package tech.lq0.providencraft.item.material.crystal;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.RarityTool;

import java.util.List;

public class DarkCrystal extends Item {
    public DarkCrystal() {
        super(new Properties().rarity(RarityTool.APOCRYPHAL));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.dark_crystal").withStyle(ChatFormatting.GRAY));
    }
}