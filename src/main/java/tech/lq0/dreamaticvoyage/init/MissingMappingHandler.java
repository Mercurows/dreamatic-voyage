package tech.lq0.dreamaticvoyage.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.MissingMappingsEvent;
import tech.lq0.dreamaticvoyage.Utils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MissingMappingHandler {
    @SubscribeEvent
    public static void onMissingMappings(MissingMappingsEvent event) {
        remapMappings(event, Registries.ITEM, ForgeRegistries.ITEMS);
        remapMappings(event, Registries.BLOCK, ForgeRegistries.BLOCKS);
        remapMappings(event, Registries.ATTRIBUTE, ForgeRegistries.ATTRIBUTES);
        remapMappings(event, Registries.POINT_OF_INTEREST_TYPE, ForgeRegistries.POI_TYPES);
        remapMappings(event, Registries.MOB_EFFECT, ForgeRegistries.MOB_EFFECTS);
        remapMappings(event, Registries.POTION, ForgeRegistries.POTIONS);
        remapMappings(event, Registries.VILLAGER_PROFESSION, ForgeRegistries.VILLAGER_PROFESSIONS);
        remapMappings(event, Registries.BLOCK_ENTITY_TYPE, ForgeRegistries.BLOCK_ENTITY_TYPES);
        remapMappings(event, Registries.ENTITY_TYPE, ForgeRegistries.ENTITY_TYPES);
        remapMappings(event, Registries.ENCHANTMENT, ForgeRegistries.ENCHANTMENTS);
        remapMappings(event, Registries.SOUND_EVENT, ForgeRegistries.SOUND_EVENTS);

//        for (MissingMappingsEvent.Mapping<Item> mapping : event.getAllMappings(Registries.ITEM)) {
//            if ("providencraft".equals(mapping.getKey().getNamespace())) {
//                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
//
//                Item remappedResource = ForgeRegistries.ITEMS.getValue(newResourceLocation);
//
//                if (remappedResource != null) {
//                    mapping.remap(remappedResource);
//                }
//            }
//        }
//
//        for (MissingMappingsEvent.Mapping<Block> mapping : event.getAllMappings(Registries.BLOCK)) {
//            if ("providencraft".equals(mapping.getKey().getNamespace())) {
//                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
//
//                Block remappedResource = ForgeRegistries.BLOCKS.getValue(newResourceLocation);
//
//                if (remappedResource != null) {
//                    mapping.remap(remappedResource);
//                }
//            }
//        }
    }

    public static <T> void remapMappings(MissingMappingsEvent event, ResourceKey<? extends Registry<T>> resourceKey, IForgeRegistry<T> registry) {
        for (MissingMappingsEvent.Mapping<T> mapping : event.getAllMappings(resourceKey)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                T remappedResource = registry.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }
    }
}
