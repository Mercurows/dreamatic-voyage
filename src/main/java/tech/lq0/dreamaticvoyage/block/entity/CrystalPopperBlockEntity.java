package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.gui.menu.CrystalPopperMenu;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.Random;

public class CrystalPopperBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    protected static final int SLOT_INPUT = 0;
    protected static final int[] SLOTS_RESULT = {1, 2, 3};

    private static final int[] SLOTS_FOR_SIDES = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{1, 2, 3};

    public static final int MAX_DATA_COUNT = 3;

    public static final int INPUT_PROCESS_TIME = 100;
    public static final int OUTPUT_PROCESS_TIME = 300;
    public static final int MAX_ENERGY = 100;

    protected NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);

    public int inputProgress;
    public int outputProgress;
    public int energy;

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> CrystalPopperBlockEntity.this.inputProgress;
                case 1 -> CrystalPopperBlockEntity.this.outputProgress;
                case 2 -> CrystalPopperBlockEntity.this.energy;
                default -> 0;
            };
        }

        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0:
                    CrystalPopperBlockEntity.this.inputProgress = pValue;
                    break;
                case 1:
                    CrystalPopperBlockEntity.this.outputProgress = pValue;
                    break;
                case 2:
                    CrystalPopperBlockEntity.this.energy = pValue;
                    break;
            }
        }

        public int getCount() {
            return MAX_DATA_COUNT;
        }
    };

    public CrystalPopperBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CRYSTAL_POPPER_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CrystalPopperBlockEntity popper) {
        // 每5s消耗一个金锭，能量+1
        if (popper.canInputProcess()) {
            popper.inputProgress++;

            if (popper.inputProgress >= INPUT_PROCESS_TIME) {
                popper.inputProgress = 0;
                popper.getInput().shrink(1);
                popper.energy++;
                setChanged(pLevel, pPos, pState);
                pLevel.sendBlockUpdated(pPos, pState, pState, 3);
                pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pState));
            }
        }

        // 每15s尝试生成一次产物
        if (popper.canOutputProcess()) {
            popper.outputProgress++;

            if (popper.outputProgress >= OUTPUT_PROCESS_TIME) {
                popper.outputProgress = 0;
                popper.energy--;
                popper.generateOutput();
                setChanged(pLevel, pPos, pState);
                pLevel.sendBlockUpdated(pPos, pState, pState, 3);
                pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pState));
            }
        }
    }

    private void generateOutput() {
        // 爆米花
        ItemStack resultPopCorn = this.items.get(1);
        if (resultPopCorn == ItemStack.EMPTY) {
            this.items.set(1, new ItemStack(ItemRegistry.CRYSTAL_POPCORN.get()));
        } else {
            resultPopCorn.grow(1);
        }

        Random random = new Random();

        // 结晶粉
        boolean generatePowder = 20 + 2 * this.energy > random.nextInt(100);
        if (generatePowder) {
            ItemStack resultPowder = this.items.get(2);
            if (resultPowder == ItemStack.EMPTY) {
                this.items.set(2, new ItemStack(ItemRegistry.CRYSTAL_POWDER.get()));
            } else {
                resultPowder.grow(1);
            }
        }

        // 纯净结晶粉
        boolean generatePurifiedPowder = this.energy - 90 > random.nextInt(100);
        if (generatePurifiedPowder) {
            ItemStack resultPowder = this.items.get(3);
            if (resultPowder == ItemStack.EMPTY) {
                this.items.set(3, new ItemStack(ItemRegistry.PURIFIED_CRYSTAL_POWDER.get()));
            } else {
                resultPowder.grow(1);
            }
        }
    }

    public ItemStack getInput() {
        return this.items.get(SLOT_INPUT);
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    private boolean canInputProcess() {
        return getInput().getCount() > 0 && this.energy < MAX_ENERGY;
    }

    private boolean canOutputProcess() {
        if (this.items.get(1).getCount() == 64 || this.items.get(2).getCount() == 64 || this.items.get(3).getCount() == 64) {
            return false;
        }

        return this.energy > 0;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.inputProgress = pTag.getInt("InputProgress");
        this.outputProgress = pTag.getInt("OutputProgress");
        this.energy = pTag.getInt("Energy");
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        pTag.putInt("InputProgress", this.inputProgress);
        pTag.putInt("OutputProgress", this.outputProgress);
        pTag.putInt("Energy", this.energy);
        ContainerHelper.saveAllItems(pTag, this.items);
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
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pStack, @Nullable Direction pDirection) {
        return pIndex == SLOT_INPUT && pStack.is(Tags.Items.INGOTS_GOLD);
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pDirection == Direction.DOWN && pIndex != SLOT_INPUT;
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
        return Component.translatable("container.dreamaticvoyage.crystal_popper");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CrystalPopperMenu(pContainerId, pPlayerInventory, this, this.dataAccess);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true);
        return compoundtag;
    }
}
