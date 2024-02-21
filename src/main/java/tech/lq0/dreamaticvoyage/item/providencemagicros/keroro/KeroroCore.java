package tech.lq0.dreamaticvoyage.item.providencemagicros.keroro;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class KeroroCore extends Item {
    public KeroroCore() {
        super(new Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.keroro_core").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.KERORO);
    }
}
