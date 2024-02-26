package tech.lq0.dreamaticvoyage.capability;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosCapabilityProvider;
import tech.lq0.dreamaticvoyage.capability.chaos.IChaosCapability;

@Mod.EventBusSubscriber()
public class CapabilityHandler {
    @SubscribeEvent
    public static void registerCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(Utils.MOD_ID, "chaos"), new ChaosCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        Player player = event.getEntity();
        Player oldPlayer = event.getOriginal();
        oldPlayer.revive();
        LazyOptional<IChaosCapability> oldChaosCap = oldPlayer.getCapability(ModCapabilities.CHAOS_CAPABILITY);
        LazyOptional<IChaosCapability> newChaosCap = player.getCapability(ModCapabilities.CHAOS_CAPABILITY);
        if (oldChaosCap.isPresent() && newChaosCap.isPresent()) {
            newChaosCap.ifPresent((newCap) -> oldChaosCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
        }
    }
}
