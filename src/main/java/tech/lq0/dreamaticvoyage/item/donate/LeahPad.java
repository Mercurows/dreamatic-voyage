package tech.lq0.dreamaticvoyage.item.donate;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class LeahPad extends Item {
    public LeahPad() {
        super(new Properties().durability(15).setNoRepair().rarity(RarityTool.DONATE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.leah_pad_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.leah_pad_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.leah_pad_3").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addDonateInfo(pTooltipComponents);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 1, false, false));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            int xp = pPlayer.experienceLevel;
            if (xp >= 10) {
                pPlayer.giveExperienceLevels(-10);
                pPlayer.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 3600, 3));

                pPlayer.getCooldowns().addCooldown(this, 6000);
                stack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));

                return InteractionResultHolder.success(stack);
            }
        }

        return InteractionResultHolder.fail(stack);
    }
}
