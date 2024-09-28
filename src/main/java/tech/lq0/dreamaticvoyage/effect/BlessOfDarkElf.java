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
import tech.lq0.dreamaticvoyage.tools.ModTags;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlessOfDarkElf extends MobEffect {
    public BlessOfDarkElf() {
        super(MobEffectCategory.BENEFICIAL, 1919810);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        MobEffect mobEffect = EffectRegistry.BLESS_OF_DARK_ELF.get();
        LivingEntity entity = event.getEntity();

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(mobEffect)) {
                int level = entity.getEffect(mobEffect).getAmplifier();
                if (source.is(DamageTypeTags.IS_FIRE)) {
                    event.setAmount(0);
                } else if (!source.is(ModTags.DamageTypes.CURSED_EXPLOSION)) {
                    int num = (level + 1) * 2;
                    event.setAmount(event.getAmount() > num ? event.getAmount() - num : 0);
                }
            }
        }
    }
}
