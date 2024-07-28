package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.effect.*;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Utils.MOD_ID);

    public static final RegistryObject<MobEffect> BLESS_OF_DARK_ELF = EFFECTS.register("bless_of_dark_elf", BlessOfDarkElf::new);
    public static final RegistryObject<MobEffect> CURSE_OF_SERPENT = EFFECTS.register("curse_of_serpent", CurseOfSerpent::new);
    public static final RegistryObject<MobEffect> BIG_FIERCE_ONE = EFFECTS.register("big_fierce_one", BigFierceOne::new);
    public static final RegistryObject<MobEffect> BIG_MOE_ONE = EFFECTS.register("big_moe_one", BigMoeOne::new);
    public static final RegistryObject<MobEffect> OVERLOAD = EFFECTS.register("overload", Overload::new);
    public static final RegistryObject<MobEffect> HOLINESS = EFFECTS.register("holiness", Holiness::new);
    public static final RegistryObject<MobEffect> BLEEDING = EFFECTS.register("bleeding", Bleeding::new);
    public static final RegistryObject<MobEffect> ECLIPSE_NIGHT = EFFECTS.register("eclipse_night", EclipseNight::new);
    public static final RegistryObject<MobEffect> SWEET_MIRAGE = EFFECTS.register("sweet_mirage", SweetMirage::new);
    public static final RegistryObject<MobEffect> MANA_SURGE = EFFECTS.register("mana_surge", ManaSurge::new);
    public static final RegistryObject<MobEffect> CREATIVITY_BANKRUPTCY = EFFECTS.register("creativity_bankruptcy", CreativityBankruptcy::new);
}
