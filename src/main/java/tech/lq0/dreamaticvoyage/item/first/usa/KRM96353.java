package tech.lq0.dreamaticvoyage.item.first.usa;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;

public class KRM96353 extends ArmorItem {
    public KRM96353() {
        super(ModArmorMaterial.PURIFIED_CRYSTAL, Type.CHESTPLATE, new Properties().rarity(Rarity.EPIC).setNoRepair());
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
