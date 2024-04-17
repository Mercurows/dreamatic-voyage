package tech.lq0.dreamaticvoyage.capability.chaos;

import net.minecraft.world.entity.player.Player;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.init.AttributeRegistry;

public class ChaosHelper {
    public static int getChaos(Player player) {
        return player.getCapability(ModCapabilities.CHAOS_CAPABILITY)
                .map(l -> (int) Math.max(-100, Math.min(100, l.getChaos() + (int) player.getAttributeValue(AttributeRegistry.CHAOS.get()))))
                .orElse(0);
    }

    public static void addChaos(Player player, int chaos) {
        player.getCapability(ModCapabilities.CHAOS_CAPABILITY)
                .ifPresent(l -> l.setChaos((int) Math.max(-100, Math.min(100, l.getChaos() + chaos))));
    }

    public static void setChaos(Player player, int chaos) {
        player.getCapability(ModCapabilities.CHAOS_CAPABILITY)
                .ifPresent(l -> l.setChaos(Math.max(-100, Math.min(100, chaos))));
    }

    public static void resetChaos(Player player) {
        player.getCapability(ModCapabilities.CHAOS_CAPABILITY)
                .ifPresent(l -> l.setChaos(0));
    }

    public static int getPureChaos(Player player) {
        return player.getCapability(ModCapabilities.CHAOS_CAPABILITY)
                .map(l -> (int) Math.max(-100, Math.min(100, l.getChaos())))
                .orElse(0);
    }

}
