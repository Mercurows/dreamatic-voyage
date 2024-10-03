package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;

import java.util.Set;

public class WhiteAhogeBeamEntity extends BeamEntity {
    public float damage = 2f;

    public WhiteAhogeBeamEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public WhiteAhogeBeamEntity(Level level, LivingEntity owner) {
        super(EntityRegistry.WHITE_AHOGE_BEAM_ENTITY.get(), level);
        this.setOwner(owner);
    }

    public WhiteAhogeBeamEntity damage(float damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public void damageEntities(Set<LivingEntity> entities) {
        for (LivingEntity entity : entities) {
            entity.invulnerableTime = 0;
            Vec3 deltaMovement = entity.getDeltaMovement();
            entity.hurt(entity.damageSources().indirectMagic(owner, owner), this.damage);
            entity.setDeltaMovement(deltaMovement);
        }

        this.discard();
    }
}
