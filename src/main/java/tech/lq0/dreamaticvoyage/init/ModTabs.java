package tech.lq0.dreamaticvoyage.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ModTabs {
    private static final List<RegistryObject<Item>> HIDDEN = new ArrayList<>();

    static {
        HIDDEN.add(ItemRegistry.SUSPICIOUS_BLUE_SAND);
    }

    public static CreativeModeTab ITEM_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_items_tab"))
            .icon(() -> new ItemStack(ItemRegistry.RED_AHOGE.get()))
            .displayItems((param, output) -> ItemRegistry.ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .withSearchBar()
            .build();

    public static CreativeModeTab MISC_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_misc_tab"))
            .withTabsBefore(TabRegistry.MOD_ITEM_TAB.getKey())
            .icon(() -> new ItemStack(ItemRegistry.LAVA_CAKE.get()))
            .displayItems((param, output) -> ItemRegistry.MISC_ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .withSearchBar()
            .build();


    public static CreativeModeTab BLOCK_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_blocks_tab"))
            .withTabsBefore(TabRegistry.MOD_MISC_TAB.getKey())
            .icon(() -> new ItemStack(ItemRegistry.BLUE_SAND.get()))
            .displayItems((param, output) -> ItemRegistry.BLOCK_ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();

    public static CreativeModeTab TAPE_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_tapes_tab"))
            .withTabsBefore(TabRegistry.MOD_BLOCK_TAB.getKey())
            .icon(() -> new ItemStack(ItemRegistry.MUSIC_DISC_AROUND_THE_TRAVEL.get()))
            .displayItems((param, output) -> ItemRegistry.AUDIO_ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();
}
