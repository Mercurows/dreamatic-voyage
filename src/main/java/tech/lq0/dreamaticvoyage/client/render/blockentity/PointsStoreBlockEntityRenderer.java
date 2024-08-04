package tech.lq0.dreamaticvoyage.client.render.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.PointsStoreBlockEntity;
import tech.lq0.dreamaticvoyage.client.models.blockentity.PdCLogoModel;

@OnlyIn(Dist.CLIENT)
public class PointsStoreBlockEntityRenderer implements BlockEntityRenderer<PointsStoreBlockEntity> {
    public static final Material TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(Utils.MOD_ID, "textures/entity/pdc_logo.png"));
    private final PdCLogoModel model;

    public PointsStoreBlockEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        this.model = new PdCLogoModel(pContext.bakeLayer(PdCLogoModel.LAYER_LOCATION));
    }

    @Override
    public void render(PointsStoreBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 1.3f, 0.5f);
        pPoseStack.scale(0.4f, 0.4f, 0.4f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0f));

        pPoseStack.mulPose(Axis.YP.rotationDegrees((pBlockEntity.ticks + pPartialTick) * 5));
        VertexConsumer vertexconsumer = TEXTURE.buffer(pBuffer, RenderType::entitySolid);
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, 255.0F, 255.0F, 255.0F, 1.0F);
        pPoseStack.popPose();
    }
}
