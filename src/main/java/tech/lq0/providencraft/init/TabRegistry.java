package tech.lq0.providencraft.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tab.ModTabs;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Utils.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PDC_TAB = TABS.register("pdc_tab", () -> ModTabs.PDC_TAB);
    public static final RegistryObject<CreativeModeTab> PDC_BLOCK_TAB = TABS.register("pdc_block_tab", () -> ModTabs.PDC_BLOCK_TAB);
    public static final RegistryObject<CreativeModeTab> PDC_COSTUME_TAB = TABS.register("pdc_costume_tab", () -> ModTabs.PDC_COSTUME_TAB);
    public static final RegistryObject<CreativeModeTab> PDC_TAPE_TAB = TABS.register("pdc_tape_tab", () -> ModTabs.PDC_TAPE_TAB);
    public static final RegistryObject<CreativeModeTab> PDC_DONATE_TAB = TABS.register("pdc_donate_tab", () -> ModTabs.PDC_DONATE_TAB);
}
