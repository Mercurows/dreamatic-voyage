package tech.lq0.dreamaticvoyage.item.fourth.hifumi;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UnfaithfulHeart extends Item implements ICurioItem {
    public UnfaithfulHeart() {
        super(new Properties().rarity(Rarity.UNCOMMON).durability(9));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.unfaithful_heart_1").withStyle(ChatFormatting.GRAY));
        if (!Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.unfaithful_heart_2").withStyle(ChatFormatting.GRAY));
        } else {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.unfaithful_heart_3").withStyle(ChatFormatting.GRAY));
        }

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HIFUMI);
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0x8f4fa5;
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @SubscribeEvent
    public static void unfaithfulHeartHealEvent(LivingHealEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player && !player.level().isClientSide) {
            CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(ItemRegistry.UNFAITHFUL_HEART.get()).ifPresent(s -> {
                ItemStack stack = s.stack();
                if (stack.getDamageValue() < stack.getMaxDamage()) {
                    event.setAmount(event.getAmount() * 2);

                    if (!player.isCreative()) {
                        stack.setDamageValue(Math.min(stack.getDamageValue() + 1, stack.getMaxDamage()));
                    }
                }
            }));
        }
    }

    @SubscribeEvent
    public static void unfaithfulHeartDamageEvent(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player && !player.level().isClientSide) {
            CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(ItemRegistry.UNFAITHFUL_HEART.get()).ifPresent(s -> {
                ItemStack stack = s.stack();
                if (stack.getDamageValue() > 0) {
                    if (!player.isCreative()) {
                        stack.setDamageValue(Math.max(stack.getDamageValue() - 1, 0));
                    }
                }
            }));
        }
    }
}
