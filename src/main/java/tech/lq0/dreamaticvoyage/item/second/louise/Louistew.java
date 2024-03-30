package tech.lq0.dreamaticvoyage.item.second.louise;

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
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

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
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.louistew").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.louistew.warn").withStyle(ChatFormatting.RED));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LOUISE);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pLivingEntity);
        return pLivingEntity instanceof Player && ((Player)pLivingEntity).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
    }
}
