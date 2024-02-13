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
            CuriosApi.getCuriosInventory(player).ifPresent(inventory -> {
                inventory.findFirstCurio(ItemRegistry.YEGGY_PEARL.get()).ifPresent(
                        s -> {
                            if (player.isSpectator()) {
                                return;
                            }

                            ItemStack stack = s.stack();
                            GuiGraphics gui = event.getGuiGraphics();

                            Minecraft.getInstance().getTextureManager().bindForSetup(HUD);

                            float left = gui.guiWidth() / 2F;
                            float top = gui.guiHeight() / 2F - 20;

                            int energy = YeggyPearl.getEnergy(stack);
                            float times = YeggyPearl.getDamageTimes(energy);

                        }
                );
            });
        }
    }
}
