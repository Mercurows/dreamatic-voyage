package tech.lq0.providencraft.capability.chaos;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import tech.lq0.providencraft.capability.ModCapabilities;
import tech.lq0.providencraft.init.AttributeRegistry;

import java.util.concurrent.atomic.AtomicInteger;

public class ChaosHelper {
    public static int getChaos(Player player){
        AtomicInteger chaos = new AtomicInteger();
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapabilities.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> chaos.set((int) Math.max(-100, Math.min(100, l.getChaos() + (int) player.getAttributeValue(AttributeRegistry.CHAOS.get())))));

        return chaos.get();
    }

    public static void addChaos(Player player, int chaos){
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapabilities.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> l.setChaos((int) Math.max(-100, Math.min(100, l.getChaos() + chaos))));
    }

    public static void setChaos(Player player, int chaos){
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapabilities.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> l.setChaos(Math.max(-100, Math.min(100, chaos))));
    }

    public static void resetChaos(Player player){
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapabilities.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> l.setChaos(0));
    }

    public static int getPureChaos(Player player){
        AtomicInteger chaos = new AtomicInteger();
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapabilities.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> chaos.set((int) Math.max(-100, Math.min(100, l.getChaos()))));

        return chaos.get();
    }

}
