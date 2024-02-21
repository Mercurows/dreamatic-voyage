package tech.lq0.dreamaticvoyage.item.material;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.RarityTool;

import java.util.List;

public class FictionalIngot extends Item {
    public FictionalIngot() {
        super(new Properties().rarity(RarityTool.FICTIONAL));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fictional_ingot").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }
}
