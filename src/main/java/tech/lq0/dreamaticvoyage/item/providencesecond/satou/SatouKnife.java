package tech.lq0.dreamaticvoyage.item.providencesecond.satou;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class SatouKnife extends SwordItem {
    public SatouKnife() {
        super(Tiers.IRON, 0, -1.0f, new Properties().durability(321));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pAttacker.isSteppingCarefully()) {
            pStack.hurtAndBreak(10, pAttacker, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
            pAttacker.heal(2.0f);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pIsSelected && pEntity instanceof LivingEntity livingEntity) {
            if (livingEntity.isSteppingCarefully()) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 3, false, false));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, false, false));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 3, false, false));
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.satou_knife").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.satou_knife.func").withStyle(ChatFormatting.AQUA));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SATOU);
    }
}
