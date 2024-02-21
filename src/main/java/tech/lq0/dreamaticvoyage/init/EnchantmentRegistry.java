package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.enchantment.*;

public class EnchantmentRegistry {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Utils.MOD_ID);

    public static final RegistryObject<Enchantment> AHOGE_PARASITIC = ENCHANTMENTS.register("ahoge_parasitic", AhogeParasitic::new);
    public static final RegistryObject<Enchantment> UNI_HUSK = ENCHANTMENTS.register("uni_husk", UniHusk::new);
    public static final RegistryObject<Enchantment> MAGICROS = ENCHANTMENTS.register("magicros", Magicros::new);
    public static final RegistryObject<Enchantment> PEACE_WISH = ENCHANTMENTS.register("peace_wish", PeaceWish::new);
    public static final RegistryObject<Enchantment> FAIR_MEANS = ENCHANTMENTS.register("fair_means", FairMeans::new);
}
