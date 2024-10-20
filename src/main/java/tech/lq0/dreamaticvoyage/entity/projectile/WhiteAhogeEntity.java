package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public class WhiteAhogeEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(WhiteAhogeEntity.class, EntityDataSerializers.INT);
    private int life = 600;

    public WhiteAhogeEntity(EntityType<? extends WhiteAhogeEntity> p_i50159_1_, Level p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public WhiteAhogeEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.WHITE_AHOGE_ENTITY.get(), entity, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LIFE, 600);
    }

    @Override
    public void tick() {
        super.tick();

        Vec3 vec = this.getDeltaMovement();
        this.setDeltaMovement(vec.scale(1 / 0.99));

        --this.life;
        if (this.life <= 0) {
            this.discard();
        }
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.hurt(this.damageSources().explosion(this, this.getOwner() instanceof LivingEntity living ? living : null), 8.0f);
            livingEntity.addEffect(new MobEffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 100, 0), this.getOwner());
        }

        if (!this.level().isClientSide) {
            this.discard();
        } else {
            level().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY() + 0.1D, this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.WHITE_AHOGE.get().asItem();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putShort("Life", (short) this.getLife());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.setLife(pCompound.getShort("Life"));
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
