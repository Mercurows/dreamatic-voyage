package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;

public class SwollenEdge extends SwordItem {

    public SwollenEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 5, -2.8f, new Properties().setNoRepair().rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
