package tech.lq0.dreamaticvoyage.item.oi.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.escort.IEscortCapability;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.escort.EscortCapabilityProvider;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class MomoKnife extends SwordItem {
    private final Supplier<Double> energyCapacity;
    public static final String TAG_TIME = "time";

    public MomoKnife() {
        super(Tiers.NETHERITE, 1, -1.0f, new Properties().durability(1231).rarity(Rarity.EPIC));

        this.energyCapacity = () -> 100.0;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.momo_knife").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.momo_knife.func").withStyle(ChatFormatting.AQUA));
        showDamage(pStack, pTooltipComponents, pLevel == null ? 0 : pLevel.getGameTime());

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = stack.getCapability(ModCapabilities.ESCORT_CAPABILITY);

        escortCapabilityLazyOptional.ifPresent(s -> {
            pPlayer.heal(getAllDamage(stack, pLevel.getGameTime()));
            s.setValue(0);
            ItemNBTTool.setLong(stack, TAG_TIME, pPlayer.level().getGameTime());
        });

        return InteractionResultHolder.success(stack);
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new EscortCapabilityProvider(stack, energyCapacity.get());
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        double damage = attacker.getAttributeValue(Attributes.ATTACK_DAMAGE);

        double random = ((Math.random() * (damage * 10)) + 20) / 10.0;

        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = stack.getCapability(ModCapabilities.ESCORT_CAPABILITY);

        escortCapabilityLazyOptional.ifPresent(s -> s.addValue(random));
        ItemNBTTool.setLong(stack, TAG_TIME, attacker.level().getGameTime());

        int lvl = -1;
        if (target.hasEffect(EffectRegistry.BLEEDING.get())) {
            lvl = target.getEffect(EffectRegistry.BLEEDING.get()).getAmplifier();
        }

        target.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 120, lvl > 2 ? 3 : lvl + 1));

        return super.hurtEnemy(stack, target, attacker);
    }

    private void showDamage(ItemStack stack, List<Component> tooltip, long time) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setMaximumFractionDigits(1);

        String damage = numberFormat.format(getAllDamage(stack, time));
        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("des.dreamaticvoyage.momo_knife.damage").withStyle(ChatFormatting.WHITE)
                .append(Component.literal(damage).withStyle(ChatFormatting.RESET).withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD)));
    }

    private static float getAllDamage(ItemStack stack, long time) {
        long lastDamageTime = ItemNBTTool.getLong(stack, TAG_TIME, 9223372036854775807L);
        AtomicReference<Float> damage = new AtomicReference<>((float) 0);

        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = stack.getCapability(ModCapabilities.ESCORT_CAPABILITY);

        escortCapabilityLazyOptional.ifPresent(s -> {
            damage.set((float) (s.getEscortValue() - (time - lastDamageTime) * 0.1f));
            if (damage.get() < 0 || time <= lastDamageTime) {
                damage.set(0f);
            }
        });

        return damage.get();
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
