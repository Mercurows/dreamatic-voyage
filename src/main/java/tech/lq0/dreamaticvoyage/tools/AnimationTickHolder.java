package tech.lq0.dreamaticvoyage.tools;

import net.minecraft.client.Minecraft;

//From Create
public class AnimationTickHolder {
    private static int ticks;
    private static int pausedTicks;

    public static void reset() {
        ticks = 0;
        pausedTicks = 0;
    }

    public static void tick() {
        if (!Minecraft.getInstance().isPaused()) {
            ticks = (ticks + 1) % 1_728_000;
        } else {
            pausedTicks = (pausedTicks + 1) % 1_728_000;
        }
    }

    public static int getTicks() {
        return getTicks(false);
    }

    public static int getTicks(boolean includePaused) {
        return includePaused ? ticks + pausedTicks : ticks;
    }

    public static float getRenderTime() {
        return getTicks() + getPartialTicks();
    }

    public static float getPartialTicks() {
        Minecraft mc = Minecraft.getInstance();
        return (mc.isPaused() ? mc.pausePartialTick : mc.getFrameTime());
    }
}
