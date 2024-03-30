package tech.lq0.dreamaticvoyage.item.other;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class GourmetMedal extends Item implements ICurioItem {
    public static final String TAG_GOURMET_MEDAL = "GourmetMedal";

    public GourmetMedal() {
        super(new Properties().stacksTo(1).fireResistant().rarity(RarityTool.FICTIONAL));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal").withStyle(ChatFormatting.GRAY));

        float progress = ItemNBTTool.getFloat(pStack, TAG_GOURMET_MEDAL, 0f);
        if (progress >= 1f) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal.done").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
        } else {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal.need").withStyle(ChatFormatting.RED)
                    .append(Component.literal(String.format("%.2f%%", progress * 100))));
        }
    }

    //TODO 解决碗装食物无法触发进度的问题
    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof ServerPlayer player && player.getServer() != null) {
            var advancements = player.getServer().getAdvancements();
            var adv = advancements.getAdvancement(new ResourceLocation(Utils.MOD_ID, "main/apex_gourmet"));
            if (adv != null) {
                ItemNBTTool.setFloat(pStack, TAG_GOURMET_MEDAL, player.getAdvancements().getOrStartProgress(adv).getPercent());
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
