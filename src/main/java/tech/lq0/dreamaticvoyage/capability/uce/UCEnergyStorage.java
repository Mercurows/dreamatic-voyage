package tech.lq0.dreamaticvoyage.capability.uce;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

public class UCEnergyStorage implements IUCEnergyStorage, INBTSerializable<Tag> {
    private static final String NBT_UCE = "UmisuEnergy";

    protected int energy;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public UCEnergyStorage(int capacity) {
        this(capacity, capacity, capacity, 0);
    }

    public UCEnergyStorage(int capacity, int maxTransfer) {
        this(capacity, maxTransfer, maxTransfer, 0);
    }

    public UCEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        this(capacity, maxReceive, maxExtract, 0);
    }

    public UCEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.energy = Math.max(0, Math.min(capacity, energy));
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if (!canReceive()) {
            return 0;
        }

        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        if (!simulate) {
            energy += energyReceived;
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (!canExtract()) {
            return 0;
        }

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if (!simulate) {
            energy -= energyExtracted;
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return this.maxExtract > 0;
    }

    public boolean canExtract(int energy) {
        return this.maxExtract > 0 && energy <= this.energy;
    }

    @Override
    public boolean canReceive() {
        return this.maxReceive > 0;
    }

    public boolean canReceive(int energy) {
        return this.maxReceive > 0 && energy <= this.capacity - this.energy;
    }

    @Override
    public Tag serializeNBT() {
        return IntTag.valueOf(this.getEnergyStored());
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        if (!(nbt instanceof IntTag intNbt))
            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
        this.energy = intNbt.getAsInt();
    }

    public void write(CompoundTag tag) {
        tag.put(NBT_UCE, IntTag.valueOf(energy));
    }

    public void read(CompoundTag tag) {
        energy = tag.getInt(NBT_UCE);
    }
}
