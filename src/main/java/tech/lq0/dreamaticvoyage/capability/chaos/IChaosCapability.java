package tech.lq0.dreamaticvoyage.capability.chaos;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

@AutoRegisterCapability
public interface IChaosCapability extends INBTSerializable<CompoundTag> {
    double getChaos();

    double setChaos(double num);
}
