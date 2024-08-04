package tech.lq0.dreamaticvoyage.client.render.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CampfireBlock;
import tech.lq0.dreamaticvoyage.block.entity.CrystalPopperBlockEntity;

public class CrystalPopperBlockEntityRenderer implements BlockEntityRenderer<CrystalPopperBlockEntity> {

    private final ItemRenderer itemRenderer;

    public CrystalPopperBlockEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        this.itemRenderer = pContext.getItemRenderer();
    }

    @Override
    public void render(CrystalPopperBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Direction direction = pBlockEntity.getBlockState().getValue(CampfireBlock.FACING);

        ItemStack stack = pBlockEntity.getInput();

        NonNullList<ItemStack> nonnulllist = pBlockEntity.getOutput();
        int i = (int) pBlockEntity.getBlockPos().asLong();

        if (stack != ItemStack.EMPTY) {
            pPoseStack.pushPose();
            pPoseStack.translate(0.5F, 0.44921875F, 0.5F);
            pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
            pPoseStack.translate(-0.3125F, -0.3125F, 0.0F);
            pPoseStack.scale(0.375F, 0.375F, 0.375F);
            this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), i);
            pPoseStack.popPose();
        }

        // TODO 修改为正确的渲染方法
        for (int j = 0; j < nonnulllist.size(); ++j) {
            ItemStack itemstack = nonnulllist.get(j);
            if (itemstack != ItemStack.EMPTY) {
                pPoseStack.pushPose();
                pPoseStack.translate(0.5F, 0.44921875F, 0.5F);
                Direction direction1 = Direction.from2DDataValue((j + direction.get2DDataValue()) % 4);
                float f = -direction1.toYRot();
                pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
                pPoseStack.translate(-0.3125F, -0.3125F, 0.0F);
                pPoseStack.scale(0.375F, 0.375F, 0.375F);
                this.itemRenderer.renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), i + j);
                pPoseStack.popPose();
            }
        }
    }
}
