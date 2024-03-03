package tech.lq0.dreamaticvoyage.item.second.mumu;

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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class RedCowHorn extends Item {
    public RedCowHorn() {
        super(new Properties());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.red_cow_horn").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MUMU);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.TOOT_HORN;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        pPlayer.getCooldowns().addCooldown(this, 200);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 80;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            pLevel.playSound(player, pLivingEntity.getOnPos(), SoundEvents.COW_AMBIENT, SoundSource.PLAYERS);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pRemainingUseDuration % 10 == 0 && pRemainingUseDuration <= 20) {
            pLivingEntity.hurt(pLevel.damageSources().inWall(), 1);
        }
    }
}
