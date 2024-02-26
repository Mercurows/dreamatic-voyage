package tech.lq0.dreamaticvoyage.client.models.entity;// Made with Blockbench 4.9.4
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
public class HirenadeGGModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "hirenade_gg_model"), "main");
    public final ModelPart main;

    public HirenadeGGModel(ModelPart root) {
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 27).addBox(3.0F, -4.0F, -4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 28).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(40, 16).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 19).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-3.0F, 3.0F, -2.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(18, 28).addBox(-5.0F, -4.0F, -2.0F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(4.0F, -4.0F, -2.0F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(4, 27).addBox(-4.0F, -4.0F, -4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -3.0F));

        PartDefinition feet = main.addOrReplaceChild("feet", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -3.0F));

        PartDefinition cube_r1 = feet.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.75F, 13.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r2 = feet.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 3.25F, 13.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r3 = feet.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(26, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 2.5F, 9.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r4 = feet.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 28).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -4.5F, 9.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r5 = feet.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(36, 8).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -1.0F, 9.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r6 = feet.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(20, 18).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -1.0F, 13.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r7 = feet.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.25F, -1.0F, 13.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r8 = feet.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(36, 36).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -1.0F, 9.0F, 0.0F, 0.0F, -0.7854F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}