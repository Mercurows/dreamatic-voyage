package tech.lq0.dreamaticvoyage.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;

public class PeaceWish extends Enchantment {
    private static final EquipmentSlot[] CHEST = new EquipmentSlot[]{EquipmentSlot.CHEST};

    public PeaceWish() {
        super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, CHEST);
    }

    @Override
    public int getMinCost(int pLevel) {
        return 20 + 9 * pLevel;
    }

    @Override
    public int getMaxCost(int pLevel) {
        return super.getMaxCost(pLevel) + 10;
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (!pTarget.level().isClientSide()) {
            if (pAttacker instanceof LivingEntity entity) {
                entity.addEffect(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 100, pLevel - 1));
            }
        }
    }
}
