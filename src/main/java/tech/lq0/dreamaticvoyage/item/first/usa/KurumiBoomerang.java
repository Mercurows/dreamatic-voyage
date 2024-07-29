package tech.lq0.dreamaticvoyage.item.first.usa;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.entity.projectile.KurumiBoomerangEntity;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class KurumiBoomerang extends Item {

    public KurumiBoomerang() {
        super(new Properties());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.kurumi_boomerang").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.USA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide()) {
            KurumiBoomerangEntity kurumiBoomerangEntity = new KurumiBoomerangEntity(pLevel, pPlayer);
            kurumiBoomerangEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 3.0f, 0.2f);

            if (pPlayer.isCreative()) {
                kurumiBoomerangEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            }

            pLevel.addFreshEntity(kurumiBoomerangEntity);
            item.shrink(1);
        }
        pPlayer.awardStat(Stats.ITEM_USED.get(this));

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }
}
