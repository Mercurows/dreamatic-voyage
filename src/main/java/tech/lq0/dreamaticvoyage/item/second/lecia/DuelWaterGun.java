package tech.lq0.dreamaticvoyage.item.second.lecia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.CriteriaRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class DuelWaterGun extends Item {
    public DuelWaterGun() {
        super(new Properties().durability(40));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.duel_water_gun_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.duel_water_gun_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.duel_water_gun.func").withStyle(ChatFormatting.AQUA));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LECIA);
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        if (pLivingEntity instanceof Player player) {
            if (pStack.getDamageValue() < pStack.getMaxDamage()) {
                int strength = (this.getUseDuration(pStack) - pTimeCharged) / 20;

//                WaterCardEntity waterCard = new WaterCardEntity(worldIn, player, Math.min(strength, 5));
//                waterCard.setShooter(player);
//                waterCard.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, 4.0f, 0.0f);
//                worldIn.addEntity(waterCard);

                player.playSound(SoundRegistry.LECIA_HOWL.get(), 1.0F, 1.0F);

                if (!player.isCreative()) {
                    pStack.setDamageValue(pStack.getDamageValue() + 1);
                }
            }
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (pPlayer.isSteppingCarefully()) {
            BlockHitResult result = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.SOURCE_ONLY);
            if (result.getType() == BlockHitResult.Type.BLOCK) {
                BlockState state = pLevel.getBlockState(result.getBlockPos());
                if (state.is(Blocks.WATER)) {
                    stack.setDamageValue(0);
                    pPlayer.playSound(SoundEvents.BUCKET_FILL, 1.0F, 1.0F);
                    return InteractionResultHolder.success(stack);
                } else if (state.is(Blocks.LAVA)) {
                    pPlayer.setSecondsOnFire(10);
                    pPlayer.playSound(SoundRegistry.LECIA_SCREAM.get(), 1.0F, 1.0F);
                    pPlayer.playSound(SoundEvents.BUCKET_FILL_LAVA, 1.0F, 1.0F);

                    if (pPlayer instanceof ServerPlayer serverPlayer) {
                        CriteriaRegistry.FILL_LAVA.trigger(serverPlayer, stack);
                    }

                    return InteractionResultHolder.success(stack);
                }
            }
        } else {
            pPlayer.playSound(SoundRegistry.LECIA_CAST.get(), 1.0F, 1.0F);
        }

        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }
}
