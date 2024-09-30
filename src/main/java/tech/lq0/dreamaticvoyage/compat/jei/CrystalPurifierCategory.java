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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.recipe.CrystalPurifyingRecipe;

import javax.annotation.ParametersAreNonnullByDefault;
import java.text.DecimalFormat;

public class CrystalPurifierCategory implements IRecipeCategory<CrystalPurifyingRecipe> {
    public static final ResourceLocation TEXTURE = Utils.loc("textures/gui/crystal_purifier.png");

    public static final RecipeType<CrystalPurifyingRecipe> TYPE = new RecipeType<>(Utils.loc("crystal_purifier"), CrystalPurifyingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated energy;
    private final IDrawableAnimated progress;

    public CrystalPurifierCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 8, 16, 160, 51)
                .setTextureSize(256, 256)
                .build();

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.CRYSTAL_PURIFIER.get()));
        this.energy = helper.drawableBuilder(TEXTURE, 177, 0, 11, 15)
                .setTextureSize(256, 256)
                .buildAnimated(50, IDrawableAnimated.StartDirection.TOP, false);
        this.progress = helper.drawableBuilder(TEXTURE, 189, 0, 32, 16)
                .setTextureSize(256, 256)
                .buildAnimated(300, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void draw(CrystalPurifyingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        energy.draw(guiGraphics, 81, 11);
        progress.draw(guiGraphics, 73, 23);

        guiGraphics.drawString(Minecraft.getInstance().font,
                Component.translatable("jei.dreamaticvoyage.crystal_purifier.time", new DecimalFormat("##.#").format(recipe.getTick() / 20.0f)),
                44, 0, 5592405, false);
    }

    @Override
    public @NotNull RecipeType<CrystalPurifyingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.dreamaticvoyage.crystal_purifier");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CrystalPurifyingRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 32, 22).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 113, 22).addItemStack(recipe.getResultItem(null));
    }

}
