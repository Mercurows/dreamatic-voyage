package tech.lq0.providencraft.item.providenceconnections.qianyun;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.NyliumBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
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

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();

        if (applyBonemeal(context.getItem(), world, blockpos, context.getPlayer())) {
            if (!world.isRemote) {
                world.playEvent(2005, blockpos, 0);
            }

            return ActionResultType.func_233537_a_(world.isRemote);
        }

        return ActionResultType.PASS;
    }

    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, net.minecraft.entity.player.PlayerEntity player) {
        boolean success = false;

        for (int i = 0; i < 10; i++) {
            BlockState blockstate = worldIn.getBlockState(pos);
            int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, blockstate, stack);
            if (hook != 0) return hook > 0;
            if (blockstate.getBlock() instanceof IGrowable && !(blockstate.getBlock() instanceof GrassBlock) && !(blockstate.getBlock() instanceof NyliumBlock)) {
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

        if (success) {
            stack.damageItem(1, player, (entity) -> entity.sendBreakAnimation(EquipmentSlotType.MAINHAND));
        }

        return success;
    }
}
