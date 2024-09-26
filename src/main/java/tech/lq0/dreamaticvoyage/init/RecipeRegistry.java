package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.recipe.CrystalPurifyingRecipe;
import tech.lq0.dreamaticvoyage.recipe.FukamizuCompressingRecipe;

public class RecipeRegistry {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Utils.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FukamizuCompressingRecipe>> FUKAMIZU_COMPRESSING_SERIALIZER =
            RECIPE_SERIALIZERS.register("fukamizu_compressing", () -> FukamizuCompressingRecipe.Serializer.INSTANCE);

//    public static final RegistryObject<RecipeSerializer<FukamizuCrushingRecipe>> FUKAMIZU_CRUSHING_SERIALIZER =
//            RECIPE_SERIALIZERS.register("fukamizu_crushing", () -> FukamizuCrushingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CrystalPurifyingRecipe>> CRYSTAL_PURIFYING_SERIALIZER =
            RECIPE_SERIALIZERS.register("crystal_purifying", () -> CrystalPurifyingRecipe.Serializer.INSTANCE);

}
