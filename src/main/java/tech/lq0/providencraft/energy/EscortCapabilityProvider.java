package tech.lq0.providencraft.energy;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import tech.lq0.providencraft.capability.IEscortCapability;
import tech.lq0.providencraft.capability.ModCapabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EscortCapabilityProvider implements ICapabilityProvider {
    private final LazyOptional<IEscortCapability> capability;

    public EscortCapabilityProvider(ItemStack stack, double energyCapacity) {
        this.capability = LazyOptional.of(() -> new ItemEscortStorage(stack, energyCapacity));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction dire) {
        if (cap == ModCapabilities.ESCORT_CAPABILITY) {
            return capability.cast();
        }

        return LazyOptional.empty();
    }
}
