package tech.lq0.providencraft.client.render.hud;

import com.google.common.util.concurrent.AtomicDouble;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.capability.escort.IEscortCapability;
import tech.lq0.providencraft.capability.ModCapabilities;
import tech.lq0.providencraft.init.ItemRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class WorldPeaceStaffRenderer {
    private static final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/world_peace_staff_hud.png");

    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        if (player.getMainHandItem().getItem() == ItemRegistry.WORLD_PEACE_STAFF.get()) {
            if (player.isSpectator()) return;

            ItemStack item = player.getMainHandItem();
            GuiGraphics gui = event.getGuiGraphics();

            int top = gui.guiHeight() / 2 - 44;
            int left = gui.guiWidth() / 2 - 120;

            Minecraft.getInstance().getTextureManager().bindForSetup(HUD);

            AtomicDouble atValue = new AtomicDouble(0);

            LazyOptional<IEscortCapability> escortCapabilityLazyOptional = item.getCapability(ModCapabilities.ESCORT_CAPABILITY);
            escortCapabilityLazyOptional.ifPresent(s -> {
                atValue.set(s.getEscortValue());

                double value = s.getEscortValue();
                double rate = value / 500;

                int topDiff = (int) (82 - Math.round(82 * rate));
                int height = (int) Math.round(82 * rate) + 1;

                // 血
                gui.blit(HUD, left + 22, top + topDiff + 2, 10, height, 41, 2 + topDiff, 10, height, 128, 128);

                // 数字
                double tempValue = (int) (value * 10);
                int[] arr = new int[4];
                for (int i = 0; i < 4; i++) {
                    arr[i] = (int) (tempValue % 10);
                    tempValue /= 10;
                }
                for (int i = 3; i >= 0; i--) {
                    gui.blit(HUD, left + (i == 0 ? 2 : 0) + 4 * (3 - i), top + 81, 3, 5, arr[i] * 4, 88, 3, 5, 128, 128);
                }
            });

            // 槽
            gui.blit(HUD, left, top, 0, 0, 40, 88, 128, 128);

            // 兔
            if (!player.isUsingItem() || atValue.get() < 5) {
                gui.blit(HUD, left + 5, top + 37, 12, 11, 52, 1, 12, 11, 128, 128);
            }
        }
    }
}
