package tech.lq0.dreamaticvoyage.item.misc.material.ingot;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HardenCrystalIngot extends Item {
    public HardenCrystalIngot() {
        super(new Properties());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.harden_crystal_ingot_1").withStyle(ChatFormatting.GRAY));
        if (!Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.harden_crystal_ingot_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        } else {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.harden_crystal_ingot_3").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }
}
