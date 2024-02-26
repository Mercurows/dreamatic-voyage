package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.0
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
public class KeroroIdolChestplateModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "keroro_idol_chestplate_model"), "main");
    public final ModelPart body_total;
    public final ModelPart right_total;
    public final ModelPart left_total;

    public KeroroIdolChestplateModel(ModelPart root) {
        this.body_total = root.getChild("body_total");
        this.right_total = root.getChild("right_total");
        this.left_total = root.getChild("left_total");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body_total = partdefinition.addOrReplaceChild("body_total", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tie = body_total.addOrReplaceChild("tie", CubeListBuilder.create().texOffs(4, 62).addBox(-0.5F, -12.0F, -3.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 57).addBox(-1.0F, -13.0F, -3.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r1 = tie.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 42).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -2.75F, 0.0F, 0.0F, 0.7854F));

        PartDefinition outer_dress = body_total.addOrReplaceChild("outer_dress", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition outer_dress1 = outer_dress.addOrReplaceChild("outer_dress1", CubeListBuilder.create().texOffs(30, 23).addBox(-1.0F, -3.25F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 25).addBox(4.25F, -3.25F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 46).addBox(4.25F, -2.75F, 1.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(4.5F, 0.0F, 2.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = outer_dress1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 38).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7362F, 9.3282F, 4.4571F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r3 = outer_dress1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 5).addBox(-1.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4579F, 6.5029F, 4.9571F, -0.5873F, -0.402F, 1.0394F));

        PartDefinition cube_r4 = outer_dress1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 16).addBox(-0.7414F, 0.1193F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6141F, 6.2784F, 4.4571F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r5 = outer_dress1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(15, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4278F, 6.6548F, 3.25F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r6 = outer_dress1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 60).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 6.0692F, 5.0591F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r7 = outer_dress1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(33, 7).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8414F, 1.7991F, 1.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r8 = outer_dress1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(49, 66).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 5.2907F, 6.7198F, 0.6981F, 0.0F, 0.0F));

        PartDefinition cube_r9 = outer_dress1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(39, 67).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 4.3367F, 7.0382F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r10 = outer_dress1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(43, 66).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.5175F, 6.4646F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r11 = outer_dress1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(34, 28).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0098F, 4.2617F, 3.25F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r12 = outer_dress1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(50, 60).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0098F, 3.2617F, 3.25F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r13 = outer_dress1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 62).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4324F, 8.1227F, 3.4924F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r14 = outer_dress1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(38, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7453F, 6.4883F, 3.4924F, 0.0F, 0.0F, -0.6981F));

        PartDefinition cube_r15 = outer_dress1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(22, 44).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4773F, 4.5454F, 3.4924F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r16 = outer_dress1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 62).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7622F, 3.054F, 2.5F, 0.0F, 0.0F, -0.6545F));

        PartDefinition cube_r17 = outer_dress1.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(28, 46).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2273F, 0.6564F, 2.5F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r18 = outer_dress1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(62, 12).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0513F, 0.7922F, 1.5F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r19 = outer_dress1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 36).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0788F, 0.1802F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r20 = outer_dress1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 36).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0149F, -0.4102F, 1.5F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r21 = outer_dress1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(56, 48).addBox(-3.0F, -1.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.5939F, 2.9053F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r22 = outer_dress1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(67, 49).addBox(-5.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 60).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.3981F, 3.4959F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r23 = outer_dress1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(16, 60).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 2.4168F, 4.7772F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r24 = outer_dress1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(11, 67).addBox(-4.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 2.0411F, 4.3512F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r25 = outer_dress1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(49, 0).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-2.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 1.8304F, 4.8301F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r26 = outer_dress1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(61, 35).addBox(-1.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 2.3977F, 4.9831F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r27 = outer_dress1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(16, 36).addBox(-0.6559F, -2.6343F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6141F, 6.2784F, 4.4571F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r28 = outer_dress1.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(16, 36).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 2.7394F, 4.1443F, 0.2182F, 0.0F, 0.0F));

        PartDefinition bow = outer_dress.addOrReplaceChild("bow", CubeListBuilder.create(), PartPose.offsetAndRotation(1.25F, -3.2784F, -3.0417F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r29 = bow.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(26, 40).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4716F, -0.2083F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r30 = bow.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 26).addBox(0.0441F, -1.302F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.8085F, 0.0417F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r31 = bow.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(35, 14).addBox(-1.0441F, -1.302F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.8085F, 0.0417F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r32 = bow.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(32, 38).addBox(-1.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0284F, 0.0417F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r33 = bow.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(56, 45).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0284F, 0.0417F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r34 = bow.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, -0.5F, -0.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9716F, 0.0417F, 0.0F, -0.2182F, 0.0F));

        PartDefinition bow2 = outer_dress.addOrReplaceChild("bow2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.25F, -2.6786F, -0.25F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r35 = bow2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(68, 54).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3214F, 0.5F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r36 = bow2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(68, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3214F, -0.5F, -0.8727F, 0.0F, 0.0F));

        PartDefinition dress = body_total.addOrReplaceChild("dress", CubeListBuilder.create().texOffs(14, 18).addBox(-4.5F, -3.0F, -2.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 13).addBox(-4.5F, -3.0F, 1.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 57).addBox(3.5F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(58, 7).addBox(-4.5F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 11).addBox(-4.5F, -0.327F, -2.9836F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 9).addBox(-4.5F, -0.327F, 1.9836F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 57).addBox(3.9836F, -0.327F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 57).addBox(-4.9836F, -0.327F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(62, 59).addBox(-5.0F, 0.5F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 62).addBox(-5.0F, 0.5F, 1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 62).addBox(4.0F, 0.5F, 1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 27).addBox(4.0F, 0.5F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r37 = dress.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(24, 62).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 62).addBox(-0.5F, -1.5F, 2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9115F, 1.9533F, -1.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r38 = dress.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(58, 53).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0706F, 1.8212F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r39 = dress.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(64, 39).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 53).addBox(-0.5F, -1.5F, -3.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9115F, 1.9533F, 1.5F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r40 = dress.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(30, 60).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0706F, 1.8212F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r41 = dress.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(53, 65).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(61, 64).addBox(-8.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0634F, 2.7364F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r42 = dress.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(65, 44).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 34).addBox(-6.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.9533F, 2.9115F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r43 = dress.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(42, 42).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7727F, 3.1197F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r44 = dress.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(65, 63).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 6).addBox(5.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.9533F, -2.9115F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r45 = dress.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(57, 65).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 66).addBox(7.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0634F, -2.7364F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r46 = dress.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(45, 19).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7727F, -3.1197F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r47 = dress.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(43, 1).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2418F, -1.1635F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r48 = dress.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(16, 44).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2418F, -1.1635F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r49 = dress.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(15, 15).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.1635F, 2.2418F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r50 = dress.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(16, 0).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.1635F, -2.2418F, -0.2618F, 0.0F, 0.0F));

        PartDefinition outer = body_total.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(41, 35).addBox(-3.0F, -10.0F, 1.75F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 58).addBox(1.0F, -7.0F, 1.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 26).addBox(-3.0F, -7.0F, 1.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition outer1 = outer.addOrReplaceChild("outer1", CubeListBuilder.create().texOffs(59, 0).addBox(2.0F, -12.0F, -2.75F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 17).addBox(1.0F, -10.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 32).addBox(4.0F, -12.0F, -1.75F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 60).addBox(3.0F, -12.0F, 1.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r51 = outer1.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(34, 13).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7418F, -5.1635F, 0.5F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r52 = outer1.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(65, 31).addBox(0.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -5.1635F, 2.4918F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r53 = outer1.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(48, 24).addBox(-0.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -5.1635F, -2.4918F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r54 = outer1.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(50, 48).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.1635F, -2.7418F, -0.2618F, 0.0F, 0.0F));

        PartDefinition outer2 = outer.addOrReplaceChild("outer2", CubeListBuilder.create().texOffs(58, 20).addBox(-5.0F, -12.0F, -2.75F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 12).addBox(-2.0F, -10.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-5.0F, -12.0F, -1.75F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 59).addBox(-5.0F, -12.0F, 1.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r55 = outer2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(27, 31).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7418F, -5.1635F, 0.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r56 = outer2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(12, 21).addBox(-2.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -5.1635F, 2.4918F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r57 = outer2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(48, 10).addBox(-2.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -5.1635F, -2.4918F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r58 = outer2.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(34, 50).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -5.1635F, -2.7418F, -0.2618F, 0.0F, 0.0F));

        PartDefinition ling2 = body_total.addOrReplaceChild("ling2", CubeListBuilder.create().texOffs(46, 40).addBox(-2.0F, -13.0F, -2.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 26).addBox(-2.0F, -14.0F, 1.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r59 = ling2.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(0, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0305F, -13.1176F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r60 = ling2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(22, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0305F, -13.1176F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition up = body_total.addOrReplaceChild("up", CubeListBuilder.create().texOffs(0, 8).addBox(-3.5F, -12.0F, -2.5F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -12.0F, 1.5F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 25).addBox(-4.5F, -12.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 25).addBox(3.5F, -12.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition upbow = up.addOrReplaceChild("upbow", CubeListBuilder.create().texOffs(33, 7).addBox(-1.0F, -8.25F, -2.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 7).addBox(-1.0F, -6.75F, -2.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition middle = body_total.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(28, 25).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 20).addBox(-4.0F, -5.0F, 1.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 35).addBox(-4.75F, -5.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(34, 28).addBox(3.75F, -5.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition ling = body_total.addOrReplaceChild("ling", CubeListBuilder.create().texOffs(0, 16).addBox(-7.0F, -13.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(15, 4).addBox(2.0F, -13.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 15).addBox(-5.75F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 24).addBox(-2.5382F, -10.9732F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 52).addBox(2.75F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 32).addBox(-0.25F, -13.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 17).addBox(-5.75F, -13.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 22).addBox(0.5382F, -10.9732F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 3).addBox(-4.0F, -12.0F, 2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 7).addBox(-3.0F, -11.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r61 = ling.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(12, 50).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0254F, -10.6488F, -2.5F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r62 = ling.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(12, 44).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.951F, -10.9115F, -2.5F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r63 = ling.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(52, 29).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0254F, -10.6488F, -2.5F, 0.0F, 0.0F, 0.7418F));

        PartDefinition cube_r64 = ling.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(12, 55).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.951F, -10.9115F, -2.5F, 0.0F, 0.0F, 0.7418F));

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(-4.0F, 2.0F, 0.0F));

        PartDefinition rightup = right_total.addOrReplaceChild("rightup", CubeListBuilder.create().texOffs(0, 21).addBox(-8.0F, -12.75F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 42).addBox(-8.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(42, 24).addBox(-4.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(56, 15).addBox(-4.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 55).addBox(-8.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 55).addBox(-8.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(28, 55).addBox(-4.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 24).addBox(-8.75F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 53).addBox(-4.25F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 10.0F, 0.0F));

        PartDefinition cube_r65 = rightup.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(34, 52).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -0.75F, 2.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r66 = rightup.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(22, 52).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 42).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -0.75F, -2.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r67 = rightup.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(16, 55).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(56, 30).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.25F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r68 = rightup.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(46, 54).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(56, 40).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.25F, -2.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(4.0F, 2.0F, 0.0F));

        PartDefinition leftup = left_total.addOrReplaceChild("leftup", CubeListBuilder.create().texOffs(14, 20).addBox(4.0F, -12.75F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(26, 38).addBox(7.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(36, 5).addBox(3.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(3.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(51, 35).addBox(7.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(50, 43).addBox(7.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 50).addBox(3.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(49, 0).addBox(7.75F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 47).addBox(3.25F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 10.0F, 0.0F));

        PartDefinition cube_r69 = leftup.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(44, 48).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 38).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -0.75F, 2.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r70 = leftup.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(6, 50).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 36).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -0.75F, -2.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r71 = leftup.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(28, 50).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 5).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.25F, 2.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r72 = leftup.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(50, 49).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 10).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.25F, -2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition huan = leftup.addOrReplaceChild("huan", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r73 = huan.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(0, 69).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.25F, -0.5F, -0.25F, -0.7854F, -0.7854F, 0.0F));

        PartDefinition cube_r74 = huan.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(22, 36).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.25F, -0.5F, -2.25F, 0.0F, 1.5708F, 0.7854F));

        PartDefinition cube_r75 = huan.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(0, 67).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.25F, -0.5F, -1.75F, -0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}