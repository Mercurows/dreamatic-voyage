package tech.lq0.dreamaticvoyage.block.fukamizu.plum;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FukamizuPlumButton extends ButtonBlock {
    public FukamizuPlumButton() {
        super(Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(MapColor.WOOD).sound(SoundType.WOOD),
                BlockSetType.register(new BlockSetType("fukamizu_plum")), 30, true);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.fukamizu_plum_button").withStyle(ChatFormatting.GRAY));
    }
}
