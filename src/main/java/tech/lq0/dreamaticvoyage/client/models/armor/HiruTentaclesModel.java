package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.4
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
public class HiruTentaclesModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "hiru_tentacles_model"), "main");
    public final ModelPart armorBody;

    public HiruTentaclesModel(ModelPart root) {
        this.armorBody = root.getChild("armorBody");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = armorBody.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 2.5F));

        PartDefinition ttc1_1 = main.addOrReplaceChild("ttc1_1", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = ttc1_1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4361F, -17.4388F, 0.8415F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r2 = ttc1_1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 24).addBox(-1.0F, -0.5F, -5.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(37, 27).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.1196F, -21.1904F, -4.9413F, -1.5153F, 0.0625F, -0.0249F));

        PartDefinition cube_r3 = ttc1_1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 37).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0304F, -21.2841F, -4.8372F, -1.4293F, 0.1513F, -0.0119F));

        PartDefinition cube_r4 = ttc1_1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(37, 31).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0304F, -21.2841F, -4.8372F, -1.3408F, 0.3263F, 0.0015F));

        PartDefinition cube_r5 = ttc1_1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0304F, -21.379F, -4.8092F, -1.2027F, 0.3232F, 0.0456F));

        PartDefinition cube_r6 = ttc1_1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(21, 38).addBox(-0.75F, -1.25F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2F, -20.4732F, -4.7102F, -1.0047F, 0.4404F, 0.1082F));

        PartDefinition cube_r7 = ttc1_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(38, 24).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.8256F, -19.7863F, -4.146F, -0.848F, 0.5099F, 0.1573F));

        PartDefinition cube_r8 = ttc1_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 20).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.4562F, -18.3849F, -2.8385F, -0.714F, 0.4442F, 0.1952F));

        PartDefinition cube_r9 = ttc1_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(20, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0731F, -17.7541F, -2.0275F, -0.5617F, -0.9506F, 0.8803F));

        PartDefinition cube_r10 = ttc1_1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(34, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5908F, -17.2916F, -1.1551F, -0.1595F, -0.8996F, 0.4111F));

        PartDefinition cube_r11 = ttc1_1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(34, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0625F, -17.043F, -0.6025F, -0.0656F, -0.7371F, 0.3423F));

        PartDefinition cube_r12 = ttc1_1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(24, 34).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5683F, -16.9579F, -0.1812F, -0.0131F, -0.5231F, 0.1804F));

        PartDefinition cube_r13 = ttc1_1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(34, 34).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.8802F, -16.8946F, 0.1908F, 0.0F, -0.3927F, 0.0873F));

        PartDefinition cube_r14 = ttc1_1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(22, 2).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6957F, -16.8915F, 0.5462F, 0.0F, -0.2182F, 0.0F));

        PartDefinition cube_r15 = ttc1_1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(6, 22).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9053F, -16.9855F, 0.878F, 0.0F, -0.1309F, -0.0873F));

        PartDefinition cube_r16 = ttc1_1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(8, 2).addBox(0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5867F, -16.9905F, 1.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition ttc1_2 = main.addOrReplaceChild("ttc1_2", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 0.0F));

        PartDefinition cube_r17 = ttc1_2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(16, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4361F, -17.4388F, 0.8415F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r18 = ttc1_2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -0.5F, -5.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.1196F, -21.1904F, -4.9413F, -1.5153F, -0.0625F, 0.0249F));

        PartDefinition cube_r19 = ttc1_2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(37, 5).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0304F, -21.2841F, -4.8372F, -1.4293F, -0.1513F, 0.0119F));

        PartDefinition cube_r20 = ttc1_2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(9, 37).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0304F, -21.2841F, -4.8372F, -1.3408F, -0.3263F, -0.0015F));

        PartDefinition cube_r21 = ttc1_2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(37, 9).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0304F, -21.379F, -4.8092F, -1.2027F, -0.3232F, -0.0456F));

        PartDefinition cube_r22 = ttc1_2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(37, 13).addBox(-1.25F, -1.25F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2F, -20.4732F, -4.7102F, -1.0047F, -0.4404F, -0.1082F));

        PartDefinition cube_r23 = ttc1_2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(15, 37).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.8256F, -19.7863F, -4.146F, -0.848F, -0.5099F, -0.1573F));

        PartDefinition cube_r24 = ttc1_2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(6, 18).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.4562F, -18.3849F, -2.8385F, -0.714F, -0.4442F, -0.1952F));

        PartDefinition cube_r25 = ttc1_2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(18, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0731F, -17.7541F, -2.0275F, -0.5617F, 0.9506F, -0.8803F));

        PartDefinition cube_r26 = ttc1_2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(32, 28).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5908F, -17.2916F, -1.1551F, -0.1595F, 0.8996F, -0.4111F));

        PartDefinition cube_r27 = ttc1_2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(30, 32).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0625F, -17.043F, -0.6025F, -0.0656F, 0.7371F, -0.3423F));

        PartDefinition cube_r28 = ttc1_2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(14, 33).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5683F, -16.9579F, -0.1812F, -0.0131F, 0.5231F, -0.1804F));

        PartDefinition cube_r29 = ttc1_2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(4, 34).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8802F, -16.8946F, 0.1908F, 0.0F, 0.3927F, -0.0873F));

        PartDefinition cube_r30 = ttc1_2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6957F, -16.8915F, 0.5462F, 0.0F, 0.2182F, 0.0F));

        PartDefinition cube_r31 = ttc1_2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(20, 10).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9053F, -16.9855F, 0.878F, 0.0F, 0.1309F, 0.0873F));

        PartDefinition cube_r32 = ttc1_2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 8).addBox(-3.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5867F, -16.9905F, 1.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition ttc2_1 = main.addOrReplaceChild("ttc2_1", CubeListBuilder.create().texOffs(16, 0).addBox(0.1518F, -1.1226F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.685F, -12.615F, 0.5F, 0.0F, -0.2182F, 0.0F));

        PartDefinition cube_r33 = ttc2_1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(18, 22).addBox(-2.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 26).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.865F, 9.4637F, -3.0299F, 0.508F, 0.5781F, -2.4224F));

        PartDefinition cube_r34 = ttc2_1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(16, 29).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2855F, 8.9848F, -3.3868F, 0.6313F, 0.4361F, -2.1703F));

        PartDefinition cube_r35 = ttc2_1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(4, 30).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6358F, 8.3514F, -3.6675F, 0.6979F, 0.3011F, -1.9863F));

        PartDefinition cube_r36 = ttc2_1.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(14, 8).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1779F, 6.6569F, -4.0518F, 0.7308F, 0.1866F, -1.8505F));

        PartDefinition cube_r37 = ttc2_1.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(30, 14).addBox(-1.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5539F, 4.8426F, -4.2735F, 0.7447F, 0.0985F, -1.7526F));

        PartDefinition cube_r38 = ttc2_1.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(26, 30).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4527F, 5.0493F, -4.194F, 0.7486F, -0.05F, -1.5926F));

        PartDefinition cube_r39 = ttc2_1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(10, 31).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4192F, 4.3693F, -4.0878F, 0.7228F, -0.261F, -1.4882F));

        PartDefinition cube_r40 = ttc2_1.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2916F, 3.6942F, -3.8401F, 0.6497F, -0.4275F, -1.2733F));

        PartDefinition cube_r41 = ttc2_1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(32, 2).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0328F, 3.1093F, -3.4873F, 0.5299F, -0.574F, -1.0253F));

        PartDefinition cube_r42 = ttc2_1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(32, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9234F, 2.8896F, -3.3434F, 0.3888F, -0.6713F, -0.7845F));

        PartDefinition cube_r43 = ttc2_1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(14, 12).addBox(-1.5F, -1.0F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3661F, 1.8692F, -2.0242F, 0.1247F, -0.7454F, -0.5138F));

        PartDefinition cube_r44 = ttc2_1.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(32, 10).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9445F, 1.5509F, -1.3699F, 0.0474F, -0.598F, -0.48F));

        PartDefinition cube_r45 = ttc2_1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(20, 32).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3006F, 1.1692F, -0.8709F, 0.0666F, -0.4808F, -0.445F));

        PartDefinition cube_r46 = ttc2_1.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(32, 24).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9811F, 1.0039F, -0.6676F, 0.0204F, -0.3097F, -0.3436F));

        PartDefinition cube_r47 = ttc2_1.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8051F, 0.6755F, -0.2704F, 0.029F, -0.2167F, -0.2193F));

        PartDefinition cube_r48 = ttc2_1.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 4).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.065F, 0.615F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition ttc2_2 = main.addOrReplaceChild("ttc2_2", CubeListBuilder.create().texOffs(8, 6).addBox(-2.1518F, -1.1226F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.685F, -12.615F, 0.5F, 0.0F, 0.2182F, 0.0F));

        PartDefinition cube_r49 = ttc2_2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(22, 6).addBox(0.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.865F, 9.4637F, -3.0299F, 0.508F, -0.5781F, 2.4224F));

        PartDefinition cube_r50 = ttc2_2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(24, 24).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2855F, 8.9848F, -3.3868F, 0.6313F, -0.4361F, 2.1703F));

        PartDefinition cube_r51 = ttc2_2.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(18, 25).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6358F, 8.3514F, -3.6675F, 0.6979F, -0.3011F, 1.9863F));

        PartDefinition cube_r52 = ttc2_2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(8, 10).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1779F, 6.6569F, -4.0518F, 0.7308F, -0.1866F, 1.8505F));

        PartDefinition cube_r53 = ttc2_2.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(26, 12).addBox(0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5539F, 4.8426F, -4.2735F, 0.7447F, -0.0985F, 1.7526F));

        PartDefinition cube_r54 = ttc2_2.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(26, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4527F, 5.0493F, -4.194F, 0.7486F, 0.05F, 1.5926F));

        PartDefinition cube_r55 = ttc2_2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4192F, 4.3693F, -4.0878F, 0.7228F, 0.261F, 1.4882F));

        PartDefinition cube_r56 = ttc2_2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(12, 27).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2916F, 3.6942F, -3.8401F, 0.6497F, 0.4275F, 1.2733F));

        PartDefinition cube_r57 = ttc2_2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(28, 0).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0328F, 3.1093F, -3.4873F, 0.5299F, 0.574F, 1.0253F));

        PartDefinition cube_r58 = ttc2_2.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(28, 4).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9234F, 2.8896F, -3.3434F, 0.3888F, 0.6713F, 0.7845F));

        PartDefinition cube_r59 = ttc2_2.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -1.0F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3661F, 1.8692F, -2.0242F, 0.1247F, 0.7454F, 0.5138F));

        PartDefinition cube_r60 = ttc2_2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(28, 8).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9445F, 1.5509F, -1.3699F, 0.0474F, 0.598F, 0.48F));

        PartDefinition cube_r61 = ttc2_2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(22, 28).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3006F, 1.1692F, -0.8709F, 0.0666F, 0.4808F, 0.445F));

        PartDefinition cube_r62 = ttc2_2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9811F, 1.0039F, -0.6676F, 0.0204F, 0.3097F, 0.3436F));

        PartDefinition cube_r63 = ttc2_2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(6, 14).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8051F, 0.6755F, -0.2704F, 0.029F, 0.2167F, 0.2193F));

        PartDefinition cube_r64 = ttc2_2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.065F, 0.615F, 0.0F, 0.0F, 0.0F, 0.1745F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}