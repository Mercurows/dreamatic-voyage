package tech.lq0.dreamaticvoyage.item.oi.shirako;

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
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosHelper;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MomoDaifuku extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(6).alwaysEat().build();

    public MomoDaifuku() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.dreamaticvoyage.momo_daifuku_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.dreamaticvoyage.momo_daifuku_2").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.dreamaticvoyage.momo_daifuku.warn").withStyle(ChatFormatting.RED));

        TooltipTool.addChaosInfo(tooltip, 0);
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.finishUsingItem(stack, worldIn, entityLiving);
        if (entityLiving instanceof Player player && !worldIn.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 0));

            int random = (int) (Math.random() * 99 + 1);
            if (random > 90) {
                player.setSecondsOnFire(10);
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.momo_daifuku.fire").withStyle(ChatFormatting.RED), true);
            }

            ChaosHelper.resetChaos(player);
        }
        return itemStack;
    }
}
