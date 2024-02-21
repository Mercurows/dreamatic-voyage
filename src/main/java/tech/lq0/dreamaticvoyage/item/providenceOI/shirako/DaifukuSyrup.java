package tech.lq0.dreamaticvoyage.item.providenceOI.shirako;

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
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.entity.projectile.DaifukuSyrupEntity;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class DaifukuSyrup extends Item {
    public static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(1).fast().alwaysEat().build();

    public DaifukuSyrup() {
        super(new Properties().food(food));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.finishUsingItem(stack, worldIn, entityLiving);
        if (entityLiving instanceof Player player && !worldIn.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 0));

            int random = (int) (Math.random() * 99 + 1);
            if (random > 90) {
                player.setSecondsOnFire(2);
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.momo_daifuku.fire").withStyle(ChatFormatting.RED), true);
            }
        }
        return itemStack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.dreamaticvoyage.daifuku_syrup_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.dreamaticvoyage.daifuku_syrup_2").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.dreamaticvoyage.daifuku_syrup_3").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    public DaifukuSyrupEntity createArrow(Level level, LivingEntity livingEntity) {
        return new DaifukuSyrupEntity(level, livingEntity);
    }

    public boolean isInfinite(ItemStack bow) {
        int enchant = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == DaifukuSyrup.class;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
