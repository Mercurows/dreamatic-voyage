package tech.lq0.dreamaticvoyage.item.third.hiru;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.npc.Villager;
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
import tech.lq0.dreamaticvoyage.client.models.armor.HiruHeadModel;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.ParticleRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HiruTentacles extends ArmorItem {
    public HiruTentacles() {
        super(ModArmorMaterial.PURIFIED_CRYSTAL, Type.LEGGINGS, new Properties());
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
                        "head", new HiruHeadModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(HiruHeadModel.LAYER_LOCATION)).armorHead,
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
        return Utils.MOD_ID + ":textures/models/armor/hiru_tentacles.png";
    }

    @SubscribeEvent
    public static void tentacleEffect(LivingHurtEvent event) {
        LivingEntity living = event.getEntity();

        if (living instanceof Player player) {
            ItemStack chestplate = player.getItemBySlot(EquipmentSlot.LEGS);
            int count = 0;

            if (!player.level().isClientSide && !chestplate.isEmpty() && chestplate.getItem().equals(ItemRegistry.HIRU_TENTACLES.get())) {
                for (Mob mobEntity : player.level().getEntitiesOfClass(Mob.class, player.getBoundingBox().inflate(20.0D, 20.0D, 20.0D))) {
                    if (player.distanceToSqr(mobEntity) < 400.0f && !player.isAlliedTo(mobEntity) && !mobEntity.hasCustomName() &&
                            !(mobEntity instanceof Animal) && !(mobEntity instanceof Villager) && !(mobEntity instanceof Allay) &&
                            !(mobEntity instanceof IronGolem) && !(mobEntity instanceof SnowGolem)) {
                        spawnTentacleParticles(player, mobEntity);

                        count++;
                        if (count > 3) {
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void spawnTentacleParticles(Player player, Mob mobEntity) {
        double[] px = {player.getX() + 0.95f * Mth.cos(player.getDirection().toYRot()),
                player.getX() - 0.95f * Mth.cos(player.getDirection().toYRot()),
                player.getX() + 0.65f * Mth.cos(player.getDirection().toYRot()),
                player.getX() - 0.65f * Mth.cos(player.getDirection().toYRot())};
        double[] py = {player.getY() + 1.5f, player.getY() + 1.5f, player.getY() + 0.5f, player.getY() + 0.5f};
        double[] pz = {player.getZ() + 0.95f * Mth.sin(player.getDirection().toYRot()),
                player.getZ() + 0.95f * Mth.sin(player.getDirection().toYRot()),
                player.getZ() + 0.95f * Mth.sin(player.getDirection().toYRot()),
                player.getZ() + 0.95f * Mth.sin(player.getDirection().toYRot())};
        double tx = mobEntity.getX();
        double ty = mobEntity.getY() + 0.5f;
        double tz = mobEntity.getZ();

        int j = (int) (Math.random() * 4);

        mobEntity.hurt(mobEntity.level().damageSources().thorns(player), 4);
        mobEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 4));

        if (player.level() instanceof ServerLevel serverLevel) {
            for (int i = 0; i < 20; i++) {
                serverLevel.sendParticles(ParticleRegistry.TENTACLE.get(), px[j] + (tx - px[j]) * (i / 20.0),
                        py[j] + (ty - py[j]) * (i / 20.0), pz[j] + (tz - pz[j]) * (i / 20.0), 0, 0.0, 0.0, 0.0, 0.0D);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hiru_tentacles.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hiru_tentacles_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hiru_tentacles_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HIRU);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.HIRU_TENTACLES.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.MAX_HEALTH, new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 6.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
