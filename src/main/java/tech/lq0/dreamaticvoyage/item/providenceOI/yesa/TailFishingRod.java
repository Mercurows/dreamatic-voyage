package tech.lq0.dreamaticvoyage.item.providenceOI.yesa;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.entity.TailHookEntity;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class TailFishingRod extends FishingRodItem {
    public TailFishingRod() {
        super(new Properties().durability(82).rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.tail_fishing_rod").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.YESA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (this.getDamage(itemStack) >= this.getMaxDamage(itemStack)) {
            return InteractionResultHolder.fail(itemStack);
        }

        if (pPlayer.fishing != null) {
            if (!pLevel.isClientSide) {
                int i = pPlayer.fishing.retrieve(itemStack);
                pPlayer.swing(pHand);

                itemStack.hurtAndBreak(i, pPlayer, p -> p.broadcastBreakEvent(pHand));
            }

            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL, 1.0F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));
        } else {
            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));
            if (!pLevel.isClientSide) {
                int k = EnchantmentHelper.getFishingSpeedBonus(itemStack) + 2;
                int j = EnchantmentHelper.getFishingLuckBonus(itemStack) + 3;
                pLevel.addFreshEntity(new TailHookEntity(pPlayer, pLevel, j, k));
            }
            pPlayer.swing(pHand);
            pPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide);
    }
}
