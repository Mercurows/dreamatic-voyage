package tech.lq0.dreamaticvoyage.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FukamizuBreadBricks extends Block {
    public FukamizuBreadBricks() {
        super(Properties.of().sound(SoundType.METAL).strength(80.0F, 1800.0F).requiresCorrectToolForDrops());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.fukamizu_bread_bricks").withStyle(ChatFormatting.GRAY));
    }
}
