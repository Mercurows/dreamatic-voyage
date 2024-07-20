package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.block.fukamizutech.FukamizuCompressor;
import tech.lq0.dreamaticvoyage.block.menu.FukamizuCompressorMenu;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public class FukamizuCompressorBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    protected static final int SLOT_INPUT = 0;
    protected static final int SLOT_RESULT = 1;

    private static final int[] SLOTS_FOR_SIDES = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{1};

    public static final int MIN_PRESSURE = 12;
    public static final int MIN_NORMAL_PRESSURE = 16;
    public static final int MAX_PRESSURE = 24;

    public static final int PROCESS_TIME = 9600;
    public static final int MAX_DAMAGE = 200;

    public static final int MAX_DATA_COUNT = 3;

    protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);

    public int pressure;
    public int compressingProgress;
    public int damage;

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> FukamizuCompressorBlockEntity.this.pressure;
                case 1 -> FukamizuCompressorBlockEntity.this.compressingProgress;
                case 2 -> FukamizuCompressorBlockEntity.this.damage;
                default -> 0;
            };
        }

        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0:
                    FukamizuCompressorBlockEntity.this.pressure = pValue;
                    break;
                case 1:
                    FukamizuCompressorBlockEntity.this.compressingProgress = pValue;
                    break;
                case 2:
                    FukamizuCompressorBlockEntity.this.damage = pValue;
                    break;
            }
        }

        public int getCount() {
            return MAX_DATA_COUNT;
        }
    };

    public FukamizuCompressorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.FUKAMIZU_COMPRESSOR_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, FukamizuCompressorBlockEntity blockEntity) {
        blockEntity.pressure = calculatePressure(pLevel, pPos);

        boolean overpressure = blockEntity.pressure > MAX_PRESSURE;
        if (overpressure) {
            if (pLevel.random.nextDouble() > .5) {
                blockEntity.damage++;
            }
        }
        pState = pState.setValue(FukamizuCompressor.OVERPRESSURE, overpressure);
        pLevel.setBlock(pPos, pState, 3);

        if (blockEntity.damage > MAX_DAMAGE) {
            pLevel.destroyBlock(pPos, false);
            Containers.dropContents(pLevel, pPos, blockEntity);
            return;
        }

        if (blockEntity.canProcess()) {
            ItemStack input = blockEntity.items.get(SLOT_INPUT);

            if (!input.is(ItemRegistry.FUKAMIZU_BREAD_INGOT.get())) {
                blockEntity.compressingProgress = 0;
                return;
            }

            blockEntity.compressingProgress++;
            if (blockEntity.pressure >= MIN_NORMAL_PRESSURE) {
                blockEntity.compressingProgress++;
            }

            if (blockEntity.compressingProgress >= PROCESS_TIME) {
                blockEntity.compressingProgress = 0;

                ItemStack result = blockEntity.items.get(SLOT_RESULT);

                if (result == ItemStack.EMPTY) {
                    blockEntity.items.set(SLOT_RESULT, new ItemStack(ItemRegistry.SWOLLEN_FUKAMIZU_BREAD_INGOT.get()));
                } else {
                    result.grow(1);
                }
                input.shrink(1);
            }
        } else {
            blockEntity.compressingProgress = 0;
        }

    }

    private static int calculatePressure(Level pLevel, BlockPos pPos) {
        int count = 0;

        while (pLevel.getBlockState(pPos.above()).is(Blocks.WATER)) {
            count++;
            pPos = pPos.above();
        }
        return count;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.pressure = pTag.getInt("Pressure");
        this.compressingProgress = pTag.getInt("CompressingProgress");
        this.damage = pTag.getInt("Damage");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        ContainerHelper.saveAllItems(pTag, this.items);
        pTag.putInt("Pressure", this.pressure);
        pTag.putInt("CompressingProgress", this.compressingProgress);
        pTag.putInt("Damage", this.damage);
    }

    private boolean canProcess() {
        return this.pressure >= MIN_PRESSURE && this.pressure <= MAX_PRESSURE;
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        if (pIndex == 1) {
            return false;
        } else return pIndex == 0 && pStack.is(ItemRegistry.FUKAMIZU_BREAD_INGOT.get());
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        if (pDirection == Direction.DOWN && pIndex == 1) {
            return pStack.is(ItemRegistry.SWOLLEN_FUKAMIZU_BREAD_INGOT.get());
        } else {
            return true;
        }
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int pSlot) {
        return this.items.get(pSlot);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return ContainerHelper.removeItem(this.items, pSlot, pAmount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return ContainerHelper.takeItem(this.items, pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        ItemStack itemstack = this.items.get(pSlot);
        boolean flag = !pStack.isEmpty() && ItemStack.isSameItemSameTags(itemstack, pStack);
        this.items.set(pSlot, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }

        if (pSlot == 0 && !flag) {
            this.compressingProgress = 0;
            this.setChanged();
        }
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return Container.stillValidBlockEntity(this, pPlayer);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.dreamaticvoyage.fukamizu_compressor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FukamizuCompressorMenu(pContainerId, pPlayerInventory, this, this.dataAccess);
    }
}
