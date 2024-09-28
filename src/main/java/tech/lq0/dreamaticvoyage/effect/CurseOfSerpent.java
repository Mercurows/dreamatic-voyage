package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.ModTags;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CurseOfSerpent extends MobEffect {
    public CurseOfSerpent() {
        super(MobEffectCategory.HARMFUL, 7324312);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        MobEffect mobEffect = EffectRegistry.CURSE_OF_SERPENT.get();
        LivingEntity entity = event.getEntity();

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(mobEffect)) {
                int level = entity.getEffect(mobEffect).getAmplifier() + 1;
                if (source.is(ModTags.DamageTypes.CURSED_EXPLOSION)) {
                    event.setAmount(event.getAmount() * (1 + level));
                }
            }
        }
    }
}
