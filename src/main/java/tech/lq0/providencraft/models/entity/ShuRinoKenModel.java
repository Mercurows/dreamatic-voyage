package tech.lq0.providencraft.models.entity;// Made with Blockbench 4.9.2
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
public class ShuRinoKenModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "shu_rino_ken_model"), "main");
    public final ModelPart main;

    public ShuRinoKenModel(ModelPart root) {
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone = main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(21, 22).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 22).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 8).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(8, 8).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(23, 0).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone2 = main.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(21, 18).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(5, 21).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 0).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(8, 1).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(8, 8).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 3).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition bone3 = main.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 19).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(7, 15).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition bone4 = main.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(19, 14).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(14, 15).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

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