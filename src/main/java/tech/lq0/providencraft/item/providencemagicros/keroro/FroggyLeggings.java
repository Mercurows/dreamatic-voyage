package tech.lq0.providencraft.item.providencemagicros.keroro;

import net.minecraft.world.item.ArmorItem;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.RarityTool;

public class FroggyLeggings extends ArmorItem {
    public FroggyLeggings() {
        super(ModArmorMaterial.MAGICROS, Type.LEGGINGS, new Properties().fireResistant().setNoRepair().rarity(RarityTool.LEGENDARY));
    }
}
