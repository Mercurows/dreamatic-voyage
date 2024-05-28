package tech.lq0.dreamaticvoyage.item.other;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.ArmorTool;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class MiracleBadge extends Item implements ICurioItem {
    public static final String TAG_SET = "Set";

    public MiracleBadge() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.miracle_badge_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.miracle_badge_2").withStyle(ChatFormatting.GRAY));
        if (hasArmorSet(pStack)) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magicros_set").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xE2B578)));
        }
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (!livingEntity.level().isClientSide && livingEntity instanceof Player player) {
            setArmorSet(stack, player);
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }

    public static void setArmorSet(ItemStack stack, Player player) {
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return ItemNBTTool.getBoolean(pStack, TAG_SET, false) ? RarityTool.MAGICROS : RarityTool.LEGENDARY;
    }
}
