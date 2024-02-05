package tech.lq0.providencraft.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.TailHookEntity;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class TailHookEntityRenderer extends EntityRenderer<TailHookEntity> {
    private static final ResourceLocation HOOK = new ResourceLocation(Utils.MOD_ID, "textures/entity/tail_hook.png");
    private static final RenderType RENDER_TYPE = RenderType.entityCutout(HOOK);

    public TailHookEntityRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(TailHookEntity pEntity) {
        return HOOK;
    }

    @Override
    public void render(TailHookEntity entityIn, float entityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        Player player = entityIn.getPlayerOwner();
        if (player != null) {
            pPoseStack.pushPose();
            pPoseStack.pushPose();
            pPoseStack.scale(0.5F, 0.5F, 0.5F);
            pPoseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            PoseStack.Pose posestack$pose = pPoseStack.last();
            Matrix4f matrix4f = posestack$pose.pose();
            Matrix3f matrix3f = posestack$pose.normal();
            VertexConsumer vertexconsumer = pBuffer.getBuffer(RENDER_TYPE);
            vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 0.0F, 0, 0, 1);
            vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 1.0F, 0, 1, 1);
            vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 1.0F, 1, 1, 0);
            vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 0.0F, 1, 0, 0);
            pPoseStack.popPose();
            int i = player.getMainArm() == HumanoidArm.RIGHT ? 1 : -1;
            ItemStack itemstack = player.getMainHandItem();
            if (!itemstack.canPerformAction(net.minecraftforge.common.ToolActions.FISHING_ROD_CAST)) {
                i = -i;
            }

            float f = player.getAttackAnim(pPartialTicks);
            float f1 = Mth.sin(Mth.sqrt(f) * (float) Math.PI);
            float f2 = Mth.lerp(pPartialTicks, player.yBodyRotO, player.yBodyRot) * ((float) Math.PI / 180F);
            double d0 = Mth.sin(f2);
            double d1 = Mth.cos(f2);
            double d2 = (double) i * 0.35D;
            double d4;
            double d5;
            double d6;
            float f3;
            if ((this.entityRenderDispatcher.options == null || this.entityRenderDispatcher.options.getCameraType().isFirstPerson()) && player == Minecraft.getInstance().player) {
                double d7 = 960.0D / (double) this.entityRenderDispatcher.options.fov().get();
                Vec3 vec3 = this.entityRenderDispatcher.camera.getNearPlane().getPointOnPlane((float) i * 0.525F, -0.1F);
                vec3 = vec3.scale(d7);
                vec3 = vec3.yRot(f1 * 0.5F);
                vec3 = vec3.xRot(-f1 * 0.7F);
                d4 = Mth.lerp(pPartialTicks, player.xo, player.getX()) + vec3.x;
                d5 = Mth.lerp(pPartialTicks, player.yo, player.getY()) + vec3.y;
                d6 = Mth.lerp(pPartialTicks, player.zo, player.getZ()) + vec3.z;
                f3 = player.getEyeHeight();
            } else {
                d4 = Mth.lerp(pPartialTicks, player.xo, player.getX()) - d1 * d2 - d0 * 0.8D;
                d5 = player.yo + (double) player.getEyeHeight() + (player.getY() - player.yo) * (double) pPartialTicks - 0.45D;
                d6 = Mth.lerp(pPartialTicks, player.zo, player.getZ()) - d0 * d2 + d1 * 0.8D;
                f3 = player.isCrouching() ? -0.1875F : 0.0F;
            }

            double d9 = Mth.lerp(pPartialTicks, entityIn.xo, entityIn.getX());
            double d10 = Mth.lerp(pPartialTicks, entityIn.yo, entityIn.getY()) + 0.25D;
            double d8 = Mth.lerp(pPartialTicks, entityIn.zo, entityIn.getZ());
            float f4 = (float) (d4 - d9);
            float f5 = (float) (d5 - d10) + f3;
            float f6 = (float) (d6 - d8);
            VertexConsumer vertexconsumer1 = pBuffer.getBuffer(RenderType.lineStrip());
            PoseStack.Pose posestack$pose1 = pPoseStack.last();

            Color color_end = new Color(0x90f2f6);
            Color color_start = new Color(0x2d2b2d);

            for (int k = 0; k < 16; ++k) {
                int r = Math.min(color_end.getRed() + (color_start.getRed() - color_end.getRed()) * k / 15, 255);
                int g = Math.min(color_end.getGreen() + (color_start.getGreen() - color_end.getGreen()) * k / 15, 255);
                int b = Math.min(color_end.getBlue() + (color_start.getBlue() - color_end.getBlue()) * k / 15, 255);

                stringVertex(f4, f5, f6, vertexconsumer1, posestack$pose1, fraction(k, 16), 255 - r, 255 - g, 255 - b);
                stringVertex(f4, f5, f6, vertexconsumer1, posestack$pose1, fraction(k + 1, 16), 255 - r, 255 - g, 255 - b);
            }

            pPoseStack.popPose();
            super.render(entityIn, entityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        }
    }

    private static float fraction(int pNumerator, int pDenominator) {
        return (float) pNumerator / (float) pDenominator;
    }

    private static void vertex(VertexConsumer pConsumer, Matrix4f pPose, Matrix3f pNormal, int pLightmapUV, float pX, int pY, int pU, int pV) {
        pConsumer.vertex(pPose, pX - 0.5F, (float) pY - 0.5F, 0.0F).color(255, 255, 255, 255).uv((float) pU, (float) pV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pLightmapUV).normal(pNormal, 0.0F, 1.0F, 0.0F).endVertex();
    }

    private static void stringVertex(float x, float y, float z, VertexConsumer pConsumer, PoseStack.Pose pPose, float f, float r, float g, float b) {
        float px = x * f;
        float py = y * (f * f + f) * 0.5F + 0.25F;
        float pz = z * f;
        float sqrt = Mth.sqrt(px * px + py * py + pz * pz);
        pConsumer.vertex(pPose.pose(), px, py, pz).color(r, g, b, 1.0F).normal(pPose.normal(), px / sqrt, py / sqrt, pz / sqrt).endVertex();
    }
}
