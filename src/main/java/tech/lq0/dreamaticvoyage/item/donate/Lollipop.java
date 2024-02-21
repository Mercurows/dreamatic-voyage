package tech.lq0.dreamaticvoyage.item.donate;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class Lollipop extends Item {
    public static final FoodProperties food = new FoodProperties.Builder().saturationMod(0.75f).nutrition(4).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 340, 4), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 340, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 340, 4), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 340, 2), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 340, 2), 1.0f).build();

    public Lollipop() {
        super(new Properties().food(food).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.lollipop_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.lollipop_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.lollipop_3").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));

        TooltipTool.addDonateInfo(pTooltipComponents);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            int lvl = -1;
            if (player.hasEffect(EffectRegistry.OVERLOAD.get())) {
                lvl = player.getEffect(EffectRegistry.OVERLOAD.get()).getAmplifier();
            }

            player.addEffect(new MobEffectInstance(EffectRegistry.OVERLOAD.get(), 340, lvl + 1));
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
