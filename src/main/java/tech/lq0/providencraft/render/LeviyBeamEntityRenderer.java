package tech.lq0.providencraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.LeviyBeamEntity;
import tech.lq0.providencraft.render.special.LeviyRenderer;

public class LeviyBeamEntityRenderer extends EntityRenderer<LeviyBeamEntity> {
    public static final ResourceLocation TEXTURE_LEVIY_BEAM = new ResourceLocation(Utils.MOD_ID, "textures/entity/leviy_beam.png");
    public static final ResourceLocation TEXTURE_LEVIY_HALO = new ResourceLocation(Utils.MOD_ID, "textures/entity/leviy_halo.png");

    protected LeviyBeamEntityRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(LeviyBeamEntity entity) {
        return TEXTURE_LEVIY_BEAM;
    }

    @Override
    public void render(LeviyBeamEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();

        float r = entityIn.getCurrentRadius(partialTicks);

        // 渲染光柱
        LeviyRenderer.renderBeamSegment(matrixStackIn,
                bufferIn,
                TEXTURE_LEVIY_BEAM,
                partialTicks,
                1, entityIn.getEntityWorld().getGameTime(),
                (int) entityIn.getYOffset(), 150, new float[]{1, 1, 1},
                r, 0, 0.5f);
        matrixStackIn.pop();
        matrixStackIn.translate(.5f, 0, .5f);
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }
}
