package tech.lq0.dreamaticvoyage.item.second.mumu;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.network.ServerEventHandler;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.event.CurioEquipEvent;
import top.theillusivec4.curios.api.event.CurioUnequipEvent;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PowerfulMassGainer extends Item implements ICurioItem {

    public PowerfulMassGainer() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    private static void addModifiers(LivingEntity living) {
        UUID uuid = new UUID(ItemRegistry.POWERFUL_MASS_GAINER.hashCode(), 0);

        double armorValue = living.getArmorValue();
        double toughnessValue = living.getAttributeValue(Attributes.ARMOR_TOUGHNESS);
        double extraHealth = armorValue * 2 + toughnessValue * 3;

        var healthAttribute = living.getAttribute(Attributes.MAX_HEALTH);
        if (healthAttribute != null) {
            AttributeModifier healthModifier = new AttributeModifier(uuid, "Armor to Health", extraHealth, AttributeModifier.Operation.ADDITION);
            if (healthAttribute.getModifier(uuid) != null) {
                healthAttribute.removePermanentModifier(uuid);
            }
            healthAttribute.addPermanentModifier(healthModifier);
        }

        var armorAttribute = living.getAttribute(Attributes.ARMOR);
        if (armorAttribute != null) {
            AttributeModifier armorZeroModifier = new AttributeModifier(uuid, "Armor Zero", -armorValue, AttributeModifier.Operation.ADDITION);
            if (armorAttribute.getModifier(uuid) != null) {
                armorAttribute.removePermanentModifier(uuid);
            }
            armorAttribute.addPermanentModifier(armorZeroModifier);
        }

        var toughnessAttribute = living.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (toughnessAttribute != null) {
            AttributeModifier toughnessZeroModifier = new AttributeModifier(uuid, "Toughness Zero", -toughnessValue, AttributeModifier.Operation.ADDITION);
            if (toughnessAttribute.getModifier(uuid) != null) {
                toughnessAttribute.removePermanentModifier(uuid);
            }
            toughnessAttribute.addPermanentModifier(toughnessZeroModifier);
        }
    }

    private static void removeModifiers(LivingEntity living) {
        UUID uuid = new UUID(ItemRegistry.POWERFUL_MASS_GAINER.hashCode(), 0);

        var armorAttribute = living.getAttribute(Attributes.ARMOR);
        if (armorAttribute == null) return;

        var armorModifier = armorAttribute.getModifier(uuid);
        if (armorModifier != null) {
            armorAttribute.removePermanentModifier(uuid);
        }

        var toughnessAttribute = living.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (toughnessAttribute != null) {
            var toughnessModifier = toughnessAttribute.getModifier(uuid);
            if (toughnessModifier != null) {
                toughnessAttribute.removePermanentModifier(uuid);
            }
        }

        var healthModifier = living.getAttribute(Attributes.MAX_HEALTH);
        if (healthModifier != null) {
            healthModifier.removePermanentModifier(uuid);
        }
    }

    @SubscribeEvent
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.POWERFUL_MASS_GAINER.get()).ifPresent(
                    s -> {
                        removeModifiers(entity);
                        ServerEventHandler.queueServerEvent(1, () -> {
                            addModifiers(entity);
                            entity.setHealth(Mth.clamp(entity.getHealth(), 0, entity.getMaxHealth()));
                        });
                    }
            ));
        }
    }

    @SubscribeEvent
    public static void onEquipCurio(CurioEquipEvent event) {
        SlotContext slotContext = event.getSlotContext();
        ItemStack stack = event.getStack();
        if (stack.is(ItemRegistry.POWERFUL_MASS_GAINER.get())) {
            addModifiers(slotContext.entity());
        }
    }

    @SubscribeEvent
    public static void onUnequipCurio(CurioUnequipEvent event) {
        SlotContext slotContext = event.getSlotContext();
        LivingEntity living = slotContext.entity();
        ItemStack stack = event.getStack();
        if (stack.is(ItemRegistry.POWERFUL_MASS_GAINER.get())) {
            removeModifiers(living);
            ServerEventHandler.queueServerEvent(1, () -> living.setHealth(Mth.clamp(living.getHealth(), 0, living.getMaxHealth())));
        }
    }
}
