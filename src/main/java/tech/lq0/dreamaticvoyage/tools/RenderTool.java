package tech.lq0.dreamaticvoyage.tools;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

public class RenderTool {
    public static void preciseBlit(GuiGraphics gui, ResourceLocation pAtlasLocation, float x, float y, float width, float height, float pBlitOffset, float pUOffset, float pVOffset, float uWidth, float vHeight, float pTextureWidth, float pTextureHeight) {
        float x2 = x + width, y2 = y + height;

        float pMinU = (pUOffset + 0.0F) / pTextureWidth, pMinV = (pVOffset + 0.0F) / pTextureHeight;
        float pMaxU = (pUOffset + uWidth) / pTextureWidth, pMaxV = (pVOffset + vHeight) / pTextureHeight;

        RenderSystem.setShaderTexture(0, pAtlasLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4f = gui.pose().last().pose();
        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, x, y, pBlitOffset).uv(pMinU, pMinV).endVertex();
        bufferbuilder.vertex(matrix4f, x, y2, pBlitOffset).uv(pMinU, pMaxV).endVertex();
        bufferbuilder.vertex(matrix4f, x2, y2, pBlitOffset).uv(pMaxU, pMaxV).endVertex();
        bufferbuilder.vertex(matrix4f, x2, y, pBlitOffset).uv(pMaxU, pMinV).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
    }

    public static void preciseBlit(GuiGraphics gui, ResourceLocation pAtlasLocation, float x, float y, float width, float height, float pUOffset, float pVOffset, float uWidth, float vHeight, float pTextureWidth, float pTextureHeight) {
        preciseBlit(gui, pAtlasLocation, x, y, width, height, 0, pUOffset, pVOffset, uWidth, vHeight, pTextureWidth, pTextureHeight);
    }

    public static void preciseBlit(GuiGraphics gui, ResourceLocation pAtlasLocation, float x, float y, float pUOffset, float pVOffset, float width, float height, float pTextureWidth, float pTextureHeight) {
        preciseBlit(gui, pAtlasLocation, x, y, width, height, 0, pUOffset, pVOffset, width, height, pTextureWidth, pTextureHeight);
    }
}
