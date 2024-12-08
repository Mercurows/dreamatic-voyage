package tech.lq0.dreamaticvoyage.recipe.ingredient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

/**
 * Code Based On @Creators-of-Create 's Create
 */
public record ChanceOutput(ItemStack stack, float chance) {

    public static final ChanceOutput EMPTY = new ChanceOutput(ItemStack.EMPTY, 1);

    private static final Random random = new Random();

    public ItemStack rollOutput() {
        int outputAmount = stack.getCount();
        for (int roll = 0; roll < stack.getCount(); roll++) {
            if (random.nextFloat() > chance) {
                outputAmount--;
            }
        }
        if (outputAmount == 0) {
            return ItemStack.EMPTY;
        }
        ItemStack out = stack.copy();
        out.setCount(outputAmount);
        return out;
    }

    public JsonElement serialize() {
        JsonObject json = new JsonObject();
        ResourceLocation resourceLocation = ForgeRegistries.ITEMS.getKey(stack.getItem());
        if (resourceLocation != null) {
            json.addProperty("item", resourceLocation.toString());
        }
        int count = stack.getCount();
        if (count != 1) {
            json.addProperty("count", count);
        }
        if (stack.hasTag())
            json.add("nbt", JsonParser.parseString(stack.getTag().toString()));
        if (chance != 1) {
            json.addProperty("chance", chance);
        }
        return json;
    }

    public static ChanceOutput deserialize(JsonElement jsonElement) {
        if (!jsonElement.isJsonObject()) {
            throw new JsonSyntaxException("ChanceOutput must be a json object");
        }

        JsonObject json = jsonElement.getAsJsonObject();
        String itemId = GsonHelper.getAsString(json, "item");
        int count = GsonHelper.getAsInt(json, "count", 1);
        float chance = GsonHelper.isValidNode(json, "chance") ? GsonHelper.getAsFloat(json, "chance") : 1;
        var item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemId));
        if (item == null) {
            throw new JsonSyntaxException("Invalid item ID: " + itemId);
        }
        ItemStack itemstack = new ItemStack(item, count);

        if (GsonHelper.isValidNode(json, "nbt")) {
            try {
                JsonElement element = json.get("nbt");
                itemstack.setTag(TagParser.parseTag(GsonHelper.convertToString(element, "nbt")));
            } catch (CommandSyntaxException ignored) {
            }
        }

        return new ChanceOutput(itemstack, chance);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeItem(this.stack);
        buf.writeFloat(this.chance);
    }

    public static ChanceOutput decode(FriendlyByteBuf buf) {
        return new ChanceOutput(buf.readItem(), buf.readFloat());
    }
}
