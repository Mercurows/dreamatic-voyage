package tech.lq0.dreamaticvoyage.capability.uce;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UCECapabilityProvider implements ICapabilityProvider {
    private final LazyOptional<ItemUCEStorage> capability;

    public UCECapabilityProvider(ItemStack stack, int energyCapacity) {
        this.capability = LazyOptional.of(() -> new ItemUCEStorage(stack, energyCapacity));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction dire) {
        if (cap == ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY) {
            return capability.cast();
        }

        return LazyOptional.empty();
    }
}
