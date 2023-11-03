package tech.lq0.providencraft.item.providenceconnections.qianyun;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Qiankela extends Item {
    public Qiankela() {
        super(new Properties().group(ModGroup.itemgroup).maxDamage(30).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.qiankela")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.QIANYUN);
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockPos blockpos1 = blockpos.offset(context.getFace());
        if (applyBonemeal(context.getItem(), world, blockpos, context.getPlayer())) {
            if (!world.isRemote) {
                world.playEvent(2005, blockpos, 0);
            }

            return ActionResultType.func_233537_a_(world.isRemote);
        } else {
            BlockState blockstate = world.getBlockState(blockpos);
            boolean flag = blockstate.isSolidSide(world, blockpos, context.getFace());
            if (flag) {
                if (!world.isRemote) {
                    world.playEvent(2005, blockpos1, 0);
                }

                return ActionResultType.func_233537_a_(world.isRemote);
            } else {
                return ActionResultType.PASS;
            }
        }
    }

    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, net.minecraft.entity.player.PlayerEntity player) {
        boolean success = false;

        for (int i = 0; i < 10; i++) {
            BlockState blockstate = worldIn.getBlockState(pos);
            int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, blockstate, stack);
            if (hook != 0) return hook > 0;
            if (blockstate.getBlock() instanceof IGrowable) {
                IGrowable igrowable = (IGrowable) blockstate.getBlock();
                if (igrowable.canGrow(worldIn, pos, blockstate, worldIn.isRemote)) {
                    if (worldIn instanceof ServerWorld) {
                        if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, blockstate)) {
                            igrowable.grow((ServerWorld) worldIn, worldIn.rand, pos, blockstate);
                        }
                    }

                    success = true;
                }
            }
        }

        return success;
    }
}
