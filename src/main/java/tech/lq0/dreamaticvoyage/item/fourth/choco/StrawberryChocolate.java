package tech.lq0.dreamaticvoyage.item.fourth.choco;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class StrawberryChocolate extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(5).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(EffectRegistry.SWEET_MIRAGE.get(), 200, 0), 1.0f)
            .build();

    public StrawberryChocolate() {
        super(new Properties().rarity(Rarity.UNCOMMON).food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.strawberry_chocolate").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHOCO);
    }
}
