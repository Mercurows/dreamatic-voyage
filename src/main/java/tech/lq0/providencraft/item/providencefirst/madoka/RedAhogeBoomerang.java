package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.entity.projectile.AhogeBoomerangEntity;
import tech.lq0.providencraft.tiers.ModItemTier;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class RedAhogeBoomerang extends SwordItem {
    public RedAhogeBoomerang() {
        super(ModItemTier.RED_AHOGE, 3, -2, new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player playerIn, InteractionHand pUsedHand) {
        ItemStack item = playerIn.getItemInHand(pUsedHand);
        pLevel.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide()) {
            AhogeBoomerangEntity ahogeBoomerangEntity = new AhogeBoomerangEntity(pLevel, playerIn);
            ahogeBoomerangEntity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0f, 3.0f, 0.2f);
            pLevel.addFreshEntity(ahogeBoomerangEntity);

            item.hurtAndBreak(3, playerIn, (playerEntity) -> playerEntity.broadcastBreakEvent(pUsedHand));

            playerIn.getCooldowns().addCooldown(item.getItem(), 20);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.red_ahoge_boomerang.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.red_ahoge_sword_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.red_ahoge_sword_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.red_ahoge_boomerang").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.red_ahoge_sword_4").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MADOKA);
    }
}
