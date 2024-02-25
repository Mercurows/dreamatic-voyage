package tech.lq0.dreamaticvoyage.item.cnt.qianyun;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class Suitcase extends Item {
    public Suitcase() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.suitcase").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.QIANYUN);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        PlayerEnderChestContainer playerEnderChestContainer = pPlayer.getEnderChestInventory();
        // 此处非空判断不能删除
        if (!pLevel.isClientSide && playerEnderChestContainer != null) {
            pPlayer.openMenu(new SimpleMenuProvider((p_53124_, p_53125_, p_53126_)
                    -> ChestMenu.threeRows(p_53124_, p_53125_, playerEnderChestContainer), stack.getHoverName()));
            pPlayer.awardStat(Stats.ITEM_USED.get(this), 1);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}