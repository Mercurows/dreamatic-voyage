package tech.lq0.dreamaticvoyage.item.misc.guardian;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.render.tooltip.ImageTooltip;

import java.util.Optional;

public class DGHurric extends DreamGuardian {

    public static final ResourceLocation IMAGE = new ResourceLocation(Utils.MOD_ID, "textures/character/hurric_default.png");

    public DGHurric() {
        super("hurric");
    }

    @Override
    public @NotNull Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack pStack) {
        return Optional.of(new ImageTooltip(64, 64, IMAGE));
    }

    @Override
    public ResourceLocation getDgTexture() {
        return IMAGE;
    }
}
