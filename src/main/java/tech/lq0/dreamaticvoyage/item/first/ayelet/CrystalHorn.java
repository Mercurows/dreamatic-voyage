package tech.lq0.dreamaticvoyage.item.first.ayelet;

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
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import tech.lq0.dreamaticvoyage.client.models.armor.CrystalHornModel;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CrystalHorn extends ArmorItem {
    public static final String TAG_NIGHT = "isnight";

    public CrystalHorn() {
        super(ModArmorMaterial.CRYSTAL, Type.HELMET, new Properties());
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.CRYSTAL_HORN.hashCode() + slot.toString().hashCode(), 0);
        if (slot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            boolean night = ItemNBTTool.getBoolean(stack, TAG_NIGHT, false);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, night ? 6.0 : 0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, night ? 4.0 : 0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, night ? 2 : 0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            if (!level.isDay()) {
                ItemNBTTool.setBoolean(stack, TAG_NIGHT, true);
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0));
            } else {
                ItemNBTTool.setBoolean(stack, TAG_NIGHT, false);
            }

            if (player.isSleeping()) {
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 12000, 2));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12000, 2));
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 12000, 0));
            }
        }
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
                        "head", new CrystalHornModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CrystalHornModel.LAYER_LOCATION)).main,
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
        return Utils.MOD_ID + ":textures/models/armor/crystal_horn.png";
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_horn_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_horn_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_horn_3").withStyle(ChatFormatting.RED));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.AYELET);
    }

    //对牛特攻
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();

        Entity entityP = event.getSource().getDirectEntity();
        if (entityP instanceof LivingEntity livingEntity && !entityP.level().isClientSide()) {
            ItemStack item = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
            if (item.getItem().equals(ItemRegistry.CRYSTAL_HORN.get())) {
                if (entity instanceof Cow) {
                    event.setAmount(event.getAmount() + 200);
                }
            }
        }
    }
}
