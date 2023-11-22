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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CommunicationTable extends Block {
    public CommunicationTable() {
        super(Properties.of().strength(2).requiresCorrectToolForDrops());
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player player, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND) {
            int random = (int) (Math.random() * 6 + 1);
            switch (random) {
                case 1 -> player.displayClientMessage(Component.translatable("des.providencraft.ct_message_1"), false);
                case 2 -> player.displayClientMessage(Component.translatable("des.providencraft.ct_message_2"), false);
                case 3 -> player.displayClientMessage(Component.translatable("des.providencraft.ct_message_3"), false);
                case 4 -> player.displayClientMessage(Component.translatable("des.providencraft.ct_message_4"), false);
                case 5 -> player.displayClientMessage(Component.translatable("des.providencraft.ct_message_5"), false);
                default -> player.displayClientMessage(Component.translatable("des.providencraft.ct_message.default"), false);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.communication_table_1").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.translatable("des.providencraft.communication_table_2").withStyle(ChatFormatting.GRAY));
    }
}
