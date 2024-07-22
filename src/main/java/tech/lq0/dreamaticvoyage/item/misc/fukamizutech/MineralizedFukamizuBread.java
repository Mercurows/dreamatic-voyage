package tech.lq0.dreamaticvoyage.item.misc.fukamizutech;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Random;

public class MineralizedFukamizuBread extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.75f).nutrition(6)
            .alwaysEat().build();

    private static List<Item> rawMaterials = List.of();

    public MineralizedFukamizuBread() {
        super(new Properties().rarity(Rarity.UNCOMMON).fireResistant().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.mineralized_fukamizu_bread").withStyle(ChatFormatting.GRAY));

        TooltipTool.addDevelopingText(pTooltipComponents);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 80;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            pLivingEntity.hurt(DamageSourceRegistry.causeFukamizuBreadDamage(pLevel.registryAccess(), null), 10.0f);

            if (rawMaterials.isEmpty()) {
                rawMaterials = ForgeRegistries.ITEMS.getValues()
                        .stream()
                        .filter(item -> item.getDefaultInstance().is(Tags.Items.RAW_MATERIALS))
                        .toList();
            }

            double random = new Random().nextDouble();

            if (random > .25) {
                int index = new Random().nextInt(rawMaterials.size());
                player.addItem(new ItemStack(rawMaterials.get(index)));
            }
        }

        return super.finishUsingItem(stack, pLevel, pLivingEntity);
    }

}
