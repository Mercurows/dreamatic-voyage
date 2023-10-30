package tech.lq0.providencraft.models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class BreezeCrownModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer flowerZ;
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
	private final ModelRenderer flowerC;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer flower;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer wing;
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
	private final ModelRenderer crossZ;
	private final ModelRenderer cube_r33;
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
	private final ModelRenderer crossC;
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
	private final ModelRenderer chain;

	public BreezeCrownModel() {
		super(2.0f);

		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(head);
		

		flowerZ = new ModelRenderer(this);
		flowerZ.setRotationPoint(0.0F, -0.1F, 0.7F);
		head.addChild(flowerZ);
		flowerZ.setTextureOffset(30, 18).addBox(-0.5F, -14.45F, -10.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -13.45F, -10.0F);
		flowerZ.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0131F, -0.0416F, -0.393F);
		cube_r1.setTextureOffset(32, 21).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.5F, -13.95F, -10.0F);
		flowerZ.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.6458F);
		cube_r2.setTextureOffset(0, 32).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-0.5F, -13.95F, -10.0F);
		flowerZ.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.0524F);
		cube_r3.setTextureOffset(32, 0).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -13.45F, -10.0F);
		flowerZ.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0131F, 0.0416F, 0.393F);
		cube_r4.setTextureOffset(25, 32).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -13.45F, -10.0F);
		flowerZ.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 1.0472F);
		cube_r5.setTextureOffset(10, 33).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -13.45F, -10.0F);
		flowerZ.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -1.0472F);
		cube_r6.setTextureOffset(29, 33).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.5F, -13.95F, -10.0F);
		flowerZ.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.0524F);
		cube_r7.setTextureOffset(32, 5).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.5F, -13.95F, -10.0F);
		flowerZ.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.6458F);
		cube_r8.setTextureOffset(32, 8).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, -14.45F, -10.0F);
		flowerZ.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 0.2967F);
		cube_r9.setTextureOffset(4, 35).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-7.0135F, -11.6258F, -9.6F);
		flowerZ.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 0.6632F);
		cube_r10.setTextureOffset(3, 42).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(6.7187F, -11.6939F, -9.6F);
		flowerZ.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.2356F);
		cube_r11.setTextureOffset(41, 25).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(4.7187F, -13.8939F, -9.8F);
		flowerZ.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 0.3578F);
		cube_r12.setTextureOffset(32, 41).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(1.1F, -14.45F, -9.7F);
		flowerZ.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -0.2967F);
		cube_r13.setTextureOffset(41, 41).addBox(-6.0F, -1.6F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(0.0F, -14.45F, -10.0F);
		flowerZ.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -0.2967F);
		cube_r14.setTextureOffset(13, 35).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		flowerC = new ModelRenderer(this);
		flowerC.setRotationPoint(-7.0545F, -12.9926F, -0.621F);
		head.addChild(flowerC);
		

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-1.7455F, 2.3037F, -2.5679F);
		flowerC.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.2705F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(6, 32).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-1.7455F, -0.6963F, -5.0679F);
		flowerC.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.3403F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(0, 34).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(15.8545F, -0.2963F, -2.7679F);
		flowerC.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.5236F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(15, 32).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		flower = new ModelRenderer(this);
		flower.setRotationPoint(-1.7955F, -0.1639F, 1.3005F);
		flowerC.addChild(flower);
		setRotationAngle(flower, 0.1309F, 0.0F, 0.0F);
		flower.setTextureOffset(0, 15).addBox(-0.4F, -1.5935F, -1.4294F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		flower.setTextureOffset(28, 22).addBox(-0.9F, -1.0935F, -0.9294F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(0.2F, -1.1022F, -0.6737F);
		flower.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.1309F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(6, 28).addBox(-0.5F, -0.65F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.2F, -1.1364F, 0.8919F);
		flower.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.1745F, 0.0F, 0.0F);
		cube_r19.setTextureOffset(6, 28).addBox(-0.5F, -0.65F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-0.3F, 2.8163F, -0.995F);
		flower.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.2597F, 0.0338F, 0.1265F);
		cube_r20.setTextureOffset(3, 4).addBox(-0.25F, -2.5F, -0.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.2F, 4.4718F, 1.3659F);
		flower.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0436F, 0.0F, 0.0F);
		cube_r21.setTextureOffset(0, 4).addBox(-0.5F, -3.9F, -1.0F, 0.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(0.1F, -0.0935F, 0.0706F);
		flower.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.7854F, 0.0F, 0.0F);
		cube_r22.setTextureOffset(7, 12).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r22.setTextureOffset(28, 8).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		wing = new ModelRenderer(this);
		wing.setRotationPoint(0.0F, -1.1F, 0.6F);
		head.addChild(wing);
		wing.setTextureOffset(18, 18).addBox(0.7437F, -13.2754F, -9.9F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		wing.setTextureOffset(18, 2).addBox(-3.7437F, -13.2754F, -9.9F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-1.9635F, -12.2489F, -9.05F);
		wing.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -0.4451F);
		cube_r23.setTextureOffset(0, 0).addBox(-1.4308F, -0.4945F, -0.4F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(-1.9635F, -12.2489F, -9.3F);
		wing.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -0.1745F);
		cube_r24.setTextureOffset(10, 4).addBox(-1.5526F, -0.2679F, -0.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(2.0698F, -11.0203F, -8.8F);
		wing.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 0.3491F);
		cube_r25.setTextureOffset(8, 8).addBox(-2.0F, -1.65F, -0.9F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(2.339F, -11.7328F, -8.75F);
		wing.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, 0.0436F);
		cube_r26.setTextureOffset(12, 12).addBox(-1.8F, -0.8F, -0.8F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(2.1653F, -12.7176F, -8.65F);
		wing.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, -0.0873F);
		cube_r27.setTextureOffset(8, 18).addBox(-1.5F, -0.6F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(1.9635F, -12.2489F, -9.05F);
		wing.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, 0.4451F);
		cube_r28.setTextureOffset(0, 10).addBox(-1.5692F, -0.4945F, -0.4F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(1.9635F, -12.2489F, -9.3F);
		wing.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, 0.1745F);
		cube_r29.setTextureOffset(15, 15).addBox(-1.4474F, -0.2679F, -0.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-2.0698F, -11.0203F, -8.8F);
		wing.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, -0.3491F);
		cube_r30.setTextureOffset(10, 0).addBox(-1.0F, -1.65F, -0.9F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-2.339F, -11.7328F, -8.75F);
		wing.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -0.0436F);
		cube_r31.setTextureOffset(16, 7).addBox(-1.2F, -0.8F, -0.8F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-2.1653F, -12.7176F, -8.65F);
		wing.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, 0.0873F);
		cube_r32.setTextureOffset(20, 10).addBox(-1.5F, -0.6F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		crossZ = new ModelRenderer(this);
		crossZ.setRotationPoint(0.0F, 6.05F, 0.0F);
		head.addChild(crossZ);
		crossZ.setTextureOffset(23, 13).addBox(-3.0F, -21.45F, -9.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		crossZ.setTextureOffset(20, 21).addBox(0.0F, -21.45F, -9.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(1.3706F, -21.433F, -9.0F);
		crossZ.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, -0.0873F);
		cube_r33.setTextureOffset(0, 24).addBox(-1.5F, -0.2F, -0.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(0.3F, -16.4F, -8.0F);
		crossZ.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, 0.4363F);
		cube_r34.setTextureOffset(10, 24).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(1.0706F, -21.933F, -9.9F);
		crossZ.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -0.6545F);
		cube_r35.setTextureOffset(30, 26).addBox(-1.9F, -1.2F, 0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(1.3706F, -21.433F, -9.0F);
		crossZ.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, 0.0873F);
		cube_r36.setTextureOffset(0, 21).addBox(-1.5F, 0.1F, -0.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(-1.0706F, -21.933F, -9.9F);
		crossZ.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, 0.6545F);
		cube_r37.setTextureOffset(31, 12).addBox(-0.1F, -1.2F, 0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(-1.3706F, -21.433F, -9.0F);
		crossZ.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, 0.0873F);
		cube_r38.setTextureOffset(24, 5).addBox(-1.5F, -0.2F, -0.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(-1.3706F, -21.433F, -9.0F);
		crossZ.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, -0.0873F);
		cube_r39.setTextureOffset(10, 21).addBox(-1.5F, 0.1F, -0.5F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(-0.3F, -16.4F, -8.0F);
		crossZ.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, -0.4363F);
		cube_r40.setTextureOffset(16, 24).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(0.0F, -18.8F, -9.0F);
		crossZ.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, -3.0543F);
		cube_r41.setTextureOffset(22, 24).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(0.0F, -18.8F, -9.0F);
		crossZ.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, 3.0543F);
		cube_r42.setTextureOffset(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(0.0F, -20.5F, -9.0F);
		crossZ.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 0.0F, 0.1571F);
		cube_r43.setTextureOffset(26, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(0.0F, -20.5F, -9.0F);
		crossZ.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, 0.0F, -0.1571F);
		cube_r44.setTextureOffset(28, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		crossC = new ModelRenderer(this);
		crossC.setRotationPoint(8.9F, -14.3514F, 0.8F);
		head.addChild(crossC);
		setRotationAngle(crossC, -1.5708F, -1.3963F, 1.5708F);
		crossC.setTextureOffset(21, 29).addBox(-0.5F, -1.6986F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		crossC.setTextureOffset(18, 0).addBox(-2.0F, -0.2486F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		crossC.setTextureOffset(14, 30).addBox(0.0F, -0.2486F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(-0.7F, 0.0586F, 0.0213F);
		crossC.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, -1.5708F, 0.0F);
		cube_r45.setTextureOffset(10, 30).addBox(-0.1014F, -0.897F, -2.6269F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(-0.9011F, -0.5431F, 0.5587F);
		crossC.addChild(cube_r46);
		setRotationAngle(cube_r46, -0.2182F, 1.4399F, 0.0F);
		cube_r46.setTextureOffset(26, 16).addBox(-0.25F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(1.3706F, -0.2315F, 0.0F);
		crossC.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, -0.0873F);
		cube_r47.setTextureOffset(31, 31).addBox(-1.5F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(1.3706F, -0.2315F, 0.0F);
		crossC.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, 0.0873F);
		cube_r48.setTextureOffset(30, 16).addBox(-1.5F, 0.1F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(-1.3706F, -0.2315F, 0.0F);
		crossC.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 0.0F, 0.0873F);
		cube_r49.setTextureOffset(24, 0).addBox(-0.5F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(-1.3706F, -0.2315F, 0.0F);
		crossC.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 0.0F, -0.0873F);
		cube_r50.setTextureOffset(20, 5).addBox(-0.5F, 0.1F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(0.0F, 0.4014F, 0.0F);
		crossC.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.0F, -0.1309F);
		cube_r51.setTextureOffset(34, 2).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(0.0F, 0.4014F, 0.0F);
		crossC.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, 0.0F, 0.1309F);
		cube_r52.setTextureOffset(18, 34).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(0.0F, 1.2014F, 0.0F);
		crossC.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0F, 0.0F, -3.0194F);
		cube_r53.setTextureOffset(35, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(0.0F, 1.2014F, 0.0F);
		crossC.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0F, 0.0F, 3.002F);
		cube_r54.setTextureOffset(22, 35).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		chain = new ModelRenderer(this);
		chain.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(chain);
		chain.setTextureOffset(40, 7).addBox(-3.1F, -14.15F, -8.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(18, 10).addBox(-4.1F, -14.35F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(7, 40).addBox(-8.4F, -14.55F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(40, 5).addBox(-7.9F, -14.25F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(3, 40).addBox(-7.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(40, 2).addBox(-6.1F, -14.05F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(40, 0).addBox(-5.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(11, 40).addBox(-1.5F, -13.55F, -8.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(39, 38).addBox(-3.2F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(8, 21).addBox(-4.2F, -12.65F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(39, 36).addBox(-6.2F, -11.75F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(35, 39).addBox(-5.2F, -12.25F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(39, 33).addBox(-7.2F, -11.55F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(39, 31).addBox(-8.0F, -11.95F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(39, 29).addBox(-8.5F, -12.55F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(40, 10).addBox(0.5F, -13.55F, -8.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(39, 27).addBox(2.2F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(16, 18).addBox(3.2F, -12.65F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(22, 39).addBox(5.2F, -11.75F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(39, 21).addBox(4.2F, -12.25F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(14, 39).addBox(6.2F, -11.55F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(0, 39).addBox(7.0F, -11.95F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(32, 38).addBox(7.5F, -12.55F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(28, 38).addBox(7.4F, -14.55F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(38, 24).addBox(8.0F, -14.75F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(38, 19).addBox(8.0F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(19, 38).addBox(8.0F, -14.75F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(38, 16).addBox(8.0F, -14.45F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(11, 38).addBox(8.0F, -14.25F, -6.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(0, 41).addBox(8.0F, -13.95F, -5.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(41, 17).addBox(8.0F, -13.75F, -4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(7, 38).addBox(8.0F, -13.65F, -3.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(4, 27).addBox(8.0F, -13.75F, -2.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(3, 38).addBox(8.0F, -13.95F, -1.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(36, 37).addBox(8.0F, -14.55F, -0.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(38, 40).addBox(8.0F, -14.55F, 0.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(29, 40).addBox(8.0F, -13.75F, -0.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(25, 37).addBox(6.9F, -14.25F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(16, 37).addBox(6.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(37, 13).addBox(4.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(37, 11).addBox(5.1F, -14.05F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(8, 0).addBox(3.1F, -14.35F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(37, 9).addBox(2.1F, -14.15F, -8.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(26, 8).addBox(-9.0F, -13.75F, -2.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(37, 6).addBox(-9.0F, -14.55F, -0.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(37, 4).addBox(-9.0F, -13.95F, -1.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(25, 40).addBox(-9.0F, -14.55F, 0.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(37, 1).addBox(-9.0F, -12.75F, -0.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(20, 24).addBox(-9.0F, -12.15F, -1.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(14, 24).addBox(-9.0F, -11.7F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(41, 23).addBox(-9.0F, -10.9F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(0, 37).addBox(-9.0F, -11.2F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(17, 40).addBox(-9.0F, -11.2F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(36, 35).addBox(-9.0F, -11.65F, -6.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(33, 36).addBox(-9.0F, -12.15F, -7.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(36, 32).addBox(-9.0F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(36, 30).addBox(-9.0F, -12.65F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(29, 36).addBox(-9.0F, -14.75F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(36, 26).addBox(-9.0F, -14.75F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(36, 22).addBox(-9.0F, -14.45F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(8, 36).addBox(-9.0F, -14.25F, -6.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(40, 14).addBox(-9.0F, -13.95F, -5.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(14, 41).addBox(-9.0F, -13.75F, -4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(35, 28).addBox(-9.0F, -13.65F, -3.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(20, 41).addBox(8.0F, -10.9F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(40, 12).addBox(8.0F, -11.2F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(26, 35).addBox(8.0F, -11.65F, -6.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(35, 20).addBox(8.0F, -12.15F, -7.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(35, 15).addBox(8.0F, -12.65F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(34, 24).addBox(8.0F, -12.75F, -0.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(8, 24).addBox(8.0F, -12.15F, -1.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(18, 21).addBox(8.0F, -11.7F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chain.setTextureOffset(34, 10).addBox(8.0F, -11.2F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.push();
		matrixStack.scale(0.55f,0.55f,0.55f);

		this.head.copyModelAngles(this.bipedHead);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		matrixStack.pop();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}