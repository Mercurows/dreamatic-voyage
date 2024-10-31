package tech.lq0.dreamaticvoyage.item.magicros.chiram;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class CandleCake extends Item {

    private static final FoodProperties FOOD = new FoodProperties.Builder().nutrition(5).saturationMod(0.4f).alwaysEat().build();

    public CandleCake() {
        super(new Properties().food(FOOD).durability(4));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        switch (pStack.getDamageValue()) {
            case 0 ->
                    pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.candle_cake_1").withStyle(ChatFormatting.GRAY));
            case 1 ->
                    pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.candle_cake_2").withStyle(ChatFormatting.GRAY));
            case 2 ->
                    pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.candle_cake_3").withStyle(ChatFormatting.GRAY));
            case 3 ->
                    pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.candle_cake_4").withStyle(ChatFormatting.GRAY));
        }

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHIRAM);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 16;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), pLivingEntity.getEatingSound(pStack), SoundSource.NEUTRAL, 1.0F, 1.0F + (pLevel.random.nextFloat() - pLevel.random.nextFloat()) * 0.4F);
        if (!(pLivingEntity instanceof Player) || !((Player) pLivingEntity).getAbilities().instabuild) {
            pStack.setDamageValue(Math.min(pStack.getDamageValue() + 1, pStack.getMaxDamage()));
        }
        if (pLivingEntity instanceof Player player) {
            player.getFoodData().eat(pStack.getItem(), pStack, player);
        }
        pLivingEntity.gameEvent(GameEvent.EAT);
        return pStack.getDamageValue() >= pStack.getMaxDamage() ? ItemStack.EMPTY : pStack;
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return false;
    }
}
