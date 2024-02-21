package tech.lq0.dreamaticvoyage.tab;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.TabRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModTabs {
    private static final List<RegistryObject<Item>> HIDDEN = new ArrayList<>();

    static {
    }

    public static CreativeModeTab PDC_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_items_tab"))
            .icon(() -> new ItemStack(ItemRegistry.RED_AHOGE.get()))
            .displayItems((param, output) -> ItemRegistry.ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();

    public static CreativeModeTab PDC_BLOCK_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_blocks_tab"))
            .withTabsBefore(TabRegistry.PDC_TAB.getKey())
            .icon(() -> new ItemStack(ItemRegistry.BLUE_SAND.get()))
            .displayItems((param, output) -> ItemRegistry.BLOCK_ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();

    public static CreativeModeTab PDC_COSTUME_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_costumes_tab"))
            .withTabsBefore(TabRegistry.PDC_BLOCK_TAB.getKey())
            .icon(() -> new ItemStack(ItemRegistry.CHIRAM_IDOL_CHESTPLATE.get()))
            .displayItems((param, output) -> ItemRegistry.COSTUMES.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();

    public static CreativeModeTab PDC_TAPE_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_tapes_tab"))
            .withTabsBefore(TabRegistry.PDC_COSTUME_TAB.getKey())
            .icon(() -> new ItemStack(ItemRegistry.MUSIC_DISC_AROUND_THE_TRAVEL.get()))
            .displayItems((param, output) -> ItemRegistry.AUDIO_ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();

    public static CreativeModeTab PDC_DONATE_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dreamaticvoyage_donate_tab"))
            .withTabsBefore(TabRegistry.PDC_TAPE_TAB.getKey())
            .icon(() -> new ItemStack(ItemRegistry.LAVA_CAKE.get()))
            .displayItems((param, output) -> ItemRegistry.DONATE_ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();
}
