package tech.lq0.dreamaticvoyage.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Utils.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_ITEM_TAB = TABS.register("dmv_item_tab", () -> ModTabs.ITEM_TAB);
    public static final RegistryObject<CreativeModeTab> MOD_MISC_TAB = TABS.register("dmv_costume_tab", () -> ModTabs.MISC_TAB);
    public static final RegistryObject<CreativeModeTab> MOD_BLOCK_TAB = TABS.register("dmv_block_tab", () -> ModTabs.BLOCK_TAB);
    public static final RegistryObject<CreativeModeTab> MOD_TAPE_TAB = TABS.register("dmv_tape_tab", () -> ModTabs.TAPE_TAB);

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }

}
