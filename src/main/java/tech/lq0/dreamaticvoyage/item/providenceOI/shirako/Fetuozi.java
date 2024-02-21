package tech.lq0.dreamaticvoyage.item.providenceOI.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class Fetuozi extends SwordItem {
    public Fetuozi() {
        super(Tiers.NETHERITE, 13, -3.0f, new Item.Properties().durability(11451).rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fetuozi").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.knockback(10.0f, pAttacker.getX() - pTarget.getX(), pAttacker.getZ() - pTarget.getZ());
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
