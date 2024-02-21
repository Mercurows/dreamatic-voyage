package tech.lq0.dreamaticvoyage.item.providencefirst.haya;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class BigSpoon extends SwordItem {
    public BigSpoon() {
        super(ModItemTier.HARDEN_CRYSTAL, 8, -3.2f, new Item.Properties().durability(518));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pAttacker instanceof Player player) {
            int food = 1;

            if (pTarget instanceof Monster) {
                if (pTarget.getMobType() == MobType.UNDEAD) {
                    food = 2;
                } else {
                    food = 4;
                }
            } else if (pTarget instanceof Animal) {
                food = 6;
            }

            if (pTarget.isDeadOrDying()) {
                player.getFoodData().eat(food, 0.75f);
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.big_spoon").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HAYA);
    }
}
