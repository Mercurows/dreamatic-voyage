package tech.lq0.dreamaticvoyage.item.magicros.haine;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
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
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.client.models.armor.MistyChestplateModel;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;
import tech.lq0.dreamaticvoyage.tools.*;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MistyChestplate extends ArmorItem {
    public static final String TAG_SET = "Set";
    public static final String TAG_SHIELD = "Shield";
    public static final String TAG_SET_WITH_CURIOS = "SetWithCurios";

    public MistyChestplate() {
        super(ModArmorMaterial.MAGICROS, Type.CHESTPLATE, new Properties().fireResistant().setNoRepair().rarity(RarityTool.LEGENDARY));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.misty_chestplate_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.misty_chestplate_2").withStyle(ChatFormatting.GRAY));
        if (hasArmorSet(pStack)) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magicros_set").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xE2B578)));
        }

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HAINE);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                MistyChestplateModel<?> armorModel = new MistyChestplateModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(MistyChestplateModel.LAYER_LOCATION));

                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/misty_chestplate.png";
    }

    @Override
    public void inventoryTick(ItemStack stack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof Player player) {
            setArmorSet(stack, player);

            AtomicBoolean flag = new AtomicBoolean(false);
            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.MIRACLE_BADGE.get())
                    .ifPresent(slotResult -> flag.set(true)));
            ItemNBTTool.setBoolean(stack, TAG_SET_WITH_CURIOS, flag.get() && hasArmorSet(stack));

            if (pSlotId == getEquipmentSlot().getIndex()) {
                // 生成护盾
                int maxCount = hasArmorSet(stack) ? 2 : 1;

                if (getShieldCount(stack) < maxCount) {
                    if (player.tickCount % 20 == 0) {
                        setShieldTime(player, Math.min(getShieldTime(player) + 1, 60));
                    }
                } else {
                    setShieldTime(player, 0);

                    if (getShieldCount(stack) > maxCount) {
                        setShieldCount(stack, maxCount);
                    }
                }

                if (getShieldTime(player) >= 60) {
                    setShieldTime(player, 0);
                    setShieldCount(stack, getShieldCount(stack) + 1);
                }

                // 空中抗性
                if (!player.onGround()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, hasArmorSet(stack) ? 1 : 0, false, false), player);
                }
            }
        }
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return ItemNBTTool.getBoolean(pStack, TAG_SET_WITH_CURIOS, false) ? RarityTool.MAGICROS : RarityTool.LEGENDARY;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.MISTY_CHESTPLATE.hashCode() + slot.toString().hashCode(), 0);
        if (slot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 7.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 20.0f + getShieldCount(stack) * 10.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @SubscribeEvent
    public static void mistyChestplateEvent(LivingDamageEvent event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        float damage = event.getAmount();

        if (!livingEntity.level().isClientSide) {
            if (!itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.MISTY_CHESTPLATE.get())) {
                int maxDamage = hasArmorSet(itemStack) ? 8 : 5;

                int count = ItemNBTTool.getInt(itemStack, TAG_SHIELD, 0);

                if (count > 0) {
                    if (damage <= maxDamage) {
                        event.setCanceled(true);
                    } else {
                        setShieldCount(itemStack, --count);
                        event.setAmount(event.getAmount() * 0.5f);

                        if (ItemNBTTool.getBoolean(itemStack, TAG_SET_WITH_CURIOS, false)) {
                            if (livingEntity instanceof Player player) {
                                setShieldTime(player, Math.min(getShieldTime(player) + 30, 60));
                            }
                            event.setCanceled(true);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void mistyChestplateProjectileEvent(LivingAttackEvent event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);

        DamageSource source = event.getSource();

        if (!livingEntity.level().isClientSide) {
            if (!itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.MISTY_CHESTPLATE.get())) {
                if (source.is(DamageTypeTags.IS_PROJECTILE)) {
                    double rand = Math.random();
                    double prob = ItemNBTTool.getBoolean(itemStack, TAG_SET_WITH_CURIOS, false) ? .41 : .17;

                    if (rand < prob) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    public static void setArmorSet(ItemStack stack, Player player) {
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    public static void setShieldCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_SHIELD, Math.max(0, Math.min(hasArmorSet(stack) ? 2 : 1, count)));
    }

    public static int getShieldCount(ItemStack stack) {
        return Math.min(hasArmorSet(stack) ? 2 : 1, ItemNBTTool.getInt(stack, TAG_SHIELD, 0));
    }

    public static void setShieldTime(Player player, int time) {
        player.getPersistentData().putInt("MistyTime", time);
    }

    public static int getShieldTime(Player player) {
        return player.getPersistentData().getInt("MistyTime");
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.ARMOR_CHEST || enchantment.category == EnchantmentCategory.BREAKABLE ||
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
