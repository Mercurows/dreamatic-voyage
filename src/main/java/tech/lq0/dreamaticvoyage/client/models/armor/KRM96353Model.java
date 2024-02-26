package tech.lq0.dreamaticvoyage.client.models.armor;// Made with Blockbench 4.9.4
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
import org.joml.Vector3f;
import tech.lq0.dreamaticvoyage.Utils;

@SuppressWarnings("unused")
public class KRM96353Model<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "krm_963_53_model"), "main");
    public final ModelPart main;
    public final ModelPart ring;

    public KRM96353Model(ModelPart root) {
        super(root);
        this.main = root.getChild("main");
        this.ring = root.getChild("ring");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wing1 = body.addOrReplaceChild("wing1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bx = wing1.addOrReplaceChild("bx", CubeListBuilder.create(), PartPose.offsetAndRotation(5.8799F, -4.1941F, 7.0F, 0.0F, -0.2182F, 0.0F));

        PartDefinition cube_r1 = bx.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(59, 166).addBox(1.5641F, 2.3449F, -0.5222F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(75, 165).addBox(0.5641F, 0.3449F, -0.5222F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 122).addBox(-0.4359F, -1.6551F, -0.5222F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(84, 133).addBox(-1.4359F, -3.6551F, -0.5222F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 149).addBox(-2.4359F, -5.6551F, -0.5222F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4447F, 14.0497F, 1.7663F, 0.2182F, 0.0F, -0.1309F));

        PartDefinition cube_r2 = bx.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(91, 87).addBox(0.5F, 12.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(51, 162).addBox(0.0F, 9.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 121).addBox(-0.5F, -5.5F, -1.0F, 4.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4579F, 13.5276F, 2.1992F, 0.2182F, 0.0F, -0.1309F));

        PartDefinition cube_r3 = bx.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(46, 165).addBox(-0.5F, 0.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9324F, -2.0212F, 1.7663F, -0.2182F, 0.0F, -0.1309F));

        PartDefinition cube_r4 = bx.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(67, 166).addBox(4.5F, 10.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(74, 104).addBox(4.5F, 4.0F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 159).addBox(3.5F, 3.0F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 149).addBox(2.5F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6249F, -2.0958F, 1.0325F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r5 = bx.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 129).addBox(1.5F, -8.0F, -1.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 106).addBox(-1.5F, -10.0F, -1.0F, 3.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6249F, -2.0958F, 1.0325F, 0.0F, 0.0F, -0.1309F));

        PartDefinition bz = wing1.addOrReplaceChild("bz", CubeListBuilder.create(), PartPose.offsetAndRotation(15.5939F, -6.3931F, 7.3619F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r6 = bz.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(31, 146).addBox(-0.3469F, -10.1156F, -2.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(63, 131).addBox(-2.3469F, -13.1156F, -2.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0761F, 3.2876F, -0.1175F, 0.0F, 0.1745F, -0.1309F));

        PartDefinition cube_r7 = bz.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 104).addBox(-1.0F, 0.5856F, -0.6207F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.901F, 9.3436F, -0.7081F, 0.0F, 0.1745F, -0.1309F));

        PartDefinition cube_r8 = bz.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(40, 133).addBox(-1.5F, -8.097F, -1.2509F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.901F, 9.3436F, -0.7081F, 0.0F, 0.1745F, -0.1309F));

        PartDefinition cube_r9 = bz.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(63, 158).addBox(-1.0F, -2.5F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(69, 158).addBox(-3.0F, -2.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3399F, -4.9527F, 0.29F, 0.0F, 0.1745F, -0.1309F));

        PartDefinition cube_r10 = bz.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(8, 142).addBox(3.5F, -8.0F, -1.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7977F, 2.1033F, 0.7958F, 0.0F, 0.0F, -0.1309F));

        PartDefinition fs = wing1.addOrReplaceChild("fs", CubeListBuilder.create().texOffs(89, 113).addBox(21.8408F, -30.9445F, 7.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r11 = fs.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(80, 151).addBox(1.0F, -4.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.2986F, -37.8278F, 8.5F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r12 = fs.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(55, 83).addBox(-8.0F, 1.0F, -1.5F, 9.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 91).addBox(-9.0F, -1.0F, -1.5F, 18.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, -36.0F, 8.5F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r13 = fs.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(75, 122).addBox(-5.0F, 3.0F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(56, 97).addBox(-7.0F, 2.0F, -1.5F, 9.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(79, 92).addBox(-8.0F, -5.9F, -0.5F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(92, 106).addBox(-9.0F, -2.9F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(39, 93).addBox(-9.0F, 1.0F, -1.5F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 162).addBox(14.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(88, 97).addBox(-14.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(82, 126).addBox(3.0F, -5.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 101).addBox(-10.0F, -5.0F, -1.5F, 13.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 80).addBox(-12.0F, -2.0F, -1.5F, 26.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.9294F, -43.7274F, 6.5F, 0.0F, 0.0F, -0.829F));

        PartDefinition cube_r14 = fs.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(79, 142).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.3435F, -31.6758F, 8.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r15 = fs.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(65, 94).addBox(-1.5F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.121F, -30.8724F, 8.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r16 = fs.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(84, 162).addBox(5.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(89, 109).addBox(-9.0F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(29, 103).addBox(-7.0F, -1.0F, -1.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.3976F, -28.6478F, 7.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition fx = wing1.addOrReplaceChild("fx", CubeListBuilder.create(), PartPose.offset(-4.0F, 12.0F, 4.0F));

        PartDefinition cube_r17 = fx.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 162).addBox(-10.5F, 6.5F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(53, 156).addBox(-8.5F, 5.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(73, 128).addBox(-6.5F, 5.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(78, 116).addBox(2.5F, 5.95F, 0.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(78, 119).addBox(2.5F, 5.95F, -1.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 162).addBox(12.5F, 6.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 121).addBox(2.5F, 5.5F, -0.5F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(59, 101).addBox(-3.5F, 5.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(36.5F, -15.5F, 7.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r18 = fx.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(79, 86).addBox(4.75F, -1.75F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(39, 153).addBox(-10.25F, -2.5F, 0.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 112).addBox(-7.25F, -1.75F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.8277F, -13.8352F, 12.3571F, 0.0752F, -0.5187F, 0.2418F));

        PartDefinition cube_r19 = fx.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(85, 130).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.3969F, -14.0635F, 8.299F, 0.2605F, -0.4595F, -0.1485F));

        PartDefinition cube_r20 = fx.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(38, 145).addBox(7.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 108).addBox(-3.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.6612F, -7.3683F, 9.0F, 0.0F, 0.0F, 1.1345F));

        PartDefinition cube_r21 = fx.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(18, 106).addBox(-2.5F, -0.5F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 93).addBox(-3.5F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 153).addBox(-1.5F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0769F, -12.1758F, 9.0F, 0.0F, 0.0F, 1.3963F));

        PartDefinition wing2 = body.addOrReplaceChild("wing2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bx2 = wing2.addOrReplaceChild("bx2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.8799F, -4.1941F, 7.0F, 0.0F, 0.2182F, 0.0F));

        PartDefinition cube_r22 = bx2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(189, 92).addBox(-2.5641F, 2.3449F, -0.5222F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(247, 71).addBox(-2.5641F, 0.3449F, -0.5222F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(245, 77).addBox(-2.5641F, -1.6551F, -0.5222F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(237, 73).addBox(-2.5641F, -3.6551F, -0.5222F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(196, 75).addBox(-2.5641F, -5.6551F, -0.5222F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4447F, 14.0497F, 1.7663F, 0.2182F, 0.0F, 0.1309F));

        PartDefinition cube_r23 = bx2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(195, 90).addBox(-2.5F, 12.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(244, 63).addBox(-3.0F, 9.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(201, 42).addBox(-3.5F, -5.5F, -1.0F, 4.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4579F, 13.5276F, 2.1992F, 0.2182F, 0.0F, 0.1309F));

        PartDefinition cube_r24 = bx2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(183, 91).addBox(-0.5F, 0.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9324F, -2.0212F, 1.7663F, -0.2182F, 0.0F, 0.1309F));

        PartDefinition cube_r25 = bx2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(248, 52).addBox(-6.5F, 10.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(178, 72).addBox(-6.5F, 4.0F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(184, 81).addBox(-4.5F, 3.0F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(219, 71).addBox(-3.5F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6249F, -2.0958F, 1.0325F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r26 = bx2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(177, 47).addBox(-3.5F, -8.0F, -1.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(157, 32).addBox(-1.5F, -10.0F, -1.0F, 3.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6249F, -2.0958F, 1.0325F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bz2 = wing2.addOrReplaceChild("bz2", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.5939F, -6.3931F, 7.3619F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r27 = bz2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(211, 71).addBox(-0.6531F, -10.1156F, -2.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(210, 57).addBox(0.3469F, -13.1156F, -2.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0761F, 3.2876F, -0.1175F, 0.0F, -0.1745F, 0.1309F));

        PartDefinition cube_r28 = bz2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(194, 82).addBox(-1.0F, 0.5856F, -0.6207F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.901F, 9.3436F, -0.7081F, 0.0F, -0.1745F, 0.1309F));

        PartDefinition cube_r29 = bz2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(165, 55).addBox(-1.5F, -8.097F, -1.2509F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.901F, 9.3436F, -0.7081F, 0.0F, -0.1745F, 0.1309F));

        PartDefinition cube_r30 = bz2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(157, 76).addBox(0.0F, -2.5F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(202, 82).addBox(1.0F, -2.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3399F, -4.9527F, 0.29F, 0.0F, -0.1745F, 0.1309F));

        PartDefinition cube_r31 = bz2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(222, 13).addBox(-9.5F, -8.0F, -1.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.7977F, 2.1033F, 0.7958F, 0.0F, 0.0F, 0.1309F));

        PartDefinition fs2 = wing2.addOrReplaceChild("fs2", CubeListBuilder.create().texOffs(242, 0).addBox(-24.8408F, -30.9445F, 7.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r32 = fs2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(169, 75).addBox(-3.0F, -4.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.2986F, -37.8278F, 8.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r33 = fs2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(211, 39).addBox(-1.0F, 1.0F, -1.5F, 9.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(157, 12).addBox(-9.0F, -1.0F, -1.5F, 18.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.0F, -36.0F, 8.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r34 = fs2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(230, 61).addBox(1.0F, 3.0F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(212, 3).addBox(-2.0F, 2.0F, -1.5F, 9.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(233, 3).addBox(3.0F, -5.9F, -0.5F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(248, 43).addBox(7.0F, -2.9F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(196, 14).addBox(-1.0F, 1.0F, -1.5F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(234, 86).addBox(-16.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(244, 3).addBox(12.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(185, 64).addBox(-6.0F, -5.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(157, 22).addBox(-3.0F, -5.0F, -1.5F, 13.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(157, 0).addBox(-14.0F, -2.0F, -1.5F, 26.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.9294F, -43.7274F, 6.5F, 0.0F, 0.0F, 0.829F));

        PartDefinition cube_r35 = fs2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(234, 23).addBox(-4.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.3435F, -31.6758F, 8.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r36 = fs2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(212, 0).addBox(-4.5F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.121F, -30.8724F, 8.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r37 = fs2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(245, 8).addBox(-7.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(187, 88).addBox(7.0F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(186, 24).addBox(-5.0F, -1.0F, -1.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.3976F, -28.6478F, 7.5F, 0.0F, 0.0F, -0.2182F));

        PartDefinition fx2 = wing2.addOrReplaceChild("fx2", CubeListBuilder.create(), PartPose.offset(4.0F, 12.0F, 4.0F));

        PartDefinition cube_r38 = fx2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(242, 83).addBox(8.5F, 6.5F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(174, 81).addBox(6.5F, 5.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(227, 68).addBox(3.5F, 5.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(228, 0).addBox(-8.5F, 5.95F, 0.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(230, 65).addBox(-8.5F, 5.95F, -1.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(205, 39).addBox(-15.5F, 6.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(213, 43).addBox(-12.5F, 5.5F, -0.5F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(213, 51).addBox(-2.5F, 5.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-36.5F, -15.5F, 7.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r39 = fx2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(231, 27).addBox(-9.75F, -1.75F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(232, 39).addBox(4.25F, -2.5F, 0.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(177, 34).addBox(-4.75F, -1.75F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-37.8277F, -13.8352F, 12.3571F, 0.0752F, 0.5187F, -0.2418F));

        PartDefinition cube_r40 = fx2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(238, 15).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.3969F, -14.0635F, 8.299F, 0.2605F, 0.4595F, 0.1485F));

        PartDefinition cube_r41 = fx2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(181, 68).addBox(-13.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(177, 42).addBox(-7.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.6612F, -7.3683F, 9.0F, 0.0F, 0.0F, -1.1345F));

        PartDefinition cube_r42 = fx2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(186, 22).addBox(-0.5F, -0.5F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(247, 28).addBox(1.5F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(233, 7).addBox(-2.5F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0769F, -12.1758F, 9.0F, 0.0F, 0.0F, -1.3963F));

        PartDefinition halo = body.addOrReplaceChild("halo", CubeListBuilder.create(), PartPose.offset(0.0F, -3.75F, 0.0F));

        PartDefinition outer = halo.addOrReplaceChild("outer", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition dev1 = outer.addOrReplaceChild("dev1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r43 = dev1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(71, 12).addBox(-2.0F, -8.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(46, 75).addBox(-2.0F, 7.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(69, 25).addBox(-3.0F, 4.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 59).addBox(-4.0F, 1.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 65).addBox(-3.0F, -6.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(33, 51).addBox(-4.0F, -4.0F, -1.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 42).addBox(-4.0F, -2.0F, -1.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -49.0F, 12.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r44 = dev1.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(28, 73).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.2839F, -44.8309F, 12.0F, 0.0F, 0.0F, -1.4399F));

        PartDefinition cube_r45 = dev1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 75).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.2451F, -48.8697F, 12.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r46 = dev1.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(14, 64).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9769F, -51.1905F, 12.5F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r47 = dev1.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(65, 33).addBox(-1.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.2974F, -44.2321F, 12.5F, 0.0F, 0.0F, -1.0908F));

        PartDefinition dev2 = outer.addOrReplaceChild("dev2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r48 = dev2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(57, 70).addBox(0.0F, -8.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(38, 75).addBox(0.0F, 7.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(69, 19).addBox(-1.0F, 4.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 59).addBox(-2.0F, 1.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(65, 45).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 48).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 42).addBox(-2.0F, -2.0F, -1.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -49.0F, 12.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r49 = dev2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(67, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.2839F, -44.8309F, 12.0F, 0.0F, 0.0F, 1.4399F));

        PartDefinition cube_r50 = dev2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(72, 4).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.2451F, -48.8697F, 12.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r51 = dev2.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(63, 50).addBox(-2.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.9769F, -51.1905F, 12.5F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r52 = dev2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 64).addBox(-3.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.2974F, -44.2321F, 12.5F, 0.0F, 0.0F, 1.0908F));

        PartDefinition dev3 = outer.addOrReplaceChild("dev3", CubeListBuilder.create(), PartPose.offset(-16.4086F, -13.5057F, 12.2727F));

        PartDefinition cube_r53 = dev3.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(37, 70).addBox(-2.0F, 6.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(73, 61).addBox(-2.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 65).addBox(-3.0F, -7.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(58, 10).addBox(-4.0F, -4.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(40, 65).addBox(-3.0F, 4.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 48).addBox(-4.0F, 2.0F, -1.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(40, 12).addBox(-4.0F, -1.0F, -1.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4086F, 1.0057F, -0.2727F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r54 = dev3.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(47, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8753F, -3.1635F, -0.2727F, 0.0F, 0.0F, 1.4399F));

        PartDefinition cube_r55 = dev3.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(70, 56).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1635F, 0.8753F, -0.2727F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r56 = dev3.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(60, 0).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4317F, 3.1962F, 0.2273F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r57 = dev3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(29, 61).addBox(-1.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8888F, -3.7622F, 0.2273F, 0.0F, 0.0F, 1.0908F));

        PartDefinition dev4 = outer.addOrReplaceChild("dev4", CubeListBuilder.create(), PartPose.offset(16.4086F, -13.5057F, 12.2727F));

        PartDefinition cube_r58 = dev4.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(0, 70).addBox(0.0F, 6.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(60, 6).addBox(0.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 67).addBox(-1.0F, -7.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 56).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(65, 39).addBox(-1.0F, 4.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-2.0F, 2.0F, -1.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(37, 39).addBox(-2.0F, -1.0F, -1.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4086F, 1.0057F, -0.2727F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r59 = dev4.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(10, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8753F, -3.1635F, -0.2727F, 0.0F, 0.0F, -1.4399F));

        PartDefinition cube_r60 = dev4.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(20, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1635F, 0.8753F, -0.2727F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r61 = dev4.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(45, 59).addBox(-2.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4317F, 3.1962F, 0.2273F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r62 = dev4.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(59, 59).addBox(-3.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8888F, -3.7622F, 0.2273F, 0.0F, 0.0F, -1.0908F));

        PartDefinition od = outer.addOrReplaceChild("od", CubeListBuilder.create().texOffs(33, 45).addBox(-3.0F, -55.0F, 11.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(54, 75).addBox(-1.0F, -51.0F, 11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r63 = od.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(55, 27).addBox(-2.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6071F, -52.5094F, 12.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r64 = od.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(55, 21).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1147F, -52.5963F, 12.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition od2 = outer.addOrReplaceChild("od2", CubeListBuilder.create().texOffs(40, 30).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 75).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.0F, 14.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r65 = od2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(48, 53).addBox(-2.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6071F, -21.5094F, -1.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r66 = od2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(55, 15).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1147F, -21.5963F, -1.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition od3 = outer.addOrReplaceChild("od3", CubeListBuilder.create().texOffs(40, 24).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 75).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.0F, 14.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r67 = od3.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 53).addBox(-3.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6071F, -21.5094F, -1.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r68 = od3.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(16, 53).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1147F, -21.5963F, -1.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition od4 = outer.addOrReplaceChild("od4", CubeListBuilder.create().texOffs(40, 18).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(74, 0).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.0F, 14.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition cube_r69 = od4.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(52, 36).addBox(-3.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6071F, -21.5094F, -1.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r70 = od4.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(52, 42).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1147F, -21.5963F, -1.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition ring = partdefinition.addOrReplaceChild("ring", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition rgb = ring.addOrReplaceChild("rgb", CubeListBuilder.create().texOffs(0, 200).addBox(-1.0F, -20.0137F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -34.7363F, 14.0F));

        PartDefinition rgb_cube_63_r2 = rgb.addOrReplaceChild("rgb_cube_63_r2", CubeListBuilder.create().texOffs(60, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -6.185F));

        PartDefinition rgb_cube_62_r2 = rgb.addOrReplaceChild("rgb_cube_62_r2", CubeListBuilder.create().texOffs(40, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -6.0868F));

        PartDefinition rgb_cube_61_r2 = rgb.addOrReplaceChild("rgb_cube_61_r2", CubeListBuilder.create().texOffs(20, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.9887F));

        PartDefinition rgb_cube_60_r2 = rgb.addOrReplaceChild("rgb_cube_60_r2", CubeListBuilder.create().texOffs(0, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.8905F));

        PartDefinition rgb_cube_59_r2 = rgb.addOrReplaceChild("rgb_cube_59_r2", CubeListBuilder.create().texOffs(180, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.7923F));

        PartDefinition rgb_cube_58_r2 = rgb.addOrReplaceChild("rgb_cube_58_r2", CubeListBuilder.create().texOffs(160, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.6941F));

        PartDefinition rgb_cube_57_r2 = rgb.addOrReplaceChild("rgb_cube_57_r2", CubeListBuilder.create().texOffs(140, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.596F));

        PartDefinition rgb_cube_56_r2 = rgb.addOrReplaceChild("rgb_cube_56_r2", CubeListBuilder.create().texOffs(120, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.4978F));

        PartDefinition rgb_cube_55_r2 = rgb.addOrReplaceChild("rgb_cube_55_r2", CubeListBuilder.create().texOffs(100, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.3996F));

        PartDefinition rgb_cube_54_r2 = rgb.addOrReplaceChild("rgb_cube_54_r2", CubeListBuilder.create().texOffs(80, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.3014F));

        PartDefinition rgb_cube_53_r2 = rgb.addOrReplaceChild("rgb_cube_53_r2", CubeListBuilder.create().texOffs(60, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.2033F));

        PartDefinition rgb_cube_52_r2 = rgb.addOrReplaceChild("rgb_cube_52_r2", CubeListBuilder.create().texOffs(40, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.1051F));

        PartDefinition rgb_cube_51_r2 = rgb.addOrReplaceChild("rgb_cube_51_r2", CubeListBuilder.create().texOffs(20, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -5.0069F));

        PartDefinition rgb_cube_50_r2 = rgb.addOrReplaceChild("rgb_cube_50_r2", CubeListBuilder.create().texOffs(0, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.9087F));

        PartDefinition rgb_cube_49_r2 = rgb.addOrReplaceChild("rgb_cube_49_r2", CubeListBuilder.create().texOffs(180, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.8106F));

        PartDefinition rgb_cube_48_r2 = rgb.addOrReplaceChild("rgb_cube_48_r2", CubeListBuilder.create().texOffs(160, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.7124F));

        PartDefinition rgb_cube_47_r2 = rgb.addOrReplaceChild("rgb_cube_47_r2", CubeListBuilder.create().texOffs(140, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.6142F));

        PartDefinition rgb_cube_46_r2 = rgb.addOrReplaceChild("rgb_cube_46_r2", CubeListBuilder.create().texOffs(120, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.516F));

        PartDefinition rgb_cube_45_r2 = rgb.addOrReplaceChild("rgb_cube_45_r2", CubeListBuilder.create().texOffs(100, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.4179F));

        PartDefinition rgb_cube_44_r2 = rgb.addOrReplaceChild("rgb_cube_44_r2", CubeListBuilder.create().texOffs(80, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.3197F));

        PartDefinition rgb_cube_43_r2 = rgb.addOrReplaceChild("rgb_cube_43_r2", CubeListBuilder.create().texOffs(60, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.2215F));

        PartDefinition rgb_cube_42_r2 = rgb.addOrReplaceChild("rgb_cube_42_r2", CubeListBuilder.create().texOffs(40, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.1233F));

        PartDefinition rgb_cube_41_r2 = rgb.addOrReplaceChild("rgb_cube_41_r2", CubeListBuilder.create().texOffs(20, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -4.0252F));

        PartDefinition rgb_cube_40_r2 = rgb.addOrReplaceChild("rgb_cube_40_r2", CubeListBuilder.create().texOffs(0, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.927F));

        PartDefinition rgb_cube_39_r2 = rgb.addOrReplaceChild("rgb_cube_39_r2", CubeListBuilder.create().texOffs(180, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.8288F));

        PartDefinition rgb_cube_38_r2 = rgb.addOrReplaceChild("rgb_cube_38_r2", CubeListBuilder.create().texOffs(160, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.7306F));

        PartDefinition rgb_cube_37_r2 = rgb.addOrReplaceChild("rgb_cube_37_r2", CubeListBuilder.create().texOffs(140, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.6325F));

        PartDefinition rgb_cube_36_r2 = rgb.addOrReplaceChild("rgb_cube_36_r2", CubeListBuilder.create().texOffs(120, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.5343F));

        PartDefinition rgb_cube_35_r2 = rgb.addOrReplaceChild("rgb_cube_35_r2", CubeListBuilder.create().texOffs(100, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.4361F));

        PartDefinition rgb_cube_34_r2 = rgb.addOrReplaceChild("rgb_cube_34_r2", CubeListBuilder.create().texOffs(80, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.3379F));

        PartDefinition rgb_cube_33_r2 = rgb.addOrReplaceChild("rgb_cube_33_r2", CubeListBuilder.create().texOffs(60, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.2398F));

        PartDefinition rgb_cube_32_r2 = rgb.addOrReplaceChild("rgb_cube_32_r2", CubeListBuilder.create().texOffs(40, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition rgb_cube_31_r2 = rgb.addOrReplaceChild("rgb_cube_31_r2", CubeListBuilder.create().texOffs(20, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -3.0434F));

        PartDefinition rgb_cube_30_r2 = rgb.addOrReplaceChild("rgb_cube_30_r2", CubeListBuilder.create().texOffs(0, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.9452F));

        PartDefinition rgb_cube_29_r2 = rgb.addOrReplaceChild("rgb_cube_29_r2", CubeListBuilder.create().texOffs(180, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.8471F));

        PartDefinition rgb_cube_28_r2 = rgb.addOrReplaceChild("rgb_cube_28_r2", CubeListBuilder.create().texOffs(160, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.7489F));

        PartDefinition rgb_cube_27_r2 = rgb.addOrReplaceChild("rgb_cube_27_r2", CubeListBuilder.create().texOffs(140, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.6507F));

        PartDefinition rgb_cube_26_r2 = rgb.addOrReplaceChild("rgb_cube_26_r2", CubeListBuilder.create().texOffs(120, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.5525F));

        PartDefinition rgb_cube_25_r2 = rgb.addOrReplaceChild("rgb_cube_25_r2", CubeListBuilder.create().texOffs(100, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.4544F));

        PartDefinition rgb_cube_24_r2 = rgb.addOrReplaceChild("rgb_cube_24_r2", CubeListBuilder.create().texOffs(80, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition rgb_cube_23_r2 = rgb.addOrReplaceChild("rgb_cube_23_r2", CubeListBuilder.create().texOffs(60, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.258F));

        PartDefinition rgb_cube_22_r2 = rgb.addOrReplaceChild("rgb_cube_22_r2", CubeListBuilder.create().texOffs(40, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.1598F));

        PartDefinition rgb_cube_21_r2 = rgb.addOrReplaceChild("rgb_cube_21_r2", CubeListBuilder.create().texOffs(20, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -2.0617F));

        PartDefinition rgb_cube_20_r2 = rgb.addOrReplaceChild("rgb_cube_20_r2", CubeListBuilder.create().texOffs(0, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.9635F));

        PartDefinition rgb_cube_19_r2 = rgb.addOrReplaceChild("rgb_cube_19_r2", CubeListBuilder.create().texOffs(180, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.8653F));

        PartDefinition rgb_cube_18_r2 = rgb.addOrReplaceChild("rgb_cube_18_r2", CubeListBuilder.create().texOffs(160, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.7671F));

        PartDefinition rgb_cube_17_r2 = rgb.addOrReplaceChild("rgb_cube_17_r2", CubeListBuilder.create().texOffs(140, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.669F));

        PartDefinition rgb_cube_16_r2 = rgb.addOrReplaceChild("rgb_cube_16_r2", CubeListBuilder.create().texOffs(120, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition rgb_cube_15_r2 = rgb.addOrReplaceChild("rgb_cube_15_r2", CubeListBuilder.create().texOffs(100, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.4726F));

        PartDefinition rgb_cube_14_r2 = rgb.addOrReplaceChild("rgb_cube_14_r2", CubeListBuilder.create().texOffs(80, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.3744F));

        PartDefinition rgb_cube_13_r2 = rgb.addOrReplaceChild("rgb_cube_13_r2", CubeListBuilder.create().texOffs(60, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.2763F));

        PartDefinition rgb_cube_12_r2 = rgb.addOrReplaceChild("rgb_cube_12_r2", CubeListBuilder.create().texOffs(40, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.1781F));

        PartDefinition rgb_cube_11_r2 = rgb.addOrReplaceChild("rgb_cube_11_r2", CubeListBuilder.create().texOffs(20, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -1.0799F));

        PartDefinition rgb_cube_10_r2 = rgb.addOrReplaceChild("rgb_cube_10_r2", CubeListBuilder.create().texOffs(0, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.9817F));

        PartDefinition rgb_cube_9_r2 = rgb.addOrReplaceChild("rgb_cube_9_r2", CubeListBuilder.create().texOffs(180, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.8836F));

        PartDefinition rgb_cube_8_r2 = rgb.addOrReplaceChild("rgb_cube_8_r2", CubeListBuilder.create().texOffs(160, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition rgb_cube_7_r2 = rgb.addOrReplaceChild("rgb_cube_7_r2", CubeListBuilder.create().texOffs(140, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.6872F));

        PartDefinition rgb_cube_6_r2 = rgb.addOrReplaceChild("rgb_cube_6_r2", CubeListBuilder.create().texOffs(120, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.589F));

        PartDefinition rgb_cube_5_r2 = rgb.addOrReplaceChild("rgb_cube_5_r2", CubeListBuilder.create().texOffs(100, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.4909F));

        PartDefinition rgb_cube_4_r2 = rgb.addOrReplaceChild("rgb_cube_4_r2", CubeListBuilder.create().texOffs(80, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition rgb_cube_3_r2 = rgb.addOrReplaceChild("rgb_cube_3_r2", CubeListBuilder.create().texOffs(60, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.2945F));

        PartDefinition rgb_cube_2_r2 = rgb.addOrReplaceChild("rgb_cube_2_r2", CubeListBuilder.create().texOffs(40, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.1963F));

        PartDefinition rgb_cube_1_r2 = rgb.addOrReplaceChild("rgb_cube_1_r2", CubeListBuilder.create().texOffs(20, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0137F, 0.0F, 0.0F, 0.0F, -0.0982F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float div = 900.0F;
        float deg = (System.currentTimeMillis() % 36000000) / div;

        poseStack.pushPose();
        poseStack.scale(0.5f, 0.5f, 0.5f);
        poseStack.translate(0, 1.7f, 0);

        main.copyFrom(this.body);
        poseStack.pushPose();
        if (this.crouching) {
            poseStack.translate(0, 0.25, 0.45);
        }
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        //TODO 解决圆环和模型本体不同步的问题
        //TODO 解决潜行时圆环旋转问题
        ring.copyFrom(this.body);
        poseStack.pushPose();
        ring.offsetPos(new Vector3f(0, -34.7363f, 14));
        if (this.crouching) {
            poseStack.translate(0, 0.1, -0.65);
        } else {
            ring.zRot = deg;
        }
        ring.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        poseStack.popPose();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.main, this.ring);
    }
}