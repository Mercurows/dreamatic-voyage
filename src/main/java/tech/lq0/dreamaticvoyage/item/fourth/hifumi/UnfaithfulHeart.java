package tech.lq0.dreamaticvoyage.item.fourth.hifumi;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class UnfaithfulHeart extends Item implements ICurioItem {
    public UnfaithfulHeart() {
        super(new Properties().rarity(Rarity.UNCOMMON).durability(9));
    }
}
