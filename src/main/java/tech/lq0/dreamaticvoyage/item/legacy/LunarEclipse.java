package tech.lq0.dreamaticvoyage.item.legacy;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class LunarEclipse extends SwordItem {
    public LunarEclipse() {
        super(ModItemTier.CHARGED_CRYSTAL, 5, -2.0f,
                new Properties().rarity(RarityTool.LEGACY));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.lunar_eclipse").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLegacyInfo(pTooltipComponents);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.LUNAR_ECLIPSE.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 2.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pAttacker instanceof Player player && !(pTarget instanceof ArmorStand)) {
            if (player.hasEffect(EffectRegistry.ECLIPSE_NIGHT.get())) {
                int level = Objects.requireNonNull(player.getEffect(EffectRegistry.ECLIPSE_NIGHT.get())).getAmplifier();
                pTarget.invulnerableTime = 0;

                float damage = pTarget.getHealth() * 0.05f * (level + 1) + 2.0f;
                pTarget.hurt(DamageSourceRegistry.causeLunarEclipseDamage(player.level().registryAccess(), player), damage);
            }

            if (!pTarget.isAlive()) {
                if (!player.hasEffect(EffectRegistry.ECLIPSE_NIGHT.get())) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.ECLIPSE_NIGHT.get(), 200, 0), player);
                } else {
                    int level = Objects.requireNonNull(player.getEffect(EffectRegistry.ECLIPSE_NIGHT.get())).getAmplifier();
                    player.addEffect(new MobEffectInstance(EffectRegistry.ECLIPSE_NIGHT.get(), 200, Math.min(level + 1, 4)), player);
                }
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof Player player && pStack.getDamageValue() < pStack.getMaxDamage()) {
            if (pLevel.isNight() && player.tickCount % 20 == 0) {
                pStack.hurtAndBreak(-1, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
