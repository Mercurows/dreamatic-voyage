package tech.lq0.dreamaticvoyage.tiers;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    CHIRAM("chiram", 25, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 2);
        p.put(ArmorItem.Type.LEGGINGS, 8);
        p.put(ArmorItem.Type.CHESTPLATE, 10);
        p.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_IRON, 3.5F, 0.3F, () -> Ingredient.of(Items.IRON_INGOT)),
    CHIRAM_PLUS("chiram_plus", 35, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 4);
        p.put(ArmorItem.Type.LEGGINGS, 10);
        p.put(ArmorItem.Type.CHESTPLATE, 16);
        p.put(ArmorItem.Type.HELMET, 5);
    }), 25, SoundEvents.ARMOR_EQUIP_IRON, 6.0F, 0.4F, () -> Ingredient.of(Items.IRON_BLOCK)),
    RED_AHOGE("red_ahoge", 18, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 3);
        p.put(ArmorItem.Type.LEGGINGS, 5);
        p.put(ArmorItem.Type.CHESTPLATE, 5);
        p.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(ItemRegistry.RED_AHOGE.get())),
    CRYSTAL("crystal", 22, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 4);
        p.put(ArmorItem.Type.LEGGINGS, 5);
        p.put(ArmorItem.Type.CHESTPLATE, 6);
        p.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.AMETHYST_BLOCK_PLACE, 0.0F, 0.0F, () -> Ingredient.of(Items.AMETHYST_SHARD)),
    IDOL_COSTUME("idol_costume", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 2);
        p.put(ArmorItem.Type.LEGGINGS, 3);
        p.put(ArmorItem.Type.CHESTPLATE, 5);
        p.put(ArmorItem.Type.HELMET, 3);
    }), 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(ItemRegistry.IDOL_CLOTH.get())),
    MAGICROS("magicros", 40, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 7);
        p.put(ArmorItem.Type.LEGGINGS, 8);
        p.put(ArmorItem.Type.CHESTPLATE, 10);
        p.put(ArmorItem.Type.HELMET, 5);
    }), 24, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.25F, () -> Ingredient.of(ItemRegistry.IDOL_CLOTH.get())),
    SATOU("satou", 5, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 1);
        p.put(ArmorItem.Type.LEGGINGS, 2);
        p.put(ArmorItem.Type.CHESTPLATE, 3);
        p.put(ArmorItem.Type.HELMET, 1);
    }), 12, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> Ingredient.of(Items.SUGAR)),
    HARDEN_CRYSTAL("harden_crystal", 20, Util.make(new EnumMap<>(ArmorItem.Type.class), p -> {
        p.put(ArmorItem.Type.BOOTS, 2);
        p.put(ArmorItem.Type.LEGGINGS, 6);
        p.put(ArmorItem.Type.CHESTPLATE, 7);
        p.put(ArmorItem.Type.HELMET, 3);
    }), 17, SoundEvents.ARMOR_EQUIP_GENERIC, 0.5F, 0.0F, () -> Ingredient.of(ItemRegistry.HARDEN_CRYSTAL_INGOT.get()));

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorMaterial(String pName, int pDurabilityMultiplier, EnumMap<ArmorItem.Type, Integer> pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = pProtectionFunctionForType;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return this.name;
    }
}
