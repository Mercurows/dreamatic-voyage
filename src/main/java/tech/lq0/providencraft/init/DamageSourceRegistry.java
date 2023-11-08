package tech.lq0.providencraft.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;

public class DamageSourceRegistry {
    public static final DamageSource BENI_CAKE = (new DamageSource("beni_cake")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource MARI_FOOD = (new DamageSource("mari_food")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource EMO = (new DamageSource("emotional_damage")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource LOTUS = (new DamageSource("lotus_potato")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource SORAYO = (new DamageSource("sorayo")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource OVERLOAD = (new DamageSource("overload")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource BLEEDING = (new DamageSource("pdc_bleeding")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource BLOOD_CRYSTAL = (new DamageSource("blood_crystal").setProjectile());
    public static final DamageSource LUNAR_ECLIPSE = (new DamageSource("lunar_eclipse").setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute());
    public static final DamageSource FUKAMIZU_BREAD = (new DamageSource("fukamizu_bread")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource BROWNIE_UZZA = (new DamageSource("brownie_uzza")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource CHOCOAL_COOKIE = (new DamageSource("chocoal_cookie")).setDamageBypassesArmor().setMagicDamage();

    public static DamageSource causeLeviyBeamDamage(Entity source, LivingEntity indirectEntityIn) {
        return new IndirectEntityDamageSource("leviy_beam", source, indirectEntityIn);
    }

    public static DamageSource causeAbsoluteLeviyBeamDamage(Entity source, LivingEntity indirectEntityIn) {
        return new IndirectEntityDamageSource("leviy_beam", source, indirectEntityIn).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    }
}
