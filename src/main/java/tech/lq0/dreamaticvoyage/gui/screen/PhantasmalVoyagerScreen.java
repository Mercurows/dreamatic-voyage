package tech.lq0.dreamaticvoyage.gui.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.gui.menu.PhantasmalVoyagerMenu;
import tech.lq0.dreamaticvoyage.item.misc.guardian.DreamGuardian;

public class PhantasmalVoyagerScreen extends AbstractContainerScreen<PhantasmalVoyagerMenu> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/phantasmal_voyager.png");

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    public PhantasmalVoyagerScreen(PhantasmalVoyagerMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        imageWidth = 384;
        imageHeight = 240;
    }

    // TODO 其他物品渲染
    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int x = (this.width - this.imageWidth + 26) / 2;
        int y = (this.height - this.imageHeight + 80) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, 350, 167, this.imageWidth, this.imageHeight);

        ItemStack stack = PhantasmalVoyagerScreen.this.menu.getDreamGuardian();
        if (stack.getItem() instanceof DreamGuardian dreamGuardian) {
            pGuiGraphics.blit(dreamGuardian.getDgTexture(), x + 99, y + 13, 0, 0, 48, 48, 48, 48);
            pGuiGraphics.blit(TEXTURE, x + 145, y + 2, 0, 168, 13, 13, this.imageWidth, this.imageHeight);
        }

    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = 24;
        this.titleLabelY = 46;
        this.inventoryLabelX = 108;
        this.inventoryLabelY = 115;
    }
}
