package tech.lq0.dreamaticvoyage.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.network.event.LivingItemBreakEvent;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "broadcastBreakEvent(Lnet/minecraft/world/entity/EquipmentSlot;)V", at = @At("RETURN"))
    public void broadcastBreakEvent(EquipmentSlot pSlot, CallbackInfo ci) {
        if ((Object) this instanceof LivingEntity living) {
            MinecraftForge.EVENT_BUS.post(new LivingItemBreakEvent(living, pSlot));
        }
    }

    @Inject(method = "broadcastBreakEvent(Lnet/minecraft/world/InteractionHand;)V", at = @At("RETURN"))
    public void broadcastBreakEvent(InteractionHand pHand, CallbackInfo ci) {
        if ((Object) this instanceof LivingEntity living) {
            MinecraftForge.EVENT_BUS.post(new LivingItemBreakEvent(living, pHand));
        }
    }

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"))
    public void addEffect(MobEffectInstance pEffectInstance, Entity pEntity, CallbackInfoReturnable<Boolean> cir) {
        CompoundTag newNBT = new CompoundTag();
        pEffectInstance.save(newNBT);
        int i = newNBT.getByte("Amplifier");
        if (pEntity instanceof LivingEntity source) {
            if (source.hasEffect(EffectRegistry.MANA_SURGE.get())) {
                int level = source.getEffect(EffectRegistry.MANA_SURGE.get()).getAmplifier();
                i = Math.min(127, i + level);
                if (!pEffectInstance.getEffect().equals(EffectRegistry.MANA_SURGE.get())) {
                    if (pEffectInstance.getEffect().getCategory() != MobEffectCategory.BENEFICIAL) {
                        LivingEntity living = (LivingEntity) (Object) this;
                        if (!living.equals(source)) {
                            newNBT.putByte("Amplifier", (byte) i);
                        }
                    } else {
                        newNBT.putByte("Amplifier", (byte) i);
                    }
                    var instance = MobEffectInstance.load(newNBT);
                    if (instance != null) {
                        pEffectInstance.update(instance);
                    }
                }
            }
        }
    }

}
