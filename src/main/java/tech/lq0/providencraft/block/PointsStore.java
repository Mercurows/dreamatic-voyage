package tech.lq0.providencraft.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.block.entity.PointsStoreBlockEntity;
import tech.lq0.providencraft.init.BlockEntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nullable;
import java.util.List;

public class PointsStore extends Block implements EntityBlock {
    public PointsStore() {
        super(BlockBehaviour.Properties.of().strength(3f).lightLevel(l -> 15));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.points_store_1").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.translatable("des.providencraft.points_store_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        if (pHand == InteractionHand.MAIN_HAND) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof PointsStoreBlockEntity pointsStoreTileEntity) {
                pointsStoreTileEntity.openGui(pPlayer);
            }
        }
        return InteractionResult.CONSUME;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PointsStoreBlockEntity(pPos, pState);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(ItemRegistry.POINTS_STORE.get());
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(0, 0, 0, 16, 8, 16);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide) {
            return createTickerHelper(pBlockEntityType, BlockEntityRegistry.POINTS_STORE_BLOCK_ENTITY.get(), PointsStoreBlockEntity::tick);
        }
        return null;
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> pServerType, BlockEntityType<E> pClientType, BlockEntityTicker<? super E> pTicker) {
        return pClientType == pServerType ? (BlockEntityTicker<A>)pTicker : null;
    }
}
