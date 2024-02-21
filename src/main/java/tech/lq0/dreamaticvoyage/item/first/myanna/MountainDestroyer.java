package tech.lq0.dreamaticvoyage.item.first.myanna;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MountainDestroyer extends PickaxeItem {
    public static final String TAG_MULTIMINE = "multimine";

    public MountainDestroyer() {
        super(ModItemTier.DARK_ELF, 6, -3f, new Properties().durability(39).rarity(Rarity.EPIC).fireResistant().setNoRepair());
    }

    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide) {
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_MULTIMINE, false);
            ItemNBTTool.setBoolean(stack, TAG_MULTIMINE, !flag);
            pPlayer.displayClientMessage(!flag ? Component.translatable("des.dreamaticvoyage.mountain_destroyer.enable") :
                    Component.translatable("des.dreamaticvoyage.mountain_destroyer.disable"), true);
        }
        return InteractionResultHolder.fail(stack);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL);
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.MOUNTAIN_DESTROYER.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    @ParametersAreNonnullByDefault
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return (pState.is(BlockTags.MINEABLE_WITH_PICKAXE) || pState.is(BlockTags.MINEABLE_WITH_SHOVEL)) ?
                this.speed : super.getDestroySpeed(pStack, pState);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if ((state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)) && TierSortingRegistry.isCorrectTierForDrops(ModItemTier.DARK_ELF, state)
                && !level.isClientSide && entityLiving instanceof Player player) {
            stack.hurtAndBreak(-1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(player.getUsedItemHand()));
            if (ItemNBTTool.getBoolean(stack, TAG_MULTIMINE, false)) {
                ArrayList<BlockPos> posList = new ArrayList<>();
                if (pos.getY() - entityLiving.getY() <= 2 && pos.getY() - entityLiving.getY() >= 0) {
                    BlockPos basePos = new BlockPos(pos.getX(), (int) entityLiving.getY(), pos.getZ());
                    float yaw = Math.abs(player.yHeadRot);
                    if ((yaw >= 45.0f && yaw <= 135.0f) || (yaw >= 225.0f && yaw <= 315.0f)) {
                        //x-facing
                        posList.add(basePos.offset(0, 0, 0));
                        posList.add(basePos.offset(0, 0, -1));
                        posList.add(basePos.offset(0, 0, 1));
                        posList.add(basePos.offset(0, 1, -1));
                        posList.add(basePos.offset(0, 1, 0));
                        posList.add(basePos.offset(0, 1, 1));
                        posList.add(basePos.offset(0, 2, -1));
                        posList.add(basePos.offset(0, 2, 0));
                        posList.add(basePos.offset(0, 2, 1));
                    } else {
                        //z-facing
                        posList.add(basePos.offset(0, 0, 0));
                        posList.add(basePos.offset(-1, 0, 0));
                        posList.add(basePos.offset(1, 0, 0));
                        posList.add(basePos.offset(-1, 1, 0));
                        posList.add(basePos.offset(0, 1, 0));
                        posList.add(basePos.offset(1, 1, 0));
                        posList.add(basePos.offset(-1, 2, 0));
                        posList.add(basePos.offset(0, 2, 0));
                        posList.add(basePos.offset(1, 2, 0));
                    }
                } else {
                    //up-down-facing
                    posList.add(pos.offset(1, 0, 0));
                    posList.add(pos.offset(-1, 0, 0));
                    posList.add(pos.offset(0, 0, 1));
                    posList.add(pos.offset(0, 0, -1));
                    posList.add(pos.offset(1, 0, 1));
                    posList.add(pos.offset(1, 0, -1));
                    posList.add(pos.offset(-1, 0, 1));
                    posList.add(pos.offset(-1, 0, -1));
                }
                manualMineBlock(posList, level, entityLiving);
            }
            return true;
        }
        return super.mineBlock(stack, level, state, pos, entityLiving);
    }

    private void manualMineBlock(ArrayList<BlockPos> pos, Level world, LivingEntity player) {
        for (BlockPos p : pos) {
            BlockState s = world.getBlockState(p);
            if (TierSortingRegistry.isCorrectTierForDrops(ModItemTier.DARK_ELF, s) && s.is(BlockTags.MINEABLE_WITH_PICKAXE) || s.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                BlockState state = world.getBlockState(p);
                BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(p) : null;
                Block.dropResources(state, world, p, blockEntity, player, player.getMainHandItem());

                world.destroyBlock(p, false);

                ((Player) player).awardStat(Stats.BLOCK_MINED.get(state.getBlock()), 1);
            }
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mountain_destroyer_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mountain_destroyer_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MYANNA);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
