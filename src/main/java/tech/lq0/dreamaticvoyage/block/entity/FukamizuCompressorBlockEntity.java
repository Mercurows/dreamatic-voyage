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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.block.fukamizu.tech.FukamizuCompressor;
import tech.lq0.dreamaticvoyage.gui.menu.FukamizuCompressorMenu;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.recipe.FukamizuCompressingRecipe;

import java.util.Optional;

public class FukamizuCompressorBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    protected static final int SLOT_INPUT = 0;
    protected static final int SLOT_RESULT = 1;

    private static final int[] SLOTS_FOR_SIDES = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{1};

    public static final int MIN_PRESSURE = 12;
    public static final int MIN_NORMAL_PRESSURE = 16;
    public static final int MAX_PRESSURE = 24;

    public static final int PROCESS_TIME = 1200;
    public static final int MAX_DAMAGE = 200;

    public static final int MAX_DATA_COUNT = 3;

    protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);

    private LazyOptional<?>[] itemHandlers = SidedInvWrapper.create(this, Direction.NORTH, Direction.DOWN);

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
            return;
        }

        if (blockEntity.canProcess() && blockEntity.hasRecipe()) {
            blockEntity.compressingProgress++;
            if (blockEntity.pressure >= MIN_NORMAL_PRESSURE) {
                blockEntity.compressingProgress++;
            }

            if (overpressure) {
                blockEntity.compressingProgress += 2;
            }

            if (blockEntity.compressingProgress >= PROCESS_TIME) {
                blockEntity.resetProgress();
                blockEntity.craftItem();
            }
        } else {
            blockEntity.resetProgress();
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

    private void craftItem() {
        Optional<FukamizuCompressingRecipe> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return;
        }

        ItemStack result = recipe.get().getResultItem(null);

        ItemStack input = this.items.get(SLOT_INPUT);
        input.shrink(1);

        ItemStack output = this.items.get(SLOT_RESULT);
        this.items.set(SLOT_RESULT, new ItemStack(result.getItem(), output.getCount() + result.getCount()));
    }

    private Optional<FukamizuCompressingRecipe> getCurrentRecipe() {
        if (this.level == null) {
            return Optional.empty();
        }

        SimpleContainer inventory = new SimpleContainer(this.items.size());
        for (int i = 0; i < this.items.size(); i++) {
            inventory.setItem(i, this.items.get(i));
        }

        return this.level.getRecipeManager().getRecipeFor(FukamizuCompressingRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean hasRecipe() {
        Optional<FukamizuCompressingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        if (getLevel() == null) {
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.items.get(SLOT_RESULT).isEmpty() || this.items.get(SLOT_RESULT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.items.get(SLOT_RESULT).getCount() + count <= this.items.get(SLOT_RESULT).getMaxStackSize();
    }

    private void resetProgress() {
        this.compressingProgress = 0;
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
        return this.pressure >= MIN_PRESSURE;
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

    @Override
    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        if (pIndex == 1) {
            return false;
        } else return pIndex == 0;
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pIndex == 1 && pDirection == Direction.DOWN;
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
            this.resetProgress();
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

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (!this.remove && side != null && cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == Direction.DOWN) {
                return itemHandlers[1].cast();
            } else {
                return itemHandlers[0].cast();
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        for (LazyOptional<?> itemHandler : itemHandlers) itemHandler.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.itemHandlers = SidedInvWrapper.create(this, Direction.NORTH, Direction.DOWN);
    }
}
