package tech.lq0.dreamaticvoyage.item.second.mumu;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.event.CurioChangeEvent;
import top.theillusivec4.curios.api.event.CurioEquipEvent;
import top.theillusivec4.curios.api.event.CurioUnequipEvent;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PowerfulMassGainer extends Item implements ICurioItem {

    public PowerfulMassGainer() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.powerful_mass_gainer_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.powerful_mass_gainer_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MUMU);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        return generateAttributes(uuid, stack.getOrCreateTag().getDouble("Armor"), stack.getOrCreateTag().getDouble("Toughness"));
    }

    private static Multimap<Attribute, AttributeModifier> generateAttributes(UUID uuid, double armor, double toughness) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();

        double extraHealth = Math.max(0, armor * 1.5 + toughness * 2);
        map.put(Attributes.MAX_HEALTH, new AttributeModifier(uuid, "Armor to Max Health", extraHealth, AttributeModifier.Operation.ADDITION));
        map.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor Zero", -armor, AttributeModifier.Operation.ADDITION));
        map.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Toughness Zero", -toughness, AttributeModifier.Operation.ADDITION));

        return map;
    }

    private static void setData(ItemStack stack, LivingEntity living) {
        var armorAttribute = living.getAttribute(Attributes.ARMOR);
        if (armorAttribute != null) {
            stack.getOrCreateTag().putDouble("Armor", armorAttribute.getValue());
        }

        var toughnessAttribute = living.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (toughnessAttribute != null) {
            stack.getOrCreateTag().putDouble("Toughness", toughnessAttribute.getValue());
        }
    }

    private static void setData(ItemStack stack, double armor, double toughness) {
        stack.getOrCreateTag().putDouble("Armor", armor);
        stack.getOrCreateTag().putDouble("Toughness", toughness);
    }

    private static void resetData(ItemStack stack) {
        stack.getOrCreateTag().putDouble("Armor", 0);
        stack.getOrCreateTag().putDouble("Toughness", 0);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @SubscribeEvent
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntity();
        var slot = event.getSlot();
        if (!slot.isArmor()) return;

        if (entity instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.POWERFUL_MASS_GAINER.get()).ifPresent(
                    s -> {
                        ItemStack stack = s.stack();
                        ItemStack from = event.getFrom();
                        ItemStack to = event.getTo();

                        var fromAttr = calculateAttributes(from, slot);
                        var toAttr = calculateAttributes(to, slot);

                        double armor = toAttr.getFirst() - fromAttr.getFirst();
                        double toughness = toAttr.getSecond() - fromAttr.getSecond();

                        setData(stack, stack.getOrCreateTag().getDouble("Armor") + armor,
                                stack.getOrCreateTag().getDouble("Toughness") + toughness);
                    }
            ));
        }
    }

    private static Pair<Double, Double> calculateAttributes(ItemStack stack, EquipmentSlot slot) {
        AtomicReference<Double> first = new AtomicReference<>(0.0);
        AtomicReference<Double> second = new AtomicReference<>(0.0);

        var attr = stack.getAttributeModifiers(slot);
        if (!attr.get(Attributes.ARMOR).isEmpty()) {
            attr.get(Attributes.ARMOR).stream().filter(a -> a.getOperation() == AttributeModifier.Operation.ADDITION)
                    .forEach(a -> first.updateAndGet(v -> v + a.getAmount()));
        }

        if (!attr.get(Attributes.ARMOR_TOUGHNESS).isEmpty()) {
            attr.get(Attributes.ARMOR_TOUGHNESS).stream().filter(a -> a.getOperation() == AttributeModifier.Operation.ADDITION)
                    .forEach(a -> second.updateAndGet(v -> v + a.getAmount()));
        }

        return Pair.of(first.get(), second.get());
    }

    private static Pair<Double, Double> calculateAttributes(ItemStack stack, SlotContext slotContext) {
        AtomicReference<Double> first = new AtomicReference<>(0.0);
        AtomicReference<Double> second = new AtomicReference<>(0.0);

        if (!(stack.getItem() instanceof ICurioItem curioItem)) return Pair.of(first.get(), second.get());

        var attr = curioItem.getAttributeModifiers(slotContext, UUID.randomUUID(), stack);
        if (!attr.get(Attributes.ARMOR).isEmpty()) {
            attr.get(Attributes.ARMOR).stream().filter(a -> a.getOperation() == AttributeModifier.Operation.ADDITION)
                    .forEach(a -> first.updateAndGet(v -> v + a.getAmount()));
        }

        if (!attr.get(Attributes.ARMOR_TOUGHNESS).isEmpty()) {
            attr.get(Attributes.ARMOR_TOUGHNESS).stream().filter(a -> a.getOperation() == AttributeModifier.Operation.ADDITION)
                    .forEach(a -> second.updateAndGet(v -> v + a.getAmount()));
        }

        return Pair.of(first.get(), second.get());
    }

    @SubscribeEvent
    public static void onCurioChange(CurioChangeEvent event) {
        var entity = event.getEntity();
        if (entity instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.POWERFUL_MASS_GAINER.get()).ifPresent(
                    s -> {
                        ItemStack stack = s.stack();
                        ItemStack from = event.getFrom();
                        ItemStack to = event.getTo();

                        if (from.is(ItemRegistry.POWERFUL_MASS_GAINER.get()) || to.is(ItemRegistry.POWERFUL_MASS_GAINER.get()))
                            return;

                        var fromAttr = calculateAttributes(from, s.slotContext());
                        var toAttr = calculateAttributes(to, s.slotContext());

                        double armor = toAttr.getFirst() - fromAttr.getFirst();
                        double toughness = toAttr.getSecond() - fromAttr.getSecond();

                        setData(stack, stack.getOrCreateTag().getDouble("Armor") + armor,
                                stack.getOrCreateTag().getDouble("Toughness") + toughness);
                    }
            ));
        }
    }

    @SubscribeEvent
    public static void onEquipCurio(CurioEquipEvent event) {
        SlotContext slotContext = event.getSlotContext();
        ItemStack stack = event.getStack();
        if (stack.is(ItemRegistry.POWERFUL_MASS_GAINER.get())) {
            setData(stack, slotContext.entity());
        }
    }

    @SubscribeEvent
    public static void onUnequipCurio(CurioUnequipEvent event) {
        ItemStack stack = event.getStack();
        if (stack.is(ItemRegistry.POWERFUL_MASS_GAINER.get())) {
            resetData(stack);
        }
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        CuriosApi.getCuriosInventory(event.getEntity()).ifPresent(c -> c.findFirstCurio(ItemRegistry.POWERFUL_MASS_GAINER.get()).ifPresent(
                s -> resetData(s.stack())
        ));
    }
}
