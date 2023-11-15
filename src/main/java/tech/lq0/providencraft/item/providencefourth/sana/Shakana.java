package tech.lq0.providencraft.item.providencefourth.sana;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class Shakana extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder()).alwaysEat().nutrition(2).saturationMod(0.25f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 20, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(EffectRegistry.BLEEDING.get(), 200, 0), 0.1f)
//            .effect(() -> new MobEffectInstance(EffectRegistry.HOLINESS.get(), 200, 0), 0.1f)
//            .effect(() -> new MobEffectInstance(EffectRegistry.OVERLOAD.get(), 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0), 0.01f)
            .effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, 200, 0), 0.01f)
            .build();

    public Shakana() {
        super(new Item.Properties().food(food).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.shakana_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.shakana_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SANA);
    }
}
