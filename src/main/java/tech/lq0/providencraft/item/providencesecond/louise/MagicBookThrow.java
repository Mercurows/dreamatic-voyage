package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.entity.projectile.WhiteAhogeEntity;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MagicBookThrow extends Item {
    public MagicBookThrow() {
        super(new Properties().durability(242).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(pTooltipComponents);
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_throw_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_throw_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 200;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (!pLevel.isClientSide) {
            int duration = getUseDuration(pStack) - pRemainingUseDuration;
            int k = 15;
            if (duration > 160) {
                k = 5;
            } else if (duration > 60) {
                k = 10;
            }

            if (pRemainingUseDuration % k == 0) {
                WhiteAhogeEntity ahoge1 = new WhiteAhogeEntity(pLevel, pLivingEntity);
                WhiteAhogeEntity ahoge2 = new WhiteAhogeEntity(pLevel, pLivingEntity);
                ahoge1.shootFromRotation(pLivingEntity, pLivingEntity.getXRot(), pLivingEntity.getYRot() - 6.14f, 0.0F, 2.0F, 0.0F);
                ahoge2.shootFromRotation(pLivingEntity, pLivingEntity.getXRot(), pLivingEntity.getYRot() + 6.14f, 0.0F, 2.0F, 0.0F);
                pLevel.addFreshEntity(ahoge1);
                pLevel.addFreshEntity(ahoge2);

                pStack.hurtAndBreak(1, pLivingEntity, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
            }
        }
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if (!entity.level().isClientSide && entity instanceof Player player) {
            player.getCooldowns().addCooldown(stack.getItem(), (getUseDuration(stack) - count) / 2);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }
}
