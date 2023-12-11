//package tech.lq0.providencraft.worldgen.biome;
//
//import net.minecraft.core.HolderGetter;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.data.worldgen.BiomeDefaultFeatures;
//import net.minecraft.data.worldgen.BootstapContext;
//import net.minecraft.data.worldgen.placement.VegetationPlacements;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.biome.BiomeGenerationSettings;
//import net.minecraft.world.level.biome.BiomeSpecialEffects;
//import net.minecraft.world.level.biome.MobSpawnSettings;
//import net.minecraft.world.level.levelgen.GenerationStep;
//import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import tech.lq0.providencraft.Utils;
//
//public class ModBiomes {
//    public static final ResourceKey<Biome> BLUE_DESERT = ResourceKey.create(Registries.BIOME,
//            new ResourceLocation(Utils.MOD_ID, "blue_desert"));
//
//    public static void boostrap(BootstapContext<Biome> context) {
//        context.register(BLUE_DESERT, blueDesertBiome(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER)));
//    }
//
//    public static Biome blueDesertBiome(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//        BiomeSpecialEffects biomeAmbience = (new BiomeSpecialEffects.Builder())
//                .skyColor(0x7cb8ff)
//                .fogColor(0xc0d8ff)
//                .waterColor(0x90f2f6)
//                .waterFogColor(0x050533)
//                .grassColorOverride(0x8ea6f2)
//                .foliageColorOverride(0x869eea)
//                .build();
//
//        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//
//        generationSettings
//                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_DEFAULT)
//                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_CACTUS_DESERT)
//                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
//
//        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
//        BiomeDefaultFeatures.addDefaultOres(generationSettings);
//
//        MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
//
//        return (new Biome.BiomeBuilder())
//                .hasPrecipitation(false)
//                .downfall(0.0f)
//                .temperature(2.0f)
////                .depth(0.15f)
////                .scale(0.15f)
////                .category(Biome.Category.DESERT)
//                .mobSpawnSettings(spawnInfo.build())
//                .generationSettings(generationSettings.build())
//                .specialEffects(biomeAmbience)
//                .build();
//    }
//}
