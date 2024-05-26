package tech.lq0.dreamaticvoyage.item.legacy;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class MoonCake extends Item {
    public static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.6f).nutrition(7).alwaysEat().
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 4), 1.0f).build();

    public MoonCake() {
        super(new Properties().food(food).rarity(RarityTool.LEGACY));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.moon_cake").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLegacyInfo(pTooltipComponents);
    }
}
