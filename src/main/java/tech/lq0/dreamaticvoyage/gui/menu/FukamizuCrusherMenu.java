package tech.lq0.dreamaticvoyage.gui.menu;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import tech.lq0.dreamaticvoyage.block.entity.FukamizuCrusherBlockEntity;
import tech.lq0.dreamaticvoyage.gui.slot.ContainerEnergyData;
import tech.lq0.dreamaticvoyage.gui.slot.SimpleEnergyData;
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;

public class FukamizuCrusherMenu extends BaseEnergyMenu {

    private final Container container;
    private final ContainerEnergyData containerData;
    protected final Level level;

    public static final int X_OFFSET = 0;
    public static final int Y_OFFSET = 11;

    public FukamizuCrusherMenu(int pContainerId, Inventory inventory) {
        this(pContainerId, inventory, new SimpleContainer(5), new SimpleEnergyData(FukamizuCrusherBlockEntity.MAX_DATA_COUNT));
    }

    public FukamizuCrusherMenu(int id, Inventory inventory, Container container, ContainerEnergyData containerData) {
        super(MenuTypeRegistry.FUKAMIZU_CRUSHER_MENU.get(), id, containerData);

        checkContainerSize(container, 5);

        this.container = container;
        this.containerData = containerData;
        this.level = inventory.player.level();

        this.addSlot(new Slot(container, 0, 53, 34));
        this.addSlot(new ResultSlot(container, 1, 104, 34));
        this.addSlot(new ResultSlot(container, 2, 122, 34));
        this.addSlot(new ResultSlot(container, 3, 104, 52));
        this.addSlot(new ResultSlot(container, 4, 122, 52));

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
            if (pIndex >= 1 && pIndex < 5) {
                if (!this.moveItemStackTo(itemstack1, 6, 42, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex != 0) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                } else if (pIndex >= 6 && pIndex < 33) {
                    if (!this.moveItemStackTo(itemstack1, 33, 42, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 33 && pIndex < 42 && !this.moveItemStackTo(itemstack1, 6, 33, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 6, 42, false)) {
                return ItemStack.EMPTY;
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

    public long getEnergy() {
        return this.containerData.get(0);
    }

    static class ResultSlot extends Slot {

        public ResultSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        @Override
        public boolean mayPlace(ItemStack pStack) {
            return false;
        }
    }
}