package tech.lq0.dreamaticvoyage.item.second.lecia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class Kuleboh extends Item {
    public static final String TAG_LOCKED = "locked";
    public static final String TAG_TOTEM_COUNT = "totem_count";
    public static final String TAG_NOW_COUNT = "now_count";

    private static final FoodProperties food = new FoodProperties.Builder().nutrition(5).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1), 1.0f)
            .alwaysEat().build();

    public Kuleboh() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON).food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.kuleboh").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LECIA);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof Player player) {
            if (!worldIn.isClientSide) {
                ServerPlayer serverPlayer = (ServerPlayer) player;
                int count = serverPlayer.getStats().getValue(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING));

                if (stack != player.getOffhandItem()) {
                    setLocked(stack, false);
                }

                //初始化并赋值
                if (!isLocked(stack)) {
                    setTotemCount(stack, count + 5);
                    setNowCount(stack, count);
                    setLocked(stack, true);
                } else {
                    if (stack == player.getOffhandItem()) {
                        setNowCount(stack, count);

                        if (getNowCount(stack) >= getTotemCount(stack)) {
                            player.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ItemRegistry.KULECIABOH.get()));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }

    public static void setTotemCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_TOTEM_COUNT, count);
    }

    public static int getTotemCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_TOTEM_COUNT, 0);
    }

    public static void setLocked(ItemStack stack, boolean flag) {
        ItemNBTTool.setBoolean(stack, TAG_LOCKED, flag);
    }

    public static boolean isLocked(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_LOCKED, false);
    }

    public static void setNowCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_NOW_COUNT, count);
    }

    public static int getNowCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_NOW_COUNT, 0);
    }
}
