package tech.lq0.dreamaticvoyage.gui.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.FukamizuCompressorBlockEntity;
import tech.lq0.dreamaticvoyage.gui.menu.FukamizuCompressorMenu;

@OnlyIn(Dist.CLIENT)
public class FukamizuCompressorScreen extends AbstractContainerScreen<FukamizuCompressorMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/fukamizu_compressor.png");

    public FukamizuCompressorScreen(FukamizuCompressorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 176;
        imageHeight = 177;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);

        int pressure = this.menu.getPressure();
        float pressureY;
        if (pressure < 16) {
            pressureY = 64 - pressure / 15f * 9;
        } else if (pressure <= 24) {
            pressureY = 56 - (pressure - 15) / 8f * 10;
        } else {
            pressureY = Math.max(45 - (pressure - 24) / 8f * 9, 34);
        }

        pGuiGraphics.blit(TEXTURE, i + 28, (int) (j + pressureY), 177, 13, 8, 3);

        float compressingProgress = this.menu.getCompressingProgress();
        pGuiGraphics.blit(TEXTURE, i + 75, j + 45, 177, 0,
                (int) (compressingProgress / FukamizuCompressorBlockEntity.PROCESS_TIME * 23f), 12);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = 8;
        this.titleLabelY = 2;
        this.inventoryLabelX = 8;
        this.inventoryLabelY = 85;
    }
}
