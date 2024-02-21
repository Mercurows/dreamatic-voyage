package tech.lq0.dreamaticvoyage.item.providencesecond.lucia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class BigFierceOneCoffee extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(2).
            effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 1), 1.0f).
            effect(() -> new MobEffectInstance(EffectRegistry.BIG_FIERCE_ONE.get(), 1200, 3), 1.0f).
            alwaysEat().build();

    public BigFierceOneCoffee() {
        super(new Properties().food(food));
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
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.big_fierce_one_coffee_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.big_fierce_one_coffee_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LUCIA);
    }
}
