package tech.lq0.dreamaticvoyage.item.fourth.hifumi;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

public class NetherLight extends SwordItem {
    public NetherLight() {
        super(Tiers.IRON, 1, -1.5f, new Properties().durability(321));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.nether_light_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.nether_light_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HIFUMI);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 80, 1), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 80, 0), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 0));

        pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0), pAttacker);
        pAttacker.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0));

        double random = Math.random();
        if (random < 0.123) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 0), pAttacker);
            pAttacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0), pAttacker);
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
