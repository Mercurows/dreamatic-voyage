package tech.lq0.dreamaticvoyage.voyage.core;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import tech.lq0.dreamaticvoyage.Utils;

public class VoyageEvent {
    // 注册名
    public final String descriptionId;
    // 类型
    public final Type type;
    // 事件成功的战利品表
    public final ResourceLocation successLoot;
    // 事件失败的战利品表
    public final ResourceLocation failLoot;
    // 事件成功的属性要求
    public final float[] successCondition;
    // 事件出现的属性要求
    public final float[] appearCondition;
    // 事件成功时的属性加成
    public final float[] successAttributeBonus;
    // 事件失败时的属性加成
    public final float[] failAttributeBonus;
    // 结果类型
    public final ResultType resultType;
    // 是否为隐藏事件
    public final boolean hidden;
    // 事件的等级
    public final int level;

    public VoyageEvent(String descriptionId, Type type, ResourceLocation successLoot, ResourceLocation failLoot, float[] successCondition, float[] appearCondition,
                       float[] successAttributeBonus, float[] failAttributeBonus, ResultType resultType, boolean hidden, int level) {
        this.descriptionId = descriptionId;
        this.type = type;
        this.successLoot = successLoot;
        this.failLoot = failLoot;
        this.successCondition = successCondition;
        this.appearCondition = appearCondition;
        this.successAttributeBonus = successAttributeBonus;
        this.failAttributeBonus = failAttributeBonus;
        this.resultType = resultType;
        this.hidden = hidden;
        this.level = level;
    }

    public VoyageEvent(String descriptionId, Type type, float[] successCondition, float[] appearCondition, float[] successAttributeBonus, float[] failAttributeBonus,
                       ResultType resultType, boolean hidden, int level) {
        this(descriptionId, type, new ResourceLocation(Utils.MOD_ID, "voyage/" + type.name + "/" + descriptionId + "_success"),
                new ResourceLocation(Utils.MOD_ID, "voyage/" + type.name + "/" + descriptionId + "_fail"), successCondition, appearCondition, successAttributeBonus, failAttributeBonus, resultType, hidden, level);
    }

    public VoyageEvent(String descriptionId, Type type, float[] successCondition, float[] appearCondition, ResultType resultType, boolean hidden, int level) {
        this(descriptionId, type, new ResourceLocation(Utils.MOD_ID, "voyage/" + type.name + "/" + descriptionId + "_success"),
                new ResourceLocation(Utils.MOD_ID, "voyage/" + type.name + "/" + descriptionId + "_fail"), successCondition, appearCondition,
                new float[]{0.0f, 0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 0.0f}, resultType, hidden, level);
    }

    public enum Type {
        BENEFICIAL("beneficial"),
        NEUTRAL("neutral"),
        HARMFUL("harmful");

        public final String name;

        Type(String name) {
            this.name = name;
        }
    }

    public enum ResultType {
        CONTINUE,
        BREAK,
    }

    public Component getDisplayName() {
        return Component.translatable("voyage." + Utils.MOD_ID + "." + this.descriptionId + ".name");
    }

    public Component getDescription() {
        return Component.translatable("voyage." + Utils.MOD_ID + "." + this.descriptionId + ".des");
    }

    public Component getSuccessMessage() {
        return Component.translatable("voyage." + Utils.MOD_ID + "." + this.descriptionId + ".des.success");
    }

    public Component getFailMessage() {
        return Component.translatable("voyage." + Utils.MOD_ID + "." + this.descriptionId + ".des.fail");
    }

}
