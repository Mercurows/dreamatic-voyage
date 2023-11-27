package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import tech.lq0.providencraft.tools.RarityTool;

public class AncientLollipop extends SwordItem {
    public AncientLollipop() {
        super(Tiers.NETHERITE, 1, -0.8f, new Properties().rarity(RarityTool.LEGENDARY).durability(642).fireResistant());
    }
}
