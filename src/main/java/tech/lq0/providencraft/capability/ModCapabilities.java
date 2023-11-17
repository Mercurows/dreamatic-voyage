package tech.lq0.providencraft.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class ModCapabilities {
    public static final Capability<IEscortCapability> ESCORT_CAPABILITY = CapabilityManager.get(new CapabilityToken<IEscortCapability>() {});
}
