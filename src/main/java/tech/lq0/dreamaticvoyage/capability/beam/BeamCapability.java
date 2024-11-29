package tech.lq0.dreamaticvoyage.capability.beam;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.entity.projectile.AbstractBeamEntity;

public class BeamCapability {

    public static ResourceLocation ID = Utils.loc("beam_capability");

    public interface IBeamCapability extends INBTSerializable<CompoundTag> {

        void init(AbstractBeamEntity beamEntity, @Nullable LivingEntity caster);

        void start();

        void tick();

        void stop();

    }

    public static class BeamCapabilityImpl implements IBeamCapability {

        public AbstractBeamEntity beamEntity;
        public int duration;
        @Nullable
        public LivingEntity caster;

        @Override
        public void init(AbstractBeamEntity beamEntity, @Nullable LivingEntity caster) {
            this.beamEntity = beamEntity;
            this.duration = beamEntity.getDuration();
            this.caster = caster;
        }

        @Override
        public void start() {
            if (this.caster == null) return;

            if (this.caster.level() instanceof ServerLevel level) {
                level.addFreshEntity(beamEntity);
            }
            this.caster.swing(InteractionHand.MAIN_HAND, true);
        }

        @Override
        public void tick() {
            System.out.println(114);
        }

        @Override
        public void stop() {
            if (this.beamEntity != null) {
                this.beamEntity.discard();
            }
        }

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.putInt("Duration", this.duration);
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.duration = nbt.getInt("Duration");
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
