package tech.lq0.providencraft.block.bluesand;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.WallBlock;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.BlockRegistry;

import java.util.List;

public class BlueSandstoneWall extends WallBlock {
    public BlueSandstoneWall() {
        super(Properties.copy(BlockRegistry.BLUE_SANDSTONE.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.blue_sandstone_wall").withStyle(ChatFormatting.GRAY));
    }
}
