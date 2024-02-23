package tech.lq0.dreamaticvoyage.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;

public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Utils.MOD_ID);

    public static final RegistryObject<SimpleParticleType> TENTACLE = PARTICLE_TYPES.register("tentacle", () -> new SimpleParticleType(false));
}
