package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class SatouChestplate extends ArmorItem {
    public SatouChestplate() {
        super(ModArmorMaterial.SATOU, Type.CHESTPLATE, new Properties().durability(70));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.satou_chestplate").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SATOU);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            if (player.getFoodData().needsFood()) {
                if (player.tickCount % 20 == 0) {
                    player.getFoodData().eat(1, 0.5f);
                    stack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(EquipmentSlot.CHEST));
                }
            }

            if (player.isInWater() || (level.isRaining() && level.canSeeSky(player.getOnPos().offset(0, 1, 0)) &&
                    level.getBiome(player.getOnPos()).get().getModifiedClimateSettings().downfall() != 0)) {
                if (player.tickCount % 2 == 0) {
                    stack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(EquipmentSlot.CHEST));
                }
            }
        }
    }
}
