package tech.lq0.dreamaticvoyage.block.bluesand;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

import java.util.List;

public class SmoothBlueSandstoneStairs extends StairBlock {
    public SmoothBlueSandstoneStairs() {
        super(() -> BlockRegistry.SMOOTH_BLUE_SANDSTONE.get().defaultBlockState(), Properties.copy(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.smooth_blue_sandstone_stairs").withStyle(ChatFormatting.GRAY));
    }
}
