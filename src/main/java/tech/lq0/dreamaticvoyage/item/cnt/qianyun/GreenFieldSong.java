package tech.lq0.dreamaticvoyage.item.cnt.qianyun;

import net.minecraft.world.item.HoeItem;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.RarityTool;

public class GreenFieldSong extends HoeItem {
    public GreenFieldSong() {
        super(ModItemTier.FICTIONAL_INGOT, 0, -1.0f, new Properties()
                .rarity(RarityTool.LEGENDARY).setNoRepair().fireResistant());
    }
}
