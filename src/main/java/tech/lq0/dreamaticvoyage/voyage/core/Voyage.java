package tech.lq0.dreamaticvoyage.voyage.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootDataManager;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;
import java.util.Random;

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
    // 是否完成
    public boolean finished;
    // 暂时的物品
    public NonNullList<ItemStack> items = NonNullList.withSize(capacity, ItemStack.EMPTY);

    public List<ItemStack> generateDrop(ServerLevel level, BlockPos pos, VoyageEvent event, boolean isSuccess) {
        LootDataManager manager = level.getServer().getLootData();

        LootTable lootTable;
        if (isSuccess) {
            lootTable = manager.getLootTable(event.successLoot);
        } else {
            lootTable = manager.getLootTable(event.failLoot);
        }

        return lootTable.getRandomItems(new LootParams.Builder(level)
                .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withLuck(luck).create(LootContextParamSets.CHEST));
    }

    public List<ItemStack> generateDrop(ServerLevel level, BlockPos pos, VoyageEvent event) {
        return this.generateDrop(level, pos, event, this.successConditionMatch(event));
    }

    public boolean appearConditionMatch(VoyageEvent event) {
        var luck = event.appearCondition[0];
        var intelligence = event.appearCondition[1];
        var insight = event.appearCondition[2];
        var sociability = event.appearCondition[3];

        return this.luck >= luck && this.intelligence >= intelligence && this.insight >= insight && this.sociability >= sociability;
    }

    public boolean successConditionMatch(VoyageEvent event) {
        var luck = event.successCondition[0];
        var intelligence = event.successCondition[1];
        var insight = event.successCondition[2];
        var sociability = event.successCondition[3];

        return this.luck >= luck && this.intelligence >= intelligence && this.insight >= insight && this.sociability >= sociability;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();

        nbt.putInt("Level", this.level);
        nbt.putInt("Time", this.time);
        nbt.putInt("CurrentTime", this.currentTime);
        nbt.putInt("Capacity", this.capacity);
        nbt.putFloat("Luck", this.luck);
        nbt.putFloat("Intelligence", this.intelligence);
        nbt.putFloat("Insight", this.insight);
        nbt.putFloat("Sociability", this.sociability);
        nbt.putBoolean("Finished", this.finished);
        ContainerHelper.saveAllItems(nbt, this.items);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.level = nbt.getInt("Level");
        this.time = nbt.getInt("Time");
        this.currentTime = nbt.getInt("CurrentTime");
        this.capacity = nbt.getInt("Capacity");
        this.luck = nbt.getFloat("Luck");
        this.intelligence = nbt.getFloat("Intelligence");
        this.insight = nbt.getFloat("Insight");
        this.sociability = nbt.getFloat("Sociability");
        this.finished = nbt.getBoolean("Finished");
        this.items = NonNullList.withSize(this.capacity, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(nbt, this.items);
    }

    public static Voyage genLevel1Voyage() {
        Voyage voyage = new Voyage();
        voyage.level = 1;
        voyage.capacity = 8;
        voyage.luck = new Random().nextInt(5) / 10.0f;
        voyage.intelligence = new Random().nextInt(5) / 10.0f;
        voyage.insight = new Random().nextInt(5) / 10.0f;
        voyage.sociability = new Random().nextInt(5) / 10.0f;
        voyage.items = NonNullList.withSize(voyage.capacity, ItemStack.EMPTY);
        return voyage;
    }
}
