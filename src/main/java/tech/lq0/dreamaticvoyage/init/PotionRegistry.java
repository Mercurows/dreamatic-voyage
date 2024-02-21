package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;

public class PotionRegistry {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Utils.MOD_ID);

    public static final RegistryObject<Potion> BLEEDING = POTIONS.register("pdc_bleeding",
            () -> new Potion(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 1200, 0)));
    public static final RegistryObject<Potion> SUPER_BLEEDING = POTIONS.register("super_pdc_bleeding",
            () -> new Potion(new MobEffectInstance(EffectRegistry.BLEEDING.get(), 300, 4)));
}
