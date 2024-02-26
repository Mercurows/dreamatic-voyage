package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.4
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
import tech.lq0.dreamaticvoyage.Utils;

@SuppressWarnings("unused")
public class OrangeTrackerModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "orange_tracker_model"), "main");
    public final ModelPart armorBody;
    public final ModelPart armorRightLeg;
    public final ModelPart armorLeftLeg;

    public OrangeTrackerModel(ModelPart root) {
        this.armorBody = root.getChild("armorBody");
        this.armorRightLeg = root.getChild("armorRightLeg");
        this.armorLeftLeg = root.getChild("armorLeftLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_total = armorBody.addOrReplaceChild("body_total", CubeListBuilder.create(), PartPose.offset(0.0F, 23.5F, 0.0F));

        PartDefinition body = body_total.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 2).addBox(-4.5F, -14.0F, -2.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.5F, -14.0F, 1.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 9).addBox(-4.75F, -14.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 4).addBox(3.75F, -14.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 6).addBox(-1.5F, -14.75F, -2.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 4).addBox(-1.5F, -13.25F, -2.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tracker = body.addOrReplaceChild("tracker", CubeListBuilder.create().texOffs(12, 22).addBox(-1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 22).addBox(-0.5F, -13.0F, -5.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(25, 5).addBox(-1.0F, -14.5F, -5.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.75F));

        PartDefinition cube_r1 = tracker.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.933F, -11.884F, -5.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r2 = tracker.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(25, 2).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.933F, -11.884F, -5.5F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r3 = tracker.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 22).addBox(-0.75F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1585F, -12.0425F, -4.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r4 = tracker.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(22, 8).addBox(-1.25F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1585F, -12.0425F, -4.5F, 0.0F, 0.0F, 1.0472F));

        PartDefinition armorRightLeg = partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition right_total = armorRightLeg.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(2.0F, 10.75F, 0.0F));

        PartDefinition right = right_total.addOrReplaceChild("right", CubeListBuilder.create().texOffs(10, 15).addBox(-4.0F, -3.0F, -2.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-4.0F, -3.0F, 1.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 5).addBox(-0.25F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-4.75F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tracker3 = right.addOrReplaceChild("tracker3", CubeListBuilder.create().texOffs(12, 19).addBox(-1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 9).addBox(-0.5F, -13.0F, -5.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 23).addBox(-1.0F, -14.5F, -5.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 10.0F, 1.0F));

        PartDefinition cube_r5 = tracker3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 12).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.933F, -11.884F, -5.5F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r6 = tracker3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(22, 17).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.933F, -11.884F, -5.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r7 = tracker3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 19).addBox(-1.25F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1585F, -12.0425F, -4.5F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r8 = tracker3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(6, 19).addBox(-0.75F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1585F, -12.0425F, -4.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition armorLeftLeg = partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition left_total = armorLeftLeg.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(-2.0F, 10.75F, 0.0F));

        PartDefinition left = left_total.addOrReplaceChild("left", CubeListBuilder.create().texOffs(10, 17).addBox(0.0F, -3.0F, -2.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(0.0F, -3.0F, 1.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 10).addBox(-0.75F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(3.75F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tracker2 = left.addOrReplaceChild("tracker2", CubeListBuilder.create().texOffs(18, 20).addBox(-1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 17).addBox(-0.5F, -13.0F, -5.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(23, 24).addBox(-1.0F, -14.5F, -5.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 10.0F, 1.0F));

        PartDefinition cube_r9 = tracker2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(23, 19).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.933F, -11.884F, -5.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r10 = tracker2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(23, 22).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.933F, -11.884F, -5.5F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r11 = tracker2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(20, 0).addBox(-0.75F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1585F, -12.0425F, -4.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r12 = tracker2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(20, 14).addBox(-1.25F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1585F, -12.0425F, -4.5F, 0.0F, 0.0F, 1.0472F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        armorRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        armorLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}