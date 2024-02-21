package tech.lq0.dreamaticvoyage.block.bluesand;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

import java.util.List;

public class CutBlueSandstoneSlab extends SlabBlock {
    public CutBlueSandstoneSlab() {
        super(Properties.copy(BlockRegistry.CUT_BLUE_SANDSTONE.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.cut_blue_sandstone_slab").withStyle(ChatFormatting.GRAY));
    }
}
