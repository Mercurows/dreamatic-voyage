package tech.lq0.dreamaticvoyage.item.donate;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class SakuraBeanCurd extends Item {
    public static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(4).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 3), 1.0f).build();

    public SakuraBeanCurd() {
        super(new Properties().rarity(RarityTool.DONATE).food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.sakura_bean_curd").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDonateInfo(pTooltipComponents);
    }
}
