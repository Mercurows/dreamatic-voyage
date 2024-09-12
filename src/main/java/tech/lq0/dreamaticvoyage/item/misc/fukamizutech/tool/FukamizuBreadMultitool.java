package tech.lq0.dreamaticvoyage.item.misc.fukamizutech.tool;

import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.ModTags;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FukamizuBreadMultitool extends AxeItem {
    private static final Set<ToolAction> TOOL_ACTIONS = Collections.newSetFromMap(new IdentityHashMap<>());

    static {
        TOOL_ACTIONS.addAll(ToolActions.DEFAULT_HOE_ACTIONS);
        TOOL_ACTIONS.addAll(ToolActions.DEFAULT_PICKAXE_ACTIONS);
        TOOL_ACTIONS.addAll(ToolActions.DEFAULT_SHOVEL_ACTIONS);
        TOOL_ACTIONS.addAll(ToolActions.DEFAULT_AXE_ACTIONS);
        TOOL_ACTIONS.add(ToolActions.SWORD_SWEEP);
    }

    public FukamizuBreadMultitool() {
        super(ModItemTier.FUKAMIZU_BREAD, 5.0F, -2.4F, new Item.Properties().fireResistant().durability(1145));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fukamizu_bread_multitool").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction action) {
        return TOOL_ACTIONS.contains(action);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        if (state.is(Blocks.COBWEB) || state.is(ModTags.Blocks.FUKAMIZU_BREAD)) {
            return 15.0F;
        } else {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)
                    || state.is(BlockTags.MINEABLE_WITH_AXE) || state.is(BlockTags.MINEABLE_WITH_HOE) ? this.speed : 1;
        }
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        return state.is(Blocks.COBWEB) || state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)
                || state.is(BlockTags.MINEABLE_WITH_AXE) || state.is(BlockTags.MINEABLE_WITH_HOE)
                && TierSortingRegistry.isCorrectTierForDrops(getTier(), state);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return this.isCorrectToolForDrops(state);
    }

    /**
     * From Mekanism-Tools
     */
    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult axeResult = super.useOn(context);
        if (axeResult != InteractionResult.PASS) {
            return axeResult;
        }

        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        if (player == null) {
            return InteractionResult.PASS;
        }

        BlockState blockstate = level.getBlockState(blockpos);
        BlockState resultToSet = null;

        if (player.isShiftKeyDown()) {
            BlockState hoeRes = level.getBlockState(blockpos).getToolModifiedState(context, net.minecraftforge.common.ToolActions.HOE_TILL, false);
            Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = hoeRes == null ? null : Pair.of(ctx -> true, HoeItem.changeIntoState(hoeRes));
            if (pair == null) {
                return InteractionResult.PASS;
            } else {
                Predicate<UseOnContext> predicate = pair.getFirst();
                Consumer<UseOnContext> consumer = pair.getSecond();
                if (predicate.test(context)) {
                    level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (!level.isClientSide) {
                        consumer.accept(context);
                    }
                } else {
                    return InteractionResult.PASS;
                }
            }
        } else {
            if (context.getClickedFace() == Direction.DOWN) {
                return InteractionResult.PASS;
            }
            BlockState shovelRes = blockstate.getToolModifiedState(context, ToolActions.SHOVEL_FLATTEN, false);
            if (shovelRes != null && level.isEmptyBlock(blockpos.above())) {
                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = shovelRes;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide) {
                    level.levelEvent(null, LevelEvent.SOUND_EXTINGUISH_FIRE, blockpos, 0);
                }
                CampfireBlock.dowse(player, level, blockpos, blockstate);
                resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
            }
            if (resultToSet == null) {
                return InteractionResult.PASS;
            }
            if (!level.isClientSide) {
                ItemStack stack = context.getItemInHand();
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockpos, stack);
                }
                level.setBlock(blockpos, resultToSet, Block.UPDATE_ALL_IMMEDIATE);
                stack.hurtAndBreak(1, player, onBroken -> onBroken.broadcastBreakEvent(context.getHand()));
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return (enchantment.category == EnchantmentCategory.BREAKABLE || enchantment.category == EnchantmentCategory.VANISHABLE
                || enchantment.category == EnchantmentCategory.DIGGER || enchantment.category == EnchantmentCategory.WEAPON)
                && enchantment != Enchantments.MENDING;
    }

}
