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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.uce.IUCEnergyStorage;
import tech.lq0.dreamaticvoyage.capability.uce.UCEnergyStorage;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

// TODO 完成能量塔逻辑
public class FukamizuPylonBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {

    public static final int MAX_RANGE = 10;
    public static final int MAX_CAPACITY = 100000;
    public static final int CHARGE_SPEED = 50;
    public static final int TRANSFER_COOLDOWN = 40;
    public static final int MAX_TRANSFER_TOTAL = 2000;
    public static final int MAX_TRANSFER_SINGLE = 200;

    public LazyOptional<IUCEnergyStorage> capability;
    public UCEnergyStorage energyStorage = new UCEnergyStorage(MAX_CAPACITY, MAX_TRANSFER_TOTAL);

    public int chargeTime;

    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public FukamizuPylonBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.FUKAMIZU_PYLON_BLOCK_ENTITY.get(), pPos, pBlockState);
        capability = LazyOptional.of(() -> energyStorage);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, FukamizuPylonBlockEntity blockEntity) {
        blockEntity.charge(pLevel, pPos, pState);
    }

    private void charge(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!this.energyStorage.canReceive()) {
            return;
        }

        if (this.chargeTime <= 0) {
            ItemStack stack = this.items.get(0);
            if (stack.isEmpty()) {
                return;
            }

            if (!stack.is(ItemRegistry.SWOLLEN_FUKAMIZU_BREAD_INGOT.get())) {
                return;
            }

            stack.shrink(1);
            this.chargeTime += 40;

            this.setChanged();
            pLevel.sendBlockUpdated(pPos, pState, pState, 3);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pState));
        } else {
            this.energyStorage.receiveEnergy(CHARGE_SPEED, false);
            this.chargeTime--;
        }
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

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.dreamaticvoyage.fukamizu_pylon");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.energyStorage.read(pTag);
        this.chargeTime = pTag.getInt("ChargeTime");
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        this.energyStorage.write(pTag);
        pTag.putInt("ChargeTime", this.chargeTime);
        ContainerHelper.saveAllItems(pTag, this.items);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY) {
            return this.capability.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.capability.invalidate();
    }
}
