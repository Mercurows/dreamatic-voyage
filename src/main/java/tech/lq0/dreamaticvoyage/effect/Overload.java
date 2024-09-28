package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.RandomTool;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Overload extends MobEffect {
    public Overload() {
        super(MobEffectCategory.HARMFUL, 9240571);
    }

    private static void triggerSideEffect(Player player, int num, int lvl) {
        switch (num) {
            case 0 -> player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, lvl));
            case 1 -> player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, lvl));
            case 2 -> player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, lvl));
            case 3 -> player.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, lvl));
            case 4 -> player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, lvl));
        }
    }

    @SubscribeEvent
    public static void onEffectExpired(MobEffectEvent.Expired event) {
        LivingEntity entity = event.getEntity();
        if (EffectRegistry.OVERLOAD.get().getDescriptionId().equals(event.getEffectInstance().getDescriptionId())) {
            if (entity instanceof Player player) {
                int random = (int) (Math.random() * 99 + 1);
                int lvl = event.getEffectInstance().getAmplifier();

                if (random > 20) {
                    int[] num = RandomTool.getRandom(1, 5, 2);
                    assert num != null;
                    triggerSideEffect(player, num[0], lvl);
                    triggerSideEffect(player, num[1], lvl);
                } else {
                    player.hurt(DamageSourceRegistry.causeEmotionalDamage(player.level().registryAccess(), null), 10.0f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        LivingEntity entity = event.getEntity();
        if (EffectRegistry.OVERLOAD.get().getDescriptionId().equals(event.getEffectInstance().getDescriptionId())) {
            if (entity instanceof Player player) {
                int lvl = event.getEffectInstance().getAmplifier();
                if (lvl >= 10) {
                    player.hurt(DamageSourceRegistry.causeOverloadDamage(player.level().registryAccess(), null), 300.0f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEffectRemoved(MobEffectEvent.Remove event) {
        LivingEntity entity = event.getEntity();
        MobEffectInstance effect = event.getEffectInstance();
        if (effect != null) {
            if (EffectRegistry.OVERLOAD.get().getDescriptionId().equals(event.getEffectInstance().getDescriptionId())) {
                if (entity instanceof Player player) {
                    int lvl = event.getEffectInstance().getAmplifier();
                    player.hurt(DamageSourceRegistry.causeOverloadDamage(player.level().registryAccess(), null), 5.0f * (lvl + 1));
                }
            }
        }
    }
}
