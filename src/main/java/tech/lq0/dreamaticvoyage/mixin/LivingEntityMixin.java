package tech.lq0.dreamaticvoyage.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
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

}
