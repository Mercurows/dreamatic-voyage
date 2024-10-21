package tech.lq0.dreamaticvoyage.init;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.voyage.core.VoyageEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoyageEventRegistry {

    public static final DeferredRegister<VoyageEvent> EVENTS = DeferredRegister.create(Utils.loc("voyage_event"), Utils.MOD_ID);

    public static final RegistryObject<VoyageEvent> FUKAMIZU_BAKERY = EVENTS.register("fukamizu_bakery", () -> new VoyageEvent(
            "fukamizu_bakery",
            VoyageEvent.Type.BENEFICIAL,
            new float[]{0.1f, 0.0f, 0.0f, 0.0f},
            new float[]{0.0f, 0.0f, 0.0f, 0.0f},
            VoyageEvent.ResultType.CONTINUE,
            false,
            1
    ));

    public static final RegistryObject<VoyageEvent> BITE_THE_HOOK = EVENTS.register("bite_the_hook", () -> new VoyageEvent(
            "bite_the_hook",
            VoyageEvent.Type.NEUTRAL,
            new float[]{0.2f, 0.0f, 0.0f, 0.0f},
            new float[]{0.0f, 0.0f, 0.0f, 0.0f},
            new float[]{0.1f, 0.0f, 0.0f, 0.0f},
            new float[]{0.0f, -0.1f, 0.0f, 0.0f},
            VoyageEvent.ResultType.CONTINUE,
            false,
            1
    ));

    public static final RegistryObject<VoyageEvent> MERMAID_GOD = EVENTS.register("mermaid_god", () -> new VoyageEvent(
            "mermaid_god",
            VoyageEvent.Type.NEUTRAL,
            new float[]{0.1f, 0.0f, 0.0f, 0.2f},
            new float[]{0.0f, 0.0f, 0.0f, 0.0f},
            new float[]{0.0f, 0.0f, 0.1f, 0.1f},
            new float[]{-0.1f, -0.1f, 0.0f, 0.0f},
            VoyageEvent.ResultType.CONTINUE,
            false,
            1
    ));

    public static final RegistryObject<VoyageEvent> EVIL_BOSS = EVENTS.register("evil_boss", () -> new VoyageEvent(
            "evil_boss",
            VoyageEvent.Type.HARMFUL,
            new float[]{0.0f, 0.0f, 0.0f, 0.0f},
            new float[]{0.0f, 0.0f, 0.0f, 0.0f},
            VoyageEvent.ResultType.BREAK,
            false,
            1
    ));

    @SubscribeEvent
    public static void registry(NewRegistryEvent event) {
        event.create(new RegistryBuilder<VoyageEvent>().setName(Utils.loc("voyage_event")));
    }
}
