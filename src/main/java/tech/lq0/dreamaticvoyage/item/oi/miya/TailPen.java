package tech.lq0.dreamaticvoyage.item.oi.miya;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.UUID;

public class TailPen extends SwordItem {
    public TailPen() {
        super(ModItemTier.CHARGED_CRYSTAL, 5, -2.5f, new Properties().setNoRepair().rarity(Rarity.EPIC));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.TAIL_PEN.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_KNOCKBACK,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.5f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity target, LivingEntity pAttacker) {
        if (pAttacker instanceof Player player) {
            int random = (int) (Math.random() * 99 + 1);
            if (random > 90) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2), player);
            } else if (random > 80) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2), player);
            } else if (random > 70) {
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 2), player);
            } else if (random > 60) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 3), player);
            } else if (random > 50) {
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 3), player);
            } else if (random > 40) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, 300, 3), player);
            } else if (random > 30) {
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 3), player);
            } else if (random > 20) {
                target.addEffect(target.getMobType() == MobType.UNDEAD ? new MobEffectInstance(MobEffects.HEAL, 10, 3)
                        : new MobEffectInstance(MobEffects.HARM, 10, 3), player);
            } else if (random > 10) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 2), player);
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 2), player);
            }
        }
        return super.hurtEnemy(pStack, target, pAttacker);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.tail_pen_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.tail_pen_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MIYA);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pStack.getDamageValue() < pStack.getMaxDamage() && pEntity instanceof Player player) {
            if (player.tickCount % 20 == 0) {
                pStack.hurtAndBreak(-1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(player.getUsedItemHand()));
            }
        }
    }
}
