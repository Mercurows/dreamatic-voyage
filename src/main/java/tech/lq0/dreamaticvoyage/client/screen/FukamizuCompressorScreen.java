package tech.lq0.dreamaticvoyage.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.block.menu.FukamizuCompressorMenu;

@OnlyIn(Dist.CLIENT)
public class FukamizuCompressorScreen extends AbstractContainerScreen<FukamizuCompressorMenu> {

    public FukamizuCompressorScreen(FukamizuCompressorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 236;
        imageHeight = 205;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
}
