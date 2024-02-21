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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlessOfDarkElf extends MobEffect {
    public BlessOfDarkElf() {
        super(MobEffectCategory.BENEFICIAL, 1919810);
    }

    @SubscribeEvent
    public static void effects(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        MobEffect effect_bless = EffectRegistry.BLESS_OF_DARK_ELF.get();
        LivingEntity entity = event.getEntity();

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(effect_bless)) {
                int level = entity.getEffect(effect_bless).getAmplifier();
                if (source.is(DamageTypeTags.IS_FIRE)) {
                    event.setAmount(0);
                } else if (source.is(DamageTypeTags.IS_EXPLOSION)) {
                    event.setAmount(event.getAmount());
                } else {
                    int num = (level + 1) * 2;
                    event.setAmount(event.getAmount() > num ? event.getAmount() - num : 0);
                }
            }
        }
    }
}
