package tech.lq0.providencraft.init;

import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.particle.TentacleParticleData;
import tech.lq0.providencraft.particle.TentacleParticleType;

public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Utils.MOD_ID);

    public static final RegistryObject<ParticleType<TentacleParticleData>> TENTACLE_PARTICLE = PARTICLE_TYPES.register("tentacle_particle", TentacleParticleType::new);
}
