package tech.lq0.providencraft.item.legacy;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.RarityTool;
import tech.lq0.providencraft.tools.TooltipTool;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class YagiStaffCard extends Item implements ICurioItem {
    public YagiStaffCard() {
        super(new Properties().stacksTo(1).rarity(RarityTool.LEGACY));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.yagi_staff_card_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.yagi_staff_card_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLegacyInfo(pTooltipComponents);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.MAX_HEALTH,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, -0.7f, AttributeModifier.Operation.MULTIPLY_BASE));
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 1.0f, AttributeModifier.Operation.MULTIPLY_BASE));

        return map;
    }
}
