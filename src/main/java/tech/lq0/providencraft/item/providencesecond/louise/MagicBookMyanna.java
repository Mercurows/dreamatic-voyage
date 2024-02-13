package tech.lq0.providencraft.item.providencesecond.louise;

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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MagicBookMyanna extends Item {
    public MagicBookMyanna() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_myanna.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_myanna").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(EffectRegistry.BLESS_OF_DARK_ELF.get(), 600, 1));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1));
        }
        pPlayer.getCooldowns().addCooldown(stack.getItem(), 2400);
        pLevel.playSound(pPlayer, pPlayer.getOnPos(), SoundRegistry.MYANNA.get(), SoundSource.AMBIENT, 0.5f, 1f);

        return InteractionResultHolder.success(stack);
    }
}
