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

                        gui.pose().pushPose();
                        gui.pose().scale(1.5f, 1.5f, 1.5f);
                        gui.pose().translate(-64, -30, 0);

                        // 槽
                        gui.blit(HUD, left - 44, top + 10, 0, 0, 60, 18, 64, 64);

                        // 条
                        gui.blit(HUD, left - 43, top + 18, 1, 19, (int) (45 * energy / 80f), 2, 64, 64);

                        gui.pose().popPose();

                        // 数字
                        int num1 = (int) times;
                        int num2 = (int) (times * 10) % 10;
                        int num3 = (int) (times * 100) % 10;

                        gui.blit(HUD, left - 40, top + 38, num1 * 4, 22, 3, 5, 64, 64);
                        gui.blit(HUD, left - 34, top + 38, num2 * 4, 22, 3, 5, 64, 64);
                        gui.blit(HUD, left - 30, top + 38, num3 * 4, 22, 3, 5, 64, 64);

                        // 点叉
                        gui.blit(HUD, left - 36, top + 42, 0, 30, 1, 1, 64, 64);
                        gui.blit(HUD, left - 26, top + 40, 10, 28, 3, 3, 64, 64);

                        gui.pose().popPose();
                    }
            ));
        }
    }
}
