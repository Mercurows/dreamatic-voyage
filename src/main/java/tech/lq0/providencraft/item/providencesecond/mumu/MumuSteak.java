package tech.lq0.providencraft.item.providencesecond.mumu;

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
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MumuSteak extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.7f).nutrition(10).
            effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 1), 1.0F).meat().build();

    public MumuSteak() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.mumu_steak").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MUMU);
    }
}
