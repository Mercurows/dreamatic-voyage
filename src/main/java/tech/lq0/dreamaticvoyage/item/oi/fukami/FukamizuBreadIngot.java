package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class FukamizuBreadIngot extends Item {
    public FukamizuBreadIngot() {
        super(new Properties().fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fukamizu_bread_ingot_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fukamizu_bread_ingot_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMI);
    }
}
