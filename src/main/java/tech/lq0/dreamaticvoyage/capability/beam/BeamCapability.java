package tech.lq0.dreamaticvoyage.capability.beam;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;

public class BeamCapability {

    public static ResourceLocation ID = Utils.loc("beam_capability");

    public interface IBeamCapability extends INBTSerializable<CompoundTag> {

    }

    public static class BeamCapabilityImpl implements IBeamCapability {

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();

            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {

        }
    }

    public static class BeamCapabilityProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {

        private final LazyOptional<BeamCapabilityImpl> instance = LazyOptional.of(BeamCapabilityImpl::new);

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return ModCapabilities.BEAM_CAPABILITY.orEmpty(cap, instance.cast());
        }

        @Override
        public CompoundTag serializeNBT() {
            return instance.orElseThrow(NullPointerException::new).serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
        }
    }

}
