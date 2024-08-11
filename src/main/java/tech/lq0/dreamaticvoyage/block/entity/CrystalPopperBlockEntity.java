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
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.Random;

public class CrystalPopperBlockEntity extends BlockEntity {

    public ItemStackHandler inputInv;
    public ItemStackHandler outputInv;
    public LazyOptional<IItemHandler> capability;

    public int progress;
    public int energy;

    public CrystalPopperBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CRYSTAL_POPPER_BLOCK_ENTITY.get(), pPos, pBlockState);

        inputInv = new ItemStackHandler(1);
        outputInv = new ItemStackHandler(3);
        capability = LazyOptional.of(CrystalPopperBlockEntity.InventoryHandler::new);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CrystalPopperBlockEntity popper) {
        if (!popper.canProcess()) {
            return;
        }

        popper.progress += 1;

        // 每5s消耗一个金锭，能量+1
        if (popper.progress % 100 == 0) {
            popper.inputInv.getStackInSlot(0).shrink(1);
            popper.energy = Math.min(popper.energy + 1, 100);
        }

        // 每15s尝试生成一次产物
        if (popper.progress >= 300) {
            popper.progress = 0;
            popper.generateOutput();
        }
    }

    private void generateOutput() {
        // 爆米花
        if (!outputInv.getStackInSlot(0).is(ItemRegistry.CRYSTAL_POPCORN.get())) {
            outputInv.setStackInSlot(0, new ItemStack(ItemRegistry.CRYSTAL_POPCORN.get()));
        } else {
            outputInv.getStackInSlot(0).grow(1);
        }

        Random random = new Random();

        // 结晶粉
        boolean generatePowder = 20 + 2 * this.energy > random.nextInt(100);
        if (generatePowder) {
            if (!outputInv.getStackInSlot(1).is(ItemRegistry.CRYSTAL_POWDER.get())) {
                outputInv.setStackInSlot(1, new ItemStack(ItemRegistry.CRYSTAL_POWDER.get()));
            } else {
                outputInv.getStackInSlot(1).grow(1);
            }
        }

        // 纯净结晶粉
        boolean generatePurifiedPowder = this.energy - 90 > random.nextInt(100);
        if (generatePurifiedPowder) {
            if (!outputInv.getStackInSlot(2).is(ItemRegistry.PURIFIED_CRYSTAL_POWDER.get())) {
                outputInv.setStackInSlot(2, new ItemStack(ItemRegistry.PURIFIED_CRYSTAL_POWDER.get()));
            } else {
                outputInv.getStackInSlot(2).grow(1);
            }
        }
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

    private boolean canProcess() {
        if (inputInv.getStackInSlot(0).getCount() > 0) {
            return true;
        }
        if (outputInv.getStackInSlot(0).getCount() == 64
                || outputInv.getStackInSlot(1).getCount() == 64
                || outputInv.getStackInSlot(2).getCount() == 64
        ) {
            return false;
        }

        return this.energy > 0;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.progress = pTag.getInt("Progress");
        this.energy = pTag.getInt("Energy");
        this.inputInv.deserializeNBT(pTag.getCompound("Input"));
        this.outputInv.deserializeNBT(pTag.getCompound("Output"));
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        pTag.putInt("Progress", this.progress);
        pTag.putInt("Energy", this.energy);
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
