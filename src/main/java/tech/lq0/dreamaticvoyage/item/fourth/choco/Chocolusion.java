package tech.lq0.dreamaticvoyage.item.fourth.choco;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ParticleRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@SuppressWarnings("SameParameterValue")
public class Chocolusion extends Item {
    private static final double RADIUS = 4;

    public Chocolusion() {
        super(new Properties().stacksTo(1).rarity(RarityTool.LEGENDARY).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(pTooltipComponents);

        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.chocolusion_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.chocolusion_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHOCO);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return EAT_DURATION;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pLivingEntity instanceof Player player) {
            player.getFoodData().eat(1, 0.5f);

            List<Player> players = player.level().getEntitiesOfClass(Player.class, player.getBoundingBox().inflate(RADIUS))
                    .stream().filter(e -> e != player && e.distanceTo(player) <= RADIUS).toList();
            players.forEach(p -> {
                if (pRemainingUseDuration % 2 == 0) {
                    p.getFoodData().eat(1, 0.5f);
                }
            });

            if (!pLevel.isClientSide && pRemainingUseDuration % 2 == 0) {
                spawnCircleParticles(player, RADIUS, (int) RADIUS * 15);
                spawnVerticalParticles(player, RADIUS, 20);
            }
        }

        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if (!entity.level().isClientSide && entity instanceof Player player) {
            player.getCooldowns().addCooldown(stack.getItem(), (getUseDuration(stack) - count) * 10);

            int effectDuration = (int) (((float) (getUseDuration(stack) - count) / (float) getUseDuration(stack)) * 400);

            if (player.getHealth() <= player.getMaxHealth() * 0.5f) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, effectDuration, 3));
            } else if (player.getHealth() >= player.getMaxHealth()) {
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, effectDuration, 3));
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, effectDuration, 1));
            }

            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, effectDuration, 2));
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, effectDuration, 2));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, effectDuration, 2));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, effectDuration, 2));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, effectDuration, 2));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, effectDuration, 2));
        }
    }

    private void spawnCircleParticles(Player player, double radius, int count) {
        ServerLevel level = (ServerLevel) player.level();
        Vec3 playerPos = player.position();
        double angleIncrement = 2 * Math.PI / count;

        for (int i = 0; i < count; ++i) {
            double angle = i * angleIncrement;
            double offsetX = radius * Math.cos(angle);
            double offsetZ = radius * Math.sin(angle);

            level.sendParticles(ParticleRegistry.UMU_LIGHT.get(), playerPos.x + offsetX, playerPos.y + 0.1, playerPos.z + offsetZ,
                    1, 0, 0, 0, 0);
        }
    }

    private void spawnVerticalParticles(Player player, double radius, int count) {
        ServerLevel level = (ServerLevel) player.level();
        Vec3 playerPos = player.position();

        for (int i = 0; i < count; i++) {
            double d0 = playerPos.x + (level.random.nextDouble() - 0.5D) * radius * 1.5;
            double d1 = playerPos.y + level.random.nextDouble() * 2.0D;
            double d2 = playerPos.z + (level.random.nextDouble() - 0.5D) * radius * 1.5;

            double yOffset = 0.5D + level.random.nextDouble() * 1.2D;

            level.sendParticles(ParticleRegistry.UMU_LIGHT.get(), d0, d1, d2, 1, 0.0D, yOffset, 0.0D, 0.0D);
        }
    }
}
