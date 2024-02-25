package tech.lq0.dreamaticvoyage.models.armor;// Made with Blockbench 4.9.4
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
public class MaidCostumeModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "maid_costume_model"), "main");
    public final ModelPart armorBody;
    public final ModelPart armorRightArm;
    public final ModelPart armorLeftArm;

    public MaidCostumeModel(ModelPart root) {
        this.armorBody = root.getChild("armorBody");
        this.armorRightArm = root.getChild("armorRightArm");
        this.armorLeftArm = root.getChild("armorLeftArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = armorBody.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition ling = body.addOrReplaceChild("ling", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition middle = body.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition up = body.addOrReplaceChild("up", CubeListBuilder.create().texOffs(24, 12).addBox(-4.1F, -10.0F, -2.7F, 8.2F, 5.0F, 5.2F, new CubeDeformation(0.0F))
                .texOffs(88, 19).addBox(-4.55F, -12.0F, -2.1F, 1.05F, 6.8F, 4.2F, new CubeDeformation(0.0F))
                .texOffs(78, 19).addBox(3.5F, -12.0F, -2.1F, 1.05F, 6.8F, 4.2F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = up.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(70, 13).addBox(0.75F, 0.725F, -0.05F, 0.5F, 0.55F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(70, 13).addBox(-0.25F, -0.275F, -0.05F, 0.5F, 0.55F, 0.1F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.875F, -2.75F, 0.0F, 0.0F, 0.7854F));

        PartDefinition ling2 = body.addOrReplaceChild("ling2", CubeListBuilder.create().texOffs(28, 10).addBox(-2.0F, -13.0F, -2.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 22).addBox(-2.0F, -14.0F, 1.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = ling2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(47, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0305F, -13.1176F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r3 = ling2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(48, 24).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0305F, -13.1176F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition outer = body.addOrReplaceChild("outer", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 0.0F));

        PartDefinition outer1 = outer.addOrReplaceChild("outer1", CubeListBuilder.create().texOffs(44, 57).addBox(3.0F, -12.0F, -2.95F, 1.0F, 7.0F, 1.2F, new CubeDeformation(0.0F))
                .texOffs(69, 57).addBox(-4.5F, -5.0F, -2.95F, 9.0F, 2.0F, 5.7F, new CubeDeformation(0.0F))
                .texOffs(70, 34).addBox(3.0F, -12.25F, -2.95F, 1.0F, 0.25F, 5.7F, new CubeDeformation(0.0F))
                .texOffs(59, 59).addBox(3.0F, -12.0F, 1.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition huabian = outer1.addOrReplaceChild("huabian", CubeListBuilder.create().texOffs(24, 38).addBox(1.0F, -1.5F, 0.0F, 0.9F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(39, 25).addBox(1.0F, 0.0F, 0.0F, 0.8F, 0.85F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(1, 75).addBox(1.0F, -3.2F, 0.0F, 1.0F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(32, 28).addBox(1.0F, -4.8F, 0.0F, 1.15F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(27, 27).addBox(1.0F, -6.45F, 0.0F, 1.3F, 0.9F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(1.4F, -6.65F, 0.0F, 0.95F, 0.2F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(39, 10).addBox(1.0F, -2.35F, 0.25F, 0.75F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(40, 0).addBox(1.0F, -0.65F, 0.25F, 0.65F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(34, 28).addBox(1.0F, -4.05F, 0.25F, 0.85F, 1.05F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(38, 11).addBox(1.0F, -5.55F, 0.25F, 0.95F, 0.85F, 0.25F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -5.8F, -3.15F));

        PartDefinition cube_r4 = huabian.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.025F, -0.025F, -0.425F, 1.55F, 0.45F, 0.35F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5366F, -6.5284F, 0.425F, -1.5708F, 0.0F, -1.3963F));

        PartDefinition cube_r5 = huabian.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 29).addBox(-0.475F, 2.8F, -0.125F, 1.85F, 1.0F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(11, 75).addBox(-0.475F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4739F, -6.3292F, 6.35F, -1.5708F, 0.0F, -0.5236F));

        PartDefinition cube_r6 = huabian.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 28).addBox(-0.625F, -2.375F, -0.325F, 2.15F, 1.3F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(38, 86).addBox(-0.425F, -0.375F, -0.325F, 1.65F, 0.8F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5306F, -6.381F, 0.425F, -1.5708F, 0.0F, -0.5236F));

        PartDefinition cube_r7 = huabian.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.875F, -6.55F, 0.125F, 0.0F, 0.0F, -0.5236F));

        PartDefinition bone = huabian.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(0.9F, -4.15F, 5.4F, 0.95F, 0.2F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(26, 16).addBox(0.5F, -3.95F, 5.4F, 1.3F, 0.9F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(37, 10).addBox(0.5F, -3.05F, 5.15F, 0.95F, 0.85F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(36, 79).addBox(0.5F, -2.3F, 5.4F, 1.15F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(47, 88).addBox(0.5F, -1.55F, 5.15F, 1.2F, 1.05F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(11, 104).addBox(0.5F, -0.7F, 5.4F, 1.0F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(33, 38).addBox(0.5F, 0.15F, 5.15F, 0.75F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(40, 3).addBox(0.5F, 1.85F, 5.15F, 0.65F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(14, 37).addBox(0.5F, 1.0F, 5.4F, 0.9F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(32, 79).addBox(0.5F, 2.5F, 5.4F, 0.8F, 0.85F, 0.25F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -2.5F, 0.45F));

        PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.025F, -0.025F, 0.075F, 1.55F, 0.45F, 0.35F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0366F, -4.0284F, 5.225F, 1.5708F, 0.0F, -1.3963F));

        PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.375F, -4.05F, 5.525F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r10 = bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(18, 97).addBox(-0.425F, -0.375F, 0.075F, 1.65F, 0.8F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(73, 51).addBox(-0.625F, -2.375F, 0.075F, 2.15F, 1.3F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0306F, -3.881F, 5.225F, 1.5708F, 0.0F, -0.5236F));

        PartDefinition cube_r11 = bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(12, 30).addBox(-0.475F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9739F, -3.8292F, -0.7F, 1.5708F, 0.0F, -0.5236F));

        PartDefinition outer2 = outer.addOrReplaceChild("outer2", CubeListBuilder.create().texOffs(56, 18).addBox(-4.0F, -12.0F, -2.95F, 1.0F, 7.0F, 1.2F, new CubeDeformation(0.0F))
                .texOffs(20, 10).addBox(-4.0F, -12.25F, -2.95F, 1.0F, 0.25F, 5.7F, new CubeDeformation(0.0F))
                .texOffs(58, 26).addBox(-4.0F, -12.0F, 1.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition huabian2 = outer2.addOrReplaceChild("huabian2", CubeListBuilder.create().texOffs(14, 36).addBox(-1.9F, -1.5F, 0.0F, 0.9F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(25, 39).addBox(-1.8F, 0.0F, 0.0F, 0.8F, 0.85F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(32, 30).addBox(-2.0F, -3.2F, 0.0F, 1.0F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(1, 77).addBox(-2.15F, -4.8F, 0.0F, 1.15F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(19, 25).addBox(-2.3F, -6.45F, 0.0F, 1.3F, 0.9F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.35F, -6.65F, 0.0F, 0.95F, 0.2F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(31, 38).addBox(-1.75F, -2.35F, 0.25F, 0.75F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(33, 39).addBox(-1.65F, -0.65F, 0.25F, 0.65F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(43, 81).addBox(-1.85F, -4.05F, 0.25F, 0.85F, 1.05F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(14, 35).addBox(-1.95F, -5.55F, 0.25F, 0.95F, 0.85F, 0.25F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -5.8F, -3.15F));

        PartDefinition cube_r12 = huabian2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-0.525F, -0.025F, -0.425F, 1.55F, 0.45F, 0.35F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5366F, -6.5284F, 0.425F, -1.5708F, 0.0F, 1.3963F));

        PartDefinition cube_r13 = huabian2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(42, 77).addBox(-1.375F, 2.8F, -0.125F, 1.85F, 1.0F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-1.175F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4739F, -6.3292F, 6.35F, -1.5708F, 0.0F, 0.5236F));

        PartDefinition cube_r14 = huabian2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(24, 22).addBox(-1.525F, -2.375F, -0.325F, 2.15F, 1.3F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(52, 85).addBox(-1.225F, -0.375F, -0.325F, 1.65F, 0.8F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5306F, -6.381F, 0.425F, -1.5708F, 0.0F, 0.5236F));

        PartDefinition cube_r15 = huabian2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.875F, -6.55F, 0.125F, 0.0F, 0.0F, 0.5236F));

        PartDefinition bone2 = huabian2.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.85F, -4.15F, 5.4F, 0.95F, 0.2F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(3, 0).addBox(-1.8F, -3.95F, 5.4F, 1.3F, 0.9F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(34, 30).addBox(-1.45F, -3.05F, 5.15F, 0.95F, 0.85F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(28, 28).addBox(-1.65F, -2.3F, 5.4F, 1.15F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(37, 94).addBox(-1.7F, -1.55F, 5.15F, 1.2F, 1.05F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(29, 100).addBox(-1.5F, -0.7F, 5.4F, 1.0F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(26, 38).addBox(-1.25F, 0.15F, 5.15F, 0.75F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(31, 39).addBox(-1.15F, 1.85F, 5.15F, 0.65F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(43, 75).addBox(-1.4F, 1.0F, 5.4F, 0.9F, 0.95F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(39, 22).addBox(-1.3F, 2.5F, 5.4F, 0.8F, 0.85F, 0.25F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -2.5F, 0.45F));

        PartDefinition cube_r16 = bone2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-0.525F, -0.025F, 0.075F, 1.55F, 0.45F, 0.35F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0366F, -4.0284F, 5.225F, 1.5708F, 0.0F, 1.3963F));

        PartDefinition cube_r17 = bone2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.375F, -4.05F, 5.525F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r18 = bone2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(40, 96).addBox(-1.225F, -0.375F, 0.075F, 1.65F, 0.8F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-1.525F, -2.375F, 0.075F, 2.15F, 1.3F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0306F, -3.881F, 5.225F, 1.5708F, 0.0F, 0.5236F));

        PartDefinition cube_r19 = bone2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(26, 29).addBox(-1.175F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9739F, -3.8292F, -0.7F, 1.5708F, 0.0F, 0.5236F));

        PartDefinition bone3 = body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(38, 110).addBox(3.3545F, -3.1794F, 0.1574F, 0.5591F, 4.6962F, 0.3914F, new CubeDeformation(0.0F))
                .texOffs(14, 95).addBox(3.9135F, -2.0612F, 0.1574F, 0.1677F, 2.4599F, 0.3914F, new CubeDeformation(0.0F))
                .texOffs(6, 96).addBox(2.5158F, -3.1794F, 0.1574F, 0.8386F, 6.0939F, 0.3914F, new CubeDeformation(0.0F))
                .texOffs(4, 96).addBox(-3.3545F, -3.1794F, 0.1574F, 0.8386F, 6.0939F, 0.3914F, new CubeDeformation(0.0F))
                .texOffs(8, 96).addBox(-3.9135F, -3.1794F, 0.1574F, 0.5591F, 4.6962F, 0.3914F, new CubeDeformation(0.0F))
                .texOffs(24, 73).addBox(-4.0812F, -2.0612F, 0.1574F, 0.1677F, 2.4599F, 0.3914F, new CubeDeformation(0.0F))
                .texOffs(72, 99).addBox(-2.5158F, -3.1794F, -0.0662F, 5.0317F, 6.653F, 0.3914F, new CubeDeformation(0.0F))
                .texOffs(37, 73).addBox(-1.9568F, 3.4736F, -0.0662F, 3.9135F, 0.2795F, 0.3914F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4713F, -3.9911F, -0.4014F, 0.0F, 0.0F));

        PartDefinition cube_r20 = bone3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5179F, 2.2203F, -0.0843F, 0.0F, 0.0F, 2.138F));

        PartDefinition cube_r21 = bone3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2339F, 2.4499F, -0.0843F, 0.0F, 0.0F, 2.8798F));

        PartDefinition cube_r22 = bone3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8666F, 2.4198F, -0.0843F, 0.0F, 0.0F, -2.618F));

        PartDefinition cube_r23 = bone3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6394F, 2.1178F, -0.0843F, 0.0F, 0.0F, -1.7017F));

        PartDefinition cube_r24 = bone3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7568F, 1.7529F, -0.0843F, 0.0F, 0.0F, -0.6981F));

        PartDefinition cube_r25 = bone3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0967F, 1.6193F, -0.0843F, 0.0F, 0.0F, 0.0436F));

        PartDefinition cube_r26 = bone3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4353F, 1.7346F, -0.0843F, 0.0F, 0.0F, 0.6981F));

        PartDefinition cube_r27 = bone3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(24, 77).addBox(-0.3546F, 0.141F, -0.0294F, 0.5192F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7118F, 2.2442F, -0.0843F, 0.0F, 0.0F, 1.2654F));

        PartDefinition cube_r28 = bone3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7963F, 2.4319F, -0.0843F, 0.0F, 0.0F, 0.9599F));

        PartDefinition bone5 = bone3.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7624F, 1.8269F, -0.1869F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r29 = bone5.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(18, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3477F, -0.2822F, 0.1026F, 0.0F, 0.0F, -0.6981F));

        PartDefinition cube_r30 = bone5.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(19, 74).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0091F, -0.3975F, 0.1026F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r31 = bone5.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(26, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3308F, -0.264F, 0.1026F, 0.0F, 0.0F, 0.6981F));

        PartDefinition cube_r32 = bone5.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(22, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4481F, 0.1009F, 0.1026F, 0.0F, 0.0F, 1.7017F));

        PartDefinition cube_r33 = bone5.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(24, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.221F, 0.403F, 0.1026F, 0.0F, 0.0F, 2.618F));

        PartDefinition cube_r34 = bone5.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4303F, 0.2035F, 0.1026F, 0.0F, 0.0F, -2.138F));

        PartDefinition cube_r35 = bone5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(24, 77).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1464F, 0.433F, 0.1026F, 0.0F, 0.0F, -2.8798F));

        PartDefinition huabian3 = bone3.addOrReplaceChild("huabian3", CubeListBuilder.create().texOffs(56, 107).addBox(-1.1182F, 2.8866F, -5.2802F, 1.6772F, 1.1741F, 0.2795F, new CubeDeformation(0.0F))
                .texOffs(38, 122).addBox(1.789F, 2.8866F, -5.2802F, 0.7268F, 0.8945F, 0.2795F, new CubeDeformation(0.0F))
                .texOffs(32, 121).addBox(2.5102F, 1.8859F, -5.2802F, 0.5591F, 1.3418F, 0.2795F, new CubeDeformation(0.0F))
                .texOffs(64, 99).addBox(0.3914F, 3.1662F, -5.7834F, 1.5654F, 1.1182F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.587F, 5.5495F));

        PartDefinition cube_r36 = huabian3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(61, 119).addBox(0.8945F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5988F, -1.1892F, -5.5318F, 0.0F, 0.0F, -1.7017F));

        PartDefinition cube_r37 = huabian3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(24, 119).addBox(-0.6709F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5988F, -1.1892F, -5.5318F, 0.0F, 0.0F, -1.4399F));

        PartDefinition cube_r38 = huabian3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(55, 115).addBox(-0.3914F, -0.8386F, -0.2516F, 1.1181F, 1.2182F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2434F, 0.8677F, -5.5318F, 0.0F, 0.0F, -1.2654F));

        PartDefinition cube_r39 = huabian3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(56, 104).addBox(-1.0063F, -1.0063F, -0.3634F, 1.3418F, 1.3536F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6899F, 2.6071F, -5.42F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r40 = huabian3.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(69, 102).addBox(-0.2795F, -0.1118F, -0.1398F, 0.5591F, 0.7827F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7926F, 3.1091F, -5.1405F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r41 = huabian3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(69, 92).addBox(-0.5311F, -1.7331F, -0.1398F, 0.7268F, 0.8945F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1577F, -1.9105F, -5.1405F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r42 = huabian3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(26, 121).addBox(-0.5311F, -0.3354F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1577F, -1.9105F, -5.1405F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r43 = huabian3.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(68, 80).addBox(-0.5311F, -0.1677F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1473F, -0.5084F, -5.1405F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r44 = huabian3.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(59, 104).addBox(-0.4752F, -1.0063F, -0.1398F, 0.8386F, 1.4536F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5501F, 1.9362F, -5.1405F, 0.0F, 0.0F, 0.2618F));

        PartDefinition bone4 = huabian3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(63, 101).addBox(-1.9568F, 3.1662F, -5.7834F, 1.5654F, 1.1182F, 0.5032F, new CubeDeformation(0.0F))
                .texOffs(30, 121).addBox(-3.0693F, 1.8859F, -5.2802F, 0.5591F, 1.3418F, 0.2795F, new CubeDeformation(0.0F))
                .texOffs(69, 90).addBox(-2.5158F, 2.8866F, -5.2802F, 0.7268F, 0.8945F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r45 = bone4.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(52, 107).addBox(-0.3634F, -1.0063F, -0.1398F, 0.8386F, 1.4536F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5501F, 1.9362F, -5.1405F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r46 = bone4.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(68, 79).addBox(-0.3075F, -0.1677F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1473F, -0.5084F, -5.1405F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r47 = bone4.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(68, 78).addBox(-0.3075F, -0.3354F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1577F, -1.9105F, -5.1405F, 0.0F, 0.0F, 0.0436F));

        PartDefinition cube_r48 = bone4.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(69, 91).addBox(-0.1957F, -1.7331F, -0.1398F, 0.7268F, 0.8945F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1577F, -1.9105F, -5.1405F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r49 = bone4.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(69, 99).addBox(-0.2795F, -0.1118F, -0.1398F, 0.5591F, 0.7827F, 0.2795F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7926F, 3.1091F, -5.1405F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r50 = bone4.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(36, 107).addBox(-0.3354F, -1.0063F, -0.3634F, 1.3418F, 1.3536F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6899F, 2.6071F, -5.42F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r51 = bone4.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(49, 115).addBox(-0.7268F, -0.8386F, -0.2516F, 1.1181F, 1.2182F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2434F, 0.8677F, -5.5318F, 0.0F, 0.0F, 1.2654F));

        PartDefinition cube_r52 = bone4.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(33, 118).addBox(-0.3354F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5988F, -1.1892F, -5.5318F, 0.0F, 0.0F, 1.4399F));

        PartDefinition cube_r53 = bone4.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(30, 119).addBox(-1.9009F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5988F, -1.1892F, -5.5318F, 0.0F, 0.0F, 1.7017F));

        PartDefinition dress = body.addOrReplaceChild("dress", CubeListBuilder.create().texOffs(3, 70).addBox(-4.6F, -3.3F, -2.6F, 9.2F, 1.3F, 1.1F, new CubeDeformation(0.0F))
                .texOffs(75, 4).addBox(-4.6F, -3.3F, 1.5F, 9.2F, 1.3F, 1.1F, new CubeDeformation(0.0F))
                .texOffs(87, 43).addBox(3.5F, -3.3F, -2.0F, 1.1F, 1.3F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 0).addBox(-4.6F, -3.3F, -2.0F, 1.1F, 1.3F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r54 = dress.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(14, 53).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(17, 61).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.7F, -2.0F, -0.2618F, 0.0F, -0.2618F));

        PartDefinition cube_r55 = dress.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(61, 0).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 54).addBox(-0.5F, -2.0F, -1.5F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.7F, 2.0F, 0.2618F, 0.0F, -0.2618F));

        PartDefinition cube_r56 = dress.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(55, 6).addBox(-0.5F, -2.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 63).addBox(-0.5F, -2.0F, -1.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.7F, 2.0F, 0.2618F, 0.0F, 0.2618F));

        PartDefinition cube_r57 = dress.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(8, 53).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 62).addBox(0.5F, -2.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.7F, -2.0F, -0.2618F, 0.0F, 0.2618F));

        PartDefinition cube_r58 = dress.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(13, 61).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 61).addBox(-0.5F, -1.5F, 2.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9115F, 1.1533F, -1.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r59 = dress.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(20, 54).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0706F, 1.0212F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r60 = dress.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(62, 26).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 62).addBox(-0.5F, -1.5F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9115F, 1.1533F, 1.5F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r61 = dress.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(54, 52).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0706F, 1.0212F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r62 = dress.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(5, 61).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 63).addBox(-8.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.2634F, 2.7364F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r63 = dress.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(60, 12).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 60).addBox(-6.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.1533F, 2.9115F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r64 = dress.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(72, 42).addBox(-2.5F, -1.5F, -0.75F, 5.0F, 6.6F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9727F, 3.1197F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r65 = dress.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(60, 49).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 19).addBox(5.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.1533F, -2.9115F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r66 = dress.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(61, 40).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(61, 33).addBox(7.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.2634F, -2.7364F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r67 = dress.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 33).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 6.6F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9727F, -3.1197F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r68 = dress.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(46, 18).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2418F, -1.1635F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r69 = dress.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(47, 38).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2418F, -1.1635F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r70 = dress.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(21, 0).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.1635F, 2.2418F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r71 = dress.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.1635F, -2.2418F, -0.2618F, 0.0F, 0.0F));

        PartDefinition bone6 = dress.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(-4.5F, 1.7F, -2.0F));

        PartDefinition cube_r72 = bone6.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(108, 66).addBox(-0.475F, -1.9F, -0.475F, 0.95F, 5.7F, 1.9F, new CubeDeformation(0.0F))
                .texOffs(117, 45).addBox(0.475F, -1.9F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.225F, 0.815F, 0.1F, -0.2618F, 0.0F, 0.2618F));

        PartDefinition cube_r73 = bone6.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(101, 89).addBox(-0.475F, -1.9F, -0.475F, 1.9F, 5.7F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(117, 38).addBox(-0.475F, -1.9F, -1.425F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.225F, 0.815F, 3.9F, 0.2618F, 0.0F, 0.2618F));

        PartDefinition cube_r74 = bone6.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(117, 78).addBox(-1.425F, -1.9F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(79, 87).addBox(-0.475F, -1.9F, -1.425F, 0.95F, 5.7F, 1.9F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.775F, 0.815F, 3.9F, 0.2618F, 0.0F, -0.2618F));

        PartDefinition cube_r75 = bone6.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(85, 87).addBox(-0.475F, -1.9F, -0.475F, 0.95F, 5.7F, 1.9F, new CubeDeformation(0.0F))
                .texOffs(94, 96).addBox(-1.425F, -1.9F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.775F, 0.815F, 0.1F, -0.2618F, 0.0F, -0.2618F));

        PartDefinition cube_r76 = bone6.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(66, 70).addBox(-2.375F, -1.425F, -0.475F, 4.75F, 6.27F, 1.1875F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.124F, -0.9637F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r77 = bone6.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(89, 67).addBox(-2.375F, -1.425F, -0.7125F, 4.75F, 6.27F, 1.1875F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.124F, 4.9637F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r78 = bone6.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(116, 94).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(86, 95).addBox(-6.175F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.35F, 0.2956F, 4.7659F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r79 = bone6.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(118, 71).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(100, 96).addBox(-8.075F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3F, 0.4002F, 4.5996F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r80 = bone6.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(112, 100).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(120, 84).addBox(-0.475F, -1.425F, -3.325F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1659F, 0.2956F, 3.425F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r81 = bone6.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(108, 74).addBox(-0.475F, -1.425F, -0.95F, 0.95F, 5.7F, 1.9F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3171F, 0.1701F, 2.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r82 = bone6.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(118, 64).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(118, 52).addBox(-8.075F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3F, 0.4002F, -0.5996F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r83 = bone6.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(116, 87).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(90, 95).addBox(-6.175F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.35F, 0.2956F, -0.7659F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r84 = bone6.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(120, 32).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F))
                .texOffs(104, 98).addBox(-0.475F, -1.425F, 2.375F, 0.95F, 5.7F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1659F, 0.2956F, 0.575F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r85 = bone6.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(91, 87).addBox(-0.475F, -1.425F, -0.95F, 0.95F, 5.7F, 1.9F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3171F, 0.1701F, 2.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition outer_dress = body.addOrReplaceChild("outer_dress", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tie = body.addOrReplaceChild("tie", CubeListBuilder.create().texOffs(85, 36).addBox(-0.5F, -11.5F, -3.3F, 1.0F, 1.0F, 1.05F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r86 = tie.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(70, 8).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.933F, -9.384F, -2.75F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r87 = tie.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(96, 13).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.933F, -9.384F, -2.75F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r88 = tie.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(70, 29).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -11.0F, -2.75F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r89 = tie.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(70, 25).addBox(-1.15F, -0.5F, -0.5F, 2.15F, 0.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8165F, -10.4495F, -2.75F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r90 = tie.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(70, 27).addBox(-1.15F, -0.5F, -0.5F, 2.15F, 0.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9614F, -10.4107F, -2.75F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r91 = tie.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(92, 35).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -11.0F, -2.75F, 0.0F, 0.0F, 0.1309F));

        PartDefinition armorRightArm = partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create(), PartPose.offset(-4.0F, 2.0F, 0.0F));

        PartDefinition right = armorRightArm.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(5.0F, 10.0F, 0.0F));

        PartDefinition rightup = right.addOrReplaceChild("rightup", CubeListBuilder.create().texOffs(0, 28).addBox(-8.0F, -12.25F, -2.0F, 4.0F, 0.5F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 45).addBox(-8.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 45).addBox(-4.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 50).addBox(-4.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(28, 50).addBox(-8.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r92 = rightup.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(51, 1).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -6.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r93 = rightup.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(44, 52).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -6.0F, -2.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r94 = rightup.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(41, 42).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -10.0F, -2.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r95 = rightup.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(45, 5).addBox(-0.4F, -2.0F, -2.0F, 0.9F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -10.0F, 2.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition armorLeftArm = partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create(), PartPose.offset(4.0F, 2.0F, 0.0F));

        PartDefinition left = armorLeftArm.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(-5.0F, 10.0F, 0.0F));

        PartDefinition leftup = left.addOrReplaceChild("leftup", CubeListBuilder.create().texOffs(26, 5).addBox(4.0F, -12.25F, -2.0F, 4.0F, 0.5F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(31, 42).addBox(7.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 1).addBox(3.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 49).addBox(3.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(47, 31).addBox(7.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r96 = leftup.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(22, 49).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -6.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r97 = leftup.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(50, 13).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -6.0F, -2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r98 = leftup.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(25, 38).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -10.0F, -2.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r99 = leftup.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(0, 41).addBox(-0.5F, -2.0F, -2.0F, 0.9F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -10.0F, 2.25F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        armorRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        armorLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}