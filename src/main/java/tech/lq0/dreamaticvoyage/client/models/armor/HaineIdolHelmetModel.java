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
public class HaineIdolHelmetModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "haine_idol_helmet_model"), "main");
    public final ModelPart head;

    public HaineIdolHelmetModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = head.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition hat = main.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(8, 9).addBox(-4.0F, -0.0714F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(3.0F, -0.0714F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(16, 10).addBox(-3.0F, -0.0714F, 3.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 8).addBox(-3.0F, -0.0714F, -4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -1.0714F, -3.5F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(7, 16).addBox(-3.5F, -1.0714F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(2.5F, -1.0714F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9286F, 1.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition bow = main.addOrReplaceChild("bow", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = bow.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -0.25F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, -0.5F, 1.0F, -0.2182F, -0.4363F, 0.0F));

        PartDefinition cube_r2 = bow.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 8).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.25F, 1.1124F, -0.1464F, -0.1298F, 0.017F, 0.1298F));

        PartDefinition cube_r3 = bow.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -1.5F, -0.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.25F, 0.5F, -0.5F, -0.2597F, 0.0338F, 0.1265F));

        PartDefinition cube_r4 = bow.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 16).mirror().addBox(0.25F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, -0.5F, -1.5F, -0.0472F, 0.3923F, -0.0181F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}