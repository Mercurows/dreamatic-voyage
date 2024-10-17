package tech.lq0.dreamaticvoyage.item.misc.fukamizutech;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class FukamizuUpgradeSmithingTemplate extends SmithingTemplateItem {
    public FukamizuUpgradeSmithingTemplate() {
        super(Component.translatable("item.dreamaticvoyage.smithing_template.fukamizu_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
                Component.translatable("item.dreamaticvoyage.smithing_template.fukamizu_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
                Component.translatable("upgrade.dreamaticvoyage.fukamizu_upgrade").withStyle(ChatFormatting.GRAY),
                Component.translatable("item.dreamaticvoyage.smithing_template.fukamizu_upgrade.base_slot_description"),
                Component.translatable("item.dreamaticvoyage.smithing_template.fukamizu_upgrade.addition_slot_description"),
                List.of(new ResourceLocation("item/empty_armor_slot_helmet"), new ResourceLocation("item/empty_slot_sword")), List.of(new ResourceLocation("item/empty_slot_ingot")));
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
}
