package tech.lq0.providencraft.item.providenceOI.yesa;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MintChocolate extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.8f).nutrition(4).alwaysEat().
            effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0f).
            effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1.0f).build();

    public MintChocolate() {
        super(new Properties().food(food));
    }

    //TODO 添加混沌值
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.mint_chocolate_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.mint_chocolate_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.YESA);
    }

//    @Override
//    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
//        if (!worldIn.isRemote && entityLiving instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) entityLiving;
//            ChaosHelper.addChaos(player, -5);
//        }
//        return super.onItemUseFinish(stack, worldIn, entityLiving);
//    }
}
