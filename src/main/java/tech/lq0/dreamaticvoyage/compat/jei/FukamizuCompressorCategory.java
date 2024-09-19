package tech.lq0.dreamaticvoyage.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.recipe.FukamizuCompressingRecipe;

import javax.annotation.ParametersAreNonnullByDefault;

public class FukamizuCompressorCategory implements IRecipeCategory<FukamizuCompressingRecipe> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/fukamizu_compressor.png");

    public static final RecipeType<FukamizuCompressingRecipe> TYPE = new RecipeType<>(new ResourceLocation(Utils.MOD_ID, "fukamizu_compressor"),
            FukamizuCompressingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated piston;
    private final IDrawable indicator;

    public FukamizuCompressorCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 8, 24, 160, 51)
                .setTextureSize(256, 256)
                .build();

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.FUKAMIZU_COMPRESSOR.get()));
        this.piston = helper.drawableBuilder(TEXTURE, 177, 0, 23, 12)
                .setTextureSize(256, 256)
                .buildAnimated(100, IDrawableAnimated.StartDirection.LEFT, false);
        this.indicator = helper.drawableBuilder(TEXTURE, 177, 13, 8, 3)
                .setTextureSize(256, 256)
                .build();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void draw(FukamizuCompressingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        piston.draw(guiGraphics, 67, 21);

        int diff = (int) (System.currentTimeMillis() % 10000);

        int pressureY;
        if (diff <= 5000) {
            pressureY = 31 - (diff / 417);
        } else {
            pressureY = 20 + ((diff - 5000) / 417);
        }
        indicator.draw(guiGraphics, 20, pressureY);
    }

    @Override
    public @NotNull RecipeType<FukamizuCompressingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.dreamaticvoyage.fukamizu_compressor");
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
    public void setRecipe(IRecipeLayoutBuilder builder, FukamizuCompressingRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 19).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 102, 19).addItemStack(recipe.getResultItem(null));
    }

}
