package tech.lq0.providencraft;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import tech.lq0.providencraft.init.*;

@Mod(Utils.MOD_ID)
public class Utils {

    public static final String MOD_ID = "providencraft";

    public static final String PDC_ATTRIBUTE_MODIFIER = "pdc_attribute_modifier";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Utils() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        TabRegistry.TABS.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);
        EntityRegistry.ENTITY_TYPES.register(modEventBus);
        SoundRegistry.SOUNDS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Welcome to {}", MOD_ID);
    }
}
