package tech.lq0.dreamaticvoyage.gui.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.CrystalPopperBlockEntity;
import tech.lq0.dreamaticvoyage.gui.menu.CrystalPopperMenu;

@OnlyIn(Dist.CLIENT)
public class CrystalPopperScreen extends AbstractContainerScreen<CrystalPopperMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/crystal_popper.png");

    public CrystalPopperScreen(CrystalPopperMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
        float height = (float) energy / CrystalPopperBlockEntity.MAX_ENERGY * 58;
        pGuiGraphics.blit(TEXTURE, i + 85, j + 76 - (int) height, 6, (int) height,
                177, 58 - (int) height, 6, (int) height, 256, 256);

        float inputProgress = this.menu.getInputProgress();
        pGuiGraphics.blit(TEXTURE, i + 67, j + 25, 184, 0, 14,
                (int) (inputProgress / CrystalPopperBlockEntity.INPUT_PROCESS_TIME * 37));
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