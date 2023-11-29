package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MagicBookRevelation extends Item {
    public MagicBookRevelation() {
        super(new Properties().stacksTo(1).durability(165).rarity(Rarity.RARE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_revelation.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.magic_book_revelation").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }

    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return pRepairCandidate.getItem() == Items.GUNPOWDER;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            for (LivingEntity livingEntity : pPlayer.level().getEntitiesOfClass(LivingEntity.class, pPlayer.getBoundingBox().inflate(10, 10, 10))) {
                if (livingEntity != pPlayer && !pPlayer.isAlliedTo(livingEntity) && !(livingEntity instanceof ArmorStand) && pPlayer.distanceToSqr(livingEntity) <= 100.0D) {
                    if (livingEntity.hasEffect(EffectRegistry.CURSE_OF_SERPENT.get())) {
                        int level = livingEntity.getEffect(EffectRegistry.CURSE_OF_SERPENT.get()).getAmplifier();
                        livingEntity.addEffect(new MobEffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 200, Math.min(level + 1, 4)));
                    } else {
                        livingEntity.addEffect(new MobEffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 200, 0));
                    }
                }
            }

            pPlayer.hurt(pLevel.damageSources().magic(), 4.0f);
            stack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));
            pPlayer.getCooldowns().addCooldown(stack.getItem(), 60);
        }

        return InteractionResultHolder.success(stack);
    }
}
