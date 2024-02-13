package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MagicBookThrow extends Item {
    public MagicBookThrow() {
        super(new Properties().durability(242).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_throw_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_throw_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 200;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return pRepairCandidate.getItem() == ItemRegistry.WHITE_DOUBLE_AHOGE.get();
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        int duration = getUseDuration(pStack) - pRemainingUseDuration;
        int k = 15;
        if (duration > 160) {
            k = 5;
        } else if (duration > 60) {
            k = 10;
        }

        if (pRemainingUseDuration % k == 0) {
            if (!pLevel.isClientSide) {
                WhiteAhogeEntity ahoge1 = new WhiteAhogeEntity(pLevel, pLivingEntity);
                WhiteAhogeEntity ahoge2 = new WhiteAhogeEntity(pLevel, pLivingEntity);
                ahoge1.shootFromRotation(pLivingEntity, pLivingEntity.getXRot(), pLivingEntity.getYRot(), 0.0F, 1.2F, 0.1F);
                ahoge2.shootFromRotation(pLivingEntity, pLivingEntity.getXRot(), pLivingEntity.getYRot(), 0.0F, 0.8F, 0.1F);
                pLevel.addFreshEntity(ahoge1);
                pLevel.addFreshEntity(ahoge2);

                pStack.hurtAndBreak(1, pLivingEntity, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
            }
            pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(),
                    SoundEvents.ARROW_SHOOT, SoundSource.AMBIENT, 0.5F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));
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
