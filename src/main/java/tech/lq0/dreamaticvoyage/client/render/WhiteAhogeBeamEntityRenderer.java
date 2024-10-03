package tech.lq0.dreamaticvoyage.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.render.special.CustomRenderType;
import tech.lq0.dreamaticvoyage.entity.projectile.WhiteAhogeBeamEntity;

/**
 * Beam render codes based on BeamEntityRenderer on @Thelnfamous1's Dungeon Gears and @Polarice3's Goety-2
 */
@OnlyIn(Dist.CLIENT)
public class WhiteAhogeBeamEntityRenderer extends EntityRenderer<WhiteAhogeBeamEntity> {
    private final static ResourceLocation CORE = Utils.loc("textures/entity/white_ahoge_beam_core.png");
    private final static ResourceLocation MAIN = Utils.loc("textures/entity/white_ahoge_beam_main.png");
    private final static ResourceLocation GLOW = Utils.loc("textures/entity/white_ahoge_beam_glow.png");

    public WhiteAhogeBeamEntityRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    public void render(WhiteAhogeBeamEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        double distance = pEntity.beamTraceDistance(pEntity.maxRaytraceDistance, 1.0f, false);
        float speedModifier = -0.02f;
        drawBeams(distance, pEntity, pPartialTicks, speedModifier, pMatrixStack);
    }

    private static void drawBeams(double distance, WhiteAhogeBeamEntity entity, float ticks, float speedModifier, PoseStack pMatrixStack) {
        long gameTime = entity.level().getGameTime();
        double velocity = gameTime * speedModifier;
        float additiveThickness = (entity.getBeamWidth() * 1.75f) * calculateLaserFlickerModifier(gameTime);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();

        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees((Mth.lerp(ticks, boundDegrees(-entity.getYRot()), boundDegrees(-entity.yRotO)))));
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(ticks, boundDegrees(entity.getXRot()), boundDegrees(entity.xRotO))));

        PoseStack.Pose matrixstack$entry = pMatrixStack.last();
        Matrix3f matrixNormal = matrixstack$entry.normal();
        Matrix4f positionMatrix = matrixstack$entry.pose();
        drawClosingBeam(buffer.getBuffer(CustomRenderType.magicBeam(GLOW)), positionMatrix, matrixNormal, additiveThickness, distance / 10, 0.5, 1, ticks, 0.9f);
        drawBeam(buffer.getBuffer(CustomRenderType.magicBeam(MAIN)), positionMatrix, matrixNormal, entity.getBeamWidth(), distance, velocity, velocity + distance * 1.5, ticks, 0.7f);
        drawBeam(buffer.getBuffer(CustomRenderType.magicBeam(CORE)), positionMatrix, matrixNormal, entity.getBeamWidth() * 0.7f, distance, velocity, velocity + distance * 1.5, ticks, 1f);
        pMatrixStack.popPose();
        buffer.endBatch();
    }

    private static float boundDegrees(float rotation) {
        return (rotation % 360 + 360) % 360;
    }

    private static float calculateLaserFlickerModifier(long gameTime) {
        return 0.9f + 0.1f * Mth.sin(gameTime * 0.99f) * Mth.sin(gameTime * 0.3f) * Mth.sin(gameTime * 0.1f);
    }

    private static void drawBeam(VertexConsumer builder, Matrix4f positionMatrix, Matrix3f matrixNormalIn, float thickness, double distance, double v1, double v2, float ticks, float alpha) {
        Vector3f vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
        matrixNormalIn.transform(vector3f);
        float xMin = -thickness;
        float xMax = thickness;
        float yMin = -thickness - 0.115f;
        float yMax = thickness - 0.115f;
        float zMin = 0;
        float zMax = (float) distance;

        Vector4f vec1 = new Vector4f(xMin, yMin, zMin, 1.0F);
        positionMatrix.transform(vec1);
        Vector4f vec2 = new Vector4f(xMin, yMin, zMax, 1.0F);
        positionMatrix.transform(vec2);
        Vector4f vec3 = new Vector4f(xMin, yMax, zMax, 1.0F);
        positionMatrix.transform(vec3);
        Vector4f vec4 = new Vector4f(xMin, yMax, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);

        vec1 = new Vector4f(xMax, yMin, zMin, 1.0F);
        positionMatrix.transform(vec1);
        vec2 = new Vector4f(xMax, yMin, zMax, 1.0F);
        positionMatrix.transform(vec2);
        vec3 = new Vector4f(xMax, yMax, zMax, 1.0F);
        positionMatrix.transform(vec3);
        vec4 = new Vector4f(xMax, yMax, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);

        vec1 = new Vector4f(xMin, yMax, zMin, 1.0F);
        positionMatrix.transform(vec1);
        vec2 = new Vector4f(xMin, yMax, zMax, 1.0F);
        positionMatrix.transform(vec2);
        vec3 = new Vector4f(xMax, yMax, zMax, 1.0F);
        positionMatrix.transform(vec3);
        vec4 = new Vector4f(xMax, yMax, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);

        vec1 = new Vector4f(xMin, yMin, zMin, 1.0F);
        positionMatrix.transform(vec1);
        vec2 = new Vector4f(xMin, yMin, zMax, 1.0F);
        positionMatrix.transform(vec2);
        vec3 = new Vector4f(xMax, yMin, zMax, 1.0F);
        positionMatrix.transform(vec3);
        vec4 = new Vector4f(xMax, yMin, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);
    }

    private static void drawClosingBeam(VertexConsumer builder, Matrix4f positionMatrix, Matrix3f matrixNormalIn, float thickness, double distance, double v1, double v2, float ticks, float alpha) {
        Vector3f vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
        matrixNormalIn.transform(vector3f);

        float xMin = -thickness;
        float xMax = thickness;
        float yMin = -thickness - 0.115f;
        float yMax = thickness - 0.115f;
        float zMin = 0;
        float zMax = (float) distance;

        Vector4f vec1 = new Vector4f(xMin, yMin, zMin, 1.0F);
        positionMatrix.transform(vec1);
        Vector4f vec2 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec2);
        Vector4f vec3 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec3);
        Vector4f vec4 = new Vector4f(xMin, yMax, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);

        vec1 = new Vector4f(xMax, yMin, zMin, 1.0F);
        positionMatrix.transform(vec1);
        vec2 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec2);
        vec3 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec3);
        vec4 = new Vector4f(xMax, yMax, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);

        vec1 = new Vector4f(xMin, yMax, zMin, 1.0F);
        positionMatrix.transform(vec1);
        vec2 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec2);
        vec3 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec3);
        vec4 = new Vector4f(xMax, yMax, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);

        vec1 = new Vector4f(xMin, yMin, zMin, 1.0F);
        positionMatrix.transform(vec1);
        vec2 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec2);
        vec3 = new Vector4f(0, 0, zMax, 1.0F);
        positionMatrix.transform(vec3);
        vec4 = new Vector4f(xMax, yMin, zMin, 1.0F);
        positionMatrix.transform(vec4);
        drawQuad(builder, (float) v1, (float) v2, alpha, vector3f, vec1, vec2, vec3, vec4);
    }

    private static void drawQuad(VertexConsumer builder, float v1, float v2, float alpha, Vector3f vector3f, Vector4f vec1, Vector4f vec2, Vector4f vec3, Vector4f vec4) {
        builder.vertex(vec4.x(), vec4.y(), vec4.z(), 1.0F, 1.0F, 1.0F, alpha, 0, v1, OverlayTexture.NO_OVERLAY, 15728880, vector3f.x(), vector3f.y(), vector3f.z());
        builder.vertex(vec3.x(), vec3.y(), vec3.z(), 1.0F, 1.0F, 1.0F, alpha, 0, v2, OverlayTexture.NO_OVERLAY, 15728880, vector3f.x(), vector3f.y(), vector3f.z());
        builder.vertex(vec2.x(), vec2.y(), vec2.z(), 1.0F, 1.0F, 1.0F, alpha, 1, v2, OverlayTexture.NO_OVERLAY, 15728880, vector3f.x(), vector3f.y(), vector3f.z());
        builder.vertex(vec1.x(), vec1.y(), vec1.z(), 1.0F, 1.0F, 1.0F, alpha, 1, v1, OverlayTexture.NO_OVERLAY, 15728880, vector3f.x(), vector3f.y(), vector3f.z());
    }

    @Override
    public ResourceLocation getTextureLocation(WhiteAhogeBeamEntity entity) {
        return CORE;
    }
}
