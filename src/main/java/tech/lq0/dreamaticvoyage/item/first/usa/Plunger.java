package tech.lq0.dreamaticvoyage.item.first.usa;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.entity.projectile.PlungerEntity;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class Plunger extends SwordItem {
    public Plunger() {
        super(ModItemTier.PURIFIED_CRYSTAL, 3, -1.5f, new Properties().rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.plunger").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.USA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));

        if (!pLevel.isClientSide) {
            if (pPlayer.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(ItemRegistry.KRM_963_53.get())) {
                PlungerEntity plungerEntity1 = new PlungerEntity(pLevel, pPlayer);
                PlungerEntity plungerEntity2 = new PlungerEntity(pLevel, pPlayer);
                PlungerEntity plungerEntity3 = new PlungerEntity(pLevel, pPlayer);
                PlungerEntity plungerEntity4 = new PlungerEntity(pLevel, pPlayer);
                PlungerEntity plungerEntity5 = new PlungerEntity(pLevel, pPlayer);

                plungerEntity1.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot() - 12.0f, 0.0f, 4.0f, 0.0f);
                plungerEntity2.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot() - 6.0f, 0.0f, 4.0f, 0.0f);
                plungerEntity3.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 4.0f, 0.0f);
                plungerEntity4.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot() + 6.0f, 0.0f, 4.0f, 0.0f);
                plungerEntity5.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot() + 12.0f, 0.0f, 4.0f, 0.0f);

                pLevel.addFreshEntity(plungerEntity1);
                pLevel.addFreshEntity(plungerEntity2);
                pLevel.addFreshEntity(plungerEntity3);
                pLevel.addFreshEntity(plungerEntity4);
                pLevel.addFreshEntity(plungerEntity5);
            } else {
                PlungerEntity plungerEntity = new PlungerEntity(pLevel, pPlayer);
                plungerEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 3.5f, 0.1f);
                pLevel.addFreshEntity(plungerEntity);
            }

            stack.hurtAndBreak(1, pPlayer, (p) -> p.broadcastBreakEvent(pUsedHand));
            pPlayer.getCooldowns().addCooldown(this, 5);
        }

        return InteractionResultHolder.success(stack);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.HEAD;
    }
}
