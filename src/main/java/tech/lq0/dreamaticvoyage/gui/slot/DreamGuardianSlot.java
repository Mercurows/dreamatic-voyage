package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import tech.lq0.dreamaticvoyage.item.misc.guardian.DreamGuardian;

public class DreamGuardianSlot extends Slot {

    public DreamGuardianSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }

    public boolean mayPlace(ItemStack pStack) {
        return pStack.getItem() instanceof DreamGuardian;
    }

    public int getMaxStackSize() {
        return 1;
    }
}
