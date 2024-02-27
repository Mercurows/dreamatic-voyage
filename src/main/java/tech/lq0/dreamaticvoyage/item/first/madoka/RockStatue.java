package tech.lq0.dreamaticvoyage.item.first.madoka;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RockStatue extends Item implements ICurioItem {
    public RockStatue() {
        super(new Properties().rarity(Rarity.UNCOMMON).stacksTo(1).fireResistant());
    }


}
