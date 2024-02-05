package tech.lq0.providencraft.item.providenceOI.yesa;

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

public class MintChocolate extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.8f).nutrition(4).alwaysEat().
            effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0f).
            effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1.0f).build();

    public MintChocolate() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.mint_chocolate_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.mint_chocolate_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addChaosInfo(pTooltipComponents, -5);
        TooltipTool.addLiverInfo(pTooltipComponents, Livers.YESA);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            ChaosHelper.addChaos(player, -5);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
