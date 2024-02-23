package tech.lq0.dreamaticvoyage.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import tech.lq0.dreamaticvoyage.Utils;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {

    public ModOverworldRegion(int weight) {
        super(new ResourceLocation(Utils.MOD_ID, "region_provider"), RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.DRY)
                .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.INLAND, ParameterUtils.Continentalness.FAR_INLAND))
                .erosion(ParameterUtils.Erosion.EROSION_0)
                .depth(Climate.Parameter.span(-0.1F, 0.0F))
                .weirdness(ParameterUtils.Weirdness.VALLEY)
                .build().forEach(point -> builder.add(point, ModBiomes.BLUE_DESERT));

        builder.build().forEach(mapper);
    }
}
