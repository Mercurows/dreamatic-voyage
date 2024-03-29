package tech.lq0.dreamaticvoyage.block.bluesand;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.IPlantable;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlueSand extends SandBlock {
    public BlueSand() {
        super(6844335, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(0.5F).sound(SoundType.SAND));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.dreamaticvoyage.blue_sand").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.relative(facing));
        return plant.getBlock() == Blocks.CACTUS || plant.getBlock() == Blocks.DEAD_BUSH || plant.getBlock() == Blocks.SUGAR_CANE;
    }
}
