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

public class CrystalCuttingRecipe implements Recipe<SimpleContainer> {

    private final Ingredient input;
    private final ItemStack output;
    private final double outputChance;
    private final ItemStack extraOutput;
    private final double extraChance;
    private final ResourceLocation id;

    public CrystalCuttingRecipe(Ingredient input, ItemStack output, double outputChance, ItemStack extraOutput, double extraChance, ResourceLocation id) {
        this.input = input;
        this.output = output;
        this.outputChance = outputChance;
        this.extraOutput = extraOutput;
        this.extraChance = extraChance;
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
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CrystalCuttingRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return CrystalCuttingRecipe.Type.INSTANCE;
    }

    public double getOutputChance() {
        return outputChance;
    }

    public double getExtraChance() {
        return extraChance;
    }

    public ItemStack getExtraOutput() {
        return extraOutput;
    }

    public static class Type implements RecipeType<CrystalCuttingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "crystal_cutting";
    }

    public static class Serializer implements RecipeSerializer<CrystalCuttingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = Utils.loc("crystal_cutting");

        @Override
        public CrystalCuttingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
            var extra = GsonHelper.getAsJsonObject(pSerializedRecipe, "extra_output", null);
            ItemStack extraOutput = ItemStack.EMPTY;
            if (extra != null) {
                extraOutput = ShapedRecipe.itemStackFromJson(extra);
            }
            double outputChance = GsonHelper.getAsDouble(pSerializedRecipe, "output_chance", 1.0);
            double extraChance = GsonHelper.getAsDouble(pSerializedRecipe, "extra_chance", 0.0);
            var ingredient = GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient");
            var input = Ingredient.fromJson(ingredient);

            return new CrystalCuttingRecipe(input, output, outputChance, extraOutput, extraChance, pRecipeId);
        }

        @Override
        public @Nullable CrystalCuttingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            ItemStack output = pBuffer.readItem();
            double outputChance = pBuffer.readDouble();
            ItemStack extraOutput = pBuffer.readItem();
            double extraChance = pBuffer.readDouble();

            return new CrystalCuttingRecipe(input, output, outputChance, extraOutput, extraChance, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CrystalCuttingRecipe pRecipe) {
            pRecipe.input.toNetwork(pBuffer);
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
            pBuffer.writeDouble(pRecipe.outputChance);
            pBuffer.writeItemStack(pRecipe.getExtraOutput(), false);
            pBuffer.writeDouble(pRecipe.extraChance);
        }
    }
}
