package tech.lq0.dreamaticvoyage.item.misc.fukamizutech;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootDataResolver;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class MineralizedFukamizuBread extends Item {
    public MineralizedFukamizuBread() {
        super(new Properties().rarity(Rarity.UNCOMMON).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mineralized_fukamizu_bread").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDevelopingText(pTooltipComponents);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide && pLevel instanceof ServerLevel serverLevel) {
            LootDataResolver manager = serverLevel.getServer().getLootData();
            LootTable lootTable = manager.getLootTable(new ResourceLocation(Utils.MOD_ID, "fukamizutech/mineralized_fukamizu_bread"));

            ItemStack stack = pPlayer.getItemInHand(pUsedHand);

            if (!pPlayer.getAbilities().instabuild) {
                stack.shrink(1);
            }

            List<ItemStack> items = lootTable.getRandomItems((new LootParams.Builder(serverLevel)).withParameter(LootContextParams.ORIGIN,
                    pPlayer.getEyePosition()).create(LootContextParamSets.CHEST));
            pPlayer.addItem(new ItemStack(items.get(0).getItem()));
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
