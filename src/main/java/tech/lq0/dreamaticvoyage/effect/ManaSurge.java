package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ManaSurge extends MobEffect {
    public ManaSurge() {
        super(MobEffectCategory.BENEFICIAL, 0xAF9CFB);
    }

    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        LivingEntity living = event.getEntity();
        if (event.getEffectSource() instanceof LivingEntity source) {
            if (source.hasEffect(EffectRegistry.MANA_SURGE.get())) {
                MobEffectInstance instance = event.getEffectInstance();
                if (instance.getEffect().equals(EffectRegistry.MANA_SURGE.get())) {
                    return;
                }

                if (instance.getEffect().getCategory() != MobEffectCategory.BENEFICIAL) {
                    if (!living.equals(source)) {
                        living.removeEffect(instance.getEffect());
                        living.addEffect(new MobEffectInstance(
                                instance.getEffect(), instance.getDuration(), instance.getAmplifier() + 1,
                                instance.isAmbient(), instance.isVisible(), instance.showIcon()), null);
                    }
                } else {
                    living.removeEffect(instance.getEffect());
                    living.addEffect(new MobEffectInstance(
                            instance.getEffect(), instance.getDuration(), instance.getAmplifier() + 1,
                            instance.isAmbient(), instance.isVisible(), instance.showIcon()), null);
                }
            }
        }
    }
}
