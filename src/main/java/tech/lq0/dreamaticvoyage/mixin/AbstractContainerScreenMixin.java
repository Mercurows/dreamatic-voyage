package tech.lq0.dreamaticvoyage.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin {

    @Inject(method = "renderSlot(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;)V", at = @At("RETURN"))
    private void renderSlot(GuiGraphics pGuiGraphics, Slot pSlot, CallbackInfo ci) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        if (pSlot instanceof ResultSlot slot) {
            if (player.hasEffect(EffectRegistry.CREATIVITY_BANKRUPTCY.get())) {
                pGuiGraphics.blit(new ResourceLocation(Utils.MOD_ID, "textures/gui/cross.png"),
                        slot.x, slot.y, 500, 0, 0, 16, 16, 16, 16);
            }
        }
    }

}
