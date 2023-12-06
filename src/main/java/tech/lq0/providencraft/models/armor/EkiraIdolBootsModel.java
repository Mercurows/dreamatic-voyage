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
public class EkiraIdolBootsModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "ekira_idol_boots_model"), "main");
    public final ModelPart right_total;
    public final ModelPart left_total;

    public EkiraIdolBootsModel(ModelPart root) {
        this.right_total = root.getChild("right_total");
        this.left_total = root.getChild("left_total");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create().texOffs(0, 20).addBox(-2.5F, 8.0F, 2.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 8).addBox(-2.5F, 8.0F, -2.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-2.75F, 8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 12).addBox(1.75F, 8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(-2.5F, 10.0F, -4.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-2.0F, 10.25F, -5.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 19).addBox(-2.0F, 11.75F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 24).addBox(-2.5F, 11.75F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 21).addBox(-2.0F, 11.75F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.5F, 11.75F, -4.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition cube_r4 = right_total.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.75F, 8.75F, -3.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r3 = right_total.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 8.75F, -3.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create().texOffs(11, 24).addBox(-2.5F, 8.0F, 2.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 16).addBox(-2.5F, 8.0F, -2.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 8).addBox(1.75F, 8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(-2.75F, 8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 4).addBox(-2.5F, 10.0F, -4.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(26, 13).addBox(-2.0F, 10.25F, -5.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 26).addBox(-2.0F, 11.75F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 11).addBox(-2.5F, 11.75F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 0).addBox(-2.0F, 11.75F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-2.5F, 11.75F, -4.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition ring = left_total.addOrReplaceChild("ring", CubeListBuilder.create().texOffs(32, 1).addBox(-0.25F, -6.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(40, 0).addBox(3.75F, -6.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(33, 7).addBox(0.75F, -6.0F, -2.25F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 9).addBox(0.75F, -6.0F, 2.25F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition cube_r2 = left_total.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(29, 2).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 8.75F, -3.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r1 = left_total.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(30, 4).mirror().addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.75F, 8.75F, -3.0F, 0.0F, 0.0F, 0.3927F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        right_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}