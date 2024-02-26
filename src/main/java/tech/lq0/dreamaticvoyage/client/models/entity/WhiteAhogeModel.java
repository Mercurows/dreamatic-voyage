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
public class WhiteAhogeModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "white_ahoge_model"), "main");
    public final ModelPart main;

    public WhiteAhogeModel(ModelPart root) {
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(19, 20).addBox(-1.0F, -1.0F, -8.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(-3.0F, -1.0F, -7.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-5.0F, -1.0F, -6.0F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-6.0F, -1.0F, -5.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-7.0F, -1.0F, -4.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-8.0F, -1.0F, -3.1F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-8.0F, -1.0F, -1.1F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(20, 10).addBox(-7.0F, -1.0F, 1.9F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-7.0F, -1.0F, 2.9F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-6.0F, -1.0F, 3.9F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -1.0F, 4.9F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 4).addBox(-3.0F, -1.0F, 5.9F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-1.0F, -1.0F, 6.9F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

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