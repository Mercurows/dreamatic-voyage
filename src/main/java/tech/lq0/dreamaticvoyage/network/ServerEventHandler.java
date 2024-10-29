package tech.lq0.dreamaticvoyage.network;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod.EventBusSubscriber
public class ServerEventHandler {

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> EVENT_QUEUE = new ConcurrentLinkedQueue<>();

    public static void queueServerEvent(int tick, Runnable event) {
        EVENT_QUEUE.add(new AbstractMap.SimpleEntry<>(event, tick));
    }

    @SubscribeEvent
    public static void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> events = new ArrayList<>();
            EVENT_QUEUE.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0) {
                    events.add(work);
                }
            });
            events.forEach(e -> e.getKey().run());
            EVENT_QUEUE.removeAll(events);
        }
    }
}
