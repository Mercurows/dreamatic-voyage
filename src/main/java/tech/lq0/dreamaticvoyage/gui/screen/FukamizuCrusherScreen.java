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
import tech.lq0.dreamaticvoyage.block.entity.FukamizuCrusherBlockEntity;
import tech.lq0.dreamaticvoyage.gui.menu.FukamizuCrusherMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class FukamizuCrusherScreen extends AbstractContainerScreen<FukamizuCrusherMenu> {

    private static final ResourceLocation TEXTURE = Utils.loc("textures/gui/fukamizu_crusher.png");

    public FukamizuCrusherScreen(FukamizuCrusherMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 176;
        imageHeight = 177;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);

        long energy = FukamizuCrusherScreen.this.menu.getEnergy();
        long progress = FukamizuCrusherScreen.this.menu.getCrushingProgress();

        // Energy
        float energyRate = Mth.clamp((float) energy / (float) FukamizuCrusherBlockEntity.MAX_ENERGY, 0, 1);
        pGuiGraphics.blit(TEXTURE, i + 27, j + 66 - (int) (31 * energyRate),
                177, 0, 4, (int) (31 * energyRate));

        // Progress
        float progressRate = Mth.clamp((float) progress / (float) FukamizuCrusherBlockEntity.PROCESS_TIME, 0, 1);
        pGuiGraphics.blit(TEXTURE, i + 81, j + 33, 182, 0, 9, (int) (21 * progressRate));
    }

    @Override
    protected void renderTooltip(GuiGraphics pGuiGraphics, int pX, int pY) {
        super.renderTooltip(pGuiGraphics, pX, pY);

        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;

        List<Component> tooltip = new ArrayList<>();
        tooltip.add(Component.translatable("des.dreamaticvoyage.umisu_current_energy",
                FukamizuCrusherScreen.this.menu.getEnergy(), FukamizuCrusherBlockEntity.MAX_ENERGY));

        if ((pX - i) >= 26 && (pX - i) <= 32 && (pY - j) >= 34 && (pY - j) <= 67) {
            pGuiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), pX, pY);
        }
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
