package tech.lq0.dreamaticvoyage.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> HARANO_TREE_PLACE_KEY = registerKey("harano_tree_placed");
    public static final ResourceKey<PlacedFeature> FUKAMIZU_PLUM_TREE_PLACE_KEY = registerKey("fukamizu_plum_tree_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, HARANO_TREE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HARANO_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), BlockRegistry.HARANO_SAPLING.get()));
        register(context, FUKAMIZU_PLUM_TREE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FUKAMIZU_PLUM_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), BlockRegistry.FUKAMIZU_PLUM_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Utils.loc(name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
