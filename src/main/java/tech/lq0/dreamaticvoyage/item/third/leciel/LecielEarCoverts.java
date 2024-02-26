package tech.lq0.dreamaticvoyage.item.third.leciel;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.client.models.armor.LecielEarCovertsModel;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LecielEarCoverts extends ArmorItem {
    public LecielEarCoverts() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties().durability(285));
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
                        "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "hat", new LecielEarCovertsModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LecielEarCovertsModel.LAYER_LOCATION)).armorHead,
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
    public @org.jetbrains.annotations.Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/leciel_ear_coverts.png";
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.leciel_ear_coverts_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.leciel_ear_coverts_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LECIEL);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.LECIEL_EAR_COVERTS.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.LUCK,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 2.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Entity entity = event.getTarget();
        Player player = event.getEntity();

        ItemStack item = player.getItemBySlot(EquipmentSlot.HEAD);
        if (item.getItem().equals(ItemRegistry.LECIEL_EAR_COVERTS.get()) && !player.level().isClientSide) {
            if (entity instanceof Animal || entity instanceof Villager) {
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));
                player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 0));

                player.playNotifySound(SoundRegistry.SORRY.get(), SoundSource.AMBIENT, 0.5f, 1.0f);
            }
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == ItemRegistry.REINA_FEATHER.get();
    }
}
