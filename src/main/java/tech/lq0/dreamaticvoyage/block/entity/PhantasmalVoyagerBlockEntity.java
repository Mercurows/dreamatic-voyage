package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.gui.menu.PhantasmalVoyagerMenu;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.item.misc.guardian.DreamGuardian;
import tech.lq0.dreamaticvoyage.voyage.core.Voyage;
import tech.lq0.dreamaticvoyage.voyage.core.VoyageEvent;
import tech.lq0.dreamaticvoyage.voyage.core.VoyageHelper;

import java.util.List;

// TODO 完成远航仪BlockEntity
public class PhantasmalVoyagerBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    /**
     * 远航仪的槽位，其中0~2为每一级远航仪的固定槽位，升级槽目前仅为3
     */
    protected static final int SLOT_DREAM_GUARDIAN = 0;
    protected static final int SLOT_FUEL = 1;
    protected static final int SLOT_BOOK = 2;
    protected static final int SLOT_UPGRADE = 3;
    protected static final int[] SLOTS_RESULT = new int[]{4, 5, 6, 7, 8, 9, 10, 11};

    protected NonNullList<ItemStack> items = NonNullList.withSize(32, ItemStack.EMPTY);

    protected final Voyage voyageData = new Voyage();
    public int finished;

    public static void serverTick(Level level, BlockPos pos, BlockState state, PhantasmalVoyagerBlockEntity blockEntity) {
        var data = blockEntity.voyageData;
        if (data.finished) {
            blockEntity.finished = 1;
            return;
        } else {
            blockEntity.finished = 0;
        }

        data.currentTime++;

        if (data.currentTime % (data.time / 3) == 0) {
            VoyageEvent event = VoyageHelper.generateVoyageEvent(blockEntity.voyageData);
            if (event == null) {
                return;
            }

            // TODO 完成远航事件的文本存储与显示
            System.out.println("发现事件：" + event.getDisplayName().getString());
            System.out.println(event.getDescription().getString());

            List<ItemStack> lootItems = data.generateDrop((ServerLevel) level, pos, event);
            VoyageHelper.mergeList(lootItems, blockEntity.items, 4);

            if (event.resultType == VoyageEvent.ResultType.BREAK && !blockEntity.voyageData.successConditionMatch(event)) {
                data.finished = true;
                return;
            }
        }

        if (data.currentTime >= data.time) {
            data.finished = true;
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.voyageData.deserializeNBT(pTag.getCompound("Voyage"));
        this.finished = pTag.getInt("Finished");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        ContainerHelper.saveAllItems(pTag, this.items);
        pTag.put("Voyage", this.voyageData.serializeNBT());
        pTag.putInt("Finished", this.finished);
    }

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int pIndex) {
            return finished;
        }

        public void set(int pIndex, int pValue) {
            finished = pValue;
        }

        @Override
        public int getCount() {
            return 1;
        }
    };

    public PhantasmalVoyagerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.PHANTASMAL_VOYAGER_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.DOWN) {
            return SLOTS_RESULT;
        } else {
            return new int[]{SLOT_FUEL};
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    @Override
    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        if (pIndex >= 4 && pIndex < 32) {
            return false;
        } else if (pIndex == SLOT_DREAM_GUARDIAN) {
            return pStack.getItem() instanceof DreamGuardian;
        } else if (pIndex == SLOT_FUEL) {
            return pStack.is(ItemRegistry.PHANTASM_FUEL.get());
        } else if (pIndex == SLOT_BOOK) {
            return pStack.is(Items.WRITABLE_BOOK);
        } else return pIndex == SLOT_UPGRADE;
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

    // TODO 待修改
    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        ItemStack itemstack = this.items.get(pSlot);
        boolean flag = !pStack.isEmpty() && ItemStack.isSameItemSameTags(itemstack, pStack);
        this.items.set(pSlot, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
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
        return Component.translatable("container.dreamaticvoyage.phantasmal_voyager");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new PhantasmalVoyagerMenu(pContainerId, pPlayerInventory, this, this.dataAccess);
    }
}
