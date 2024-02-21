package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;

import java.util.UUID;

public class EclipseNight extends MobEffect {
    public EclipseNight() {
        super(MobEffectCategory.BENEFICIAL, 0xFC96A1);
        addAttributeModifier(Attributes.ATTACK_SPEED, new UUID(Livers.SORAYO.hashCode(), 0).toString(), 0.08F, AttributeModifier.Operation.MULTIPLY_TOTAL);
        addAttributeModifier(Attributes.ATTACK_DAMAGE, new UUID(Livers.SORAYO.hashCode() + 0xFC96A1, 0).toString(), 1.0f, AttributeModifier.Operation.ADDITION);
    }

    @SubscribeEvent
    public static void entityHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        MobEffect effect = EffectRegistry.ECLIPSE_NIGHT.get();
        LivingEntity entity = event.getEntity();

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(effect)) {
                if (source.is(DamageSourceRegistry.SORAYO)) {
                    event.setAmount(event.getAmount() / 2.0f);
                }
            }
        }
    }
}
