package tech.lq0.dreamaticvoyage.item.fourth.hifumi;

import com.google.common.collect.ImmutableMultimap;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class OminousSickle extends SwordItem {
    public static final String TAG_HEALTH = "Health";

    public OminousSickle() {
        super(ModItemTier.CHARGED_CRYSTAL, 5, -2.0F,
                new Properties().rarity(RarityTool.LEGENDARY).setNoRepair().fireResistant());
    }

    private Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
                Math.max(11, calculateAttackDamage(stack)), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",
                Math.max(-2f, calculateAttackSpeed(stack)), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(new UUID(ItemRegistry.OMINOUS_SICKLE.hashCode(), 0), Utils.MOD_ATTRIBUTE_MODIFIER,
                0.2, AttributeModifier.Operation.MULTIPLY_BASE));
        return builder.build();
    }

    private int calculateAttackDamage(ItemStack stack) {
        return (int) (12 / ItemNBTTool.getFloat(stack, TAG_HEALTH, 1.0f)) - 1;
    }

    private float calculateAttackSpeed(ItemStack stack) {
        return -2 + (1 - ItemNBTTool.getFloat(stack, TAG_HEALTH, 1.0f)) / 0.8f;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random random = new Random();
        if (random.nextFloat() < .3f) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 0));
        }

        float healAmount = (1 - ItemNBTTool.getFloat(pStack, TAG_HEALTH, 1.0f)) / 8f * pAttacker.getMaxHealth();

        if (pTarget.hasEffect(MobEffects.UNLUCK)) {
            pAttacker.heal(healAmount * 2f);
        } else {
            pAttacker.heal(healAmount);
        }

        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? getModifiers(stack) : super.getAttributeModifiers(equipmentSlot, stack);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isClientSide && entityIn instanceof Player player) {
            float health = player.getHealth();
            float rate = health / player.getMaxHealth();

            ItemNBTTool.setFloat(stack, TAG_HEALTH, Math.max(0.2f, rate));
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.ominous_sickle_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.ominous_sickle_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HIFUMI);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.BREAKABLE;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;
    }

    @SubscribeEvent
    public static void onCriticalHit(CriticalHitEvent event) {
        Player player = event.getEntity();
        if (event.getTarget() instanceof LivingEntity living && living.hasEffect(MobEffects.UNLUCK)) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() == ItemRegistry.OMINOUS_SICKLE.get()) {
                event.setDamageModifier(event.getDamageModifier() * 2f);
            }
        }
    }
}
