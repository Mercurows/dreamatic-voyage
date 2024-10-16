package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;

public class SerrationEdge extends SwordItem {

    public SerrationEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 12, -2.8f, new Properties().setNoRepair().rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
