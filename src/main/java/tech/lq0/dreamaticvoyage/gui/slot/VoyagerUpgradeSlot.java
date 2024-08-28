package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class VoyagerUpgradeSlot extends Slot {

    public VoyagerUpgradeSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }

    public boolean mayPlace(ItemStack pStack) {
        return false;
    }

    public int getMaxStackSize() {
        return 1;
    }
}
