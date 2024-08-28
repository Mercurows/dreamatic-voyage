package tech.lq0.dreamaticvoyage.voyage.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootDataManager;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.INBTSerializable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.VoyageEventRegistry;

import java.util.List;

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

    public boolean generateDrop(ServerLevel level, BlockPos pos) {
        LootDataManager manager = level.getServer().getLootData();

        var availableEvents = VoyageEventRegistry.EVENTS.getEntries().stream().filter(r -> appearConditionMatch(r.get())).toList();
        if (availableEvents.isEmpty()) return false;

        VoyageEvent randomEvent = availableEvents.get((int) (Math.random() * availableEvents.size())).get();

        if (this.successConditionMatch(randomEvent)) {
            // TODO 正确实现战利品生成
            LootTable successTable = manager.getLootTable(randomEvent.successLoot);
            List<ItemStack> itemList = successTable.getRandomItems(new LootParams.Builder(level)
                    .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).create(LootContextParamSets.CHEST));
            itemList.forEach(stack -> {
                ItemEntity itementity = new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(), stack.copy());
                itementity.setDefaultPickUpDelay();
                level.addFreshEntity(itementity);
            });

            System.out.println(Component.translatable("voyage." + Utils.MOD_ID + "." + randomEvent.descriptionId + ".name").getString());
            System.out.println(Component.translatable("voyage." + Utils.MOD_ID + "." + randomEvent.descriptionId + ".des").getString());

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

        return this.luck >= luck && this.intelligence >= intelligence && this.insight >= insight && this.sociability >= sociability;
    }

    private boolean successConditionMatch(VoyageEvent event) {
        var luck = event.successCondition[0];
        var intelligence = event.successCondition[1];
        var insight = event.successCondition[2];
        var sociability = event.successCondition[3];

        return this.luck >= luck && this.intelligence >= intelligence && this.insight >= insight && this.sociability >= sociability;
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
