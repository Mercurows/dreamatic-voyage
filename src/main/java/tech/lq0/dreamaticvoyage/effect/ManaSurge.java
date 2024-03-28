package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
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

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        if (source.is(DamageTypes.MAGIC) && event.getEntity().hasEffect(EffectRegistry.MANA_SURGE.get())) {
            event.setAmount(event.getAmount() / 2.0f);
        }
    }
}
