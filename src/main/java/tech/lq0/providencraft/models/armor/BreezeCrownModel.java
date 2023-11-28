package tech.lq0.providencraft.models.armor;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import tech.lq0.providencraft.Utils;

@SuppressWarnings("unused")
public class BreezeCrownModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "breeze_crown_model"), "main");
    public final ModelPart main;

    public BreezeCrownModel(ModelPart root) {
        super(root);
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition flowerZ = head.addOrReplaceChild("flowerZ", CubeListBuilder.create().texOffs(30, 18).addBox(-0.5F, -14.45F, -10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.1F, 0.7F));

        PartDefinition cube_r1 = flowerZ.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 21).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.45F, -10.0F, 0.0131F, -0.0416F, -0.393F));

        PartDefinition cube_r2 = flowerZ.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.95F, -10.0F, 0.0F, 0.0F, 0.6458F));

        PartDefinition cube_r3 = flowerZ.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.95F, -10.0F, 0.0F, 0.0F, 0.0524F));

        PartDefinition cube_r4 = flowerZ.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(25, 32).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.45F, -10.0F, 0.0131F, 0.0416F, 0.393F));

        PartDefinition cube_r5 = flowerZ.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(10, 33).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.45F, -10.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r6 = flowerZ.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(29, 33).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.45F, -10.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r7 = flowerZ.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 5).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -13.95F, -10.0F, 0.0F, 0.0F, -0.0524F));

        PartDefinition cube_r8 = flowerZ.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 8).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -13.95F, -10.0F, 0.0F, 0.0F, -0.6458F));

        PartDefinition cube_r9 = flowerZ.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(4, 35).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.45F, -10.0F, 0.0F, 0.0F, 0.2967F));

        PartDefinition cube_r10 = flowerZ.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(3, 42).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0135F, -11.6258F, -9.6F, 0.0F, 0.0F, 0.6632F));

        PartDefinition cube_r11 = flowerZ.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(41, 25).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7187F, -11.6939F, -9.6F, 0.0F, 0.0F, -0.2356F));

        PartDefinition cube_r12 = flowerZ.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(32, 41).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7187F, -13.8939F, -9.8F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r13 = flowerZ.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(41, 41).addBox(-6.0F, -1.6F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, -14.45F, -9.7F, 0.0F, 0.0F, -0.2967F));

        PartDefinition cube_r14 = flowerZ.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(13, 35).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.45F, -10.0F, 0.0F, 0.0F, -0.2967F));

        PartDefinition flowerC = head.addOrReplaceChild("flowerC", CubeListBuilder.create(), PartPose.offset(-7.0545F, -12.9926F, -0.621F));

        PartDefinition cube_r15 = flowerC.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(6, 32).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7455F, 2.3037F, -2.5679F, 0.2705F, 0.0F, 0.0F));

        PartDefinition cube_r16 = flowerC.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 34).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7455F, -0.6963F, -5.0679F, 0.3403F, 0.0F, 0.0F));

        PartDefinition cube_r17 = flowerC.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(15, 32).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.8545F, -0.2963F, -2.7679F, -0.5236F, 0.0F, 0.0F));

        PartDefinition flower = flowerC.addOrReplaceChild("flower", CubeListBuilder.create().texOffs(0, 15).addBox(-0.4F, -1.5935F, -1.4294F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(28, 22).addBox(-0.9F, -1.0935F, -0.9294F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7955F, -0.1639F, 1.3005F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r18 = flower.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(6, 28).addBox(-0.5F, -0.65F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -1.1022F, -0.6737F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r19 = flower.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(6, 28).addBox(-0.5F, -0.65F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -1.1364F, 0.8919F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r20 = flower.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(3, 4).addBox(-0.25F, -2.5F, -0.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 2.8163F, -0.995F, -0.2597F, 0.0338F, 0.1265F));

        PartDefinition cube_r21 = flower.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 4).addBox(-0.5F, -3.9F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 4.4718F, 1.3659F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r22 = flower.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(7, 12).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(28, 8).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.0935F, 0.0706F, -0.7854F, 0.0F, 0.0F));

        PartDefinition wing = head.addOrReplaceChild("wing", CubeListBuilder.create().texOffs(18, 18).addBox(0.7437F, -13.2754F, -9.9F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 2).addBox(-3.7437F, -13.2754F, -9.9F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.1F, 0.6F));

        PartDefinition cube_r23 = wing.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(-1.4308F, -0.4945F, -0.4F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9635F, -12.2489F, -9.05F, 0.0F, 0.0F, -0.4451F));

        PartDefinition cube_r24 = wing.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(10, 4).addBox(-1.5526F, -0.2679F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9635F, -12.2489F, -9.3F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r25 = wing.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(8, 8).addBox(-2.0F, -1.65F, -0.9F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0698F, -11.0203F, -8.8F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r26 = wing.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(12, 12).addBox(-1.8F, -0.8F, -0.8F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.339F, -11.7328F, -8.75F, 0.0F, 0.0F, 0.0436F));

        PartDefinition cube_r27 = wing.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(8, 18).addBox(-1.5F, -0.6F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1653F, -12.7176F, -8.65F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r28 = wing.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5692F, -0.4945F, -0.4F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9635F, -12.2489F, -9.05F, 0.0F, 0.0F, 0.4451F));

        PartDefinition cube_r29 = wing.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(15, 15).addBox(-1.4474F, -0.2679F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9635F, -12.2489F, -9.3F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r30 = wing.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(10, 0).addBox(-1.0F, -1.65F, -0.9F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0698F, -11.0203F, -8.8F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r31 = wing.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(16, 7).addBox(-1.2F, -0.8F, -0.8F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.339F, -11.7328F, -8.75F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r32 = wing.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(20, 10).addBox(-1.5F, -0.6F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1653F, -12.7176F, -8.65F, 0.0F, 0.0F, 0.0873F));

        PartDefinition crossZ = head.addOrReplaceChild("crossZ", CubeListBuilder.create().texOffs(23, 13).addBox(-3.0F, -21.45F, -9.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 21).addBox(0.0F, -21.45F, -9.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.05F, 0.0F));

        PartDefinition cube_r33 = crossZ.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -0.2F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3706F, -21.433F, -9.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r34 = crossZ.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(10, 24).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -16.4F, -8.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r35 = crossZ.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(30, 26).addBox(-1.9F, -1.2F, 0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0706F, -21.933F, -9.9F, 0.0F, 0.0F, -0.6545F));

        PartDefinition cube_r36 = crossZ.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 21).addBox(-1.5F, 0.1F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3706F, -21.433F, -9.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r37 = crossZ.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(31, 12).addBox(-0.1F, -1.2F, 0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0706F, -21.933F, -9.9F, 0.0F, 0.0F, 0.6545F));

        PartDefinition cube_r38 = crossZ.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(24, 5).addBox(-1.5F, -0.2F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3706F, -21.433F, -9.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r39 = crossZ.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(10, 21).addBox(-1.5F, 0.1F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3706F, -21.433F, -9.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r40 = crossZ.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(16, 24).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, -16.4F, -8.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r41 = crossZ.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(22, 24).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.8F, -9.0F, 0.0F, 0.0F, -3.0543F));

        PartDefinition cube_r42 = crossZ.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.8F, -9.0F, 0.0F, 0.0F, 3.0543F));

        PartDefinition cube_r43 = crossZ.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(26, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.5F, -9.0F, 0.0F, 0.0F, 0.1571F));

        PartDefinition cube_r44 = crossZ.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(28, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.5F, -9.0F, 0.0F, 0.0F, -0.1571F));

        PartDefinition crossC = head.addOrReplaceChild("crossC", CubeListBuilder.create().texOffs(21, 29).addBox(-0.5F, -1.6986F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 0).addBox(-2.0F, -0.2486F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 30).addBox(0.0F, -0.2486F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9F, -14.3514F, 0.8F, -1.5708F, -1.3963F, 1.5708F));

        PartDefinition cube_r45 = crossC.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(10, 30).addBox(-0.1014F, -0.897F, -2.6269F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0586F, 0.0213F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r46 = crossC.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(26, 16).addBox(-0.25F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9011F, -0.5431F, 0.5587F, -0.2182F, 1.4399F, 0.0F));

        PartDefinition cube_r47 = crossC.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(31, 31).addBox(-1.5F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3706F, -0.2315F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r48 = crossC.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(30, 16).addBox(-1.5F, 0.1F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3706F, -0.2315F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r49 = crossC.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(24, 0).addBox(-0.5F, -0.2F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3706F, -0.2315F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r50 = crossC.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(20, 5).addBox(-0.5F, 0.1F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3706F, -0.2315F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r51 = crossC.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(34, 2).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4014F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r52 = crossC.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(18, 34).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4014F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r53 = crossC.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(35, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2014F, 0.0F, 0.0F, 0.0F, -3.0194F));

        PartDefinition cube_r54 = crossC.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(22, 35).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2014F, 0.0F, 0.0F, 0.0F, 3.002F));

        PartDefinition chain = head.addOrReplaceChild("chain", CubeListBuilder.create().texOffs(40, 7).addBox(-3.1F, -14.15F, -8.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 10).addBox(-4.1F, -14.35F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 40).addBox(-8.4F, -14.55F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 5).addBox(-7.9F, -14.25F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 40).addBox(-7.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 2).addBox(-6.1F, -14.05F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 0).addBox(-5.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 40).addBox(-1.5F, -13.55F, -8.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 38).addBox(-3.2F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 21).addBox(-4.2F, -12.65F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 36).addBox(-6.2F, -11.75F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 39).addBox(-5.2F, -12.25F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 33).addBox(-7.2F, -11.55F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 31).addBox(-8.0F, -11.95F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 29).addBox(-8.5F, -12.55F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 10).addBox(0.5F, -13.55F, -8.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 27).addBox(2.2F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 18).addBox(3.2F, -12.65F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 39).addBox(5.2F, -11.75F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 21).addBox(4.2F, -12.25F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 39).addBox(6.2F, -11.55F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 39).addBox(7.0F, -11.95F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 38).addBox(7.5F, -12.55F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 38).addBox(7.4F, -14.55F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 24).addBox(8.0F, -14.75F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 19).addBox(8.0F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 38).addBox(8.0F, -14.75F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 16).addBox(8.0F, -14.45F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 38).addBox(8.0F, -14.25F, -6.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 41).addBox(8.0F, -13.95F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 17).addBox(8.0F, -13.75F, -4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 38).addBox(8.0F, -13.65F, -3.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 27).addBox(8.0F, -13.75F, -2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 38).addBox(8.0F, -13.95F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 37).addBox(8.0F, -14.55F, -0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 40).addBox(8.0F, -14.55F, 0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 40).addBox(8.0F, -13.75F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 37).addBox(6.9F, -14.25F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 37).addBox(6.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 13).addBox(4.1F, -14.15F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 11).addBox(5.1F, -14.05F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(3.1F, -14.35F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 9).addBox(2.1F, -14.15F, -8.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 8).addBox(-9.0F, -13.75F, -2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 6).addBox(-9.0F, -14.55F, -0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 4).addBox(-9.0F, -13.95F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 40).addBox(-9.0F, -14.55F, 0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 1).addBox(-9.0F, -12.75F, -0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 24).addBox(-9.0F, -12.15F, -1.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 24).addBox(-9.0F, -11.7F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 23).addBox(-9.0F, -10.9F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(-9.0F, -11.2F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 40).addBox(-9.0F, -11.2F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 35).addBox(-9.0F, -11.65F, -6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 36).addBox(-9.0F, -12.15F, -7.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 32).addBox(-9.0F, -12.95F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 30).addBox(-9.0F, -12.65F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 36).addBox(-9.0F, -14.75F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 26).addBox(-9.0F, -14.75F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 22).addBox(-9.0F, -14.45F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 36).addBox(-9.0F, -14.25F, -6.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 14).addBox(-9.0F, -13.95F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 41).addBox(-9.0F, -13.75F, -4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 28).addBox(-9.0F, -13.65F, -3.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 41).addBox(8.0F, -10.9F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 12).addBox(8.0F, -11.2F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 35).addBox(8.0F, -11.65F, -6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 20).addBox(8.0F, -12.15F, -7.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 15).addBox(8.0F, -12.65F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 24).addBox(8.0F, -12.75F, -0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 24).addBox(8.0F, -12.15F, -1.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 21).addBox(8.0F, -11.7F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 10).addBox(8.0F, -11.2F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(0.55f, 0.55f, 0.55f);

        main.copyFrom(this.hat);

        if (this.crouching) {
            poseStack.translate(0, 0.2, 0);
        }

        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.main);
    }
}