package tech.lq0.dreamaticvoyage.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EnchantmentRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShadowOfVoid extends Enchantment {
    private static final EquipmentSlot[] HEAD = new EquipmentSlot[]{EquipmentSlot.HEAD};

    public ShadowOfVoid() {
        super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, HEAD);
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

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity living = event.getEntity();

        if (EnchantmentHelper.getTagEnchantmentLevel(EnchantmentRegistry.SHADOW_OF_VOID.get(), living.getItemBySlot(EquipmentSlot.HEAD)) <= 0) {
            return;
        }

        DamageSource source = event.getSource();
        if (source.getEntity() instanceof LivingEntity attacker) {
            Vec3 vec3 = living.getViewVector(1.0F).normalize();
            Vec3 vec31 = new Vec3(attacker.getX() - living.getX(), attacker.getEyeY() - living.getEyeY(), attacker.getZ() - living.getZ());
            double d0 = vec31.length();
            vec31 = vec31.normalize();
            double d1 = vec3.dot(vec31);
            boolean flag = d1 > 1.0D - 0.025D / d0 && living.hasLineOfSight(attacker);

            if (!flag) {
                event.setAmount(event.getAmount() * living.getRandom().nextIntBetweenInclusive(0, 5) / 10.0f);
            }
        }
    }
}
