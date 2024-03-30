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

public class TetrisIBlockEntity extends ThrowableItemProjectile {
    public TetrisIBlockEntity(EntityType<? extends TetrisIBlockEntity> p_i50159_1_, Level p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public TetrisIBlockEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.TETRIS_I_BLOCK_ENTITY.get(), entity, world);
    }

    public TetrisIBlockEntity(Level p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.TETRIS_I_BLOCK_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.hurt(this.damageSources().thrown(this, this.getOwner() instanceof LivingEntity living ? living : null), 10.0f);
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
        return ItemRegistry.TETRIS_CAT.get().asItem();
    }
}
