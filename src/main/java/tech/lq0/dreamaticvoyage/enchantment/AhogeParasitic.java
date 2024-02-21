package tech.lq0.dreamaticvoyage.enchantment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;

public class AhogeParasitic extends Enchantment {
    private static final EquipmentSlot[] MAINHAND = new EquipmentSlot[]{EquipmentSlot.MAINHAND};

    public AhogeParasitic() {
        super(Rarity.RARE, EnchantmentCategory.WEAPON, MAINHAND);
    }

    @Override
    public int getMinCost(int pLevel) {
        return 1 + 8 * (pLevel - 1);
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
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return super.canApplyAtEnchantingTable(stack);
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        int times = 2;
        if (attacker instanceof Player player && !player.level().isClientSide() && !target.isAlive()) {
            ItemStack heldItem = player.getMainHandItem();

            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.RED_AHOGE_HELMET.get())) {
                times++;
            }
            if (heldItem.getItem() instanceof SwordItem swordItem) {
                if (swordItem.getTier().equals(ModItemTier.RED_AHOGE)) {
                    times++;
                }
            }

            player.heal(level * times / 2.0f);
        }
    }
}
