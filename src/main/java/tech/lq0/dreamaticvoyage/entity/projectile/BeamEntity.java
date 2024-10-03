package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.network.DmvNetwork;
import tech.lq0.dreamaticvoyage.network.packet.BeamPacket;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Beam codes based on BeamEntityRenderer on @Thelnfamous1's Dungeon Gears and @Polarice3's Goety-2
 */
public abstract class BeamEntity extends Entity implements IEntityAdditionalSpawnData {
    public double maxRaytraceDistance = 64;
    public LivingEntity owner;
    public UUID ownerUUID;
    public float beamWidth = 0.2F;

    public BeamEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public void setOwner(LivingEntity owner) {
        this.owner = owner;
        if (owner != null) {
            this.ownerUUID = owner.getUUID();
            this.updatePositionAndRotation();
        }
    }

    public BeamEntity width(float beamWidth) {
        this.beamWidth = beamWidth;
        return this;
    }

    public BeamEntity maxDistance(double maxRaytraceDistance) {
        this.maxRaytraceDistance = maxRaytraceDistance;
        return this;
    }

    @Override
    public void tick() {
        LivingEntity owner = getOwner();
        if (this.level().isClientSide) {
            if (this.owner instanceof Player) {
                DmvNetwork.CHANNEL.sendToServer(new BeamPacket(this));
            }
            this.updatePositionAndRotation();
        }

        if (owner != null && owner.isAlive()) {
            owner.setDeltaMovement(0, owner.getDeltaMovement().y, 0);
            owner.xxa = 0.0F;
            owner.zza = 0.0F;
        }

        if (!this.level().isClientSide) {
            if (owner == null || !owner.isAlive()) {
                this.discard();
                return;
            }

            this.updatePositionAndRotation();
            Set<LivingEntity> entities = new HashSet<>();
            AABB aabb = new AABB(this.position(), this.position()).inflate(this.beamWidth);
            double distanceToDestination = beamTraceDistance(maxRaytraceDistance, 1.0f, false);
            double distanceTraveled = 0;
            while (!(this.position().distanceTo(aabb.getCenter()) > distanceToDestination)
                    && !(this.position().distanceTo(aabb.getCenter()) > maxRaytraceDistance)) {
                for (Entity entity : this.level().getEntitiesOfClass(Entity.class, aabb)) {
                    LivingEntity livingEntity = null;
                    if (entity instanceof PartEntity<?> partEntity && partEntity.getParent() instanceof LivingEntity living) {
                        livingEntity = living;
                    } else if (entity instanceof LivingEntity living) {
                        livingEntity = living;
                    }
                    if (livingEntity != null && canHitEntity(owner).test(livingEntity)) {
                        entities.add(livingEntity);
                    }
                }
                distanceTraveled += 1.0D;
                Vec3 viewVector = this.getViewVector(1.0F);
                Vec3 targetVector = this.position().add(viewVector.x * distanceTraveled, viewVector.y * distanceTraveled, viewVector.z * distanceTraveled);
                aabb = new AABB(targetVector, targetVector).inflate(this.beamWidth);
            }
            this.damageEntities(entities);
        }
    }

    public abstract void damageEntities(Set<LivingEntity> entities);

    public Predicate<LivingEntity> canHitEntity(LivingEntity living) {
        return living1 -> living1 != living && living.hasLineOfSight(living1) && living1.isAlive() && !living.isAlliedTo(living1);
    }

    public void updatePositionAndRotation() {
        LivingEntity owner = this.getOwner();
        if (owner != null) {
            Vec3 vec1 = owner.position();
            vec1 = vec1.add(this.getOffsetVector(owner));
            this.setPos(vec1.x, vec1.y, vec1.z);
            this.setYRot(boundDegrees(this.owner.getYRot()));
            this.setXRot(boundDegrees(this.owner.getXRot()));
            this.yRotO = boundDegrees(this.owner.yRotO);
            this.xRotO = boundDegrees(this.owner.xRotO);
        }
    }

    private float boundDegrees(float v) {
        return (v % 360 + 360) % 360;
    }

    private Vec3 getOffsetVector(LivingEntity living) {
        Vec3 viewVector = this.getViewVector(1.0F);
        return new Vec3(viewVector.x, living.getEyeHeight() * 0.4D, viewVector.z);
    }

    public float getBeamWidth() {
        return this.beamWidth;
    }

    public final Vec3 getWorldPosition(float partialTicks) {
        double d0 = Mth.lerp(partialTicks, this.xo, this.getX());
        double d1 = Mth.lerp(partialTicks, this.yo, this.getY());
        double d2 = Mth.lerp(partialTicks, this.zo, this.getZ());
        return new Vec3(d0, d1, d2);
    }

    public HitResult beamTraceResult(double distance, float ticks, boolean passesWater) {
        Vec3 vector3d = this.getWorldPosition(ticks);
        Vec3 vector3d1 = this.getViewVector(ticks);
        Vec3 vector3d2 = vector3d.add(vector3d1.x * distance, vector3d1.y * distance, vector3d1.z * distance);
        return this.level().clip(new ClipContext(vector3d, vector3d2, ClipContext.Block.COLLIDER, passesWater ? ClipContext.Fluid.ANY : ClipContext.Fluid.NONE, this));
    }

    public double beamTraceDistance(double distance, float ticks, boolean passesWater) {
        HitResult rayTraceResult = beamTraceResult(distance, ticks, passesWater);
        double distanceToDestination = maxRaytraceDistance;
        if (rayTraceResult instanceof BlockHitResult blockHitResult) {
            BlockPos collision = blockHitResult.getBlockPos();
            Vec3 destination = new Vec3(collision.getX(), collision.getY(), collision.getZ());
            distanceToDestination = this.position().distanceTo(destination);
        }
        return distanceToDestination;
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUUID != null) {
            if (this.level() instanceof ServerLevel serverLevel) {
                Entity entity = serverLevel.getEntity(this.ownerUUID);
                if (entity instanceof LivingEntity) {
                    this.owner = (LivingEntity) entity;
                }
            } else if (this.level().isClientSide) {
                this.owner = this.level().getPlayerByUUID(this.ownerUUID);
            }
        }
        return this.owner;
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.hasUUID("Owner")) {
            this.ownerUUID = pCompound.getUUID("Owner");
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        if (this.ownerUUID != null) {
            pCompound.putUUID("Owner", this.ownerUUID);
        }
    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        if (this.ownerUUID != null) {
            buffer.writeUUID(this.ownerUUID);
        }
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {
        this.ownerUUID = additionalData.readUUID();
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
