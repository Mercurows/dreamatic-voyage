package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MomoSyringe extends Item {
    public MomoSyringe(){
        super(new Properties().rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_syringe_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_syringe_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity target, InteractionHand pUsedHand) {
        double random = Math.random();

        if (pPlayer.getCooldowns().isOnCooldown(pStack.getItem())) {
            return InteractionResult.FAIL;
        } else {
            if (random <= .1) {
                target.setSecondsOnFire(8);
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 2));
            } else {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 1));
                target.heal(target.getMaxHealth() * 0.25f);
            }

            pPlayer.getCooldowns().addCooldown(pStack.getItem(), 200);

            if (!pPlayer.isCreative()) {
                pStack.shrink(1);
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 10;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.CROSSBOW;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            double random = Math.random();
            if (random <= .1) {
                player.setSecondsOnFire(8);
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 2));
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 1));
                player.heal(player.getMaxHealth() * 0.25f);
            }

            if (!player.isCreative()) {
                pStack.shrink(1);
            }

            player.getCooldowns().addCooldown(pStack.getItem(), 200);
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
