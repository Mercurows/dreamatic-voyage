package tech.lq0.dreamaticvoyage.gui.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.gui.menu.PhantasmalVoyagerMenu;
import tech.lq0.dreamaticvoyage.item.misc.guardian.DreamGuardian;
import tech.lq0.dreamaticvoyage.network.DmvNetwork;
import tech.lq0.dreamaticvoyage.network.packet.PhantasmalVoyagerPacket;
import tech.lq0.dreamaticvoyage.tools.RenderTool;

@OnlyIn(Dist.CLIENT)
public class PhantasmalVoyagerScreen extends AbstractContainerScreen<PhantasmalVoyagerMenu> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/phantasmal_voyager.png");

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);

        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;

        var components = menu.getComponents();
        // TODO 实现远航信息渲染
        for (Component component : components) {
            pGuiGraphics.drawString(Minecraft.getInstance().font, component, i, j, 0xFFFFFF);
        }
    }

    public PhantasmalVoyagerScreen(PhantasmalVoyagerMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        imageWidth = 384;
        imageHeight = 240;
    }

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

        int progress = PhantasmalVoyagerScreen.this.menu.getVoyageProgress();
        int maxTime = PhantasmalVoyagerScreen.this.menu.getVoyageMaxTime();

        RenderTool.preciseBlit(pGuiGraphics, TEXTURE, x + 157, y + 19, 102, 168,
                100 * ((float) progress / maxTime), 4, this.imageWidth, this.imageHeight);
        RenderTool.preciseBlit(pGuiGraphics, TEXTURE, x + 154 + 100 * ((float) progress / maxTime), y + 15,
                203, 168, 7, 12, this.imageWidth, this.imageHeight);

    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = 24;
        this.titleLabelY = 46;
        this.inventoryLabelX = 108;
        this.inventoryLabelY = 115;

        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;

        StartButton startButton = new StartButton(i + 222, j + 87);
        EndButton endButton = new EndButton(i + 244, j + 87);

        this.addRenderableWidget(startButton);
        this.addRenderableWidget(endButton);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    @OnlyIn(Dist.CLIENT)
    class StartButton extends AbstractButton {

        public StartButton(int pX, int pY) {
            super(pX, pY, 21, 15, Component.translatable("button.dreamaticvoyage.start_voyage"));
        }

        @Override
        protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
            pGuiGraphics.blit(TEXTURE, this.getX(), this.getY(), this.isHovered() ? 58 : 14, 168, 21, 15, 384, 240);
        }

        @Override
        public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
            super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        }

        @Override
        public void onPress() {
            DmvNetwork.CHANNEL.sendToServer(new PhantasmalVoyagerPacket(1));
        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    @OnlyIn(Dist.CLIENT)
    class EndButton extends AbstractButton {

        public EndButton(int pX, int pY) {
            super(pX, pY, 21, 15, Component.translatable("button.dreamaticvoyage.end_voyage"));
        }

        @Override
        protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
            pGuiGraphics.blit(TEXTURE, this.getX(), this.getY(), this.isHovered() ? 80 : 36, 168, 21, 15, 384, 240);
        }

        @Override
        public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
            super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        }

        @Override
        public void onPress() {
            DmvNetwork.CHANNEL.sendToServer(new PhantasmalVoyagerPacket(-1));
        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

        }
    }
}
