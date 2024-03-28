package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SweetMirage extends MobEffect {
    public SweetMirage() {
        super(MobEffectCategory.BENEFICIAL, 0xA98880);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        LivingEntity living = event.getEntity();
        if (!source.is(DamageTypeTags.BYPASSES_ARMOR) && living.hasEffect(EffectRegistry.SWEET_MIRAGE.get())) {
            Random random = new Random();
            int level = living.getEffect(EffectRegistry.SWEET_MIRAGE.get()).getAmplifier() + 1;
            double chance = -9.0 / (0.5 * (double)level + 1.0) + 9.0;
            if (random.nextDouble() < chance / 10.0) {
                event.setAmount(0);
                living.heal(level * 2);
            }
        }
    }
}
