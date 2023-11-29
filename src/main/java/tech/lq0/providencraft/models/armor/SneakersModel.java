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
public class SneakersModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "sneakers_model"), "main");
	public final ModelPart right_total;
	public final ModelPart left_total;

	public SneakersModel(ModelPart root) {
		this.right_total = root.getChild("right_total");
		this.left_total = root.getChild("left_total");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition right = right_total.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.75F, -3.75F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-4.0F, -0.75F, 1.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 23).addBox(-4.0F, -0.75F, 1.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 23).addBox(-4.0F, -0.85F, 0.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 10).addBox(-4.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 27).addBox(-4.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-0.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-4.25F, -1.0F, -4.0F, 4.5F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 8).addBox(-4.5F, -3.0F, 2.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition cube_r1 = right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, 10).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 12).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.5F, -2.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r2 = right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 23).addBox(-1.5F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.4142F, -2.5858F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r3 = right.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 17).addBox(-2.75F, -0.5F, -0.5F, 4.5F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, -3.2929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r4 = right.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(6, 27).addBox(0.5F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, -2.9F, 0.0F, -1.5708F, -0.3927F));

		PartDefinition cube_r5 = right.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 27).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1157F, -2.0751F, -3.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r6 = right.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 27).addBox(-0.75F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.75F, -2.75F, 0.0F, -1.5708F, -0.3927F));

		PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition left = left_total.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -0.75F, -3.75F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 18).addBox(0.0F, -0.75F, 1.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 25).addBox(0.0F, -0.75F, 1.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 16).addBox(0.0F, -0.85F, 0.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 13).addBox(3.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(3.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 28).addBox(-0.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 1).addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 20).addBox(-0.25F, -1.0F, -4.0F, 4.5F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 3).addBox(-0.5F, -3.0F, 2.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition cube_r7 = left.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(6, 12).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 14).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.5F, -2.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r8 = left.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(20, 25).addBox(-2.5F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.4142F, -2.5858F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r9 = left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 20).addBox(-1.75F, -0.5F, -0.5F, 4.5F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, -3.2929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r10 = left.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(28, 20).addBox(-1.5F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, -2.9F, 0.0F, 1.5708F, 0.3927F));

		PartDefinition cube_r11 = left.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(28, 7).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1157F, -2.0751F, -3.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r12 = left.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(28, 25).addBox(-0.25F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.75F, -2.75F, 0.0F, 1.5708F, 0.3927F));

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