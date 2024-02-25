package tech.lq0.dreamaticvoyage.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tab.ModTabs;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Utils.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = TABS.register("dmv_tab", () -> ModTabs.MOD_TAB);
    public static final RegistryObject<CreativeModeTab> MOD_BLOCK_TAB = TABS.register("dmv_block_tab", () -> ModTabs.MOD_BLOCK_TAB);
    public static final RegistryObject<CreativeModeTab> MOD_COSTUME_TAB = TABS.register("dmv_costume_tab", () -> ModTabs.MOD_COSTUME_TAB);
    public static final RegistryObject<CreativeModeTab> MOD_TAPE_TAB = TABS.register("dmv_tape_tab", () -> ModTabs.MOD_TAPE_TAB);
    public static final RegistryObject<CreativeModeTab> MOD_DONATE_TAB = TABS.register("dmv_donate_tab", () -> ModTabs.MOD_DONATE_TAB);
}
