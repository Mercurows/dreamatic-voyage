package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class ColorfulEdge extends SwordItem {
    public static final int MAX_HUNGER = 2400;

    public ColorfulEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 3, -2.5f, new Properties().setNoRepair().rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.colorful_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.colorful_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
        handleUpgradeTooltips(pStack, pTooltipComponents);
    }

    private void handleUpgradeTooltips(ItemStack pStack, List<Component> pTooltipComponents) {
        pTooltipComponents.add(Component.literal(""));
        TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.ctrl_hide").withStyle(ChatFormatting.YELLOW), true);

        int hunger = pStack.getOrCreateTag().getInt("Hunger");
        float hungerProgress = Math.min(1, (float) hunger / MAX_HUNGER);

        int count = 0;
        if (hungerProgress >= 1) {
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
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.hunger").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(hunger + " / " + MAX_HUNGER)
                                .withStyle(hungerProgress >= 1 ? ChatFormatting.GREEN : ChatFormatting.GRAY))));
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
        return 48;
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
            pLivingEntity.heal(4.0f);
        }
        if (pLivingEntity instanceof Player player) {
            int hunger = player.getFoodData().getFoodLevel();
            float saturation = player.getFoodData().getSaturationLevel();
            pStack.getOrCreateTag().putInt("Hunger",
                    pStack.getOrCreateTag().getInt("Hunger") + Math.min(20 - hunger, 10) + (int) Math.min(20 - saturation, 12));

            player.getFoodData().eat(10, 0.6f);
            player.getCooldowns().addCooldown(this, 400);
        }
        pLivingEntity.gameEvent(GameEvent.EAT);
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
