package tech.lq0.dreamaticvoyage.item.oi.fukami;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageTypes;
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
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HeavyBreadComponent extends Item implements ICurioItem {

    public HeavyBreadComponent() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.heavy_bread_component_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.heavy_bread_component_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMI);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.MOVEMENT_SPEED,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, -0.05f, AttributeModifier.Operation.MULTIPLY_BASE));

        return map;
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();

        if (event.getSource().getEntity() instanceof Player player &&
                event.getSource().is(DamageTypes.PLAYER_ATTACK)) {

            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.HEAVY_BREAD_COMPONENT.get())
                    .ifPresent(s -> {
                        float damage = event.getAmount();
                        double armor = entity.getAttribute(Attributes.ARMOR) == null ? 0 : entity.getAttributeValue(Attributes.ARMOR);
                        double toughness = entity.getAttribute(Attributes.ARMOR_TOUGHNESS) == null ? 0 : entity.getAttributeValue(Attributes.ARMOR_TOUGHNESS);

                        float limit = (float) ((1 - armor / 125) * (1.6 * armor + 0.2 * armor * toughness));

                        float originDamage;
                        if (damage > limit) {
                            originDamage = (float) (damage / (1 - armor / 125));
                        } else {
                            originDamage = (float) ((6.25 * toughness + 50) * ((armor / 25 - 1) +
                                    Math.sqrt(Math.pow(1 - armor / 25, 2) + 4 * damage / (6.25 * toughness + 50))) / 2);
                        }

                        float res = CombatRules.getDamageAfterAbsorb(originDamage,
                                (float) armor * .5f, (float) toughness * .7f);
                        event.setAmount(res);
                    }));
        }
    }
}
