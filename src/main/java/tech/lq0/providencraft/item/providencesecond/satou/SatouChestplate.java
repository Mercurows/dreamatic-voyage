package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.world.item.ArmorItem;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

public class SatouChestplate extends ArmorItem {
    public SatouChestplate() {
        super(ModArmorMaterial.SATOU, Type.CHESTPLATE, new Properties().durability(70));
    }
}
