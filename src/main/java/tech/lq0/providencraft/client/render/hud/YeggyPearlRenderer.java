package tech.lq0.providencraft.client.render.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providenceOI.yesa.YeggyPearl;
import tech.lq0.providencraft.tools.RenderTool;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class YeggyPearlRenderer {
    private static final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/yeggy_pearl_hud.png");

    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent.Pre event) {
        Player player = Minecraft.getInstance().player;

        if (player != null) {
            CuriosApi.getCuriosInventory(player).ifPresent(inventory -> inventory.findFirstCurio(ItemRegistry.YEGGY_PEARL.get()).ifPresent(
                    s -> {
                        if (player.isSpectator()) {
                            return;
                        }

                        ItemStack stack = s.stack();
                        GuiGraphics gui = event.getGuiGraphics();

                        gui.pose().pushPose();
                        Minecraft.getInstance().getTextureManager().bindForSetup(HUD);

                        int left = gui.guiWidth() / 2;
                        int top = gui.guiHeight() / 2;

                        int energy = YeggyPearl.getEnergy(stack);
                        float times = YeggyPearl.getDamageTimes(energy);

                        // 槽
                        RenderTool.preciseBlit(gui, HUD, left - 48, top + 20, 3, 0, 96, 27, 96, 96);

                        // 条
                        //TODO 修复条的渲染
                        RenderTool.preciseBlit(gui, HUD, left - 48, top + 35, 6f, 28.5f, (45f * energy / 80f) * 1.5f, 3, 96, 96);
//                        gui.blit(HUD, left - 46, top + 22, 4.5f, 28.5f, (int) (45 * energy / 80f * 1.5f), 3, 96, 96);

                        // 数字
                        int num1 = (int) times;
                        int num2 = (int) (times * 10) % 10;
                        int num3 = (int) (times * 100) % 10;

                        gui.blit(HUD, left - 44, top + 24, num1 * 4 + 4, 22, 3, 5, 64, 64);
                        gui.blit(HUD, left - 38, top + 24, num2 * 4 + 4, 22, 3, 5, 64, 64);
                        gui.blit(HUD, left - 34, top + 24, num3 * 4 + 4, 22, 3, 5, 64, 64);

                        // 点叉
                        gui.blit(HUD, left - 40, top + 28, 8, 30, 1, 1, 64, 64);
                        gui.blit(HUD, left - 30, top + 26, 18, 28, 3, 3, 64, 64);

                        gui.pose().popPose();
                    }
            ));
        }
    }
}
