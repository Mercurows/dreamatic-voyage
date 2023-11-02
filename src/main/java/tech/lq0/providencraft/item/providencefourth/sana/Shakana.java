package tech.lq0.providencraft.item.providencefourth.sana;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class Shakana extends Item {
    private static final Food food = (new Food.Builder()).setAlwaysEdible().hunger(2).saturation(0.25f).fastToEat()
            .effect(() -> new EffectInstance(Effects.SPEED, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.SLOWNESS, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.HASTE, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.MINING_FATIGUE, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.STRENGTH, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 1, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.INSTANT_DAMAGE, 1, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.JUMP_BOOST, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.RESISTANCE, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.WATER_BREATHING, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.INVISIBILITY, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.BLINDNESS, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.HUNGER, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.WEAKNESS, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.POISON, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.WITHER, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.SATURATION, 20, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.GLOWING, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.LEVITATION, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.LUCK, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.UNLUCK, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.SLOW_FALLING, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.CONDUIT_POWER, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.DOLPHINS_GRACE, 200, 0), 0.1f)
            .effect(() -> new EffectInstance(EffectRegistry.BLEEDING.get(), 200, 0), 0.1f)
            .effect(() -> new EffectInstance(EffectRegistry.HOLINESS.get(), 200, 0), 0.1f)
            .effect(() -> new EffectInstance(EffectRegistry.OVERLOAD.get(), 200, 0), 0.1f)
            .effect(() -> new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 200, 0), 0.01f)
            .effect(() -> new EffectInstance(Effects.BAD_OMEN, 200, 0), 0.01f)
            .build();

    public Shakana() {
        super(new Item.Properties().group(ModGroup.itemgroup).food(food).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.providencraft.shakana_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.shakana_2").mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SANA);
    }
}
