package tech.lq0.providencraft.models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class CelestialBootsModel2<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer left_total;
	private final ModelRenderer left;
	private final ModelRenderer cube_r1;
	private final ModelRenderer star;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer star4;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer star3;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer star6;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cross;
	private final ModelRenderer cube_r21;
	private final ModelRenderer bow;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer right_total;
	private final ModelRenderer right;
	private final ModelRenderer cube_r26;
	private final ModelRenderer star2;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer STAR5;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer star7;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cross2;
	private final ModelRenderer cube_r46;
	private final ModelRenderer bow2;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;

	public CelestialBootsModel2() {
		super(2.0f);

		textureWidth = 128;
		textureHeight = 128;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 12.0F, 0.0F);
		

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(0.0F, 1.0F, 0.0F);
		main.addChild(left_total);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(-2.5F, 24.0F, 3.0F);
		left_total.addChild(left);
		left.setTextureOffset(18, 45).addBox(-0.75F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
		left.setTextureOffset(38, 54).addBox(-1.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		left.setTextureOffset(48, 54).addBox(-1.0F, -8.0F, 4.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(54, 45).addBox(-1.0F, -8.0F, -5.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(28, 50).addBox(8.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		left.setTextureOffset(0, 45).addBox(7.75F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
		left.setTextureOffset(0, 16).addBox(-1.0F, -2.0F, -8.0F, 10.0F, 3.0F, 13.0F, 0.0F, false);
		left.setTextureOffset(48, 57).addBox(-0.5F, -6.0F, 3.75F, 9.0F, 4.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(0, 57).addBox(-0.5F, -6.0F, -4.5F, 9.0F, 4.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(33, 16).addBox(-0.5F, -4.0F, -7.75F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(4.0F, -5.0F, -4.5F);
		left.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2094F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(33, 0).addBox(-5.0F, -0.6F, -0.8F, 10.0F, 2.0F, 11.0F, 0.0F, false);

		star = new ModelRenderer(this);
		star.setRotationPoint(8.0F, 0.0F, 0.0F);
		left.addChild(star);


		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-8.8F, -4.3256F, 3.2197F);
		star.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.48F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(37, 38).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-8.8F, -4.3256F, 1.3803F);
		star.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.0908F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(20, 49).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-9.3F, -4.0F, 2.3F);
		star.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.7854F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(4, 48).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-9.3F, -5.0F, 2.3F);
		star.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.7854F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(10, 48).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-9.3F, -3.2457F, 1.7469F);
		star.addChild(cube_r6);
		setRotationAngle(cube_r6, -1.3963F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(20, 46).addBox(0.0F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-9.3F, -3.2457F, 2.8531F);
		star.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.1745F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(46, 27).addBox(0.0F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		star4 = new ModelRenderer(this);
		star4.setRotationPoint(-8.8F, -3.0259F, 2.2978F);
		star.addChild(star4);
		setRotationAngle(star4, -0.2182F, 0.0F, 0.0F);


		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(9.8F, -0.7997F, 0.0219F);
		star4.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.48F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(5, 3).addBox(-0.5F, -2.266F, -2.1428F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(9.8F, -0.7997F, -1.8176F);
		star4.addChild(cube_r9);
		setRotationAngle(cube_r9, -1.0908F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(0, 22).addBox(-0.5F, -0.7588F, -2.4659F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(9.3F, -1.4741F, -0.8978F);
		star4.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(31, 38).addBox(0.0F, -2.0373F, -2.3434F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(9.3F, 0.2803F, -1.451F);
		star4.addChild(cube_r11);
		setRotationAngle(cube_r11, -1.3963F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(0, 16).addBox(0.0F, -1.4564F, -2.499F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(9.3F, 0.2803F, -0.3447F);
		star4.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.1745F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(33, 5).addBox(0.0F, -2.4239F, -0.8827F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		star3 = new ModelRenderer(this);
		star3.setRotationPoint(-8.8F, -3.0259F, 2.2978F);
		star.addChild(star3);
		setRotationAngle(star3, -0.2182F, 0.0F, 0.0F);


		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(9.8F, -2.2997F, -4.4781F);
		star3.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.48F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(16, 48).addBox(-0.5F, -0.1786F, -0.883F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(9.8F, -2.2997F, -6.3176F);
		star3.addChild(cube_r14);
		setRotationAngle(cube_r14, -1.0908F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(28, 48).addBox(-0.5F, -1.017F, -0.6294F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(9.3F, -1.9741F, -5.3978F);
		star3.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(0, 27).addBox(0.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(9.3F, -2.9741F, -5.3978F);
		star3.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(28, 45).addBox(0.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(9.3F, -1.2197F, -5.951F);
		star3.addChild(cube_r17);
		setRotationAngle(cube_r17, -1.3963F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(37, 3).addBox(0.0F, -0.0005F, -1.4782F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(9.3F, -1.2197F, -4.8447F);
		star3.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.1745F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(0, 39).addBox(0.0F, -0.3087F, -1.9619F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		star6 = new ModelRenderer(this);
		star6.setRotationPoint(-8.8F, -3.0259F, 2.2978F);
		star.addChild(star6);
		setRotationAngle(star6, -0.2182F, 0.0F, 0.0F);


		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.1F, -0.2741F, -4.9978F);
		star6.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.7854F, 0.0F, 0.0F);
		cube_r19.setTextureOffset(37, 41).addBox(-0.5F, -1.0373F, -0.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r19.setTextureOffset(41, 27).addBox(-0.5F, -0.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r19.setTextureOffset(44, 44).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.1F, 1.1401F, -4.9978F);
		star6.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.7854F, 0.0F, 0.0F);
		cube_r20.setTextureOffset(4, 45).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cross = new ModelRenderer(this);
		cross.setRotationPoint(8.2F, -0.2F, 0.3F);
		left.addChild(cross);


		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.7F, -3.6F, -4.5F);
		cross.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.3665F, 0.0F, 0.0F);
		cube_r21.setTextureOffset(5, 24).addBox(-0.5F, -0.3F, -0.7F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r21.setTextureOffset(31, 32).addBox(-0.5F, -0.9F, 0.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bow = new ModelRenderer(this);
		bow.setRotationPoint(0.0F, 0.0F, 0.0F);
		left.addChild(bow);
		bow.setTextureOffset(44, 41).addBox(3.0F, -5.75F, 4.75F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(1.7452F, -4.8627F, 5.25F);
		bow.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, 0.2618F);
		cube_r22.setTextureOffset(5, 0).addBox(-1.5F, -1.25F, -0.6F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(6.2548F, -4.8627F, 5.25F);
		bow.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -0.2618F);
		cube_r23.setTextureOffset(5, 0).addBox(-1.5F, -1.25F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(2.6847F, -2.3754F, 5.15F);
		bow.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, 0.6545F);
		cube_r24.setTextureOffset(0, 32).addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, 0.0F, true);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(5.3153F, -2.3754F, 5.25F);
		bow.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, -0.6545F);
		cube_r25.setTextureOffset(0, 32).addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(0.0F, 1.0F, 0.0F);
		main.addChild(right_total);
		

		right = new ModelRenderer(this);
		right.setRotationPoint(2.5F, 24.0F, 3.0F);
		right_total.addChild(right);
		right.setTextureOffset(44, 42).addBox(-0.25F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
		right.setTextureOffset(49, 32).addBox(0.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		right.setTextureOffset(54, 42).addBox(-9.0F, -8.0F, 4.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(46, 13).addBox(-9.0F, -8.0F, -5.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(46, 22).addBox(-9.0F, -8.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		right.setTextureOffset(34, 38).addBox(-8.75F, -6.0F, -4.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
		right.setTextureOffset(0, 0).addBox(-9.0F, -2.0F, -8.0F, 10.0F, 3.0F, 13.0F, 0.0F, false);
		right.setTextureOffset(56, 22).addBox(-8.5F, -6.0F, 3.75F, 9.0F, 4.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(33, 22).addBox(-8.5F, -6.0F, -4.5F, 9.0F, 4.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(31, 32).addBox(-8.5F, -4.0F, -7.75F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-4.0F, -5.0F, -4.5F);
		right.addChild(cube_r26);
		setRotationAngle(cube_r26, -0.2094F, 0.0F, 0.0F);
		cube_r26.setTextureOffset(0, 32).addBox(-5.0F, -0.6F, -0.8F, 10.0F, 2.0F, 11.0F, 0.0F, false);

		star2 = new ModelRenderer(this);
		star2.setRotationPoint(0.8F, -3.0259F, 2.2978F);
		right.addChild(star2);
		setRotationAngle(star2, -0.2182F, 0.0F, 0.0F);


		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-0.1F, 1.1401F, -4.9978F);
		star2.addChild(cube_r27);
		setRotationAngle(cube_r27, -0.7854F, 0.0F, 0.0F);
		cube_r27.setTextureOffset(5, 41).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-0.1F, -0.2741F, -4.9978F);
		star2.addChild(cube_r28);
		setRotationAngle(cube_r28, -0.7854F, 0.0F, 0.0F);
		cube_r28.setTextureOffset(39, 6).addBox(-0.5F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r28.setTextureOffset(37, 27).addBox(-0.5F, -0.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r28.setTextureOffset(33, 27).addBox(-0.5F, -1.0373F, -0.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(0.0F, -0.2997F, 0.9219F);
		star2.addChild(cube_r29);
		setRotationAngle(cube_r29, -0.48F, 0.0F, 0.0F);
		cube_r29.setTextureOffset(33, 16).addBox(-0.5F, -1.266F, -1.1428F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(0.0F, -0.2997F, -0.9176F);
		star2.addChild(cube_r30);
		setRotationAngle(cube_r30, -1.0908F, 0.0F, 0.0F);
		cube_r30.setTextureOffset(31, 50).addBox(-0.5F, -1.7588F, -1.4659F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(0.5F, 0.0259F, 0.0022F);
		star2.addChild(cube_r31);
		setRotationAngle(cube_r31, -0.7854F, 0.0F, 0.0F);
		cube_r31.setTextureOffset(14, 45).addBox(-1.0F, -1.0373F, -1.3434F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(0.5F, -0.9741F, 0.0022F);
		star2.addChild(cube_r32);
		setRotationAngle(cube_r32, -0.7854F, 0.0F, 0.0F);
		cube_r32.setTextureOffset(0, 48).addBox(-1.0F, -1.0373F, -1.3434F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(0.5F, 0.7803F, -0.551F);
		star2.addChild(cube_r33);
		setRotationAngle(cube_r33, -1.3963F, 0.0F, 0.0F);
		cube_r33.setTextureOffset(0, 45).addBox(-1.0F, -0.4564F, -2.499F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(0.5F, 0.7803F, 0.5553F);
		star2.addChild(cube_r34);
		setRotationAngle(cube_r34, -0.1745F, 0.0F, 0.0F);
		cube_r34.setTextureOffset(10, 45).addBox(-1.0F, -1.4239F, -1.8827F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		STAR5 = new ModelRenderer(this);
		STAR5.setRotationPoint(-9.3F, -1.2197F, -5.951F);
		star2.addChild(STAR5);


		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(0.0F, 0.0F, 0.0F);
		STAR5.addChild(cube_r35);
		setRotationAngle(cube_r35, -1.3963F, 0.0F, 0.0F);
		cube_r35.setTextureOffset(5, 16).addBox(-1.0F, -0.0005F, -1.4782F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(-0.5F, -1.08F, -0.3666F);
		STAR5.addChild(cube_r36);
		setRotationAngle(cube_r36, -1.0908F, 0.0F, 0.0F);
		cube_r36.setTextureOffset(44, 38).addBox(-0.5F, -1.017F, -0.6294F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(0.0F, -0.7543F, 0.5531F);
		STAR5.addChild(cube_r37);
		setRotationAngle(cube_r37, -0.7854F, 0.0F, 0.0F);
		cube_r37.setTextureOffset(9, 16).addBox(-1.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(-0.5F, -1.08F, 1.4729F);
		STAR5.addChild(cube_r38);
		setRotationAngle(cube_r38, -0.48F, 0.0F, 0.0F);
		cube_r38.setTextureOffset(39, 0).addBox(-0.5F, -0.1786F, -0.883F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(0.0F, -1.7543F, 0.5531F);
		STAR5.addChild(cube_r39);
		setRotationAngle(cube_r39, -0.7854F, 0.0F, 0.0F);
		cube_r39.setTextureOffset(16, 45).addBox(-1.0F, -0.0783F, -0.7686F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(0.0F, 0.0F, 1.1063F);
		STAR5.addChild(cube_r40);
		setRotationAngle(cube_r40, -0.1745F, 0.0F, 0.0F);
		cube_r40.setTextureOffset(37, 8).addBox(-1.0F, -0.3087F, -1.9619F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		star7 = new ModelRenderer(this);
		star7.setRotationPoint(-9.3F, 0.2803F, -1.451F);
		star2.addChild(star7);


		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(0.0F, 0.0F, 0.0F);
		star7.addChild(cube_r41);
		setRotationAngle(cube_r41, -1.3963F, 0.0F, 0.0F);
		cube_r41.setTextureOffset(0, 6).addBox(-1.0F, -1.4564F, -2.499F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(0.0F, 0.0F, 1.1063F);
		star7.addChild(cube_r42);
		setRotationAngle(cube_r42, -0.1745F, 0.0F, 0.0F);
		cube_r42.setTextureOffset(33, 0).addBox(-1.0F, -2.4239F, -0.8827F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(-0.5F, -1.08F, 1.4729F);
		star7.addChild(cube_r43);
		setRotationAngle(cube_r43, -0.48F, 0.0F, 0.0F);
		cube_r43.setTextureOffset(0, 0).addBox(-0.5F, -2.266F, -2.1428F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(0.0F, -1.7543F, 0.5531F);
		star7.addChild(cube_r44);
		setRotationAngle(cube_r44, -0.7854F, 0.0F, 0.0F);
		cube_r44.setTextureOffset(4, 36).addBox(-1.0F, -2.0373F, -2.3434F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(-0.5F, -1.08F, -0.3666F);
		star7.addChild(cube_r45);
		setRotationAngle(cube_r45, -1.0908F, 0.0F, 0.0F);
		cube_r45.setTextureOffset(5, 19).addBox(-0.5F, -0.7588F, -2.4659F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		cross2 = new ModelRenderer(this);
		cross2.setRotationPoint(-8.2F, -0.2F, 0.3F);
		right.addChild(cross2);


		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(-0.7F, -3.6F, -4.5F);
		cross2.addChild(cube_r46);
		setRotationAngle(cube_r46, -0.3665F, 0.0F, 0.0F);
		cube_r46.setTextureOffset(5, 9).addBox(-0.5F, -0.3F, -0.7F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r46.setTextureOffset(6, 32).addBox(-0.5F, -0.9F, 0.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bow2 = new ModelRenderer(this);
		bow2.setRotationPoint(0.0F, 0.0F, 0.0F);
		right.addChild(bow2);
		bow2.setTextureOffset(44, 41).addBox(-5.0F, -5.75F, 4.75F, 2.0F, 2.0F, 1.0F, 0.0F, true);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(-1.7452F, -4.8627F, 5.25F);
		bow2.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, -0.2618F);
		cube_r47.setTextureOffset(5, 0).addBox(-1.5F, -1.25F, -0.6F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(-6.2548F, -4.8627F, 5.25F);
		bow2.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, 0.2618F);
		cube_r48.setTextureOffset(5, 0).addBox(-1.5F, -1.25F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(-2.6847F, -2.3754F, 5.15F);
		bow2.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 0.0F, -0.6545F);
		cube_r49.setTextureOffset(0, 32).addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(-5.3153F, -2.3754F, 5.25F);
		bow2.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 0.0F, 0.6545F);
		cube_r50.setTextureOffset(0, 32).addBox(-1.0F, -2.5F, -0.4F, 2.0F, 5.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.push();
		matrixStack.scale(0.5f,0.5f,0.55f);

		this.left_total.copyModelAngles(this.bipedLeftLeg);
		this.right_total.copyModelAngles(this.bipedRightLeg);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		matrixStack.pop();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}