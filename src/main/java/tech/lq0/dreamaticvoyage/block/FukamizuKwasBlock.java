package tech.lq0.dreamaticvoyage.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.FluidRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FukamizuKwasBlock extends LiquidBlock {

    public FukamizuKwasBlock() {
        super(FluidRegistry.FUKAMIZU_KWAS, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100.0f)
                .noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).replaceable().sound(SoundType.EMPTY));
    }

    @SubscribeEvent
    public static void onPlayerInKwas(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (event.player.isInFluidType(FluidRegistry.FUKAMIZU_KWAS_TYPE.get())) {
                if (event.player.tickCount % 20 == 0 && !event.player.level().isClientSide) {
                    event.player.getFoodData().eat(1, 0.5f);
                }
            }
        }
    }
}
