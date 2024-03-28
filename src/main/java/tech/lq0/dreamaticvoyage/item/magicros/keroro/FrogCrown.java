package tech.lq0.dreamaticvoyage.item.magicros.keroro;

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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.client.models.armor.FrogCrownModel;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class FrogCrown extends ArmorItem {
    public static final String TAG_RAIN = "isRaining";

    public FrogCrown() {
        super(ArmorMaterials.GOLD, Type.HELMET, new Properties().durability(302));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                HumanoidModel<?> armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of(
                        "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "head", new FrogCrownModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(FrogCrownModel.LAYER_LOCATION)).armorHead,
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

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/frog_crown.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isRaining()) {
            ItemNBTTool.setBoolean(stack, TAG_RAIN, true);
            if (player.tickCount % 300 == 0) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false), player);
            }
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 300, 0, false, false), player);
        } else {
            ItemNBTTool.setBoolean(stack, TAG_RAIN, false);
        }

        if (player.isSwimming()) {
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 0, false, false));
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.FROG_CROWN.hashCode() + slot.toString().hashCode(), 0);
        if (slot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            boolean rain = ItemNBTTool.getBoolean(stack, TAG_RAIN, false);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, rain ? 2.0 : 0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, rain ? 4.0 : 0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.frog_crown_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.frog_crown_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.KERORO);
    }
}
