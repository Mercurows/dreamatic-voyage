package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.block.machine.fukamizutech.FukamizuCrusher;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.uce.UCEnergyStorage;
import tech.lq0.dreamaticvoyage.gui.menu.FukamizuCrusherMenu;
import tech.lq0.dreamaticvoyage.gui.slot.ContainerEnergyData;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.recipe.FukamizuCrushingRecipe;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class FukamizuCrusherBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {

    protected static final int SLOT_INPUT = 0;

    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_OTHER = new int[]{1, 2, 3, 4};

    public static final int PROCESS_TIME = 100;
    public static final int MAX_DATA_COUNT = 2;
    public static final int MAX_ENERGY = 64000;
    public static final int DEFAULT_ENERGY_COST = 20;

    protected NonNullList<ItemStack> items = NonNullList.withSize(5, ItemStack.EMPTY);

    private LazyOptional<UCEnergyStorage> energyHandler;
    private LazyOptional<?>[] itemHandlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    public int crushingProgress;

    protected final ContainerEnergyData dataAccess = new ContainerEnergyData() {
        public long get(int pIndex) {
            return switch (pIndex) {
                case 0 -> {
                    AtomicInteger energy = new AtomicInteger();
                    FukamizuCrusherBlockEntity.this.getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(consumer -> energy.set(consumer.getEnergyStored()));
                    yield energy.get();
                }
                case 1 -> FukamizuCrusherBlockEntity.this.crushingProgress;
                default -> 0;
            };
        }

        public void set(int pIndex, long pValue) {
            switch (pIndex) {
                case 0:
                    FukamizuCrusherBlockEntity.this.getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(consumer -> consumer.receiveEnergy((int) pValue, false));
                    break;
                case 1:
                    FukamizuCrusherBlockEntity.this.crushingProgress = (int) pValue;
                    break;
            }
        }

        public int getCount() {
            return MAX_DATA_COUNT;
        }
    };

    public FukamizuCrusherBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.FUKAMIZU_CRUSHER_BLOCK_ENTITY.get(), pPos, pBlockState);

        this.energyHandler = LazyOptional.of(() -> new UCEnergyStorage(MAX_ENERGY));
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, FukamizuCrusherBlockEntity blockEntity) {
        boolean flag = false;
        AtomicInteger energy = new AtomicInteger(0);
        blockEntity.getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(handler -> energy.set(handler.getEnergyStored()));
        if (energy.get() < DEFAULT_ENERGY_COST) {
            if (pState.getValue(FukamizuCrusher.PROCESSING)) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(FukamizuCrusher.PROCESSING, false));
                setChanged(pLevel, pPos, pState);
            }
            return;
        }

        if (blockEntity.canProcess()) {
            blockEntity.crushingProgress++;
            blockEntity.energyHandler.ifPresent(consumer -> consumer.extractEnergy(DEFAULT_ENERGY_COST, false));

            if (blockEntity.crushingProgress >= PROCESS_TIME) {
                blockEntity.craftItem();
                blockEntity.resetProgress();
                blockEntity.setChanged();
            }
        } else if (blockEntity.crushingProgress > 0) {
            blockEntity.resetProgress();
            blockEntity.setChanged();
        }

        if (pState.getValue(FukamizuCrusher.PROCESSING) != blockEntity.crushingProgress > 0 && !blockEntity.canProcess()) {
            flag = true;
            pLevel.setBlockAndUpdate(pPos, pState.setValue(FukamizuCrusher.PROCESSING, blockEntity.crushingProgress > 0));
        }

        if (flag) {
            setChanged(pLevel, pPos, pState);
        }
    }

    private void craftItem() {
        Optional<FukamizuCrushingRecipe> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return;
        }

        ItemStack input = this.items.get(SLOT_INPUT);
        input.shrink(1);

        var results = recipe.get().rollResults();

        // TODO 弹射多余的物品
        for (ItemStack result : results) {
            for (int i = 1; i < 5; i++) {
                if (this.items.get(i).isEmpty()) {
                    this.items.set(i, result);
                    break;
                } else if (this.items.get(i).is(result.getItem()) && this.items.get(i).getCount() + result.getCount() <= this.items.get(i).getMaxStackSize()) {
                    this.items.set(i, new ItemStack(result.getItem(), this.items.get(i).getCount() + result.getCount()));
                    break;
                }
            }
        }
    }

    private Optional<FukamizuCrushingRecipe> getCurrentRecipe() {
        if (this.level == null) {
            return Optional.empty();
        }

        SimpleContainer inventory = new SimpleContainer(this.items.size());
        inventory.setItem(0, this.items.get(SLOT_INPUT));

        return this.level.getRecipeManager().getRecipeFor(FukamizuCrushingRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canProcess() {
        Optional<FukamizuCrushingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        if (getLevel() == null) {
            return false;
        }

        var results = recipe.get().getRollableResultsAsItemStacks();
        if (results.stream().map(ItemStack::getDescriptionId).distinct().count() > 4) return false;

        return results.stream().anyMatch(result -> {
            for (int i = 1; i < 5; i++) {
                var item = this.items.get(i);
                if (item.isEmpty() || item.is(result.getItem()) && item.getCount() + result.getCount() <= item.getMaxStackSize()) {
                    return true;
                }
            }
            return false;
        });
    }

    private boolean canInsertItemIntoOutputSlot(Item item, int slot) {
        return this.items.get(slot).isEmpty() || this.items.get(slot).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count, int slot) {
        return this.items.get(slot).getCount() + count <= this.items.get(slot).getMaxStackSize();
    }

    private void resetProgress() {
        this.crushingProgress = 0;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);

        if (pTag.contains("UmisuEnergy")) {
            getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(handler -> {
                ((UCEnergyStorage) handler).deserializeNBT(pTag.get("UmisuEnergy"));
            });
        }

        this.crushingProgress = pTag.getInt("CrushingProgress");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        ContainerHelper.saveAllItems(pTag, this.items);

        getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(handler -> pTag.put("UmisuEnergy", ((UCEnergyStorage) handler).serializeNBT()));
        pTag.putInt("CrushingProgress", this.crushingProgress);
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.UP) {
            return SLOTS_FOR_UP;
        } else {
            return SLOTS_FOR_OTHER;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack) && pDirection == Direction.UP;
    }

    @Override
    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        return pIndex == 0;
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pIndex >= 1 && pDirection != Direction.UP;
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
        return Component.translatable("container.dreamaticvoyage.fukamizu_crusher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FukamizuCrusherMenu(pContainerId, pPlayerInventory, this, this.dataAccess);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putInt("CrushingProgress", this.crushingProgress);
        return compoundtag;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY) {
            return energyHandler.cast();
        }
        if (!this.remove && side != null && cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == Direction.UP) {
                return itemHandlers[0].cast();
            } else if (side == Direction.DOWN) {
                return itemHandlers[1].cast();
            } else {
                return itemHandlers[2].cast();
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        for (LazyOptional<?> itemHandler : itemHandlers) itemHandler.invalidate();
        this.energyHandler.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.itemHandlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
        this.energyHandler = LazyOptional.of(() -> new UCEnergyStorage(MAX_ENERGY));
    }
}
