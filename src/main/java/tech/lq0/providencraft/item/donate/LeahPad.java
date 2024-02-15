package tech.lq0.providencraft.item.donate;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class LeahPad extends Item {
    public LeahPad() {
        super(new Properties().durability(15));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(pTooltipComponents);

        pTooltipComponents.add(Component.translatable("des.providencraft.leah_pad_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.leah_pad_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.providencraft.leah_pad_3").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addDonateInfo(pTooltipComponents);
    }
}
