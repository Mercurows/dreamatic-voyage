package tech.lq0.dreamaticvoyage.gui.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
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
import tech.lq0.dreamaticvoyage.gui.slot.*;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;
import tech.lq0.dreamaticvoyage.item.misc.guardian.DreamGuardian;

import java.util.ArrayList;
import java.util.List;

public class PhantasmalVoyagerMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData containerData;

    private final List<Component> components = new ArrayList<>();

    public static final int X_OFFSET = 100;
    public static final int Y_OFFSET = 41;

    public PhantasmalVoyagerMenu(int id, Inventory inventory, FriendlyByteBuf data) {
        this(id, inventory, new SimpleContainer(32), new SimpleContainerData(3), data);
    }

    public PhantasmalVoyagerMenu(int id, Inventory inventory, Container container, ContainerData containerData, FriendlyByteBuf data) {
        super(MenuTypeRegistry.PHANTASMAL_VOYAGER_MENU.get(), id);

        int count = data.readInt();

        for (int i = 0; i < count; ++i) {
            this.components.add(data.readComponent());
        }

        checkContainerSize(container, 32);
        checkContainerDataCount(containerData, 3);

        this.container = container;
        this.containerData = containerData;

        this.addSlot(new DreamGuardianSlot(container, 0, 170, 87, this.containerData.get(0) == 0));
        this.addSlot(new VoyagerFuelSlot(container, 1, 189, 87));
        this.addSlot(new VoyagerBookSlot(container, 2, 75, 183, this.containerData.get(0) == 0));
        this.addSlot(new VoyagerUpgradeSlot(container, 3, 285, 183, this.containerData.get(0) == 0));

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 4; ++j) {
                this.addSlot(new VoyageResultSlot(container, j + i * 4 + 4, 285 + j * 18, 53 + i * 18, this.containerData.get(0) == 0));
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

    public ItemStack getDreamGuardian() {
        return this.container.getItem(0);
    }

    public void setVoyageState(int state) {
        this.containerData.set(0, state);
    }

    public int getVoyageState() {
        return this.containerData.get(0);
    }

    public int getVoyageProgress() {
        return this.containerData.get(1);
    }

    public int getVoyageMaxTime() {
        return this.containerData.get(2);
    }

    public List<Component> getComponents() {
        return this.components;
    }
}
