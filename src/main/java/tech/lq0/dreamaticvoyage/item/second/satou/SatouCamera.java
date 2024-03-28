package tech.lq0.dreamaticvoyage.item.second.satou;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.ArrayList;
import java.util.List;

public class SatouCamera extends Item {
    public SatouCamera() {
        super(new Properties().durability(148));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.satou_camera_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.satou_camera_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SATOU);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide) {
            List<LivingEntity> target = new ArrayList<>();
            Vec3 start = pPlayer.position().add(0, pPlayer.getEyeHeight(), 0);

            EntityHitResult result;

            //最远距离5m
            float distance = 5;

            float yaw = pPlayer.getYRot();
            float pitch = pPlayer.getXRot() < -30 ? -30 : pPlayer.getXRot() > 30 ? 30 : pPlayer.getXRot();

            //生成闪光粒子效果
            ServerLevel serverLevel = (ServerLevel) pLevel;
            serverLevel.sendParticles(ParticleTypes.FLASH, pPlayer.getX() + pPlayer.getLookAngle().x,
                    pPlayer.getY() + pPlayer.getEyeHeight() + pPlayer.getLookAngle().y, pPlayer.getZ() + pPlayer.getLookAngle().z,
                    1, 0, 0, 0, 0);

            //水平±60°
            for (int i = 0; i < 24; i++) {
                //垂直±30°
                for (int j = 0; j < 12; j++) {

                    float finalYaw = (yaw + 5 * (i - 11.5F)) / 180F * 3.14159F;
                    float finalPitch = (pitch + 5 * (j - 5.5F)) / 180F * 3.14159F;

                    Vec3 end = start.add(-distance * Mth.sin(finalYaw) * Mth.cos(finalPitch), -distance * Mth.sin(finalPitch), distance * Mth.cos(finalYaw) * Mth.cos(finalPitch));

                    do {
                        result = ProjectileUtil.getEntityHitResult(pLevel, pPlayer, start, end, pPlayer.getBoundingBox().inflate(distance, distance, distance), (e) -> (!target.contains(e)) && e != pPlayer && !pPlayer.isAlliedTo(e) && e instanceof LivingEntity && !(e instanceof ArmorStand));
                        if (result != null) {
                            target.add((LivingEntity) result.getEntity());
                        }
                    } while (result != null);
                }
            }
            for (LivingEntity livingentity : target) {
                livingentity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0));
                livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 4), pPlayer);

                livingentity.invulnerableTime = 0;
                livingentity.hurt(pLevel.damageSources().playerAttack(pPlayer), 0);
            }

            pPlayer.playNotifySound(SoundRegistry.SHUTTER.get(), SoundSource.AMBIENT, 0.7f, 1f);
            stack.hurtAndBreak(1, pPlayer, player1 -> player1.broadcastBreakEvent(pUsedHand));

            pPlayer.getCooldowns().addCooldown(stack.getItem(), 100);

            return InteractionResultHolder.success(stack);
        }

        return InteractionResultHolder.fail(stack);
    }
}
