package tech.lq0.dreamaticvoyage.item.second.lecia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingUseTotemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Kuleboh extends Item {
    public static final String TAG_TOTEM_COUNT = "UsedTotemCount";

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
    public void inventoryTick(ItemStack stack, Level level, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof Player player && !level.isClientSide) {
            if (player.getOffhandItem() == stack) {
                if (getTotemCount(stack) >= 5) {
                    player.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ItemRegistry.KULECIABOH.get()));
                }
            } else {
                setTotemCount(stack, 0);
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }

    @SubscribeEvent
    public static void onPlayerUseTotem(LivingUseTotemEvent event) {
        LivingEntity living = event.getEntity();
        if (living instanceof Player player && event.getHandHolding() == InteractionHand.MAIN_HAND) {
            ItemStack stack = player.getOffhandItem();
            if (stack.getItem() == ItemRegistry.KULEBOH.get()) {
                setTotemCount(stack, getTotemCount(stack) + 1);
            }
        }
    }

    public static void setTotemCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_TOTEM_COUNT, count);
    }

    public static int getTotemCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_TOTEM_COUNT, 0);
    }
}
