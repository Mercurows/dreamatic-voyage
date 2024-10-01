package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.Arrays;

public abstract class PylonBlockEntity extends BlockEntity implements WorldlyContainer {

    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    protected NonNullList<byte[]> connections = NonNullList.create();

    public PylonBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    abstract public int getPylonLevel();

    abstract public boolean canBind(byte[] offset);

    abstract public boolean canBindMore();

    public boolean hasConnection(byte[] offset) {
        return this.connections.stream().anyMatch(c -> Arrays.equals(c, offset));
    }

    public void addConnection(byte[] offset) {
        if (this.hasConnection(offset)) {
            return;
        }
        this.connections.add(offset);
    }

    public void removeConnection(byte[] offset) {
        this.connections.removeIf(c -> Arrays.equals(c, offset));
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        return new int[]{0};
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return pDirection != Direction.DOWN && pItemStack.is(ItemRegistry.SWOLLEN_FUKAMIZU_BREAD_INGOT.get());
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return false;
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
}
