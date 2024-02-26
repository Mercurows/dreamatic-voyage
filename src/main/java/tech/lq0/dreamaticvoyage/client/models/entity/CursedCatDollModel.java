package tech.lq0.dreamaticvoyage.client.models.entity;// Made with Blockbench 4.8.3
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
public class CursedCatDollModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "cursed_cat_doll_model"), "main");
    private final ModelPart main;

    public CursedCatDollModel(ModelPart root) {
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -2.5F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(14, 15).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 10).addBox(-3.5F, -10.5F, -2.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(26, 26).addBox(5.5F, -7.75F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(26, 2).addBox(5.0F, -8.75F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(20, 22).addBox(4.0F, -9.75F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 30).addBox(-6.5F, -7.75F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 26).addBox(-6.0F, -8.75F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-5.0F, -9.75F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(0, 38).addBox(1.25F, -8.25F, -2.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 10).addBox(-3.25F, -8.25F, -2.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 0).addBox(-2.75F, -6.05F, -2.55F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bow = head.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(36, 29).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.75F));

        PartDefinition cube_r1 = bow.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 10).addBox(0.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4858F, -9.9217F, -2.7446F, 0.1719F, -0.4971F, -0.3492F));

        PartDefinition cube_r2 = bow.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 36).addBox(-2.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4858F, -9.9217F, -2.7446F, 0.1719F, 0.4971F, 0.3492F));

        PartDefinition cube_r3 = bow.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 15).addBox(-1.5F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.799F, -10.5F, -0.616F, 0.0F, 0.5236F, 0.0F));

        PartDefinition cube_r4 = bow.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(26, 23).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9821F, -11.0F, -0.366F, -0.0692F, 0.2527F, -0.2706F));

        PartDefinition cube_r5 = bow.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(21, 2).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6177F, -11.3744F, -1.0722F, 0.035F, 0.2595F, 0.1355F));

        PartDefinition cube_r6 = bow.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 26).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6177F, -11.3744F, -1.0722F, 0.035F, -0.2595F, -0.1355F));

        PartDefinition cube_r7 = bow.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 2).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9821F, -11.0F, -0.366F, -0.0692F, -0.2527F, 0.2706F));

        PartDefinition cube_r8 = bow.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(26, 32).addBox(-2.5F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.799F, -10.5F, -0.616F, 0.0F, -0.5236F, 0.0F));

        PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(21, 0).addBox(-3.5F, -4.75F, -2.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 20).addBox(-3.5F, -4.75F, 1.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 18).addBox(3.0F, -4.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 5).addBox(-4.0F, -4.75F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition flower_r1 = neck.addOrReplaceChild("flower_r1", CubeListBuilder.create().texOffs(22, 30).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.75F, -4.25F, -2.25F, 0.0F, 0.7854F, 0.0F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -4.0F, -1.5F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.5454F, -2.6181F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r9 = arms.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(8, 19).addBox(-1.0F, -0.7954F, -2.3681F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.2462F, 0.2066F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r10 = arms.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.2462F, 0.2066F, 0.2182F, -0.1745F, 0.0F));

        PartDefinition cube_r11 = arms.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(6, 25).addBox(-1.0F, -0.7954F, -2.3681F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.2462F, 0.2066F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r12 = arms.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(12, 20).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.2462F, 0.2066F, 0.2182F, 0.1745F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition cube_r13 = legs.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(8, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 35).addBox(-4.5F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 4.8453F, -0.9791F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r14 = legs.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 35).addBox(-4.5F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 2.75F, -0.25F, -0.1745F, 0.0F, 0.0F));

        PartDefinition tail = main.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(20, 22).addBox(-0.5F, -0.3153F, -0.1092F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 2.5584F, 2.0627F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r15 = tail.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.47F, -0.3709F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r16 = tail.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 26).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.6108F, 0.2645F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r17 = tail.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 19).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2415F, 0.2645F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r18 = tail.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 25).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0584F, -0.3127F, 0.3491F, 0.0F, 0.0F));

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