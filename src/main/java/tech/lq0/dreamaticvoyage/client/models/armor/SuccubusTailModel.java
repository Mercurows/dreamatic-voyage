package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.2
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
public class SuccubusTailModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "succubus_tail_model"), "main");
    public final ModelPart armorBody;

    public SuccubusTailModel(ModelPart root) {
        this.armorBody = root.getChild("armorBody");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = armorBody.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 2.0F));

        PartDefinition bone = main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(4, 0).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(21, 4).addBox(-2.4606F, -8.0F, 2.2809F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 20).addBox(-6.3934F, -4.3954F, 2.2809F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-7.8908F, -4.3954F, 3.4827F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 15).addBox(-7.8908F, -5.6615F, 4.9915F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 0).addBox(2.4377F, -9.7933F, 4.3471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 9).addBox(4.5891F, -11.5291F, 4.3471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 9).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6578F, -15.0043F, 4.8471F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9482F, -11.8279F, 4.8471F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(17, 12).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9482F, -10.2303F, 4.8471F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(13, 17).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5567F, -9.7425F, 4.8471F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7913F, -9.4057F, 4.8471F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(4, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2718F, -9.1239F, 4.8696F, 0.0F, 0.1309F, 0.0F));

        PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(18, 3).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0539F, -9.3831F, 4.8518F, 0.0302F, 0.041F, 0.1732F));

        PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 18).addBox(-0.051F, -0.583F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6913F, -9.5409F, 5.0302F, 0.0306F, 0.1719F, 0.1772F));

        PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(4, 7).addBox(-1.949F, -0.583F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6913F, -9.5409F, 5.0302F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r10 = bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 18).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0891F, -9.6258F, 5.4915F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r11 = bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(8, 0).addBox(2.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.414F, -8.5746F, 5.4915F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r12 = bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(19, 6).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2346F, -8.9135F, 5.4915F, 0.0F, 0.0F, 1.0036F));

        PartDefinition cube_r13 = bone.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(7, 19).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9249F, -8.3595F, 5.4915F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r14 = bone.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(10, 11).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.949F, -6.8104F, 5.4915F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r15 = bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(13, 19).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9249F, -5.4027F, 4.9915F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r16 = bone.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(19, 17).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8908F, -3.8954F, 5.3488F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r17 = bone.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(19, 19).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8908F, -3.3954F, 4.4827F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r18 = bone.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(4, 20).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1945F, -3.8954F, 3.3599F, 0.0F, -0.6109F, 0.0F));

        PartDefinition cube_r19 = bone.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(20, 8).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0107F, -3.3954F, 3.2048F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r20 = bone.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(20, 10).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4537F, -3.7375F, 2.2809F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r21 = bone.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(20, 13).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6851F, -1.2279F, 2.7809F, 0.0F, 0.0F, -0.8727F));

        PartDefinition cube_r22 = bone.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(9, 2).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8901F, -5.6187F, 2.7809F, 0.0F, 0.0F, -1.1781F));

        PartDefinition cube_r23 = bone.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(16, 20).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.265F, -6.7956F, 2.7809F, 0.0F, 0.0F, -0.8727F));

        PartDefinition cube_r24 = bone.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(21, 1).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6436F, -7.317F, 2.7809F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r25 = bone.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(7, 21).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.248F, -7.5F, 2.6065F, 0.0F, -1.0908F, 0.0F));

        PartDefinition cube_r26 = bone.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(13, 21).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6964F, -7.5F, 2.1228F, 0.0F, -0.6109F, 0.0F));

        PartDefinition bone2 = main.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(4.0024F, -5.6446F, 3.8471F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 14).addBox(2.4045F, -2.7145F, 3.8471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 5).addBox(1.1112F, -4.1893F, 3.8471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 11).addBox(5.6002F, -2.7145F, 3.8471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 15).addBox(6.8935F, -4.1893F, 3.8471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 13).addBox(4.0024F, -10.6446F, 3.8471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.2406F, 0.5F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r27 = bone2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(13, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7801F, -9.3267F, 4.3471F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r28 = bone2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(13, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2246F, -9.3267F, 4.3471F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r29 = bone2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0746F, -8.5177F, 4.3471F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r30 = bone2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(14, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9301F, -8.5177F, 4.3471F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r31 = bone2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(7, 9).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8787F, -3.9552F, 4.3471F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r32 = bone2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(9, 4).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7699F, -5.1879F, 4.3471F, 0.0F, 0.0F, -0.6545F));

        PartDefinition cube_r33 = bone2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2291F, -4.4312F, 4.3471F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r34 = bone2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(7, 15).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2105F, -3.0063F, 4.3471F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r35 = bone2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(15, 2).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6925F, -2.4156F, 4.3471F, 0.0F, 0.0F, -0.6545F));

        PartDefinition cube_r36 = bone2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(10, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4471F, -2.4049F, 4.3471F, 0.0F, 0.0F, 0.5672F));

        PartDefinition cube_r37 = bone2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(4, 14).addBox(0.75F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.716F, -1.0025F, 4.3471F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r38 = bone2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(10, 7).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.126F, -3.9552F, 4.3471F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r39 = bone2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2349F, -5.1879F, 4.3471F, 0.0F, 0.0F, 0.6545F));

        PartDefinition cube_r40 = bone2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(4, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7757F, -4.4312F, 4.3471F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r41 = bone2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(16, 7).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7942F, -3.0063F, 4.3471F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r42 = bone2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(10, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3123F, -2.4156F, 4.3471F, 0.0F, 0.0F, 0.6545F));

        PartDefinition cube_r43 = bone2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(16, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5576F, -2.4049F, 4.3471F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r44 = bone2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(7, 17).addBox(-1.75F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2887F, -1.0025F, 4.3471F, 0.0F, 0.0F, 0.6109F));

        PartDefinition bone3 = main.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r45 = bone3.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(4, 12).addBox(2.25F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3029F, -18.4595F, 0.3471F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r46 = bone3.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(13, 4).addBox(2.0F, 2.0F, 3.8471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 6).addBox(-0.25F, 0.25F, 3.8471F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -18.5F, 0.5F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r47 = bone3.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(4, 3).addBox(6.5F, -13.75F, 4.3471F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 5).addBox(6.25F, -15.25F, 4.3471F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}