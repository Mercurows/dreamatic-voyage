package tech.lq0.providencraft.entity.projectile;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

public class CursedCatDollEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> FUSE = SynchedEntityData.defineId(CursedCatDollEntity.class, EntityDataSerializers.INT);
    private int fuse = 100;

    public CursedCatDollEntity(EntityType<? extends CursedCatDollEntity> type, Level world){
        super(type, world);
    }

    public CursedCatDollEntity(Level world, LivingEntity entity){
        super(EntityRegistry.CURSED_CAT_DOLL_ENTITY.get(), entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.CURSED_MARSHAIMALLOW.get();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FUSE, 80);
    }

    @Override
    public void tick() {
        super.tick();
        --this.fuse;
        if (this.fuse <= 0) {
            this.discard();
            if (!this.level().isClientSide) {
                explode(this, 10.0f);
            }
        } else {
            if (this.level().isClientSide) {
                this.level().addParticle(ParticleTypes.FIREWORK, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putShort("Fuse", (short) this.getFuse());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.setFuse(pCompound.getShort("Fuse"));
    }

    public int getFuse() {
        return fuse;
    }

    public void setFuse(int fuse) {
        this.fuse = fuse;
    }

    @Override
    protected void onHit(HitResult result) {
        if (!level().isClientSide) {
            if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockResult = (BlockHitResult) result;

                //From TaC
                Direction direction = blockResult.getDirection();
                switch (direction.getAxis()) {
                    case X -> this.setDeltaMovement(this.getDeltaMovement().multiply(-0.5, 0.75, 0.75));
                    case Y -> {
                        this.setDeltaMovement(this.getDeltaMovement().multiply(0.75, -0.25, 0.75));
                        if (this.getDeltaMovement().get(Direction.Axis.Y) < this.getGravity()) {
                            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0, 1));
                        }
                    }
                    case Z -> this.setDeltaMovement(this.getDeltaMovement().multiply(0.75, 0.75, -0.5));
                }
            } else {
                this.discard();
                explode(this, 10.0f);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        explode(this, 10.0f);
    }

    public static void explode(Entity entity, float radius) {
        Level world = entity.level();
        if (world.isClientSide()) {
            return;
        }

        Explosion explosion = new Explosion(world, entity, null, null, entity.getX(), entity.getY(), entity.getZ(), radius, false, Explosion.BlockInteraction.KEEP);

        if(net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion)) {
            return;
        }

        explosion.explode();
        explosion.finalizeExplosion(true);

        explosion.clearToBlow();

        for (ServerPlayer serverPlayer : ((ServerLevel) world).players()) {
            if (serverPlayer.distanceToSqr(entity.getX(), entity.getY(), entity.getZ()) < 4096) {
                serverPlayer.connection.send(new ClientboundExplodePacket(entity.getX(), entity.getY(), entity.getZ(), 2, explosion.getToBlow(), explosion.getHitPlayers().get(entity)));
            }
        }

        AreaEffectCloud areaEffectCloud = new AreaEffectCloud(world, entity.getX(), entity.getY(), entity.getZ());
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
        areaEffectCloud.setRadius(1.0f);
        areaEffectCloud.setDuration(180);
        areaEffectCloud.setRadiusPerTick(0.05f);

        world.addFreshEntity(areaEffectCloud);
    }
}
