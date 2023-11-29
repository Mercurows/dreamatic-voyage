package tech.lq0.providencraft.models.armor;// Made with Blockbench 4.8.3
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
public class ChiramIdolBootsModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "chiram_idol_boots_model"), "main");
	public final ModelPart right_total;
	public final ModelPart left_total;

	public ChiramIdolBootsModel(ModelPart root) {
		this.right_total = root.getChild("right_total");
		this.left_total = root.getChild("left_total");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition right = right_total.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 14).addBox(-4.5F, -1.0F, -4.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -2.0F, -4.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-3.5F, -2.0F, 1.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-0.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(17, 22).addBox(-4.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(22, 31).addBox(-4.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 19).addBox(-4.0F, -4.0F, 2.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 32).addBox(-4.0F, -1.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 8).addBox(0.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(16, 1).addBox(-5.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 20).addBox(-4.0F, -5.0F, 3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 15).addBox(-5.25F, -4.25F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, -0.5F));

		PartDefinition cube_r1 = right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -1.25F, 1.5F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r2 = right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -1.25F, -0.5F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r3 = right.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 11).addBox(-0.5F, -1.0F, 1.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -3.5F, -0.5F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r4 = right.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 19).addBox(-0.5F, -1.0F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 19).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -3.5F, 1.5F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r5 = right.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 27).addBox(-2.5F, -1.0F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.3467F, -2.5381F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r6 = right.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(28, 15).addBox(-3.0F, -0.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.7681F, -3.618F, -0.7418F, 0.0F, 0.0F));

		PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition left = left_total.addOrReplaceChild("left", CubeListBuilder.create().texOffs(14, 15).addBox(-0.5F, -1.0F, -4.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(-0.5F, -2.0F, -4.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(31, 0).addBox(0.5F, -2.0F, 1.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(25, 7).addBox(-0.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 20).addBox(3.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 7).addBox(0.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 22).addBox(0.0F, -4.0F, 2.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 31).addBox(0.0F, -1.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 20).addBox(-1.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(4.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(-0.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 10).addBox(0.0F, -5.0F, 3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(2.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 8).addBox(4.25F, -4.25F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, -0.5F));

		PartDefinition cube_r7 = left.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -1.25F, 1.5F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r8 = left.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(16, 3).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -1.25F, -0.5F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r9 = left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(8, 21).addBox(-0.5F, -1.0F, 1.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 23).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -3.5F, -0.5F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r10 = left.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 22).addBox(-0.5F, -1.0F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -3.5F, 1.5F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r11 = left.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(28, 28).addBox(-2.5F, -1.0F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.3467F, -2.5381F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r12 = left.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(11, 29).addBox(-2.0F, -0.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.7681F, -3.618F, -0.7418F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}