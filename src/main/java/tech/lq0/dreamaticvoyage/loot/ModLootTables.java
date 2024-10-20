package tech.lq0.dreamaticvoyage.loot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import tech.lq0.dreamaticvoyage.Utils;

import java.util.function.Consumer;

// From Botania
public final class ModLootTables {

    public static final ResourceLocation DMV_CHEST = Utils.loc("chests/dmv_chest");
    public static final ResourceLocation DMV_DISC_CHEST = Utils.loc("chests/dmv_disc_chest");
    public static final ResourceLocation DMV_IGLOO_CHEST = Utils.loc("chests/dmv_igloo_chest");
    public static final ResourceLocation DMV_ELF_CHEST = Utils.loc("chests/dmv_elf_chest");
    public static final ResourceLocation DMV_BURIED_CHEST = Utils.loc("chests/dmv_buried_chest");
    public static final ResourceLocation DMV_SHIPWRECK_CHEST = Utils.loc("chests/dmv_shipwreck_chest");

    public static void lootLoad(ResourceLocation id, Consumer<LootPool.Builder> addPool) {
        String prefix = "minecraft:chests/";
        String name = id.toString();

        if (name.startsWith(prefix)) {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch (file) {
                case "abandoned_mineshaft", "desert_pyramid", "simple_dungeon" -> addPool.accept(inject(DMV_CHEST));
                case "jungle_temple", "woodland_mansion" -> addPool.accept(inject(DMV_ELF_CHEST));
                case "end_city_treasure" -> addPool.accept(inject(DMV_DISC_CHEST));
                case "igloo_chest" -> addPool.accept(inject(DMV_IGLOO_CHEST));
                case "buried_treasure" -> addPool.accept(inject(DMV_BURIED_CHEST));
                case "shipwreck_supply", "shipwreck_map", "shipwreck_treasure" ->
                        addPool.accept(inject(DMV_SHIPWRECK_CHEST));
                default -> {
                }
            }
        }
    }

    private static LootPool.Builder inject(ResourceLocation entryName) {
        return LootPool.lootPool().add(getInjectEntry(entryName));
    }

    private static LootPoolEntryContainer.Builder<?> getInjectEntry(ResourceLocation name) {
        return LootTableReference.lootTableReference(name).setWeight(1);
    }
}
