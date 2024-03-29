package tech.lq0.dreamaticvoyage.block.bluesand;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CutBlueSandstone extends Block {
    public CutBlueSandstone() {
        super(Properties.of().requiresCorrectToolForDrops().strength(0.8F).mapColor(MapColor.TERRACOTTA_BLUE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.cut_blue_sandstone").withStyle(ChatFormatting.GRAY));
    }
}
