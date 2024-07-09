package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.ChatFormatting;
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

public class MusicDisc extends RecordItem {
    private final Livers liver;

    public MusicDisc(Livers liver, Supplier<SoundEvent> soundSupplier, Item.Properties builder, int value, int length) {
        super(value, soundSupplier, builder, length);
        this.liver = liver;
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltip, this.liver);
    }

    @Override
    public MutableComponent getDisplayName() {
        return super.getDisplayName();
    }
}
