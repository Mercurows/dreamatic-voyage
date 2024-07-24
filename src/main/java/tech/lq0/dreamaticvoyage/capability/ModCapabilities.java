package tech.lq0.dreamaticvoyage.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import tech.lq0.dreamaticvoyage.capability.chaos.IChaosCapability;
import tech.lq0.dreamaticvoyage.capability.escort.IEscortCapability;
import tech.lq0.dreamaticvoyage.capability.uce.IUmisuCurrentEnergyCapability;
import tech.lq0.dreamaticvoyage.capability.voyage.IVoyageContainerCapability;

public class ModCapabilities {
    public static final Capability<IEscortCapability> ESCORT_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    public static final Capability<IChaosCapability> CHAOS_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    public static final Capability<IUmisuCurrentEnergyCapability> UMISU_CURRENT_ENERGY_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    public static final Capability<IVoyageContainerCapability> VOYAGE_CONTAINER_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });
}
