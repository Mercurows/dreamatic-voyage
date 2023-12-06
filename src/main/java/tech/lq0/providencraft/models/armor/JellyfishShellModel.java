package tech.lq0.providencraft.models.armor;// Made with Blockbench 4.9.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

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
public class JellyfishShellModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "jellyfish_shell_model"), "main");
    public final ModelPart main;

    public JellyfishShellModel(ModelPart root) {
        super(root);
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tentacles = main.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition ttc1 = tentacles.addOrReplaceChild("ttc1", CubeListBuilder.create().texOffs(22, 44).addBox(-5.0F, -2.0F, -8.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 44).addBox(-5.0F, 2.0F, -8.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = ttc1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 44).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r2 = ttc1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(66, 67).addBox(0.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 67).addBox(-0.8164F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r3 = ttc1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 67).addBox(-1.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 67).addBox(-0.7571F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, 0.8727F));

        PartDefinition cube_r4 = ttc1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(20, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 4.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r5 = ttc1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, 3.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r6 = ttc1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, 5.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r7 = ttc1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(8, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 6.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r8 = ttc1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, 1.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r9 = ttc1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 2.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r10 = ttc1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(28, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 0.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r11 = ttc1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(36, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, -0.8941F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition ttc3 = tentacles.addOrReplaceChild("ttc3", CubeListBuilder.create().texOffs(42, 26).addBox(-5.0F, -2.0F, -8.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 18).addBox(-5.0F, 2.0F, -8.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.0F, 1.0F));

        PartDefinition cube_r12 = ttc3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(58, 60).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3337F, 11.465F, -7.5F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r13 = ttc3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(42, 13).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r14 = ttc3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(28, 62).addBox(0.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 62).addBox(-0.8164F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r15 = ttc3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(32, 62).addBox(-1.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 62).addBox(-0.7571F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, 0.8727F));

        PartDefinition cube_r16 = ttc3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 4.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r17 = ttc3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(8, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, 3.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r18 = ttc3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(16, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, 5.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r19 = ttc3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(50, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 6.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r20 = ttc3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(54, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, 1.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r21 = ttc3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(58, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 2.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r22 = ttc3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(66, 8).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.836F, 0.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r23 = ttc3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(66, 15).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.164F, -0.8941F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition ttc4 = tentacles.addOrReplaceChild("ttc4", CubeListBuilder.create().texOffs(42, 5).addBox(1.4505F, -4.5781F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 0).addBox(1.4505F, -0.5781F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7838F, 1.7975F, -5.5F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r24 = ttc4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(58, 5).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7841F, 8.887F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r25 = ttc4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(22, 38).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6079F, 5.8097F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r26 = ttc4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(59, 20).addBox(-1.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 59).addBox(-0.1836F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6079F, 5.8097F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r27 = ttc4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(28, 59).addBox(0.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 59).addBox(-0.2429F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6079F, 5.8097F, 0.0F, 0.0F, 0.0F, -0.8727F));

        PartDefinition cube_r28 = ttc4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(42, 59).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2865F, 1.5279F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r29 = ttc4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6145F, 0.5279F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r30 = ttc4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(8, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6145F, 2.5279F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r31 = ttc4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(60, 15).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2865F, 3.5279F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r32 = ttc4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(16, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6145F, -1.4721F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r33 = ttc4.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(20, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2865F, -0.4721F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r34 = ttc4.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(50, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2865F, -2.4721F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r35 = ttc4.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(54, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6145F, -3.4721F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition ttc2 = tentacles.addOrReplaceChild("ttc2", CubeListBuilder.create().texOffs(4, 44).addBox(4.0F, -2.0F, -8.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 44).addBox(4.0F, 2.0F, -8.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r36 = ttc2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(42, 31).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r37 = ttc2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(66, 18).addBox(-1.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 66).addBox(-0.1836F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r38 = ttc2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(66, 21).addBox(0.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 66).addBox(-0.2429F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1574F, 8.3877F, -7.5F, 0.0F, 0.0F, -0.8727F));

        PartDefinition cube_r39 = ttc2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(30, 66).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.836F, 4.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r40 = ttc2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(34, 66).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.164F, 3.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r41 = ttc2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(38, 66).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.164F, 5.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r42 = ttc2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.836F, 6.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r43 = ttc2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(4, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.164F, 1.1059F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition cube_r44 = ttc2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(42, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.836F, 2.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r45 = ttc2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(46, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.836F, 0.1059F, -7.5F, 0.0F, 0.0F, 0.6109F));

        PartDefinition cube_r46 = ttc2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(50, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.164F, -0.8941F, -7.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition lt1 = tentacles.addOrReplaceChild("lt1", CubeListBuilder.create().texOffs(18, 38).addBox(-10.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 48).addBox(-10.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -3.0F));

        PartDefinition cube_r47 = lt1.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(14, 38).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.9602F, 9.5876F, 0.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r48 = lt1.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(58, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.2147F, 3.7522F, 0.5F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r49 = lt1.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(48, 45).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.921F, 1.8444F, 0.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition lt3 = tentacles.addOrReplaceChild("lt3", CubeListBuilder.create().texOffs(36, 26).addBox(-0.0425F, -7.7802F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 13).addBox(-0.8424F, 0.9247F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7075F, 3.7802F, 2.5F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r50 = lt3.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(8, 36).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0027F, 5.8074F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r51 = lt3.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(54, 26).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2571F, -0.028F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r52 = lt3.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(46, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0365F, -1.9358F, 0.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition lt4 = tentacles.addOrReplaceChild("lt4", CubeListBuilder.create().texOffs(36, 4).addBox(-0.9575F, -7.7802F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-0.1576F, 0.9247F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7075F, 3.7802F, 2.5F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r53 = lt4.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(4, 33).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0027F, 5.8074F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r54 = lt4.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(36, 22).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2571F, -0.028F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r55 = lt4.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(46, 4).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0365F, -1.9358F, 0.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition lt2 = tentacles.addOrReplaceChild("lt2", CubeListBuilder.create().texOffs(4, 38).addBox(9.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 26).addBox(9.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -3.0F));

        PartDefinition cube_r56 = lt2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9602F, 9.5876F, 0.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r57 = lt2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(54, 29).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.2147F, 3.7522F, 0.5F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r58 = lt2.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(46, 30).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.921F, 1.8444F, 0.5F, 0.0F, 0.0F, -0.2182F));

        PartDefinition lt5 = tentacles.addOrReplaceChild("lt5", CubeListBuilder.create().texOffs(0, 33).addBox(9.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 45).addBox(9.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 2.0F, 7.0F));

        PartDefinition cube_r59 = lt5.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(8, 31).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9602F, 9.5876F, 0.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r60 = lt5.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(36, 9).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.2147F, 3.7522F, 0.5F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r61 = lt5.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(44, 45).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.921F, 1.8444F, 0.5F, 0.0F, 0.0F, -0.2182F));

        PartDefinition lt6 = tentacles.addOrReplaceChild("lt6", CubeListBuilder.create().texOffs(22, 24).addBox(-10.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 13).addBox(-10.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 2.0F, 7.0F));

        PartDefinition cube_r62 = lt6.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(8, 23).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.9602F, 9.5876F, 0.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r63 = lt6.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(22, 31).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.2147F, 3.7522F, 0.5F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r64 = lt6.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(34, 45).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.921F, 1.8444F, 0.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(56, 51).addBox(-5.0F, -10.0F, -6.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 44).addBox(5.0F, -10.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(42, 26).addBox(6.0F, -8.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(28, 13).addBox(6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(42, 60).addBox(7.0F, -5.0F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(14, 4).addBox(7.0F, -4.0F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(56, 48).addBox(-5.0F, -8.0F, -7.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 8).addBox(5.0F, -8.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 49).addBox(6.0F, -5.0F, -7.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 0).addBox(-6.0F, -6.0F, -7.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 56).addBox(-6.0F, -5.0F, -8.0F, 12.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 2).addBox(-3.0F, -2.0F, -8.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 64).addBox(-3.0F, -2.0F, 7.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 60).addBox(7.0F, -5.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(7.0F, -4.0F, 3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(34, 49).addBox(6.0F, -5.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 0).addBox(-6.0F, -5.0F, 7.0F, 12.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 42).addBox(-5.0F, -10.0F, 5.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 45).addBox(-5.0F, -8.0F, 6.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 70).addBox(5.0F, -8.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 0).addBox(-6.0F, -10.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(42, 13).addBox(-7.0F, -8.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(69, 69).addBox(-6.0F, -8.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 70).addBox(-6.0F, -8.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 0).addBox(-7.0F, -6.0F, -6.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 49).addBox(-7.0F, -5.0F, -7.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 59).addBox(-8.0F, -5.0F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -4.0F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(34, 59).addBox(-8.0F, -5.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-8.0F, -4.0F, 3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(4, 49).addBox(-7.0F, -5.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 36).addBox(-6.0F, -6.0F, 6.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(54, 26).addBox(-3.0F, -23.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(64, 60).addBox(-4.0F, -22.0F, -4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(51, 58).addBox(-5.0F, -21.0F, -5.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 56).addBox(-6.0F, -20.0F, -6.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 33).addBox(-6.0F, -20.0F, 5.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 40).addBox(-6.0F, -18.0F, 6.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(55, 38).addBox(-6.0F, -12.0F, 6.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 13).addBox(-6.0F, -11.0F, 5.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 39).addBox(-7.0F, -17.0F, 6.0F, 14.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 22).addBox(-6.0F, -18.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 6).addBox(-3.0F, -19.0F, -7.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(-3.0F, -19.0F, 6.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(-6.0F, -12.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 30).addBox(-6.0F, -11.0F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 62).addBox(-4.0F, -11.0F, -7.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-7.0F, -17.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 31).addBox(-7.0F, -16.0F, -7.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-7.0F, -13.0F, -7.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 24).addBox(-8.0F, -15.0F, -7.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(2.0F, -18.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 56).addBox(-5.0F, -21.0F, 4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 36).addBox(-4.0F, -22.0F, 3.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 61).addBox(3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(34, 45).addBox(4.0F, -21.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(54, 15).addBox(5.0F, -20.0F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(14, 22).addBox(-7.0F, -19.0F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-7.0F, -12.0F, -6.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(14, 5).addBox(-8.0F, -17.0F, -6.0F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(6.0F, -19.0F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(54, 2).addBox(-6.0F, -20.0F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(44, 45).addBox(-6.0F, -11.0F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(14, 8).addBox(3.0F, -17.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 22).addBox(4.0F, -16.0F, -7.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(5.0F, -15.0F, -7.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 26).addBox(4.0F, -13.0F, -7.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 10).addBox(2.0F, -12.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 28).addBox(3.0F, -11.0F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 45).addBox(5.0F, -11.0F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(28, 26).addBox(6.0F, -12.0F, -6.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(7.0F, -17.0F, -6.0F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 44).addBox(-5.0F, -21.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(56, 60).addBox(-4.0F, -22.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition nekomimi = head.addOrReplaceChild("nekomimi", CubeListBuilder.create().texOffs(26, 45).addBox(3.0F, -24.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 19).addBox(5.0F, -25.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 17).addBox(5.0F, -24.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 15).addBox(4.0F, -23.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 13).addBox(4.0F, -22.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 15).addBox(5.0F, -21.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 21).addBox(6.0F, -20.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 6).addBox(6.0F, -24.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 6).addBox(6.0F, -22.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 49).addBox(5.0F, -24.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 8).addBox(4.0F, -23.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 10).addBox(4.0F, -22.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 53).addBox(5.0F, -21.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 2).addBox(6.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 53).addBox(6.0F, -20.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition nekomimi2 = head.addOrReplaceChild("nekomimi2", CubeListBuilder.create().texOffs(19, 4).addBox(-5.0F, -24.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 34).addBox(-7.0F, -25.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 21).addBox(-7.0F, -24.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 6).addBox(-7.0F, -23.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 4).addBox(-7.0F, -22.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 8).addBox(-7.0F, -21.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 41).addBox(-7.0F, -20.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-7.0F, -24.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 49).addBox(-7.0F, -22.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 32).addBox(-7.0F, -24.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 27).addBox(-7.0F, -23.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-7.0F, -22.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 32).addBox(-7.0F, -21.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 49).addBox(-7.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 5).addBox(-7.0F, -20.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(1.35f, 1.35f, 1.35f);

        main.copyFrom(this.hat);
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }
}