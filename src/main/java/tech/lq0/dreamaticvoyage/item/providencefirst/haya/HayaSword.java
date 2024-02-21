package tech.lq0.dreamaticvoyage.item.providencefirst.haya;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HayaSword extends SwordItem {
    public HayaSword() {
        super(ModItemTier.PURIFIED_CRYSTAL, 4, -2.6f, new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.haya_sword.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.haya_sword_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.haya_sword_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HAYA);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.HAYA_SWORD.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 2.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
        if (getUseDuration(pStack) - pRemainingUseDuration == 20) {
            pLivingEntity.playSound(SoundEvents.ARROW_HIT_PLAYER, 1.0F, 1.0F);
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        if (pLivingEntity instanceof Player player && this.getUseDuration(stack) - pTimeCharged > 20) {
            boolean isOnGround = player.onGround();
            int distance = isOnGround ? 16 : 32;
            float damage = isOnGround ? 9 : 4.5F;

            Vec3 look = player.getLookAngle();
            Vec3 start = player.position().add(0, 0.8, 0);
            Vec3 end = player.position().add(look.x * distance, 0.8, look.z * distance);

            EntityHitResult result;

            List<LivingEntity> target = new ArrayList<>();

            float length = .5f;
            for (int i = -1; i <= 1; i++) {
                do {
                    result = ProjectileUtil.getEntityHitResult(pLevel, player, start.add(look.z * length * i, 0, look.x * length * (-i)), end.add(look.z * length * i, 0, look.x * length * (-i)), player.getBoundingBox().inflate(distance + 10, 0.5, distance + 10), (e) -> (!target.contains(e)) && e != player && !player.isAlliedTo(e) && e instanceof LivingEntity);
                    if (result != null) {
                        target.add((LivingEntity) result.getEntity());
                    }
                } while (result != null);
            }

            target.forEach(e -> {
                e.knockback(1.0F, Mth.sin(player.getYRot() * ((float) Math.PI / 180F)), -Mth.cos(player.getYRot() * ((float) Math.PI / 180F)));
                e.hurt(pLevel.damageSources().playerAttack(player), damage);
            });

            Vec3 v_player = Vec3.directionFromRotation(player.getRotationVector());
            Vec3 v_final = v_player.multiply(4.0f, 0.0f, 4.0f).add(0.0f, 0.2f, 0.0f);

            player.setDeltaMovement(v_final);
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4, true, false));

            stack.hurtAndBreak(1, player, (player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand())));
        }
    }
}
