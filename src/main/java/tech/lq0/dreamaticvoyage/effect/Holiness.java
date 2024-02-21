package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Holiness extends MobEffect {
    public Holiness() {
        super(MobEffectCategory.BENEFICIAL, 16777159);
    }

    @SubscribeEvent
    public static void onHolinessHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        MobEffect effect = EffectRegistry.HOLINESS.get();
        LivingEntity entity = event.getEntity();

        Entity enemy = source.getDirectEntity();

        if (entity instanceof Player player && !entity.level().isClientSide) {
            if (player.hasEffect(effect)) {
                int level = player.getEffect(effect).getAmplifier();
                if (enemy instanceof LivingEntity enemyL) {
                    if (enemyL.getMobType() == MobType.UNDEAD) {
                        float damage = event.getAmount() - (level + 1) * 3;
                        event.setAmount(damage > 0 ? damage : 1.0f);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onHolinessAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        MobEffect effect = EffectRegistry.HOLINESS.get();
        Entity entity = event.getTarget();

        if (!player.level().isClientSide && player.hasEffect(effect)) {
            int level = player.getEffect(effect).getAmplifier();
            if (entity instanceof LivingEntity entity1) {
                if (entity1.getMobType() == MobType.UNDEAD) {
                    entity1.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, level, true, false));
                    entity1.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, level));
                }
            }
        }
    }
}
