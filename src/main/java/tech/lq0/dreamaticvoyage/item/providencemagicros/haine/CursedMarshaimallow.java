package tech.lq0.dreamaticvoyage.item.providencemagicros.haine;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.entity.projectile.CursedCatDollEntity;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class CursedMarshaimallow extends Item {
    public CursedMarshaimallow() {
        super(new Properties().rarity(Rarity.UNCOMMON));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        playerIn.startUsingItem(handIn);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.SPEAR;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        if (!worldIn.isClientSide) {
            if (entityLiving instanceof Player player) {

                CursedCatDollEntity cursedCatDoll = new CursedCatDollEntity(worldIn, player);
                int usingTime = this.getUseDuration(stack) - timeLeft;

                float power = Math.min(usingTime / 30.0f, 3.5f);

                cursedCatDoll.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, power, 0.0f);
                worldIn.addFreshEntity(cursedCatDoll);

                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                player.getCooldowns().addCooldown(stack.getItem(), 100);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.providencraft.cursed_marshaimallow_1")).withStyle(ChatFormatting.GRAY));
        tooltip.add((Component.translatable("des.providencraft.cursed_marshaimallow_2")).withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.HAINE);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 1000;
    }
}
