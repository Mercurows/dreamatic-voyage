package tech.lq0.providencraft.item.material;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.capability.ModCapabilities;
import tech.lq0.providencraft.capability.escort.EscortCapabilityProvider;
import tech.lq0.providencraft.capability.escort.IEscortCapability;
import tech.lq0.providencraft.init.ItemRegistry;

import java.util.List;
import java.util.function.Supplier;

public class IdolCloth extends Item {
    private final Supplier<Double> energyCapacity;

    public IdolCloth() {
        super(new Properties());

        this.energyCapacity = () -> 100.0;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.idol_cloth").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new EscortCapabilityProvider(stack, energyCapacity.get());
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        LazyOptional<IEscortCapability> escortCapabilityLazyOptional = pStack.getCapability(ModCapabilities.ESCORT_CAPABILITY);

        escortCapabilityLazyOptional.ifPresent(s -> {
            boolean flag = false;
            if (!pLevel.isClientSide && pEntity instanceof Player player) {
                if (pIsSelected) {
                    boolean flag1 = pStack.getCount() == 1;
                    boolean flag2 = player.experienceLevel >= 25;
                    boolean flag3 = !pLevel.isDay();
                    boolean flag4 = player.isSleeping();

                    if (flag1 && flag2 && flag3 && flag4) {
                        int count = 0;
                        for (MobEffectInstance effect : player.getActiveEffects()) {
                            if (effect.getEffect().isBeneficial()) {
                                count++;
                            }
                        }

                        if (count >= 16) {
                            flag = true;
                        }
                    }
                }

                if (flag) {
                    s.addValue(1);
                } else {
                    s.setValue(0);
                }

                if (s.getEscortValue() >= 100) {
                    player.getInventory().setItem(pSlotId, new ItemStack(ItemRegistry.DREAM_WEAVING_YARN.get()));
                    player.giveExperienceLevels(-4);
                    player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
                }
            }
        });
    }
}
