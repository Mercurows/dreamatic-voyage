package tech.lq0.dreamaticvoyage.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.PointsStoreBlockEntity;
import tech.lq0.dreamaticvoyage.gui.screen.CrystalPopperScreen;
import tech.lq0.dreamaticvoyage.gui.screen.CrystalPurifierScreen;
import tech.lq0.dreamaticvoyage.gui.screen.FukamizuCompressorScreen;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.recipe.CrystalPurifyingRecipe;
import tech.lq0.dreamaticvoyage.recipe.FukamizuCompressingRecipe;

import java.util.Arrays;
import java.util.List;

@JeiPlugin
public class DmvJEIPlugin implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PointsStoreCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FukamizuCompressorCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CrystalPopperCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CrystalPurifierCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ItemRegistry.POINTS_STORE.get()), PointsStoreCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(ItemRegistry.FUKAMIZU_COMPRESSOR.get()), FukamizuCompressorCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(ItemRegistry.CRYSTAL_POPPER.get()), CrystalPopperCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(ItemRegistry.CRYSTAL_PURIFIER.get()), CrystalPurifierCategory.TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        // 积分商店配方
        var pointsStoreRecipes = Arrays.asList(PointsStoreBlockEntity.offers);
        registration.addRecipes(PointsStoreCategory.TYPE, pointsStoreRecipes);

        // 深水压缩机
        List<FukamizuCompressingRecipe> fukamizuCompressingRecipes = recipeManager.getAllRecipesFor(FukamizuCompressingRecipe.Type.INSTANCE);
        registration.addRecipes(FukamizuCompressorCategory.TYPE, fukamizuCompressingRecipes);

        // 结晶爆米花机
        registration.addRecipes(CrystalPopperCategory.TYPE, List.of(new Object()));

        // 结晶提纯器
        List<CrystalPurifyingRecipe> crystalPurifyingRecipes = recipeManager.getAllRecipesFor(CrystalPurifyingRecipe.Type.INSTANCE);
        registration.addRecipes(CrystalPurifierCategory.TYPE, crystalPurifyingRecipes);

        // 其他物品获取方式描述
        registration.addItemStackInfo(new ItemStack(ItemRegistry.MUSIC_DISC_AROUND_THE_TRAVEL.get()), Component.translatable("jei.dreamaticvoyage.around_the_travel"));
        registration.addItemStackInfo(new ItemStack(ItemRegistry.MUSIC_DISC_SONG_OF_QINGQIU.get()), Component.translatable("jei.dreamaticvoyage.song_of_qingqiu"));
        registration.addItemStackInfo(new ItemStack(ItemRegistry.MUSIC_DISC_SONG_OF_AUTUMN.get()), Component.translatable("jei.dreamaticvoyage.song_of_autumn"));
        registration.addItemStackInfo(new ItemStack(ItemRegistry.ELF_WINGS.get()), Component.translatable("jei.dreamaticvoyage.elf_wings"));
        registration.addItemStackInfo(new ItemStack(ItemRegistry.PAST_SUGAR.get()), Component.translatable("jei.dreamaticvoyage.past_sugar"));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(FukamizuCompressorScreen.class, 73, 43, 27, 16, FukamizuCompressorCategory.TYPE);
        registration.addRecipeClickArea(CrystalPopperScreen.class, 65, 23, 18, 41, CrystalPopperCategory.TYPE);
        registration.addRecipeClickArea(CrystalPurifierScreen.class, 81, 35, 32, 16, CrystalPurifierCategory.TYPE);
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(Utils.MOD_ID, "jei_plugin");
    }
}
