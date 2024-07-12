package tech.lq0.dreamaticvoyage.voyage.core;

import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Voyage {

    /**
     * 远航的基础属性，会影响远航期间的事件以及战利品等
     */
    // 远航的等级
    private final int level;
    // 远航的时间
    private final int time;
    // 远航的载货量
    private final int capacity;
    // 幸运
    private final float luck;
    // 智力
    private final float intelligence;
    // 洞察力
    private final float insight;
    // 社交能力
    private final float sociability;

    private int currentTime;
    private int currentCapacity;
    private final List<ItemStack> items = new ArrayList<>();
    private UUID uuid;
    private int currentEventCount;
    private boolean isFinished;

    public Voyage(int level, int time, int capacity, float luck, float intelligence, float insight, float sociability) {
        this.level = level;
        this.time = time;
        this.capacity = capacity;
        this.luck = luck;
        this.intelligence = intelligence;
        this.insight = insight;
        this.sociability = sociability;
    }

    public void tick() {
        if (isFinished) return;

        this.currentTime++;


        if (this.currentTime >= this.time) {
            this.isFinished = true;
        }
    }

}
