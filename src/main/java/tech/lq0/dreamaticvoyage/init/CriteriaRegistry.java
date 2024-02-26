package tech.lq0.dreamaticvoyage.init;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tech.lq0.dreamaticvoyage.advancements.criterion.CallInThunderTrigger;
import tech.lq0.dreamaticvoyage.advancements.criterion.FillLavaTrigger;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CriteriaRegistry {
    public static FillLavaTrigger FILL_LAVA;
    public static CallInThunderTrigger CALL_IN_THUNDER;

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FILL_LAVA = register(new FillLavaTrigger());
            CALL_IN_THUNDER = register(new CallInThunderTrigger());
        });
    }

    public static <T extends SimpleCriterionTrigger<?>> T register(T criterion) {
        CriteriaTriggers.register(criterion);
        return criterion;
    }
}
