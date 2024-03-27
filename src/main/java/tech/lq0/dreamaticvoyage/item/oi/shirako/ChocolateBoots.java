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
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class ChocolateBoots extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.8f).nutrition(5)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 1), 1.0f).build();

    public ChocolateBoots() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.dreamaticvoyage.chocolate_boots_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.dreamaticvoyage.chocolate_boots_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addChaosInfo(tooltip, 200);
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.finishUsingItem(stack, worldIn, entityLiving);
        if (entityLiving instanceof Player player && !worldIn.isClientSide) {
            int chaos = ChaosHelper.getChaos(player);

            if (chaos < 0) {
                player.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 100, 0), player);
            }

            ChaosHelper.addChaos(player, 200);
        }
        return itemStack;
    }
}
