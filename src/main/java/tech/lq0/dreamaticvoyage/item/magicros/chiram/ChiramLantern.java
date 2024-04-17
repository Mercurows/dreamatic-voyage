package tech.lq0.dreamaticvoyage.item.magicros.chiram;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.escort.EscortCapabilityProvider;
import tech.lq0.dreamaticvoyage.capability.escort.IEscortCapability;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.function.Supplier;

public class ChiramLantern extends Item {
    private final Supplier<Double> energyCapacity;

    public ChiramLantern() {
        super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));

        this.energyCapacity = () -> 200.0;
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new EscortCapabilityProvider(stack, energyCapacity.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.chiram_lantern_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.chiram_lantern_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHIRAM);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof Player player) {
            if (!player.getOffhandItem().getItem().equals(ItemRegistry.CHIRAM_LANTERN.get())) return;

            ItemStack lantern = player.getOffhandItem();
            if (worldIn.getLightEmission(player.getOnPos()) > 5) return;

            lantern.getCapability(ModCapabilities.ESCORT_CAPABILITY).ifPresent(s -> {
                if (s.getEscortValue() < 200) {
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0, false, false), player);
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
                    if (player.tickCount % 20 == 0 && !player.isCreative() && !player.isSpectator()) {
                        s.addValue(1);
                    }
                }
            });
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pUsedHand != InteractionHand.MAIN_HAND) return super.use(pLevel, pPlayer, pUsedHand);

        ItemStack stack = pPlayer.getMainHandItem();
        ItemStack off = pPlayer.getOffhandItem();

        if (off.getItem() != Items.TORCH) return super.use(pLevel, pPlayer, pUsedHand);

        stack.getCapability(ModCapabilities.ESCORT_CAPABILITY).ifPresent(s -> {
            if (s.getEscortValue() > 0) {
                if (!pPlayer.isCreative() && !pPlayer.isSpectator()) {
                    off.shrink(1);
                }
                s.setValue(0);
            }
        });

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return pStack.getCapability(ModCapabilities.ESCORT_CAPABILITY)
                .map(s -> s.getEscortValue() > 0)
                .orElse(false);
    }

    @Override
    public int getBarWidth(ItemStack pStack) {
        return pStack.getCapability(ModCapabilities.ESCORT_CAPABILITY)
                .map(IEscortCapability::getEscortValue)
                .map(Double::floatValue)
                .map(v -> Math.round(13.0F - v / 200F * 13.0F))
                .orElse(13);
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0xFFECE7;
    }
}
