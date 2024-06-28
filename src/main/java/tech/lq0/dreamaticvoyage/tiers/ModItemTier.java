package tech.lq0.dreamaticvoyage.tiers;

import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    RED_AHOGE(2, 321, 7.0F, 2.0F, 14,
            () -> Ingredient.of(ItemRegistry.RED_AHOGE.get())),
    DARK_ELF(4, 39, 50.0F, 1.0F, 20,
            () -> Ingredient.of(ItemRegistry.WHITE_AHOGE.get())),
    HARDEN_CRYSTAL(2, 402, 7.0F, 2.0F, 14,
            () -> Ingredient.of(ItemRegistry.HARDEN_CRYSTAL_INGOT.get())),
    PURIFIED_CRYSTAL(4, 2321, 9.0F, 4.0F, 16,
            () -> Ingredient.of(ItemRegistry.PURIFIED_CRYSTAL_INGOT.get())),
    CHARGED_CRYSTAL(5, 3410, 12.0F, 6.0F, 20,
            () -> Ingredient.of(ItemRegistry.CHARGED_CRYSTAL_INGOT.get())),
    FICTIONAL_INGOT(6, 5601, 14.0F, 8.0F, 24,
            () -> Ingredient.of(ItemRegistry.FICTIONAL_INGOT.get())),
    FUKAMIZU_BREAD(3, 404, 7.0F, 5.5F, 16,
            () -> Ingredient.of(ItemRegistry.FUKAMIZU_BREAD_INGOT.get()));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public @Nullable TagKey<Block> getTag() {
        return Tier.super.getTag();
    }
}
