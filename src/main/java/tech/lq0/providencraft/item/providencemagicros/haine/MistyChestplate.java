package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.world.item.ArmorItem;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.RarityTool;

public class MistyChestplate extends ArmorItem {
    public MistyChestplate() {
        super(ModArmorMaterial.MAGICROS, Type.CHESTPLATE, new Properties().fireResistant().setNoRepair().rarity(RarityTool.LEGENDARY));
    }
}
