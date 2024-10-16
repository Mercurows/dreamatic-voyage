package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.entity.player.TradeWithVillagerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.escort.EscortCapabilityProvider;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EscortToken extends Item implements ICurioItem {
    private final Supplier<Double> energyCapacity;

    public EscortToken() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));

        this.energyCapacity = () -> 100.0;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.escort_token").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new EscortCapabilityProvider(stack, energyCapacity.get());
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        if (entity instanceof Player player && !player.level().isClientSide) {
            stack.getCapability(ModCapabilities.ESCORT_CAPABILITY).ifPresent(s -> {
                if (s.getEscortValue() >= 1) {
                    s.subValue(1);
                    player.addItem(new ItemStack(ItemRegistry.PDC_POINT.get()));
                }
            });
        }
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @SubscribeEvent
    public static void onTrade(TradeWithVillagerEvent event) {
        Player player = event.getEntity();
        if (player.level().isClientSide) {
            return;
        }

        CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.ESCORT_TOKEN.get()).ifPresent(s -> {
            MerchantOffer offer = event.getMerchantOffer();

            ItemStack costA = offer.getCostA();
            ItemStack costB = offer.getCostB();

            int count = 0;
            if (costA.getItem() == Items.EMERALD) {
                count += costA.getCount();
            }
            if (costB.getItem() == Items.EMERALD) {
                count += costB.getCount();
            }

            int finalCount = count;
            s.stack().getCapability(ModCapabilities.ESCORT_CAPABILITY)
                    .ifPresent(st -> st.addValue(finalCount / 10.0));
        }));
    }
}
