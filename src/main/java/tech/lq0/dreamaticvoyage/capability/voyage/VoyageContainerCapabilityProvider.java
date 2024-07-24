package tech.lq0.dreamaticvoyage.capability.voyage;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;

import javax.annotation.Nonnull;

public class VoyageContainerCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static final int MAX_SIZE = 27;

    private IVoyageContainerCapability capability;

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == ModCapabilities.VOYAGE_CONTAINER_CAPABILITY ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Nonnull
    IVoyageContainerCapability getOrCreateCapability() {
        if (capability == null) {
            this.capability = new VoyageContainerCapability(MAX_SIZE);
        }
        return this.capability;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        SimpleContainer container = capability.getInventory();

        CompoundTag nbt = new CompoundTag();
        for (int i = 0; i < container.getContainerSize(); i++) {
            nbt.put("Item" + i, container.getItem(i).serializeNBT());
        }
        tag.put("VoyageContainer", nbt);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        CompoundTag tag = nbt.getCompound("VoyageContainer");

        SimpleContainer container = capability.getInventory();
        for (int i = 0; i < container.getContainerSize(); i++) {
            container.setItem(i, ItemStack.of(tag.getCompound("Item" + i)));
        }

    }
}
