package tech.lq0.dreamaticvoyage.gui.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.gui.menu.PhantasmalVoyagerMenu;

public class PhantasmalVoyagerScreen extends AbstractContainerScreen<PhantasmalVoyagerMenu> {

    // TODO 这什么b背景
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/phantasmal_voyager.png");

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    public PhantasmalVoyagerScreen(PhantasmalVoyagerMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        imageWidth = 392;
        imageHeight = 232;
    }

    // TODO 其他物品渲染
    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
    }
}
