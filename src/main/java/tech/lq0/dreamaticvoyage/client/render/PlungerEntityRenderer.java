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
import tech.lq0.dreamaticvoyage.entity.projectile.PlungerEntity;
import tech.lq0.dreamaticvoyage.client.models.entity.PlungerModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
public class PlungerEntityRenderer extends EntityRenderer<PlungerEntity> {
    public static final ResourceLocation TEXTURE = Utils.loc("textures/entity/plunger.png");
    private final PlungerModel<PlungerEntity> model;

    public PlungerEntityRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        model = new PlungerModel<>(manager.bakeLayer(PlungerModel.LAYER_LOCATION));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(PlungerEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();

        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(45.0F));

        matrixStackIn.translate(0.0f, -1.3f, 0.0f);
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(bufferIn, this.model.renderType(this.getTextureLocation(entityIn)), false, false);
        this.model.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getTextureLocation(PlungerEntity entity) {
        return TEXTURE;
    }
}
