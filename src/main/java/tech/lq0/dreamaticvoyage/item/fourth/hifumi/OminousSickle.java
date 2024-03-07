package tech.lq0.dreamaticvoyage.item.fourth.hifumi;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.RarityTool;

public class OminousSickle extends SwordItem {
    public OminousSickle() {
        super(ModItemTier.CHARGED_CRYSTAL, 5, -1.0F,
                new Properties().rarity(RarityTool.LEGENDARY).setNoRepair().fireResistant());
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
