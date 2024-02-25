package tech.lq0.dreamaticvoyage.item.third.leciel;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Map;

public class GiantDiamondRing extends SwordItem {
    private static final String TAG_SILK_TOUCH = "providencraft:silk_touch";

    public GiantDiamondRing() {
        super(Tiers.DIAMOND, 1, -1.0f, new Properties().durability(794).rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.is(Tags.Blocks.GLASS);
    }

    //From Botania
    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        BlockState state = player.level().getBlockState(pos);
        boolean hasSilk = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SILK_TOUCH, itemstack) > 0;
        if (hasSilk || !(state.is(Tags.Blocks.GLASS))) {
            return super.onBlockStartBreak(itemstack, pos, player);
        }

        itemstack.enchant(Enchantments.SILK_TOUCH, 1);
        CompoundTag nbt = itemstack.getTag();
        if (nbt != null) {
            nbt.putBoolean(TAG_SILK_TOUCH, true);
        }

        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (stack.getOrCreateTag().getBoolean(TAG_SILK_TOUCH)) {
            CompoundTag nbt = stack.getTag();
            if (nbt != null) {
                nbt.remove(TAG_SILK_TOUCH);
            }

            Map<Enchantment, Integer> enchantments = EnchantmentHelper.deserializeEnchantments(stack.getEnchantmentTags());
            enchantments.remove(Enchantments.SILK_TOUCH);
            EnchantmentHelper.setEnchantments(enchantments, stack);
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.giant_diamond_ring_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.giant_diamond_ring_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LECIEL);
    }
}
