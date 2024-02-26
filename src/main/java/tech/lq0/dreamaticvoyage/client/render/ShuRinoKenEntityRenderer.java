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
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.entity.projectile.ShuRinoKenEntity;
import tech.lq0.dreamaticvoyage.client.models.entity.ShuRinoKenModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ShuRinoKenEntityRenderer extends EntityRenderer<ShuRinoKenEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/shu_rino_ken.png");
    private final ShuRinoKenModel<ShuRinoKenEntity> model;

    public ShuRinoKenEntityRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        model = new ShuRinoKenModel<>(manager.bakeLayer(ShuRinoKenModel.LAYER_LOCATION));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(ShuRinoKenEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();

        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));

        matrixStackIn.translate(0.0f, -1.3f, 0.0f);
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(bufferIn, this.model.renderType(this.getTextureLocation(entityIn)), false, false);
        this.model.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getTextureLocation(ShuRinoKenEntity entity) {
        return TEXTURE;
    }
}
