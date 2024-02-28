package tech.lq0.dreamaticvoyage.item.first.unia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class EnchantedUnigiri extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(14).
            effect(() -> new MobEffectInstance(MobEffects.JUMP, 140, 0), 1.0F).
            effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 140, 0), 1.0F).build();

    public EnchantedUnigiri() {
        super(new Properties().food(food).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.unigiri_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.enchanted_unigiri").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.UNIA);
    }
}
