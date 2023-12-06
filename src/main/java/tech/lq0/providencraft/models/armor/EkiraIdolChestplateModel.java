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
public class EkiraIdolChestplateModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "ekira_idol_chestplate_model"), "main");
    public final ModelPart body_total;
    public final ModelPart right_total;
    public final ModelPart left_total;

    public EkiraIdolChestplateModel(ModelPart root) {
        this.body_total = root.getChild("body_total");
        this.right_total = root.getChild("right_total");
        this.left_total = root.getChild("left_total");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body_total = partdefinition.addOrReplaceChild("body_total", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tie = body_total.addOrReplaceChild("tie", CubeListBuilder.create().texOffs(16, 65).addBox(-0.5F, -12.0F, -3.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(59, 22).addBox(-1.0F, -13.0F, -3.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r1 = tie.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 42).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -2.75F, 0.0F, 0.0F, 0.7854F));

        PartDefinition outer_dress = body_total.addOrReplaceChild("outer_dress", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition outer_dress1 = outer_dress.addOrReplaceChild("outer_dress1", CubeListBuilder.create().texOffs(29, 5).addBox(1.0F, -4.25F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(59, 7).addBox(4.25F, -4.25F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 46).addBox(4.25F, -2.75F, 1.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 47).addBox(5.8458F, 8.9811F, 4.5422F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = outer_dress1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(69, 44).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7046F, 1.7044F, 4.234F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r3 = outer_dress1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 46).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8712F, 3.6823F, 5.3133F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r4 = outer_dress1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 65).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2273F, 5.3118F, 5.2601F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r5 = outer_dress1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 25).addBox(-2.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9746F, 7.6616F, 5.0422F, 0.0F, 0.0F, 1.309F));

        PartDefinition cube_r6 = outer_dress1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(69, 50).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5979F, 5.7917F, 5.0422F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r7 = outer_dress1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 65).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9492F, 8.3422F, 4.4571F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r8 = outer_dress1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(69, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0844F, 5.0246F, 4.4571F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r9 = outer_dress1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(44, 47).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6447F, 2.6105F, 3.8078F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r10 = outer_dress1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(4, 62).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0614F, 5.4398F, 3.8078F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r11 = outer_dress1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 52).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9742F, 4.6615F, 2.25F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r12 = outer_dress1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(40, 52).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9719F, 6.0076F, 2.9924F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r13 = outer_dress1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(46, 53).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2457F, 4.2441F, 2.9924F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r14 = outer_dress1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(52, 54).addBox(0.0F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.036F, 1.5834F, 2.9924F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r15 = outer_dress1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(70, 9).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9169F, 3.0452F, 2.25F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r16 = outer_dress1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(7, 70).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5177F, 2.7598F, 1.5F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r17 = outer_dress1.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(20, 65).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4773F, -0.0936F, 2.25F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r18 = outer_dress1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(62, 37).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8479F, -0.2633F, 1.5F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r19 = outer_dress1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(62, 12).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0935F, -0.4889F, 1.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r20 = outer_dress1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(35, 65).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0788F, 0.1802F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r21 = outer_dress1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(16, 60).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.5939F, 2.9053F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r22 = outer_dress1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(65, 19).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.3981F, 3.4959F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r23 = outer_dress1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(50, 48).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 2.4168F, 4.7772F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r24 = outer_dress1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(11, 70).addBox(-1.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 1.8304F, 4.8301F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r25 = outer_dress1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(64, 69).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5058F, 3.883F, 4.4571F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r26 = outer_dress1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(55, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 2.6569F, 4.4552F, 0.4363F, 0.0F, 0.0F));

        PartDefinition outer_dress2 = outer_dress.addOrReplaceChild("outer_dress2", CubeListBuilder.create().texOffs(6, 26).addBox(-5.0F, -4.25F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 57).addBox(-5.25F, -4.25F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 36).addBox(-5.25F, -2.75F, 1.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 50).addBox(-6.8458F, 8.9811F, 4.5422F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r27 = outer_dress2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(56, 40).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7046F, 1.7044F, 4.234F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r28 = outer_dress2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8712F, 3.6823F, 5.3133F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r29 = outer_dress2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(34, 28).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2273F, 5.3118F, 5.2601F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r30 = outer_dress2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(46, 40).addBox(-1.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9746F, 7.6616F, 5.0422F, 0.0F, 0.0F, -1.309F));

        PartDefinition cube_r31 = outer_dress2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(58, 55).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5979F, 5.7917F, 5.0422F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r32 = outer_dress2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(62, 24).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9492F, 8.3422F, 4.4571F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r33 = outer_dress2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0844F, 5.0246F, 4.4571F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r34 = outer_dress2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 21).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6447F, 2.6105F, 3.8078F, 0.0F, 0.0F, 0.7418F));

        PartDefinition cube_r35 = outer_dress2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 36).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0614F, 5.4398F, 3.8078F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r36 = outer_dress2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 26).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9742F, 4.6615F, 2.25F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r37 = outer_dress2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(35, 14).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9719F, 6.0076F, 2.9924F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r38 = outer_dress2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(16, 36).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2457F, 4.2441F, 2.9924F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r39 = outer_dress2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(38, 42).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.036F, 1.5834F, 2.9924F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r40 = outer_dress2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(4, 68).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9169F, 3.0452F, 2.25F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r41 = outer_dress2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(68, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5177F, 2.7598F, 1.5F, 0.0F, 0.0F, 0.5672F));

        PartDefinition cube_r42 = outer_dress2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(62, 55).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4773F, -0.0936F, 2.25F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r43 = outer_dress2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(58, 60).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8479F, -0.2633F, 1.5F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r44 = outer_dress2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 62).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0935F, -0.4889F, 1.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r45 = outer_dress2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(62, 60).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0788F, 0.1802F, 0.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r46 = outer_dress2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(8, 60).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.5939F, 2.9053F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r47 = outer_dress2.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(63, 29).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.3981F, 3.4959F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r48 = outer_dress2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(22, 44).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 2.4168F, 4.7772F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r49 = outer_dress2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(69, 19).addBox(0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 1.8304F, 4.8301F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r50 = outer_dress2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(69, 22).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5058F, 3.883F, 4.4571F, 0.0F, 0.0F, 0.7418F));

        PartDefinition cube_r51 = outer_dress2.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 46).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 2.6569F, 4.4552F, 0.4363F, 0.0F, 0.0F));

        PartDefinition bow = outer_dress.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(22, 57).addBox(-2.0F, -1.4716F, -0.4583F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.2784F, -3.0417F, -0.2618F, 0.0F, 0.3054F));

        PartDefinition cube_r52 = bow.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(26, 40).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4716F, -0.2083F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r53 = bow.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(49, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 1.2784F, 0.0417F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r54 = bow.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(34, 50).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 1.2784F, 0.0417F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r55 = bow.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(32, 38).addBox(-1.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0284F, 0.0417F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r56 = bow.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(59, 20).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0284F, 0.0417F, 0.0F, 0.0F, -0.3927F));

        PartDefinition dress = body_total.addOrReplaceChild("dress", CubeListBuilder.create().texOffs(14, 18).addBox(-4.5F, -3.0F, -2.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 13).addBox(-4.5F, -3.0F, 1.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 45).addBox(3.5F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(56, 50).addBox(-4.5F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 11).addBox(-4.5F, -0.327F, -2.9836F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 9).addBox(-4.5F, -0.327F, 1.9836F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 40).addBox(3.9836F, -0.327F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(56, 15).addBox(-4.9836F, -0.327F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(65, 64).addBox(-5.0F, 0.5F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(61, 65).addBox(-5.0F, 0.5F, 1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 49).addBox(4.0F, 0.5F, 1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 44).addBox(4.0F, 0.5F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r57 = dress.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(43, 65).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 65).addBox(-0.5F, -1.5F, 2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9115F, 1.9533F, -1.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r58 = dress.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(30, 60).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0706F, 1.8212F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r59 = dress.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(66, 11).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 24).addBox(-0.5F, -1.5F, -3.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9115F, 1.9533F, 1.5F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r60 = dress.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(52, 60).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0706F, 1.8212F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r61 = dress.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(51, 66).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 66).addBox(-8.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0634F, 2.7364F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r62 = dress.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(47, 66).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 36).addBox(-6.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.9533F, 2.9115F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r63 = dress.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(42, 42).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7727F, 3.1197F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r64 = dress.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(55, 66).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 59).addBox(5.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.9533F, -2.9115F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r65 = dress.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(66, 54).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(67, 0).addBox(7.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0634F, -2.7364F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r66 = dress.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(45, 19).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7727F, -3.1197F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r67 = dress.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(43, 1).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2418F, -1.1635F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r68 = dress.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(16, 44).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2418F, -1.1635F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r69 = dress.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(15, 15).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.1635F, 2.2418F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r70 = dress.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(16, 0).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.1635F, -2.2418F, -0.2618F, 0.0F, 0.0F));

        PartDefinition outer = body_total.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(41, 35).addBox(-3.0F, -10.0F, 1.75F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 42).addBox(1.0F, -7.0F, 1.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 17).addBox(-3.0F, -7.0F, 1.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition outer1 = outer.addOrReplaceChild("outer1", CubeListBuilder.create().texOffs(59, 0).addBox(2.0F, -12.0F, -2.75F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 67).addBox(1.0F, -10.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 32).addBox(4.0F, -12.0F, -1.75F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 60).addBox(3.0F, -12.0F, 1.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r71 = outer1.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(34, 13).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7418F, -5.1635F, 0.5F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r72 = outer1.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(12, 55).addBox(0.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -5.1635F, 2.4918F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r73 = outer1.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(48, 10).addBox(-0.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -5.1635F, -2.4918F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r74 = outer1.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(15, 70).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.1635F, -2.7418F, -0.2618F, 0.0F, 0.0F));

        PartDefinition outer2 = outer.addOrReplaceChild("outer2", CubeListBuilder.create().texOffs(38, 58).addBox(-5.0F, -12.0F, -2.75F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(67, 5).addBox(-2.0F, -10.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-5.0F, -12.0F, -1.75F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 59).addBox(-5.0F, -12.0F, 1.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r75 = outer2.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(27, 31).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7418F, -5.1635F, 0.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r76 = outer2.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(12, 21).addBox(-2.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -5.1635F, 2.4918F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r77 = outer2.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(18, 25).addBox(-2.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -5.1635F, -2.4918F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r78 = outer2.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(70, 12).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -5.1635F, -2.7418F, -0.2618F, 0.0F, 0.0F));

        PartDefinition ling2 = body_total.addOrReplaceChild("ling2", CubeListBuilder.create().texOffs(57, 35).addBox(-2.0F, -13.5F, -2.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(-2.0F, -14.0F, 1.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r79 = ling2.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(0, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0305F, -13.1176F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r80 = ling2.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(22, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0305F, -13.1176F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition up = body_total.addOrReplaceChild("up", CubeListBuilder.create().texOffs(0, 8).addBox(-3.5F, -12.0F, -2.5F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -12.0F, 1.5F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 25).addBox(-4.5F, -12.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 25).addBox(3.5F, -12.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition middle = body_total.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(28, 25).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 20).addBox(-4.0F, -5.0F, 1.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 35).addBox(-4.75F, -5.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(34, 28).addBox(3.75F, -5.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition ling = body_total.addOrReplaceChild("ling", CubeListBuilder.create().texOffs(0, 16).addBox(-7.0F, -13.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(15, 4).addBox(2.0F, -13.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 50).addBox(-5.75F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(67, 29).addBox(-2.5382F, -10.9732F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 33).addBox(2.75F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 17).addBox(-0.25F, -13.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 7).addBox(-5.75F, -13.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 33).addBox(0.5382F, -10.9732F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 3).addBox(-4.0F, -12.0F, 2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 23).addBox(-3.0F, -11.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r81 = ling.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(12, 44).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0254F, -10.6488F, -2.5F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r82 = ling.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(22, 38).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.951F, -10.9115F, -2.5F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r83 = ling.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(12, 52).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0254F, -10.6488F, -2.5F, 0.0F, 0.0F, 0.7418F));

        PartDefinition cube_r84 = ling.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(52, 15).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.951F, -10.9115F, -2.5F, 0.0F, 0.0F, 0.7418F));

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(-4.0F, 2.0F, 0.0F));

        PartDefinition rightup = right_total.addOrReplaceChild("rightup", CubeListBuilder.create().texOffs(0, 21).addBox(-8.0F, -12.75F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 42).addBox(-8.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(42, 24).addBox(-4.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 55).addBox(-4.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 55).addBox(-8.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(54, 25).addBox(-8.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 54).addBox(-4.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 52).addBox(-8.75F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(53, 20).addBox(-4.25F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 10.0F, 0.0F));

        PartDefinition cube_r85 = rightup.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(34, 52).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -0.75F, 2.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r86 = rightup.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(52, 10).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 42).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -0.75F, -2.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r87 = rightup.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(54, 30).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(28, 55).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.25F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r88 = rightup.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(40, 53).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 55).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.25F, -2.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(4.0F, 2.0F, 0.0F));

        PartDefinition leftup = left_total.addOrReplaceChild("leftup", CubeListBuilder.create().texOffs(14, 20).addBox(4.0F, -12.75F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(26, 38).addBox(7.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(36, 5).addBox(3.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(51, 35).addBox(3.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(50, 49).addBox(7.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(28, 50).addBox(7.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 50).addBox(3.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 48).addBox(7.75F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 47).addBox(3.25F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 10.0F, 0.0F));

        PartDefinition cube_r89 = leftup.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(48, 28).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 38).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -0.75F, 2.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r90 = leftup.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(49, 0).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 36).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -0.75F, -2.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r91 = leftup.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(16, 50).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.25F, 2.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r92 = leftup.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(50, 43).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 5).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.25F, -2.0F, 0.0F, 1.5708F, 0.0F));

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