package tech.lq0.dreamaticvoyage.gui.slot;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import tech.lq0.dreamaticvoyage.item.misc.guardian.DreamGuardian;

public class DreamGuardianSlot extends Slot {
    public boolean flag;

    public DreamGuardianSlot(Container pContainer, int pSlot, int pX, int pY, boolean flag) {
        super(pContainer, pSlot, pX, pY);
        this.flag = flag;
    }

    public boolean mayPlace(ItemStack pStack) {
        return pStack.getItem() instanceof DreamGuardian;
    }

    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean mayPickup(Player pPlayer) {
        return this.flag;
    }
}
