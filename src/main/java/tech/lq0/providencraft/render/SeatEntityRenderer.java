package tech.lq0.providencraft.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.lq0.providencraft.entity.SeatEntity;

public class SeatEntityRenderer extends EntityRenderer<SeatEntity> {
    public SeatEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(SeatEntity seatEntity) {
        return null;
    }
}
