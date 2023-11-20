package tech.lq0.providencraft.item.providenceOI.shirako;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class MomoBandage extends Item implements ICurioItem {
    public MomoBandage() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_bandage_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_bandage_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, -0.197f, AttributeModifier.Operation.MULTIPLY_BASE));
        map.put(Attributes.ATTACK_SPEED,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, -0.197f, AttributeModifier.Operation.MULTIPLY_BASE));

        return map;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        if (entity.hasEffect(EffectRegistry.BLEEDING.get())) {
            entity.removeEffect(EffectRegistry.BLEEDING.get());
        }

        if (entity.tickCount % 100 == 0) {
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 95, 0, false, false));
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }
}
