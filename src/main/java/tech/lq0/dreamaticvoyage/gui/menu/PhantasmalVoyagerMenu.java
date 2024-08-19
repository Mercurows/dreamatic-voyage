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
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;

public class PhantasmalVoyagerMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData containerData;

    // TODO 这改的是个锤子位置
    public static final int X_OFFSET = 97;
    public static final int Y_OFFSET = 56;

    public PhantasmalVoyagerMenu(int id, Inventory inventory) {
        this(id, inventory, new SimpleContainer(12), new SimpleContainerData(12));
    }

    public PhantasmalVoyagerMenu(int id, Inventory inventory, Container container, ContainerData containerData) {
        super(MenuTypeRegistry.PHANTASMAL_VOYAGER_MENU.get(), id);

        checkContainerSize(container, 2);
        checkContainerDataCount(containerData, 12);

        this.container = container;
        this.containerData = containerData;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18 + X_OFFSET, 84 + i * 18 + Y_OFFSET));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18 + X_OFFSET, 142 + Y_OFFSET));
        }
    }

    // TODO 动了吗？如动
    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }
}
