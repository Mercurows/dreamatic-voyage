package tech.lq0.dreamaticvoyage.item.magicros.keroro;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RedNose extends Item implements ICurioItem {
    public RedNose() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.red_nose_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.red_nose_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.KERORO);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.ARMOR,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 1.0f, AttributeModifier.Operation.ADDITION));

        return map;
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();

        if (livingEntity instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(
                    c -> c.findFirstCurio(ItemRegistry.RED_NOSE.get()).ifPresent(
                            slotResult -> {
                                if (!player.getCooldowns().isOnCooldown(slotResult.stack().getItem())) {
                                    if (!player.level().isClientSide) {
                                        player.playNotifySound(SoundRegistry.KERORO_SNEEZE.get(), SoundSource.PLAYERS, 0.5f, 1.0f);
                                    }
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 3), player);
                                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 3), player);
                                    player.getCooldowns().addCooldown(ItemRegistry.RED_NOSE.get(), 100);
                                }
                            }
                    )
            );
        }
    }
}
