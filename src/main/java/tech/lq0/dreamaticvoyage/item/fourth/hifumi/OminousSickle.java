package tech.lq0.dreamaticvoyage.item.fourth.hifumi;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OminousSickle extends SwordItem {
    public static final String TAG_HEALTH = "Health";
    public static final String TAG_INVOKE = "Invoke";

    public OminousSickle() {
        super(ModItemTier.CHARGED_CRYSTAL, 5, -2.0F,
                new Properties().rarity(RarityTool.LEGENDARY).setNoRepair().fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        ItemNBTTool.setBoolean(stack, TAG_INVOKE, !isInvoke(stack));
        pPlayer.getCooldowns().addCooldown(this, 20);
        return InteractionResultHolder.fail(stack);
    }

    private Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack) {
        double attackDamage = Math.max(11, calculateAttackDamage(stack));
        double attackSpeed = Math.max(-2f, calculateAttackSpeed(stack));

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
                isInvoke(stack) ? attackDamage * 3 + 2 : attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",
                isInvoke(stack) ? -3.2 : attackSpeed, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(new UUID(ItemRegistry.OMINOUS_SICKLE.hashCode(), 0), Utils.MOD_ATTRIBUTE_MODIFIER,
                isInvoke(stack) ? -0.2 : 0.2, AttributeModifier.Operation.MULTIPLY_BASE));
        return builder.build();
    }

    private int calculateAttackDamage(ItemStack stack) {
        return (int) (12 / ItemNBTTool.getFloat(stack, TAG_HEALTH, 1.0f)) - 1;
    }

    private float calculateAttackSpeed(ItemStack stack) {
        return -2 + (1 - ItemNBTTool.getFloat(stack, TAG_HEALTH, 1.0f)) / 0.8f;
    }

    private boolean isInvoke(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random random = new Random();
        if (random.nextFloat() < .3f) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 0));
        }

        if (!isInvoke(pStack)) {
            float healAmount = (1 - ItemNBTTool.getFloat(pStack, TAG_HEALTH, 1.0f)) / 8f * pAttacker.getMaxHealth();

            if (pTarget.hasEffect(MobEffects.UNLUCK)) {
                pAttacker.heal(healAmount * 2f);
            } else {
                pAttacker.heal(healAmount);
            }
        } else {
            if (pAttacker.getHealth() > pAttacker.getMaxHealth() * .1f) {
                float damage = pAttacker.getHealth() - pAttacker.getMaxHealth() * .1f;
                pAttacker.hurt(pAttacker.level().damageSources().cactus(),
                        Math.min(damage, pAttacker.getMaxHealth() * .25f));
            }
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
        if (!Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.ominous_sickle_1").withStyle(ChatFormatting.GRAY));
        } else {
            if (isInvoke(pStack)) {
                pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.ominous_sickle_4").withStyle(ChatFormatting.GRAY));
            } else {
                pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.ominous_sickle_3").withStyle(ChatFormatting.GRAY));
            }
        }

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
        return 24;
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

    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        if (event.getEntity() instanceof Player player && !player.level().isClientSide) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() == ItemRegistry.OMINOUS_SICKLE.get()) {
                if (ItemNBTTool.getBoolean(stack, TAG_INVOKE, false)) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
