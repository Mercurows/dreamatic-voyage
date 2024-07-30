package tech.lq0.dreamaticvoyage.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.FukamizuCrusherBlockEntity;
import tech.lq0.dreamaticvoyage.block.fukamizutech.FukamizuCrusher;
import tech.lq0.dreamaticvoyage.client.models.blockentity.FukamizuCrusherModel;

@SuppressWarnings("rawtypes")
@OnlyIn(Dist.CLIENT)
public class FukamizuCrusherBlockEntityRenderer implements BlockEntityRenderer<FukamizuCrusherBlockEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/fukamizu_crusher.png");
    private final FukamizuCrusherModel model;

    public FukamizuCrusherBlockEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        this.model = new FukamizuCrusherModel(pContext.bakeLayer(FukamizuCrusherModel.LAYER_LOCATION));
    }

    // TODO 完成粉碎机BE的渲染，实现高光效果
    @Override
    public void render(FukamizuCrusherBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();

        pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        pPoseStack.translate(-0.5f, -1.5f, 0.5f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getBlockState().getValue(FukamizuCrusher.FACING).toYRot()));

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(TEXTURE), false, false);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
    }
}
