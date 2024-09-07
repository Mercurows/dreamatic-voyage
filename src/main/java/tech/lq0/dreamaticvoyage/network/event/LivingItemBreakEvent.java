package tech.lq0.dreamaticvoyage.network.event;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;

public class LivingItemBreakEvent extends Event {

    public final LivingEntity livingEntity;
    public final EquipmentSlot slot;

    public LivingItemBreakEvent(LivingEntity livingEntity, EquipmentSlot slot) {
        this.livingEntity = livingEntity;
        this.slot = slot;
    }

    public LivingItemBreakEvent(LivingEntity livingEntity, InteractionHand hand) {
        this.livingEntity = livingEntity;
        this.slot = hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
    }

    public ItemStack getItemStack() {
        return livingEntity.getItemBySlot(slot);
    }

}
