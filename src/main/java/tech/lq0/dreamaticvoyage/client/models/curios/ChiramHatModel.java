package tech.lq0.dreamaticvoyage.client.models.curios;// Made with Blockbench 4.9.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.google.common.collect.ImmutableList;
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

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class ChiramHatModel extends HumanoidModel<LivingEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "chiram_hat_model"), "main");
    public final ModelPart armorHead;

    public ChiramHatModel(ModelPart root) {
        super(root);
        this.armorHead = root.getChild("armorHead");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hat = armorHead.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -0.35F, -0.5F, 0.1395F, -0.0374F, 0.1604F));

        PartDefinition maoyan = hat.addOrReplaceChild("maoyan", CubeListBuilder.create().texOffs(25, 47).addBox(0.1525F, -7.745F, -2.1773F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F))
                .texOffs(45, 42).addBox(0.1525F, -7.745F, 3.2999F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offset(-0.4325F, -1.2203F, -0.814F));

        PartDefinition cube_r1 = maoyan.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 47).addBox(-0.612F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6064F, -2.356F, 0.8732F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r2 = maoyan.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(5, 47).addBox(-0.612F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4827F, -2.356F, 0.9878F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r3 = maoyan.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(30, 45).addBox(-0.612F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4123F, -2.356F, 1.1409F, 0.0F, 1.1781F, 0.0F));

        PartDefinition cube_r4 = maoyan.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(25, 45).addBox(-0.612F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4059F, -2.356F, 1.3093F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r5 = maoyan.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(10, 45).addBox(-0.612F, -5.389F, 1.632F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4123F, -2.356F, 1.3417F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r6 = maoyan.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(5, 45).addBox(-0.612F, -5.389F, 1.632F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4827F, -2.356F, 1.4949F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r7 = maoyan.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(50, 42).addBox(-0.612F, -5.389F, 1.632F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6064F, -2.356F, 1.6094F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r8 = maoyan.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(20, 45).addBox(-0.748F, -5.389F, 1.632F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2526F, -2.356F, 1.3417F, 0.0F, 1.1781F, 0.0F));

        PartDefinition cube_r9 = maoyan.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(15, 45).addBox(-0.748F, -5.389F, 1.632F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1822F, -2.356F, 1.4949F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r10 = maoyan.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 45).addBox(-0.748F, -5.389F, 1.632F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0585F, -2.356F, 1.6094F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r11 = maoyan.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(35, 45).addBox(-0.748F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2591F, -2.356F, 1.3093F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r12 = maoyan.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 47).addBox(-0.748F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2526F, -2.356F, 1.1409F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r13 = maoyan.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(15, 47).addBox(-0.748F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1822F, -2.356F, 0.9878F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r14 = maoyan.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(20, 47).addBox(-0.748F, -5.389F, -2.992F, 1.36F, 0.34F, 1.36F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0585F, -2.356F, 0.8732F, 0.0F, -0.3927F, 0.0F));

        PartDefinition heyebian = hat.addOrReplaceChild("heyebian", CubeListBuilder.create(), PartPose.offset(-0.4325F, -0.7703F, -0.814F));

        PartDefinition cube_r15 = heyebian.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(27, 42).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4342F, -7.57F, -1.8166F, 0.0894F, 0.3829F, 0.2355F));

        PartDefinition cube_r16 = heyebian.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 42).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.508F, -7.57F, -1.0991F, 0.2132F, 0.762F, 0.3038F));

        PartDefinition cube_r17 = heyebian.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(54, 39).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2255F, -7.57F, -0.0253F, 0.4815F, 1.1243F, 0.5251F));

        PartDefinition cube_r18 = heyebian.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(36, 39).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4775F, -7.57F, 1.2413F, 1.5708F, 1.3526F, 1.5708F));

        PartDefinition cube_r19 = heyebian.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(9, 39).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2255F, -7.57F, 2.508F, 0.4815F, -1.1243F, -0.5251F));

        PartDefinition cube_r20 = heyebian.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(45, 34).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.508F, -7.57F, 3.5818F, 0.2132F, -0.762F, -0.3038F));

        PartDefinition cube_r21 = heyebian.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(18, 34).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4342F, -7.57F, 4.2993F, 0.0894F, -0.3829F, -0.2355F));

        PartDefinition cube_r22 = heyebian.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(27, 34).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8325F, -7.57F, 4.5512F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r23 = heyebian.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(18, 39).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8904F, -7.57F, 2.508F, -0.4815F, 1.1243F, -0.5251F));

        PartDefinition cube_r24 = heyebian.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 39).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1729F, -7.57F, 3.5818F, -0.2132F, 0.762F, -0.3038F));

        PartDefinition cube_r25 = heyebian.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(36, 34).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0991F, -7.57F, 4.2993F, -0.0894F, 0.3829F, -0.2355F));

        PartDefinition cube_r26 = heyebian.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(27, 39).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1424F, -7.57F, 1.2413F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r27 = heyebian.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(45, 39).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8904F, -7.57F, -0.0253F, -0.4815F, -1.1243F, 0.5251F));

        PartDefinition cube_r28 = heyebian.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(9, 42).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1729F, -7.57F, -1.0991F, -0.2132F, -0.762F, 0.3038F));

        PartDefinition cube_r29 = heyebian.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(18, 42).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0991F, -7.57F, -1.8166F, -0.0894F, -0.3829F, 0.2355F));

        PartDefinition cube_r30 = heyebian.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(36, 42).addBox(-0.8219F, -0.1414F, -0.8219F, 1.6437F, 0.3469F, 1.6437F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8325F, -7.57F, -2.0686F, 0.0F, 0.0F, 0.2182F));

        PartDefinition maozi = hat.addOrReplaceChild("maozi", CubeListBuilder.create().texOffs(0, 18).addBox(0.3769F, -9.6889F, -1.0491F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F))
                .texOffs(9, 0).addBox(0.3769F, -9.6889F, 0.6206F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offset(-0.4325F, -1.2203F, -0.814F));

        PartDefinition cube_r31 = maozi.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(9, 12).addBox(-0.41F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.681F, -4.0783F, 0.9947F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r32 = maozi.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(18, 12).addBox(-0.41F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5981F, -4.0783F, 1.0714F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r33 = maozi.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(18, 6).addBox(-0.41F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.551F, -4.0783F, 1.174F, 0.0F, 1.1781F, 0.0F));

        PartDefinition cube_r34 = maozi.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(27, 6).addBox(-0.41F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5466F, -4.0783F, 1.2869F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r35 = maozi.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(27, 0).addBox(-0.41F, -5.6106F, -0.9066F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.551F, -4.0783F, 1.3086F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r36 = maozi.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(36, 0).addBox(-0.41F, -5.6106F, -0.9066F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5981F, -4.0783F, 1.4112F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r37 = maozi.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).addBox(-0.41F, -5.6106F, -0.9066F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.681F, -4.0783F, 1.4879F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r38 = maozi.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5012F, -5.6106F, -0.9066F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.114F, -4.0783F, 1.3086F, 0.0F, 1.1781F, 0.0F));

        PartDefinition cube_r39 = maozi.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(9, 6).addBox(-0.5012F, -5.6106F, -0.9066F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0668F, -4.0783F, 1.4112F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r40 = maozi.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(18, 0).addBox(-0.5012F, -5.6106F, -0.9066F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9839F, -4.0783F, 1.4879F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r41 = maozi.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(36, 6).addBox(-0.5012F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1183F, -4.0783F, 1.2869F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r42 = maozi.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5012F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.114F, -4.0783F, 1.174F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r43 = maozi.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(36, 12).addBox(-0.5012F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0668F, -4.0783F, 1.0714F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r44 = maozi.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(27, 12).addBox(-0.5012F, -5.6106F, -2.0046F, 0.9112F, 1.9778F, 2.9112F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9839F, -4.0783F, 0.9947F, 0.0F, -0.3927F, 0.0F));

        PartDefinition hudiejie = hat.addOrReplaceChild("hudiejie", CubeListBuilder.create(), PartPose.offset(-0.4325F, -1.2203F, -0.814F));

        PartDefinition cube_r45 = hudiejie.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(39, 47).addBox(-0.2647F, -0.3212F, -0.0496F, 0.7794F, 0.6424F, 0.3491F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9482F, -8.4726F, -1.5647F, -0.1733F, -0.3542F, 0.4674F));

        PartDefinition cube_r46 = hudiejie.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(33, 47).addBox(-0.3647F, -0.3212F, -0.0496F, 0.9794F, 0.6424F, 0.3491F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0143F, -8.0996F, -1.5373F, 0.0894F, -0.3829F, -0.2355F));

        PartDefinition cube_r47 = hudiejie.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(30, 47).addBox(-0.3647F, -0.3212F, -0.0996F, 1.0169F, 0.6424F, 0.3491F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3472F, -8.1665F, -0.9311F, -0.0718F, -0.3864F, 0.1886F));

        PartDefinition cube_r48 = hudiejie.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(36, 47).addBox(-0.3647F, -0.3212F, 0.0004F, 0.8325F, 0.6424F, 0.3491F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.536F, -8.4092F, -0.9611F, 0.1733F, -0.3542F, -0.4674F));

        PartDefinition cube_r49 = hudiejie.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 49).addBox(-0.4112F, -4.5478F, -2.4447F, 0.6294F, 0.6424F, 0.3991F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.987F, -3.9983F, 0.9898F, 0.0F, -0.3927F, 0.0F));

        PartDefinition dai = hat.addOrReplaceChild("dai", CubeListBuilder.create().texOffs(9, 34).addBox(0.3677F, -8.4462F, -1.0949F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F))
                .texOffs(18, 18).addBox(0.3677F, -8.4462F, 0.6082F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offset(-0.4325F, -1.2203F, -0.814F));

        PartDefinition cube_r50 = dai.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(18, 29).addBox(-0.4182F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.678F, -3.9983F, 0.9898F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r51 = dai.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(27, 29).addBox(-0.4182F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5935F, -3.9983F, 1.068F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r52 = dai.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(36, 24).addBox(-0.4182F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5453F, -3.9983F, 1.1727F, 0.0F, 1.1781F, 0.0F));

        PartDefinition cube_r53 = dai.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(27, 24).addBox(-0.4182F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5409F, -3.9983F, 1.2878F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r54 = dai.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(36, 18).addBox(-0.4182F, -4.4478F, -0.9247F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5453F, -3.9983F, 1.3099F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r55 = dai.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(9, 24).addBox(-0.4182F, -4.4478F, -0.9247F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5935F, -3.9983F, 1.4146F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r56 = dai.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(9, 18).addBox(-0.4182F, -4.4478F, -0.9247F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.678F, -3.9983F, 1.4929F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r57 = dai.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5112F, -4.4478F, -0.9247F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1196F, -3.9983F, 1.3099F, 0.0F, 1.1781F, 0.0F));

        PartDefinition cube_r58 = dai.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(18, 24).addBox(-0.5112F, -4.4478F, -0.9247F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0715F, -3.9983F, 1.4146F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r59 = dai.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(27, 18).addBox(-0.5112F, -4.4478F, -0.9247F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.987F, -3.9983F, 1.4929F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r60 = dai.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(0, 29).addBox(-0.5112F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.124F, -3.9983F, 1.2878F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r61 = dai.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(9, 29).addBox(-0.5112F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1196F, -3.9983F, 1.1727F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r62 = dai.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(36, 29).addBox(-0.5112F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0715F, -3.9983F, 1.068F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r63 = dai.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 34).addBox(-0.5112F, -4.4478F, -2.0447F, 0.9294F, 0.7424F, 2.9694F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.987F, -3.9983F, 0.9898F, 0.0F, -0.3927F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    @Nonnull
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.armorHead);
    }

    @Override
    @Nonnull
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of();
    }
}