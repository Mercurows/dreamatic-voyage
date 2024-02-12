package tech.lq0.providencraft.block.harano;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HaranoTrapDoor extends TrapDoorBlock {
    public HaranoTrapDoor() {
        super(Properties.of().strength(3.0F).mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion()
                        .isValidSpawn((state, getter, blockPos, entityType) -> false),
                BlockSetType.register(new BlockSetType("harano")));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.harano_trap_door").withStyle(ChatFormatting.GRAY));
    }
}
