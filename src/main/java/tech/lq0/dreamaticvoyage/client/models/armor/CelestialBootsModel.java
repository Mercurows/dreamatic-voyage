package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.8.3
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
public class CelestialBootsModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "celestial_boots_model"), "main");
    public final ModelPart right_total;
    public final ModelPart left_total;

    public CelestialBootsModel(ModelPart root) {
        super(root);
        this.right_total = root.getChild("right_total");
        this.left_total = root.getChild("left_total");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(-2.0F, 3.0F, 0.0F));

        PartDefinition right = right_total.addOrReplaceChild("right", CubeListBuilder.create().texOffs(44, 42).addBox(-0.25F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(49, 32).addBox(0.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(54, 42).addBox(-9.0F, -8.0F, 4.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 13).addBox(-9.0F, -8.0F, -5.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 22).addBox(-9.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(34, 38).addBox(-8.75F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-9.0F, -2.0F, -8.0F, 10.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(56, 22).addBox(-8.5F, -6.0F, 3.75F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 22).addBox(-8.5F, -6.0F, -4.5F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 32).addBox(-8.5F, -4.0F, -7.75F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 27.0F, 0.0F));

        PartDefinition cube_r1 = right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-5.0F, -0.6F, -0.8F, 10.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -5.0F, -4.5F, -0.2094F, 0.0F, 0.0F));

        PartDefinition star2 = right.addOrReplaceChild("star2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8F, -3.0259F, 2.2978F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = star2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(5, 41).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 1.1401F, -4.9978F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r3 = star2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(39, 6).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 27).addBox(-0.5F, -0.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 27).addBox(-0.5F, -1.0373F, -0.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -0.2741F, -4.9978F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r4 = star2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(33, 16).addBox(-0.5F, -1.266F, -1.1428F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2997F, 0.9219F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r5 = star2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(31, 50).addBox(-0.5F, -1.7588F, -1.4659F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2997F, -0.9176F, -1.0908F, 0.0F, 0.0F));

        PartDefinition cube_r6 = star2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 45).addBox(-1.0F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0259F, 0.0022F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r7 = star2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -1.0373F, -1.3434F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.9741F, 0.0022F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r8 = star2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, -0.4564F, -2.499F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.7803F, -0.551F, -1.3963F, 0.0F, 0.0F));

        PartDefinition cube_r9 = star2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(10, 45).addBox(-1.0F, -1.4239F, -1.8827F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.7803F, 0.5553F, -0.1745F, 0.0F, 0.0F));

        PartDefinition STAR5 = star2.addOrReplaceChild("STAR5", CubeListBuilder.create(), PartPose.offset(-9.3F, -1.2197F, -5.951F));

        PartDefinition cube_r10 = STAR5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(5, 16).addBox(-1.0F, -0.0005F, -1.4782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3963F, 0.0F, 0.0F));

        PartDefinition cube_r11 = STAR5.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(44, 38).addBox(-0.5F, -1.017F, -0.6294F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.08F, -0.3666F, -1.0908F, 0.0F, 0.0F));

        PartDefinition cube_r12 = STAR5.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(9, 16).addBox(-1.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7543F, 0.5531F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r13 = STAR5.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(39, 0).addBox(-0.5F, -0.1786F, -0.883F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.08F, 1.4729F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r14 = STAR5.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 45).addBox(-1.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7543F, 0.5531F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r15 = STAR5.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(37, 8).addBox(-1.0F, -0.3087F, -1.9619F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.1063F, -0.1745F, 0.0F, 0.0F));

        PartDefinition star7 = star2.addOrReplaceChild("star7", CubeListBuilder.create(), PartPose.offset(-9.3F, 0.2803F, -1.451F));

        PartDefinition cube_r16 = star7.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -1.4564F, -2.499F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3963F, 0.0F, 0.0F));

        PartDefinition cube_r17 = star7.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -2.4239F, -0.8827F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.1063F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r18 = star7.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.266F, -2.1428F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.08F, 1.4729F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r19 = star7.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(4, 36).addBox(-1.0F, -2.0373F, -2.3434F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7543F, 0.5531F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r20 = star7.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(5, 19).addBox(-0.5F, -0.7588F, -2.4659F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.08F, -0.3666F, -1.0908F, 0.0F, 0.0F));

        PartDefinition cross2 = right.addOrReplaceChild("cross2", CubeListBuilder.create(), PartPose.offset(-8.2F, -0.2F, 0.3F));

        PartDefinition cube_r21 = cross2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(5, 9).addBox(-0.5F, -0.3F, -0.7F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(6, 32).addBox(-0.5F, -0.9F, 0.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -3.6F, -4.5F, -0.3665F, 0.0F, 0.0F));

        PartDefinition bow2 = right.addOrReplaceChild("bow2", CubeListBuilder.create().texOffs(44, 41).mirror().addBox(-5.0F, -5.75F, 4.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r22 = bow2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(5, 0).addBox(-1.5F, -1.25F, -0.6F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7452F, -4.8627F, 5.25F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r23 = bow2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(5, 0).mirror().addBox(-1.5F, -1.25F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.2548F, -4.8627F, 5.25F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r24 = bow2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6847F, -2.3754F, 5.15F, 0.0F, 0.0F, -0.6545F));

        PartDefinition cube_r25 = bow2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.3153F, -2.3754F, 5.25F, 0.0F, 0.0F, 0.6545F));

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(2.0F, 3.0F, 0.0F));

        PartDefinition left = left_total.addOrReplaceChild("left", CubeListBuilder.create().texOffs(18, 45).addBox(-0.75F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(38, 54).addBox(-1.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(48, 54).addBox(-1.0F, -8.0F, 4.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 45).addBox(-1.0F, -8.0F, -5.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 50).addBox(8.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(7.75F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-1.0F, -2.0F, -8.0F, 10.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(48, 57).addBox(-0.5F, -6.0F, 3.75F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 57).addBox(-0.5F, -6.0F, -4.5F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 16).addBox(-0.5F, -4.0F, -7.75F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 27.0F, 0.0F));

        PartDefinition cube_r26 = left.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(33, 0).addBox(-5.0F, -0.6F, -0.8F, 10.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -5.0F, -4.5F, -0.2094F, 0.0F, 0.0F));

        PartDefinition star = left.addOrReplaceChild("star", CubeListBuilder.create(), PartPose.offset(8.0F, 0.0F, 0.0F));

        PartDefinition cube_r27 = star.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(37, 38).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8F, -4.3256F, 3.2197F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r28 = star.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(20, 49).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8F, -4.3256F, 1.3803F, -1.0908F, 0.0F, 0.0F));

        PartDefinition cube_r29 = star.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(4, 48).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, -4.0F, 2.3F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r30 = star.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(10, 48).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, -5.0F, 2.3F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r31 = star.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(20, 46).addBox(0.0F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, -3.2457F, 1.7469F, -1.3963F, 0.0F, 0.0F));

        PartDefinition cube_r32 = star.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(46, 27).addBox(0.0F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, -3.2457F, 2.8531F, -0.1745F, 0.0F, 0.0F));

        PartDefinition star4 = star.addOrReplaceChild("star4", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.8F, -3.0259F, 2.2978F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r33 = star4.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(5, 3).addBox(-0.5F, -2.266F, -2.1428F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8F, -0.7997F, 0.0219F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r34 = star4.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -0.7588F, -2.4659F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8F, -0.7997F, -1.8176F, -1.0908F, 0.0F, 0.0F));

        PartDefinition cube_r35 = star4.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(31, 38).addBox(0.0F, -2.0373F, -2.3434F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, -1.4741F, -0.8978F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r36 = star4.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -1.4564F, -2.499F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 0.2803F, -1.451F, -1.3963F, 0.0F, 0.0F));

        PartDefinition cube_r37 = star4.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(33, 5).addBox(0.0F, -2.4239F, -0.8827F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 0.2803F, -0.3447F, -0.1745F, 0.0F, 0.0F));

        PartDefinition star3 = star.addOrReplaceChild("star3", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.8F, -3.0259F, 2.2978F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r38 = star3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(16, 48).addBox(-0.5F, -0.1786F, -0.883F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8F, -2.2997F, -4.4781F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r39 = star3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(28, 48).addBox(-0.5F, -1.017F, -0.6294F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8F, -2.2997F, -6.3176F, -1.0908F, 0.0F, 0.0F));

        PartDefinition cube_r40 = star3.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, -1.9741F, -5.3978F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r41 = star3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(28, 45).addBox(0.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, -2.9741F, -5.3978F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r42 = star3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(37, 3).addBox(0.0F, -0.0005F, -1.4782F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, -1.2197F, -5.951F, -1.3963F, 0.0F, 0.0F));

        PartDefinition cube_r43 = star3.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 39).addBox(0.0F, -0.3087F, -1.9619F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, -1.2197F, -4.8447F, -0.1745F, 0.0F, 0.0F));

        PartDefinition star6 = star.addOrReplaceChild("star6", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.8F, -3.0259F, 2.2978F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r44 = star6.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(37, 41).addBox(-0.5F, -1.0373F, -0.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 27).addBox(-0.5F, -0.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 44).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.2741F, -4.9978F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r45 = star6.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(4, 45).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.1401F, -4.9978F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cross = left.addOrReplaceChild("cross", CubeListBuilder.create(), PartPose.offset(8.2F, -0.2F, 0.3F));

        PartDefinition cube_r46 = cross.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(5, 24).addBox(-0.5F, -0.3F, -0.7F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(31, 32).addBox(-0.5F, -0.9F, 0.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, -3.6F, -4.5F, -0.3665F, 0.0F, 0.0F));

        PartDefinition bow = left.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(44, 41).addBox(3.0F, -5.75F, 4.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r47 = bow.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(5, 0).mirror().addBox(-1.5F, -1.25F, -0.6F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.7452F, -4.8627F, 5.25F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r48 = bow.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(5, 0).addBox(-1.5F, -1.25F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2548F, -4.8627F, 5.25F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r49 = bow.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.6847F, -2.3754F, 5.15F, 0.0F, 0.0F, 0.6545F));

        PartDefinition cube_r50 = bow.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3153F, -2.3754F, 5.25F, 0.0F, 0.0F, -0.6545F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();

        poseStack.scale(0.5f, 0.5f, 0.55f);
        poseStack.translate(0, 0.65, 0);

        poseStack.pushPose();
        right_total.copyFrom(this.rightLeg);
        if (this.crouching) {
            poseStack.translate(0, -0.15, 0.2);
        }
        right_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        poseStack.pushPose();
        left_total.copyFrom(this.leftLeg);
        if (this.crouching) {
            poseStack.translate(0, -0.15, 0.2);
        }
        left_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        poseStack.popPose();
    }
}