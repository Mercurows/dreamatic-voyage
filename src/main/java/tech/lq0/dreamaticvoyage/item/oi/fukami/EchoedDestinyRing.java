package tech.lq0.dreamaticvoyage.item.oi.fukami;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.client.models.item.EchoedDestinyRingItemModel;
import tech.lq0.dreamaticvoyage.client.render.item.EchoedDestinyRingItemRenderer;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EchoedDestinyRing extends Item {
    public static final String TAG_ECHO = "underwater";

    public EchoedDestinyRing() {
        super(new Properties().stacksTo(1).durability(404).rarity(RarityTool.LEGENDARY));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.echoed_destiny_ring_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.echoed_destiny_ring_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMI);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new EchoedDestinyRingItemRenderer();
            }
        });
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.HEAD;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            if (player.isInWater() || level.isRaining()) {
                ItemNBTTool.setBoolean(stack, TAG_ECHO, true);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 2, false, false), player);
                player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1, false, false), player);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2, false, false), player);

                if (player.isSwimming()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 300, 0, false, false));
                }
                for (LivingEntity livingentity : player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(30.0D, 30.0D, 30.0D))) {
                    if (livingentity instanceof Player playerEntity && livingentity != player && livingentity.isAlliedTo(player)) {
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1, false, false), player);
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1, false, false), player);
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 0, false, false));
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 300, 0, false, false));
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false), player);
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1, false, false), player);

                        if (player.tickCount % 300 == 0) {
                            playerEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1, false, false), player);
                        }
                    }
                }
            } else {
                ItemNBTTool.setBoolean(stack, TAG_ECHO, false);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1, false, false), player);
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1, false, false), player);

                for (LivingEntity livingentity : player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10.0D, 10.0D, 10.0D))) {
                    if (livingentity instanceof Player playerEntity && livingentity != player) {
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0, false, false), player);
                        playerEntity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 0, false, false));
                    }
                }
            }

            //heal player
            if (player.tickCount % 100 == 0) {
                player.heal(1.0f);
            }

            //give saturation effect when player is dying
            if (player.getHealth() <= 5.0f && !player.getCooldowns().isOnCooldown(stack.getItem())) {
                player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 0, false, false));
                player.getCooldowns().addCooldown(stack.getItem(), 2400);
            }
        }
        super.onArmorTick(stack, level, player);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.FUKAMIZU_RING.hashCode() + slot.toString().hashCode(), 0);
        if (slot == EquipmentSlot.HEAD) {
            map = HashMultimap.create(map);
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_ECHO, false);
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, flag ? 9.0f : 3.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, flag ? 6.0f : 0.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, flag ? 20.0f : 6.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @SubscribeEvent
    public static void onModelBaked(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
        ModelResourceLocation location = new ModelResourceLocation(ItemRegistry.ECHOED_DESTINY_RING.getId(), "inventory");
        BakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException();
        } else if (existingModel instanceof EchoedDestinyRingItemModel) {
            throw new RuntimeException();
        } else {
            EchoedDestinyRingItemModel model = new EchoedDestinyRingItemModel(existingModel);
            event.getModels().put(location, model);
        }
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;
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
        return enchantment.category == EnchantmentCategory.ARMOR_HEAD || enchantment.category == EnchantmentCategory.BREAKABLE ||
                enchantment.category == EnchantmentCategory.ARMOR;
    }
}
