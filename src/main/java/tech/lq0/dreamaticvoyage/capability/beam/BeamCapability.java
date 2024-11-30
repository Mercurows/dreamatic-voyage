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

        void init(BeamHandler handler);

        void start();

        void tick();

        void stop();

    }

    public static class BeamCapabilityImpl implements IBeamCapability {

        public BeamHandler beamHandler;

        @Override
        public void init(BeamHandler handler) {
            this.beamHandler = handler;
        }

        @Override
        public void start() {
            this.beamHandler.start();
        }

        @Override
        public void tick() {
        }

        @Override
        public void stop() {
            if (this.beamHandler != null) {
                this.beamHandler.stop();
            }
        }

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            if (this.beamHandler != null) {
                tag.put("Beam", this.beamHandler.writeNBT());
            }
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            if (nbt.contains("Beam") && this.beamHandler != null) {
                this.beamHandler.readNBT(nbt.getCompound("Beam"));
            }
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
