package tech.lq0.dreamaticvoyage.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
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
        addHideText(tooltip, Component.translatable("liver.providencraft.liver").withStyle(ChatFormatting.WHITE));

        MutableComponent component = Component.translatable("liver.providencraft." + liver.getName()).withStyle(Style.EMPTY.withColor(TextColor.parseColor(liver.getColor())));
        if (!liver.isActive()) {
            component.withStyle(ChatFormatting.ITALIC);
        }

        addHideText(tooltip, component);
    }

    public static void addDonateInfo(List<Component> tooltip) {
        addHideText(tooltip, Component.literal(""));
        addHideText(tooltip, Component.translatable("des.providencraft.donate_item").withStyle(ChatFormatting.GOLD));
    }

    public static void addLegacyInfo(List<Component> tooltip) {
        addHideText(tooltip, Component.literal(""));
        addHideText(tooltip, Component.translatable("des.providencraft.legacy").withStyle(Style.EMPTY.withColor(0xff6288)));
    }

    public static void addChaosInfo(List<Component> tooltip, int chaos) {
        ChatFormatting chatFormatting;
        StringBuilder builder = new StringBuilder();
        if (chaos > 0) {
            chatFormatting = ChatFormatting.BLUE;
            builder.append("+").append(chaos).append(" ").append(Component.translatable("des.providencraft.chaos").getString());
        } else if (chaos < 0) {
            chatFormatting = ChatFormatting.YELLOW;
            builder.append("-").append(Math.abs(chaos)).append(" ").append(Component.translatable("des.providencraft.chaos").getString());
        } else {
            chatFormatting = ChatFormatting.GREEN;
            builder.append(Component.translatable("des.providencraft.chaos.reset").getString());
        }
        addHideText(tooltip, Component.literal(""));
        addHideText(tooltip, Component.translatable("des.providencraft.chaos.eaten").withStyle(ChatFormatting.GRAY));
        addHideText(tooltip, Component.literal(builder.toString()).withStyle(chatFormatting));
    }
}
