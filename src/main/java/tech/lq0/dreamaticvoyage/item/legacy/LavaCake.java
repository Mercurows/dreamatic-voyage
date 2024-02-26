package tech.lq0.dreamaticvoyage.item.legacy;

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
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosHelper;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class LavaCake extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.75f).nutrition(20).build();

    public LavaCake() {
        super(new Properties().food(food).stacksTo(1).rarity(RarityTool.LEGACY));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            ChaosHelper.addChaos(player, 30);

            player.hurt(DamageSourceRegistry.causeLavaCakeDamage(pLevel.registryAccess(), null), 20.0f);
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.lava_cake").withStyle(ChatFormatting.GRAY));

        TooltipTool.addChaosInfo(pTooltipComponents, 30);
        TooltipTool.addLegacyInfo(pTooltipComponents);
    }
}
