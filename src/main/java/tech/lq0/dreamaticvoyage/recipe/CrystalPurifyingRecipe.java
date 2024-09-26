package tech.lq0.dreamaticvoyage.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import tech.lq0.dreamaticvoyage.Utils;

import javax.annotation.Nullable;

public class CrystalPurifyingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final ItemStack output;
    private final int tick;
    private final ResourceLocation id;

    public CrystalPurifyingRecipe(Ingredient input, ItemStack output, int tick, ResourceLocation id) {
        this.input = input;
        this.output = output;
        this.tick = tick;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        return input.test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.withSize(1, input);
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(@Nullable RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public int getTick() {
        return tick;
    }

    public static class Type implements RecipeType<CrystalPurifyingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "crystal_purifying";
    }

    public static class Serializer implements RecipeSerializer<CrystalPurifyingRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public static final ResourceLocation ID = new ResourceLocation(Utils.MOD_ID, "crystal_purifying");

        @Override
        public CrystalPurifyingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
            var ingredient = GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient");
            var input = Ingredient.fromJson(ingredient);
            int tick = GsonHelper.getAsInt(pSerializedRecipe, "tick", 100);

            return new CrystalPurifyingRecipe(input, output, tick, pRecipeId);
        }

        @Override
        public @Nullable CrystalPurifyingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            ItemStack output = pBuffer.readItem();
            int tick = pBuffer.readInt();

            return new CrystalPurifyingRecipe(input, output, tick, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CrystalPurifyingRecipe pRecipe) {
            pRecipe.input.toNetwork(pBuffer);
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
            pBuffer.writeInt(pRecipe.tick);
        }
    }
}
