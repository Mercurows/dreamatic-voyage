package tech.lq0.dreamaticvoyage.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PurifiedCrystalBlock extends Block {
    public PurifiedCrystalBlock() {
        super(Properties.of().strength(6.0f, 4.0f).requiresCorrectToolForDrops());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.purified_crystal_block").withStyle(ChatFormatting.GRAY));
    }
}
