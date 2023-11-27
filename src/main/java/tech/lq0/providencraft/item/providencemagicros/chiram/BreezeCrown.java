package tech.lq0.providencraft.item.providencemagicros.chiram;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.*;

import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BreezeCrown extends ArmorItem {
    public static final String TAG_HEALTH = "Health";
    public static final String TAG_SET = "Set";

    public BreezeCrown() {
        super(ModArmorMaterial.MAGICROS, Type.HELMET, new Properties().fireResistant().setNoRepair().rarity(RarityTool.LEGENDARY));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.breeze_crown_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.providencraft.breeze_crown_2").withStyle(ChatFormatting.GRAY));
        if (hasArmorSet(pStack)) {
            pTooltipComponents.add(Component.translatable("des.providencraft.magicros_set").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xE2B578)));
        }

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHIRAM);
    }

//    @SuppressWarnings("unchecked")
//    @OnlyIn(Dist.CLIENT)
//    @Nullable
//    @Override
//    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
//        if (entityLiving instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) entityLiving;
//
//            if (!player.abilities.isFlying && player.isSneaking()) {
//                return (A) new BreezeCrownModel2<>();
//            }
//            if (!player.abilities.isFlying && player.isOnGround() && player.isSneaking()) {
//                return (A) new BreezeCrownModel2<>();
//            } else {
//                return (A) new BreezeCrownModel<>();
//            }
//        }
//
//        return (A) new BreezeCrownModel<>();
//    }
//
//    @Nullable
//    @Override
//    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
//        return Utils.MOD_ID + ":textures/models/armor/breeze_crown_texture.png";
//    }


    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof Player player) {
            setArmorSet(pStack, player);
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            setHealthAmount(stack, player);
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.BREEZE_CROWN.hashCode() + slot.toString().hashCode(), 0);
        if (slot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 3.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, getAttackSpeedAmount(stack), AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    public static void setHealthAmount(ItemStack stack, Player player) {
        ItemNBTTool.setFloat(stack, TAG_HEALTH, player.getHealth());
    }

    public static float getAttackSpeedAmount(ItemStack stack) {
        float times = hasArmorSet(stack) ? 0.03f : 0.02f;
        float max = 1.0f;
        float min = hasArmorSet(stack) ? 0.4f : 0.2f;

        float spd = (getHealthAmount(stack) - 20) * times + min;
        return Math.min(max, Math.max(spd, min));
    }

    public static float getHealthAmount(ItemStack stack) {
        return ItemNBTTool.getFloat(stack, TAG_HEALTH, 0.0f);
    }

    public static void setArmorSet(ItemStack stack, Player player) {
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @SubscribeEvent
    public static void breezeCrownEvent(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        float damage = event.getAmount();

        if (damage > 0f) {
            if (livingEntity instanceof Player player && !itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.BREEZE_CROWN.get())) {
                if (!player.getCooldowns().isOnCooldown(ItemRegistry.BREEZE_CROWN.get())) {
                    int level = ArmorTool.hasArmorSet(player) ? 4 : 3;
                    int time = ArmorTool.hasArmorSet(player) ? 50 : 35;

                    if (!livingEntity.level().isClientSide) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 30, level, false, false));
                    }

                    player.getPersistentData().putInt("BreezeInvincible", time);
                    player.getCooldowns().addCooldown(ItemRegistry.BREEZE_CROWN.get(), 160);
                }
            }
        }
    }

    @SubscribeEvent
    public static void breezeInvincibleEvent(LivingAttackEvent event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        DamageSource source = event.getSource();

        if (livingEntity instanceof Player player && !itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.BREEZE_CROWN.get())) {
            int time = player.getPersistentData().getInt("BreezeInvincible");

            if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && time > 0) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void breezeCrownHealEvent(LivingHealEvent event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        float heal = event.getAmount();

        if (!livingEntity.level().isClientSide) {
            if (!itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.BREEZE_CROWN.get())) {
                event.setAmount(heal * 1.3f);
            }
        }
    }

    @SubscribeEvent
    public static void breezeCrownTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.side.isServer() && event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            int time = player.getPersistentData().getInt("BreezeInvincible");

            if (time > 0) {
                player.getPersistentData().putInt("BreezeInvincible", --time);
            }
        }
    }

    @SubscribeEvent
    public static void breezeCrownCriticalEvent(CriticalHitEvent event) {
        Player livingEntity = event.getEntity();
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);

        if (!livingEntity.level().isClientSide) {
            if (!itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.BREEZE_CROWN.get())) {
                if (hasArmorSet(itemStack)) {
                    event.setDamageModifier(event.getDamageModifier() * 1.5f);
                }
            }
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.ARMOR_HEAD || enchantment.category == EnchantmentCategory.BREAKABLE ||
                enchantment.category == EnchantmentCategory.ARMOR;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 24;
    }
}
