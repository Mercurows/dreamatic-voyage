package tech.lq0.providencraft.models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class MistyChestplateModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer left_total;
	private final ModelRenderer left_arm;
	private final ModelRenderer cuff;
	private final ModelRenderer ring1;
	private final ModelRenderer ring2;
	private final ModelRenderer ring3;
	private final ModelRenderer sleeve;
	private final ModelRenderer body_total;
	private final ModelRenderer body;
	private final ModelRenderer up;
	private final ModelRenderer dress;
	private final ModelRenderer outside;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
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
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer inside;
	private final ModelRenderer one;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer cube_r57;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer cube_r60;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;
	private final ModelRenderer cube_r65;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer cube_r68;
	private final ModelRenderer cube_r69;
	private final ModelRenderer cube_r70;
	private final ModelRenderer cube_r71;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer cube_r89;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer cube_r92;
	private final ModelRenderer two;
	private final ModelRenderer cube_r93;
	private final ModelRenderer cube_r94;
	private final ModelRenderer cube_r95;
	private final ModelRenderer cube_r96;
	private final ModelRenderer cube_r97;
	private final ModelRenderer cube_r98;
	private final ModelRenderer cube_r99;
	private final ModelRenderer cube_r100;
	private final ModelRenderer cube_r101;
	private final ModelRenderer cube_r102;
	private final ModelRenderer cube_r103;
	private final ModelRenderer cube_r104;
	private final ModelRenderer cube_r105;
	private final ModelRenderer cube_r106;
	private final ModelRenderer cube_r107;
	private final ModelRenderer cube_r108;
	private final ModelRenderer hudejie;
	private final ModelRenderer cube_r109;
	private final ModelRenderer cube_r110;
	private final ModelRenderer cube_r111;
	private final ModelRenderer cube_r112;
	private final ModelRenderer cube_r113;
	private final ModelRenderer cube_r114;
	private final ModelRenderer cube_r115;
	private final ModelRenderer cube_r116;
	private final ModelRenderer brace;
	private final ModelRenderer core;
	private final ModelRenderer cube_r117;
	private final ModelRenderer cube_r118;
	private final ModelRenderer cube_r119;
	private final ModelRenderer cube_r120;
	private final ModelRenderer cube_r121;
	private final ModelRenderer bow;
	private final ModelRenderer cube_r122;
	private final ModelRenderer cube_r123;
	private final ModelRenderer wing;
	private final ModelRenderer right_total;
	private final ModelRenderer right_arm;
	private final ModelRenderer cuff2;
	private final ModelRenderer ring4;
	private final ModelRenderer ring5;
	private final ModelRenderer ring6;
	private final ModelRenderer sleeve2;

	public MistyChestplateModel() {
		super(1.0f);

		textureWidth = 128;
		textureHeight = 128;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(-5.0F, -22.0F, 0.0F);
		main.addChild(left_total);
		

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(1.5F, 6.0F, 0.0F);
		left_total.addChild(left_arm);
		

		cuff = new ModelRenderer(this);
		cuff.setRotationPoint(-8.0F, 17.0F, 0.0F);
		left_arm.addChild(cuff);
		

		ring1 = new ModelRenderer(this);
		ring1.setRotationPoint(0.0F, 0.0F, 0.0F);
		cuff.addChild(ring1);
		ring1.setTextureOffset(76, 38).addBox(8.0F, -21.5F, 3.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring1.setTextureOffset(65, 76).addBox(8.0F, -21.5F, -4.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring1.setTextureOffset(43, 86).addBox(7.25F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		ring1.setTextureOffset(87, 20).addBox(15.75F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		ring1.setTextureOffset(65, 73).addBox(8.0F, -16.5F, 3.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring1.setTextureOffset(76, 35).addBox(8.0F, -16.5F, -4.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring1.setTextureOffset(0, 86).addBox(7.25F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		ring1.setTextureOffset(86, 35).addBox(15.75F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		ring2 = new ModelRenderer(this);
		ring2.setRotationPoint(0.0F, 0.0F, 0.0F);
		cuff.addChild(ring2);
		ring2.setTextureOffset(96, 39).addBox(7.5F, -20.0F, -5.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(104, 8).addBox(15.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(80, 0).addBox(16.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring2.setTextureOffset(101, 18).addBox(15.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(96, 37).addBox(7.5F, -20.0F, 4.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(100, 8).addBox(7.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(31, 79).addBox(6.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring2.setTextureOffset(100, 41).addBox(7.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(96, 33).addBox(7.5F, -17.0F, -5.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(42, 92).addBox(15.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(76, 55).addBox(16.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring2.setTextureOffset(113, 27).addBox(15.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(96, 35).addBox(7.5F, -17.0F, 4.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(96, 41).addBox(7.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring2.setTextureOffset(11, 79).addBox(6.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring2.setTextureOffset(114, 8).addBox(7.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ring3 = new ModelRenderer(this);
		ring3.setRotationPoint(0.0F, 0.0F, 0.0F);
		cuff.addChild(ring3);
		ring3.setTextureOffset(30, 55).addBox(6.25F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
		ring3.setTextureOffset(53, 36).addBox(16.75F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
		ring3.setTextureOffset(87, 55).addBox(7.0F, -19.0F, -5.75F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		ring3.setTextureOffset(87, 30).addBox(7.0F, -19.0F, 4.75F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		ring3.setTextureOffset(112, 44).addBox(16.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ring3.setTextureOffset(112, 41).addBox(7.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ring3.setTextureOffset(111, 79).addBox(7.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ring3.setTextureOffset(111, 76).addBox(16.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		sleeve = new ModelRenderer(this);
		sleeve.setRotationPoint(-8.0F, 16.0F, 0.0F);
		left_arm.addChild(sleeve);
		sleeve.setTextureOffset(20, 49).addBox(7.25F, -13.5F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		sleeve.setTextureOffset(0, 49).addBox(7.0F, -7.5F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		sleeve.setTextureOffset(54, 73).addBox(15.85F, -13.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve.setTextureOffset(70, 13).addBox(16.1F, -10.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve.setTextureOffset(69, 1).addBox(16.5F, -7.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve.setTextureOffset(31, 67).addBox(16.8F, -4.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve.setTextureOffset(95, 68).addBox(7.5F, -13.5F, -4.85F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(95, 64).addBox(7.5F, -10.5F, -4.95F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(65, 94).addBox(7.5F, -7.5F, -5.1F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(111, 72).addBox(16.0F, -7.5F, -4.75F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(16, 111).addBox(16.0F, -7.5F, 3.75F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(86, 45).addBox(7.5F, -4.5F, -5.2F, 10.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(85, 94).addBox(7.5F, -13.5F, 3.85F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(94, 86).addBox(7.5F, -10.5F, 3.95F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(94, 82).addBox(7.5F, -7.5F, 4.1F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve.setTextureOffset(85, 75).addBox(7.5F, -4.5F, 4.3F, 10.0F, 3.0F, 1.0F, 0.0F, false);

		body_total = new ModelRenderer(this);
		body_total.setRotationPoint(0.0F, -24.0F, 0.0F);
		main.addChild(body_total);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body_total.addChild(body);
		

		up = new ModelRenderer(this);
		up.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(up);
		up.setTextureOffset(0, 27).addBox(-8.0F, -20.0F, -5.25F, 16.0F, 6.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(0, 13).addBox(-8.0F, -20.0F, 4.25F, 16.0F, 6.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(20, 34).addBox(7.75F, -20.0F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		up.setTextureOffset(0, 34).addBox(-8.75F, -20.0F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		up.setTextureOffset(43, 63).addBox(-8.5F, -14.0F, -4.5F, 1.0F, 4.0F, 9.0F, 0.0F, false);
		up.setTextureOffset(59, 19).addBox(7.5F, -14.0F, -4.5F, 1.0F, 4.0F, 9.0F, 0.0F, false);
		up.setTextureOffset(75, 44).addBox(7.7F, -10.0F, -4.5F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		up.setTextureOffset(0, 20).addBox(-8.0F, -14.0F, -5.0F, 16.0F, 6.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(54, 63).addBox(-3.5F, -14.0F, -5.3F, 7.0F, 6.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(65, 39).addBox(-2.75F, -13.0F, -5.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(65, 11).addBox(1.75F, -13.0F, -5.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(5, 56).addBox(1.75F, -10.0F, -5.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(61, 7).addBox(-2.75F, -10.0F, -5.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(34, 16).addBox(-8.0F, -14.0F, 4.0F, 16.0F, 4.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(32, 32).addBox(-8.0F, -10.0F, 3.2F, 16.0F, 2.0F, 2.0F, 0.0F, false);
		up.setTextureOffset(74, 73).addBox(-8.8F, -10.0F, -4.5F, 1.0F, 2.0F, 9.0F, 0.0F, false);

		dress = new ModelRenderer(this);
		dress.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(dress);
		

		outside = new ModelRenderer(this);
		outside.setRotationPoint(-3.1828F, -6.0162F, -5.9904F);
		dress.addChild(outside);
		setRotationAngle(outside, 0.2618F, 0.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.5128F, 3.988F, 11.4321F);
		outside.addChild(cube_r1);
		setRotationAngle(cube_r1, -2.763F, -0.1923F, 2.7532F);
		cube_r1.setTextureOffset(76, 84).addBox(-3.0F, -1.0F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-3.8801F, 4.9714F, 11.168F);
		outside.addChild(cube_r2);
		setRotationAngle(cube_r2, -2.7902F, 0.2071F, 3.0314F);
		cube_r2.setTextureOffset(53, 79).addBox(-3.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-5.5041F, 5.0297F, 10.4907F);
		outside.addChild(cube_r3);
		setRotationAngle(cube_r3, -2.727F, 0.5804F, -3.0903F);
		cube_r3.setTextureOffset(34, 82).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-6.4267F, 4.7687F, 9.298F);
		outside.addChild(cube_r4);
		setRotationAngle(cube_r4, -2.1616F, 1.1532F, -2.3894F);
		cube_r4.setTextureOffset(10, 89).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-6.8495F, 4.3535F, 7.9393F);
		outside.addChild(cube_r5);
		setRotationAngle(cube_r5, -2.0931F, 1.1716F, -2.3147F);
		cube_r5.setTextureOffset(113, 18).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-7.067F, 3.5784F, 5.6976F);
		outside.addChild(cube_r6);
		setRotationAngle(cube_r6, -1.5407F, 1.2271F, -1.7243F);
		cube_r6.setTextureOffset(75, 50).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-6.9621F, 2.9193F, 3.9409F);
		outside.addChild(cube_r7);
		setRotationAngle(cube_r7, -1.0055F, 1.1605F, -1.1511F);
		cube_r7.setTextureOffset(80, 5).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-5.7867F, 1.8278F, 1.3565F);
		outside.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.429F, 0.7378F, -0.4512F);
		cube_r8.setTextureOffset(22, 85).addBox(-1.5F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(3.3551F, 2.1678F, 10.6717F);
		outside.addChild(cube_r9);
		setRotationAngle(cube_r9, -2.772F, 0.0043F, 2.1169F);
		cube_r9.setTextureOffset(0, 76).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(2.3002F, 3.7827F, 10.6877F);
		outside.addChild(cube_r10);
		setRotationAngle(cube_r10, -2.7725F, -0.0209F, 2.182F);
		cube_r10.setTextureOffset(77, 30).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.8192F, 4.8306F, 10.96F);
		outside.addChild(cube_r11);
		setRotationAngle(cube_r11, -2.839F, -0.2156F, 2.7289F);
		cube_r11.setTextureOffset(64, 54).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-1.6153F, 5.6032F, 11.2449F);
		outside.addChild(cube_r12);
		setRotationAngle(cube_r12, -2.8847F, -0.0237F, 2.9477F);
		cube_r12.setTextureOffset(31, 55).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-6.758F, 6.1286F, 9.5562F);
		outside.addChild(cube_r13);
		setRotationAngle(cube_r13, -2.8604F, 0.4144F, 3.0696F);
		cube_r13.setTextureOffset(81, 13).addBox(-4.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-6.1373F, 5.9478F, 9.3208F);
		outside.addChild(cube_r14);
		setRotationAngle(cube_r14, -2.7765F, 0.7792F, -3.0669F);
		cube_r14.setTextureOffset(0, 86).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-7.7293F, 5.7491F, 7.4464F);
		outside.addChild(cube_r15);
		setRotationAngle(cube_r15, -1.9722F, 1.2912F, -2.1744F);
		cube_r15.setTextureOffset(42, 61).addBox(-1.5F, -1.0F, -0.4F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-7.5273F, 4.7861F, 3.2003F);
		outside.addChild(cube_r16);
		setRotationAngle(cube_r16, -1.0533F, 1.2742F, -1.2216F);
		cube_r16.setTextureOffset(32, 85).addBox(-3.0F, -1.2F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-7.5484F, 4.8162F, 3.2982F);
		outside.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.6413F, 1.1322F, -0.7821F);
		cube_r17.setTextureOffset(42, 89).addBox(0.0F, -1.2F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-7.6534F, 3.1313F, -1.3758F);
		outside.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.4982F, 0.7886F, -0.5538F);
		cube_r18.setTextureOffset(53, 76).addBox(-2.2367F, -1.023F, 1.9903F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-2.1836F, 2.779F, -1.3388F);
		outside.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.3442F, -0.0594F, -0.1642F);
		cube_r19.setTextureOffset(65, 79).addBox(-2.7939F, -1.6343F, -0.1015F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-3.1436F, -0.7495F, 0.6904F);
		outside.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.3123F, -0.1586F, -0.4549F);
		cube_r20.setTextureOffset(22, 79).addBox(1.0161F, 2.9691F, -0.8015F, 8.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-2.715F, -0.6074F, 0.0904F);
		outside.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.3463F, -0.0447F, -0.1231F);
		cube_r21.setTextureOffset(31, 40).addBox(-1.9989F, 0.4914F, -0.2004F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-2.715F, -0.6074F, 0.0904F);
		outside.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.3295F, -0.1172F, -0.3295F);
		cube_r22.setTextureOffset(76, 65).addBox(0.203F, 0.6918F, -0.2004F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(4.6497F, 1.4109F, 11.4509F);
		outside.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.0878F, 0.0444F, -0.6558F);
		cube_r23.setTextureOffset(53, 40).addBox(-2.5633F, -1.0231F, -1.4666F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(6.1483F, -2.1702F, 0.6904F);
		outside.addChild(cube_r24);
		setRotationAngle(cube_r24, -0.3848F, -0.0647F, 0.0262F);
		cube_r24.setTextureOffset(22, 82).addBox(-4.0F, -0.4129F, -0.4149F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(0.0905F, 3.3657F, 10.9857F);
		outside.addChild(cube_r25);
		setRotationAngle(cube_r25, -2.7862F, -0.1855F, 3.064F);
		cube_r25.setTextureOffset(53, 36).addBox(-2.5F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-2.7133F, 3.4306F, 11.0923F);
		outside.addChild(cube_r26);
		setRotationAngle(cube_r26, -2.7903F, 0.1096F, -3.1108F);
		cube_r26.setTextureOffset(11, 67).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-5.1686F, 3.1199F, 10.1761F);
		outside.addChild(cube_r27);
		setRotationAngle(cube_r27, -2.7156F, 0.596F, -2.9014F);
		cube_r27.setTextureOffset(42, 40).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-6.4371F, 2.2621F, 7.787F);
		outside.addChild(cube_r28);
		setRotationAngle(cube_r28, -1.9075F, 1.2F, -1.9393F);
		cube_r28.setTextureOffset(75, 46).addBox(-2.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(-6.4698F, 1.6216F, 6.0262F);
		outside.addChild(cube_r29);
		setRotationAngle(cube_r29, -1.3052F, 1.2085F, -1.297F);
		cube_r29.setTextureOffset(0, 89).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-6.3067F, 0.7583F, 3.6586F);
		outside.addChild(cube_r30);
		setRotationAngle(cube_r30, -1.4429F, 1.2187F, -1.444F);
		cube_r30.setTextureOffset(53, 50).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-5.3588F, -0.0322F, 1.511F);
		outside.addChild(cube_r31);
		setRotationAngle(cube_r31, -0.4927F, 0.7626F, -0.3644F);
		cube_r31.setTextureOffset(64, 50).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-2.715F, -0.6074F, 0.2904F);
		outside.addChild(cube_r32);
		setRotationAngle(cube_r32, -0.3491F, -0.003F, -0.0082F);
		cube_r32.setTextureOffset(76, 68).addBox(-2.0F, -1.4F, -0.1F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(-2.715F, -0.6074F, 0.2904F);
		outside.addChild(cube_r33);
		setRotationAngle(cube_r33, -0.3478F, -0.0298F, -0.082F);
		cube_r33.setTextureOffset(42, 46).addBox(2.1F, -1.3F, -0.1F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		inside = new ModelRenderer(this);
		inside.setRotationPoint(4.0712F, -1.6285F, -5.5F);
		dress.addChild(inside);
		

		one = new ModelRenderer(this);
		one.setRotationPoint(-8.0367F, 2.1643F, 11.3628F);
		inside.addChild(one);
		

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(12.4558F, -1.537F, -2.4412F);
		one.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0436F, -0.0023F, -0.1222F);
		cube_r34.setTextureOffset(101, 98).addBox(-0.6F, -7.0F, 0.6F, 1.0F, 15.0F, 1.0F, 0.0F, true);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(12.0111F, 0.4125F, -1.0476F);
		one.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0523F, 0.0027F, -0.061F);
		cube_r35.setTextureOffset(69, 98).addBox(-0.5F, -9.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(12.8558F, -1.537F, -2.4412F);
		one.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0436F, -0.0023F, -0.1222F);
		cube_r36.setTextureOffset(101, 98).addBox(-0.6F, -7.0F, 0.6F, 1.0F, 15.0F, 1.0F, 0.0F, true);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(13.6176F, -0.6241F, -6.3348F);
		one.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0017F, 0.0089F, -0.1656F);
		cube_r37.setTextureOffset(101, 98).addBox(-1.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, 0.0F, true);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(14.1176F, -0.7241F, -7.3348F);
		one.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0009F, 0.009F, -0.2267F);
		cube_r38.setTextureOffset(101, 98).addBox(-1.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, 0.0F, true);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(14.5894F, -0.802F, -7.3373F);
		one.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0005F, 0.0091F, -0.2791F);
		cube_r39.setTextureOffset(101, 98).addBox(-1.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, 0.0F, true);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(14.9585F, -0.8888F, -7.3386F);
		one.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0003F, 0.0091F, -0.3314F);
		cube_r40.setTextureOffset(101, 98).addBox(-1.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, 0.0F, true);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(15.2558F, -1.037F, -7.3412F);
		one.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0002F, 0.0091F, -0.3663F);
		cube_r41.setTextureOffset(73, 98).addBox(-1.0F, -8.1F, 1.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(14.9585F, -0.8888F, -9.3386F);
		one.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0003F, 0.0091F, -0.3314F);
		cube_r42.setTextureOffset(73, 98).addBox(-1.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(14.6894F, -0.802F, -11.3373F);
		one.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0005F, 0.0091F, -0.2965F);
		cube_r43.setTextureOffset(73, 98).addBox(-1.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(14.4176F, -0.7241F, -13.3348F);
		one.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0008F, 0.009F, -0.2616F);
		cube_r44.setTextureOffset(73, 98).addBox(-1.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(13.5182F, -1.1885F, -9.7809F);
		one.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0012F, 0.009F, -0.218F);
		cube_r45.setTextureOffset(73, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(13.0182F, -1.1885F, -10.2809F);
		one.addChild(cube_r46);
		setRotationAngle(cube_r46, -0.0683F, 0.0114F, -0.1831F);
		cube_r46.setTextureOffset(77, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(0.0F, 0.4F, 0.0F);
		one.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.1309F, 0.0F, 0.0F);
		cube_r47.setTextureOffset(0, 96).addBox(0.0F, -9.5F, -0.5F, 1.0F, 19.0F, 1.0F, 0.0F, false);
		cube_r47.setTextureOffset(8, 96).addBox(6.931F, -9.5F, -0.5F, 1.0F, 19.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(0.0F, 0.4F, 0.4F);
		one.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.1745F, 0.0F, 0.0F);
		cube_r48.setTextureOffset(26, 89).addBox(1.0F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, 0.0F, false);
		cube_r48.setTextureOffset(22, 89).addBox(2.0F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, 0.0F, false);
		cube_r48.setTextureOffset(30, 89).addBox(5.931F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, 0.0F, false);
		cube_r48.setTextureOffset(34, 89).addBox(4.931F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(0.0F, 0.4F, 0.8F);
		one.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.2182F, 0.0F, 0.0F);
		cube_r49.setTextureOffset(61, 85).addBox(3.0F, -9.5F, -0.5F, 1.0F, 21.0F, 1.0F, 0.0F, false);
		cube_r49.setTextureOffset(18, 89).addBox(3.931F, -9.5F, -0.5F, 1.0F, 21.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(0.0F, 0.4F, 0.0F);
		one.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.1309F, 0.0F, 0.0F);
		cube_r50.setTextureOffset(38, 89).addBox(-1.0F, -9.4998F, -0.5109F, 1.0F, 19.0F, 1.0F, 0.0F, false);
		cube_r50.setTextureOffset(4, 96).addBox(7.931F, -9.4998F, -0.5109F, 1.0F, 19.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(0.0F, 0.0F, -0.4F);
		one.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0873F, 0.0F, 0.0F);
		cube_r51.setTextureOffset(42, 96).addBox(-2.0F, -9.499F, -0.5218F, 1.0F, 18.0F, 1.0F, 0.0F, false);
		cube_r51.setTextureOffset(50, 96).addBox(8.931F, -9.499F, -0.5218F, 1.0F, 18.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(0.0F, 0.0F, -0.4F);
		one.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0873F, 0.0F, 0.0F);
		cube_r52.setTextureOffset(12, 96).addBox(-3.0F, -9.4981F, -0.5436F, 1.0F, 18.0F, 1.0F, 0.0F, false);
		cube_r52.setTextureOffset(46, 96).addBox(9.931F, -9.4981F, -0.5436F, 1.0F, 18.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(0.0F, -0.1F, -0.6F);
		one.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0611F, 0.0F, 0.0F);
		cube_r53.setTextureOffset(54, 96).addBox(-4.0F, -9.4914F, -0.6305F, 1.0F, 17.0F, 1.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(-4.0801F, 0.4125F, -1.0476F);
		one.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0523F, -0.0027F, 0.061F);
		cube_r54.setTextureOffset(69, 98).addBox(-0.5F, -9.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(-4.5248F, -1.537F, -2.4412F);
		one.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0436F, 0.0023F, 0.1222F);
		cube_r55.setTextureOffset(101, 98).addBox(-0.4F, -7.0F, 0.6F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(-4.5873F, -1.0885F, -10.4809F);
		one.addChild(cube_r56);
		setRotationAngle(cube_r56, -0.0677F, -0.0143F, 0.1396F);
		cube_r56.setTextureOffset(37, 109).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(-5.0873F, -1.1885F, -10.2809F);
		one.addChild(cube_r57);
		setRotationAngle(cube_r57, -0.0683F, -0.0114F, 0.1831F);
		cube_r57.setTextureOffset(81, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(-5.5873F, -1.1885F, -9.7809F);
		one.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0012F, -0.009F, 0.218F);
		cube_r58.setTextureOffset(85, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(-6.4866F, -0.7241F, -13.3348F);
		one.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.0008F, -0.009F, 0.2616F);
		cube_r59.setTextureOffset(85, 98).addBox(0.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(-5.6866F, -0.6241F, -6.3348F);
		one.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0017F, -0.0089F, 0.1656F);
		cube_r60.setTextureOffset(101, 98).addBox(0.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(-6.1866F, -0.7241F, -7.3348F);
		one.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0009F, -0.009F, 0.2267F);
		cube_r61.setTextureOffset(101, 98).addBox(0.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(-6.7584F, -0.802F, -11.3373F);
		one.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0005F, -0.0091F, 0.2965F);
		cube_r62.setTextureOffset(85, 98).addBox(0.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(-6.6584F, -0.802F, -7.3373F);
		one.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.0005F, -0.0091F, 0.2791F);
		cube_r63.setTextureOffset(101, 98).addBox(0.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(-7.0275F, -0.8888F, -9.3386F);
		one.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.0003F, -0.0091F, 0.3314F);
		cube_r64.setTextureOffset(85, 98).addBox(0.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setRotationPoint(-7.0275F, -0.8888F, -7.3386F);
		one.addChild(cube_r65);
		setRotationAngle(cube_r65, 0.0003F, -0.0091F, 0.3314F);
		cube_r65.setTextureOffset(101, 98).addBox(0.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setRotationPoint(-7.3248F, -1.037F, -7.3412F);
		one.addChild(cube_r66);
		setRotationAngle(cube_r66, 0.0002F, -0.0091F, 0.3663F);
		cube_r66.setTextureOffset(93, 98).addBox(0.0F, -8.1F, 1.05F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setRotationPoint(-4.469F, -0.0924F, -10.6988F);
		one.addChild(cube_r67);
		setRotationAngle(cube_r67, -0.0872F, 0.0019F, 0.0872F);
		cube_r67.setTextureOffset(89, 98).addBox(-0.5F, -8.5F, -0.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setRotationPoint(-4.169F, 3.4082F, -10.9938F);
		one.addChild(cube_r68);
		setRotationAngle(cube_r68, -0.0872F, 0.003F, 0.0348F);
		cube_r68.setTextureOffset(69, 85).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setRotationPoint(-1.569F, -1.1163F, -11.1028F);
		one.addChild(cube_r69);
		setRotationAngle(cube_r69, -0.1047F, 0.0F, 0.0F);
		cube_r69.setTextureOffset(89, 98).addBox(-2.5F, -7.4762F, -0.2959F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r69.setTextureOffset(97, 98).addBox(-1.5F, -7.4762F, -0.2959F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setRotationPoint(7.931F, -0.1F, -0.7F);
		one.addChild(cube_r70);
		setRotationAngle(cube_r70, 0.0436F, 0.0F, 0.0F);
		cube_r70.setTextureOffset(65, 98).addBox(3.0F, -9.4914F, -0.6305F, 1.0F, 17.0F, 1.0F, 0.0F, false);

		cube_r71 = new ModelRenderer(this);
		cube_r71.setRotationPoint(-1.569F, -1.1163F, -11.0028F);
		one.addChild(cube_r71);
		setRotationAngle(cube_r71, -0.1134F, 0.0F, 0.0F);
		cube_r71.setTextureOffset(105, 92).addBox(-0.5F, -7.4473F, -0.5096F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		cube_r71.setTextureOffset(58, 106).addBox(0.5F, -7.4473F, -0.5096F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setRotationPoint(-1.569F, -1.1163F, -11.0028F);
		one.addChild(cube_r72);
		setRotationAngle(cube_r72, -0.1396F, 0.0F, 0.0F);
		cube_r72.setTextureOffset(109, 18).addBox(1.5F, -7.5124F, -0.7312F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setRotationPoint(6.931F, -9.4222F, -11.7128F);
		one.addChild(cube_r73);
		setRotationAngle(cube_r73, -0.1571F, 0.0F, 0.0F);
		cube_r73.setTextureOffset(109, 106).addBox(-6.0F, 0.7F, 1.1F, 1.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setRotationPoint(12.7957F, 0.5219F, -10.7349F);
		one.addChild(cube_r74);
		setRotationAngle(cube_r74, -3.0555F, 0.0144F, 2.9764F);
		cube_r74.setTextureOffset(105, 107).addBox(-0.5F, -8.4F, -0.5F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r75 = new ModelRenderer(this);
		cube_r75.setRotationPoint(11.6243F, 5.3194F, -11.7554F);
		one.addChild(cube_r75);
		setRotationAngle(cube_r75, -3.0552F, 0.0121F, 3.0025F);
		cube_r75.setTextureOffset(57, 89).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setRotationPoint(12.131F, 5.0268F, -11.5215F);
		one.addChild(cube_r76);
		setRotationAngle(cube_r76, -3.0554F, 0.0136F, 2.9851F);
		cube_r76.setTextureOffset(53, 89).addBox(-0.9F, -2.9F, -0.7F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setRotationPoint(11.8841F, -2.8139F, -10.6348F);
		one.addChild(cube_r77);
		setRotationAngle(cube_r77, -3.0546F, 0.0068F, 3.0634F);
		cube_r77.setTextureOffset(33, 110).addBox(-0.3F, -5.0F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setRotationPoint(6.631F, -6.9222F, -9.6628F);
		one.addChild(cube_r78);
		setRotationAngle(cube_r78, -3.002F, 0.0F, 3.1416F);
		cube_r78.setTextureOffset(109, 92).addBox(-5.0F, -0.3F, 0.3F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setRotationPoint(6.631F, -6.9222F, -9.3628F);
		one.addChild(cube_r79);
		setRotationAngle(cube_r79, -2.9932F, 0.0F, -3.1416F);
		cube_r79.setTextureOffset(21, 110).addBox(-4.0F, -0.3F, 0.7F, 1.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setRotationPoint(6.631F, -6.9222F, -9.3628F);
		one.addChild(cube_r80);
		setRotationAngle(cube_r80, -2.9671F, 0.0F, -3.1416F);
		cube_r80.setTextureOffset(25, 110).addBox(-3.0F, -0.3F, 0.7F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setRotationPoint(5.631F, -6.9222F, -10.0628F);
		one.addChild(cube_r81);
		setRotationAngle(cube_r81, -2.9409F, 0.0F, -3.1416F);
		cube_r81.setTextureOffset(73, 0).addBox(-1.0F, -0.3F, -0.3F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setRotationPoint(6.631F, -6.9222F, -10.3628F);
		one.addChild(cube_r82);
		setRotationAngle(cube_r82, -2.8711F, 0.0F, -3.1416F);
		cube_r82.setTextureOffset(109, 54).addBox(-1.0F, -0.3F, -1.1F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setRotationPoint(8.131F, -0.8816F, -11.7043F);
		one.addChild(cube_r83);
		setRotationAngle(cube_r83, -2.9496F, 0.0F, -3.1416F);
		cube_r83.setTextureOffset(108, 41).addBox(-0.5F, -6.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		cube_r84 = new ModelRenderer(this);
		cube_r84.setRotationPoint(6.931F, -9.4222F, -11.7128F);
		one.addChild(cube_r84);
		setRotationAngle(cube_r84, -0.1745F, 0.0F, 0.0F);
		cube_r84.setTextureOffset(105, 18).addBox(-5.0F, 0.7F, 1.1F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setRotationPoint(6.931F, -9.4222F, -11.7128F);
		one.addChild(cube_r85);
		setRotationAngle(cube_r85, -0.1833F, 0.0F, 0.0F);
		cube_r85.setTextureOffset(29, 110).addBox(-4.0F, 0.7F, 1.1F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setRotationPoint(6.931F, -9.4222F, -11.7128F);
		one.addChild(cube_r86);
		setRotationAngle(cube_r86, -0.2007F, 0.0F, 0.0F);
		cube_r86.setTextureOffset(107, 72).addBox(-3.0F, 0.7F, 1.1F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		cube_r86.setTextureOffset(70, 13).addBox(-2.0F, 0.7F, 1.1F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r87 = new ModelRenderer(this);
		cube_r87.setRotationPoint(11.431F, -8.0596F, -10.7912F);
		one.addChild(cube_r87);
		setRotationAngle(cube_r87, -0.3403F, 0.0F, 0.0F);
		cube_r87.setTextureOffset(112, 47).addBox(-0.5F, -0.4F, -0.2F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setRotationPoint(6.931F, -9.0212F, -12.0428F);
		one.addChild(cube_r88);
		setRotationAngle(cube_r88, -0.3316F, 0.0F, 0.0F);
		cube_r88.setTextureOffset(104, 41).addBox(3.0F, 0.1F, 1.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setRotationPoint(6.931F, -8.9897F, -12.0559F);
		one.addChild(cube_r89);
		setRotationAngle(cube_r89, -0.3054F, 0.0F, 0.0F);
		cube_r89.setTextureOffset(88, 68).addBox(2.0F, 0.1F, 1.3F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r90 = new ModelRenderer(this);
		cube_r90.setRotationPoint(6.931F, -8.9222F, -12.0628F);
		one.addChild(cube_r90);
		setRotationAngle(cube_r90, -0.2705F, 0.0F, 0.0F);
		cube_r90.setTextureOffset(111, 0).addBox(1.0F, 0.1F, 1.3F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setRotationPoint(6.931F, -8.7222F, -12.0628F);
		one.addChild(cube_r91);
		setRotationAngle(cube_r91, -0.2443F, 0.0F, 0.0F);
		cube_r91.setTextureOffset(65, 85).addBox(0.0F, -0.1F, 1.3F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setRotationPoint(6.931F, -8.7222F, -11.7628F);
		one.addChild(cube_r92);
		setRotationAngle(cube_r92, -0.2182F, 0.0F, 0.0F);
		cube_r92.setTextureOffset(74, 13).addBox(-1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		two = new ModelRenderer(this);
		two.setRotationPoint(0.0F, -1.0F, 0.0F);
		inside.addChild(two);
		

		cube_r93 = new ModelRenderer(this);
		cube_r93.setRotationPoint(2.9288F, -1.3368F, 7.4276F);
		two.addChild(cube_r93);
		setRotationAngle(cube_r93, 0.0F, 0.0F, -0.2182F);
		cube_r93.setTextureOffset(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, 0.0F, false);
		cube_r93.setTextureOffset(97, 18).addBox(0.0F, 0.0099F, -4.9612F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r94 = new ModelRenderer(this);
		cube_r94.setRotationPoint(-12.0712F, -1.3368F, 7.4276F);
		two.addChild(cube_r94);
		setRotationAngle(cube_r94, 0.0F, 0.0F, 0.2182F);
		cube_r94.setTextureOffset(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, 0.0F, false);
		cube_r94.setTextureOffset(97, 18).addBox(0.0F, 0.0099F, -4.9612F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r95 = new ModelRenderer(this);
		cube_r95.setRotationPoint(2.9288F, -1.3368F, 5.4276F);
		two.addChild(cube_r95);
		setRotationAngle(cube_r95, 0.0F, 0.0F, -0.3054F);
		cube_r95.setTextureOffset(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r96 = new ModelRenderer(this);
		cube_r96.setRotationPoint(-12.0712F, -1.3368F, 5.4276F);
		two.addChild(cube_r96);
		setRotationAngle(cube_r96, 0.0F, 0.0F, 0.3054F);
		cube_r96.setTextureOffset(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r97 = new ModelRenderer(this);
		cube_r97.setRotationPoint(2.9288F, -1.3368F, 2.4276F);
		two.addChild(cube_r97);
		setRotationAngle(cube_r97, 0.0F, 0.0F, -0.1309F);
		cube_r97.setTextureOffset(69, 0).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r97.setTextureOffset(69, 0).addBox(0.0F, 0.0099F, 6.0388F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r98 = new ModelRenderer(this);
		cube_r98.setRotationPoint(-12.0712F, -1.3368F, 9.4276F);
		two.addChild(cube_r98);
		setRotationAngle(cube_r98, 0.0F, 0.0F, 0.1309F);
		cube_r98.setTextureOffset(69, 0).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r98.setTextureOffset(69, 0).addBox(0.0F, 0.0099F, -7.9612F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r99 = new ModelRenderer(this);
		cube_r99.setRotationPoint(-4.0712F, -1.3368F, 8.4276F);
		two.addChild(cube_r99);
		setRotationAngle(cube_r99, 0.2094F, 0.0F, 0.0F);
		cube_r99.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r100 = new ModelRenderer(this);
		cube_r100.setRotationPoint(-2.0712F, -1.3368F, 8.4276F);
		two.addChild(cube_r100);
		setRotationAngle(cube_r100, 0.1658F, 0.0F, 0.0F);
		cube_r100.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r100.setTextureOffset(0, 34).addBox(-5.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r101 = new ModelRenderer(this);
		cube_r101.setRotationPoint(-0.0712F, -1.3368F, 8.4276F);
		two.addChild(cube_r101);
		setRotationAngle(cube_r101, 0.1222F, 0.0F, 0.0F);
		cube_r101.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r101.setTextureOffset(0, 34).addBox(-9.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r102 = new ModelRenderer(this);
		cube_r102.setRotationPoint(1.9288F, -1.3368F, 8.4276F);
		two.addChild(cube_r102);
		setRotationAngle(cube_r102, 0.0785F, 0.0F, 0.0F);
		cube_r102.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r102.setTextureOffset(0, 34).addBox(-13.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r103 = new ModelRenderer(this);
		cube_r103.setRotationPoint(3.9288F, -1.3368F, 8.4276F);
		two.addChild(cube_r103);
		setRotationAngle(cube_r103, 0.0349F, 0.0F, 0.0F);
		cube_r103.setTextureOffset(69, 0).addBox(-1.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r103.setTextureOffset(69, 0).addBox(-16.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r104 = new ModelRenderer(this);
		cube_r104.setRotationPoint(-11.0712F, -1.3368F, 1.4276F);
		two.addChild(cube_r104);
		setRotationAngle(cube_r104, -0.0349F, 0.0F, 0.0F);
		cube_r104.setTextureOffset(69, 0).addBox(-1.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r104.setTextureOffset(69, 0).addBox(14.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r105 = new ModelRenderer(this);
		cube_r105.setRotationPoint(-10.0712F, -1.3368F, 1.4276F);
		two.addChild(cube_r105);
		setRotationAngle(cube_r105, -0.0785F, 0.0F, 0.0F);
		cube_r105.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r105.setTextureOffset(0, 34).addBox(11.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r106 = new ModelRenderer(this);
		cube_r106.setRotationPoint(-8.0712F, -1.3368F, 1.4276F);
		two.addChild(cube_r106);
		setRotationAngle(cube_r106, -0.096F, 0.0F, 0.0F);
		cube_r106.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r106.setTextureOffset(0, 34).addBox(7.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r107 = new ModelRenderer(this);
		cube_r107.setRotationPoint(-6.0712F, -1.2368F, 1.4276F);
		two.addChild(cube_r107);
		setRotationAngle(cube_r107, -0.1571F, 0.0F, 0.0F);
		cube_r107.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r107.setTextureOffset(0, 34).addBox(3.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r108 = new ModelRenderer(this);
		cube_r108.setRotationPoint(-4.0712F, -1.0868F, 1.4276F);
		two.addChild(cube_r108);
		setRotationAngle(cube_r108, -0.2094F, 0.0F, 0.0F);
		cube_r108.setTextureOffset(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		hudejie = new ModelRenderer(this);
		hudejie.setRotationPoint(0.0F, 0.0F, 0.0F);
		dress.addChild(hudejie);
		hudejie.setTextureOffset(113, 6).addBox(-2.9655F, -13.614F, 4.8988F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(112, 50).addBox(-3.9655F, -14.414F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 21).addBox(-4.9655F, -14.814F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(75, 55).addBox(-6.9655F, -15.114F, 5.5988F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 101).addBox(-7.9655F, -14.414F, 5.7488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 99).addBox(-8.9655F, -13.614F, 5.6488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 95).addBox(-8.2655F, -12.614F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(42, 86).addBox(-7.2655F, -12.014F, 5.2988F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(84, 87).addBox(-5.2655F, -11.764F, 4.0988F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		hudejie.setTextureOffset(53, 86).addBox(-3.2655F, -11.464F, 3.8988F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 89).addBox(-6.2655F, -10.914F, 5.1488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 54).addBox(-7.2655F, -10.464F, 5.4488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 27).addBox(-8.2655F, -10.064F, 5.5488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 85).addBox(-9.0655F, -9.114F, 5.5488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 60).addBox(-8.2655F, -8.114F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(10, 86).addBox(-7.2655F, -7.764F, 5.7988F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(85, 41).addBox(-5.2655F, -8.164F, 5.8488F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(114, 8).addBox(-3.2655F, -8.614F, 5.8488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 113).addBox(-2.6655F, -9.614F, 5.3988F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 103).addBox(-1.6655F, -10.214F, 5.0988F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 107).addBox(0.6655F, -10.214F, 5.0988F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(112, 105).addBox(1.9655F, -13.614F, 4.8988F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 23).addBox(3.9655F, -14.814F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(48, 6).addBox(4.9655F, -15.114F, 5.5988F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 97).addBox(6.9655F, -14.414F, 5.7488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 93).addBox(7.9655F, -13.614F, 5.6488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 91).addBox(7.2655F, -12.614F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 62).addBox(7.2655F, -10.064F, 5.5488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 58).addBox(8.0655F, -9.114F, 5.5488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 56).addBox(7.2655F, -8.114F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(81, 20).addBox(5.2655F, -7.764F, 5.5988F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(81, 16).addBox(3.2655F, -8.164F, 5.8488F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(56, 21).addBox(-2.0345F, -13.114F, 4.1488F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		hudejie.setTextureOffset(74, 60).addBox(-2.0345F, -12.664F, 5.6988F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(87, 25).addBox(1.2655F, -11.464F, 3.8988F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		hudejie.setTextureOffset(79, 28).addBox(5.2655F, -12.014F, 5.2988F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(76, 87).addBox(3.2655F, -11.764F, 4.0988F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 29).addBox(5.2655F, -10.914F, 5.1488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 25).addBox(6.2655F, -10.464F, 5.4488F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 111).addBox(2.2655F, -8.614F, 5.8988F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(113, 109).addBox(1.6655F, -9.614F, 5.4988F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hudejie.setTextureOffset(112, 31).addBox(2.9655F, -14.414F, 5.3488F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r109 = new ModelRenderer(this);
		cube_r109.setRotationPoint(-3.2245F, 5.7298F, 9.8856F);
		hudejie.addChild(cube_r109);
		setRotationAngle(cube_r109, 0.0931F, -0.043F, 0.1329F);
		cube_r109.setTextureOffset(0, 64).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r110 = new ModelRenderer(this);
		cube_r110.setRotationPoint(-2.2727F, -1.0365F, 8.7939F);
		hudejie.addChild(cube_r110);
		setRotationAngle(cube_r110, 0.224F, -0.043F, 0.1329F);
		cube_r110.setTextureOffset(21, 34).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r111 = new ModelRenderer(this);
		cube_r111.setRotationPoint(-2.1655F, -12.214F, 5.8488F);
		hudejie.addChild(cube_r111);
		setRotationAngle(cube_r111, 0.3113F, -0.043F, 0.1329F);
		cube_r111.setTextureOffset(0, 49).addBox(0.5F, 1.0F, -0.85F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r112 = new ModelRenderer(this);
		cube_r112.setRotationPoint(-3.2296F, 5.6699F, 10.1881F);
		hudejie.addChild(cube_r112);
		setRotationAngle(cube_r112, 0.0059F, -0.043F, 0.1329F);
		cube_r112.setTextureOffset(21, 49).addBox(-1.0F, 3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r113 = new ModelRenderer(this);
		cube_r113.setRotationPoint(3.2296F, 5.6699F, 10.1881F);
		hudejie.addChild(cube_r113);
		setRotationAngle(cube_r113, 0.0059F, 0.043F, -0.1329F);
		cube_r113.setTextureOffset(11, 34).addBox(-1.0F, 3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r114 = new ModelRenderer(this);
		cube_r114.setRotationPoint(3.2245F, 5.7298F, 9.8856F);
		hudejie.addChild(cube_r114);
		setRotationAngle(cube_r114, 0.0931F, 0.043F, -0.1329F);
		cube_r114.setTextureOffset(68, 32).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r115 = new ModelRenderer(this);
		cube_r115.setRotationPoint(2.2727F, -1.0365F, 8.7939F);
		hudejie.addChild(cube_r115);
		setRotationAngle(cube_r115, 0.224F, 0.043F, -0.1329F);
		cube_r115.setTextureOffset(11, 49).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r116 = new ModelRenderer(this);
		cube_r116.setRotationPoint(2.1655F, -12.214F, 5.8488F);
		hudejie.addChild(cube_r116);
		setRotationAngle(cube_r116, 0.3113F, 0.043F, -0.1329F);
		cube_r116.setTextureOffset(56, 0).addBox(-2.5F, 1.0F, -0.85F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		brace = new ModelRenderer(this);
		brace.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(brace);
		brace.setTextureOffset(80, 0).addBox(-9.0F, -24.0F, -4.75F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		brace.setTextureOffset(63, 63).addBox(-9.0F, -24.75F, -4.5F, 2.0F, 1.0F, 9.0F, 0.0F, false);
		brace.setTextureOffset(0, 80).addBox(-9.0F, -24.0F, 3.75F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		brace.setTextureOffset(11, 79).addBox(7.0F, -24.0F, -4.75F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		brace.setTextureOffset(56, 0).addBox(7.0F, -24.75F, -4.5F, 2.0F, 1.0F, 9.0F, 0.0F, false);
		brace.setTextureOffset(42, 79).addBox(7.0F, -24.0F, 3.75F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		core = new ModelRenderer(this);
		core.setRotationPoint(-0.2F, 24.0F, 0.0F);
		body.addChild(core);
		core.setTextureOffset(47, 83).addBox(-0.3F, -20.9F, -5.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		core.setTextureOffset(42, 8).addBox(-2.3F, -19.3F, -5.75F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		core.setTextureOffset(90, 20).addBox(-0.3F, -18.2F, -5.75F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r117 = new ModelRenderer(this);
		cube_r117.setRotationPoint(0.2F, -15.4F, -5.25F);
		core.addChild(cube_r117);
		setRotationAngle(cube_r117, 0.0F, 0.0F, 0.7854F);
		cube_r117.setTextureOffset(40, 11).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r118 = new ModelRenderer(this);
		cube_r118.setRotationPoint(2.7F, -18.8F, -5.25F);
		core.addChild(cube_r118);
		setRotationAngle(cube_r118, 0.0F, 0.0F, -0.7854F);
		cube_r118.setTextureOffset(5, 71).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r119 = new ModelRenderer(this);
		cube_r119.setRotationPoint(-2.3F, -18.8F, -5.25F);
		core.addChild(cube_r119);
		setRotationAngle(cube_r119, 0.0F, 0.0F, 0.7854F);
		cube_r119.setTextureOffset(81, 55).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r120 = new ModelRenderer(this);
		cube_r120.setRotationPoint(0.2F, -21.1F, -5.25F);
		core.addChild(cube_r120);
		setRotationAngle(cube_r120, 0.0F, 0.0F, 0.7854F);
		cube_r120.setTextureOffset(16, 83).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r121 = new ModelRenderer(this);
		cube_r121.setRotationPoint(0.2F, -19.0F, -5.5F);
		core.addChild(cube_r121);
		setRotationAngle(cube_r121, 0.0F, 0.0F, 0.7854F);
		cube_r121.setTextureOffset(77, 79).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		bow = new ModelRenderer(this);
		bow.setRotationPoint(0.0F, 24.75F, 0.0F);
		body.addChild(bow);
		bow.setTextureOffset(65, 44).addBox(-3.5F, -25.25F, -4.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		bow.setTextureOffset(11, 49).addBox(-4.0F, -25.25F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		bow.setTextureOffset(11, 34).addBox(3.0F, -25.25F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		bow.setTextureOffset(54, 70).addBox(-3.5F, -25.25F, 3.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r122 = new ModelRenderer(this);
		cube_r122.setRotationPoint(-2.15F, -23.95F, -4.0F);
		bow.addChild(cube_r122);
		setRotationAngle(cube_r122, 0.0F, 0.0F, 0.3491F);
		cube_r122.setTextureOffset(42, 70).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r123 = new ModelRenderer(this);
		cube_r123.setRotationPoint(2.4F, -23.95F, -4.0F);
		bow.addChild(cube_r123);
		setRotationAngle(cube_r123, 0.0F, 0.0F, -0.3491F);
		cube_r123.setTextureOffset(11, 71).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wing = new ModelRenderer(this);
		wing.setRotationPoint(0.0F, 12.0F, 10.0F);
		body.addChild(wing);
		setRotationAngle(wing, 0.0F, 0.0F, -0.6545F);
		wing.setTextureOffset(0, 6).addBox(10.2431F, -5.9771F, -0.6F, 23.0F, 1.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(0, 2).addBox(7.2431F, -2.9771F, -0.6F, 26.0F, 1.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(42, 67).addBox(7.2431F, -1.9771F, -0.6F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(70, 25).addBox(8.2431F, 0.0229F, -0.6F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(70, 25).addBox(8.2431F, 0.0229F, -0.6F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(0, 4).addBox(8.2431F, -4.9771F, -0.6F, 26.0F, 1.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(0, 0).addBox(8.2431F, -3.9771F, -0.6F, 26.0F, 1.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(0, 11).addBox(11.2431F, 0.0229F, -0.2F, 19.0F, 1.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(0, 8).addBox(11.2431F, -1.9771F, -0.2F, 20.0F, 2.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(34, 13).addBox(11.2431F, 1.0229F, 0.2F, 17.0F, 2.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(33, 26).addBox(12.2431F, 3.0229F, 0.2F, 15.0F, 1.0F, 1.0F, 0.0F, false);

		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(5.0F, -22.0F, 0.0F);
		main.addChild(right_total);
		

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-1.5F, 6.0F, 0.0F);
		right_total.addChild(right_arm);
		

		cuff2 = new ModelRenderer(this);
		cuff2.setRotationPoint(8.0F, 17.0F, 0.0F);
		right_arm.addChild(cuff2);
		

		ring4 = new ModelRenderer(this);
		ring4.setRotationPoint(0.0F, 0.0F, 0.0F);
		cuff2.addChild(ring4);
		ring4.setTextureOffset(22, 73).addBox(-16.0F, -21.5F, -4.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring4.setTextureOffset(22, 70).addBox(-16.0F, -21.5F, 3.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring4.setTextureOffset(85, 65).addBox(-8.25F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		ring4.setTextureOffset(84, 84).addBox(-16.75F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		ring4.setTextureOffset(22, 67).addBox(-16.0F, -16.5F, -4.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring4.setTextureOffset(11, 64).addBox(-16.0F, -16.5F, 3.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		ring4.setTextureOffset(66, 84).addBox(-8.25F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		ring4.setTextureOffset(81, 10).addBox(-16.75F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		ring5 = new ModelRenderer(this);
		ring5.setRotationPoint(0.0F, 0.0F, 0.0F);
		cuff2.addChild(ring5);
		ring5.setTextureOffset(95, 52).addBox(-16.5F, -20.0F, 4.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(14, 92).addBox(-16.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(42, 76).addBox(-17.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring5.setTextureOffset(10, 92).addBox(-16.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(94, 90).addBox(-16.5F, -20.0F, -5.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(88, 90).addBox(-8.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(76, 25).addBox(-7.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring5.setTextureOffset(84, 90).addBox(-8.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(87, 62).addBox(-16.5F, -17.0F, 4.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(80, 90).addBox(-16.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(0, 76).addBox(-17.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring5.setTextureOffset(76, 90).addBox(-16.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(53, 48).addBox(-16.5F, -17.0F, -5.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(82, 87).addBox(-8.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ring5.setTextureOffset(42, 36).addBox(-7.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		ring5.setTextureOffset(16, 86).addBox(-8.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ring6 = new ModelRenderer(this);
		ring6.setRotationPoint(0.0F, 0.0F, 0.0F);
		cuff2.addChild(ring6);
		ring6.setTextureOffset(52, 51).addBox(-7.25F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
		ring6.setTextureOffset(44, 0).addBox(-17.75F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
		ring6.setTextureOffset(86, 49).addBox(-17.0F, -19.0F, 4.75F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		ring6.setTextureOffset(85, 79).addBox(-17.0F, -19.0F, -5.75F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		ring6.setTextureOffset(111, 15).addBox(-17.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ring6.setTextureOffset(103, 72).addBox(-8.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ring6.setTextureOffset(47, 91).addBox(-8.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ring6.setTextureOffset(88, 84).addBox(-17.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		sleeve2 = new ModelRenderer(this);
		sleeve2.setRotationPoint(8.0F, 16.0F, 0.0F);
		right_arm.addChild(sleeve2);
		sleeve2.setTextureOffset(42, 46).addBox(-8.25F, -13.5F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		sleeve2.setTextureOffset(31, 40).addBox(-8.0F, -7.5F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		sleeve2.setTextureOffset(11, 67).addBox(-16.85F, -13.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve2.setTextureOffset(65, 32).addBox(-17.1F, -10.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve2.setTextureOffset(64, 48).addBox(-17.5F, -7.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve2.setTextureOffset(0, 64).addBox(-17.8F, -4.5F, -4.5F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		sleeve2.setTextureOffset(91, 14).addBox(-16.5F, -13.5F, 3.85F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(91, 10).addBox(-16.5F, -10.5F, 3.95F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(91, 4).addBox(-16.5F, -7.5F, 4.1F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(111, 11).addBox(-17.0F, -7.5F, 3.75F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(110, 7).addBox(-17.0F, -7.5F, -4.75F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(34, 28).addBox(-17.5F, -4.5F, 4.3F, 10.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(91, 0).addBox(-16.5F, -13.5F, -4.85F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(87, 58).addBox(-16.5F, -10.5F, -4.95F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(31, 36).addBox(-16.5F, -7.5F, -5.1F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		sleeve2.setTextureOffset(34, 21).addBox(-17.5F, -4.5F, -5.2F, 10.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		float sin = (float) Math.sin((System.currentTimeMillis() % 4000 - 1) * Math.PI / 2000);
		float deg = sin * 20f + 20f;

		this.wing.rotateAngleY = deg / -60f;

		this.right_total.copyModelAngles(this.bipedRightArm);
		this.left_total.copyModelAngles(this.bipedLeftArm);
		this.body_total.copyModelAngles(this.bipedBody);

		matrixStack.push();
		matrixStack.scale(0.55f, 0.55f, 0.61f);

		matrixStack.translate(0, -1.5, -0.03);

		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

		matrixStack.pop();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}