package tech.lq0.dreamaticvoyage.capability.beam;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import tech.lq0.dreamaticvoyage.entity.projectile.AbstractBeamEntity;

public class BeamHandler {

    public final int coolingTick;
    public boolean isUsing;
    public final LivingEntity entity;
    public final AbstractBeamEntity beamEntity;
    private int tick;

    public BeamHandler(LivingEntity entity, AbstractBeamEntity beamEntity, int coolingTick) {
        this.coolingTick = coolingTick;
        this.entity = entity;
        this.beamEntity = beamEntity;
    }

    public void start() {
        this.tick = 0;
        this.isUsing = true;

        if (this.entity.level() instanceof ServerLevel level) {
            level.addFreshEntity(this.beamEntity);
        }
        this.entity.swing(InteractionHand.MAIN_HAND, true);
    }

    public void tick() {
        if (this.isUsing) {
            this.tick++;

            if (this.tick > beamEntity.getDuration()) {
                this.stop();
            }
        }
    }

    public void stop() {
        if (!this.isUsing) return;

        this.isUsing = false;
        this.tick = 0;
        if (this.beamEntity != null) {
            this.beamEntity.discard();
        }
    }

    public int getTick() {
        return this.tick;
    }

    public CompoundTag writeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        if (this.isUsing) {
            compoundTag.putInt("Tick", this.tick);
        }
        return compoundTag;
    }

    public void readNBT(Tag nbt) {
        CompoundTag compoundTag = (CompoundTag) nbt;
        this.isUsing = compoundTag.contains("Tick");
        if (this.isUsing) {
            this.tick = compoundTag.getInt("Tick");
        }
    }

    public boolean isUsable() {
        return !this.isUsing;
    }

}
