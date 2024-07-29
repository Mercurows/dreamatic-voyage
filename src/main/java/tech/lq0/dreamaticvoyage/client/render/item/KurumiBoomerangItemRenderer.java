package tech.lq0.dreamaticvoyage.client.render.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class KurumiBoomerangItemRenderer extends BlockEntityWithoutLevelRenderer {
    public KurumiBoomerangItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        long degree = System.currentTimeMillis() / 25 % 360;

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        BakedModel bakedModel = itemRenderer.getModel(pStack, null, null, 0);

        pPoseStack.pushPose();
        pPoseStack.scale(0.6F, 0.6F, 0.6F);
        pPoseStack.translate(0.2F, 1.5F, 0.8F);
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(-155.5F));
        float xOffset = -1 / 32f;
        float zOffset = 0;
        pPoseStack.translate(-xOffset, 0, -zOffset);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(degree));
        pPoseStack.translate(xOffset, 0, zOffset);

        itemRenderer.render(pStack, ItemDisplayContext.NONE, false, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, bakedModel);

        pPoseStack.popPose();
    }
}
