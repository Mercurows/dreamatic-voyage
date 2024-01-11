package tech.lq0.providencraft.block.harano;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HaranoWood extends RotatedPillarBlock {
    public HaranoWood(){
        super(Properties.of().strength(2.0F).mapColor(MapColor.WOOD).sound(SoundType.WOOD));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.harano_wood").withStyle(ChatFormatting.GRAY));
    }

//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        ItemStack stack = player.getHeldItem(handIn);
//        if(stack.getItem() instanceof AxeItem) {
//            worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
//            if (!worldIn.isRemote) {
//                worldIn.setBlockState(pos, BlockRegistry.STRIPPED_HARANO_LOG.get().getDefaultState()
//                        .with(RotatedPillarBlock.AXIS, state.get(RotatedPillarBlock.AXIS)), 11);
//                stack.damageItem(1, player, (player1) -> player1.sendBreakAnimation(handIn));
//            }
//            return ActionResultType.func_233537_a_(worldIn.isRemote);
//        }
//        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//    }
}
