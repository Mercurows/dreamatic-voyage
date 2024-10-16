package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;

public class ColorfulEdge extends SwordItem {

    public ColorfulEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 7, -2.5f, new Properties().setNoRepair().rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
