package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CrystalPendant extends Item implements ICurioItem {

    public CrystalPendant() {
        super(new Properties().durability(15));
    }

    @SubscribeEvent
    public static void onItemBreak(PlayerDestroyItemEvent event) {



    }
}
