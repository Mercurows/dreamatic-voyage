package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.4
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
public class LecielEarCovertsModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "leciel_ear_coverts_model"), "main");
    public final ModelPart armorHead;

    public LecielEarCovertsModel(ModelPart root) {
        this.armorHead = root.getChild("armorHead");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = armorHead.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition left = main.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 4).addBox(3.75F, -5.0F, -3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 8).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1137F, -1.6728F, -1.4054F, 0.3927F, 0.0F, -0.6981F));

        PartDefinition cube_r2 = left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(7, 11).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2565F, -1.5026F, -1.1609F, 0.7418F, 0.0F, -0.6981F));

        PartDefinition cube_r3 = left.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 10).addBox(-0.7513F, -1.6781F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1853F, -7.2806F, -2.0F, -0.0167F, 0.0403F, -0.393F));

        PartDefinition cube_r4 = left.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(10, 0).addBox(-0.9453F, -1.088F, 0.0147F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 7).addBox(-0.9553F, -0.2446F, 0.552F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1853F, -7.2806F, -2.0F, -0.5729F, 0.0433F, -0.131F));

        PartDefinition cube_r5 = left.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 10).addBox(-0.9553F, -1.088F, -1.0147F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 4).addBox(-0.9453F, -0.2446F, -1.552F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1853F, -7.2806F, -2.0F, 0.5615F, 0.0433F, -0.131F));

        PartDefinition cube_r6 = left.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(6, 0).addBox(-0.9353F, -0.7194F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1853F, -7.2806F, -2.0F, -0.0057F, 0.0433F, -0.131F));

        PartDefinition cube_r7 = left.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(8, 9).addBox(-1.0F, -1.0F, -1.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6428F, -2.234F, -0.5F, 0.0F, 0.0F, -0.6981F));

        PartDefinition right = main.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 0).addBox(-4.75F, -5.0F, -3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r8 = right.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(9, 6).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2565F, -1.5026F, -1.1609F, 0.7418F, 0.0F, 0.6981F));

        PartDefinition cube_r9 = right.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 3).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1137F, -1.6728F, -1.4054F, 0.3927F, 0.0F, 0.6981F));

        PartDefinition cube_r10 = right.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -1.0F, -1.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6428F, -2.234F, -0.5F, 0.0F, 0.0F, 0.6981F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}