package tech.lq0.dreamaticvoyage.item.second.louise;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class MagicBookMyannaPlus extends Item {
    public MagicBookMyannaPlus() {
        super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magic_book_myanna_plus.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magic_book_myanna_plus").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magic_book_myanna_plus.warn").withStyle(ChatFormatting.RED));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(EffectRegistry.BLESS_OF_DARK_ELF.get(), 600, 4), pPlayer);
            pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 2), pPlayer);
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 2), pPlayer);

            int random = (int) (Math.random() * 10 + 1);
            if (random <= 3) {
                pPlayer.addEffect(new MobEffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 600, 2), pPlayer);
                pPlayer.displayClientMessage(Component.translatable("des.dreamaticvoyage.magic_book_myanna_plus.be_cursed").withStyle(ChatFormatting.RED), true);
            }
        }
        pPlayer.getCooldowns().addCooldown(stack.getItem(), 3600);
        pLevel.playSound(pPlayer, pPlayer.getOnPos(), SoundRegistry.MYANNA.get(), SoundSource.AMBIENT, 0.8f, 1.1f);

        return InteractionResultHolder.success(stack);
    }
}
