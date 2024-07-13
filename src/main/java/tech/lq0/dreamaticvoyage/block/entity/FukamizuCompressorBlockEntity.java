package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;

public class FukamizuCompressorBlockEntity extends BlockEntity {

    public FukamizuCompressorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.FUKAMIZU_COMPRESSOR_BLOCK_ENTITY.get(), pPos, pBlockState);
    }
}
