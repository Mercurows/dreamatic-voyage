package tech.lq0.dreamaticvoyage.item.misc.fukamizutech;

import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;

import java.util.List;
import java.util.function.Supplier;

public class MetalBreadSlice extends Item {
    public String name;
    public float hurtDamage = 5.0f;
    private final List<Supplier<MobEffectInstance>> effects = Lists.newArrayList();

    public MetalBreadSlice(String name) {
        super(new Item.Properties().fireResistant());
        this.name = name;
    }

    public MetalBreadSlice(String name, float hurtDamage) {
        super(new Item.Properties().fireResistant());
        this.name = name;
        this.hurtDamage = hurtDamage;
    }

    public MetalBreadSlice setEffect(@Nullable Supplier<MobEffectInstance> effect) {
        if (effect != null) {
            this.effects.add(effect);
        }
        return this;
    }

    public MetalBreadSlice setEffect(List<Supplier<MobEffectInstance>> effects) {
        if (!effects.isEmpty()) {
            this.effects.addAll(effects);
        }
        return this;
    }

    @Override
    public boolean isEdible() {
        return true;
    }

    @Override
    public @Nullable FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
        var builder = new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).alwaysEat();
        if (!effects.isEmpty()) {
            for (var effect : effects) {
                builder.effect(effect, 1.0f);
            }
        }

        return builder.build();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage." + this.name + "_bread_slice").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 100;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide) {
            pLivingEntity.hurt(DamageSourceRegistry.causeFukamizuBreadDamage(pLevel.registryAccess(), null), hurtDamage);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
