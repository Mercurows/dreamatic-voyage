package tech.lq0.providencraft.entity.projectile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

public class BloodCrystalEntity extends ThrowableItemProjectile {
    public BloodCrystalEntity(EntityType<? extends BloodCrystalEntity> p_i50159_1_, Level p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public BloodCrystalEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.BLOOD_CRYSTAL_ENTITY.get(), entity, world);
    }

    public BloodCrystalEntity(Level p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.BLOOD_CRYSTAL_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity instanceof Player player) {
                Entity shooter = this.getOwner();
                if (shooter != null) {
                    if (player.getTeam() == shooter.getTeam()) {
                        player.heal(4.0f);
                    } else if (player.getTeam() == null && shooter.getTeam() == null) {
                        player.heal(4.0f);
                    } else {
                        player.hurt(DamageSourceRegistry.causeBloodCrystalDamage(this.level().registryAccess(), this.getOwner()), 4.0f);
                        player.invulnerableTime = 0;
                    }
                } else {
                    player.hurt(DamageSourceRegistry.causeBloodCrystalDamage(this.level().registryAccess(), this.getOwner()), 4.0f);
                    player.invulnerableTime = 0;
                }
            } else {
                entity.hurt(DamageSourceRegistry.causeBloodCrystalDamage(this.level().registryAccess(), this.getOwner()), 4.0f);
                entity.invulnerableTime = 0;
            }
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
        return ItemRegistry.WORLD_PEACE_STAFF.get().asItem();
    }
}
