package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.BlockRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class UniMillet extends ItemNameBlockItem {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.25f).nutrition(2).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0), 1.0f).build();

    public UniMillet(){
        super(BlockRegistry.UNI_MILLET_BLOCK.get(), new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.uni_millet").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }
}
