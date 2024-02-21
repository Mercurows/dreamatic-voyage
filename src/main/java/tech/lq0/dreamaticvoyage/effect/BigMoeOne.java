package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BigMoeOne extends MobEffect {
    public BigMoeOne() {
        super(MobEffectCategory.NEUTRAL, 15984600);
    }

    @SubscribeEvent
    public static void effects(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        MobEffect effect = EffectRegistry.BIG_MOE_ONE.get();
        if (entity.hasEffect(effect)) {
            ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.RED_AHOGE_HELMET.get())) {
                event.setAmount(event.getAmount() * 0.8f);
            } else {
                event.setAmount(event.getAmount() * 1.5f);
            }
        }
    }
}
