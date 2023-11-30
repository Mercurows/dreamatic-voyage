package tech.lq0.providencraft.item.providencefirst.haya;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class BigSpoon extends SwordItem {
    public BigSpoon() {
        super(Tiers.IRON, 8, -3.2f, new Item.Properties().durability(518));
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

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.big_spoon").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HAYA);
    }
}
