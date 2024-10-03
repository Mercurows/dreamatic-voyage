package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.Set;

public class WhiteAhogeBeamEntity extends BeamEntity {

    public WhiteAhogeBeamEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void damageEntities(Set<LivingEntity> entities) {

    }
}
