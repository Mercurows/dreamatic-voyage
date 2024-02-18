package tech.lq0.providencraft.models.armor;// Made with Blockbench 4.9.3
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
public class HiruHeadModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "hiru_head_model"), "main");
    public final ModelPart armorHead;

    public HiruHeadModel(ModelPart root) {
        this.armorHead = root.getChild("armorHead");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = armorHead.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone = main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone2 = main.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 32).addBox(-9.0F, -10.0F, 6.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-9.0F, -10.0F, -8.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 44).addBox(-9.0F, -12.0F, 4.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(15, 32).addBox(-9.0F, -14.0F, 2.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 0).addBox(-9.0F, -14.0F, 0.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 8).addBox(-9.0F, -14.0F, -2.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 32).addBox(-9.0F, -14.0F, -4.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 44).addBox(-8.0F, -8.0F, -9.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 41).addBox(-8.0F, -8.0F, 8.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 35).addBox(-1.0F, -13.0F, -9.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 32).addBox(-1.0F, -13.0F, 8.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 38).addBox(8.0F, -13.0F, -8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 44).addBox(8.0F, -13.0F, 6.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 44).addBox(-1.0F, -21.0182F, -6.7343F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(27, 32).addBox(-1.0F, -1.5F, 7.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.6667F, -3.0555F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -0.5F, -10.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.2623F, 3.2006F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(15, 32).addBox(-1.0F, -1.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5F, -3.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 40).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 40).addBox(-1.0F, -4.0F, 16.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, -8.5F, 0.0F, 0.0F, -0.2182F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}