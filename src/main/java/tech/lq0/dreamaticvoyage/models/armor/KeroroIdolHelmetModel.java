package tech.lq0.dreamaticvoyage.models.armor;// Made with Blockbench 4.9.0
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
public class KeroroIdolHelmetModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "keroro_idol_helmet_model"), "main");
    public final ModelPart main;

    public KeroroIdolHelmetModel(ModelPart root) {
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right = main.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(-0.25F, -0.75F, 0.0F));

        PartDefinition bow2 = right.addOrReplaceChild("bow2", CubeListBuilder.create().texOffs(10, 3).addBox(-4.6254F, -8.0891F, -0.45F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 3).addBox(-4.1396F, -7.6412F, -0.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7025F, 0.3935F, 0.2F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r19 = bow2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(1.4056F, -8.6297F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0544F, -0.0451F, -0.2F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r20 = bow2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 3).addBox(3.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2975F, 1.373F, 0.05F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r21 = bow2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(20, 20).addBox(-6.0458F, -7.0908F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9898F, 2.8742F, 0.05F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r22 = bow2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(4, 17).addBox(-8.324F, 3.3937F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4203F, 3.1359F, 0.05F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r23 = bow2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 21).addBox(-2.1671F, -8.6899F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1269F, 2.8742F, 0.05F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r24 = bow2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(5, 5).addBox(6.324F, -4.9942F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5574F, 3.1359F, 0.05F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r25 = bow2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(6, 0).addBox(-8.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4346F, 1.373F, 0.05F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r26 = bow2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(17, 7).addBox(5.8682F, -4.3937F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4203F, -3.122F, 0.05F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r27 = bow2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(6, 21).addBox(-2.974F, -8.7649F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9898F, -2.8603F, 0.05F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r28 = bow2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 7).addBox(-8.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2975F, -1.3591F, 0.05F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r29 = bow2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(6, 8).addBox(-7.8682F, 2.9942F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5574F, -3.122F, 0.05F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r30 = bow2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(12, 21).addBox(-5.2388F, -7.1659F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1269F, -2.8603F, 0.05F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r31 = bow2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 10).addBox(3.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4346F, -1.3591F, 0.05F, 0.0F, 0.0F, -1.0472F));

        PartDefinition shu2 = right.addOrReplaceChild("shu2", CubeListBuilder.create().texOffs(20, 3).addBox(-0.5F, -9.3095F, 0.356F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.25F, 5.4825F, 0.4238F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r32 = shu2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(18, 0).addBox(-0.9881F, -0.2363F, -0.0988F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.1224F, 2.3437F, -0.3491F, 0.0F, 0.2182F));

        PartDefinition cube_r33 = shu2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(13, 18).addBox(-0.9881F, -1.5298F, -0.1956F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.1224F, 2.3437F, 0.4363F, 0.0F, 0.2182F));

        PartDefinition cube_r34 = shu2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 16).addBox(-0.9881F, -1.3385F, -0.7662F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.1224F, 2.3437F, 0.0436F, 0.0F, 0.2182F));

        PartDefinition cube_r35 = shu2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(3, 19).addBox(-0.5F, -7.5532F, -5.0886F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9225F, -1.0939F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r36 = shu2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(16, 3).addBox(-0.5F, -9.8104F, -2.2315F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.608F, -1.3366F, -0.3927F, 0.0F, 0.0F));

        PartDefinition left = main.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(0.25F, -0.75F, 0.0F));

        PartDefinition bow = left.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(12, 15).addBox(2.6254F, -8.0891F, -0.45F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 9).addBox(3.1396F, -7.6412F, -0.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7025F, 0.3935F, 0.2F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r1 = bow.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, 11).addBox(-3.4056F, -8.6297F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0544F, -0.0451F, -0.2F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = bow.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 9).addBox(-5.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2975F, 1.373F, 0.05F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r3 = bow.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(3, 23).addBox(5.0458F, -7.0908F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9898F, 2.8742F, 0.05F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r4 = bow.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(17, 11).addBox(6.324F, 3.3937F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4203F, 3.1359F, 0.05F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r5 = bow.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 12).addBox(1.1671F, -8.6899F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1269F, 2.8742F, 0.05F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r6 = bow.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 0).addBox(-8.324F, -4.9942F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5574F, 3.1359F, 0.05F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r7 = bow.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(11, 6).addBox(6.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4346F, 1.373F, 0.05F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r8 = bow.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(17, 14).addBox(-7.8682F, -4.3937F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4203F, -3.122F, 0.05F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r9 = bow.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(23, 5).addBox(1.974F, -8.7649F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9898F, -2.8603F, 0.05F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r10 = bow.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 12).addBox(6.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2975F, -1.3591F, 0.05F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r11 = bow.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 13).addBox(5.8682F, 2.9942F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5574F, -3.122F, 0.05F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r12 = bow.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(9, 23).addBox(4.2388F, -7.1659F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1269F, -2.8603F, 0.05F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r13 = bow.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(6, 14).addBox(-5.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4346F, -1.3591F, 0.05F, 0.0F, 0.0F, 1.0472F));

        PartDefinition shu = left.addOrReplaceChild("shu", CubeListBuilder.create().texOffs(22, 8).addBox(-0.5F, -9.3095F, 0.356F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.25F, 5.4825F, 0.4238F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r14 = shu.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(21, 16).addBox(-0.0119F, -0.2363F, -0.0988F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.1224F, 2.3437F, -0.3491F, 0.0F, -0.2182F));

        PartDefinition cube_r15 = shu.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(16, 21).addBox(-0.0119F, -1.5298F, -0.1956F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.1224F, 2.3437F, 0.4363F, 0.0F, -0.2182F));

        PartDefinition cube_r16 = shu.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(17, 17).addBox(-0.0119F, -1.3385F, -0.7662F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.1224F, 2.3437F, 0.0436F, 0.0F, -0.2182F));

        PartDefinition cube_r17 = shu.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, -7.5532F, -5.0886F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9225F, -1.0939F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r18 = shu.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(9, 18).addBox(-0.5F, -9.8104F, -2.2315F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.608F, -1.3366F, -0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}