package tech.lq0.dreamaticvoyage.item.donate;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class MusicDiscSongOfAutumn extends RecordItem {
    public MusicDiscSongOfAutumn() {
        super(7, SoundRegistry.SONG_OF_AUTUMN, new Properties().stacksTo(1).rarity(RarityTool.DONATE), 4720);
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.translatable("des.providencraft.music_disc_song_of_autumn").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDonateInfo(pTooltip);
    }

    @Override
    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }
}
