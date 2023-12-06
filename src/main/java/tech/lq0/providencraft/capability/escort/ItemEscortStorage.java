package tech.lq0.providencraft.capability.escort;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("ConstantConditions")
public class ItemEscortStorage extends EscortCapability {
    private static final String NBT_ESCORT = "Escort";

    private final ItemStack stack;

    public ItemEscortStorage(ItemStack stack, double capacity) {
        super(capacity, Double.MAX_VALUE, Double.MAX_VALUE);

        this.stack = stack;
        this.value = stack.hasTag() && stack.getTag().contains(NBT_ESCORT) ? stack.getTag().getDouble(NBT_ESCORT) : 0;
    }

    @Override
    public double addValue(double num) {
        double escort = super.addValue(num);

        if (escort > 0) {
            if (!stack.hasTag()) {
                stack.setTag(new CompoundTag());
            }

            stack.getTag().putDouble(NBT_ESCORT, getEscortValue());
        }

        return escort;
    }

    @Override
    public double subValue(double num) {
        double escort = super.subValue(num);

        if (escort > 0) {
            if (!stack.hasTag()) {
                stack.setTag(new CompoundTag());
            }

            stack.getTag().putDouble(NBT_ESCORT, getEscortValue());
        }

        return escort;
    }

    @Override
    public double setValue(double num) {
        double escort = super.setValue(num);

        if (!stack.hasTag()) {
            stack.setTag(new CompoundTag());
        }

        stack.getTag().putDouble(NBT_ESCORT, escort);

        return escort;
    }
}
