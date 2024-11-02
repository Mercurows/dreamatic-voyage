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
import net.minecraft.world.level.Level;
import tech.lq0.dreamaticvoyage.block.entity.CrystalCutterBlockEntity;
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;
import tech.lq0.dreamaticvoyage.recipe.CrystalCuttingRecipe;

public class CrystalCutterMenu extends AbstractContainerMenu {

    private final Container container;
    private final ContainerData containerData;
    protected final Level level;

    public static final int X_OFFSET = 0;
    public static final int Y_OFFSET = 0;

    public CrystalCutterMenu(int id, Inventory inventory) {
        this(id, inventory, new SimpleContainer(4), new SimpleContainerData(CrystalCutterBlockEntity.MAX_DATA_COUNT));
    }

    public CrystalCutterMenu(int id, Inventory inventory, Container container, ContainerData containerData) {
        super(MenuTypeRegistry.CRYSTAL_CUTTER_MENU.get(), id);

        checkContainerSize(container, 4);
        checkContainerDataCount(containerData, CrystalCutterBlockEntity.MAX_DATA_COUNT);

        this.container = container;
        this.containerData = containerData;
        this.level = inventory.player.level();

        this.addSlot(new CrystalCutterMenu.InputSlot(container, 0, 40, 34));
        this.addSlot(new CrystalCutterMenu.FuelSlot(container, 1, 61, 34));
        this.addSlot(new CrystalCutterMenu.ResultSlot(container, 2, 121, 34));
        this.addSlot(new CrystalCutterMenu.ResultSlot(container, 3, 142, 34));

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

            if (pIndex == 2 || pIndex == 3) {
                if (!this.moveItemStackTo(itemstack1, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex != 1 && pIndex != 0) {
                if (this.canProcess(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (itemstack1.is(Items.ECHO_SHARD)) {
                    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 4 && pIndex < 31) {
                    if (!this.moveItemStackTo(itemstack1, 31, 40, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 31 && pIndex < 40 && !this.moveItemStackTo(itemstack1, 4, 31, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 4, 40, false)) {
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

    protected boolean canProcess(ItemStack pStack) {
        return this.level.getRecipeManager().getRecipeFor(CrystalCuttingRecipe.Type.INSTANCE, new SimpleContainer(pStack), this.level).isPresent();
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public int getEnergy() {
        return this.containerData.get(0);
    }

    public int getOutputProgress() {
        return this.containerData.get(1);
    }

    static class InputSlot extends Slot {
        public InputSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return super.mayPlace(pStack);
        }

        public int getMaxStackSize() {
            return 64;
        }
    }

    static class FuelSlot extends Slot {
        public FuelSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return pStack.is(Items.ECHO_SHARD);
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
