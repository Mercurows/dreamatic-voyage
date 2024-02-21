package tech.lq0.dreamaticvoyage.capability.chaos;

import net.minecraft.nbt.CompoundTag;

public class ChaosCapability implements IChaosCapability {
    private double chaos;

    public ChaosCapability(double chaos) {
        this.chaos = chaos;
    }

    @Override
    public double getChaos() {
        return this.chaos;
    }

    @Override
    public double setChaos(double num) {
        this.chaos = num;
        return 0;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putDouble("chaos", this.chaos);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.chaos = nbt.getDouble("chaos");
    }
}
