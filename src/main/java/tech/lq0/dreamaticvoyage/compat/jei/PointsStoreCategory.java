package tech.lq0.dreamaticvoyage.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

public class PointsStoreCategory implements IRecipeCategory<MerchantOffer> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/gui/container/villager2.png");

    public static final RecipeType<MerchantOffer> TYPE = RecipeType.create(Utils.MOD_ID, "points_store", MerchantOffer.class);
    private final IDrawable background;
    private final IDrawable icon;

    public PointsStoreCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 127, 28, 119, 36)
                .setTextureSize(512, 256)
                .build();

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.POINTS_STORE.get()));
    }

    @Override
    public @NotNull RecipeType<MerchantOffer> getRecipeType() {
        return TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.dreamaticvoyage.points_store");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return icon;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRecipe(IRecipeLayoutBuilder builder, MerchantOffer recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 9).addIngredients(Ingredient.of(recipe.getCostA()));
        builder.addSlot(RecipeIngredientRole.INPUT, 35, 9).addIngredients(Ingredient.of(recipe.getCostB()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 93, 10).addIngredients(Ingredient.of(recipe.getResult()));
    }
}
