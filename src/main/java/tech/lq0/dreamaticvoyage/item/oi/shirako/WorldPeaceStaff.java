package tech.lq0.dreamaticvoyage.item.oi.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.escort.EscortCapabilityProvider;
import tech.lq0.dreamaticvoyage.capability.escort.IEscortCapability;
import tech.lq0.dreamaticvoyage.entity.projectile.BloodCrystalEntity;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.function.Supplier;

public class WorldPeaceStaff extends SwordItem {
    private final Supplier<Double> energyCapacity;

    public WorldPeaceStaff() {
        super(ModItemTier.FICTIONAL_INGOT, 14, -2.0f, new Properties().durability(11451).fireResistant()
                .rarity(RarityTool.LEGENDARY));

        this.energyCapacity = () -> 500.0;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.world_peace_staff_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        TooltipTool.addHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.world_peace_staff_2").withStyle(Style.EMPTY.withColor(0xF4ADB4)).withStyle(ChatFormatting.ITALIC));
        TooltipTool.addHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.world_peace_staff_3").withStyle(Style.EMPTY.withColor(0xF4ADB4)).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public int getEnchantmentValue() {
        return 24;
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.BREAKABLE;
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new EscortCapabilityProvider(stack, energyCapacity.get());
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.knockback(5.0f, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());

        double damage = attacker.getAttributeValue(Attributes.ATTACK_DAMAGE);
        double random = ((Math.random() * (damage * 10)) + 100) / 10.0;

        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = stack.getCapability(ModCapabilities.ESCORT_CAPABILITY);
        escortCapabilityLazyOptional.ifPresent(s -> s.addValue(random));

        target.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 200, 5));
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 2));
        return true;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 9999;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (pUsedHand == InteractionHand.MAIN_HAND) {
            pPlayer.startUsingItem(pUsedHand);
            return InteractionResultHolder.consume(stack);
        } else {
            return InteractionResultHolder.fail(stack);
        }
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity player, ItemStack pStack, int pRemainingUseDuration) {
        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = pStack.getCapability(ModCapabilities.ESCORT_CAPABILITY);
        escortCapabilityLazyOptional.ifPresent(s -> {
            if (pRemainingUseDuration % 2 == 0 && s.getEscortValue() >= 5.0) {
                if (player.isSteppingCarefully()) {
                    player.heal(3.0f);
                } else {
                    BloodCrystalEntity bloodCrystal = new BloodCrystalEntity(pLevel, player);
                    Vec3 vec3 = player.getLookAngle();
                    bloodCrystal.shoot(vec3.x, vec3.y, vec3.z, 4.0f, 0.6f);
                    pLevel.addFreshEntity(bloodCrystal);

                    if (player instanceof Player player1) {
                        pLevel.playSound(player1, player1.getOnPos(), SoundRegistry.BLOOD_CRYSTAL.get(), SoundSource.AMBIENT, 0.8f, 1.0f);
                    }
                }

                s.subValue(5.0);
            }
        });
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;
    }
}
