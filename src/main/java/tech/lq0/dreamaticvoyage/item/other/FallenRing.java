package tech.lq0.dreamaticvoyage.item.other;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
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
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosHelper;
import tech.lq0.dreamaticvoyage.init.AttributeRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FallenRing extends Item implements ICurioItem {
    public FallenRing() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fallen_ring").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        if (entity.hasEffect(MobEffects.DARKNESS)) {
            entity.removeEffect(MobEffects.DARKNESS);
        }

        if (entity.hasEffect(MobEffects.BLINDNESS)) {
            entity.removeEffect(MobEffects.BLINDNESS);
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.ARMOR,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, -3.0f, AttributeModifier.Operation.ADDITION));
        map.put(Attributes.ARMOR_TOUGHNESS,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, -1.5f, AttributeModifier.Operation.ADDITION));
        map.put(AttributeRegistry.CHAOS.get(),
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 50.0f, AttributeModifier.Operation.ADDITION));

        return map;
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @SubscribeEvent
    public static void fallenRingEffect(AttackEntityEvent event) {
        Player player = event.getEntity();
        Entity entity = event.getTarget();

        if (entity instanceof LivingEntity living) {
            if (living.hasEffect(MobEffects.BLINDNESS) || living.hasEffect(MobEffects.DARKNESS)) {
                if (!player.getCooldowns().isOnCooldown(ItemRegistry.FALLEN_RING.get())) {
                    CuriosApi.getCuriosInventory(player).ifPresent(
                            c -> c.findFirstCurio(ItemRegistry.FALLEN_RING.get()).ifPresent(
                                    slotResult -> {
                                        living.hurt(player.level().damageSources().sonicBoom(player), Math.min(living.getMaxHealth() * 0.4f, Math.max(ChaosHelper.getChaos(player), 0) * 1.5f));
                                        player.getCooldowns().addCooldown(ItemRegistry.FALLEN_RING.get(), 40);
                                    }
                            )
                    );
                }
            }
        }
    }
}
