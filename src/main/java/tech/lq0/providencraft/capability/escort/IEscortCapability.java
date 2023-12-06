package tech.lq0.providencraft.capability.escort;

import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public interface IEscortCapability {
    double getEscortValue();

    double getCapacity();

    double addValue(double num);

    double subValue(double num);

    boolean canAdd();

    boolean canSub();

    double setValue(double num);
}
