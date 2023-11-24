package tech.lq0.providencraft.item.providenceOI.lutafia;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class Fiaxe extends AxeItem {
    public Fiaxe() {
        super(Tiers.IRON, 8.0f, -3.0f, new Properties().durability(601).setNoRepair());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.fiaxe").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LUTAFIA);
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return pState.is(BlockTags.MINEABLE_WITH_AXE) || pState.is(BlockTags.LEAVES) ? 40.0f : super.getDestroySpeed(pStack, pState);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_AXE) || state.is(BlockTags.LEAVES);
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if(pState.is(BlockTags.LEAVES) && pEntityLiving instanceof Player player){
            double random = Math.random();

            pStack.hurtAndBreak(random > .2 ? 0 : -1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(player.getUsedItemHand()));
            return true;
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }
}
