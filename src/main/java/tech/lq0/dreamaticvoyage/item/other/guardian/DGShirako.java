package tech.lq0.dreamaticvoyage.item.other.guardian;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.render.tooltip.ImageTooltip;
import tech.lq0.dreamaticvoyage.tools.Livers;

import java.util.Optional;

public class DGShirako extends DreamGuardian {

    public static final ResourceLocation IMAGE = new ResourceLocation(Utils.MOD_ID, "textures/character/shirako_default.png");

    public DGShirako() {
        super(Livers.SHIRAKO);
    }

    @Override
    public @NotNull Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack pStack) {
        return Optional.of(new ImageTooltip(64, 64, IMAGE));
    }
}
