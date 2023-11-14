package tech.lq0.providencraft.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.item.providencefirst.madoka.RedAhoge;
import tech.lq0.providencraft.item.providencesecond.lucia.MoonlightAmulet;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> RED_AHOGE = ITEMS.register("red_ahoge", RedAhoge::new);

    public static final RegistryObject<Item> MOONLIGHT_AMULET = ITEMS.register("moonlight_amulet", MoonlightAmulet::new);
}
