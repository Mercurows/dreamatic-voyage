package tech.lq0.dreamaticvoyage.block.fukamizutech;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.block.entity.FukamizuCompressorBlockEntity;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;

public class FukamizuCompressor extends Block implements EntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OVERPRESSURE = BooleanProperty.create("overpressure");

    public FukamizuCompressor() {
        super(BlockBehaviour.Properties.of().strength(5f, 6f).requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OVERPRESSURE, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FukamizuCompressorBlockEntity(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(OVERPRESSURE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite()).setValue(OVERPRESSURE, false);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (!pLevel.isClientSide) {
            return createTickerHelper(pBlockEntityType, BlockEntityRegistry.FUKAMIZU_COMPRESSOR_BLOCK_ENTITY.get(), FukamizuCompressorBlockEntity::serverTick);
        }
        return null;
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> pServerType, BlockEntityType<E> pClientType, BlockEntityTicker<? super E> pTicker) {
        return pClientType == pServerType ? (BlockEntityTicker<A>) pTicker : null;
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel instanceof ServerLevel serverLevel) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof FukamizuCompressorBlockEntity fukamizuCompressorBlockEntity) {
                Containers.dropContents(serverLevel, pPos, fukamizuCompressorBlockEntity);
            }
        }

        super.destroy(pLevel, pPos, pState);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        double x = (double) pPos.getX() + 0.5D;
        double y = (double) pPos.getY() + 0.8D;
        double z = (double) pPos.getZ() + 0.5D;

        if (pLevel.getBlockState(pPos.above()).is(Blocks.WATER)) {
            pLevel.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, x, y + 0.25D, z, 0.0D, 0.02D, 0.0D);
        }

        if (pState.getValue(OVERPRESSURE)) {
            Direction direction = pState.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();

            double d4 = pRandom.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : d4;
            double d6 = pRandom.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : d4;

            pLevel.addParticle(ParticleTypes.CLOUD, x + d5, y + d6, z + d7, 0.0D, 0.0D, 0.0D);
        }

        super.animateTick(pState, pLevel, pPos, pRandom);
    }
}
