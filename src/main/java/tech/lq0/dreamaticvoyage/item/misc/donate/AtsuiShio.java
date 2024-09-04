package tech.lq0.dreamaticvoyage.item.misc.donate;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AtsuiShio extends Item {
    public static final String TAG_BURN = "AtsuiShioBurn";

    public static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.5f).nutrition(1).alwaysEat().build();

    public AtsuiShio() {
        super(new Properties().food(food).stacksTo(1).fireResistant().rarity(RarityTool.DONATE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.atsuishio").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDonateInfo(pTooltipComponents);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            player.getPersistentData().putBoolean(TAG_BURN, true);

            if (player.isCreative()) {
                return pStack;
            } else {
                return ItemRegistry.EMPTY_JAR.get().getDefaultInstance();
            }
        }
        return ItemRegistry.EMPTY_JAR.get().getDefaultInstance();
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.HEAD;
    }

    @SubscribeEvent
    public static void doBurning(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (event.phase == TickEvent.Phase.END) {
            if (player.getPersistentData().getBoolean(TAG_BURN) && !player.level().isClientSide) {
                player.setSecondsOnFire(1);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.getPersistentData().contains(TAG_BURN)) {
                player.getPersistentData().remove(TAG_BURN);
            }
        }
    }
}
