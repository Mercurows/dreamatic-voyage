package tech.lq0.dreamaticvoyage.item.providencemagicros.ekira;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class CrystalBall extends Item {
    public CrystalBall() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            if (pLevel.isThundering()) {
                pPlayer.displayClientMessage(Component.translatable("des.dreamaticvoyage.crystal_ball.weather_thunder").withStyle(ChatFormatting.YELLOW), true);
            } else if (pLevel.isRaining()) {
                pPlayer.displayClientMessage(Component.translatable("des.dreamaticvoyage.crystal_ball.weather_rain").withStyle(ChatFormatting.AQUA), true);
            } else {
                pPlayer.displayClientMessage(Component.translatable("des.dreamaticvoyage.crystal_ball.weather_clear").withStyle(ChatFormatting.GREEN), true);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_ball.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_ball").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.EKIRA);
    }
}
