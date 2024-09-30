package tech.lq0.dreamaticvoyage.item.magicros.chiram;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class DisillusionFairyTale extends Item implements ICurioItem {

    public DisillusionFairyTale() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.disillusion_fairy_tale_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.disillusion_fairy_tale_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.disillusion_fairy_tale_3").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHIRAM);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.ARMOR, new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, -0.1f, AttributeModifier.Operation.MULTIPLY_BASE));
        map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.1f, AttributeModifier.Operation.MULTIPLY_BASE));

        return map;
    }

}
