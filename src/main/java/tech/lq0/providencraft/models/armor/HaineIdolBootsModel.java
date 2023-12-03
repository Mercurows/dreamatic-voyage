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
public class HaineIdolBootsModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "haine_idol_boots_model"), "main");
    public final ModelPart right_total;
    public final ModelPart left_total;

    public HaineIdolBootsModel(ModelPart root) {
        this.right_total = root.getChild("right_total");
        this.left_total = root.getChild("left_total");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition right = right_total.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, 0.0F, -4.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(13, 5).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-4.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(20, 26).addBox(-4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 22).addBox(-4.5F, 0.0F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 3).addBox(-4.0F, -1.0F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-4.0F, -1.5F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-4.0F, -1.0F, -5.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(-4.0F, -1.5F, -4.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(25, 0).addBox(-4.0F, -1.75F, -2.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.0F, 0.0F));

        PartDefinition cube_r4 = right.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -0.889F, 1.6879F, -0.9599F, 0.0F, 0.0F));

        PartDefinition cube_r5 = right.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 2).addBox(-0.5F, -1.0F, -0.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -0.5F, 0.5F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r6 = right.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -1.75F, 1.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition left = left_total.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, 0.0F, -4.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(18, 14).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(9, 13).addBox(3.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(27, 13).addBox(0.0F, 0.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 24).addBox(-0.5F, 0.0F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 22).addBox(0.0F, -1.0F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 6).addBox(0.0F, -1.5F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(0.0F, -1.0F, -5.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 9).addBox(0.0F, -1.5F, -4.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(0.0F, -1.75F, -2.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, 0.0F));

        PartDefinition cube_r1 = left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, 0.0F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -0.889F, 1.6879F, -0.9599F, 0.0F, 0.0F));

        PartDefinition cube_r2 = left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 8).addBox(-0.5F, -1.0F, -0.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -0.5F, 0.5F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r3 = left.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -1.75F, 1.0F, -0.2182F, 0.0F, 0.0F));

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