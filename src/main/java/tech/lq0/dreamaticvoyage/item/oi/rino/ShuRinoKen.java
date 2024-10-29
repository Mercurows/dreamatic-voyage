package tech.lq0.dreamaticvoyage.item.oi.rino;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.entity.projectile.ShuRinoKenEntity;
import tech.lq0.dreamaticvoyage.network.ServerEventHandler;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class ShuRinoKen extends SwordItem {
    public ShuRinoKen() {
        super(Tiers.IRON, 1, -2.0f, new Properties().durability(406));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.shu_rino_ken_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.shu_rino_ken_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.RINO);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.DIAMOND;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        if (!worldIn.isClientSide) {
            shootSRK(worldIn, playerIn, playerIn.getYRot());

            ServerEventHandler.queueServerEvent(3, () -> {
                shootSRK(worldIn, playerIn, playerIn.getYRot() - 4.0f);
                shootSRK(worldIn, playerIn, playerIn.getYRot() + 4.0f);
            });

            ServerEventHandler.queueServerEvent(6, () -> {
                shootSRK(worldIn, playerIn, playerIn.getYRot() - 8.0f);
                shootSRK(worldIn, playerIn, playerIn.getYRot());
                shootSRK(worldIn, playerIn, playerIn.getYRot() + 8.0f);
            });

            ServerEventHandler.queueServerEvent(9, () -> {
                shootSRK(worldIn, playerIn, playerIn.getYRot() - 4.0f);
                shootSRK(worldIn, playerIn, playerIn.getYRot() + 4.0f);
            });

            ServerEventHandler.queueServerEvent(12, () -> shootSRK(worldIn, playerIn, playerIn.getYRot()));

            item.hurtAndBreak(10, playerIn, (playerEntity) -> playerEntity.broadcastBreakEvent(handIn));
            playerIn.getCooldowns().addCooldown(item.getItem(), 30);
        }

        return InteractionResultHolder.success(item);
    }

    private void shootSRK(Level level, Player player, float yRot) {
        ShuRinoKenEntity entity = new ShuRinoKenEntity(level, player);
        entity.shootFromRotation(player, player.getXRot(), yRot, 0.0f, 3.0f, 0.2f);
        level.addFreshEntity(entity);
    }
}
