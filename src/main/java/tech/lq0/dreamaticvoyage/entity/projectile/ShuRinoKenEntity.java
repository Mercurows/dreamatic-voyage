package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import javax.annotation.Nonnull;

public class ShuRinoKenEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> MAX_TIME = SynchedEntityData.defineId(ShuRinoKenEntity.class, EntityDataSerializers.INT);
    private int maxTime = 200;

    public ShuRinoKenEntity(EntityType<? extends ShuRinoKenEntity> p_i50159_1_, Level p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public ShuRinoKenEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.SHU_RINO_KEN_ENTITY.get(), entity, world);
    }

    public ShuRinoKenEntity(Level p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.SHU_RINO_KEN_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.hurt(this.level().damageSources().thrown(this, this.getOwner()), 6.0f);
            livingEntity.invulnerableTime = 0;
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MAX_TIME, 200);
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putShort("MaxTime", (short) this.getMaxTime());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.setMaxTime(pCompound.getShort("MaxTime"));
    }

    @Override
    public void tick() {
        super.tick();
        --this.maxTime;
        if (this.getMaxTime() <= 0) {
            this.discard();
        } else {
            if (this.level().isClientSide) {
                this.level().addParticle(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    @Override
    @Nonnull
    protected Item getDefaultItem() {
        return ItemRegistry.SHU_RINO_KEN.get().asItem();
    }
}
