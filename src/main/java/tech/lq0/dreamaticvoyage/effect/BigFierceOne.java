package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BigFierceOne extends MobEffect {
    public BigFierceOne() {
        super(MobEffectCategory.BENEFICIAL, 9871020);
    }

    @SubscribeEvent
    public static void effects(AttackEntityEvent event) {
        Player player = event.getEntity();
        Entity target = event.getTarget();
        if (!player.level().isClientSide && target instanceof LivingEntity entity) {
            if (player.hasEffect(EffectRegistry.BIG_FIERCE_ONE.get())) {
                int level = player.getEffect(EffectRegistry.BIG_FIERCE_ONE.get()).getAmplifier();
                target.setSecondsOnFire(level * 5);
                if (target.isAlive()) {
                    entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300, 0, true, false));
                    entity.knockback(level, player.getX() - entity.getX(), player.getZ() - entity.getZ());
                }
            }
        }
    }
}
