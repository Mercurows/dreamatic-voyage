package tech.lq0.providencraft.item.providencefirst.mari;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MagicMirror extends Item {
    public MagicMirror() {
        super(new Properties().durability(136).setNoRepair());
    }

    private final MobEffect[][] EFFECT = {
            {MobEffects.DAMAGE_BOOST, MobEffects.WEAKNESS},
            {MobEffects.MOVEMENT_SPEED, MobEffects.MOVEMENT_SLOWDOWN},
            {MobEffects.SLOW_FALLING, MobEffects.LEVITATION},
            {MobEffects.NIGHT_VISION, MobEffects.CONFUSION},
            {MobEffects.DIG_SPEED, MobEffects.DIG_SLOWDOWN},
            {MobEffects.SATURATION, MobEffects.HUNGER},
            {MobEffects.INVISIBILITY, MobEffects.BLINDNESS},
            {MobEffects.REGENERATION, MobEffects.WITHER}
    };

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        for (MobEffect[] effect : EFFECT) {
            if (pPlayer.hasEffect(effect[0])) {
                pPlayer.removeEffect(effect[0]);
                pPlayer.addEffect(new MobEffectInstance(effect[1], 600, 1));
            } else if (pPlayer.hasEffect(effect[1])) {
                pPlayer.removeEffect(effect[1]);
                pPlayer.addEffect(new MobEffectInstance(effect[0], 600, 1));
            }
        }
        pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 100);
        itemStack.hurtAndBreak(1, pPlayer, (playerEntity) -> playerEntity.broadcastBreakEvent(pUsedHand));

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_mirror_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_mirror_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MARI);
    }
}
