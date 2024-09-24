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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

public class CrystalPopperCategory implements IRecipeCategory<Object> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/crystal_popper.png");

    public static final RecipeType<Object> TYPE = new RecipeType<>(new ResourceLocation(Utils.MOD_ID, "crystal_popper"),
            Object.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated popper;
    private final IDrawableAnimated energy;

    public CrystalPopperCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 41, 16, 94, 62)
                .setTextureSize(256, 256)
                .build();

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.CRYSTAL_POPPER.get()));

        this.popper = helper.drawableBuilder(TEXTURE, 183, 0, 16, 38)
                .setTextureSize(256, 256)
                .buildAnimated(100, IDrawableAnimated.StartDirection.TOP, false);

        this.energy = helper.drawableBuilder(TEXTURE, 177, 0, 6, 58)
                .setTextureSize(256, 256)
                .buildAnimated(800, IDrawableAnimated.StartDirection.BOTTOM, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void draw(Object recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        popper.draw(guiGraphics, 25, 8);
        energy.draw(guiGraphics, 44, 2);
    }

    @Override
    public @NotNull RecipeType<Object> getRecipeType() {
        return TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.dreamaticvoyage.crystal_popper");
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
    public void setRecipe(IRecipeLayoutBuilder builder, Object recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 3, 10).addIngredients(Ingredient.of(Items.GOLD_INGOT));

        // TODO 修改tooltip显示效果

        builder.addSlot(RecipeIngredientRole.OUTPUT, 75, 3)
                .addItemStack(ItemRegistry.PURIFIED_CRYSTAL_POWDER.get().getDefaultInstance())
                .addTooltipCallback((tooltipContext, tooltip) -> {
                    tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability.purified_powder").withStyle(ChatFormatting.BLUE));
                });

        builder.addSlot(RecipeIngredientRole.OUTPUT, 75, 23)
                .addItemStack(ItemRegistry.CRYSTAL_POWDER.get().getDefaultInstance())
                .addTooltipCallback((tooltipContext, tooltip) -> {
                    tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("jei.dreamaticvoyage.crystal_popper.probability.powder").withStyle(ChatFormatting.BLUE));
                });

        builder.addSlot(RecipeIngredientRole.OUTPUT, 75, 43).addItemStack(ItemRegistry.CRYSTAL_POPCORN.get().getDefaultInstance());
    }

}
