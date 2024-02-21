package tech.lq0.dreamaticvoyage.item.providencemagicros.ekira;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class BubbleTea extends Item {
    public static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.4f).nutrition(8).alwaysEat().build();

    public BubbleTea() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.bubble_tea").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.EKIRA);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 0));

            double random = Math.random();
            if (random <= .2) {
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 2));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1));
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.bubble_tea.message").withStyle(ChatFormatting.LIGHT_PURPLE), true);
            }
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
