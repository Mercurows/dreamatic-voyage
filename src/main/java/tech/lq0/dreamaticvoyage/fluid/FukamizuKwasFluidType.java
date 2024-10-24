package tech.lq0.dreamaticvoyage.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import tech.lq0.dreamaticvoyage.Utils;

import java.util.function.Consumer;

public class FukamizuKwasFluidType extends FluidType {

    public FukamizuKwasFluidType() {
        super(FluidType.Properties.create().fallDistanceModifier(0F).canExtinguish(true)
                .supportsBoating(true).canHydrate(false).motionScale(0.007D).canPushEntity(true)
                .canSwim(true).canConvertToSource(false).canDrown(false)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public int getTintColor() {
                return 0xFFFECF02;
            }

            @Override
            public ResourceLocation getStillTexture() {
                return Utils.loc("block/fukamizu_kwas_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return Utils.loc("block/fukamizu_kwas_flowing");
            }
        });
    }

}
