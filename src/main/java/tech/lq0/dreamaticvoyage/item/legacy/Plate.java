package tech.lq0.dreamaticvoyage.item.legacy;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Plate extends Item {
    public Plate() {
        super(new Properties().durability(10).rarity(RarityTool.LEGACY));
    }

    @SubscribeEvent
    public static void plateEffect(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();

        ItemStack stack = entity.getOffhandItem();
        if (stack.getItem() == ItemRegistry.PLATE.get()) {
            if (event.getAmount() >= 10) {
                event.setAmount(1);
                stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.OFFHAND));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.plate_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.plate_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLegacyInfo(pTooltipComponents);
    }
}
