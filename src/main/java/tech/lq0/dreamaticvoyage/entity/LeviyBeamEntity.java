package tech.lq0.dreamaticvoyage.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
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
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class LeviyBeamEntity extends Entity {
    private static final EntityDataAccessor<Float> POWER = SynchedEntityData.defineId(LeviyBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(LeviyBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(LeviyBeamEntity.class, EntityDataSerializers.INT);

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private float power;
    private float radius;
    private int duration;
    private LivingEntity owner;
    private UUID ownerUniqueId;

    public LeviyBeamEntity(EntityType<?> entityTypeIn, Level level) {
        super(entityTypeIn, level);
        this.power = 6f;
        this.radius = 10f;
        this.duration = 200;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(POWER, 6.0f);
        this.entityData.define(RADIUS, 10.0f);
        this.entityData.define(DURATION, 200);
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
                    motionFlag = target.hurt(DamageSourceRegistry.causeLeviyBeamDamage(this.level().registryAccess(), this.owner), damage * 3.5f);
                    target.hurt(DamageSourceRegistry.causeAbsoluteLeviyBeamDamage(this.level().registryAccess(), this.owner), damage * 0.5f);
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
        this.power = pCompound.getFloat("power");
        this.radius = pCompound.getFloat("radius");
        this.duration = pCompound.getInt("duration");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putFloat("power", this.power);
        pCompound.putFloat("radius", this.radius);
        pCompound.putInt("duration", this.duration);
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
        float tickCount = this.tickCount + partialTicks;

        if (tickCount <= 5) {
            return .25f;
        } else if (tickCount <= 100) {
            return .00108f * tickCount * tickCount - .011f * tickCount + .277f;
        } else if (tickCount <= 180) {
            return 10f;
        } else {
            return Math.max(0.05f, -0.025f * tickCount * tickCount + 9 * tickCount - 800);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        FriendlyByteBuf byteBuf = new FriendlyByteBuf(Unpooled.buffer());

        byteBuf.writeDouble(this.getX());
        byteBuf.writeDouble(this.getY());
        byteBuf.writeDouble(this.getZ());

        byteBuf.writeFloat(this.power);
        byteBuf.writeFloat(this.radius);
        byteBuf.writeInt(this.duration);

        byteBuf.writeInt(this.getId());
        byteBuf.writeUUID(this.getUUID());

        return new ClientboundAddEntityPacket(this);
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }
}
