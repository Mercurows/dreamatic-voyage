package tech.lq0.providencraft.item.providencethird.leciel;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

public class ReinaWings extends ArmorItem {
    public ReinaWings() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties().durability(627));
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.getItem() == ItemRegistry.REINA_FEATHER.get();
    }
}
