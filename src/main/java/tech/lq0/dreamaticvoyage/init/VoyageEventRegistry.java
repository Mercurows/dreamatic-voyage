package tech.lq0.dreamaticvoyage.init;

import net.minecraft.resources.ResourceLocation;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.voyage.core.VoyageEvent;

public class VoyageEventRegistry {
    // TODO 正确实现事件注册
    public static final VoyageEvent BREAD = new VoyageEvent(
            "fukamizu_bakery",
            VoyageEvent.Type.BENEFICIAL,
            new ResourceLocation(Utils.MOD_ID, ""),
            new ResourceLocation(Utils.MOD_ID, ""),
            new float[]{0.0f, 0.0f, 0.0f, 0.0f},
            new float[]{0.0f, 0.0f, 0.0f, 0.0f},
            VoyageEvent.ResultType.CONTINUE,
            false,
            1
    );
}
