package tech.lq0.dreamaticvoyage.item.first.unia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class Unigiri extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(10).build();

    public Unigiri() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.unigiri_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.unigiri_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.UNIA);
    }
}
