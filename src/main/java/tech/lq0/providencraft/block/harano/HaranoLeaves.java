package tech.lq0.providencraft.block.harano;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HaranoLeaves extends LeavesBlock {
    public HaranoLeaves(){
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS)
                .noOcclusion().isValidSpawn((state, getter, blockPos, type) -> (type == EntityType.OCELOT || type == EntityType.PARROT))
                .isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).ignitedByLava()
                .pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.harano_leaves").withStyle(ChatFormatting.GRAY));
    }
}
