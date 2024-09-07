package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.network.event.LivingItemBreakEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CrystalPendant extends Item implements ICurioItem {

    public CrystalPendant() {
        super(new Properties().durability(8).setNoRepair());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_pendant_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.crystal_pendant_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @SubscribeEvent
    public static void onItemBreak(LivingItemBreakEvent event) {
        LivingEntity living = event.livingEntity;
        ItemStack stack = event.getItemStack();
        if (stack.isDamageableItem()) {
            ItemStack copy = generateFixedItem(stack, .25f);
            CuriosApi.getCuriosInventory(living).ifPresent(
                    c -> c.findFirstCurio(ItemRegistry.CRYSTAL_PENDANT.get()).ifPresent(
                            slotResult -> {
                                ItemStack pendant = slotResult.stack();
                                pendant.getOrCreateTag().put("ItemToRepair", copy.serializeNBT());
                            }
                    )
            );
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) return;

        CuriosApi.getCuriosInventory(event.player).ifPresent(
                c -> c.findFirstCurio(ItemRegistry.CRYSTAL_PENDANT.get()).ifPresent(
                        slotResult -> {
                            ItemStack pendant = slotResult.stack();
                            ItemStack stack = ItemStack.of(pendant.getOrCreateTag().getCompound("ItemToRepair"));
                            if (!stack.isEmpty() && stack.getItem() != ItemRegistry.CRYSTAL_PENDANT.get()) {
                                if (stack.getItem() instanceof ArmorItem armorItem) {
                                    event.player.setItemSlot(armorItem.getEquipmentSlot(), stack);
                                } else {
                                    event.player.addItem(stack);
                                }
                                pendant.removeTagKey("ItemToRepair");

                                if (!event.player.getAbilities().instabuild) {
                                    pendant.setDamageValue(pendant.getDamageValue() + 1);
                                }
                                if (pendant.getDamageValue() > pendant.getMaxDamage()) {
                                    pendant.shrink(1);
                                }
                            }
                        }
                )
        );
    }

    public static ItemStack generateFixedItem(ItemStack stack, float rate) {
        ItemStack res = stack.copy();
        res.setDamageValue((int) (stack.getDamageValue() * Mth.clamp(1 - rate, 0, 1)));
        return res;
    }
}
