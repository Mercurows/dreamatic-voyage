package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.fluid.FukamizuKwasFluid;
import tech.lq0.dreamaticvoyage.fluid.FukamizuKwasFluidType;

public class FluidRegistry {

    /**
     * Fluids
     */
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Utils.MOD_ID);

    public static final RegistryObject<FlowingFluid> FUKAMIZU_KWAS = FLUIDS.register("fukamizu_kwas", FukamizuKwasFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_FUKAMIZU_KWAS = FLUIDS.register("flowing_fukamizu_kwas", FukamizuKwasFluid.Flowing::new);

    /**
     * Fluid Types
     */
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Utils.MOD_ID);

    public static final RegistryObject<FluidType> FUKAMIZU_KWAS_TYPE = FLUID_TYPES.register("fukamizu_kwas", FukamizuKwasFluidType::new);

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
        FLUID_TYPES.register(bus);
    }
}
