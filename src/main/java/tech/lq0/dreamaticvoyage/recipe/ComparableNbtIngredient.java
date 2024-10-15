package tech.lq0.dreamaticvoyage.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.AbstractIngredient;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IIngredientSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ComparableNbtIngredient extends AbstractIngredient {

    private final ItemStack stack;
    private boolean lesserThan = false;

    public ComparableNbtIngredient(ItemStack stack) {
        super(Stream.of(new Ingredient.ItemValue(stack)));
        this.stack = stack;
    }

    public ComparableNbtIngredient(ItemStack stack, boolean lesserThan) {
        super(Stream.of(new Ingredient.ItemValue(stack)));
        this.stack = stack;
        this.lesserThan = lesserThan;
    }

    public static ComparableNbtIngredient of(ItemStack stack) {
        return new ComparableNbtIngredient(stack);
    }

    public static ComparableNbtIngredient of(ItemStack stack, boolean lesserThan) {
        return new ComparableNbtIngredient(stack, lesserThan);
    }

    @Override
    public boolean test(@Nullable ItemStack pStack) {
        if (pStack == null) return false;

        return this.stack.getItem() == pStack.getItem() && this.stack.getDamageValue() == pStack.getDamageValue() && compareTags(this.stack, pStack);
    }

    private boolean compareTags(ItemStack stack, ItemStack input) {
        CompoundTag shareTagA = stack.getShareTag();
        CompoundTag shareTagB = input.getShareTag();
        if (shareTagA == null) {
            return shareTagB == null;
        }

        if (shareTagB != null) {
            for (var tag : shareTagA.getAllKeys()) {
                if (shareTagA.getTagType(tag) >= Tag.TAG_BYTE && shareTagA.getTagType(tag) <= Tag.TAG_DOUBLE) {
                    try {
                        double valueA = getNumericValue(shareTagA, tag);
                        double valueB = getNumericValue(shareTagB, tag);
                        if (valueB < valueA && !lesserThan) {
                            return false;
                        }
                    } catch (RuntimeException e) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private double getNumericValue(CompoundTag tag, String key) throws RuntimeException {
        return switch (tag.getTagType(key)) {
            case Tag.TAG_BYTE -> tag.getByte(key);
            case Tag.TAG_SHORT -> tag.getShort(key);
            case Tag.TAG_INT -> tag.getInt(key);
            case Tag.TAG_LONG -> tag.getLong(key);
            case Tag.TAG_FLOAT -> tag.getFloat(key);
            case Tag.TAG_DOUBLE -> tag.getDouble(key);
            default -> throw new RuntimeException("Unsupported numeric type");
        };
    }

    @Override
    public boolean isSimple() {
        return false;
    }

    @Override
    public IIngredientSerializer<? extends Ingredient> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public JsonElement toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("type", CraftingHelper.getID(Serializer.INSTANCE).toString());
        json.addProperty("item", ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
        json.addProperty("count", stack.getCount());
        json.addProperty("lesserThan", lesserThan);
        if (stack.hasTag())
            json.addProperty("nbt", stack.getTag().toString());
        return json;
    }

    public static class Serializer implements IIngredientSerializer<ComparableNbtIngredient> {
        public static final ComparableNbtIngredient.Serializer INSTANCE = new ComparableNbtIngredient.Serializer();

        @Override
        public ComparableNbtIngredient parse(FriendlyByteBuf buffer) {
            return new ComparableNbtIngredient(buffer.readItem(), buffer.readBoolean());
        }

        @Override
        public ComparableNbtIngredient parse(JsonObject json) {
            return new ComparableNbtIngredient(CraftingHelper.getItemStack(json, true), json.get("lesserThan").getAsBoolean());
        }

        @Override
        public void write(FriendlyByteBuf buffer, ComparableNbtIngredient ingredient) {
            buffer.writeItem(ingredient.stack);
            buffer.writeBoolean(ingredient.lesserThan);
        }
    }
}
