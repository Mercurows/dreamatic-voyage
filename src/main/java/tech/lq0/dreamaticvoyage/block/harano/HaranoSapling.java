package tech.lq0.dreamaticvoyage.block.harano;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.worldgen.tree.HaranoTree;

import java.util.List;

public class HaranoSapling extends SaplingBlock {
    public HaranoSapling(){
        super(new HaranoTree(), Properties.of().noOcclusion().randomTicks().instabreak().noCollission().sound(SoundType.GRASS));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("des.providencraft.harano_sapling").withStyle(ChatFormatting.GRAY));
    }
}
