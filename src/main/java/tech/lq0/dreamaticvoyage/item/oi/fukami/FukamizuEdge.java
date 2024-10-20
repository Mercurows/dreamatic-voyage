package tech.lq0.dreamaticvoyage.item.oi.fukami;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.UUID;

public class FukamizuEdge extends SwordItem {

    public FukamizuEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 9, -2.5f, new Properties().setNoRepair().rarity(Rarity.EPIC).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fukamizu_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fukamizu_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 200;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pTarget.level().isClientSide && pTarget.level().random.nextDouble() < .8) {
            pTarget.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 160,
                    pTarget.level().random.nextIntBetweenInclusive(1, 3)), pAttacker);
        }

        return true;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pLivingEntity instanceof Player player) {
            if (!pLevel.isClientSide) {
                HitResult result = getHitResult(pLevel, player);
                if (result.getType() == HitResult.Type.ENTITY) {
                    EntityHitResult hitResult = (EntityHitResult) result;
                    if (hitResult.getEntity() instanceof LivingEntity living) {
                        var attr = player.getAttribute(Attributes.ATTACK_DAMAGE);
                        living.hurt(pLevel.damageSources().playerAttack(player), attr == null ? 3f : (float) (attr.getValue() / 5.0f));
                        living.invulnerableTime = 0;

                        if (pRemainingUseDuration % 5 == 0) {
                            player.getFoodData().eat(1, 0.6f);
                        }
                    }
                }
            }
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    private HitResult getHitResult(Level level, Player player) {
        double entityReach = player.getEntityReach() * 1.5f;
        HitResult rayTrace = Item.getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
        Vec3 vec = player.getEyePosition(1.0f);

        double distance = rayTrace.getLocation().distanceToSqr(vec);
        Vec3 viewVector = player.getViewVector(1.0f);
        Vec3 addedVec = vec.add(viewVector.x * entityReach, viewVector.y * entityReach, viewVector.z * entityReach);

        AABB aabb = player.getBoundingBox().expandTowards(viewVector.scale(entityReach)).inflate(1.0d, 1.0d, 1.0d);
        EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(player, vec, addedVec, aabb, entity -> !entity.isSpectator() && entity.isPickable(), distance);
        if (hitResult != null) {
            rayTrace = hitResult;
        }
        return rayTrace;
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if (!entity.level().isClientSide && entity instanceof Player player) {
            int tick = getUseDuration(stack) - count;
            Level level = player.level();
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);

            if (!level.isClientSide) {
                player.heal(8.0f * ((float) tick / (float) getUseDuration(stack)));
            }
            player.gameEvent(GameEvent.EAT);
            player.getCooldowns().addCooldown(stack.getItem(), tick * 4);
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pIsSelected && pEntity instanceof LivingEntity living) {
            if (!pLevel.isClientSide) {
                living.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0, false, false), living);

                if (living.isInWater()) {
                    living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1, false, false), living);
                    living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, false, false), living);
                }
            }
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.SWOLLEN_EDGE.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 2.0f, AttributeModifier.Operation.ADDITION));
            map.put(ForgeMod.BLOCK_REACH.get(),
                    new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 2.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

}
