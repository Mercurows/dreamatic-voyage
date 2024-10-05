package tech.lq0.dreamaticvoyage.gui.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.gui.menu.CrystalPurifierMenu;

@OnlyIn(Dist.CLIENT)
public class CrystalPurifierScreen extends AbstractContainerScreen<CrystalPurifierMenu> {

    private static final ResourceLocation TEXTURE = Utils.loc("textures/gui/crystal_purifier.png");

    public CrystalPurifierScreen(CrystalPurifierMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 176;
        imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);

        int energy = this.menu.getEnergy();
        int maxEnergy = this.menu.getMaxEnergy();
        if (maxEnergy == 0) {
            maxEnergy = 300;
        }

        int height = (int) (15 * (1 - (float) energy / maxEnergy));
        pGuiGraphics.blit(TEXTURE, i + 89, j + 23 + height, 177, height,
                11, 15, 256, 256);

        int progress = this.menu.getOutputProgress();
        int time = this.menu.getOutputTime();
        if (time == 0) {
            time = 300;
        }

        pGuiGraphics.blit(TEXTURE, i + 81, j + 35, 189, 0,
                (int) (Mth.clamp((float) progress / (float) time, 0f, 1f) * 32.0f), 16, 256, 256);
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
        this.titleLabelY = 5;
        this.inventoryLabelX = 8;
        this.inventoryLabelY = 74;
    }
}
