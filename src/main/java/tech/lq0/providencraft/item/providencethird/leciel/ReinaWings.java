package tech.lq0.providencraft.item.providencethird.leciel;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
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
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.armor.ReinaWingsModel;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class ReinaWings extends ArmorItem {
    public ReinaWings() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties().durability(627).rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.getItem() == ItemRegistry.REINA_FEATHER.get();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                HumanoidModel<?> armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of(
                        "body", new ReinaWingsModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ReinaWingsModel.LAYER_LOCATION)).main,
                        "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/reina_wings.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0, true, false));
            if (player.tickCount % 200 == 0) {
                player.getFoodData().eat(1, 0.5f);
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.REINA_WINGS.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_GRAVITY.get(),
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, -0.5f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 0.3f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.reina_wings_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.reina_wings_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LECIEL);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.ARMOR_CHEST || enchantment.category == EnchantmentCategory.BREAKABLE || enchantment.category == EnchantmentCategory.ARMOR;
    }
}
