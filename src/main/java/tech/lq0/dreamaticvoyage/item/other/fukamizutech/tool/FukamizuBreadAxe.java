package tech.lq0.dreamaticvoyage.item.other.fukamizutech.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;

import java.util.List;

public class FukamizuBreadAxe extends AxeItem {

    public FukamizuBreadAxe() {
        super(ModItemTier.FUKAMIZU_BREAD, 5.0F, -3.0F, new Item.Properties().fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fukamizu_bread_axe").withStyle(ChatFormatting.GRAY));
    }

}
