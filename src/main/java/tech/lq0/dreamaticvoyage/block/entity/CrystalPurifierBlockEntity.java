package tech.lq0.dreamaticvoyage.block.entity;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.tags.TagKey;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.gui.menu.CrystalPurifierMenu;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.recipe.CrystalPurifyingRecipe;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

// TODO 实现菜单和渲染
public class CrystalPurifierBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    protected static final int SLOT_INPUT = 0;
    protected static final int SLOT_FUEL = 1;
    protected static final int SLOT_RESULT = 2;

    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2};

    public static final int MAX_DATA_COUNT = 4;
    public static final int FUEL_TICK = 300;

    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);

    public int energy;
    public int maxEnergy = 300;
    public int outputProgress;
    public int outputTime = 300;

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> CrystalPurifierBlockEntity.this.energy;
                case 1 -> CrystalPurifierBlockEntity.this.maxEnergy;
                case 2 -> CrystalPurifierBlockEntity.this.outputProgress;
                case 3 -> CrystalPurifierBlockEntity.this.outputTime;
                default -> 0;
            };
        }

        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0:
                    CrystalPurifierBlockEntity.this.energy = pValue;
                    break;
                case 1:
                    CrystalPurifierBlockEntity.this.maxEnergy = pValue;
                    break;
                case 2:
                    CrystalPurifierBlockEntity.this.outputProgress = pValue;
                    break;
                case 3:
                    CrystalPurifierBlockEntity.this.outputTime = pValue;
                    break;
            }
        }

        public int getCount() {
            return MAX_DATA_COUNT;
        }
    };

    public CrystalPurifierBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CRYSTAL_PURIFIER_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public static Map<TagKey<Item>, Integer> getFuels() {
        Map<TagKey<Item>, Integer> map = Maps.newLinkedHashMap();
        map.put(Tags.Items.GEMS_EMERALD, FUEL_TICK);
        map.put(Tags.Items.STORAGE_BLOCKS_EMERALD, FUEL_TICK * 10);
        map.put(Tags.Items.INGOTS_GOLD, FUEL_TICK / 5);
        map.put(Tags.Items.STORAGE_BLOCKS_GOLD, FUEL_TICK * 2);

        return map;
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CrystalPurifierBlockEntity blockEntity) {
        if (blockEntity.hasRecipe()) {
            var recipe = blockEntity.getCurrentRecipe();
            if (recipe.isEmpty()) return;

            ItemStack fuel = blockEntity.items.get(SLOT_FUEL);
            if (blockEntity.energy <= 0) {
                if (fuel.isEmpty()) {
                    if (blockEntity.outputProgress <= 0) return;
                    blockEntity.outputProgress--;
                } else {
                    getFuels().forEach((k, v) -> {
                        if (fuel.is(k)) {
                            blockEntity.energy += v;
                            blockEntity.maxEnergy = v;
                            fuel.shrink(1);
                        }
                    });

                    blockEntity.setChanged();
                    pLevel.sendBlockUpdated(pPos, pState, pState, 3);
                    pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pState));
                }
            }

            int time = recipe.get().getTick();

            blockEntity.outputProgress++;
            blockEntity.energy--;
            blockEntity.outputTime = time;

            if (blockEntity.outputProgress >= time) {
                blockEntity.craftItem();
                blockEntity.outputProgress = 0;
                blockEntity.setChanged();
                pLevel.sendBlockUpdated(pPos, pState, pState, 3);
                pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pState));
            }
        } else {
            if (blockEntity.energy > 0) {
                blockEntity.energy--;
            }
            blockEntity.resetProgress();
        }
    }

    private void craftItem() {
        Optional<CrystalPurifyingRecipe> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return;
        }

        ItemStack result = recipe.get().getResultItem(null);

        ItemStack input = this.items.get(SLOT_INPUT);
        input.shrink(1);

        ItemStack output = this.items.get(SLOT_RESULT);
        this.items.set(SLOT_RESULT, new ItemStack(result.getItem(), output.getCount() + result.getCount()));
    }

    private Optional<CrystalPurifyingRecipe> getCurrentRecipe() {
        if (this.level == null) {
            return Optional.empty();
        }

        SimpleContainer inventory = new SimpleContainer(this.items.size());
        for (int i = 0; i < this.items.size(); i++) {
            inventory.setItem(i, this.items.get(i));
        }

        return this.level.getRecipeManager().getRecipeFor(CrystalPurifyingRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean hasRecipe() {
        Optional<CrystalPurifyingRecipe> recipe = getCurrentRecipe();

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
        this.outputProgress = 0;
    }

    public ItemStack getInput() {
        return this.items.get(SLOT_INPUT);
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.energy = pTag.getInt("Energy");
        this.maxEnergy = pTag.getInt("MaxEnergy");
        this.outputProgress = pTag.getInt("OutputProgress");
        this.outputTime = pTag.getInt("OutputTime");
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        pTag.putInt("Energy", this.energy);
        pTag.putInt("MaxEnergy", this.maxEnergy);
        pTag.putInt("OutputProgress", this.outputProgress);
        pTag.putInt("OutputTime", this.outputTime);
        ContainerHelper.saveAllItems(pTag, this.items);
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
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pStack, @Nullable Direction pDirection) {
        if (pDirection == Direction.UP) {
            return true;
        } else if (pDirection == Direction.DOWN) {
            return false;
        } else {
            if (pIndex == SLOT_FUEL) {
                AtomicBoolean hasFuel = new AtomicBoolean(false);
                getFuels().forEach((k, v) -> {
                    if (pStack.is(k)) {
                        hasFuel.set(true);
                    }
                });
                return hasFuel.get();
            }

            return false;
        }
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pDirection == Direction.DOWN && pIndex == SLOT_RESULT;
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
        return Component.translatable("container.dreamaticvoyage.crystal_purifier");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CrystalPurifierMenu(pContainerId, pPlayerInventory, this, this.dataAccess);
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
