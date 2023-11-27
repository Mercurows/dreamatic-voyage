package tech.lq0.providencraft.models.armor;// Made with Blockbench 4.8.3
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
public class ReinaWingsModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "reina_wings_model"), "main");
    public final ModelPart main;

    public ReinaWingsModel(ModelPart root) {
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wing1 = main.addOrReplaceChild("wing1", CubeListBuilder.create(), PartPose.offset(2.25F, 24.0F, 2.0F));

        PartDefinition cube_r1 = wing1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(23, 16).addBox(-1.0F, -13.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0053F, -6.9929F, -0.9979F, 0.0F, -0.2618F, 0.0F));

        PartDefinition cube_r2 = wing1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(19, 10).addBox(-0.6665F, -13.4581F, 0.4445F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2769F, -3.1676F, -4.0427F, 0.0F, 1.7453F, -0.0873F));

        PartDefinition cube_r3 = wing1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 0).addBox(-0.9134F, -13.2392F, 1.845F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.3095F, -9.0227F, -4.0427F, 0.0F, 1.7453F, -0.2182F));

        PartDefinition cube_r4 = wing1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -12.991F, 2.8074F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.6011F, -9.1417F, -2.9635F, 0.0F, 1.5708F, -0.3054F));

        PartDefinition cube_r5 = wing1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(7, 8).addBox(0.6313F, -12.8365F, 3.0885F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5343F, -9.1381F, -1.8363F, 0.0F, 1.2654F, -0.3491F));

        PartDefinition cube_r6 = wing1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(11, 14).addBox(2.0626F, -12.6627F, 2.8396F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1319F, -8.9984F, -0.8087F, 0.0F, 0.9163F, -0.3927F));

        PartDefinition cube_r7 = wing1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(15, 12).addBox(3.1456F, -12.6627F, 1.6048F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3151F, -8.6601F, -0.0334F, 0.0F, 0.5236F, -0.3927F));

        PartDefinition cube_r8 = wing1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(16, 0).addBox(3.6097F, -12.6627F, 0.4112F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3331F, -8.2533F, 0.3799F, 0.0F, 0.2182F, -0.3927F));

        PartDefinition cube_r9 = wing1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(19, 15).addBox(3.7095F, -12.6627F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.3202F, -7.8337F, 0.5F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r10 = wing1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 20).addBox(2.8074F, -12.991F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1764F, -7.4174F, 0.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r11 = wing1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(8, 21).addBox(1.8812F, -12.2392F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7843F, -8.0787F, 0.5F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r12 = wing1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(12, 22).addBox(1.4098F, -12.3329F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7396F, -7.8709F, 0.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r13 = wing1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(23, 3).addBox(0.914F, -12.4059F, -0.7493F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6082F, -7.6985F, 0.4056F, 0.0F, -0.1745F, -0.1309F));

        PartDefinition cube_r14 = wing1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 23).addBox(0.4012F, -11.9581F, -0.8281F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.459F, -8.0807F, 0.1252F, 0.0F, -0.3491F, -0.0873F));

        PartDefinition cube_r15 = wing1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(23, 19).addBox(-0.0655F, -11.9895F, -0.7026F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.454F, -8.0228F, -0.2738F, 0.0F, -0.4363F, -0.0436F));

        PartDefinition wing2 = main.addOrReplaceChild("wing2", CubeListBuilder.create(), PartPose.offset(-2.25F, 24.0F, 2.0F));

        PartDefinition cube_r16 = wing2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(23, 7).addBox(0.0F, -13.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0053F, -6.9929F, -0.9979F, 0.0F, 0.2618F, 0.0F));

        PartDefinition cube_r17 = wing2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(7, 16).addBox(-0.3335F, -13.4581F, 0.4445F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2769F, -3.1676F, -4.0427F, 0.0F, -1.7453F, 0.0873F));

        PartDefinition cube_r18 = wing2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 9).addBox(-0.0866F, -13.2392F, 1.845F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.3095F, -9.0227F, -4.0427F, 0.0F, -1.7453F, 0.2182F));

        PartDefinition cube_r19 = wing2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -12.991F, 2.8074F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.6011F, -9.1417F, -2.9635F, 0.0F, -1.5708F, 0.3054F));

        PartDefinition cube_r20 = wing2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(8, 0).addBox(-1.6313F, -12.8365F, 3.0885F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5343F, -9.1381F, -1.8363F, 0.0F, -1.2654F, 0.3491F));

        PartDefinition cube_r21 = wing2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(11, 7).addBox(-3.0626F, -12.6627F, 2.8396F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1319F, -8.9984F, -0.8087F, 0.0F, -0.9163F, 0.3927F));

        PartDefinition cube_r22 = wing2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(3, 15).addBox(-4.1456F, -12.6627F, 1.6048F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3151F, -8.6601F, -0.0334F, 0.0F, -0.5236F, 0.3927F));

        PartDefinition cube_r23 = wing2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(15, 6).addBox(-4.6097F, -12.6627F, 0.4112F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3331F, -8.2533F, 0.3799F, 0.0F, -0.2182F, 0.3927F));

        PartDefinition cube_r24 = wing2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(15, 18).addBox(-4.7095F, -12.6627F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.3202F, -7.8337F, 0.5F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r25 = wing2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(19, 5).addBox(-3.8074F, -12.991F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1764F, -7.4174F, 0.5F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r26 = wing2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(20, 0).addBox(-2.8812F, -12.2392F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7843F, -8.0787F, 0.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r27 = wing2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(19, 20).addBox(-2.4098F, -12.3329F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7396F, -7.8709F, 0.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r28 = wing2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(4, 21).addBox(-1.914F, -12.4059F, -0.7493F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6082F, -7.6985F, 0.4056F, 0.0F, 0.1745F, 0.1309F));

        PartDefinition cube_r29 = wing2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(23, 10).addBox(-1.4012F, -11.9581F, -0.8281F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.459F, -8.0807F, 0.1252F, 0.0F, 0.3491F, 0.0873F));

        PartDefinition cube_r30 = wing2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(23, 13).addBox(-0.9345F, -11.9895F, -0.7026F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.454F, -8.0228F, -0.2738F, 0.0F, 0.4363F, 0.0436F));

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