package tech.lq0.dreamaticvoyage.block.harano;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

import java.util.List;

public class HaranoStairs extends StairBlock {
    public HaranoStairs() {
        super(() -> BlockRegistry.HARANO_PLANKS.get().defaultBlockState(), Properties.copy(BlockRegistry.HARANO_PLANKS.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.harano_stairs").withStyle(ChatFormatting.GRAY));
    }
}
