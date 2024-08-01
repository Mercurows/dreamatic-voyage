package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
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

public class FukamizuCrusherBlockEntity extends BlockEntity {
    public static final int PROCESS_TIME = 1200;

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

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, FukamizuCrusherBlockEntity blockEntity) {

    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.energy = pTag.getInt("UmisuEnergy");
        this.crushingProgress = pTag.getInt("CrushingProgress");
        this.inputInv.deserializeNBT(pTag.getCompound("Input"));
        this.outputInv.deserializeNBT(pTag.getCompound("Output"));
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        pTag.putInt("UmisuEnergy", this.energy);
        pTag.putInt("CrushingProgress", this.crushingProgress);
        pTag.put("Input", inputInv.serializeNBT());
        pTag.put("Output", outputInv.serializeNBT());
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER)
            return capability.cast();
        return super.getCapability(cap, side);
    }

    private class FukamizuCrusherInventoryHandler extends CombinedInvWrapper {
        public FukamizuCrusherInventoryHandler() {
            super(inputInv, outputInv);
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if (outputInv == getHandlerFromIndex(getIndexForSlot(slot))) {
                return false;
            }
            // TODO 修改为正确的有效物品判断
            return stack.getItem() == ItemRegistry.FUKAMIZU_BREAD.get() && super.isItemValid(slot, stack);
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
