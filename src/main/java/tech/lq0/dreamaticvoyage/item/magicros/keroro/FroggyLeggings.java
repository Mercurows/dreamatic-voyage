package tech.lq0.dreamaticvoyage.item.magicros.keroro;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.client.models.armor.FroggyLeggingsModel;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;
import tech.lq0.dreamaticvoyage.tools.*;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FroggyLeggings extends ArmorItem {
    public static final String TAG_SET = "Set";
    public static final String TAG_SET_WITH_CURIOS = "SetWithCurios";

    public FroggyLeggings() {
        super(ModArmorMaterial.MAGICROS, Type.LEGGINGS, new Properties().fireResistant().setNoRepair().rarity(RarityTool.LEGENDARY));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.froggy_leggings_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.froggy_leggings_2").withStyle(ChatFormatting.GRAY));
        if (hasArmorSet(pStack)) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magicros_set").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xE2B578)));
        }

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.KERORO);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                FroggyLeggingsModel<?> armorModel = new FroggyLeggingsModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(FroggyLeggingsModel.LAYER_LOCATION));

                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/froggy_leggings.png";
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!level.isClientSide && pEntity instanceof Player player) {
            setArmorSet(stack, player);

            AtomicBoolean flag = new AtomicBoolean(false);
            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.MIRACLE_BADGE.get())
                    .ifPresent(slotResult -> flag.set(true)));
            ItemNBTTool.setBoolean(stack, TAG_SET_WITH_CURIOS, flag.get() && hasArmorSet(stack));

            if (pSlotId == getEquipmentSlot().getIndex()) {
                setArmorSet(stack, player);

                boolean set = hasArmorSet(stack);

                if (player.isSteppingCarefully()) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 40, set ? 2 : 1, false, false));
                }

                //净化
                if (player.isSwimming() || level.isRaining() || set) {
                    int time = set ? 300 : 600;

                    List<MobEffectInstance> effectList = new ArrayList<>(player.getActiveEffects());

                    if (player.tickCount % time == 0) {
                        if (!effectList.isEmpty()) {
                            for (MobEffectInstance effectInstance : effectList) {
                                if (effectInstance.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                                    player.removeEffect(effectInstance.getEffect());
                                    break;
                                }
                            }
                        }
                    }
                }

                //生命恢复
                if (player.isSwimming() || level.isRaining()) {
                    int tickSeg = ItemNBTTool.getBoolean(stack, TAG_SET_WITH_CURIOS, false) ? 20 : 40;

                    if (player.tickCount % tickSeg == 0) {
                        player.heal(1);
                    }
                }

                if (player.isInWater()) {
                    player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false));
                }
            }
        }
    }

    @SubscribeEvent
    public static void froggyJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity livingEntity = event.getEntity();

        if (livingEntity instanceof Player player) {
            ItemStack stack = player.getItemBySlot(EquipmentSlot.LEGS);
            if (stack.getItem() == ItemRegistry.FROGGY_LEGGINGS.get()) {
                Vec3 base = player.getDeltaMovement().add(0, 0.275, 0);

                if (player.isSprinting()) {
                    float f1 = player.getYRot() * ((float) Math.PI / 180F);
                    base = base.add(-Mth.sin(f1) * 0.45f, 0.0D, Mth.cos(f1) * 0.45f);
                }

                player.setDeltaMovement(base);
            }
        }
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return ItemNBTTool.getBoolean(pStack, TAG_SET_WITH_CURIOS, false) ? RarityTool.MAGICROS : RarityTool.LEGENDARY;
    }

    @SubscribeEvent
    public static void froggyDamage(LivingAttackEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack stack = player.getItemBySlot(EquipmentSlot.LEGS);
            DamageSource type = event.getSource();

            if (stack.getItem() == ItemRegistry.FROGGY_LEGGINGS.get()) {
                if (type.is(DamageTypeTags.IS_FALL)) {
                    event.setCanceled(true);
                }

                if (hasArmorSet(stack)) {
                    if (type.is(DamageTypeTags.IS_FIRE)) {
                        event.setCanceled(true);
                    }
                }

                if (ItemNBTTool.getBoolean(stack, TAG_SET_WITH_CURIOS, false) && player.isSprinting()) {
                    double random = new Random().nextDouble();
                    if (random < 0.1) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.FROGGY_LEGGINGS.hashCode() + slot.toString().hashCode(), 0);
        if (slot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 6.0f, AttributeModifier.Operation.ADDITION));
            map.put(ForgeMod.SWIM_SPEED.get(),
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.4f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
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
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasMagicrosArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.ARMOR_LEGS || enchantment.category == EnchantmentCategory.BREAKABLE ||
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
