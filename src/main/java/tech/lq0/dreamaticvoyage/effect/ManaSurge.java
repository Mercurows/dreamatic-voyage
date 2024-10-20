package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.ModTags;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ManaSurge extends MobEffect {
    public ManaSurge() {
        super(MobEffectCategory.BENEFICIAL, 0xAF9CFB);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        if (source.is(ModTags.DamageTypes.MAGIC_CAN_BE_ENHANCED) && event.getEntity().hasEffect(EffectRegistry.MANA_SURGE.get())) {
            var instance = event.getEntity().getEffect(EffectRegistry.MANA_SURGE.get());
            assert instance != null;
            event.setAmount((float) (event.getAmount() * (0.1 + 9 / (5 * Math.pow(2, instance.getAmplifier() + 1.5)))));
        }
    }
}
