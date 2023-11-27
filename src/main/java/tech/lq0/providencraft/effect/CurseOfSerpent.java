package tech.lq0.providencraft.effect;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CurseOfSerpent extends MobEffect {
    public CurseOfSerpent() {
        super(MobEffectCategory.HARMFUL, 7324312);
    }

    @SubscribeEvent
    public static void effects(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        MobEffect effect_curse = EffectRegistry.CURSE_OF_SERPENT.get();
        LivingEntity entity = event.getEntity();

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(effect_curse)) {
                int level = entity.getEffect(effect_curse).getAmplifier() + 1;
                if (source.is(DamageTypeTags.IS_EXPLOSION)) {
                    event.setAmount(event.getAmount() * (1 + level));
                }
            }
        }
    }
}
