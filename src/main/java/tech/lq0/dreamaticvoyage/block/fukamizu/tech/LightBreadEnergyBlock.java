package tech.lq0.dreamaticvoyage.block.fukamizu.tech;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.block.entity.LightBreadEnergyBlockEntity;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;

public class LightBreadEnergyBlock extends Block implements EntityBlock {

    public LightBreadEnergyBlock() {
        super(BlockBehaviour.Properties.of().strength(5f, 6f).requiresCorrectToolForDrops());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new LightBreadEnergyBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (!pLevel.isClientSide) {
            return createTickerHelper(pBlockEntityType, BlockEntityRegistry.LIGHT_BREAD_ENERGY_BLOCK_ENTITY.get(), LightBreadEnergyBlockEntity::serverTick);
        }
        return null;
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> pServerType, BlockEntityType<E> pClientType, BlockEntityTicker<? super E> pTicker) {
        return pClientType == pServerType ? (BlockEntityTicker<A>) pTicker : null;
    }
}
