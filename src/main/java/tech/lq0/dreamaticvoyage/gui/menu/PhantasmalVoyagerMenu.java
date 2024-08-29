package tech.lq0.dreamaticvoyage.gui.menu;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import tech.lq0.dreamaticvoyage.gui.slot.DreamGuardianSlot;
import tech.lq0.dreamaticvoyage.gui.slot.VoyagerBookSlot;
import tech.lq0.dreamaticvoyage.gui.slot.VoyagerFuelSlot;
import tech.lq0.dreamaticvoyage.gui.slot.VoyagerUpgradeSlot;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;
import tech.lq0.dreamaticvoyage.item.misc.guardian.DreamGuardian;

public class PhantasmalVoyagerMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData containerData;

    // TODO 这改的是个锤子位置
    public static final int X_OFFSET = 97;
    public static final int Y_OFFSET = 56;

    public PhantasmalVoyagerMenu(int id, Inventory inventory) {
        this(id, inventory, new SimpleContainer(32), new SimpleContainerData(1));
    }

    public PhantasmalVoyagerMenu(int id, Inventory inventory, Container container, ContainerData containerData) {
        super(MenuTypeRegistry.PHANTASMAL_VOYAGER_MENU.get(), id);

        checkContainerSize(container, 32);
        checkContainerDataCount(containerData, 1);

        this.container = container;
        this.containerData = containerData;

        this.addSlot(new DreamGuardianSlot(container, 0, 51, 43));
        this.addSlot(new VoyagerFuelSlot(container, 1, 110, 43));
        this.addSlot(new VoyagerBookSlot(container, 2, 178, 43));
        this.addSlot(new VoyagerUpgradeSlot(container, 3, 246, 43));

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 4; ++j) {
                this.addSlot(new ResultSlot(container, j + i * 4 + 4, 8 + j * 18, 84 + i * 18));
            }
        }

        this.addDataSlots(containerData);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18 + X_OFFSET, 84 + i * 18 + Y_OFFSET));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18 + X_OFFSET, 142 + Y_OFFSET));
        }
    }

    // TODO 待添加升级槽位的快速填充
    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemStack = stack.copy();
            if (pIndex >= 0 && pIndex <= 31) {
                if (!this.moveItemStackTo(stack, 32, 68, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (stack.getItem() instanceof DreamGuardian) {
                    if (!this.moveItemStackTo(stack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (stack.is(Items.WRITABLE_BOOK)) {
                    if (!this.moveItemStackTo(stack, 2, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (stack.is(ItemRegistry.PHANTASM_FUEL.get())) {
                    if (!this.moveItemStackTo(stack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 59 && pIndex < 68 && !this.moveItemStackTo(stack, 32, 59, false)) {
                    return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(stack, 59, 68, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, stack);
        }

        return itemStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public class ResultSlot extends Slot {

        public ResultSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        @Override
        public boolean mayPlace(ItemStack pStack) {
            return false;
        }

        @Override
        public int getMaxStackSize() {
            return 64;
        }

        @Override
        public boolean mayPickup(Player pPlayer) {
            return containerData.get(0) == 1;
        }
    }
}
