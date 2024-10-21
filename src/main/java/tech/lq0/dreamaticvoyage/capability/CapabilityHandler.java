package tech.lq0.dreamaticvoyage.capability;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosCapabilityProvider;

@Mod.EventBusSubscriber()
public class CapabilityHandler {
    @SubscribeEvent
    public static void registerCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(Utils.loc("chaos"), new ChaosCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        Player player = event.getEntity();
        Player oldPlayer = event.getOriginal();

        handleChaosCap(player, oldPlayer);
    }

    private static void handleChaosCap(Player player, Player oldPlayer) {
        oldPlayer.revive();
        var oldChaosCap = oldPlayer.getCapability(ModCapabilities.CHAOS_CAPABILITY).resolve();
        var newChaosCap = player.getCapability(ModCapabilities.CHAOS_CAPABILITY).resolve();

        if (oldChaosCap.isEmpty() || newChaosCap.isEmpty()) return;

        var newCap = newChaosCap.get();
        var oldCap = oldChaosCap.get();
        newCap.deserializeNBT(oldCap.serializeNBT());
    }

}
