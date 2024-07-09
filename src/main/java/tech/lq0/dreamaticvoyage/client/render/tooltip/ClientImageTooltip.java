package tech.lq0.dreamaticvoyage.client.render.tooltip;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ClientImageTooltip implements ClientTooltipComponent {
    private final int width;
    private final int height;

    private final ResourceLocation image;

    @Override
    public void renderImage(@NotNull Font font, int x, int y, GuiGraphics guiGraphics) {
        guiGraphics.pose().pushPose();
        guiGraphics.blit(image, x, y, 0, 0, width, height, width, height);
        guiGraphics.pose().popPose();
    }

    public ClientImageTooltip(ImageTooltip tooltip) {
        this.width = tooltip.width();
        this.height = tooltip.height();
        this.image = tooltip.image();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth(@NotNull Font font) {
        return width;
    }
}
