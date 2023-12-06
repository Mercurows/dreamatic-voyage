package tech.lq0.providencraft.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import tech.lq0.providencraft.capability.chaos.IChaosCapability;
import tech.lq0.providencraft.capability.escort.IEscortCapability;

public class ModCapabilities {
    public static final Capability<IEscortCapability> ESCORT_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    public static final Capability<IChaosCapability> CHAOS_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });
}
