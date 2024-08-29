package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public class VoyagerFuelSlot extends Slot {

    public VoyagerFuelSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }

    public boolean mayPlace(ItemStack pStack) {
        return pStack.is(ItemRegistry.PHANTASM_FUEL.get());
    }

    public int getMaxStackSize() {
        return 64;
    }
}
