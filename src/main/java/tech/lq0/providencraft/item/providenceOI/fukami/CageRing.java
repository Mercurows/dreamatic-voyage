package tech.lq0.providencraft.item.providenceOI.fukami;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CageRing extends Item implements ICurioItem {
    public CageRing() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }


}
