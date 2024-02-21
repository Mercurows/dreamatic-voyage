package tech.lq0.dreamaticvoyage.block.harano;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StrippedHaranoWood extends RotatedPillarBlock {
    public StrippedHaranoWood(){
        super(Properties.of().strength(2.0F).mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.WOOD));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.stripped_harano_wood").withStyle(ChatFormatting.GRAY));
    }
}
