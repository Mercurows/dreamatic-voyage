package tech.lq0.dreamaticvoyage.client.render.curios;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.models.curios.LunaticBowModel;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class LunaticBowRenderer implements ICurioRenderer {
    private static final ResourceLocation TEXTURE = Utils.loc("textures/models/curios/lunatic_bow.png");

    private final LunaticBowModel model;

    public LunaticBowRenderer() {
        this.model = new LunaticBowModel(Minecraft.getInstance().getEntityModels().bakeLayer(LunaticBowModel.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStack.pushPose();

        LivingEntity entity = slotContext.entity();
        this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
        this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        ICurioRenderer.translateIfSneaking(matrixStack, entity);
        ICurioRenderer.followHeadRotations(entity, this.model.main);

        matrixStack.scale(0.7f, 0.7f, 0.7f);
        matrixStack.translate(0.12f, -0.1f, 0.0f);

        VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.armorCutoutNoCull(TEXTURE), false, stack.hasFoil());

        model.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.popPose();
    }
}
