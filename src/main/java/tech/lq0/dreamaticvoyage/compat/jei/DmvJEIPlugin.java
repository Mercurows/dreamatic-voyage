package tech.lq0.dreamaticvoyage.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

@JeiPlugin
public class DmvJEIPlugin implements IModPlugin {
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addItemStackInfo(new ItemStack(ItemRegistry.MUSIC_DISC_AROUND_THE_TRAVEL.get()), Component.translatable("jei.dreamaticvoyage.around_the_travel"));
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(Utils.MOD_ID, "jei_plugin");
    }
}
