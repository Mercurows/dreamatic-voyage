package tech.lq0.providencraft.item.providenceOI.shirako;

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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

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
                player.displayClientMessage(Component.translatable("des.providencraft.momo_daifuku.fire").withStyle(ChatFormatting.RED), true);
            }
        }
        return itemStack;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.providencraft.daifuku_syrup_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.providencraft.daifuku_syrup_2").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.providencraft.daifuku_syrup_3").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

//    public DaifukuSyrupEntity createArrow(World p_200887_1_, ItemStack p_200887_2_, LivingEntity p_200887_3_) {
//        return new DaifukuSyrupEntity(p_200887_1_, p_200887_3_);
//    }
//
//    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
//        int enchant = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow);
//        return enchant > 0 && this.getClass() == DaifukuSyrup.class;
//    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
