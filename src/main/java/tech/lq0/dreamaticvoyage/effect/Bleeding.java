package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Bleeding extends MobEffect {
    public Bleeding() {
        super(MobEffectCategory.HARMFUL, 11815816);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (EntityType.getKey(pLivingEntity.getType()).equals(new ResourceLocation("twilightforest:snow_queen"))) {
            return;
        }
        pLivingEntity.hurt(DamageSourceRegistry.causeBleedingDamage(pLivingEntity.level().registryAccess(), null), 0.5f);
        pLivingEntity.invulnerableTime = 0;
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        int k = 40 - pAmplifier * 10;
        if (k > 0) {
            return pDuration % k == 0;
        } else {
            return pDuration % 10 == 0;
        }
    }

    @SubscribeEvent
    public static void effects(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        MobEffect effect = EffectRegistry.BLEEDING.get();

        if (EntityType.getKey(entity.getType()).equals(new ResourceLocation("twilightforest:snow_queen"))) {
            return;
        }

        if (!event.getSource().is(DamageSourceRegistry.BLEEDING)) {
            if (entity.hasEffect(effect)) {
                entity.invulnerableTime = 0;
                int level = entity.getEffect(EffectRegistry.BLEEDING.get()).getAmplifier();

                float damage = 1.0f + level * (level + 1.0f) / 2.0f;
                entity.hurt(DamageSourceRegistry.causeBleedingDamage(entity.level().registryAccess(), event.getSource().getDirectEntity()), damage);
            }
        }
    }
}
