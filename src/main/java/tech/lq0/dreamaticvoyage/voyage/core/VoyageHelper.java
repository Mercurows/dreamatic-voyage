package tech.lq0.dreamaticvoyage.voyage.core;

import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.VoyageEventRegistry;

import java.util.List;

public class VoyageHelper {

    @Nullable
    public static VoyageEvent generateVoyageEvent(Voyage voyageData) {
        var availableEvents = VoyageEventRegistry.EVENTS.getEntries().stream().filter(r -> voyageData.appearConditionMatch(r.get())
                && r.get().level <= voyageData.level).toList();
        if (availableEvents.isEmpty()) return null;

        return availableEvents.get((int) (Math.random() * availableEvents.size())).get();
    }

    /**
     * 将tempList的物品合并至resultList上
     */
    public static void mergeList(List<ItemStack> temp, List<ItemStack> result, int index) {
        for (ItemStack itemStack : temp) {
            insertNewItem(result, itemStack, index);
        }
    }

    private static void insertNewItem(List<ItemStack> result, ItemStack stack, int index) {
        if (stack.isEmpty()) return;

        for (int i = index; i < result.size(); i++) {
            var slot = result.get(i);
            if (slot.isEmpty()) {
                result.set(i, stack);
                break;
            }

            if (slot.getCount() >= 64) continue;
            if (!ItemStack.isSameItemSameTags(slot, stack)) continue;

            int slotItemCount = slot.getCount();
            int itemCount = stack.getCount();

            int maxAddableCount = 64 - slotItemCount;

            if (maxAddableCount >= itemCount) {
                stack.setCount(0);
                slot.setCount(slotItemCount + itemCount);
                break;
            }

            stack.setCount(itemCount - maxAddableCount);
            slot.setCount(64);
        }
    }

    public static void processAttributes(Voyage voyage, VoyageEvent event) {
        if (voyage.successConditionMatch(event)) {
            voyage.luck += event.successAttributeBonus[0];
            voyage.intelligence += event.successAttributeBonus[1];
            voyage.insight += event.successAttributeBonus[2];
            voyage.sociability += event.successAttributeBonus[3];
        } else {
            voyage.luck += event.failAttributeBonus[0];
            voyage.intelligence += event.failAttributeBonus[1];
            voyage.insight += event.failAttributeBonus[2];
            voyage.sociability += event.failAttributeBonus[3];
        }
    }
}
