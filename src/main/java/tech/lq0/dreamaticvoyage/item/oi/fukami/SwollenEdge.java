package tech.lq0.dreamaticvoyage.item.oi.fukami;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.UUID;

public class SwollenEdge extends SwordItem {
    public static final int MAX_KILL_COUNT = 600;

    public SwollenEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 5, -3.0f, new Properties().setNoRepair().rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.swollen_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.swollen_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
        handleUpgradeTooltips(pStack, pTooltipComponents);
    }

    private void handleUpgradeTooltips(ItemStack pStack, List<Component> pTooltipComponents) {
        pTooltipComponents.add(Component.literal(""));
        TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.ctrl_hide").withStyle(ChatFormatting.YELLOW), true);

        int killCount = pStack.getOrCreateTag().getInt("KillCount");
        float killCountProgress = Math.min(1, (float) killCount / MAX_KILL_COUNT);

        int count = 0;
        if (killCountProgress >= 1) {
            count++;
        }

        if (count >= 1) {
            TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.complete").withStyle(ChatFormatting.GREEN));
        }

        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.progress").withStyle(ChatFormatting.YELLOW)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(count + " / 1").withStyle(count == 1 ? ChatFormatting.GREEN : ChatFormatting.WHITE)));
        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.kill_count").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(killCount + " / " + MAX_KILL_COUNT)
                                .withStyle(killCountProgress >= 1 ? ChatFormatting.GREEN : ChatFormatting.GRAY))));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pIsSelected && pEntity instanceof LivingEntity living) {
            if (!pLevel.isClientSide) {
                living.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0, false, false), living);

                if (living.isInWater()) {
                    living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0, false, false), living);
                    living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, false, false), living);
                }
            }
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.SWOLLEN_EDGE.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 1.5f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
