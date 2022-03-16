package tech.lq0.providencraft.models;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AhogeHelmetModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer bone2;

	public AhogeHelmetModel(float modelSize, EquipmentSlotType slot, LivingEntity entity) {
		super(modelSize, 0.0f, 64, 64);
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, -24.0F, 0.0F);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -6.0F, 0.0F);
		main.addChild(bone2);
		bone2.setTextureOffset(0, 25).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(24, 0).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(0, 22).addBox(0.0F, -5.0F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(16, 21).addBox(1.0F, -8.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(20, 14).addBox(0.0F, -9.0F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(0, 19).addBox(-4.0F, -10.0F, -1.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(20, 11).addBox(-3.0F, -11.0F, -1.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(24, 3).addBox(-5.0F, -9.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}