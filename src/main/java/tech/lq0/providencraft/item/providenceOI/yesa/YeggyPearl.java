package tech.lq0.providencraft.item.providenceOI.yesa;

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
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class YeggyPearl extends Item implements ICurioItem {
    public static final String TAG_YEGGY_PEARL = "yeggy_energy";

    public YeggyPearl(){
        super(new Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.yeggy_pearl_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.yeggy_pearl_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.YESA);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, -0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));

        return map;
    }

    public static void setEnergy(ItemStack stack, int num){
        ItemNBTTool.setInt(stack, TAG_YEGGY_PEARL, Math.min(80, num));
    }

    public static int getEnergy(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_YEGGY_PEARL, 0);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        setEnergy(stack, getEnergy(stack) + 1);
        ICurioItem.super.curioTick(slotContext, stack);
    }

    public static float getDamageTimes(int x){
        float res = 0f;
        if(x > 80){
            return 1.25f;
        }

        if(x >= 60){
            res = 25.0f;
        }else if(x >= 40){
            res = -1.187f * x * x + 95f * x - 1400f;
        }else if(x >= 30){
            res = 3.25f * x * x - 195f * x + 3100f;
        }else if(x >= 10){
            res = -0.375f * x * x + 22.5f * x - 162.5f;
        }else if(x >= 0){
            res = 2.5f * x;
        }
        return 1.0f + res * 0.01f;
    }

//    @SubscribeEvent
//    public static void yeggyPearlEffect(LivingDamageEvent event) {
//        Entity source = event.getSource().getImmediateSource();
//        if (source instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) source;
//            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
//            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.YEGGY_PEARL.get())) {
//                event.setAmount(event.getAmount() * getDamageTimes(getEnergy(helmet)));
////                System.out.println("yesa: " + event.getAmount());
////                System.out.println("times: " + getDamageTimes(getEnergy(helmet)));
//                setEnergy(helmet, 0);
//            }
//        }
//    }
}
