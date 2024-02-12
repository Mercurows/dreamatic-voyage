package tech.lq0.providencraft.item.providenceOI.roky;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class Xiaolongbao extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(7).alwaysEat().build();

    public Xiaolongbao() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.xiaolongbao").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.xiaolongbao.warn").withStyle(ChatFormatting.RED));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.ROKY);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 50;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof Player player && !worldIn.isClientSide) {
            double random = Math.random();
            if (random < .05) {
                Explosion explosion = new Explosion(worldIn, player, worldIn.damageSources().explosion(player, player),
                        null, player.getX(), player.getY(), player.getZ(), 2, false, Explosion.BlockInteraction.KEEP);
                explosion.explode();
                explosion.finalizeExplosion(true);

                explosion.clearToBlow();

                for (ServerPlayer serverPlayer : ((ServerLevel) worldIn).players()) {
                    if (serverPlayer.distanceToSqr(player.getX(), player.getY(), player.getZ()) < 100) {
                        serverPlayer.connection.send(new ClientboundExplodePacket(player.getX(), player.getY(), player.getZ(), 2, explosion.getToBlow(), explosion.getHitPlayers().get(player)));
                    }
                }
            }
        }
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
}
