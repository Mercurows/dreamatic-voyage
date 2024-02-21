package tech.lq0.dreamaticvoyage.capability.escort;

import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

public class EscortCapability implements IEscortCapability, INBTSerializable<Tag> {
    protected double value;
    protected double capacity;
    protected double addLimit;
    protected double subLimit;

    public EscortCapability(double capacity) {
        this(capacity, 0, capacity, capacity);
    }

    public EscortCapability(double capacity, double limit) {
        this(capacity, 0, limit, limit);
    }

    public EscortCapability(double capacity, double addLimit, double subLimit) {
        this(capacity, 0, addLimit, subLimit);
    }

    public EscortCapability(double capacity, double value, double addLimit, double subLimit) {
        this.capacity = capacity;
        this.value = Math.min(capacity, Math.max(0, value));
        this.addLimit = addLimit;
        this.subLimit = subLimit;
    }

    @Override
    public double getEscortValue() {
        return this.value;
    }

    @Override
    public double getCapacity() {
        return this.capacity;
    }

    @Override
    public double addValue(double num) {
        if (!canAdd()) {
            return 0;
        }

        double add = Math.min(capacity - value, Math.min(this.addLimit, num));
        value += add;

        return add;
    }

    @Override
    public double subValue(double num) {
        if (!canSub()) {
            return 0;
        }

        double sub = Math.min(value, Math.min(this.subLimit, num));
        value = Math.max(0, value - sub);

        return sub;
    }

    @Override
    public boolean canAdd() {
        return this.addLimit > 0;
    }

    @Override
    public boolean canSub() {
        return this.subLimit > 0;
    }

    @Override
    public Tag serializeNBT() {
        return DoubleTag.valueOf(this.value);
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        if (nbt instanceof DoubleTag doubleTag) {
            this.value = doubleTag.getAsDouble();
        }
    }

    @Override
    public double setValue(double num) {
        value = Math.min(num, capacity);

        return value;
    }
}
