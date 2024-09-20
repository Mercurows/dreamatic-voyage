package tech.lq0.dreamaticvoyage.init;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.dreamaticvoyage.gui.screen.CrystalPopperScreen;
import tech.lq0.dreamaticvoyage.gui.screen.FukamizuCompressorScreen;
import tech.lq0.dreamaticvoyage.gui.screen.PhantasmalVoyagerScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ScreenRegistry {

    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MenuTypeRegistry.FUKAMIZU_COMPRESSOR_MENU.get(), FukamizuCompressorScreen::new);
            MenuScreens.register(MenuTypeRegistry.PHANTASMAL_VOYAGER_MENU.get(), PhantasmalVoyagerScreen::new);
            MenuScreens.register(MenuTypeRegistry.CRYSTAL_POPPER_MENU.get(), CrystalPopperScreen::new);
        });
    }
}
