package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class VoyagerFuelSlot extends Slot {

    public VoyagerFuelSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }

    public boolean mayPlace(ItemStack pStack) {
        return pStack.getBurnTime(null) > 0;
    }

    public int getMaxStackSize() {
        return 64;
    }
}
