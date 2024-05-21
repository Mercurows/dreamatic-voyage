package tech.lq0.dreamaticvoyage.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.render.special.LeviyRenderer;
import tech.lq0.dreamaticvoyage.entity.LeviyBeamEntity;

public class LeviyBeamEntityRenderer extends EntityRenderer<LeviyBeamEntity> {
    public static final ResourceLocation TEXTURE_LEVIY_BEAM = new ResourceLocation(Utils.MOD_ID, "textures/entity/leviy_beam.png");
    public static final ResourceLocation TEXTURE_LEVIY_HALO = new ResourceLocation(Utils.MOD_ID, "textures/entity/leviy_halo.png");
    public static final ResourceLocation TEXTURE_LEVIY_MAGIC = new ResourceLocation(Utils.MOD_ID, "textures/entity/leviy_magic.png");

    public LeviyBeamEntityRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(LeviyBeamEntity pEntity) {
        return TEXTURE_LEVIY_BEAM;
    }

    @Override
    public void render(LeviyBeamEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();

        // TODO 正确获取半径
        int duration = entityIn.getDuration();
        float radius = entityIn.getRadius();

        float r = entityIn.getCurrentRadius(partialTicks, duration, radius);

        // 渲染光柱
        LeviyRenderer.renderBeamSegment(matrixStackIn,
                bufferIn,
                TEXTURE_LEVIY_BEAM,
                partialTicks,
                1, entityIn.level().getGameTime(),
                (int) entityIn.getMyRidingOffset(), 150, new float[]{1, 1, 1},
                r, 0, 0.5f, true);
        matrixStackIn.translate(.5f, 0, .5f);
        matrixStackIn.popPose();
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }
}
