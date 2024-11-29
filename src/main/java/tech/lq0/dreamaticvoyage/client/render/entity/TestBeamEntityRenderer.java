package tech.lq0.dreamaticvoyage.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.entity.projectile.TestBeamEntity;

@OnlyIn(Dist.CLIENT)
public class TestBeamEntityRenderer extends AbstractBeamEntityRenderer<TestBeamEntity> {

    public static final ResourceLocation TEXTURE = Utils.loc("textures/entity/test_beam.png");

    public TestBeamEntityRenderer(EntityRendererProvider.Context context) {
        super(context, 1.0f, 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(TestBeamEntity entity) {
        return TEXTURE;
    }
}
