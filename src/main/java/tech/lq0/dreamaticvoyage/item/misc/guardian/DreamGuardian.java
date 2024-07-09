package tech.lq0.dreamaticvoyage.item.misc.guardian;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public abstract class DreamGuardian extends Item {
    private final String liverName;

    public DreamGuardian(Livers liver) {
        super(new Properties().rarity(Rarity.UNCOMMON).stacksTo(1));
        this.liverName = liver.getName();
    }

    public DreamGuardian(String liverName) {
        super(new Properties().rarity(Rarity.UNCOMMON).stacksTo(1));
        this.liverName = liverName;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("liver.dreamaticvoyage." + this.liverName).withStyle(ChatFormatting.GRAY));

        TooltipTool.addDevelopingText(pTooltip);
    }
}
