package tech.lq0.providencraft.item.other;

import net.minecraft.world.item.Item;
import tech.lq0.providencraft.tools.RarityTool;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class FallenRing extends Item implements ICurioItem {
    public FallenRing() {
        super(new Properties().stacksTo(1).rarity(RarityTool.DEEP_DARK));
    }
}
