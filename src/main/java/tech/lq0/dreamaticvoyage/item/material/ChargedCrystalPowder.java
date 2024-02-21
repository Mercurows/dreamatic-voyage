package tech.lq0.dreamaticvoyage.item.material;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChargedCrystalPowder extends Item {
    public ChargedCrystalPowder() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (!Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.charged_crystal_powder_1").withStyle(ChatFormatting.GRAY));
        } else {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.charged_crystal_powder_2").withStyle(ChatFormatting.GRAY));
        }
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.charged_crystal_powder_3").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }
}
