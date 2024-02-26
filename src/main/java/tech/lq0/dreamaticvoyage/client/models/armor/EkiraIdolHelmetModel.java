package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.0
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
public class EkiraIdolHelmetModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "ekira_idol_helmet_model"), "main");
    public final ModelPart head;

    public EkiraIdolHelmetModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition kou = head.addOrReplaceChild("kou", CubeListBuilder.create(), PartPose.offset(0.25F, 24.0F, 0.0F));

        PartDefinition cube_r6 = kou.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -23.1731F, 8.6844F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -5.5F, 0.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r7 = kou.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -23.1731F, 8.6844F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -6.5F, 0.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition shu = head.addOrReplaceChild("shu", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r4 = shu.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(5, 5).addBox(-0.75F, -26.6586F, -2.5925F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.25F, -4.5F, 0.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r5 = shu.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 6).addBox(3.9745F, -25.5413F, 7.2175F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.5F, 0.5F, 0.3011F, 0.0522F, -0.1666F));

        PartDefinition bow = head.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(9, 1).addBox(-18.1875F, -17.9512F, -0.45F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 3).addBox(-16.2557F, -18.4335F, -0.45F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4727F, 15.7571F, 0.45F, 0.0F, 0.0F, 0.7418F));

        PartDefinition cube_r1 = bow.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 9).addBox(-18.8856F, -15.9263F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0273F, -0.0071F, -0.2F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r2 = bow.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 0).addBox(-16.2419F, -13.3945F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9659F, -0.8094F, 0.05F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r3 = bow.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 8).addBox(-21.2419F, -13.3945F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8774F, -0.4812F, 0.05F, 0.0F, 0.0F, 0.2618F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}