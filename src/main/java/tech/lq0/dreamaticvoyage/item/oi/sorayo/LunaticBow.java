package tech.lq0.dreamaticvoyage.item.oi.sorayo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LunaticBow extends Item implements ICurioItem {
    public LunaticBow() {
        super(new Properties().rarity(Rarity.UNCOMMON).stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.lunatic_bow_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.lunatic_bow_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SORAYO);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.ATTACK_SPEED,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 0.4f, AttributeModifier.Operation.MULTIPLY_BASE));

        return map;
    }

    @SubscribeEvent
    public static void bowEffect1(AttackEntityEvent event) {
        Player player = event.getEntity();

        CuriosApi.getCuriosInventory(player).ifPresent(
                c -> c.findFirstCurio(ItemRegistry.LUNATIC_BOW.get()).ifPresent(
                        slotResult -> player.hurt(DamageSourceRegistry.causeSorayoDamage(player.level().registryAccess(), null), 2.0f)
                )
        );
    }

    @SubscribeEvent
    public static void bowEffect2(LivingDeathEvent event) {
        Entity entity = event.getSource().getDirectEntity();
        if (entity instanceof Player player && !player.level().isClientSide) {
            CuriosApi.getCuriosInventory(player).ifPresent(
                    c -> c.findFirstCurio(ItemRegistry.LUNATIC_BOW.get()).ifPresent(
                            slotResult -> player.heal(6.0f)
                    )
            );
        }
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(ItemRegistry.YEGGY_PEARL.get()).ifPresent(s -> flag.set(false)));

        return flag.get();
    }
}
