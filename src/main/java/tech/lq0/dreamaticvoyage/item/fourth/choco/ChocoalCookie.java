package tech.lq0.dreamaticvoyage.item.fourth.choco;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Random;

public class ChocoalCookie extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 100, 0), 1.0f).build();

    public ChocoalCookie() {
        super(new Properties().food(food).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.chocoal_cookie").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHOCO);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            player.hurt(DamageSourceRegistry.causeChocoalCookieDamage(pLevel.registryAccess(), null), 2.0f);
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pInteractionTarget instanceof Phantom phantom && !pPlayer.level().isClientSide && !pPlayer.getCooldowns().isOnCooldown(this)) {
            int size = phantom.getPhantomSize();

            if (size < 10) {
                Random random = new Random();
                if (random.nextFloat() < .5f) {
                    phantom.setPhantomSize(size + 3);
                } else {
                    phantom.hurt(DamageSourceRegistry.causeChocoalCookieDamage(phantom.level().registryAccess(), pPlayer), 5.0f);
                    if (size > 1) {
                        phantom.setPhantomSize(size - 1);
                    }
                }

                pStack.shrink(1);
                pPlayer.getCooldowns().addCooldown(this, 40);

                return InteractionResult.SUCCESS;
            }
        }

        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 3200;
    }
}
