package tech.lq0.providencraft.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;

import java.util.List;

public class TooltipTool {
    public static void addHideText(List<Component> tooltip, Component text) {
        if (Screen.hasShiftDown()) {
            tooltip.add(text);
        }
    }

    public static void addDevelopingText(List<Component> tooltip) {
        tooltip.add(Component.literal("本物品还在开发中").withStyle(Style.EMPTY.withBold(true).withColor(TextColor.parseColor("#ADDBFF"))));
    }

    public static void addLiverInfo(List<Component> tooltip, Livers liver) {
        addHideText(tooltip, Component.literal(""));
        addHideText(tooltip, Component.translatable("liver.providencraft.liver").withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
        addHideText(tooltip, Component.translatable("liver.providencraft." + liver.getName()).withStyle(Style.EMPTY.withColor(TextColor.parseColor(liver.getColor()))));
    }

//    public static void addChaosInfo(List<Component> tooltip, int chaos) {
//        TextFormatting textFormatting;
//        StringBuilder builder = new StringBuilder();
//        if(chaos > 0){
//            textFormatting = TextFormatting.BLUE;
//            builder.append("+").append(chaos).append(" ").append(new TranslationTextComponent("des.providencraft.chaos").getString());
//        }else if(chaos < 0){
//            textFormatting = TextFormatting.YELLOW;
//            builder.append("-").append(Math.abs(chaos)).append(" ").append(new TranslationTextComponent("des.providencraft.chaos").getString());
//        }else {
//            textFormatting = TextFormatting.GREEN;
//            builder.append(new TranslationTextComponent("des.providencraft.chaos.reset").getString());
//        }
//        addHideText(tooltip, new StringTextComponent(""));
//        addHideText(tooltip, new TranslationTextComponent("des.providencraft.chaos.eaten").mergeStyle(TextFormatting.GRAY));
//        addHideText(tooltip, new StringTextComponent(builder.toString()).mergeStyle(textFormatting));
//    }
}
