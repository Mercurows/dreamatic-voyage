package tech.lq0.dreamaticvoyage.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.item.second.satou.AncientLollipop;
import tech.lq0.dreamaticvoyage.tools.AnimationTickHolder;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent event) {
        if (!isGameActive()) {
            return;
        }

        AnimationTickHolder.tick();
    }

    //From Create
    protected static boolean isGameActive() {
        return !(Minecraft.getInstance().level == null || Minecraft.getInstance().player == null);
    }

    @SubscribeEvent
    public static void setPlayerInvisible(RenderPlayerEvent.Pre event) {
        var otherPlayer = event.getEntity();
        var currentPlayer = Minecraft.getInstance().player;
        if (currentPlayer == null) return;

        if (otherPlayer.isInvisibleTo(currentPlayer) && otherPlayer.isInvisible() && otherPlayer.getMainHandItem().getItem() instanceof AncientLollipop) {
            event.setCanceled(true);
        }
    }
}
