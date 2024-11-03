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
import tech.lq0.dreamaticvoyage.recipe.CrystalCuttingRecipe;

import javax.annotation.ParametersAreNonnullByDefault;
import java.text.DecimalFormat;

public class CrystalCutterCategory implements IRecipeCategory<CrystalCuttingRecipe> {

    public static final ResourceLocation TEXTURE = Utils.loc("textures/gui/crystal_cutter.png");

    public static final RecipeType<CrystalCuttingRecipe> TYPE = new RecipeType<>(Utils.loc("crystal_cutting"), CrystalCuttingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated progress;
    private final IDrawable energy;

    public CrystalCutterCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 8, 16, 160, 58)
                .setTextureSize(256, 256)
                .build();

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.CRYSTAL_CUTTER.get()));

        this.progress = helper.drawableBuilder(TEXTURE, 177, 0, 22, 16)
                .setTextureSize(256, 256)
                .buildAnimated(300, IDrawableAnimated.StartDirection.LEFT, false);

        this.energy = helper.drawableBuilder(TEXTURE, 177, 17, 21, 4)
                .setTextureSize(256, 256)
                .build();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void draw(CrystalCuttingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        progress.draw(guiGraphics, 67, 24);
        energy.draw(guiGraphics, 67, 46);
    }

    @Override
    public @NotNull RecipeType<CrystalCuttingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.dreamaticvoyage.crystal_cutter");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CrystalCuttingRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 38, 23).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 101, 23).addItemStack(recipe.getResultItem(null))
                .addTooltipCallback((tooltipContext, tooltip) -> tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability")
                        .append(Component.literal(new DecimalFormat("##.#").format(recipe.getOutputChance() * 100) + " %").withStyle(ChatFormatting.GOLD))));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 122, 23).addItemStack(recipe.getExtraOutput())
                .addTooltipCallback((tooltipContext, tooltip) -> tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability")
                        .append(Component.literal(new DecimalFormat("##.#").format(recipe.getExtraChance() * 100) + " %").withStyle(ChatFormatting.GOLD))));
    }

}
