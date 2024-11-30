package tech.lq0.dreamaticvoyage.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.entity.projectile.TestBeamEntity;

/**
 * Code based on @BobMowzie's MowziesMobs and @EEEAB's EEEABsMobs
 */
@OnlyIn(Dist.CLIENT)
public class TestBeamEntityRenderer extends AbstractBeamEntityRenderer<TestBeamEntity> {

    private boolean playerView;

    private static final float TEXTURE_WIDTH = 256;
    private static final float TEXTURE_HEIGHT = 32;

    public static final ResourceLocation TEXTURE = Utils.loc("textures/entity/test_beam.png");

    public TestBeamEntityRenderer(EntityRendererProvider.Context context) {
        super(context, 1.0f, 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(TestBeamEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TestBeamEntity laser, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        this.playerView = laser.caster instanceof Player && Minecraft.getInstance().player == laser.caster
                && Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON;
        super.render(laser, entityYaw, delta, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    protected void renderFlatQuad(int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn, boolean inGround) {
        float minU = 0 + 16F / TEXTURE_WIDTH * frame;
        float minV = 0;
        float maxU = minU + 16F / TEXTURE_WIDTH;
        float maxV = minV + 16F / TEXTURE_HEIGHT;
        float size = 0.8f;
        PoseStack.Pose matrix$stack$entry = matrixStackIn.last();
        Matrix4f matrix4f = matrix$stack$entry.pose();
        Matrix3f matrix3f = matrix$stack$entry.normal();
        drawVertex(matrix4f, matrix3f, builder, -size, -size, 0, minU, minV, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, -size, size, 0, minU, maxV, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, size, size, 0, maxU, maxV, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, size, -size, 0, maxU, minV, packedLightIn);
    }

    @Override
    protected void renderStart(TestBeamEntity laser, int frame, PoseStack matrixStackIn, VertexConsumer builder, float delta, int packedLightIn) {
        if (this.playerView) return;
        super.renderStart(laser, frame, matrixStackIn, builder, delta, packedLightIn);
    }

    @Override
    protected void drawBeam(float length, int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0;
        float minV = 16 / TEXTURE_HEIGHT + 1 / TEXTURE_HEIGHT * frame;
        float maxU = minU + 20 / TEXTURE_WIDTH;
        float maxV = minV + 1 / TEXTURE_HEIGHT;
        PoseStack.Pose matrix$stack$entry = matrixStackIn.last();
        Matrix4f matrix4f = matrix$stack$entry.pose();
        Matrix3f matrix3f = matrix$stack$entry.normal();
        float offset = playerView ? -1 : 0;
        float size = 0.8f;
        drawVertex(matrix4f, matrix3f, builder, -size, offset, 0, minU, minV, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, -size, length, 0, minU, maxV, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, size, length, 0, maxU, maxV, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, size, offset, 0, maxU, minV, packedLightIn);
    }
}
