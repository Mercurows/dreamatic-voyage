package tech.lq0.dreamaticvoyage.item.first.mitsuki;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.models.armor.MitsukiCrownModel;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MitsukiCrown extends ArmorItem {
    public MitsukiCrown() {
        super(ArmorMaterials.IRON, Type.HELMET, new Properties().durability(411).setNoRepair());
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
                        "hat", new MitsukiCrownModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(MitsukiCrownModel.LAYER_LOCATION)).armorHead,
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
        return Utils.MOD_ID + ":textures/models/armor/mitsuki_crown.png";
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mitsuki_crown_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mitsuki_crown_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MITSUKI);
    }

//    @SubscribeEvent
//    public static void crownEffect(AttackEntityEvent event) {
//        LivingEntity entity = event.getEntityLiving();
//        Entity target = event.getTarget();
//        if (entity instanceof PlayerEntity && !entity.world.isRemote) {
//            PlayerEntity player = (PlayerEntity) entity;
//            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
//            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.CROWN.get())) {
//                player.heal(0.5f);
//                if (target instanceof LivingEntity) {
//                    LivingEntity entityT = (LivingEntity) target;
//                    entityT.addPotionEffect(new EffectInstance(Effects.WITHER, 60, 0));
//                }
//            }
//        }
//    }
}
