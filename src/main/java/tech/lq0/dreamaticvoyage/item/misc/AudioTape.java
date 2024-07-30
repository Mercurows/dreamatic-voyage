package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.function.Supplier;

public class AudioTape extends RecordItem {
    private final Livers liver;

    public AudioTape(Livers liver, Supplier<SoundEvent> soundSupplier, Item.Properties builder, int value, int length) {
        super(value, soundSupplier, builder.stacksTo(1), length);
        this.liver = liver;
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
        if (Screen.hasShiftDown()) {
            pTooltip.add(this.getText());
        } else {
            pTooltip.add(this.getLengthText());
        }

        TooltipTool.addLiverInfo(pTooltip, this.liver);
    }

    public MutableComponent getLengthText() {
        return Component.translatable("des.item.dreamaticvoyage.audio_tape")
                .append(String.format("%02d:%02d", getLengthInTicks() / 20 / 60, getLengthInTicks() / 20 % 60))
                .withStyle(ChatFormatting.YELLOW);
    }

    public MutableComponent getText() {
        return Component.translatable("text." + this.getDescriptionId()).withStyle(ChatFormatting.WHITE);
    }

    @Override
    public MutableComponent getDisplayName() {
        return Component.translatable("des." + this.getDescriptionId());
    }
}
