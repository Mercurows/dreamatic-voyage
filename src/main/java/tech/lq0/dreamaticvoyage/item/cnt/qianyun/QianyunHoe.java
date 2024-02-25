package tech.lq0.dreamaticvoyage.item.cnt.qianyun;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QianyunHoe extends HoeItem {
    protected static final Map<Block, BlockState> QIANYUN_HOE_LOOKUP = Maps.newHashMap(new ImmutableMap.Builder<Block, BlockState>()
            .put(Blocks.GRASS_BLOCK, Blocks.FARMLAND.defaultBlockState())
            .put(Blocks.DIRT_PATH, Blocks.FARMLAND.defaultBlockState())
            .put(Blocks.DIRT, Blocks.FARMLAND.defaultBlockState())
            .put(Blocks.COARSE_DIRT, Blocks.FARMLAND.defaultBlockState())
            .put(Blocks.PODZOL, Blocks.FARMLAND.defaultBlockState())
            .put(Blocks.SAND, Blocks.DIRT.defaultBlockState())
            .put(Blocks.RED_SAND, Blocks.DIRT.defaultBlockState())
            .put(BlockRegistry.BLUE_SAND.get(), Blocks.DIRT.defaultBlockState())
            .build()
    );

    public QianyunHoe() {
        super(ModItemTier.HARDEN_CRYSTAL, 1, -1.0f, new Properties().rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.qianyun_hoe").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.QIANYUN);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        boolean shouldCauseDamage = false;

        ArrayList<BlockPos> posList = new ArrayList<>();
        posList.add(pos);
        posList.add(pos.offset(1, 0, 0));
        posList.add(pos.offset(-1, 0, 0));
        posList.add(pos.offset(0, 0, 1));
        posList.add(pos.offset(0, 0, -1));
        posList.add(pos.offset(1, 0, 1));
        posList.add(pos.offset(1, 0, -1));
        posList.add(pos.offset(-1, 0, 1));
        posList.add(pos.offset(-1, 0, -1));

        for (BlockPos blockPos : posList) {
            if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockPos.above())) {
                BlockState blockstate = getQianyunHoeTillingState(world.getBlockState(blockPos));
                if (blockstate != null) {

                    world.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (!world.isClientSide) {
                        world.setBlock(blockPos, blockstate, 11);
                        shouldCauseDamage = true;
                    }
                }
            }
        }

        if (shouldCauseDamage) {
            if (player != null) {
                context.getItemInHand().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));
            }
        }

        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    @Nullable
    public BlockState getQianyunHoeTillingState(BlockState originalState) {
        return QIANYUN_HOE_LOOKUP.get(originalState.getBlock());
    }
}
