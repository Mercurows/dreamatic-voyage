package tech.lq0.providencraft.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class UniHusk extends Enchantment {
    private static final EquipmentSlot[] CHEST = new EquipmentSlot[]{EquipmentSlot.CHEST};

    public UniHusk() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, CHEST);
    }

    @Override
    public int getMinCost(int pLevel) {
        return 8 + 6 * pLevel;
    }

    @Override
    public int getMaxCost(int pLevel) {
        return super.getMaxCost(pLevel) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (!pTarget.level().isClientSide()) {
            if (pAttacker instanceof LivingEntity entity) {
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, pLevel));
            }
        }
    }
}
