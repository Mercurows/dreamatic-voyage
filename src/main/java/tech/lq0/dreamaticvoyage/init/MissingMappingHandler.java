package tech.lq0.dreamaticvoyage.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import tech.lq0.dreamaticvoyage.Utils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MissingMappingHandler {
    @SubscribeEvent
    public static void onMissingMappings(MissingMappingsEvent event) {
        for (MissingMappingsEvent.Mapping<Item> mapping : event.getAllMappings(Registries.ITEM)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                Item remappedResource = ForgeRegistries.ITEMS.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<Block> mapping : event.getAllMappings(Registries.BLOCK)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                Block remappedResource = ForgeRegistries.BLOCKS.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<Enchantment> mapping : event.getAllMappings(Registries.ENCHANTMENT)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                Enchantment remappedResource = ForgeRegistries.ENCHANTMENTS.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<SoundEvent> mapping : event.getAllMappings(Registries.SOUND_EVENT)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                SoundEvent remappedResource = ForgeRegistries.SOUND_EVENTS.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<BlockEntityType<?>> mapping : event.getAllMappings(Registries.BLOCK_ENTITY_TYPE)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                BlockEntityType<?> remappedResource = ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<EntityType<?>> mapping : event.getAllMappings(Registries.ENTITY_TYPE)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                EntityType<?> remappedResource = ForgeRegistries.ENTITY_TYPES.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<Attribute> mapping : event.getAllMappings(Registries.ATTRIBUTE)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                Attribute remappedResource = ForgeRegistries.ATTRIBUTES.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<PoiType> mapping : event.getAllMappings(Registries.POINT_OF_INTEREST_TYPE)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                PoiType remappedResource = ForgeRegistries.POI_TYPES.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<MobEffect> mapping : event.getAllMappings(Registries.MOB_EFFECT)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                MobEffect remappedResource = ForgeRegistries.MOB_EFFECTS.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<Potion> mapping : event.getAllMappings(Registries.POTION)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                Potion remappedResource = ForgeRegistries.POTIONS.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }

        for (MissingMappingsEvent.Mapping<VillagerProfession> mapping : event.getAllMappings(Registries.VILLAGER_PROFESSION)) {
            if ("providencraft".equals(mapping.getKey().getNamespace())) {
                ResourceLocation newResourceLocation = new ResourceLocation(Utils.MOD_ID, mapping.getKey().getPath());
                VillagerProfession remappedResource = ForgeRegistries.VILLAGER_PROFESSIONS.getValue(newResourceLocation);
                if (remappedResource != null) {
                    mapping.remap(remappedResource);
                }
            }
        }
    }
}
