package tech.lq0.dreamaticvoyage.item.fourth.choco;

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
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class StrawberryCake extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.2f).nutrition(6).build();

    public StrawberryCake() {
        super(new Properties().food(food));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            double random = Math.random();
            if (random > .2) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0));
            }
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.strawberry_cake_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.strawberry_cake_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHOCO);
    }
}
