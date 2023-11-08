package tech.lq0.providencraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.DamageSourceRegistry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class LeviyBeamEntity extends Entity {
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

    public LeviyBeamEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.power = 6;
        this.radius = 10;
        this.duration = 200;
    }

    @Override
    public void tick() {
        super.tick();
        if (!world.isRemote) {
            if (this.ticksExisted >= this.duration) {
                this.remove();
            }
            float r = getCurrentRadius();
            List<LivingEntity> targets = this.world.getEntitiesWithinAABB(LivingEntity.class, this.getBoundingBox().grow(r, 0, r));
            if (!targets.isEmpty()) {
                for (LivingEntity target : targets) {
                    if (target.getUniqueID().equals(this.ownerUniqueId) || getOwner() != null && target.isOnSameTeam(getOwner())) {
                        continue;
                    }

                    double xDiff = target.getPosX() - this.getPosX();
                    double zDiff = target.getPosZ() - this.getPosZ();
                    double d = Math.sqrt(xDiff * xDiff + zDiff * zDiff);

                    float damage = getDamage(d, r);

                    target.forceFireTicks(1);
                    target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 1));

                    boolean motionFlag = false;

                    double xMotion = target.getMotion().x - 10 * xDiff / r / 20;
                    double zMotion = target.getMotion().z - 10 * zDiff / r / 20;

                    if (this.ticksExisted % 4 == 0) {
                        motionFlag = target.attackEntityFrom(DamageSourceRegistry.causeLeviyBeamDamage(this, this.owner), damage * 4);
                    }

                    if (motionFlag) {
                        if (r <= 1.5) {
                            target.setMotion(xMotion * r / 1.5, target.getMotion().y + .05, zMotion * r / 1.5);
                        } else {
                            target.setMotion(xMotion, target.getMotion().y + .05, zMotion);
                        }
                    }

                    target.hurtResistantTime = 4;
                }
            }
        }
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
        this.ownerUniqueId = ownerIn == null ? null : ownerIn.getUniqueID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUniqueId != null && this.world instanceof ServerWorld) {
            Entity entity = ((ServerWorld) this.world).getEntityByUuid(this.ownerUniqueId);
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
        float ticksExisted = this.ticksExisted + partialTicks;

        if (ticksExisted <= 5) {
            return .25f;
        } else if (ticksExisted <= 100) {
            return .00108f * ticksExisted * ticksExisted - .011f * ticksExisted + .277f;
        } else if (ticksExisted <= 180) {
            return 10f;
        } else {
            return Math.max(0.05f, -0.025f * ticksExisted * ticksExisted + 9 * ticksExisted - 800);
        }
    }

    @Override
    protected void registerData() {

    }

    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

    }

    @Override
    public IPacket<?> createSpawnPacket() {
        PacketBuffer pack = new PacketBuffer(Unpooled.buffer());
        pack.writeDouble(getPosX());
        pack.writeDouble(getPosY());
        pack.writeDouble(getPosZ());

        pack.writeFloat(this.power);
        pack.writeFloat(this.radius);
        pack.writeInt(this.duration);

        pack.writeInt(getEntityId());
        pack.writeUniqueId(getUniqueID());

        return NetworkHooks.getEntitySpawningPacket(this);
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }
}
