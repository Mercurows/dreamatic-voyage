package tech.lq0.providencraft.item.providencemagicros.ekira;

import net.minecraft.world.item.ArmorItem;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.RarityTool;

public class CelestialBoots extends ArmorItem {
    public CelestialBoots() {
        super(ModArmorMaterial.MAGICROS, Type.BOOTS, new Properties().fireResistant().setNoRepair().rarity(RarityTool.LEGENDARY));
    }
}
