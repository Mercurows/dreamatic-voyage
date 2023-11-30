package tech.lq0.providencraft.item.material;

import net.minecraft.world.item.Item;
import tech.lq0.providencraft.tools.RarityTool;

public class DarkCrystal extends Item {
    public DarkCrystal() {
        super(new Properties().rarity(RarityTool.DEEP_DARK));
    }
}
