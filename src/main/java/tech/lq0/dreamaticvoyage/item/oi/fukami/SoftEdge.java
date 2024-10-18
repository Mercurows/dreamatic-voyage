package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.ModTags;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.text.DecimalFormat;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SoftEdge extends SwordItem {
    public static final float MAX_DAMAGE = 3000.0f;
    public static final int MAX_HUNGER = 200;

    public SoftEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 1, -2.8f, new Properties().setNoRepair().fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.soft_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.soft_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
        handleUpgradeTooltips(pStack, pTooltipComponents);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }

    @Override
    public SoundEvent getEatingSound() {
        return super.getEatingSound();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F + (pLevel.random.nextFloat() - pLevel.random.nextFloat()) * 0.4F);
        if (!pLevel.isClientSide) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0), pLivingEntity);
        }
        if (pLivingEntity instanceof Player player) {
            int hunger = player.getFoodData().getFoodLevel();
            float saturation = player.getFoodData().getSaturationLevel();
            pStack.getOrCreateTag().putInt("Hunger",
                    pStack.getOrCreateTag().getInt("Hunger") + Math.min(20 - hunger, 5) + (int) Math.min(20 - saturation, 5));

            player.getFoodData().eat(5, 0.5f);
            player.getCooldowns().addCooldown(this, 600);
        }
        pLivingEntity.gameEvent(GameEvent.EAT);
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    private void handleUpgradeTooltips(ItemStack pStack, List<Component> pTooltipComponents) {
        pTooltipComponents.add(Component.literal(""));
        TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.ctrl_hide").withStyle(ChatFormatting.YELLOW), true);

        float damage = pStack.getOrCreateTag().getFloat("CausedDamage");
        int hunger = pStack.getOrCreateTag().getInt("Hunger");

        float damageProgress = Math.min(1, damage / MAX_DAMAGE);
        float hungerProgress = Math.min(1, (float) hunger / MAX_HUNGER);

        int count = 0;
        if (damageProgress >= 1) {
            count++;
        }
        if (hungerProgress >= 1) {
            count++;
        }

        if (count >= 2) {
            TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.complete").withStyle(ChatFormatting.GREEN));
        }

        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.progress").withStyle(ChatFormatting.YELLOW)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(count + " / 2").withStyle(count == 2 ? ChatFormatting.GREEN : ChatFormatting.WHITE)));
        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.damage").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(new DecimalFormat("#0.0").format(damage) + " / " + MAX_DAMAGE).withStyle(damageProgress >= 1 ? ChatFormatting.GREEN : ChatFormatting.GRAY))));
        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.hunger").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(hunger + " / " + MAX_HUNGER).withStyle(hungerProgress >= 1 ? ChatFormatting.GREEN : ChatFormatting.GRAY))));
    }

    /**
     * 深水锋芒系列通用方法，仅在本类中实现
     */
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        var source = event.getSource();
        if (!source.is(DamageTypes.PLAYER_ATTACK)) return;

        var sourceEntity = source.getEntity();
        if (!(sourceEntity instanceof Player player)) return;

        ItemStack stack = player.getMainHandItem();
        if (stack.is(ModTags.Items.FUKAMIZU_EDGE)) {
            stack.getOrCreateTag().putFloat("CausedDamage", stack.getOrCreateTag().getFloat("CausedDamage") + event.getAmount());
        }
    }
}
