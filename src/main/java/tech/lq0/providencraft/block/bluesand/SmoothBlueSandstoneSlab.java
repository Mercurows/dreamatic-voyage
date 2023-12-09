package tech.lq0.providencraft.block.bluesand;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.BlockRegistry;

import java.util.List;

public class SmoothBlueSandstoneSlab extends SlabBlock {
    public SmoothBlueSandstoneSlab() {
        super(Properties.copy(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get()));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.smooth_blue_sandstone_slab").withStyle(ChatFormatting.GRAY));
    }
}
