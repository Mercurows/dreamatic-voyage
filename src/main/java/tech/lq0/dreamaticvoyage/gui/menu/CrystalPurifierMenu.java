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
import net.minecraft.world.level.Level;
import tech.lq0.dreamaticvoyage.block.entity.CrystalPurifierBlockEntity;
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;
import tech.lq0.dreamaticvoyage.recipe.CrystalPurifyingRecipe;

import java.util.concurrent.atomic.AtomicBoolean;

public class CrystalPurifierMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData containerData;
    protected final Level level;

    public static final int X_OFFSET = 0;
    public static final int Y_OFFSET = 0;

    public CrystalPurifierMenu(int id, Inventory inventory) {
        this(id, inventory, new SimpleContainer(3), new SimpleContainerData(CrystalPurifierBlockEntity.MAX_DATA_COUNT));
    }

    public CrystalPurifierMenu(int id, Inventory inventory, Container container, ContainerData containerData) {
        super(MenuTypeRegistry.CRYSTAL_PURIFIER_MENU.get(), id);

        checkContainerSize(container, 3);
        checkContainerDataCount(containerData, CrystalPurifierBlockEntity.MAX_DATA_COUNT);

        this.container = container;
        this.containerData = containerData;
        this.level = inventory.player.level();

        this.addSlot(new CrystalPurifierMenu.InputSlot(container, 0, 40, 34));
        this.addSlot(new CrystalPurifierMenu.FuelSlot(container, 1, 61, 34));
        this.addSlot(new CrystalPurifierMenu.ResultSlot(container, 2, 121, 34));

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

            if (pIndex == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex != 1 && pIndex != 0) {
                if (this.canProcess(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 3 && pIndex < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 30 && pIndex < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
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
        return this.level.getRecipeManager().getRecipeFor(CrystalPurifyingRecipe.Type.INSTANCE, new SimpleContainer(pStack), this.level).isPresent();
    }

    protected boolean isFuel(ItemStack pStack) {
        AtomicBoolean flag = new AtomicBoolean(false);
        CrystalPurifierBlockEntity.getFuels().forEach((tagKey, integer) -> {
            if (pStack.is(tagKey)) {
                flag.set(true);
            }
        });
        return flag.get();
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public int getEnergy() {
        return this.containerData.get(0);
    }

    public int getMaxEnergy() {
        return this.containerData.get(1);
    }

    public int getOutputProgress() {
        return this.containerData.get(2);
    }

    public int getOutputTime() {
        return this.containerData.get(3);
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
            AtomicBoolean flag = new AtomicBoolean(false);
            CrystalPurifierBlockEntity.getFuels().forEach((tagKey, integer) -> {
                if (pStack.is(tagKey)) {
                    flag.set(true);
                }
            });
            return flag.get();
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
