package tech.lq0.providencraft.capability;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.capability.chaos.ChaosCapabilityProvider;
import tech.lq0.providencraft.capability.chaos.IChaosCapability;

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
        LazyOptional<IChaosCapability> oldChaosCap = event.getOriginal().getCapability(ModCapabilities.CHAOS_CAPABILITY);
        LazyOptional<IChaosCapability> newChaosCap = event.getEntity().getCapability(ModCapabilities.CHAOS_CAPABILITY);
        if (oldChaosCap.isPresent() && newChaosCap.isPresent()) {
            newChaosCap.ifPresent((newCap) -> oldChaosCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
        }
    }
}
