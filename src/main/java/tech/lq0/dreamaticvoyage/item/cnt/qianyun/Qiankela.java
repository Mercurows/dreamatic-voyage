package tech.lq0.dreamaticvoyage.item.cnt.qianyun;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.ArrayList;
import java.util.List;

public class Qiankela extends Item {
    public Qiankela() {
        super(new Properties().durability(50).rarity(Rarity.UNCOMMON).setNoRepair());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.qiankela").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.QIANYUN);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        ItemStack stack = pContext.getItemInHand();
        Player player = pContext.getPlayer();

        ArrayList<BlockPos> posList = new ArrayList<>();
        posList.add(blockpos);
        posList.add(blockpos.offset(1, 0, 0));
        posList.add(blockpos.offset(-1, 0, 0));
        posList.add(blockpos.offset(0, 0, 1));
        posList.add(blockpos.offset(0, 0, -1));
        posList.add(blockpos.offset(1, 0, 1));
        posList.add(blockpos.offset(1, 0, -1));
        posList.add(blockpos.offset(-1, 0, 1));
        posList.add(blockpos.offset(-1, 0, -1));

        boolean success = false;

        for (BlockPos blockPos : posList) {
            for (int i = 0; i < 10; i++) {
                boolean flag = applyBonemeal(stack, level, blockPos, player);
                if (flag) {
                    if (!level.isClientSide) {
                        level.levelEvent(1505, blockPos, 0);
                    }
                    success = true;
                }
            }
        }

        if (success && player != null) {
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
        }

        return InteractionResult.PASS;
    }

    public static boolean applyBonemeal(ItemStack pStack, Level pLevel, BlockPos pPos, Player player) {
        BlockState blockstate = pLevel.getBlockState(pPos);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, pLevel, pPos, blockstate, pStack);
        if (hook != 0) {
            return hook > 0;
        }

        if (blockstate.getBlock() instanceof BonemealableBlock bonemealableblock &&
                !(bonemealableblock instanceof GrassBlock) && !(bonemealableblock instanceof NyliumBlock) && !(bonemealableblock instanceof SaplingBlock)) {
            if (bonemealableblock.isValidBonemealTarget(pLevel, pPos, blockstate, pLevel.isClientSide)) {
                if (pLevel instanceof ServerLevel serverLevel) {
                    if (bonemealableblock.isBonemealSuccess(pLevel, pLevel.random, pPos, blockstate)) {
                        bonemealableblock.performBonemeal(serverLevel, pLevel.random, pPos, blockstate);
                        serverLevel.sendBlockUpdated(pPos, blockstate, blockstate, 3);
                    }
                }

                return true;
            }
        }

        return false;
    }
}
