package tech.lq0.providencraft.item.providencethird.yuki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.capability.chaos.ChaosHelper;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class FoxIceCream extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.4f).nutrition(6).build();

    public FoxIceCream() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.fox_ice_cream").withStyle(ChatFormatting.GRAY));

        TooltipTool.addChaosInfo(pTooltipComponents, -1);
        TooltipTool.addLiverInfo(pTooltipComponents, Livers.YUKI);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            ChaosHelper.addChaos(player, -1);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
