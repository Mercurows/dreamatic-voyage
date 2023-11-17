package tech.lq0.providencraft.energy;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import tech.lq0.providencraft.capability.EscortCapability;

@SuppressWarnings("ConstantConditions")
public class ItemEscortStorage extends EscortCapability {
    private static final String NBT_ESCORT = "Escort";

    private final ItemStack stack;

    public ItemEscortStorage(ItemStack stack, double capacity) {
        super(capacity, Double.MAX_VALUE, Double.MAX_VALUE);

        this.stack = stack;
        this.value = stack.hasTag() && stack.getTag().contains(NBT_ESCORT) ? stack.getTag().getInt(NBT_ESCORT) : 0;
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
}
