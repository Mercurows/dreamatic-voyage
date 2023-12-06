package tech.lq0.providencraft.models.armor;// Made with Blockbench 4.9.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import tech.lq0.providencraft.Utils;

@SuppressWarnings("unused")
public class KeroroIdolBootsModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "keroro_idol_boots_model"), "main");
    public final ModelPart left_total;
    public final ModelPart right_total;

    public KeroroIdolBootsModel(ModelPart root) {
        this.left_total = root.getChild("left_total");
        this.right_total = root.getChild("right_total");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition left = left_total.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -0.25F, -4.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(16, 14).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(14, 6).addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 12).addBox(0.0F, -0.25F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 29).addBox(-0.5F, -0.25F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-0.5F, -4.0F, 2.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 10).addBox(0.0F, -0.25F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 3).addBox(-0.5F, -2.0F, -5.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-1.0F, -2.0F, -4.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 26).addBox(-1.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 10).addBox(4.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-0.5F, -4.0F, -2.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 12).addBox(1.0F, -4.25F, -2.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition right = right_total.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -0.25F, -4.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(8, 13).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(-4.0F, -0.25F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 0).addBox(-4.5F, -0.25F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 21).addBox(-4.5F, -4.0F, 2.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 3).addBox(-4.0F, -0.25F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 26).addBox(-4.5F, -2.0F, -5.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(-5.0F, -2.0F, -4.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 3).addBox(0.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 21).addBox(-5.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 17).addBox(-4.5F, -4.0F, -2.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-3.0F, -4.25F, -2.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}