package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.ArmorTool;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MiracleBadge extends Item implements ICurioItem {
    public static final String TAG_SET = "Set";

    private static final List<String> players = Collections.synchronizedList(new ArrayList<>());

    public MiracleBadge() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.miracle_badge_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.miracle_badge_2").withStyle(ChatFormatting.GRAY));
        if (hasArmorSet(pStack)) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magicros_set").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xE2B578)));
        }
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof Player player) {
            AtomicBoolean flag = new AtomicBoolean(false);
            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(true)));
            if (flag.get()) {
                setArmorSet(pStack, player);
            } else {
                ItemNBTTool.setBoolean(pStack, TAG_SET, false);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (!livingEntity.level().isClientSide && livingEntity instanceof Player player) {
            setArmorSet(stack, player);
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    public static void setArmorSet(ItemStack stack, Player player) {
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasMagicrosArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return ItemNBTTool.getBoolean(pStack, TAG_SET, false) ? RarityTool.MAGICROS : RarityTool.LEGENDARY;
    }

    @SubscribeEvent
    public static void playerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        String username = event.getEntity().getGameProfile().getName();
        players.remove(username + ":false");
        players.remove(username + ":true");
    }

    private static String playerToString(Player player) {
        return player.getGameProfile().getName() + ":" + player.level().isClientSide;
    }

    private static boolean checkFly(Player player) {
        AtomicBoolean flag = new AtomicBoolean(false);
        CuriosApi.getCuriosInventory(player).ifPresent(
                c -> flag.set(c.findFirstCurio(ItemRegistry.MIRACLE_BADGE.get()).isPresent())
        );
        return flag.get();
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player) {
            if (players.contains(playerToString(player))) {
                if (checkFly(player)) {
                    player.getAbilities().mayfly = true;
                } else {
                    if (!player.isSpectator() && !player.isCreative()) {
                        player.getAbilities().mayfly = false;
                        player.getAbilities().flying = false;
                        player.getAbilities().invulnerable = false;
                    }
                    players.remove(playerToString(player));
                }
            } else if (checkFly(player)) {
                players.add(playerToString(player));
                player.getAbilities().mayfly = true;
            }
        }
    }
}
