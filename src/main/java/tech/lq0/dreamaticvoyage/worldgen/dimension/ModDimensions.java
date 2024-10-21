package tech.lq0.dreamaticvoyage.worldgen.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import tech.lq0.dreamaticvoyage.Utils;

import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> TRAUM_KEY = ResourceKey.create(Registries.LEVEL_STEM, Utils.loc("traum"));
    public static final ResourceKey<Level> TRAUM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, Utils.loc("traum"));
    public static final ResourceKey<DimensionType> TRAUM_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, Utils.loc("traum_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(TRAUM_DIM_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }
}
