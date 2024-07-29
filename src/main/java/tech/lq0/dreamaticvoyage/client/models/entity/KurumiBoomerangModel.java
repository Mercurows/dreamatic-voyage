package tech.lq0.dreamaticvoyage.client.models.entity;// Made with Blockbench 4.10.4
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
public class KurumiBoomerangModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "kurumi_boomerang_model"), "main");
    public final ModelPart bone;
//    public final ModelPart nei;
//    public final ModelPart wai;
//    public final ModelPart wai2;
//    public final ModelPart wai3;
//    public final ModelPart wai4;
//    public final ModelPart ring;
//    public final ModelPart ring2;

    public KurumiBoomerangModel(ModelPart root) {
        this.bone = root.getChild("bone");
//        this.nei = this.bone.getChild("nei");
//        this.wai = this.bone.getChild("wai");
//        this.wai2 = this.bone.getChild("wai2");
//        this.wai3 = this.bone.getChild("wai3");
//        this.wai4 = this.bone.getChild("wai4");
//        this.ring = this.bone.getChild("ring");
//        this.ring2 = this.bone.getChild("ring2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition nei = bone.addOrReplaceChild("nei", CubeListBuilder.create().texOffs(14, 14).addBox(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(5.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(18, 8).addBox(2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 21).addBox(-5.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 21).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 13).addBox(-3.0F, -1.0F, 5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-5.0F, -1.0F, 2.0F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wai = bone.addOrReplaceChild("wai", CubeListBuilder.create().texOffs(13, 38).addBox(-12.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 12).addBox(-12.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 2).addBox(-13.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 6).addBox(-13.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(-15.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wai2 = bone.addOrReplaceChild("wai2", CubeListBuilder.create().texOffs(38, 9).addBox(11.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 38).addBox(11.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 25).addBox(8.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 23).addBox(8.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wai3 = bone.addOrReplaceChild("wai3", CubeListBuilder.create().texOffs(38, 5).addBox(11.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 3).addBox(11.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 4).addBox(8.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 0).addBox(8.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wai4 = bone.addOrReplaceChild("wai4", CubeListBuilder.create().texOffs(38, 1).addBox(11.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 37).addBox(11.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 17).addBox(8.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 15).addBox(8.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition ring = bone.addOrReplaceChild("ring", CubeListBuilder.create().texOffs(26, 33).addBox(-10.0F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 33).addBox(-9.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 33).addBox(-8.0F, -1.0F, 6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 31).addBox(-6.0F, -1.0F, 7.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 28).addBox(-4.0F, -1.0F, 8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 37).addBox(-8.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 23).addBox(-4.0F, -1.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 37).addBox(-9.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 34).addBox(-10.0F, -1.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 7).addBox(-5.0F, -1.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 36).addBox(-7.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 35).addBox(-6.0F, -1.0F, 5.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 26).addBox(-10.0F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(-9.0F, -1.0F, -6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 27).addBox(-8.0F, -1.0F, -8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(26, 27).addBox(-6.0F, -1.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 28).addBox(-4.0F, -1.0F, -10.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 8).addBox(-8.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 20).addBox(-4.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 22).addBox(-9.0F, -1.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 27).addBox(-10.0F, -1.0F, -10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 19).addBox(-5.0F, -1.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-7.0F, -1.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-6.0F, -1.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ring2 = bone.addOrReplaceChild("ring2", CubeListBuilder.create().texOffs(32, 25).addBox(-10.0F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 17).addBox(-9.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 32).addBox(-8.0F, -1.0F, 6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 31).addBox(-6.0F, -1.0F, 7.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(26, 30).addBox(-4.0F, -1.0F, 8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(29, 36).addBox(-8.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 36).addBox(-4.0F, -1.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 36).addBox(-9.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 20).addBox(-10.0F, -1.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 36).addBox(-5.0F, -1.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 34).addBox(-7.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 13).addBox(-6.0F, -1.0F, 5.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 8).addBox(-10.0F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 29).addBox(-9.0F, -1.0F, -6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-8.0F, -1.0F, -8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 30).addBox(-6.0F, -1.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 21).addBox(-4.0F, -1.0F, -10.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 30).addBox(-8.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 33).addBox(-4.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 0).addBox(-9.0F, -1.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 4).addBox(-10.0F, -1.0F, -10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 35).addBox(-5.0F, -1.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 34).addBox(-7.0F, -1.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 9).addBox(-6.0F, -1.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}