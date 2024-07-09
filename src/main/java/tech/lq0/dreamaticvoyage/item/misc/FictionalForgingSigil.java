package tech.lq0.dreamaticvoyage.item.misc;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.GrindstoneEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;

import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FictionalForgingSigil extends Item {
    public static final String TAG_FICTIONAL_FORGING_SIGIL = "FictionalForgingSigil";

    public FictionalForgingSigil() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fictional_forging_sigil").withStyle(ChatFormatting.GRAY));
    }

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (right.getItem() == ItemRegistry.FICTIONAL_FORGING_SIGIL.get()) {
            if (getForgingCount(left) >= 3) {
                event.setCanceled(true);
                return;
            }

            ItemStack output = left.copy();
            Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(output);

            if (enchants.isEmpty()) {
                event.setCanceled(true);
                return;
            }

            for (Map.Entry<Enchantment, Integer> enchant : enchants.entrySet()) {
                Enchantment ench = enchant.getKey();
                int lvl = enchant.getValue();

                if (ench.getMaxLevel() != 1 && lvl < 32767) {
                    enchants.put(ench, lvl + 1);
                }
            }

            EnchantmentHelper.setEnchantments(enchants, output);
            ItemNBTTool.setInt(output, TAG_FICTIONAL_FORGING_SIGIL, getForgingCount(left) + 1);

            event.setOutput(output);
            event.setCost((getForgingCount(left) + 1) * 10);
            event.setMaterialCost(1);
        }
    }

    private static int getForgingCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_FICTIONAL_FORGING_SIGIL, 0);
    }

    @SubscribeEvent
    public static void onGrindstone(GrindstoneEvent event) {
        ItemStack top = event.getTopItem();
        ItemNBTTool.setInt(top, TAG_FICTIONAL_FORGING_SIGIL, 0);
    }

}
