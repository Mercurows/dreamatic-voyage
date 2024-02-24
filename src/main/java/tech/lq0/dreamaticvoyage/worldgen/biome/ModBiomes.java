package tech.lq0.dreamaticvoyage.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import tech.lq0.dreamaticvoyage.Utils;

public class ModBiomes {
    public static final ResourceKey<Biome> BLUE_DESERT = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Utils.MOD_ID, "blue_desert"));
    public static final ResourceKey<Biome> HARANO_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Utils.MOD_ID, "harano_plains"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(BLUE_DESERT, blueDesertBiome(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER)));
        context.register(HARANO_PLAINS, haranoPlainsBiome(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER)));
    }

    public static Biome blueDesertBiome(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects biomeAmbience = (new BiomeSpecialEffects.Builder())
                .skyColor(0x7cb8ff)
                .fogColor(0xc0d8ff)
                .waterColor(0x90f2f6)
                .waterFogColor(0x050533)
                .grassColorOverride(0x8ea6f2)
                .foliageColorOverride(0x869eea)
                .build();

        MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.caveSpawns(spawnInfo);

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);

        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDesertVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDesertExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addDesertExtraDecoration(generationSettings);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(2.0f)
                .mobSpawnSettings(spawnInfo.build())
                .generationSettings(generationSettings.build())
                .specialEffects(biomeAmbience)
                .build();
    }

    public static Biome haranoPlainsBiome(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects biomeAmbience = (new BiomeSpecialEffects.Builder())
                .skyColor(0x83bcff)
                .fogColor(0xc0d8ff)
                .waterColor(0x4ca0e8)
                .waterFogColor(0x050533)
                .grassColorOverride(0xfbb671)
                .foliageColorOverride(0xfbd269)
                .build();

        MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnInfo);

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);

        BiomeDefaultFeatures.addPlainGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);

        //TODO 添加原野木的生成

        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_PLAINS);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(1.4f)
                .mobSpawnSettings(spawnInfo.build())
                .generationSettings(generationSettings.build())
                .specialEffects(biomeAmbience)
                .build();
    }
}
