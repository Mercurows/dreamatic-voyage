package tech.lq0.dreamaticvoyage.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.PointsStoreBlockEntity;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.Arrays;

@JeiPlugin
public class DmvJEIPlugin implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PointsStoreCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ItemRegistry.POINTS_STORE.get()), PointsStoreCategory.TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // 积分商店配方
        var pointsStoreRecipes = Arrays.asList(PointsStoreBlockEntity.offers);
        registration.addRecipes(PointsStoreCategory.TYPE, pointsStoreRecipes);

        // 其他物品获取方式描述
        registration.addItemStackInfo(new ItemStack(ItemRegistry.MUSIC_DISC_AROUND_THE_TRAVEL.get()), Component.translatable("jei.dreamaticvoyage.around_the_travel"));
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(Utils.MOD_ID, "jei_plugin");
    }
}
