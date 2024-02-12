package tech.lq0.providencraft.client.render.special;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.awt.*;

public class SpecialRenderer {

    public static void renderLandmark(PoseStack matrix, float x, float y, float z, Color color) {
        var buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        var builder = buffer.getBuffer(CustomRenderType.Landmark);

        Vec3 view = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();

        matrix.pushPose();
        matrix.translate(-view.x, -view.y, -view.z);

        matrix.pushPose();
        matrix.translate(x, 0, z);
        matrix.translate(-0.005f, -0.005f, -0.005f);
        matrix.scale(1.01f, 1.01f, 1.01f);
        matrix.mulPose(Axis.YP.rotationDegrees(-90.0F));

        Matrix4f m4f = matrix.last().pose();
        float red = color.getRed() / 255f, green = color.getGreen() / 255f, blue = color.getBlue() / 255f, alpha = .5f;
        float startX = 0, startY = -1000, startZ = -1, endX = 1, endY = 1000, endZ = 0;

        //east
        builder.vertex(m4f, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, startX, endY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, endX, startY, startZ).color(red, green, blue, alpha).endVertex();

        //west
        builder.vertex(m4f, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, endX, startY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, startX, endY, endZ).color(red, green, blue, alpha).endVertex();

        //south
        builder.vertex(m4f, endX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, endX, startY, endZ).color(red, green, blue, alpha).endVertex();

        //north
        builder.vertex(m4f, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, startX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(m4f, startX, endY, startZ).color(red, green, blue, alpha).endVertex();

        matrix.popPose();

        matrix.popPose();
        RenderSystem.disableDepthTest();
        buffer.endBatch(CustomRenderType.Landmark);
    }

    public static void renderBlock(Matrix4f matrix, VertexConsumer builder, Color color) {
        float red = color.getRed() / 255f, green = color.getGreen() / 255f, blue = color.getBlue() / 255f, alpha = .5f;

        float startX = 0, startY = 0, startZ = -1, endX = 1, endY = 1, endZ = 0;

        //down
        builder.vertex(matrix, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, startY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, startX, startY, endZ).color(red, green, blue, alpha).endVertex();

        //up
        builder.vertex(matrix, startX, endY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, startX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, endY, startZ).color(red, green, blue, alpha).endVertex();

        //east
        builder.vertex(matrix, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, startX, endY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, startY, startZ).color(red, green, blue, alpha).endVertex();

        //west
        builder.vertex(matrix, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, startY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, startX, endY, endZ).color(red, green, blue, alpha).endVertex();

        //south
        builder.vertex(matrix, endX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, endX, startY, endZ).color(red, green, blue, alpha).endVertex();

        //north
        builder.vertex(matrix, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, startX, endY, endZ).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix, startX, endY, startZ).color(red, green, blue, alpha).endVertex();
    }
}

