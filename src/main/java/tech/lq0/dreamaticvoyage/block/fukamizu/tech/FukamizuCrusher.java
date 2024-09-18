package tech.lq0.dreamaticvoyage.block.fukamizu.tech;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.block.entity.FukamizuCrusherBlockEntity;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;

@SuppressWarnings("deprecation")
public class FukamizuCrusher extends Block implements EntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public FukamizuCrusher() {
        super(BlockBehaviour.Properties.of().strength(5f, 6f).requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FukamizuCrusherBlockEntity(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (!pLevel.isClientSide) {
            return createTickerHelper(pBlockEntityType, BlockEntityRegistry.FUKAMIZU_CRUSHER_BLOCK_ENTITY.get(), FukamizuCrusherBlockEntity::serverTick);
        }
        return null;
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> pServerType, BlockEntityType<E> pClientType, BlockEntityTicker<? super E> pTicker) {
        return pClientType == pServerType ? (BlockEntityTicker<A>) pTicker : null;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!player.getItemInHand(handIn).isEmpty()) {
            return InteractionResult.PASS;
        }
        if (worldIn.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        worldIn.getBlockEntity(pos, BlockEntityRegistry.FUKAMIZU_CRUSHER_BLOCK_ENTITY.get()).ifPresent(crusher -> {
            boolean emptyOutput = true;
            IItemHandlerModifiable inv = crusher.outputInv;

            ItemStack stackInSlot = inv.getStackInSlot(0);
            if (!stackInSlot.isEmpty()) {
                emptyOutput = false;
            }

            player.getInventory().placeItemBackInInventory(stackInSlot);
            inv.setStackInSlot(0, ItemStack.EMPTY);

            if (emptyOutput) {
                inv = crusher.inputInv;
                player.getInventory().placeItemBackInInventory(inv.getStackInSlot(0));
                inv.setStackInSlot(0, ItemStack.EMPTY);
            }

            crusher.setChanged();
        });

        return InteractionResult.SUCCESS;
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter pLevel, Entity entity) {
        super.updateEntityAfterFallOn(pLevel, entity);

        if (entity.level().isClientSide || !(entity instanceof ItemEntity itemEntity) || !entity.isAlive()) {
            return;
        }

        var blockEntity = pLevel.getBlockEntity(entity.blockPosition().below());
        if (!(blockEntity instanceof FukamizuCrusherBlockEntity crusher)) return;

        LazyOptional<IItemHandler> capability = crusher.getCapability(ForgeCapabilities.ITEM_HANDLER);
        if (!capability.isPresent()) {
            return;
        }

        ItemStack remainder = capability.orElse(new ItemStackHandler()).insertItem(0, itemEntity.getItem(), false);
        if (remainder.isEmpty()) {
            itemEntity.discard();
        }
        
        if (remainder.getCount() < itemEntity.getItem().getCount()) {
            itemEntity.setItem(remainder);
        }
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pLevel instanceof ServerLevel) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof FukamizuCrusherBlockEntity blockEntity) {
                IItemHandler inputInv = blockEntity.inputInv;
                for (int slot = 0; slot < inputInv.getSlots(); slot++) {
                    Containers.dropItemStack(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), inputInv.getStackInSlot(slot));
                }

                IItemHandler outputInv = blockEntity.outputInv;
                for (int slot = 0; slot < outputInv.getSlots(); slot++) {
                    Containers.dropItemStack(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), outputInv.getStackInSlot(slot));
                }
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }
}
