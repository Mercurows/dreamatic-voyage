package tech.lq0.providencraft.item.providencefirst.ayelet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class SleepRoulette extends Item {
    public SleepRoulette() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player playerIn, InteractionHand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        if (!pLevel.isClientSide && !pLevel.isDay()) {
            int random = (int) (Math.random() * 10) + 1;
            if (random > 6) {
                playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 2));
                playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2));
                playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2));
                playerIn.displayClientMessage(Component.translatable("des.providencraft.sleep_roulette.awake").withStyle(ChatFormatting.GOLD), true);
            } else {
                playerIn.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1200, 0));
                playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0));
                playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 0));
                playerIn.displayClientMessage(Component.translatable("des.providencraft.sleep_roulette.asleep").withStyle(ChatFormatting.GRAY), true);
            }
            playerIn.getCooldowns().addCooldown(itemStack.getItem(), 1800);
            return InteractionResultHolder.success(itemStack);
        }
        return InteractionResultHolder.fail(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.sleep_roulette.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.sleep_roulette_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.providencraft.sleep_roulette_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.providencraft.sleep_roulette_3").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.providencraft.sleep_roulette_4").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.AYELET);
    }
}
