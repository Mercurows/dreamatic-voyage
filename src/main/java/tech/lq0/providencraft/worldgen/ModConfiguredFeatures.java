package tech.lq0.providencraft.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.BlockRegistry;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HARANO_TREE = registerKey("harano_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        //TODO 修复树叶问题
        register(context, HARANO_TREE,
                Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockRegistry.HARANO_LOG.get()),
                        new StraightTrunkPlacer(7, 4, 0),
                        BlockStateProvider.simple(BlockRegistry.HARANO_LEAVES.get()),
                        new BlobFoliagePlacer(UniformInt.of(1, 2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines().build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Utils.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
