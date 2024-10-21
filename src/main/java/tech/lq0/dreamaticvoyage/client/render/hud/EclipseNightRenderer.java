package tech.lq0.dreamaticvoyage.client.render.hud;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class EclipseNightRenderer {
    private static final ResourceLocation HUD = Utils.loc("textures/gui/eclipse_night_hud.png");
    private static final ResourceLocation HUD2 = new ResourceLocation("textures/misc/nausea.png");

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onRenderGui(RenderGuiEvent.Pre event) {
        if (Minecraft.getInstance().player == null) {
            return;
        }
        Player player = Minecraft.getInstance().player;
        if (Minecraft.getInstance().player.hasEffect(EffectRegistry.ECLIPSE_NIGHT.get())) {
            GuiGraphics gui = event.getGuiGraphics();

            int width = gui.guiWidth();
            int height = gui.guiHeight();
            int level = Math.min(5, player.getEffect(EffectRegistry.ECLIPSE_NIGHT.get()).getAmplifier() + 1);

            // 红色效果
            gui.pose().pushPose();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();

            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            gui.setColor(0.1F * level, 0.0F, 0.02F * level, 1.0F);

            gui.blit(HUD2, 0, 0, -88, 0, 0, width, height, width, height);
            gui.setColor(1.0F, 1.0F, 1.0F, 1.0F);

            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();

            gui.pose().popPose();

            // 血丝效果
            gui.pose().pushPose();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                    GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

            gui.setColor(1.0F, 1.0F, 1.0F, level * 0.2F);
            Minecraft.getInstance().getTextureManager().bindForSetup(HUD);
            gui.blit(HUD, 0, 0, -89, 0, 0, width, height, width, height);
            gui.setColor(1.0F, 1.0F, 1.0F, 1.0F);

            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            gui.pose().popPose();
        }
    }
}
