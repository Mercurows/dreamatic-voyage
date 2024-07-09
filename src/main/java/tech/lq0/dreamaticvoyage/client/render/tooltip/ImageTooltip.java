package tech.lq0.dreamaticvoyage.client.render.tooltip;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

public record ImageTooltip(int width, int height, ResourceLocation image) implements TooltipComponent {
}
