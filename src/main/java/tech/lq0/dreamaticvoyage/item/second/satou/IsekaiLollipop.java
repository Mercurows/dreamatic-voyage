package tech.lq0.dreamaticvoyage.item.second.satou;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosHelper;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IsekaiLollipop extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().saturationMod(0.5f).nutrition(14)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 2), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, 0), 1.0F)
            .alwaysEat().build();

    public IsekaiLollipop() {
        super(new Properties().fireResistant().stacksTo(1).food(food));
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        int level = checkEnchantments(pStack);
        if (level <= 10) {
            return Rarity.UNCOMMON;
        } else if (level < 30) {
            return Rarity.RARE;
        } else {
            return Rarity.EPIC;
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.isekai_lollipop_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.isekai_lollipop_2").withStyle(ChatFormatting.GRAY));
        if (checkEnchantments(pStack) >= 30) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.isekai_lollipop_4").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
        } else if (checkEnchantments(pStack) > 10) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.isekai_lollipop_3").withStyle(ChatFormatting.LIGHT_PURPLE).withStyle(ChatFormatting.ITALIC));
        }

        TooltipTool.addChaosInfo(pTooltipComponents, -50);
        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SATOU);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            int lvl = checkEnchantments(pStack);
            if (lvl > 10) {
                int random = (int) (Math.random() * 100) + 1;
                if (random <= (lvl - 10) * 5) {
                    player.hurt(pLevel.damageSources().magic(), 5.0f);
                    player.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 200, 0));

                    return player.isCreative() ? pStack : new ItemStack(ItemRegistry.PAST_SUGAR.get());
                }
            }

            ChaosHelper.addChaos(player, -50);
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    public int checkEnchantments(ItemStack stack) {
        AtomicInteger sum = new AtomicInteger();
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack);
        map.forEach(((enchantment, integer) -> sum.addAndGet(integer)));

        return sum.get();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 20;
    }
}
