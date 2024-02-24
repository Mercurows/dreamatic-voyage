package tech.lq0.dreamaticvoyage.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.DesertWellFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

import java.util.Optional;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HARANO_TREE = registerKey("harano_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_DESERT_WELL = registerKey("blue_desert_well");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, HARANO_TREE,
                Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockRegistry.HARANO_LOG.get()),
                        new StraightTrunkPlacer(7, 4, 0),
                        BlockStateProvider.simple(BlockRegistry.HARANO_LEAVES.get()),
                        new BlobFoliagePlacer(UniformInt.of(2, 3), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines().build());
        register(context, BLUE_DESERT_WELL, BLUE_DESERT_WELL_FEATURE, new NoneFeatureConfiguration());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Utils.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static final Feature<NoneFeatureConfiguration> BLUE_DESERT_WELL_FEATURE = new Feature<>(NoneFeatureConfiguration.CODEC) {
        @Override
        public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
            WorldGenLevel worldgenlevel = context.level();
            BlockPos blockpos = context.origin();
            RandomSource rand = worldgenlevel.getRandom();

            for (blockpos = blockpos.above(); worldgenlevel.isEmptyBlock(blockpos) && blockpos.getY() > worldgenlevel.getMinBuildHeight() + 2; blockpos = blockpos.below()) {
            }

            if (!BlockStatePredicate.forBlock(BlockRegistry.BLUE_SAND.get()).test(worldgenlevel.getBlockState(blockpos))) {
                return false;
            } else {
                if (rand.nextInt(300) <= 1) {
                    Rotation rotation = Rotation.values()[rand.nextInt(3)];
                    Mirror mirror = Mirror.values()[rand.nextInt(2)];

                    StructureTemplateManager structureTemplateManager = worldgenlevel.getLevel().getStructureManager();
                    Optional<StructureTemplate> structure = structureTemplateManager.get(new ResourceLocation(Utils.MOD_ID, "blue_desert/blue_desert_well"));

                    if (structure.isPresent()) {
                        StructureTemplate template = structure.get();
                        template.placeInWorld(worldgenlevel, blockpos, blockpos, new StructurePlaceSettings().setRotation(rotation).setMirror(mirror)
                                .addProcessor(BlockIgnoreProcessor.AIR).setFinalizeEntities(true), rand, 4);

                        return true;
                    }
                }
            }

            return false;
        }
    };
}
