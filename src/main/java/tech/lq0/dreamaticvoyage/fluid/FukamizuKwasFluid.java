package tech.lq0.dreamaticvoyage.fluid;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;
import tech.lq0.dreamaticvoyage.init.FluidRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public abstract class FukamizuKwasFluid extends ForgeFlowingFluid {
    public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(FluidRegistry.FUKAMIZU_KWAS_TYPE,
            FluidRegistry.FUKAMIZU_KWAS, FluidRegistry.FLOWING_FUKAMIZU_KWAS).explosionResistance(100.0f)
            .block(BlockRegistry.FUKAMIZU_KWAS).bucket(ItemRegistry.FUKAMIZU_KWAS_BUCKET);

    public FukamizuKwasFluid() {
        super(PROPERTIES);
    }

    public static class Source extends FukamizuKwasFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends FukamizuKwasFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
