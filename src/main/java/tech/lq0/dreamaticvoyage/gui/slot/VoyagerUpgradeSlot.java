package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class VoyagerUpgradeSlot extends Slot {
    public boolean flag;

    public VoyagerUpgradeSlot(Container pContainer, int pSlot, int pX, int pY, boolean flag) {
        super(pContainer, pSlot, pX, pY);
        this.flag = flag;
    }

    public boolean mayPlace(ItemStack pStack) {
        return false;
    }

    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean mayPickup(Player pPlayer) {
        return this.flag;
    }
}
