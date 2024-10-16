package tech.lq0.dreamaticvoyage.item.second.lucia;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class MoonlightAmulet extends Item implements ICurioItem {
    public static final String TAG_MOONLIGHT = "IsNight";

    public MoonlightAmulet() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.moonlight_amulet").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LUCIA);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (livingEntity instanceof Player player && !player.level().isClientSide) {
            if (!player.level().isDay()) {
                ItemNBTTool.setBoolean(stack, TAG_MOONLIGHT, true);
                player.addEffect(new MobEffectInstance(EffectRegistry.BIG_FIERCE_ONE.get(), 300, 0, false, false), player);
            } else {
                ItemNBTTool.setBoolean(stack, TAG_MOONLIGHT, false);
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.MAX_HEALTH,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 6.0, AttributeModifier.Operation.ADDITION));
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 2.0, AttributeModifier.Operation.ADDITION));
        map.put(Attributes.ARMOR,
                new AttributeModifier(uuid, Utils.MOD_ATTRIBUTE_MODIFIER, 4.0, AttributeModifier.Operation.ADDITION));

        return map;
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }
}
