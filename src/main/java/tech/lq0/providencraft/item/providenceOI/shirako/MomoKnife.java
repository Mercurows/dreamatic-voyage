package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.capability.IEscortCapability;
import tech.lq0.providencraft.capability.ModCapabilities;
import tech.lq0.providencraft.energy.EscortCapabilityProvider;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.text.NumberFormat;
import java.util.List;
import java.util.function.Supplier;

public class MomoKnife extends SwordItem {
    private final Supplier<Double> energyCapacity;

    public MomoKnife() {
        super(Tiers.NETHERITE, 1, -1.0f, new Properties().durability(1231).rarity(Rarity.EPIC));

        this.energyCapacity = () -> 100.0;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_knife").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_knife.func").withStyle(ChatFormatting.AQUA));
        showDamage(pStack, pTooltipComponents);

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = stack.getCapability(ModCapabilities.ESCORT_CAPABILITY);

        escortCapabilityLazyOptional.ifPresent(s -> {
            pPlayer.heal((float) (s.getEscortValue() * 0.5));
            s.setValue(0);
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

        int lvl = -1;
        if (target.hasEffect(EffectRegistry.BLEEDING.get())) {
            lvl = target.getEffect(EffectRegistry.BLEEDING.get()).getAmplifier();
        }

        target.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 120, lvl > 2 ? 3 : lvl + 1));

        return super.hurtEnemy(stack, target, attacker);
    }

    private void showDamage(ItemStack stack, List<Component> tooltip) {
        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = stack.getCapability(ModCapabilities.ESCORT_CAPABILITY);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setMaximumFractionDigits(1);

        escortCapabilityLazyOptional.ifPresent(s -> {
            String damage = numberFormat.format(s.getEscortValue());
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("des.providencraft.momo_knife.damage").withStyle(ChatFormatting.WHITE)
                    .append(Component.literal(damage).withStyle(ChatFormatting.RESET).withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD)));
        });
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = pStack.getCapability(ModCapabilities.ESCORT_CAPABILITY);

        escortCapabilityLazyOptional.ifPresent(s -> s.subValue(0.1));
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
