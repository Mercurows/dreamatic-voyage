package tech.lq0.dreamaticvoyage.capability.uce;

import net.minecraft.world.item.ItemStack;

@SuppressWarnings("ConstantConditions")
public class ItemUCEStorage extends UmisuCurrentEnergyCapability {
    private static final String NBT_UCE = "UmisuEnergy";

    private final ItemStack stack;

    public ItemUCEStorage(ItemStack stack, int capacity) {
        super(capacity, Integer.MAX_VALUE, Integer.MAX_VALUE);

        this.stack = stack;
        this.energy = stack.hasTag() && stack.getTag().contains(NBT_UCE) ? stack.getTag().getInt(NBT_UCE) : 0;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int received = super.receiveEnergy(maxReceive, simulate);

        if (received > 0 && !simulate) {
            stack.getOrCreateTag().putInt(NBT_UCE, getEnergyStored());
        }

        return received;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int extracted = super.extractEnergy(maxExtract, simulate);

        if (extracted > 0 && !simulate) {
            stack.getOrCreateTag().putInt(NBT_UCE, getEnergyStored());
        }

        return extracted;
    }
}
