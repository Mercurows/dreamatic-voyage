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
import net.minecraftforge.common.Tags;
import tech.lq0.dreamaticvoyage.block.entity.CrystalPopperBlockEntity;
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;

public class CrystalPopperMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData containerData;

    public static final int X_OFFSET = 0;
    public static final int Y_OFFSET = 0;

    public CrystalPopperMenu(int id, Inventory inventory) {
        this(id, inventory, new SimpleContainer(4), new SimpleContainerData(CrystalPopperBlockEntity.MAX_DATA_COUNT));
    }

    public CrystalPopperMenu(int id, Inventory inventory, Container container, ContainerData containerData) {
        super(MenuTypeRegistry.CRYSTAL_POPPER_MENU.get(), id);

        checkContainerSize(container, 4);
        checkContainerDataCount(containerData, CrystalPopperBlockEntity.MAX_DATA_COUNT);

        this.container = container;
        this.containerData = containerData;

        this.addSlot(new CrystalPopperMenu.InputSlot(container, 0, 44, 26));
        this.addSlot(new CrystalPopperMenu.ResultSlot(container, 1, 116, 59));
        this.addSlot(new CrystalPopperMenu.ResultSlot(container, 2, 116, 39));
        this.addSlot(new CrystalPopperMenu.ResultSlot(container, 3, 116, 19));

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

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex == 0) {
                if (!this.moveItemStackTo(itemstack1, 4, 40, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (pIndex <= 3) {
                if (!this.moveItemStackTo(itemstack1, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else {
                if (itemstack1.is(Tags.Items.INGOTS_GOLD)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex < 31) {
                    if (!this.moveItemStackTo(itemstack1, 31, 40, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex < 40 && !this.moveItemStackTo(itemstack1, 4, 31, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public int getInputProgress() {
        return this.containerData.get(0);
    }

    public int getOutputProgress() {
        return this.containerData.get(1);
    }

    public int getEnergy() {
        return this.containerData.get(2);
    }

    static class InputSlot extends Slot {
        public InputSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return pStack.is(Tags.Items.INGOTS_GOLD);
        }

        public int getMaxStackSize() {
            return 64;
        }
    }

    static class ResultSlot extends Slot {
        public ResultSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return false;
        }

        public int getMaxStackSize() {
            return 64;
        }
    }
}
