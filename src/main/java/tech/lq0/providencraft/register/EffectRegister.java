package tech.lq0.providencraft.register;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectInit;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EffectRegister {

    //暗精灵祝福 抗火
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Effect effect = EffectInit.BLESS_OF_DARK_ELF.get();
        LivingEntity entity = event.getEntityLiving();

        if (source.getDamageType().equals("inFire") || source.getDamageType().equals("onFire") || source.getDamageType().equals("lava")) {
            if (entity.isPotionActive(effect)) {
                EffectInstance effectInstance = entity.getActivePotionEffect(effect);
                int level = effectInstance.getAmplifier();
                if (level >= 0) {
                    event.setCanceled(true);
                }
            }
        } else {
            if (entity.isPotionActive(effect)) {
                EffectInstance effectInstance = entity.getActivePotionEffect(effect);
                int level = effectInstance.getAmplifier();
                if (level >= 10) {
                    event.setAmount(0);
                } else {
                    event.setAmount(event.getAmount() * (10 - level) / 10);
                }
            }
        }

    }


}
