package tech.lq0.dreamaticvoyage.voyage.core;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.INBTSerializable;
import tech.lq0.dreamaticvoyage.init.VoyageEventRegistry;

public class Voyage implements INBTSerializable<CompoundTag> {

    /**
     * 远航的基础属性，会影响远航期间的事件以及战利品等
     */
    // 远航的等级
    public int level = 1;
    // 远航的时间
    public int time = 300;
    // 当前时间
    public int currentTime;
    // 远航的载货量
    public int capacity;
    // 幸运
    public float luck;
    // 智力
    public float intelligence;
    // 洞察力
    public float insight;
    // 社交能力
    public float sociability;

    public final NonNullList<ItemStack> items = NonNullList.create();
    public boolean finished;

    public boolean generateDrop() {

        // TODO 正确实现事件读取
        var availableEvents = VoyageEventRegistry.EVENTS.getEntries().stream().filter(r -> appearConditionMatch(r.get())).toList();
        if (availableEvents.isEmpty()) return false;

        var randomEvent = availableEvents.get((int) (Math.random() * availableEvents.size()));

        if (this.successConditionMatch(randomEvent.get())) {
            // TODO 正确实现战利品生成
            System.out.println("生成战利品");

            return true;
        }

        System.out.println("没有生成战利品");

        return false;
    }

    private boolean appearConditionMatch(VoyageEvent event) {
        var luck = event.appearCondition[0];
        var intelligence = event.appearCondition[1];
        var insight = event.appearCondition[2];
        var sociability = event.appearCondition[3];

        return luck >= this.luck && intelligence >= this.intelligence && insight >= this.insight && sociability >= this.sociability;
    }

    private boolean successConditionMatch(VoyageEvent event) {
        var luck = event.successCondition[0];
        var intelligence = event.successCondition[1];
        var insight = event.successCondition[2];
        var sociability = event.successCondition[3];

        return luck >= this.luck && intelligence >= this.intelligence && insight >= this.insight && sociability >= this.sociability;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();

        nbt.putInt("level", this.level);
        nbt.putInt("time", this.time);
        nbt.putInt("current_time", this.currentTime);
        nbt.putInt("capacity", this.capacity);
        nbt.putFloat("luck", this.luck);
        nbt.putFloat("intelligence", this.intelligence);
        nbt.putFloat("insight", this.insight);
        nbt.putFloat("sociability", this.sociability);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.level = nbt.getInt("level");
        this.time = nbt.getInt("time");
        this.currentTime = nbt.getInt("current_time");
        this.capacity = nbt.getInt("capacity");
        this.luck = nbt.getFloat("luck");
        this.intelligence = nbt.getFloat("intelligence");
        this.insight = nbt.getFloat("insight");
        this.sociability = nbt.getFloat("sociability");
    }
}
