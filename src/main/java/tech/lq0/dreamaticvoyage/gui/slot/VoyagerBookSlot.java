package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class VoyagerBookSlot extends Slot {

    public VoyagerBookSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }

    public boolean mayPlace(ItemStack pStack) {
        return pStack.is(Items.WRITABLE_BOOK);
    }

    public int getMaxStackSize() {
        return 1;
    }
}
