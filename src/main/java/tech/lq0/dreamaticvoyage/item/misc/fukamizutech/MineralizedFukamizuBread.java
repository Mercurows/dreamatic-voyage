package tech.lq0.dreamaticvoyage.item.misc.fukamizutech;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Random;

public class MineralizedFukamizuBread extends Item {
    public MineralizedFukamizuBread() {
        super(new Properties().rarity(Rarity.UNCOMMON).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mineralized_fukamizu_bread").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDevelopingText(pTooltipComponents);
    }

    private static List<Item> rawMaterials = List.of();

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide && pLevel instanceof ServerLevel) {
            ItemStack stack = pPlayer.getItemInHand(pUsedHand);

            if (!pPlayer.getAbilities().instabuild) {
                stack.shrink(1);
            }

            if (rawMaterials.isEmpty()) {
                rawMaterials = ForgeRegistries.ITEMS.getValues()
                        .stream()
                        .filter(item -> item.getDefaultInstance().is(Tags.Items.RAW_MATERIALS))
                        .toList();
            }

            int index = new Random().nextInt(rawMaterials.size());
            pPlayer.addItem(new ItemStack(rawMaterials.get(index)));
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
