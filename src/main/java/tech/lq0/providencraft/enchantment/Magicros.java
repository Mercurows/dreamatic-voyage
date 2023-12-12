package tech.lq0.providencraft.enchantment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Magicros extends Enchantment {
    private static final EquipmentSlot[] SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public Magicros() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR, SLOTS);
    }

    @Override
    public int getMinCost(int pLevel) {
        return 9 * pLevel;
    }

    @Override
    public int getMaxCost(int pLevel) {
        return super.getMinCost(pLevel) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (pTarget instanceof Player player && !pTarget.level().isClientSide) {
            int count = 0;
            for (LivingEntity livingentity : player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10.0D, 10.0D, 10.0D))) {
                if (livingentity != player && !(livingentity instanceof Monster || livingentity instanceof ArmorStand) && player.distanceToSqr(livingentity) < 100.0D) {
                    count++;
                }
            }
            if (count >= 3) {
                player.heal((float) (pLevel + 1) * (count + 1) / 4);
                if (pAttacker instanceof LivingEntity attackerLiving) {
                    attackerLiving.hurt(player.level().damageSources().magic(), pLevel);
                    attackerLiving.knockback(pLevel + 1, player.getX() - attackerLiving.getX(), player.getZ() - attackerLiving.getZ());
                }
            }
        }
        super.doPostHurt(pTarget, pAttacker, pLevel);
    }
}
