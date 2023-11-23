package tech.lq0.providencraft.models.entity;// Made with Blockbench 4.8.3
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

public class AhogeBoomerangModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "ahoge_boomerang_model"), "main");
	public final ModelPart bb_main;

	public AhogeBoomerangModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone = bb_main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(30, 27).addBox(-10.0F, -1.0F, 6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-12.0F, -1.0F, 8.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-9.0F, -1.0F, 9.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 31).addBox(-14.0F, -1.0F, 10.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(23, 15).addBox(-13.0F, -1.0F, 9.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(16, 21).addBox(-6.0F, -1.0F, 11.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(30, 22).addBox(-5.0F, -1.0F, 11.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-4.0F, -1.0F, 10.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(30, 11).addBox(-3.0F, -1.0F, 10.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 27).addBox(-2.0F, -1.0F, 9.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(11, 8).addBox(-10.0F, -1.0F, 10.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-9.0F, -1.0F, 12.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, -8.0F));

		PartDefinition bone2 = bb_main.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(24, 26).addBox(-7.0F, -1.0F, 6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -1.0F, 6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 16).addBox(-3.0F, -1.0F, 3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 20).addBox(-4.0F, -1.0F, 2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(19, 7).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(8, 26).addBox(-12.0F, -1.0F, 1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(19, 0).addBox(-13.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(26, 6).addBox(-14.0F, -1.0F, 2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-15.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(23, 21).addBox(-16.0F, -1.0F, 4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(11, 0).addBox(-7.0F, -1.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(14, 15).addBox(-10.0F, -1.0F, 0.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}