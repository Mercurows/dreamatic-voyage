package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class VoyagerBookSlot extends Slot {
    public boolean flag;

    public VoyagerBookSlot(Container pContainer, int pSlot, int pX, int pY, boolean flag) {
        super(pContainer, pSlot, pX, pY);
        this.flag = flag;
    }

    public boolean mayPlace(ItemStack pStack) {
        return pStack.is(Items.WRITABLE_BOOK);
    }

    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean mayPickup(Player pPlayer) {
        return this.flag;
    }
}
