package tech.lq0.dreamaticvoyage.item.providencefirst.haya;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class Hayamen extends ShieldItem {
    public Hayamen() {
        super(new Properties().durability(1520).rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.hayamen.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.hayamen_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.hayamen_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HAYA);
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.getItem() == Items.DIAMOND;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);

        if (pPlayer.isSteppingCarefully()) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 4));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 4));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 1));

            itemstack.hurtAndBreak(80, pPlayer, (playerEntity) -> playerEntity.broadcastBreakEvent(pHand));
            pPlayer.getCooldowns().addCooldown(itemstack.getItem(), 200);
        }

        return InteractionResultHolder.consume(itemstack);
    }
}
