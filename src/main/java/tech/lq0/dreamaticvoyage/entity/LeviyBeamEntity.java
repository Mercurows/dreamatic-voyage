package tech.lq0.dreamaticvoyage.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class LeviyBeamEntity extends Entity implements IEntityAdditionalSpawnData {
    public static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(LeviyBeamEntity.class, EntityDataSerializers.FLOAT);

    private float power = 6f;
    private float maxRadius = 10f;
    private float currentRadius;
    private int duration = 200;
    private LivingEntity owner;
    private UUID ownerUniqueId;

    public LeviyBeamEntity(EntityType<?> entityTypeIn, Level level) {
        super(entityTypeIn, level);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(RADIUS, this.currentRadius);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            return;
        }

        if (this.tickCount >= this.duration) {
            this.discard();
        }

        if (this.tickCount == 1) {
            this.playSound(SoundRegistry.LEVIY_BEAM.get(), 1.0f, 1.0f);
        }

        float r = getCurrentRadius();

        this.currentRadius = r;
        this.entityData.set(RADIUS, this.currentRadius);

        List<LivingEntity> targets = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(r, 0, r));
        if (!targets.isEmpty()) {
            for (LivingEntity target : targets) {
                if (target.getUUID().equals(this.ownerUniqueId) || getOwner() != null && target.isAlliedTo(getOwner())) {
                    continue;
                }

                double xDiff = target.getX() - this.getX();
                double zDiff = target.getZ() - this.getZ();
                double d = Math.sqrt(xDiff * xDiff + zDiff * zDiff);

                float damage = getDamage(d, r);

                target.setRemainingFireTicks(1);
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1));

                boolean motionFlag = false;

                double xMotion = target.getDeltaMovement().x - 10 * xDiff / r / 20;
                double zMotion = target.getDeltaMovement().z - 10 * zDiff / r / 20;

                if (this.tickCount % 4 == 0) {
                    motionFlag = target.hurt(DamageSourceRegistry.causeLeviyBeamDamage(this.level().registryAccess(), this, this.owner), damage * 3.5f);
                    target.hurt(DamageSourceRegistry.causeAbsoluteLeviyBeamDamage(this.level().registryAccess(), this, this.owner), damage * 0.5f);
                }

                if (motionFlag) {
                    if (r <= 1.5) {
                        target.setDeltaMovement(xMotion * r / 1.5, target.getDeltaMovement().y + .05, zMotion * r / 1.5);
                    } else {
                        target.setDeltaMovement(xMotion, target.getDeltaMovement().y + .05, zMotion);
                    }
                }

                target.invulnerableTime = 4;
            }
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        this.power = pCompound.getFloat("Power");
        this.maxRadius = Math.min(64, pCompound.getFloat("Radius"));
        this.duration = Math.min(3600, pCompound.getInt("Duration"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putFloat("Power", this.power);
        pCompound.putFloat("Radius", Math.min(64, this.maxRadius));
        pCompound.putInt("Duration", Math.min(3600, this.duration));
    }

    private float getDamage(double d, float r) {
        float damage;
        if (d <= r * .1f) {
            damage = power * 1.25f;
        } else if (d <= r * .5f) {
            damage = power;
        } else {
            if (d > r) {
                damage = power * .1f;
            } else {
                damage = ease(power, power * .1f, (float) ((d - r * .5f) / r));
            }
        }
        return damage;
    }

    public void setOwner(@Nullable LivingEntity ownerIn) {
        this.owner = ownerIn;
        this.ownerUniqueId = ownerIn == null ? null : ownerIn.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUniqueId != null && this.level() instanceof ServerLevel server) {
            Entity entity = server.getEntity(this.ownerUniqueId);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity) entity;
            }
        }

        return this.owner;
    }

    public float getCurrentRadius() {
        return getCurrentRadius(0);
    }

    public float getCurrentRadius(float partialTicks) {
        return getCurrentRadius(partialTicks, this.duration, this.maxRadius);
    }

    public float getCurrentRadius(float partialTicks, float duration, float radius) {
        float tickCount = this.tickCount + partialTicks;

        if (tickCount <= 5) {
            return 0.25f;
        } else if (tickCount <= 0.5 * duration) {
            return (radius - 0.25f) / ((duration * 0.5f - 5) * (duration * 0.5f - 5)) * (tickCount - 5) * (tickCount - 5) + 0.25f;
        } else if (tickCount <= 0.9 * duration) {
            return radius;
        } else {
            return Math.max(0.005f * radius, (25 - 100 * radius) / duration / duration * (tickCount - 0.9f * duration) * (tickCount - 0.9f * duration) + radius);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public float getMaxRadius() {
        return maxRadius;
    }

    public void setMaxRadius(float maxRadius) {
        this.maxRadius = maxRadius;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        buffer.writeFloat(this.power);
        buffer.writeFloat(this.maxRadius);
        buffer.writeInt(this.duration);
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {
        this.power = additionalData.readFloat();
        this.maxRadius = additionalData.readFloat();
        this.duration = additionalData.readInt();
    }
}
