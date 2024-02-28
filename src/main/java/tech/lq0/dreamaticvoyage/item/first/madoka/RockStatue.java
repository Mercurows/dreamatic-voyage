package tech.lq0.dreamaticvoyage.item.first.madoka;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class RockStatue extends BlockItem implements ICurioItem {
    public RockStatue() {
        super(BlockRegistry.ROCK_STATUE.get(), new Properties().rarity(Rarity.UNCOMMON).stacksTo(1).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.rock_statue").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MADOKA);
    }
}
