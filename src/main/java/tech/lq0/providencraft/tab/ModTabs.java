package tech.lq0.providencraft.tab;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.init.ItemRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModTabs {
    private static final List<RegistryObject<Item>> HIDDEN = new ArrayList<>();

    static {
    }

    public static CreativeModeTab PDC_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.Providencraft Items"))
            .icon(() -> new ItemStack(ItemRegistry.RED_AHOGE.get()))
            .displayItems((param, output) -> ItemRegistry.ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();
}
