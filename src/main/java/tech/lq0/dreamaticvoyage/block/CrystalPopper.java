package tech.lq0.dreamaticvoyage.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.block.entity.CrystalPopperBlockEntity;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@SuppressWarnings("deprecation")
public class CrystalPopper extends Block implements EntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CrystalPopper() {
        super(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.crystal_popper").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDevelopingText(pTooltip);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (worldIn.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockentity = worldIn.getBlockEntity(pos);
        ItemStack mainHandItem = player.getItemInHand(handIn);

        if (blockentity instanceof CrystalPopperBlockEntity popper) {
            if (mainHandItem.isEmpty()) {
                var outputInv = popper.outputInv;
                if (!outputInv.getStackInSlot(0).isEmpty() || !outputInv.getStackInSlot(1).isEmpty()) {
                    // 取出输出槽物品
                    player.getInventory().placeItemBackInInventory(outputInv.getStackInSlot(0));
                    player.getInventory().placeItemBackInInventory(outputInv.getStackInSlot(1));
                    outputInv.setStackInSlot(0, ItemStack.EMPTY);
                    outputInv.setStackInSlot(1, ItemStack.EMPTY);
                } else {
                    // 取出输入槽物品
                    var inputInv = popper.inputInv;
                    player.getInventory().placeItemBackInInventory(inputInv.getStackInSlot(0));
                    inputInv.setStackInSlot(0, ItemStack.EMPTY);
                }
                popper.setChanged();
            } else if (popper.tryInsertGold(mainHandItem)) {
                // 尝试输入金锭
                return InteractionResult.CONSUME;
            }
            return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.or(Block.box(0.25D, 0.0D, 0.25D, 15.75D, 15.0D, 15.75D),
                Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CrystalPopperBlockEntity(pPos, pState);
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

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pLevel instanceof ServerLevel) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof CrystalPopperBlockEntity blockEntity) {
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
