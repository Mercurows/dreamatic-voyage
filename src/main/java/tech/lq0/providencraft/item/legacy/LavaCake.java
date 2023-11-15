package tech.lq0.providencraft.item.legacy;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class LavaCake extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.75f).nutrition(20).build();

    public LavaCake() {
        super(new Properties().food(food).stacksTo(1).rarity(Rarity.RARE));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            player.hurt(DamageSourceRegistry.causeLavaCakeDamage(pLevel.registryAccess()), 20.0f);
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.lava_cake").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLegacyInfo(pTooltipComponents);
    }
}
