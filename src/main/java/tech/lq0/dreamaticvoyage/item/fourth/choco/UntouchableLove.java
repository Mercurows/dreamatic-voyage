package tech.lq0.dreamaticvoyage.item.fourth.choco;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.UUID;

public class UntouchableLove extends SwordItem {
    public UntouchableLove() {
        super(Tiers.WOOD, 2, -1.8f, new Properties().durability(130));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.untouchable_love").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHOCO);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pAttacker.level().isClientSide) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 4));
            pTarget.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400, 4));
            pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 4));
            pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 400, 4));
            pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 400, 0));
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.getItem() == Items.PAPER;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.UNTOUCHABLE_LOVE.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, -1.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
