package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Code based on @BobMowzie's MowziesMobs and @EEEAB's EEEABsMobs
 */
public abstract class AbstractBeamEntity extends Entity implements TraceableEntity {

    public LivingEntity caster;
    public float yaw, pitch;
    public float preYaw, prePitch;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public Direction blockSide = null;
    public boolean on = true;
    private static final EntityDataAccessor<Integer> DATA_CASTER_ID = SynchedEntityData.defineId(AbstractBeamEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_YAW = SynchedEntityData.defineId(AbstractBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_PITCH = SynchedEntityData.defineId(AbstractBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_DURATION = SynchedEntityData.defineId(AbstractBeamEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_COUNT_DOWN = SynchedEntityData.defineId(AbstractBeamEntity.class, EntityDataSerializers.INT);

    public AbstractBeamEntity(EntityType<?> type, Level level, int countDown) {
        super(type, level);
        this.setCountDown(countDown);
        noCulling = true;
    }

    @Override
    public void tick() {
        super.tick();
        this.prevCollidePosX = this.collidePosX;
        this.prevCollidePosY = this.collidePosY;
        this.prevCollidePosZ = this.collidePosZ;
        this.preYaw = this.yaw;
        this.prePitch = this.pitch;
        this.yaw = this.getYaw();
        this.pitch = this.getPitch();
        this.xo = this.getX();
        this.yo = this.getY();
        this.zo = this.getZ();
        if (this.tickCount == 1 && this.level().isClientSide) {
            this.caster = (LivingEntity) this.level().getEntity(getCasterId());
        }

        this.beamTick();

        if (!on || (this.caster != null && !caster.isAlive())) {
            this.discard();
        }

        if (this.tickCount - this.getCountDown() > this.getDuration()) {
            on = false;
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }

    protected void beamTick() {
    }

    @Nullable
    public LivingEntity getOwner() {
        return caster;
    }

    @Override
    public boolean isPickable() {
        return super.isPickable();
    }

    @Override
    public void push(Entity entityIn) {
    }

    @Override
    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_CASTER_ID, -1);
        this.entityData.define(DATA_YAW, 0F);
        this.entityData.define(DATA_PITCH, 0F);
        this.entityData.define(DATA_DURATION, 0);
        this.entityData.define(DATA_COUNT_DOWN, 0);
    }

    public void setCasterId(int id) {
        this.entityData.set(DATA_CASTER_ID, id);
    }

    public int getCasterId() {
        return this.entityData.get(DATA_CASTER_ID);
    }

    public boolean isAccumulating() {
        return this.tickCount > this.getCountDown();
    }

    public float getYaw() {
        return getEntityData().get(DATA_YAW);
    }

    public void setYaw(float rotAngle) {
        getEntityData().set(DATA_YAW, rotAngle);
    }

    public float getPitch() {
        return getEntityData().get(DATA_PITCH);
    }

    public void setPitch(float rotAngle) {
        getEntityData().set(DATA_PITCH, rotAngle);
    }

    public int getDuration() {
        return getEntityData().get(DATA_DURATION);
    }

    public void setDuration(int duration) {
        getEntityData().set(DATA_DURATION, duration);
    }

    public int getCountDown() {
        return getEntityData().get(DATA_COUNT_DOWN);
    }

    public void setCountDown(int countDown) {
        getEntityData().set(DATA_COUNT_DOWN, countDown);
    }

    protected void calculateEndPos(double radius) {
        if (level().isClientSide()) {
            endPosX = getX() + radius * Math.cos(yaw) * Math.cos(pitch);
            endPosZ = getZ() + radius * Math.sin(yaw) * Math.cos(pitch);
            endPosY = getY() + radius * Math.sin(pitch);
        } else {
            endPosX = getX() + radius * Math.cos(getYaw()) * Math.cos(getPitch());
            endPosZ = getZ() + radius * Math.sin(getYaw()) * Math.cos(getPitch());
            endPosY = getY() + radius * Math.sin(getPitch());
        }
    }

    public HitResult raytraceEntities(Level world, Vec3 from, Vec3 to) {
        HitResult result = new HitResult();
        result.setBlockHit(world.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)));
        if (result.getBlockHit() != null) {
            Vec3 hitVec = result.getBlockHit().getLocation();
            collidePosX = hitVec.x;
            collidePosY = hitVec.y;
            collidePosZ = hitVec.z;
            blockSide = result.getBlockHit().getDirection();
        } else {
            collidePosX = endPosX;
            collidePosY = endPosY;
            collidePosZ = endPosZ;
            blockSide = null;
        }
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).inflate(1, 1, 1));
        for (LivingEntity entity : entities) {
            if (entity == this.caster) {
                continue;
            }
            float pad = entity.getPickRadius() + getBaseScale();
            AABB aabb = entity.getBoundingBox().inflate(pad, pad, pad);
            Optional<Vec3> hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

    protected float getBaseScale() {
        return 0.5F;
    }

    public static class HitResult {

        private BlockHitResult blockHit;
        private final List<LivingEntity> entities = new ArrayList<>();

        public BlockHitResult getBlockHit() {
            return blockHit;
        }

        public List<LivingEntity> getEntities() {
            return entities;
        }

        public void setBlockHit(net.minecraft.world.phys.HitResult rayTraceResult) {
            if (rayTraceResult.getType() == net.minecraft.world.phys.HitResult.Type.BLOCK)
                this.blockHit = (BlockHitResult) rayTraceResult;
        }

        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }

}
