package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class MomoBandage extends Item implements ICurioItem {
    public MomoBandage() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }
}
