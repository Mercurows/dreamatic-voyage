package tech.lq0.dreamaticvoyage.block.fukamizu.plum;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

import java.util.List;

public class FukamizuPlumLog extends RotatedPillarBlock {
    public FukamizuPlumLog() {
        super(BlockBehaviour.Properties.of().strength(2.0F).mapColor(MapColor.TERRACOTTA_PURPLE).sound(SoundType.WOOD));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.fukamizu_plum_log").withStyle(ChatFormatting.GRAY));
    }

    // TODO 修改为正确的木头
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult pHit) {
        ItemStack stack = player.getItemInHand(handIn);
        if (stack.getItem() instanceof AxeItem) {
            pLevel.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!pLevel.isClientSide) {
                pLevel.setBlock(pos, BlockRegistry.STRIPPED_HARANO_LOG.get().defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, pState.getValue(RotatedPillarBlock.AXIS)), 11);
                stack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(handIn));
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }

        return super.use(pState, pLevel, pos, player, handIn, pHit);
    }
}
