package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.4
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
public class KurumiHaloModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "kurumi_halo_model"), "main");
    public final ModelPart bone;

    public KurumiHaloModel(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(34, 31).addBox(-1.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 18).addBox(-2.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 12).addBox(-4.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 26).addBox(-5.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 34).addBox(-8.0F, -23.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 20).addBox(-9.0F, -23.0F, 6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 21).addBox(-10.0F, -22.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 15).addBox(-11.0F, -21.0F, 6.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(-12.0F, -20.0F, 6.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 23).addBox(-13.0F, -18.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 33).addBox(-14.0F, -16.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 5).addBox(-7.0F, -24.0F, 6.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 8).addBox(-15.0F, -12.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 18).addBox(-18.0F, -11.5F, 6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 16).addBox(-2.0F, -19.5F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 32).addBox(-8.5F, -13.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 41).addBox(-8.0F, -15.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 39).addBox(-7.0F, -16.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 29).addBox(-6.0F, -17.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 25).addBox(-5.0F, -18.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 38).addBox(-3.0F, -19.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 38).addBox(-4.0F, -19.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(32, 8).addBox(0.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 38).addBox(-0.5F, -28.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 33).addBox(1.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 15).addBox(3.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 32).addBox(4.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(7.0F, -23.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 26).addBox(8.0F, -23.0F, 6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 22).addBox(9.0F, -22.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 15).addBox(10.0F, -21.0F, 6.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(11.0F, -20.0F, 6.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 22).addBox(12.0F, -18.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 22).addBox(13.0F, -16.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(5.0F, -24.0F, 6.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 13).addBox(11.0F, -12.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 16).addBox(15.0F, -11.5F, 6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 19).addBox(0.0F, -19.5F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 13).addBox(6.5F, -13.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 9).addBox(7.0F, -15.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 35).addBox(6.0F, -16.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 18).addBox(5.0F, -17.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 12).addBox(4.0F, -18.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 0).addBox(2.0F, -19.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 36).addBox(3.0F, -19.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 39).addBox(1.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 39).addBox(3.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 30).addBox(4.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 30).addBox(7.0F, 19.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(8.0F, 18.0F, 6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 15).addBox(9.0F, 16.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(10.0F, 14.0F, 6.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 0).addBox(11.0F, 12.0F, 6.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 19).addBox(12.0F, 12.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 30).addBox(13.0F, 12.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 10).addBox(5.0F, 20.0F, 6.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 11).addBox(11.0F, 11.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 41).addBox(10.0F, 10.5F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 29).addBox(0.0F, 17.5F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 5).addBox(6.5F, 11.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 39).addBox(7.0F, 13.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(6.0F, 13.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 36).addBox(5.0F, 14.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(4.0F, 15.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 22).addBox(2.0F, 17.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 36).addBox(3.0F, 16.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, 0.0F));

        PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(22, 28).addBox(-1.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 35).addBox(-0.5F, 25.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 39).addBox(-2.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 39).addBox(-4.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(-5.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 9).addBox(-8.0F, 19.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 10).addBox(-9.0F, 18.0F, 6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-10.0F, 16.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 11).addBox(-11.0F, 14.0F, 6.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.0F, 12.0F, 6.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 15).addBox(-13.0F, 12.0F, 6.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 0).addBox(-14.0F, 12.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 0).addBox(-7.0F, 20.0F, 6.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 9).addBox(-15.0F, 11.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 28).addBox(-11.0F, 10.5F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 27).addBox(-2.0F, 17.5F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 5).addBox(-8.5F, 11.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 6).addBox(-8.0F, 13.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 35).addBox(-7.0F, 13.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 22).addBox(-6.0F, 14.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 35).addBox(-5.0F, 15.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 3).addBox(-3.0F, 17.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 4).addBox(-4.0F, 16.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(0.7f, 0.7f, 0.7f);
        poseStack.translate(0.0f, 0.6f, 0.4f);

        bone.copyFrom(this.body);
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }
}