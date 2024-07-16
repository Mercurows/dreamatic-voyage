package tech.lq0.dreamaticvoyage.item.misc.donate;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
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
import tech.lq0.dreamaticvoyage.client.models.armor.OrangeTrackerModel;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OrangeTracker extends ArmorItem {
    public static final String TAG_ABLE = "able";

    public OrangeTracker() {
        super(ArmorMaterials.CHAIN, Type.LEGGINGS, new Properties().durability(2022).rarity(RarityTool.DONATE));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                HumanoidModel<?> armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of(
                        "body", new OrangeTrackerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(OrangeTrackerModel.LAYER_LOCATION)).armorBody,
                        "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_leg", new OrangeTrackerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(OrangeTrackerModel.LAYER_LOCATION)).armorRightLeg,
                        "left_leg", new OrangeTrackerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(OrangeTrackerModel.LAYER_LOCATION)).armorLeftLeg)));
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/orange_tracker.png";
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.orange_tracker_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.orange_tracker_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.orange_tracker_3").withStyle(ChatFormatting.RED));

        TooltipTool.addDonateInfo(pTooltipComponents);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        if (pPlayer.isSteppingCarefully()) {
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_ABLE, false);
            ItemNBTTool.setBoolean(stack, TAG_ABLE, !flag);
            pPlayer.displayClientMessage(!flag ? Component.translatable("des.dreamaticvoyage.orange_tracker.enable") :
                    Component.translatable("des.dreamaticvoyage.orange_tracker.disable"), true);
            return InteractionResultHolder.fail(stack);
        } else {
            return super.use(pLevel, pPlayer, pHand);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pSlotId == getEquipmentSlot().getIndex() && !level.isClientSide && pEntity instanceof LivingEntity living) {
            if (ItemNBTTool.getBoolean(stack, TAG_ABLE, false)) {
                if (living.tickCount % 40 == 0) {
                    int r = 5;
                    AABB area = new AABB(living.getOnPos().offset(-r, -r, -r), living.getOnPos().offset(r, r, r));

                    List<ItemEntity> items = living.level().getEntities(EntityType.ITEM, area,
                            item -> item.isAlive() && (living.level().isClientSide || item.tickCount > 1) &&
                                    (item.getOwner() == null || !item.getOwner().equals(living) || !item.hasPickUpDelay()) &&
                                    !item.getItem().isEmpty()
                    );
                    items.forEach(item -> item.setPos(living.getX(), living.getY(), living.getZ()));
                }
            }

            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1, false, false), living);
            living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1, false, false), living);
        }

        super.inventoryTick(stack, level, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.ORANGE_TRACKER.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.1, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player player && !player.level().isClientSide) {
            ItemStack tracker = player.getItemBySlot(EquipmentSlot.LEGS);
            if (!tracker.isEmpty() && tracker.getItem().equals(ItemRegistry.ORANGE_TRACKER.get())) {
                int random = (int) (Math.random() * 10 + 1);
                if (random == 1) {
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0));
                }
            }
        }
    }
}
