package tech.lq0.providencraft.item.providenceOI.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class FukamizuFish extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(6).
            effect(() -> new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0f).build();

    public FukamizuFish(){
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.fukamizu_fish_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.fukamizu_fish_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMI);
    }
}
