package tech.lq0.dreamaticvoyage.item.misc.fukamizutech;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.RarityTool;

import java.util.List;

public class HQSSBreadIngot extends Item {
    public HQSSBreadIngot() {
        super(new Item.Properties().rarity(RarityTool.FUKAMI_TECH).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hqss_bread_ingot_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hqss_bread_ingot_2").withStyle(ChatFormatting.GRAY));
    }
}
