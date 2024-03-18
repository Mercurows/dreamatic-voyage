package tech.lq0.dreamaticvoyage.item.cnt.qianyun;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class GreenFieldSong extends HoeItem {
    public GreenFieldSong() {
        super(ModItemTier.FICTIONAL_INGOT, 0, 0, new Properties()
                .rarity(RarityTool.LEGENDARY).setNoRepair().fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(pTooltipComponents);

        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.green_field_song_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.green_field_song_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.QIANYUN);
    }
}
