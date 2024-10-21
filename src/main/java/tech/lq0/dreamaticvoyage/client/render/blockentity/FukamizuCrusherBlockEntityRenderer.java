package tech.lq0.dreamaticvoyage.client.render.blockentity;

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
import tech.lq0.dreamaticvoyage.block.fukamizu.tech.FukamizuCrusher;
import tech.lq0.dreamaticvoyage.client.models.blockentity.FukamizuCrusherModel;

@SuppressWarnings("rawtypes")
@OnlyIn(Dist.CLIENT)
public class FukamizuCrusherBlockEntityRenderer implements BlockEntityRenderer<FukamizuCrusherBlockEntity> {
    public static final ResourceLocation TEXTURE = Utils.loc("textures/entity/fukamizu_crusher.png");
    private final FukamizuCrusherModel model;

    public FukamizuCrusherBlockEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        this.model = new FukamizuCrusherModel(pContext.bakeLayer(FukamizuCrusherModel.LAYER_LOCATION));
    }

    @Override
    public void render(FukamizuCrusherBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();

        pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        pPoseStack.translate(-0.5f, -1.5f, 0.5f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getBlockState().getValue(FukamizuCrusher.FACING).toYRot()));

        pPoseStack.pushPose();
        // TODO 完成加工时的旋转动画


        pPoseStack.popPose();

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(TEXTURE), false, false);
        this.model.renderToBuffer(pPoseStack, vertexconsumer, 0xffffff, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
    }
}
