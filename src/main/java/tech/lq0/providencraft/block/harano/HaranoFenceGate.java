package tech.lq0.providencraft.block.harano;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HaranoFenceGate extends FenceGateBlock {
    public HaranoFenceGate() {
        super(Properties.of().requiresCorrectToolForDrops().strength(2.0F, 3.0F).mapColor(MapColor.WOOD).sound(SoundType.WOOD).forceSolidOn(),
                SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.harano_fence_gate").withStyle(ChatFormatting.GRAY));
    }
}
