package tech.lq0.dreamaticvoyage.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.models.entity.KurumiBoomerangModel;
import tech.lq0.dreamaticvoyage.entity.projectile.KurumiBoomerangEntity;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
public class KurumiBoomerangEntityRenderer extends EntityRenderer<KurumiBoomerangEntity> {

    public static final ResourceLocation TEXTURE = Utils.loc("textures/entity/kurumi_boomerang.png");
    private final KurumiBoomerangModel<KurumiBoomerangEntity> model;

    public KurumiBoomerangEntityRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        model = new KurumiBoomerangModel<>(manager.bakeLayer(KurumiBoomerangModel.LAYER_LOCATION));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(KurumiBoomerangEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

        matrixStackIn.pushPose();

        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));

        matrixStackIn.translate(0.0f, -0.85f, 0.0f);

        int rotateSpeed = 60;

        if (entityIn.getInGroundTime() == 0) {
            matrixStackIn.mulPose(Axis.YP.rotationDegrees((entityIn.flyingTicks + partialTicks) * rotateSpeed));
        } else {
            double base = entityIn.flyingTicks * rotateSpeed;
            double pitch = Math.abs(entityIn.getYRot());
            double endTick = (float) (0.0148148148 * pitch * pitch - 2.664 * pitch + 140);

            double x = entityIn.getInGroundTime() + partialTicks;
            if (x > endTick) {
                x = endTick;
            }
            double extraDegree = (float) (-1800.0 / Math.pow(endTick, 2) * x * x + (3600.0 / (endTick)) * x);

            matrixStackIn.mulPose(Axis.YP.rotationDegrees((float) (base + extraDegree)));
        }

        matrixStackIn.scale(0.7f, 0.7f, 0.7f);

        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(bufferIn, this.model.renderType(this.getTextureLocation(entityIn)), false, false);
        this.model.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStackIn.popPose();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getTextureLocation(KurumiBoomerangEntity entity) {
        return TEXTURE;
    }
}
