package tech.lq0.providencraft.item.providencesecond.lucia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class BigMoeOnePotion extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0).nutrition(0).alwaysEat().build();

    public BigMoeOnePotion() {
        super(new Properties().food(food).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            int random = (int) (Math.random() * 99 + 1);
            if (random > 10) {
                player.addEffect(new MobEffectInstance(EffectRegistry.BIG_FIERCE_ONE.get(), 3600, 2));
                player.displayClientMessage(Component.translatable("des.providencraft.big_moe_one_potion.fierce").withStyle(ChatFormatting.GOLD), true);
            } else {
                player.addEffect(new MobEffectInstance(EffectRegistry.BIG_MOE_ONE.get(), 3600, 0));
                player.displayClientMessage(Component.translatable("des.providencraft.big_moe_one_potion.moe").withStyle(ChatFormatting.LIGHT_PURPLE), true);
            }

            if (!player.isCreative()) {
                pStack.shrink(1);

                if (pStack.isEmpty()) {
                    return new ItemStack(Items.GLASS_BOTTLE);
                }

                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        return pStack;
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
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.big_moe_one_potion_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.big_moe_one_potion_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.big_moe_one_potion.warn").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LUCIA);
    }
}
