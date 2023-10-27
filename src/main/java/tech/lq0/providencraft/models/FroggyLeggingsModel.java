package tech.lq0.providencraft.models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class FroggyLeggingsModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer body_total;
	private final ModelRenderer body;
	private final ModelRenderer out1;
	private final ModelRenderer bone;
	private final ModelRenderer out2;
	private final ModelRenderer note;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer left_total;
	private final ModelRenderer left;
	private final ModelRenderer left_r1;
	private final ModelRenderer left_r2;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer hua;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer left_note;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r17_r1;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r18_r1;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer right_total;
	private final ModelRenderer right;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;

	public FroggyLeggingsModel() {
		super(2.0f);

		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 12.0F, 0.0F);
		

		body_total = new ModelRenderer(this);
		body_total.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body_total);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 12.0F, 0.0F);
		body_total.addChild(body);
		

		out1 = new ModelRenderer(this);
		out1.setRotationPoint(0.0F, 1.35F, 1.5966F);
		body.addChild(out1);
		out1.setTextureOffset(30, 40).addBox(-14.0F, -0.5F, -2.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(24, 40).addBox(-13.25F, -0.5F, -4.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(38, 32).addBox(-12.5F, -0.5F, -6.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(42, 46).addBox(-11.75F, -0.5F, -7.9966F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(38, 29).addBox(-13.25F, -0.5F, -0.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(8, 41).addBox(-12.5F, -0.5F, 1.0034F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(40, 38).addBox(11.5F, -0.5F, 1.0034F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(38, 24).addBox(12.25F, -0.5F, -0.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(38, 21).addBox(13.0F, -0.5F, -2.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(38, 18).addBox(12.25F, -0.5F, -4.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(8, 38).addBox(11.5F, -0.5F, -6.9966F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out1.setTextureOffset(46, 36).addBox(10.75F, -0.5F, -7.9966F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(36, 46).addBox(8.75F, -0.5F, -8.4966F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(46, 26).addBox(6.75F, -0.5F, -8.9966F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(12, 46).addBox(-8.75F, -0.5F, -8.9966F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(46, 8).addBox(-10.75F, -0.5F, -8.4966F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(12, 41).addBox(-11.75F, -0.5F, 3.0034F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(34, 40).addBox(10.75F, -0.5F, 3.0034F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(6, 46).addBox(-11.0F, -0.5F, 4.0034F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(0, 46).addBox(9.0F, -0.5F, 4.0034F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(45, 45).addBox(-9.0F, -0.5F, 4.7534F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(45, 40).addBox(7.0F, -0.5F, 4.7534F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(31, 45).addBox(-7.0F, -0.5F, 5.1534F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(25, 45).addBox(5.0F, -0.5F, 5.1534F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(19, 45).addBox(-5.0F, -0.5F, 5.3534F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(40, 44).addBox(3.0F, -0.5F, 5.3534F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(44, 38).addBox(-3.0F, -0.5F, 5.5534F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(44, 34).addBox(-1.0F, -0.5F, 5.8034F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out1.setTextureOffset(14, 44).addBox(1.0F, -0.5F, 5.5534F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.3958F, 0.0F, 1.1117F);
		out1.addChild(bone);
		

		out2 = new ModelRenderer(this);
		out2.setRotationPoint(0.0F, 3.35F, 2.5179F);
		body.addChild(out2);
		out2.setTextureOffset(36, 37).addBox(-15.0F, -0.5F, -3.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(30, 37).addBox(-14.25F, -0.5F, -5.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(24, 37).addBox(-13.5F, -0.5F, -7.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(28, 40).addBox(-12.75F, -0.5F, -8.9179F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(8, 44).addBox(-11.75F, -0.5F, -9.6679F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(8, 35).addBox(-14.25F, -0.5F, -1.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(36, 40).addBox(-13.5F, -0.5F, 0.0821F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(40, 35).addBox(12.5F, -0.5F, 0.0821F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(34, 31).addBox(13.25F, -0.5F, -1.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(34, 28).addBox(14.0F, -0.5F, -3.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(34, 22).addBox(13.25F, -0.5F, -5.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(34, 19).addBox(12.5F, -0.5F, -7.9179F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		out2.setTextureOffset(12, 38).addBox(11.75F, -0.5F, -8.9179F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(35, 43).addBox(9.75F, -0.5F, -9.6679F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(34, 37).addBox(-12.75F, -0.5F, 2.0821F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(28, 37).addBox(11.75F, -0.5F, 2.0821F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(29, 43).addBox(-12.0F, -0.5F, 3.0821F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(23, 43).addBox(10.0F, -0.5F, 3.0821F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(41, 42).addBox(-10.0F, -0.5F, 3.8321F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(42, 32).addBox(8.0F, -0.5F, 3.8321F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(42, 29).addBox(-8.0F, -0.5F, 4.4821F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(42, 24).addBox(6.0F, -0.5F, 4.4821F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(42, 21).addBox(-6.0F, -0.5F, 4.6821F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(42, 18).addBox(4.0F, -0.5F, 4.6821F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(41, 27).addBox(-4.0F, -0.5F, 5.1321F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(40, 8).addBox(2.0F, -0.5F, 5.1321F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(24, 34).addBox(-2.0F, -0.5F, 5.3821F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		out2.setTextureOffset(14, 26).addBox(0.0F, -0.5F, 5.3821F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		note = new ModelRenderer(this);
		note.setRotationPoint(14.5507F, 2.803F, 0.1F);
		body.addChild(note);
		setRotationAngle(note, 0.0F, 0.0F, -0.2618F);
		note.setTextureOffset(27, 29).addBox(-0.5F, -2.3F, -1.6F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		note.setTextureOffset(10, 27).addBox(-0.5F, -2.3F, -0.6F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		note.setTextureOffset(23, 29).addBox(-0.5F, -2.3F, 1.4F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		note.setTextureOffset(12, 35).addBox(-0.5F, 0.7F, 0.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		note.setTextureOffset(34, 34).addBox(-0.5F, 0.7F, -2.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-24.4483F, -4.5236F, -6.85F);
		note.addChild(cube_r1);
		setRotationAngle(cube_r1, -2.8812F, 0.9674F, -2.5523F);
		cube_r1.setTextureOffset(34, 25).addBox(0.537F, -0.8708F, -3.3206F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-24.4483F, -4.5236F, -6.85F);
		note.addChild(cube_r2);
		setRotationAngle(cube_r2, -2.7503F, 0.9674F, -2.5523F);
		cube_r2.setTextureOffset(26, 10).addBox(0.537F, -4.1748F, -2.3176F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-24.4483F, -4.5236F, -6.85F);
		note.addChild(cube_r3);
		setRotationAngle(cube_r3, -3.047F, 0.9674F, -2.5523F);
		cube_r3.setTextureOffset(26, 23).addBox(0.537F, -3.6072F, -2.4806F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.addChild(left_total);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(2.0F, 10.0F, 0.0F);
		left_total.addChild(left);
		

		left_r1 = new ModelRenderer(this);
		left_r1.setRotationPoint(-3.9319F, -3.0739F, -0.2F);
		left.addChild(left_r1);
		setRotationAngle(left_r1, 0.0F, 0.0F, 0.2618F);
		left_r1.setTextureOffset(17, 22).addBox(0.0F, -0.5F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		left_r1.setTextureOffset(0, 11).addBox(-1.0F, -0.5F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		left_r1.setTextureOffset(18, 29).addBox(0.0F, -0.5F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		left_r2 = new ModelRenderer(this);
		left_r2.setRotationPoint(3.4191F, 1.3122F, -0.2F);
		left.addChild(left_r2);
		setRotationAngle(left_r2, 0.0F, 0.0F, 0.2618F);
		left_r2.setTextureOffset(4, 27).addBox(-1.0F, -0.5F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		left_r2.setTextureOffset(28, 20).addBox(-1.0F, -0.5F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		left_r2.setTextureOffset(0, 0).addBox(0.0F, -0.5F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.05F, 0.0F);
		left.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -0.3491F);
		cube_r4.setTextureOffset(32, 14).addBox(-3.75F, -3.65F, 4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r4.setTextureOffset(32, 12).addBox(-3.75F, -3.65F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -0.95F, 0.0F);
		left.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.3491F);
		cube_r5.setTextureOffset(32, 10).addBox(-4.75F, -0.65F, 4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(32, 6).addBox(-4.75F, -0.65F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -2.45F, 0.0F);
		left.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.3491F);
		cube_r6.setTextureOffset(32, 4).addBox(-6.0F, 2.65F, 4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r6.setTextureOffset(32, 2).addBox(-6.0F, 2.65F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-4.0909F, 1.6911F, -1.0F);
		left.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.3491F);
		cube_r7.setTextureOffset(0, 22).addBox(0.0F, -0.5F, -4.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-4.0909F, 2.3911F, -1.0F);
		left.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.3491F);
		cube_r8.setTextureOffset(24, 28).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-4.2799F, 0.4481F, -1.0F);
		left.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -0.3491F);
		cube_r9.setTextureOffset(24, 19).addBox(-0.25F, -0.5F, -3.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-5.306F, -1.3709F, -1.0F);
		left.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -0.3491F);
		cube_r10.setTextureOffset(22, 10).addBox(0.75F, -0.5F, -3.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(4.3663F, -0.687F, 0.0F);
		left.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.3491F);
		cube_r11.setTextureOffset(22, 1).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(3.1513F, -4.4491F, 0.0F);
		left.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -0.3491F);
		cube_r12.setTextureOffset(0, 22).addBox(0.75F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(4.1773F, -2.63F, 0.0F);
		left.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -0.3491F);
		cube_r13.setTextureOffset(14, 20).addBox(-0.25F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-0.8298F, -1.2824F, 3.5F);
		left.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, 0.6109F);
		cube_r14.setTextureOffset(0, 33).addBox(-2.8F, -0.5F, 0.3F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r14.setTextureOffset(32, 16).addBox(-2.8F, -0.5F, -8.7F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		hua = new ModelRenderer(this);
		hua.setRotationPoint(10.6F, -7.05F, 0.1F);
		left.addChild(hua);
		hua.setTextureOffset(22, 3).addBox(-6.2F, 3.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		hua.setTextureOffset(22, 0).addBox(-6.2F, 5.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		hua.setTextureOffset(10, 22).addBox(-5.95F, 4.5F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-5.582F, 5.0F, 1.7582F);
		hua.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.5236F, 0.0F);
		cube_r15.setTextureOffset(12, 11).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-5.5F, 5.0F, -2.0F);
		hua.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.5236F, 0.0F);
		cube_r16.setTextureOffset(12, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		left_note = new ModelRenderer(this);
		left_note.setRotationPoint(-0.2077F, 0.4134F, -5.3F);
		left.addChild(left_note);
		setRotationAngle(left_note, 0.0F, 0.0F, -0.1745F);
		left_note.setTextureOffset(22, 6).addBox(-1.5476F, -0.509F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(5.0447F, -3.1652F, 0.0F);
		left_note.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, 0.2618F);
		

		cube_r17_r1 = new ModelRenderer(this);
		cube_r17_r1.setRotationPoint(-0.0113F, 1.5156F, 0.0F);
		cube_r17.addChild(cube_r17_r1);
		setRotationAngle(cube_r17_r1, 0.0F, 0.0F, -0.1745F);
		cube_r17_r1.setTextureOffset(24, 20).addBox(-0.9403F, -3.1531F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(4.4195F, -3.7553F, 0.0F);
		left_note.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, -0.3054F);
		

		cube_r18_r1 = new ModelRenderer(this);
		cube_r18_r1.setRotationPoint(-0.405F, 2.023F, 0.0F);
		cube_r18.addChild(cube_r18_r1);
		setRotationAngle(cube_r18_r1, 0.0F, 0.0F, -0.1745F);
		cube_r18_r1.setTextureOffset(22, 15).addBox(-1.2482F, 0.2091F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(4.3349F, -4.5105F, 0.0F);
		left_note.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -0.3054F);
		cube_r19.setTextureOffset(12, 6).addBox(-2.2897F, -1.1216F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-1.7444F, 1.08F, 0.0F);
		left_note.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, 0.1745F);
		cube_r20.setTextureOffset(12, 17).addBox(-1.9085F, -1.6143F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(9.8053F, -4.664F, -12.0F);
		left_note.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, 0.2618F);
		cube_r21.setTextureOffset(16, 11).addBox(-9.2F, 10.4F, 11.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r21.setTextureOffset(22, 10).addBox(-8.7F, 7.4F, 11.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(10.5284F, -3.5429F, -12.0F);
		left_note.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, 0.2618F);
		cube_r22.setTextureOffset(16, 0).addBox(-13.7F, 9.2F, 11.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(9.873F, -4.9608F, -12.0F);
		left_note.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, 0.2618F);
		cube_r23.setTextureOffset(4, 22).addBox(-11.7F, 7.4F, 11.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.addChild(right_total);
		

		right = new ModelRenderer(this);
		right.setRotationPoint(3.0F, 7.0F, -0.5F);
		right_total.addChild(right);
		

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(0.0F, 0.0F, 0.0F);
		right.addChild(cube_r24);
		setRotationAngle(cube_r24, 1.5708F, 0.0F, -1.0472F);
		cube_r24.setTextureOffset(4, 35).addBox(-2.5F, -4.5F, 9.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		cube_r24.setTextureOffset(0, 35).addBox(-2.5F, -4.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(-1.2321F, -2.866F, 0.0F);
		right.addChild(cube_r25);
		setRotationAngle(cube_r25, 1.5708F, 0.0F, 1.0472F);
		cube_r25.setTextureOffset(20, 33).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-9.8923F, 2.134F, -0.5F);
		right.addChild(cube_r26);
		setRotationAngle(cube_r26, 1.5708F, 0.0F, 1.0472F);
		cube_r26.setTextureOffset(16, 33).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-2.0981F, -2.366F, -5.5F);
		right.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, 1.0472F);
		cube_r27.setTextureOffset(4, 11).addBox(-0.5F, -0.5F, 10.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		cube_r27.setTextureOffset(0, 11).addBox(-0.5F, -0.5F, 1.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-2.0981F, -2.366F, -5.5F);
		right.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, -1.0472F);
		cube_r28.setTextureOffset(4, 0).addBox(-3.5F, -6.5F, 10.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		cube_r28.setTextureOffset(0, 0).addBox(-3.5F, -6.5F, 1.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-1.3182F, 3.0321F, -0.5F);
		right.addChild(bone2);
		

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, 0.3491F);
		cube_r29.setTextureOffset(12, 11).addBox(-0.75F, -0.5F, -2.75F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-4.2799F, -1.3981F, 1.0F);
		bone2.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, 0.3491F);
		cube_r30.setTextureOffset(32, 0).addBox(-5.25F, -0.6499F, 4.25F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r30.setTextureOffset(0, 31).addBox(-5.25F, -0.65F, -4.75F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-8.4572F, -3.0782F, 1.0F);
		bone2.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, 0.3491F);
		cube_r31.setTextureOffset(12, 0).addBox(-0.75F, -0.5F, -3.75F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.push();
		matrixStack.scale(0.5f,0.5f,0.55f);

		this.body_total.copyModelAngles(this.bipedBody);
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