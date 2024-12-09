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
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.recipe.FukamizuCrushingRecipe;

import javax.annotation.ParametersAreNonnullByDefault;
import java.text.DecimalFormat;

public class FukamizuCrusherCategory implements IRecipeCategory<FukamizuCrushingRecipe> {

    public static final ResourceLocation TEXTURE = Utils.loc("textures/gui/fukamizu_crusher_jei.png");

    public static final RecipeType<FukamizuCrushingRecipe> TYPE = new RecipeType<>(Utils.loc("fukamizu_crusher"),
            FukamizuCrushingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated progress;
    private final IDrawable chanceIcon;
    private final IDrawable empty;

    public FukamizuCrusherCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 160, 51)
                .setTextureSize(192, 64)
                .build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.FUKAMIZU_CRUSHER.get()));
        this.progress = helper.drawableBuilder(TEXTURE, 161, 0, 9, 21)
                .setTextureSize(192, 64)
                .buildAnimated(100, IDrawableAnimated.StartDirection.TOP, false);
        this.chanceIcon = helper.drawableBuilder(TEXTURE, 0, 52, 4, 4)
                .setTextureSize(192, 64)
                .build();
        this.empty = helper.drawableBuilder(TEXTURE, 0, 0, 0, 0)
                .setTextureSize(192, 64)
                .build();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void draw(FukamizuCrushingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        progress.draw(guiGraphics, 41, 9);
    }

    @Override
    public @NotNull RecipeType<FukamizuCrushingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.dreamaticvoyage.fukamizu_crusher");
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
    public void setRecipe(IRecipeLayoutBuilder builder, FukamizuCrushingRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 13, 10).addIngredients(recipe.input);

        var results = recipe.getResults();
        for (int i = 0; i < results.size() && i < 5; i++) {
            var result = results.get(i);
            builder.addSlot(RecipeIngredientRole.OUTPUT, 64 + i * 18, 10).addItemStack(result.stack())
                    .setOverlay(result.chance() == 1 ? empty : chanceIcon, 11, 1)
                    .addTooltipCallback((tooltipContext, tooltip) -> {
                        if (result.chance() != 1) {
                            tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability")
                                    .append(Component.literal(new DecimalFormat("##.#").format(result.chance() * 100) + "%").withStyle(ChatFormatting.GOLD)));
                        }
                    });
        }
        if (results.size() < 5) return;
        for (int i = 5; i < results.size() && i < 10; i++) {
            var result = results.get(i);
            builder.addSlot(RecipeIngredientRole.OUTPUT, 64 + i * 18, 28).addItemStack(result.stack())
                    .setOverlay(result.chance() == 1 ? empty : chanceIcon, 11, 1)
                    .addTooltipCallback((tooltipContext, tooltip) -> {
                        if (result.chance() != 1) {
                            tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability")
                                    .append(Component.literal(new DecimalFormat("##.#").format(result.chance() * 100) + "%").withStyle(ChatFormatting.GOLD)));
                        }
                    });
        }
    }

}
