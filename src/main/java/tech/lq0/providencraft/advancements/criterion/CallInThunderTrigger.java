package tech.lq0.providencraft.advancements.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;

public class CallInThunderTrigger extends SimpleCriterionTrigger<CallInThunderTrigger.TriggerInstance> {
    public static final ResourceLocation ID = new ResourceLocation(Utils.MOD_ID, "call_in_thunder");

    @Override
    protected TriggerInstance createInstance(JsonObject pJson, ContextAwarePredicate pPredicate, DeserializationContext pDeserializationContext) {
        return new TriggerInstance(pPredicate, ItemPredicate.fromJson(pJson.get("item")));
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayer pPlayer, ItemStack stack) {
        this.trigger(pPlayer, instance -> instance.matches(stack));
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        @Nullable
        private final ItemPredicate itemPredicate;

        public TriggerInstance(ContextAwarePredicate pPlayer, ItemPredicate predicate) {
            super(CallInThunderTrigger.ID, pPlayer);
            this.itemPredicate = predicate;
        }

        public boolean matches(ItemStack stack) {
            return itemPredicate == null || itemPredicate.matches(stack);
        }

        public JsonObject serializeToJson(SerializationContext pConditions) {
            JsonObject jsonobject = super.serializeToJson(pConditions);
            if (itemPredicate != null) {
                jsonobject.addProperty("item", this.itemPredicate.serializeToJson().toString());
            }

            return jsonobject;
        }
    }
}
