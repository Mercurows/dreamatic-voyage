package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;

public class CrystalPopperBlockEntity extends BlockEntity {

    public ItemStackHandler inputInv;
    public ItemStackHandler outputInv;
    public LazyOptional<IItemHandler> capability;

    public int progress;

    public CrystalPopperBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CRYSTAL_POPPER_BLOCK_ENTITY.get(), pPos, pBlockState);

        inputInv = new ItemStackHandler(1);
        outputInv = new ItemStackHandler(2);
        capability = LazyOptional.of(CrystalPopperBlockEntity.InventoryHandler::new);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CrystalPopperBlockEntity blockEntity) {

    }

    public boolean tryInsertGold(ItemStack itemStack) {
        if (!itemStack.is(Items.GOLD_INGOT)) {
            return false;
        }

        var inputItem = this.inputInv.getStackInSlot(0);
        if (inputItem.getCount() == 64) return false;

        var countToInsert = 64 - inputItem.getCount();
        var itemToInsert = itemStack.split(countToInsert);
        itemToInsert.setCount(itemToInsert.getCount() + inputItem.getCount());

        this.inputInv.setStackInSlot(0, itemToInsert);

        return true;
    }

    public ItemStack getInput() {
        return inputInv.getStackInSlot(0);
    }

    public NonNullList<ItemStack> getOutput() {
        return NonNullList.of(outputInv.getStackInSlot(0), outputInv.getStackInSlot(1));
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.progress = pTag.getInt("Progress");
        this.inputInv.deserializeNBT(pTag.getCompound("Input"));
        this.outputInv.deserializeNBT(pTag.getCompound("Output"));
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        pTag.putInt("Progress", this.progress);
        pTag.put("Input", inputInv.serializeNBT());
        pTag.put("Output", outputInv.serializeNBT());
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER)
            return capability.cast();
        return super.getCapability(cap, side);
    }

    private class InventoryHandler extends CombinedInvWrapper {
        public InventoryHandler() {
            super(inputInv, outputInv);
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if (outputInv == getHandlerFromIndex(getIndexForSlot(slot))) {
                return false;
            }

            return stack.is(Tags.Items.INGOTS_GOLD) && super.isItemValid(slot, stack);
        }

        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (outputInv == getHandlerFromIndex(getIndexForSlot(slot))) {
                return stack;
            }
            if (!isItemValid(slot, stack)) {
                return stack;
            }
            return super.insertItem(slot, stack, simulate);
        }

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            if (inputInv == getHandlerFromIndex(getIndexForSlot(slot))) {
                return ItemStack.EMPTY;
            }
            return super.extractItem(slot, amount, simulate);
        }

    }
}
