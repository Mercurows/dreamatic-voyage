package tech.lq0.dreamaticvoyage.item.magicros.chiram;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class CandleCake extends Item {

    private static final FoodProperties FOOD = new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat().build();

    public CandleCake() {
        super(new Properties().food(FOOD).durability(8));
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
        return pStack.getDamageValue() >= pStack.getMaxDamage() ? new ItemStack(Items.CAKE) : pStack;
    }
}
