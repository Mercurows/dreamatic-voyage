package tech.lq0.dreamaticvoyage.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

@Mixin(Slot.class)
public class SlotMixin {

    @Inject(method = "mayPickup(Lnet/minecraft/world/entity/player/Player;)Z", at = @At("HEAD"), cancellable = true)
    public void mayPickup(Player pPlayer, CallbackInfoReturnable<Boolean> cir) {
        if ((Object) this instanceof ResultSlot) {
            if (pPlayer.hasEffect(EffectRegistry.CREATIVITY_BANKRUPTCY.get())) {
                cir.setReturnValue(false);
            }
        }
    }

}
