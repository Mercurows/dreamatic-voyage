package tech.lq0.dreamaticvoyage.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.dreamaticvoyage.client.screen.FukamizuCompressorScreen;
import tech.lq0.dreamaticvoyage.init.MenuTypeRegistry;
import tech.lq0.dreamaticvoyage.tools.AnimationTickHolder;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent event) {
        if (!isGameActive()) {
            return;
        }

        AnimationTickHolder.tick();
    }

    //From Create
    protected static boolean isGameActive() {
        return !(Minecraft.getInstance().level == null || Minecraft.getInstance().player == null);
    }

    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MenuTypeRegistry.FUKAMIZU_COMPRESSOR_MENU.get(), FukamizuCompressorScreen::new);
        });
    }
}
