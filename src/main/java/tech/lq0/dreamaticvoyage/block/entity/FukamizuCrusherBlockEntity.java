package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public class FukamizuCrusherBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    protected static final int SLOT_ENERGY = 0;
    protected static final int SLOT_INPUT = 1;
    protected static final int SLOT_RESULT = 2;

    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2};

    public static final int PROCESS_TIME = 1200;

    public static final int MAX_DATA_COUNT = 2;

    protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);

    public int energy;
    public int crushingProgress;

    // from Create
    public ItemStackHandler inputInv;
    public ItemStackHandler outputInv;
    public LazyOptional<IItemHandler> capability;

    public FukamizuCrusherBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.FUKAMIZU_CRUSHER_BLOCK_ENTITY.get(), pPos, pBlockState);

        inputInv = new ItemStackHandler(1);
        outputInv = new ItemStackHandler(1);
        capability = LazyOptional.of(FukamizuCrusherInventoryHandler::new);
    }

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> FukamizuCrusherBlockEntity.this.energy;
                case 1 -> FukamizuCrusherBlockEntity.this.crushingProgress;
                default -> 0;
            };
        }

        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0:
                    FukamizuCrusherBlockEntity.this.energy = pValue;
                    break;
                case 1:
                    FukamizuCrusherBlockEntity.this.crushingProgress = pValue;
                    break;
            }
        }

        public int getCount() {
            return MAX_DATA_COUNT;
        }
    };


    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, FukamizuCrusherBlockEntity blockEntity) {

    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.energy = pTag.getInt("UmisuEnergy");
        this.crushingProgress = pTag.getInt("CrushingProgress");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        ContainerHelper.saveAllItems(pTag, this.items);
        pTag.putInt("UmisuEnergy", this.energy);
        pTag.putInt("CrushingProgress", this.crushingProgress);
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.UP) {
            return SLOTS_FOR_UP;
        } else if (pSide == Direction.DOWN) {
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
        if (pIndex == 0) {
            return pStack.is(ItemRegistry.SWOLLEN_FUKAMIZU_BREAD_INGOT.get());
        } else return pIndex != 2;
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pDirection == Direction.DOWN && pIndex == 2;
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

    // TODO 修复NBT存储问题
    @Override
    public CompoundTag serializeNBT() {
        var tag = super.serializeNBT();
        tag.put("input", inputInv.serializeNBT());
        tag.put("output", outputInv.serializeNBT());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        inputInv.deserializeNBT(nbt.getCompound("input"));
        outputInv.deserializeNBT(nbt.getCompound("output"));
        super.deserializeNBT(nbt);
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
        return Component.translatable("container.dreamaticvoyage.fukamizu_crusher");
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER)
            return capability.cast();
        return super.getCapability(cap, side);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }


    private class FukamizuCrusherInventoryHandler extends CombinedInvWrapper {

        public FukamizuCrusherInventoryHandler() {
            super(inputInv, outputInv);
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if (outputInv == getHandlerFromIndex(getIndexForSlot(slot)))
                return false;
            // TODO 修改为正确的有效物品判断
            return stack.getItem() == ItemRegistry.FUKAMIZU_BREAD.get() && super.isItemValid(slot, stack);
        }

        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (outputInv == getHandlerFromIndex(getIndexForSlot(slot)))
                return stack;
            if (!isItemValid(slot, stack))
                return stack;
            return super.insertItem(slot, stack, simulate);
        }

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            if (inputInv == getHandlerFromIndex(getIndexForSlot(slot)))
                return ItemStack.EMPTY;
            return super.extractItem(slot, amount, simulate);
        }

    }
}
