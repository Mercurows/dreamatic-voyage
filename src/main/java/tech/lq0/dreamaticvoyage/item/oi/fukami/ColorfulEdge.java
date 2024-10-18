package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class ColorfulEdge extends SwordItem {

    public ColorfulEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 4, -2.5f, new Properties().setNoRepair().rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.colorful_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.colorful_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
//        handleUpgradeTooltips(pStack, pTooltipComponents);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
