package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.text.DecimalFormat;
import java.util.List;

public class SerrationEdge extends SwordItem {
    public static final float MAX_DAMAGE = 80000.0f;

    public SerrationEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 12, -2.8f, new Properties().setNoRepair().rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.serration_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.serration_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
        handleUpgradeTooltips(pStack, pTooltipComponents);
    }

    private void handleUpgradeTooltips(ItemStack pStack, List<Component> pTooltipComponents) {
        pTooltipComponents.add(Component.literal(""));
        TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.ctrl_hide").withStyle(ChatFormatting.YELLOW), true);

        float damage = pStack.getOrCreateTag().getFloat("CausedDamage");
        float damageProgress = Math.min(2, damage / MAX_DAMAGE);

        int count = 0;
        if (damageProgress >= 1) {
            count++;
        }

        if (count >= 1) {
            TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.complete").withStyle(ChatFormatting.GREEN));
        }

        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.progress").withStyle(ChatFormatting.YELLOW)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(count + " / 1").withStyle(count == 1 ? ChatFormatting.GREEN : ChatFormatting.WHITE)));
        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.damage").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(new DecimalFormat("#0.0").format(damage) + " / " + MAX_DAMAGE)
                                .withStyle(damageProgress >= 1 ? ChatFormatting.GREEN : ChatFormatting.GRAY))));
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 100;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pTarget.level().isClientSide && pTarget.level().random.nextDouble() < .5) {
            pTarget.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 100,
                    pTarget.level().random.nextIntBetweenInclusive(0, 2)), pAttacker);
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
                        living.hurt(pLevel.damageSources().playerAttack(player), 1.5f);
                        living.invulnerableTime = 0;
                    }
                }
            }
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    private HitResult getHitResult(Level level, Player player) {
        double entityReach = player.getEntityReach();
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
            player.getCooldowns().addCooldown(stack.getItem(), (getUseDuration(stack) - count) * 6);
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
}
