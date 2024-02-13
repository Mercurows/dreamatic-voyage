package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class Louistew extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).saturationMod(0.6f).nutrition(14).
            effect(() -> new MobEffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 200, 0), 0.1f).
            effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0), 1.0f).build();

    public Louistew(){
        super(new Properties().stacksTo(1).food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.louistew").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.louistew.warn").withStyle(ChatFormatting.RED));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            if (player.isCreative()) {
                return pStack;
            }
        }
        return new ItemStack(Items.BOWL);
    }
}
