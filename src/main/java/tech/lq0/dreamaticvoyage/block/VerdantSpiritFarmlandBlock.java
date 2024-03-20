package tech.lq0.dreamaticvoyage.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.ForgeHooks;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

public class VerdantSpiritFarmlandBlock extends FarmBlock {
    public VerdantSpiritFarmlandBlock() {
        super(Properties.of().mapColor(MapColor.DIRT).randomTicks().strength(0.6F).sound(SoundType.GRAVEL).
                isViewBlocking((state, getter, pos) -> true).isSuffocating((state, getter, pos) -> true));
    }

    @Override
    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.is(BlockRegistry.VERDANT_SPIRIT_FARMLAND.get())) {
            return state.getValue(FarmBlock.MOISTURE) > 0;
        }
        return false;
    }

    private static boolean isNearWater(LevelReader pLevel, BlockPos pPos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-4, 0, -4), pPos.offset(4, 1, 4))) {
            if (pLevel.getFluidState(blockpos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(pLevel, pPos);
    }

    /**
     * From Farmer's Delight
     */
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int moisture = state.getValue(MOISTURE);
        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (moisture > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, moisture - 1), 2);
            }
        } else if (moisture < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        } else if (moisture == 7) {
            BlockState aboveState = level.getBlockState(pos.above());
            Block aboveBlock = aboveState.getBlock();

            if (aboveBlock instanceof TallFlowerBlock) {
                return;
            }

            if (aboveBlock instanceof BonemealableBlock growable && random.nextDouble() < .1D) {
                if (growable.isValidBonemealTarget(level, pos.above(), aboveState, false) && ForgeHooks.onCropsGrowPre(level, pos.above(), aboveState, true)) {
                    growable.performBonemeal(level, level.random, pos.above(), aboveState);
                    if (!level.isClientSide) {
                        level.levelEvent(2005, pos.above(), 0);
                    }
                    ForgeHooks.onCropsGrowPost(level, pos.above(), aboveState);
                }
            }
        }
    }
}
