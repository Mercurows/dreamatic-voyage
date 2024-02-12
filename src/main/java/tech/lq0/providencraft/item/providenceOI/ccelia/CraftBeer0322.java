package tech.lq0.providencraft.item.providenceOI.ccelia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.capability.chaos.ChaosHelper;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class CraftBeer0322 extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(5).alwaysEat().
            effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 0.1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200, 1), 1.0f).
            effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f).build();

    public CraftBeer0322() {
        super(new Properties().food(food).fireResistant().stacksTo(1));
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.craft_beer_0322").withStyle(ChatFormatting.GRAY));

        TooltipTool.addChaosInfo(pTooltipComponents, 10);
        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CCELIA);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.finishUsingItem(stack, worldIn, entityLiving);
        if (entityLiving instanceof Player player && !worldIn.isClientSide) {
            ChaosHelper.addChaos(player, 10);
        }
        return itemStack;
    }
}
