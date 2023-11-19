package tech.lq0.providencraft.item.providenceOI.sorayo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class LunaticBow extends Item implements ICurioItem {
    public LunaticBow() {
        super(new Properties());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.lunatic_bow_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.lunatic_bow_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SORAYO);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 0.4f, AttributeModifier.Operation.MULTIPLY_BASE));
        map.put(Attributes.ATTACK_SPEED,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 0.7f, AttributeModifier.Operation.MULTIPLY_BASE));

        return map;
    }

//    @SubscribeEvent
//    public static void BowEffect(AttackEntityEvent event) {
//        LivingEntity entity = event.getEntityLiving();
//        if (entity instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) entity;
//            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
//            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.LUNATIC_BOW.get())) {
//                player.attackEntityFrom(DamageSourceRegistry.SORAYO, 2.0f);
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public static void BowEffect2(LivingDeathEvent event) {
//        Entity entity = event.getSource().getImmediateSource();
//        if (entity instanceof PlayerEntity && !entity.world.isRemote) {
//            PlayerEntity player = (PlayerEntity) entity;
//            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
//            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.LUNATIC_BOW.get())) {
//                player.heal(6.0f);
//            }
//        }
//    }
}
