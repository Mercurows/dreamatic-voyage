package tech.lq0.dreamaticvoyage.tools;

import net.minecraft.world.entity.player.Player;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public class ArmorTool {
    public static boolean hasMagicrosArmorSet(Player player) {
        if (player == null) {
            return false;
        }

        return player.getInventory().getArmor(3).getItem() == ItemRegistry.BREEZE_CROWN.get()
                && player.getInventory().getArmor(2).getItem() == ItemRegistry.MISTY_CHESTPLATE.get()
                && player.getInventory().getArmor(1).getItem() == ItemRegistry.FROGGY_LEGGINGS.get()
                && player.getInventory().getArmor(0).getItem() == ItemRegistry.CELESTIAL_BOOTS.get();
    }
}
