package tech.lq0.dreamaticvoyage.item.other;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class GourmetMedal extends Item implements ICurioItem {
    public GourmetMedal() {
        super(new Properties().stacksTo(1).fireResistant().rarity(RarityTool.FICTIONAL));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof ServerPlayer player && player.getServer() != null) {
            var advancements = player.getServer().getAdvancements();
            var adv = advancements.getAdvancement(new ResourceLocation(Utils.MOD_ID, "main/eat_all_food"));
            if (adv != null) {
                if (player.getAdvancements().getOrStartProgress(adv).isDone()) {
                }
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
