package tech.lq0.dreamaticvoyage.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.recipe.ingredient.ChanceOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Code Based On @Creators-of-Create 's Create
 */
@SuppressWarnings("ClassCanBeRecord")
public class FukamizuCrushingRecipe implements Recipe<SimpleContainer> {

    public final Ingredient input;
    private final NonNullList<ChanceOutput> results;
    private final ResourceLocation id;

    public FukamizuCrushingRecipe(Ingredient input, NonNullList<ChanceOutput> results, ResourceLocation id) {
        this.input = input;
        this.results = results;
        this.id = id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.input);
        return nonnulllist;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        return input.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.getResultItem(pRegistryAccess);
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.results.isEmpty() ? ItemStack.EMPTY : results.get(0).stack();
    }

    public List<ItemStack> getRollableResultsAsItemStacks() {
        return this.results.stream().map(ChanceOutput::stack).toList();
    }

    public List<ItemStack> rollResults() {
        return rollResults(this.results);
    }

    public List<ItemStack> rollResults(List<ChanceOutput> rollableResults) {
        List<ItemStack> results = new ArrayList<>();
        for (ChanceOutput output : rollableResults) {
            ItemStack stack = output.rollOutput();
            if (!stack.isEmpty()) {
                results.add(stack);
            }
        }
        return results;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public NonNullList<ChanceOutput> getResults() {
        return this.results;
    }

    public static class Type implements RecipeType<FukamizuCrushingRecipe> {

        public static final FukamizuCrushingRecipe.Type INSTANCE = new FukamizuCrushingRecipe.Type();
        public static final String ID = "fukamizu_crushing";
    }

    public static class Serializer implements RecipeSerializer<FukamizuCrushingRecipe> {

        public static final FukamizuCrushingRecipe.Serializer INSTANCE = new FukamizuCrushingRecipe.Serializer();
        public static final ResourceLocation ID = Utils.loc("fukamizu_crushing");

        @Override
        public FukamizuCrushingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            JsonElement ingredient = GsonHelper.isArrayNode(pSerializedRecipe, "input") ?
                    GsonHelper.getAsJsonArray(pSerializedRecipe, "input") : GsonHelper.getAsJsonObject(pSerializedRecipe, "input");
            var input = Ingredient.fromJson(ingredient);

            NonNullList<ChanceOutput> results = NonNullList.create();
            for (JsonElement jsonElement : GsonHelper.getAsJsonArray(pSerializedRecipe, "results")) {
                results.add(ChanceOutput.deserialize(jsonElement));
            }

            return new FukamizuCrushingRecipe(input, results, pRecipeId);
        }

        @Override
        public @Nullable FukamizuCrushingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            NonNullList<ChanceOutput> results = NonNullList.create();
            int size = pBuffer.readVarInt();
            for (int i = 0; i < size; i++) {
                results.add(ChanceOutput.decode(pBuffer));
            }

            return new FukamizuCrushingRecipe(input, results, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, FukamizuCrushingRecipe pRecipe) {
            pRecipe.input.toNetwork(pBuffer);
            pBuffer.writeVarInt(pRecipe.results.size());
            pRecipe.results.forEach((output) -> output.encode(pBuffer));
        }
    }
}
