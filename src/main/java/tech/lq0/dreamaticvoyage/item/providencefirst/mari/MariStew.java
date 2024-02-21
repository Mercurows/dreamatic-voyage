package tech.lq0.dreamaticvoyage.item.providencefirst.mari;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosHelper;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class MariStew extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.6f).nutrition(10).build();

    public MariStew() {
        super(new Properties().food(food).stacksTo(1));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            int random = (int) (Math.random() * 99 + 1);
            if (random > 95) {
                player.hurt(DamageSourceRegistry.causeMariFoodDamage(pLevel.registryAccess(), null), 20.0f);
            } else if (random > 90) {
                player.heal(20.0f);
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.mari_stew.heal").withStyle(ChatFormatting.GOLD), true);
            } else if (random > 70) {
                player.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
            } else if (random > 40) {
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1));
            } else {
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.mari_stew.nothing").withStyle(ChatFormatting.GRAY), true);
            }

            ChaosHelper.addChaos(player, 10);

            if (player.isCreative()) {
                return pStack;
            }
        }
        return new ItemStack(Items.BOWL);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mari_stew").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mari_stew.warn").withStyle(ChatFormatting.RED));

        TooltipTool.addChaosInfo(pTooltipComponents, 10);
        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MARI);
    }
}
