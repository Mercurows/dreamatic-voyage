package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public class DaifukuSyrupEntity extends ThrowableItemProjectile {
    public DaifukuSyrupEntity(EntityType<? extends DaifukuSyrupEntity> p_i50159_1_, Level p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public DaifukuSyrupEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.DAIFUKU_SYRUP_ENTITY.get(), entity, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity livingEntity && entity != this.getOwner()) {
            livingEntity.hurt(this.damageSources().mobProjectile(this, this.getOwner() instanceof LivingEntity living ? living : null), 2.5f);

            int random = (int) (Math.random() * 10 + 1);
            if (random == 1) {
                entity.setSecondsOnFire(10);
            } else {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 9), this.getOwner());
            }
        }

        if (!this.level().isClientSide) {
            this.discard();
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
        return ItemRegistry.DAIFUKU_SYRUP.get().asItem();
    }
}
