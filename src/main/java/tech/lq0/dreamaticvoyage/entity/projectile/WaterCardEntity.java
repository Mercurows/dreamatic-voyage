package tech.lq0.dreamaticvoyage.entity.projectile;

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

import javax.annotation.Nonnull;

public class WaterCardEntity extends ThrowableItemProjectile {
    private int strength = 1;

    public WaterCardEntity(EntityType<? extends WaterCardEntity> p_i50159_1_, Level p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public WaterCardEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.WATER_CARD_ENTITY.get(), entity, world);
    }

    public WaterCardEntity(Level world, LivingEntity entity, int strength) {
        super(EntityRegistry.WATER_CARD_ENTITY.get(), entity, world);
        this.strength = strength;
    }

    public WaterCardEntity(Level p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.WATER_CARD_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity living) {
            if (this.getOwner() != null && !living.equals(this.getOwner())) {
                living.hurt(living.level().damageSources().thrown(this, this.getOwner() instanceof LivingEntity owner ? owner : null), 1.0f);
                living.knockback(this.strength, this.getX() - living.getX(), this.getZ() - living.getZ());
            }
        }
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.discard();
    }

    @Override
    @Nonnull
    protected Item getDefaultItem() {
        return ItemRegistry.DUEL_WATER_GUN.get().asItem();
    }
}
