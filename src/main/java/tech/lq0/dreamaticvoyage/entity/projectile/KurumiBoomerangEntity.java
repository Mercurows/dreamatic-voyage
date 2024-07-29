package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;

import javax.annotation.Nullable;

public class KurumiBoomerangEntity extends AbstractArrow {

    private boolean dealtDamage;
    public int flyingTicks = 0;

    public KurumiBoomerangEntity(EntityType<? extends KurumiBoomerangEntity> entityType, Level level) {
        super(entityType, level);
    }

    public KurumiBoomerangEntity(Level level, LivingEntity entity) {
        super(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), entity, level);
    }

    public int getInGroundTime() {
        return this.inGroundTime;
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 1) {
            // first time hit ground
            if (!this.dealtDamage) {
                this.playSound(SoundRegistry.WHY_NOT_DIE.get(), 0.5F, 1.0F);
            }
            this.dealtDamage = true;
            this.inGroundTime++;
        } else {
            this.flyingTicks++;
        }

        super.tick();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemRegistry.KURUMI_BOOMERANG.get().getDefaultInstance();
    }

    @Nullable
    @Override
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.EMPTY;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity target = pResult.getEntity();
        if (target instanceof LivingEntity) {
            float damage = 0.8f;
            if (target instanceof Pig || target instanceof AbstractPiglin || target instanceof Zoglin ||
                    target instanceof Hoglin || target instanceof ZombifiedPiglin) {
                damage = 6.4f;
            }

            this.dealtDamage = true;
            Entity attacker = this.getOwner() == null ? this : this.getOwner();

            if (target.hurt(this.level().damageSources().thrown(this, attacker), damage)) {
                if (target.getType() == EntityType.ENDERMAN) {
                    return;
                }

                target.invulnerableTime = 0;
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        this.playSound(SoundRegistry.HOW_HOLD_BLOOD.get(), 0.5F, 1.0F);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);

        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }

    @Override
    protected float getWaterInertia() {
        return 0.99F;
    }

}
