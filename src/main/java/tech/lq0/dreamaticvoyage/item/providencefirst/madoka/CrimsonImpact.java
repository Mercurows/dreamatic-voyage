package tech.lq0.dreamaticvoyage.item.providencefirst.madoka;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class CrimsonImpact extends SwordItem {
    public CrimsonImpact() {
        super(ModItemTier.RED_AHOGE, 2, -1.2f, new Properties().durability(429).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.crimson_impact_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.crimson_impact_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MADOKA);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        double random = Math.random();
        if (random > .7f) {
            pTarget.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 200, 1));
        }

        if (pAttacker instanceof Player player) {
            if (player.isSteppingCarefully()) {
                Vec3 vec = new Vec3(pTarget.getX() - pAttacker.getX(), 0, pTarget.getZ() - pAttacker.getZ())
                        .normalize().scale(1.5).add(0, 1.0, 0);

                pTarget.setDeltaMovement(vec);
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
