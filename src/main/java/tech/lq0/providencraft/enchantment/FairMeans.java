package tech.lq0.providencraft.enchantment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EnchantmentRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FairMeans extends Enchantment {
    private static final EquipmentSlot[] SLOTS = new EquipmentSlot[]{EquipmentSlot.MAINHAND};

    public FairMeans() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, SLOTS);
    }

    @Override
    public int getMinCost(int pLevel) {
        return 13 + 5 * pLevel;
    }

    @Override
    public int getMaxCost(int pLevel) {
        return super.getMaxCost(pLevel) + 10;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @SubscribeEvent
    public static void attackEvent(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();
        Entity entity = event.getSource().getDirectEntity();
        if (!target.level().isClientSide && entity instanceof LivingEntity attacker) {
            ItemStack stack = attacker.getMainHandItem();
            if (!stack.isEmpty()) {
                int level = EnchantmentHelper.getTagEnchantmentLevel(EnchantmentRegistry.FAIR_MEANS.get(), stack);
                if (level > 0) {
                    if (stack.getOrCreateTag().getBoolean("FairMeans")) {
                        event.setAmount(event.getAmount() * (1.5f + level));
                        stack.getOrCreateTag().putBoolean("FairMeans", false);
                    } else {
                        event.setAmount(Math.min(0.1f + 0.05f * level, 0.5f) * event.getAmount());
                        stack.getOrCreateTag().putBoolean("FairMeans", true);
                    }
                }
            }
        }
    }
}
