package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.menu.FukamizuCompressorMenu;

public class MenuTypeRegistry {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Utils.MOD_ID);

    public static final RegistryObject<MenuType<FukamizuCompressorMenu>> FUKAMIZU_COMPRESSOR_MENU =
            MENU_TYPES.register("fukamizu_compressor_menu",
                    () -> IForgeMenuType.create((windowId, inv, data) -> new FukamizuCompressorMenu(windowId, inv)));
}