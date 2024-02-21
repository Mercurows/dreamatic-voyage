package tech.lq0.dreamaticvoyage.item.magicros.ekira;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
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
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.models.armor.CelestialBootsModel;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;
import tech.lq0.dreamaticvoyage.tools.*;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CelestialBoots extends ArmorItem {
    private static final int[] HUNGER_TIME = new int[]{320, 240, 160, 160};

    public static final String TAG_SET = "Set";

    public CelestialBoots() {
        super(ModArmorMaterial.MAGICROS, Type.BOOTS, new Properties().fireResistant().setNoRepair().rarity(RarityTool.LEGENDARY));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.celestial_boots_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.celestial_boots_2").withStyle(ChatFormatting.GRAY));
        if (hasArmorSet(pStack)) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magicros_set").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xE2B578)));
        }

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.EKIRA);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                CelestialBootsModel<?> armorModel = new CelestialBootsModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CelestialBootsModel.LAYER_LOCATION));

                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/celestial_boots.png";
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof Player player) {
            setArmorSet(pStack, player);
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            setArmorSet(stack, player);

            int times = getEnhanceTimes(player, hasArmorSet(stack));
            if (times == 4) {
                if (player.getFoodData().getFoodLevel() > 10) {
                    if (player.tickCount % 80 == 0) {
                        player.getFoodData().eat(2, 1.0f);
                    }
                } else {
                    if (player.tickCount % 160 == 0) {
                        player.getFoodData().eat(2, 0.5f);
                    }
                }
            } else if (player.tickCount % HUNGER_TIME[times - 1] == 0) {
                player.getFoodData().eat(1, 0.5f);
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
        UUID uuid = new UUID(ItemRegistry.CELESTIAL_BOOTS.hashCode() + slot.toString().hashCode(), 0);
        if (slot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 4.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 0.4f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
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
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    private static int getEnhanceTimes(Player player, boolean flag) {
        //套装效果，强化变为4次
        if (flag) {
            return 4;
        }

        //普通情况，倍率为1
        int times = 1;

        Level level = player.level();
        BlockPos pos = player.getOnPos();

        if (!level.isClientSide) {
            //可见天空，倍率为2
            if (level.canSeeSky(pos)) {
                times = 2;

                //可见星空，倍率为3
                if (!level.isRaining() && level.isNight()) {
                    times = 3;
                }
            }
        }

        return times;
    }

    @SubscribeEvent
    public static void celestialBootsEvent(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.FEET);
        DamageSource source = event.getSource();
        Entity entity = source.getDirectEntity();

        if (!livingEntity.level().isClientSide) {
            if (livingEntity instanceof Player player && !itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.CELESTIAL_BOOTS.get())) {
                if (!player.getCooldowns().isOnCooldown(ItemRegistry.CELESTIAL_BOOTS.get())) {
                    int times = getEnhanceTimes(player, hasArmorSet(itemStack));

                    if (entity instanceof LivingEntity target) {

                        if (target != player) {
                            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, times - 1));
                            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50, 0));

                            if (times == 4) {
                                target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 50, 0));
                            }
                        }
                    }

                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 50 + Math.min(3, times) * 50, times == 4 ? 1 : 0));

                    player.getCooldowns().addCooldown(itemStack.getItem(), 120);
                }
            }
        }
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
    public int getEnchantmentValue(ItemStack stack) {
        return 24;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }
}
