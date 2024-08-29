package tech.lq0.dreamaticvoyage.voyage.core;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import tech.lq0.dreamaticvoyage.Utils;

public class VoyageEvent {

    public final String descriptionId;

    public final Type type;

    public final ResourceLocation successLoot;

    public final ResourceLocation failLoot;

    public final float[] successCondition;

    public final float[] appearCondition;

    public final ResultType resultType;

    public final boolean hidden;

    public final int level;

    public VoyageEvent(String descriptionId, Type type, ResourceLocation successLoot, ResourceLocation failLoot, float[] successCondition, float[] appearCondition, ResultType resultType, boolean hidden, int level) {
        this.descriptionId = descriptionId;
        this.type = type;
        this.successLoot = successLoot;
        this.failLoot = failLoot;
        this.successCondition = successCondition;
        this.appearCondition = appearCondition;
        this.resultType = resultType;
        this.hidden = hidden;
        this.level = level;
    }

    public VoyageEvent(String descriptionId, Type type, float[] successCondition, float[] appearCondition, ResultType resultType, boolean hidden, int level) {
        this(descriptionId, type, new ResourceLocation(Utils.MOD_ID, "voyage/" + type.name + "/" + descriptionId + "_success"),
                new ResourceLocation(Utils.MOD_ID, "voyage/" + type.name + "/" + descriptionId + "_fail"), successCondition, appearCondition, resultType, hidden, level);
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
