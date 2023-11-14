package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class Fetuozi extends SwordItem {
    public Fetuozi() {
        super(Tiers.NETHERITE, 13, -3.0f, new Item.Properties().durability(11451).rarity(Rarity.RARE).fireResistant());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.fetuozi").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.knockback(10.0f, pAttacker.getX() - pTarget.getX(), pAttacker.getZ() - pTarget.getZ());
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
