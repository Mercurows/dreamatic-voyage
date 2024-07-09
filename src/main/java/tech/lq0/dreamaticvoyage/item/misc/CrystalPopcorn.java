package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

import java.util.List;

public class CrystalPopcorn extends Item {

    private static final FoodProperties food = new FoodProperties.Builder().saturationMod(0.5f).nutrition(8).
            effect(() -> new MobEffectInstance(EffectRegistry.HOLINESS.get(), 1600, 0), 1.0f).build();

    public CrystalPopcorn() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_popcorn").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }
}
