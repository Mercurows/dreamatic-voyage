package tech.lq0.dreamaticvoyage.block.fukamizu.plum;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FukamizuPlumPressurePlate extends PressurePlateBlock {
    public FukamizuPlumPressurePlate() {
        super(Sensitivity.EVERYTHING, Properties.of().strength(0.5F).mapColor(MapColor.WOOD).sound(SoundType.WOOD),
                BlockSetType.register(new BlockSetType("fukamizu_plum")));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.fukamizu_plum_pressure_plate").withStyle(ChatFormatting.GRAY));
    }
}
