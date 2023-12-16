package tech.lq0.providencraft.item.providencemagicros.keroro;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;
import java.util.UUID;

public class FrogCrown extends ArmorItem {
    public static final String TAG_RAIN = "isRaining";

    public FrogCrown() {
        super(ArmorMaterials.GOLD, Type.HELMET, new Properties().durability(302));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isRaining()) {
            ItemNBTTool.setBoolean(stack, TAG_RAIN, true);
            if (player.tickCount % 300 == 0) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, true, false));
            }
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 300, 0, true, false));
        } else {
            ItemNBTTool.setBoolean(stack, TAG_RAIN, false);
        }

        if (player.isSwimming()) {
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 0, true, false));
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.FROG_CROWN.hashCode() + slot.toString().hashCode(), 0);
        if (slot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            boolean rain = ItemNBTTool.getBoolean(stack, TAG_RAIN, false);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, rain ? 2.0 : 0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, rain ? 4.0 : 0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.frog_crown_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.frog_crown_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.KERORO);
    }
}
