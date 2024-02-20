package tech.lq0.providencraft.item.providencethird.hiru;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.capability.chaos.ChaosHelper;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class HirenadeGG extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().saturationMod(1).nutrition(5).alwaysEat().
            effect(() -> new MobEffectInstance(MobEffects.WITHER, 200, 0), 1.0f).build();

    public HirenadeGG() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.hirenade_gg_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.hirenade_gg_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addChaosInfo(pTooltipComponents, 50);
        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HIRU);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            ChaosHelper.addChaos(player, 50);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 100;
    }
}
