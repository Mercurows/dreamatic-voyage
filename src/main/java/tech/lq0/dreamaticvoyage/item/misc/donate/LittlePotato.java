package tech.lq0.dreamaticvoyage.item.misc.donate;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class LittlePotato extends Item {
    public static final FoodProperties food = new FoodProperties.Builder().saturationMod(0.5f).nutrition(20).build();

    public LittlePotato() {
        super(new Properties().food(food).rarity(RarityTool.DONATE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.little_potato").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDonateInfo(pTooltipComponents);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            player.displayClientMessage(Component.translatable("des.dreamaticvoyage.little_potato.eaten").withStyle(ChatFormatting.WHITE), true);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 120;
    }
}
