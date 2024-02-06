package tech.lq0.providencraft.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import tech.lq0.providencraft.init.BlockRegistry;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource BLUE_SAND = makeStateRule(BlockRegistry.BLUE_SAND.get());
    private static final SurfaceRules.RuleSource BLUE_SANDSTONE = makeStateRule(BlockRegistry.BLUE_SANDSTONE.get());

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, BLUE_SAND),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, BLUE_SANDSTONE),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(5, false, CaveSurface.FLOOR), BLUE_SANDSTONE),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(5, false, CaveSurface.CEILING), STONE)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
