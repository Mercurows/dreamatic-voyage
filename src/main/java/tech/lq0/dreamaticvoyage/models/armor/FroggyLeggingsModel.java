package tech.lq0.dreamaticvoyage.models.armor;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import tech.lq0.dreamaticvoyage.Utils;

@SuppressWarnings("unused")
public class FroggyLeggingsModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "froggy_leggings_model"), "main");
    public final ModelPart right_total;
    public final ModelPart left_total;
    public final ModelPart body_total;

    public FroggyLeggingsModel(ModelPart root) {
        super(root);
        this.right_total = root.getChild("right_total");
        this.left_total = root.getChild("left_total");
        this.body_total = root.getChild("body_total");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition right = right_total.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(3.0F, 7.0F, -0.5F));

        PartDefinition cube_r24 = right.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(4, 35).addBox(-2.5F, -4.5F, 9.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).addBox(-2.5F, -4.5F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, -1.0472F));

        PartDefinition cube_r25 = right.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(20, 33).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2321F, -2.866F, 0.0F, 1.5708F, 0.0F, 1.0472F));

        PartDefinition cube_r26 = right.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(16, 33).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8923F, 2.134F, -0.5F, 1.5708F, 0.0F, 1.0472F));

        PartDefinition cube_r27 = right.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(4, 11).addBox(-0.5F, -0.5F, 10.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(-0.5F, -0.5F, 1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0981F, -2.366F, -5.5F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r28 = right.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(4, 0).addBox(-3.5F, -6.5F, 10.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -6.5F, 1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0981F, -2.366F, -5.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition bone2 = right.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-1.3182F, 3.0321F, -0.5F));

        PartDefinition cube_r29 = bone2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(12, 11).addBox(-0.75F, -0.5F, -2.75F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r30 = bone2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(32, 0).addBox(-5.25F, -0.6499F, 4.25F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-5.25F, -0.65F, -4.75F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2799F, -1.3981F, 1.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r31 = bone2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(12, 0).addBox(-0.75F, -0.5F, -3.75F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4572F, -3.0782F, 1.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition left = left_total.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(2.0F, 10.0F, 0.0F));

        PartDefinition left_r1 = left.addOrReplaceChild("left_r1", CubeListBuilder.create().texOffs(17, 22).addBox(0.0F, -0.5F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(-1.0F, -0.5F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(18, 29).addBox(0.0F, -0.5F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9319F, -3.0739F, -0.2F, 0.0F, 0.0F, 0.2618F));

        PartDefinition left_r2 = left.addOrReplaceChild("left_r2", CubeListBuilder.create().texOffs(4, 27).addBox(-1.0F, -0.5F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 20).addBox(-1.0F, -0.5F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -0.5F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4191F, 1.3122F, -0.2F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r4 = left.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 14).addBox(-3.75F, -3.65F, 4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 12).addBox(-3.75F, -3.65F, -5.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r5 = left.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(32, 10).addBox(-4.75F, -0.65F, 4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 6).addBox(-4.75F, -0.65F, -5.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.95F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r6 = left.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 4).addBox(-6.0F, 2.65F, 4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 2).addBox(-6.0F, 2.65F, -5.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.45F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r7 = left.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -0.5F, -4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0909F, 1.6911F, -1.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r8 = left.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(24, 28).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0909F, 2.3911F, -1.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r9 = left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 19).addBox(-0.25F, -0.5F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2799F, 0.4481F, -1.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r10 = left.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(22, 10).addBox(0.75F, -0.5F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.306F, -1.3709F, -1.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r11 = left.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(22, 1).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3663F, -0.687F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r12 = left.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 22).addBox(0.75F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1513F, -4.4491F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r13 = left.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(14, 20).addBox(-0.25F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1773F, -2.63F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r14 = left.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 33).addBox(-2.8F, -0.5F, 0.3F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 16).addBox(-2.8F, -0.5F, -8.7F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8298F, -1.2824F, 3.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition hua = left.addOrReplaceChild("hua", CubeListBuilder.create().texOffs(22, 3).addBox(-6.2F, 3.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-6.2F, 5.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 22).addBox(-5.95F, 4.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(10.6F, -7.05F, 0.1F));

        PartDefinition cube_r15 = hua.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(12, 11).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.582F, 5.0F, 1.7582F, 0.0F, -0.5236F, 0.0F));

        PartDefinition cube_r16 = hua.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 5.0F, -2.0F, 0.0F, 0.5236F, 0.0F));

        PartDefinition left_note = left.addOrReplaceChild("left_note", CubeListBuilder.create().texOffs(22, 6).addBox(-1.5476F, -0.509F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2077F, 0.4134F, -5.3F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r17 = left_note.addOrReplaceChild("cube_r17", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0447F, -3.1652F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r17_r1 = cube_r17.addOrReplaceChild("cube_r17_r1", CubeListBuilder.create().texOffs(24, 20).addBox(-0.9403F, -3.1531F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0113F, 1.5156F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r18 = left_note.addOrReplaceChild("cube_r18", CubeListBuilder.create(), PartPose.offsetAndRotation(4.4195F, -3.7553F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r18_r1 = cube_r18.addOrReplaceChild("cube_r18_r1", CubeListBuilder.create().texOffs(22, 15).addBox(-1.2482F, 0.2091F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.405F, 2.023F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r19 = left_note.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(12, 6).addBox(-2.2897F, -1.1216F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3349F, -4.5105F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r20 = left_note.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(12, 17).addBox(-1.9085F, -1.6143F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7444F, 1.08F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r21 = left_note.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(16, 11).addBox(-9.2F, 10.4F, 11.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 10).addBox(-8.7F, 7.4F, 11.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8053F, -4.664F, -12.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r22 = left_note.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(16, 0).addBox(-13.7F, 9.2F, 11.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5284F, -3.5429F, -12.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r23 = left_note.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(4, 22).addBox(-11.7F, 7.4F, 11.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.873F, -4.9608F, -12.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition body_total = partdefinition.addOrReplaceChild("body_total", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = body_total.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition out1 = body.addOrReplaceChild("out1", CubeListBuilder.create().texOffs(30, 40).addBox(-14.0F, -0.5F, -2.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 40).addBox(-13.25F, -0.5F, -4.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 32).addBox(-12.5F, -0.5F, -6.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(42, 46).addBox(-11.75F, -0.5F, -7.9966F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 29).addBox(-13.25F, -0.5F, -0.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 41).addBox(-12.5F, -0.5F, 1.0034F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(40, 38).addBox(11.5F, -0.5F, 1.0034F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 24).addBox(12.25F, -0.5F, -0.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 21).addBox(13.0F, -0.5F, -2.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 18).addBox(12.25F, -0.5F, -4.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 38).addBox(11.5F, -0.5F, -6.9966F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 36).addBox(10.75F, -0.5F, -7.9966F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 46).addBox(8.75F, -0.5F, -8.4966F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 26).addBox(6.75F, -0.5F, -8.9966F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 46).addBox(-8.75F, -0.5F, -8.9966F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 8).addBox(-10.75F, -0.5F, -8.4966F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 41).addBox(-11.75F, -0.5F, 3.0034F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 40).addBox(10.75F, -0.5F, 3.0034F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 46).addBox(-11.0F, -0.5F, 4.0034F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 46).addBox(9.0F, -0.5F, 4.0034F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(45, 45).addBox(-9.0F, -0.5F, 4.7534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(45, 40).addBox(7.0F, -0.5F, 4.7534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 45).addBox(-7.0F, -0.5F, 5.1534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 45).addBox(5.0F, -0.5F, 5.1534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 45).addBox(-5.0F, -0.5F, 5.3534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 44).addBox(3.0F, -0.5F, 5.3534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 38).addBox(-3.0F, -0.5F, 5.5534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 34).addBox(-1.0F, -0.5F, 5.8034F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 44).addBox(1.0F, -0.5F, 5.5534F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.35F, 1.5966F));

        PartDefinition bone = out1.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.3958F, 0.0F, 1.1117F));

        PartDefinition out2 = body.addOrReplaceChild("out2", CubeListBuilder.create().texOffs(36, 37).addBox(-15.0F, -0.5F, -3.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 37).addBox(-14.25F, -0.5F, -5.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 37).addBox(-13.5F, -0.5F, -7.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 40).addBox(-12.75F, -0.5F, -8.9179F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 44).addBox(-11.75F, -0.5F, -9.6679F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 35).addBox(-14.25F, -0.5F, -1.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(36, 40).addBox(-13.5F, -0.5F, 0.0821F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(40, 35).addBox(12.5F, -0.5F, 0.0821F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 31).addBox(13.25F, -0.5F, -1.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 28).addBox(14.0F, -0.5F, -3.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 22).addBox(13.25F, -0.5F, -5.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 19).addBox(12.5F, -0.5F, -7.9179F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 38).addBox(11.75F, -0.5F, -8.9179F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 43).addBox(9.75F, -0.5F, -9.6679F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 37).addBox(-12.75F, -0.5F, 2.0821F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 37).addBox(11.75F, -0.5F, 2.0821F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 43).addBox(-12.0F, -0.5F, 3.0821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 43).addBox(10.0F, -0.5F, 3.0821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 42).addBox(-10.0F, -0.5F, 3.8321F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 32).addBox(8.0F, -0.5F, 3.8321F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 29).addBox(-8.0F, -0.5F, 4.4821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 24).addBox(6.0F, -0.5F, 4.4821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 21).addBox(-6.0F, -0.5F, 4.6821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 18).addBox(4.0F, -0.5F, 4.6821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 27).addBox(-4.0F, -0.5F, 5.1321F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 8).addBox(2.0F, -0.5F, 5.1321F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 34).addBox(-2.0F, -0.5F, 5.3821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 26).addBox(0.0F, -0.5F, 5.3821F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.35F, 2.5179F));

        PartDefinition note = body.addOrReplaceChild("note", CubeListBuilder.create().texOffs(27, 29).addBox(-0.5F, -2.3F, -1.6F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 27).addBox(-0.5F, -2.3F, -0.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(23, 29).addBox(-0.5F, -2.3F, 1.4F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 35).addBox(-0.5F, 0.7F, 0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 34).addBox(-0.5F, 0.7F, -2.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5507F, 2.803F, 0.1F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r1 = note.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 25).addBox(0.537F, -0.8708F, -3.3206F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.4483F, -4.5236F, -6.85F, -2.8812F, 0.9674F, -2.5523F));

        PartDefinition cube_r2 = note.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(26, 10).addBox(0.537F, -4.1748F, -2.3176F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.4483F, -4.5236F, -6.85F, -2.7503F, 0.9674F, -2.5523F));

        PartDefinition cube_r3 = note.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(26, 23).addBox(0.537F, -3.6072F, -2.4806F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.4483F, -4.5236F, -6.85F, -3.047F, 0.9674F, -2.5523F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(0.5f, 0.5f, 0.55f);
        poseStack.translate(0, 0.7f, 0);

        poseStack.pushPose();
        right_total.copyFrom(this.rightLeg);
        if (this.crouching) {
            poseStack.translate(0, 0.05, 0.2);
        }
        right_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        poseStack.pushPose();
        left_total.copyFrom(this.leftLeg);
        if (this.crouching) {
            poseStack.translate(0, 0.05, 0.2);
        }
        left_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        poseStack.pushPose();
        body_total.copyFrom(this.body);
        if (this.crouching) {
            poseStack.translate(0, 0.05, 0.25);
        }
        body_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        poseStack.popPose();
    }
}