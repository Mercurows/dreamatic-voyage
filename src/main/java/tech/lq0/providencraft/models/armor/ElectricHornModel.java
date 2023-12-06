package tech.lq0.providencraft.models.armor;// Made with Blockbench 4.9.0
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
public class ElectricHornModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "electric_horn_model"), "main");
    public final ModelPart head;

    public ElectricHornModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = head.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition bone = main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(6, 0).addBox(4.0F, -15.0F, -1.0F, 1.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 3).addBox(5.0F, -3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 16).addBox(5.0F, -4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 8).addBox(5.0F, -10.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 19).addBox(6.0F, -6.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 17).addBox(4.5F, -14.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 17).addBox(3.0F, -7.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone2 = main.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -15.0F, -1.0F, 1.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 21).addBox(-6.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 0).addBox(-7.0F, -3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 6).addBox(-8.0F, -4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-6.0F, -10.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 13).addBox(-7.0F, -6.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 9).addBox(-5.5F, -14.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(-4.0F, -7.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

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