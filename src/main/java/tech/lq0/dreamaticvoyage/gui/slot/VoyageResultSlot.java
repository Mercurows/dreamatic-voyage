package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class VoyageResultSlot extends Slot {
    public boolean flag;

    public VoyageResultSlot(Container pContainer, int pSlot, int pX, int pY, boolean flag) {
        super(pContainer, pSlot, pX, pY);
        this.flag = flag;
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return false;
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public boolean mayPickup(Player pPlayer) {
        return this.flag;
    }
}
