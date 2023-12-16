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
public class MistyChestplateModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "misty_chestplate_model"), "main");
    public final ModelPart right_total;
    public final ModelPart body_total;
    public final ModelPart left_total;
    public final ModelPart wing;

    public MistyChestplateModel(ModelPart root) {
        super(root);
        this.right_total = root.getChild("right_total");
        this.body_total = root.getChild("body_total");
        this.left_total = root.getChild("left_total");
        this.wing = root.getChild("wing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_total = partdefinition.addOrReplaceChild("right_total", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition right_arm = right_total.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-2.0F, 6.0F, 0.0F));

        PartDefinition cuff2 = right_arm.addOrReplaceChild("cuff2", CubeListBuilder.create(), PartPose.offset(8.0F, 17.0F, 0.0F));

        PartDefinition ring4 = cuff2.addOrReplaceChild("ring4", CubeListBuilder.create().texOffs(22, 73).addBox(-16.0F, -21.5F, -4.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 70).addBox(-16.0F, -21.5F, 3.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 65).addBox(-8.25F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(84, 84).addBox(-16.75F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(22, 67).addBox(-16.0F, -16.5F, -4.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 64).addBox(-16.0F, -16.5F, 3.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 84).addBox(-8.25F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(81, 10).addBox(-16.75F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ring5 = cuff2.addOrReplaceChild("ring5", CubeListBuilder.create().texOffs(95, 52).addBox(-16.5F, -20.0F, 4.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 92).addBox(-16.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 76).addBox(-17.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(10, 92).addBox(-16.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 90).addBox(-16.5F, -20.0F, -5.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 90).addBox(-8.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 25).addBox(-7.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(84, 90).addBox(-8.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 62).addBox(-16.5F, -17.0F, 4.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 90).addBox(-16.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 76).addBox(-17.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(76, 90).addBox(-16.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 48).addBox(-16.5F, -17.0F, -5.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(82, 87).addBox(-8.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 36).addBox(-7.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(16, 86).addBox(-8.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ring6 = cuff2.addOrReplaceChild("ring6", CubeListBuilder.create().texOffs(52, 51).addBox(-7.25F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(44, 0).addBox(-17.75F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(86, 49).addBox(-17.0F, -19.0F, 4.75F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 79).addBox(-17.0F, -19.0F, -5.75F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 15).addBox(-17.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(103, 72).addBox(-8.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(47, 91).addBox(-8.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 84).addBox(-17.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition sleeve2 = right_arm.addOrReplaceChild("sleeve2", CubeListBuilder.create().texOffs(42, 46).addBox(-8.25F, -13.5F, -4.5F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(31, 40).addBox(-8.0F, -7.5F, -4.5F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(11, 67).addBox(-16.85F, -13.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(65, 32).addBox(-17.1F, -10.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(64, 48).addBox(-17.5F, -7.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 64).addBox(-17.8F, -4.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(91, 14).addBox(-16.5F, -13.5F, 3.85F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 10).addBox(-16.5F, -10.5F, 3.95F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 4).addBox(-16.5F, -7.5F, 4.1F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 11).addBox(-17.0F, -7.5F, 3.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 7).addBox(-17.0F, -7.5F, -4.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 28).addBox(-17.5F, -4.5F, 4.3F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 0).addBox(-16.5F, -13.5F, -4.85F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 58).addBox(-16.5F, -10.5F, -4.95F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 36).addBox(-16.5F, -7.5F, -5.1F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 21).addBox(-17.5F, -4.5F, -5.2F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 16.0F, 0.0F));

        PartDefinition body_total = partdefinition.addOrReplaceChild("body_total", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = body_total.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition up = body.addOrReplaceChild("up", CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -20.0F, -5.25F, 16.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-8.0F, -20.0F, 4.25F, 16.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 34).addBox(7.75F, -20.0F, -4.5F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-8.75F, -20.0F, -4.5F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(43, 63).addBox(-8.5F, -14.0F, -4.5F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(59, 19).addBox(7.5F, -14.0F, -4.5F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(75, 44).addBox(7.7F, -10.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-8.0F, -14.0F, -5.0F, 16.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 63).addBox(-3.5F, -14.0F, -5.3F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 39).addBox(-2.75F, -13.0F, -5.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 11).addBox(1.75F, -13.0F, -5.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 56).addBox(1.75F, -10.0F, -5.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(61, 7).addBox(-2.75F, -10.0F, -5.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 16).addBox(-8.0F, -14.0F, 4.0F, 16.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 32).addBox(-8.0F, -10.0F, 3.2F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(74, 73).addBox(-8.8F, -10.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition dress = body.addOrReplaceChild("dress", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition outside = dress.addOrReplaceChild("outside", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1828F, -6.0162F, -5.9904F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r1 = outside.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(76, 84).addBox(-3.0F, -1.0F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5128F, 3.988F, 11.4321F, -2.763F, -0.1923F, 2.7532F));

        PartDefinition cube_r2 = outside.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(53, 79).addBox(-3.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8801F, 4.9714F, 11.168F, -2.7902F, 0.2071F, 3.0314F));

        PartDefinition cube_r3 = outside.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(34, 82).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5041F, 5.0297F, 10.4907F, -2.727F, 0.5804F, -3.0903F));

        PartDefinition cube_r4 = outside.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(10, 89).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4267F, 4.7687F, 9.298F, -2.1616F, 1.1532F, -2.3894F));

        PartDefinition cube_r5 = outside.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(113, 18).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8495F, 4.3535F, 7.9393F, -2.0931F, 1.1716F, -2.3147F));

        PartDefinition cube_r6 = outside.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(75, 50).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.067F, 3.5784F, 5.6976F, -1.5407F, 1.2271F, -1.7243F));

        PartDefinition cube_r7 = outside.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(80, 5).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9621F, 2.9193F, 3.9409F, -1.0055F, 1.1605F, -1.1511F));

        PartDefinition cube_r8 = outside.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(22, 85).addBox(-1.5F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.7867F, 1.8278F, 1.3565F, -0.429F, 0.7378F, -0.4512F));

        PartDefinition cube_r9 = outside.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 76).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3551F, 2.1678F, 10.6717F, -2.772F, 0.0043F, 2.1169F));

        PartDefinition cube_r10 = outside.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(77, 30).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3002F, 3.7827F, 10.6877F, -2.7725F, -0.0209F, 2.182F));

        PartDefinition cube_r11 = outside.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 54).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8192F, 4.8306F, 10.96F, -2.839F, -0.2156F, 2.7289F));

        PartDefinition cube_r12 = outside.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(31, 55).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6153F, 5.6032F, 11.2449F, -2.8847F, -0.0237F, 2.9477F));

        PartDefinition cube_r13 = outside.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(81, 13).addBox(-4.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.758F, 6.1286F, 9.5562F, -2.8604F, 0.4144F, 3.0696F));

        PartDefinition cube_r14 = outside.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 86).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1373F, 5.9478F, 9.3208F, -2.7765F, 0.7792F, -3.0669F));

        PartDefinition cube_r15 = outside.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(42, 61).addBox(-1.5F, -1.0F, -0.4F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7293F, 5.7491F, 7.4464F, -1.9722F, 1.2912F, -2.1744F));

        PartDefinition cube_r16 = outside.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(32, 85).addBox(-3.0F, -1.2F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5273F, 4.7861F, 3.2003F, -1.0533F, 1.2742F, -1.2216F));

        PartDefinition cube_r17 = outside.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(42, 89).addBox(0.0F, -1.2F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5484F, 4.8162F, 3.2982F, -0.6413F, 1.1322F, -0.7821F));

        PartDefinition cube_r18 = outside.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(53, 76).addBox(-2.2367F, -1.023F, 1.9903F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6534F, 3.1313F, -1.3758F, -0.4982F, 0.7886F, -0.5538F));

        PartDefinition cube_r19 = outside.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(65, 79).addBox(-2.7939F, -1.6343F, -0.1015F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1836F, 2.779F, -1.3388F, -0.3442F, -0.0594F, -0.1642F));

        PartDefinition cube_r20 = outside.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 79).addBox(1.0161F, 2.9691F, -0.8015F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1436F, -0.7495F, 0.6904F, -0.3123F, -0.1586F, -0.4549F));

        PartDefinition cube_r21 = outside.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(31, 40).addBox(-1.9989F, 0.4914F, -0.2004F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.715F, -0.6074F, 0.0904F, -0.3463F, -0.0447F, -0.1231F));

        PartDefinition cube_r22 = outside.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(76, 65).addBox(0.203F, 0.6918F, -0.2004F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.715F, -0.6074F, 0.0904F, -0.3295F, -0.1172F, -0.3295F));

        PartDefinition cube_r23 = outside.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(53, 40).addBox(-2.5633F, -1.0231F, -1.4666F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6497F, 1.4109F, 11.4509F, -0.0878F, 0.0444F, -0.6558F));

        PartDefinition cube_r24 = outside.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(22, 82).addBox(-4.0F, -0.4129F, -0.4149F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1483F, -2.1702F, 0.6904F, -0.3848F, -0.0647F, 0.0262F));

        PartDefinition cube_r25 = outside.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(53, 36).addBox(-2.5F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 3.3657F, 10.9857F, -2.7862F, -0.1855F, 3.064F));

        PartDefinition cube_r26 = outside.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(11, 67).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7133F, 3.4306F, 11.0923F, -2.7903F, 0.1096F, -3.1108F));

        PartDefinition cube_r27 = outside.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(42, 40).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1686F, 3.1199F, 10.1761F, -2.7156F, 0.596F, -2.9014F));

        PartDefinition cube_r28 = outside.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(75, 46).addBox(-2.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4371F, 2.2621F, 7.787F, -1.9075F, 1.2F, -1.9393F));

        PartDefinition cube_r29 = outside.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 89).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4698F, 1.6216F, 6.0262F, -1.3052F, 1.2085F, -1.297F));

        PartDefinition cube_r30 = outside.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(53, 50).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3067F, 0.7583F, 3.6586F, -1.4429F, 1.2187F, -1.444F));

        PartDefinition cube_r31 = outside.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(64, 50).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3588F, -0.0322F, 1.511F, -0.4927F, 0.7626F, -0.3644F));

        PartDefinition cube_r32 = outside.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(76, 68).addBox(-2.0F, -1.4F, -0.1F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.715F, -0.6074F, 0.2904F, -0.3491F, -0.003F, -0.0082F));

        PartDefinition cube_r33 = outside.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(42, 46).addBox(2.1F, -1.3F, -0.1F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.715F, -0.6074F, 0.2904F, -0.3478F, -0.0298F, -0.082F));

        PartDefinition inside = dress.addOrReplaceChild("inside", CubeListBuilder.create(), PartPose.offset(4.0712F, -1.6285F, -5.5F));

        PartDefinition one = inside.addOrReplaceChild("one", CubeListBuilder.create(), PartPose.offset(-8.0367F, 2.1643F, 11.3628F));

        PartDefinition cube_r34 = one.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(101, 98).mirror().addBox(-0.6F, -7.0F, 0.6F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.4558F, -1.537F, -2.4412F, 0.0436F, -0.0023F, -0.1222F));

        PartDefinition cube_r35 = one.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(69, 98).mirror().addBox(-0.5F, -9.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0111F, 0.4125F, -1.0476F, 0.0523F, 0.0027F, -0.061F));

        PartDefinition cube_r36 = one.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(101, 98).mirror().addBox(-0.6F, -7.0F, 0.6F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.8558F, -1.537F, -2.4412F, 0.0436F, -0.0023F, -0.1222F));

        PartDefinition cube_r37 = one.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(101, 98).mirror().addBox(-1.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.6176F, -0.6241F, -6.3348F, 0.0017F, 0.0089F, -0.1656F));

        PartDefinition cube_r38 = one.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(101, 98).mirror().addBox(-1.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.1176F, -0.7241F, -7.3348F, 0.0009F, 0.009F, -0.2267F));

        PartDefinition cube_r39 = one.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(101, 98).mirror().addBox(-1.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.5894F, -0.802F, -7.3373F, 0.0005F, 0.0091F, -0.2791F));

        PartDefinition cube_r40 = one.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(101, 98).mirror().addBox(-1.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.9585F, -0.8888F, -7.3386F, 0.0003F, 0.0091F, -0.3314F));

        PartDefinition cube_r41 = one.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(73, 98).addBox(-1.0F, -8.1F, 1.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.2558F, -1.037F, -7.3412F, 0.0002F, 0.0091F, -0.3663F));

        PartDefinition cube_r42 = one.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(73, 98).addBox(-1.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9585F, -0.8888F, -9.3386F, 0.0003F, 0.0091F, -0.3314F));

        PartDefinition cube_r43 = one.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(73, 98).addBox(-1.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.6894F, -0.802F, -11.3373F, 0.0005F, 0.0091F, -0.2965F));

        PartDefinition cube_r44 = one.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(73, 98).addBox(-1.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.4176F, -0.7241F, -13.3348F, 0.0008F, 0.009F, -0.2616F));

        PartDefinition cube_r45 = one.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(73, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5182F, -1.1885F, -9.7809F, 0.0012F, 0.009F, -0.218F));

        PartDefinition cube_r46 = one.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(77, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0182F, -1.1885F, -10.2809F, -0.0683F, 0.0114F, -0.1831F));

        PartDefinition cube_r47 = one.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 96).addBox(0.0F, -9.5F, -0.5F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 96).addBox(6.931F, -9.5F, -0.5F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r48 = one.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(26, 89).addBox(1.0F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(2.0F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 89).addBox(5.931F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 89).addBox(4.931F, -9.5F, -0.5F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, 0.4F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r49 = one.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(61, 85).addBox(3.0F, -9.5F, -0.5F, 1.0F, 21.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 89).addBox(3.931F, -9.5F, -0.5F, 1.0F, 21.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, 0.8F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r50 = one.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(38, 89).addBox(-1.0F, -9.4998F, -0.5109F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 96).addBox(7.931F, -9.4998F, -0.5109F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r51 = one.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(42, 96).addBox(-2.0F, -9.499F, -0.5218F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 96).addBox(8.931F, -9.499F, -0.5218F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.4F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r52 = one.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(12, 96).addBox(-3.0F, -9.4981F, -0.5436F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 96).addBox(9.931F, -9.4981F, -0.5436F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.4F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r53 = one.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(54, 96).addBox(-4.0F, -9.4914F, -0.6305F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -0.6F, 0.0611F, 0.0F, 0.0F));

        PartDefinition cube_r54 = one.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(69, 98).addBox(-0.5F, -9.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0801F, 0.4125F, -1.0476F, 0.0523F, -0.0027F, 0.061F));

        PartDefinition cube_r55 = one.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(101, 98).addBox(-0.4F, -7.0F, 0.6F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5248F, -1.537F, -2.4412F, 0.0436F, 0.0023F, 0.1222F));

        PartDefinition cube_r56 = one.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(37, 109).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5873F, -1.0885F, -10.4809F, -0.0677F, -0.0143F, 0.1396F));

        PartDefinition cube_r57 = one.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(81, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0873F, -1.1885F, -10.2809F, -0.0683F, -0.0114F, 0.1831F));

        PartDefinition cube_r58 = one.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(85, 98).addBox(-0.5F, -7.5F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5873F, -1.1885F, -9.7809F, 0.0012F, -0.009F, 0.218F));

        PartDefinition cube_r59 = one.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(85, 98).addBox(0.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4866F, -0.7241F, -13.3348F, 0.0008F, -0.009F, 0.2616F));

        PartDefinition cube_r60 = one.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(101, 98).addBox(0.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6866F, -0.6241F, -6.3348F, 0.0017F, -0.0089F, 0.1656F));

        PartDefinition cube_r61 = one.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(101, 98).addBox(0.0F, -8.1F, 4.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1866F, -0.7241F, -7.3348F, 0.0009F, -0.009F, 0.2267F));

        PartDefinition cube_r62 = one.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(85, 98).addBox(0.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7584F, -0.802F, -11.3373F, 0.0005F, -0.0091F, 0.2965F));

        PartDefinition cube_r63 = one.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(101, 98).addBox(0.0F, -8.1F, 3.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6584F, -0.802F, -7.3373F, 0.0005F, -0.0091F, 0.2791F));

        PartDefinition cube_r64 = one.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(85, 98).addBox(0.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0275F, -0.8888F, -9.3386F, 0.0003F, -0.0091F, 0.3314F));

        PartDefinition cube_r65 = one.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(101, 98).addBox(0.0F, -8.1F, 2.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0275F, -0.8888F, -7.3386F, 0.0003F, -0.0091F, 0.3314F));

        PartDefinition cube_r66 = one.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(93, 98).addBox(0.0F, -8.1F, 1.05F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.3248F, -1.037F, -7.3412F, 0.0002F, -0.0091F, 0.3663F));

        PartDefinition cube_r67 = one.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(89, 98).addBox(-0.5F, -8.5F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.469F, -0.0924F, -10.6988F, -0.0872F, 0.0019F, 0.0872F));

        PartDefinition cube_r68 = one.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(69, 85).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.169F, 3.4082F, -10.9938F, -0.0872F, 0.003F, 0.0348F));

        PartDefinition cube_r69 = one.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(89, 98).addBox(-2.5F, -7.4762F, -0.2959F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(97, 98).addBox(-1.5F, -7.4762F, -0.2959F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.569F, -1.1163F, -11.1028F, -0.1047F, 0.0F, 0.0F));

        PartDefinition cube_r70 = one.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(65, 98).addBox(3.0F, -9.4914F, -0.6305F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.931F, -0.1F, -0.7F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r71 = one.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(105, 92).addBox(-0.5F, -7.4473F, -0.5096F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 106).addBox(0.5F, -7.4473F, -0.5096F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.569F, -1.1163F, -11.0028F, -0.1134F, 0.0F, 0.0F));

        PartDefinition cube_r72 = one.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(109, 18).addBox(1.5F, -7.5124F, -0.7312F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.569F, -1.1163F, -11.0028F, -0.1396F, 0.0F, 0.0F));

        PartDefinition cube_r73 = one.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(109, 106).addBox(-6.0F, 0.7F, 1.1F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -9.4222F, -11.7128F, -0.1571F, 0.0F, 0.0F));

        PartDefinition cube_r74 = one.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(105, 107).addBox(-0.5F, -8.4F, -0.5F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7957F, 0.5219F, -10.7349F, -3.0555F, 0.0144F, 2.9764F));

        PartDefinition cube_r75 = one.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(57, 89).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.6243F, 5.3194F, -11.7554F, -3.0552F, 0.0121F, 3.0025F));

        PartDefinition cube_r76 = one.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(53, 89).addBox(-0.9F, -2.9F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.131F, 5.0268F, -11.5215F, -3.0554F, 0.0136F, 2.9851F));

        PartDefinition cube_r77 = one.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(33, 110).addBox(-0.3F, -5.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.8841F, -2.8139F, -10.6348F, -3.0546F, 0.0068F, 3.0634F));

        PartDefinition cube_r78 = one.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(109, 92).addBox(-5.0F, -0.3F, 0.3F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.631F, -6.9222F, -9.6628F, -3.002F, 0.0F, 3.1416F));

        PartDefinition cube_r79 = one.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(21, 110).addBox(-4.0F, -0.3F, 0.7F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.631F, -6.9222F, -9.3628F, -2.9932F, 0.0F, -3.1416F));

        PartDefinition cube_r80 = one.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(25, 110).addBox(-3.0F, -0.3F, 0.7F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.631F, -6.9222F, -9.3628F, -2.9671F, 0.0F, -3.1416F));

        PartDefinition cube_r81 = one.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(73, 0).addBox(-1.0F, -0.3F, -0.3F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.631F, -6.9222F, -10.0628F, -2.9409F, 0.0F, -3.1416F));

        PartDefinition cube_r82 = one.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(109, 54).addBox(-1.0F, -0.3F, -1.1F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.631F, -6.9222F, -10.3628F, -2.8711F, 0.0F, -3.1416F));

        PartDefinition cube_r83 = one.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(108, 41).addBox(-0.5F, -6.5F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.131F, -0.8816F, -11.7043F, -2.9496F, 0.0F, -3.1416F));

        PartDefinition cube_r84 = one.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(105, 18).addBox(-5.0F, 0.7F, 1.1F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -9.4222F, -11.7128F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r85 = one.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(29, 110).addBox(-4.0F, 0.7F, 1.1F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -9.4222F, -11.7128F, -0.1833F, 0.0F, 0.0F));

        PartDefinition cube_r86 = one.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(107, 72).addBox(-3.0F, 0.7F, 1.1F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 13).addBox(-2.0F, 0.7F, 1.1F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -9.4222F, -11.7128F, -0.2007F, 0.0F, 0.0F));

        PartDefinition cube_r87 = one.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(112, 47).addBox(-0.5F, -0.4F, -0.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.431F, -8.0596F, -10.7912F, -0.3403F, 0.0F, 0.0F));

        PartDefinition cube_r88 = one.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(104, 41).addBox(3.0F, 0.1F, 1.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -9.0212F, -12.0428F, -0.3316F, 0.0F, 0.0F));

        PartDefinition cube_r89 = one.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(88, 68).addBox(2.0F, 0.1F, 1.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -8.9897F, -12.0559F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r90 = one.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(111, 0).addBox(1.0F, 0.1F, 1.3F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -8.9222F, -12.0628F, -0.2705F, 0.0F, 0.0F));

        PartDefinition cube_r91 = one.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(65, 85).addBox(0.0F, -0.1F, 1.3F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -8.7222F, -12.0628F, -0.2443F, 0.0F, 0.0F));

        PartDefinition cube_r92 = one.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(74, 13).addBox(-1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.931F, -8.7222F, -11.7628F, -0.2182F, 0.0F, 0.0F));

        PartDefinition two = inside.addOrReplaceChild("two", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r93 = two.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(97, 18).addBox(0.0F, 0.0099F, -4.9612F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9288F, -1.3368F, 7.4276F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r94 = two.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(97, 18).addBox(0.0F, 0.0099F, -4.9612F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0712F, -1.3368F, 7.4276F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r95 = two.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9288F, -1.3368F, 5.4276F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r96 = two.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(97, 18).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0712F, -1.3368F, 5.4276F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r97 = two.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(69, 0).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 0).addBox(0.0F, 0.0099F, 6.0388F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9288F, -1.3368F, 2.4276F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r98 = two.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(69, 0).addBox(0.0F, 0.0099F, -0.9612F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 0).addBox(0.0F, 0.0099F, -7.9612F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0712F, -1.3368F, 9.4276F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r99 = two.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0712F, -1.3368F, 8.4276F, 0.2094F, 0.0F, 0.0F));

        PartDefinition cube_r100 = two.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-5.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0712F, -1.3368F, 8.4276F, 0.1658F, 0.0F, 0.0F));

        PartDefinition cube_r101 = two.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-9.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0712F, -1.3368F, 8.4276F, 0.1222F, 0.0F, 0.0F));

        PartDefinition cube_r102 = two.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-13.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9288F, -1.3368F, 8.4276F, 0.0785F, 0.0F, 0.0F));

        PartDefinition cube_r103 = two.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(69, 0).addBox(-1.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 0).addBox(-16.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9288F, -1.3368F, 8.4276F, 0.0349F, 0.0F, 0.0F));

        PartDefinition cube_r104 = two.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(69, 0).addBox(-1.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 0).addBox(14.0F, -0.025F, 0.0382F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0712F, -1.3368F, 1.4276F, -0.0349F, 0.0F, 0.0F));

        PartDefinition cube_r105 = two.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(11.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0712F, -1.3368F, 1.4276F, -0.0785F, 0.0F, 0.0F));

        PartDefinition cube_r106 = two.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(7.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0712F, -1.3368F, 1.4276F, -0.096F, 0.0F, 0.0F));

        PartDefinition cube_r107 = two.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(3.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0712F, -1.2368F, 1.4276F, -0.1571F, 0.0F, 0.0F));

        PartDefinition cube_r108 = two.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -0.025F, 0.0382F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0712F, -1.0868F, 1.4276F, -0.2094F, 0.0F, 0.0F));

        PartDefinition hudejie = dress.addOrReplaceChild("hudejie", CubeListBuilder.create().texOffs(113, 6).addBox(-2.9655F, -13.614F, 4.8988F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 50).addBox(-3.9655F, -14.414F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 21).addBox(-4.9655F, -14.814F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 55).addBox(-6.9655F, -15.114F, 5.5988F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 101).addBox(-7.9655F, -14.414F, 5.7488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 99).addBox(-8.9655F, -13.614F, 5.6488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 95).addBox(-8.2655F, -12.614F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 86).addBox(-7.2655F, -12.014F, 5.2988F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(84, 87).addBox(-5.2655F, -11.764F, 4.0988F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(53, 86).addBox(-3.2655F, -11.464F, 3.8988F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(113, 89).addBox(-6.2655F, -10.914F, 5.1488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 54).addBox(-7.2655F, -10.464F, 5.4488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 27).addBox(-8.2655F, -10.064F, 5.5488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 85).addBox(-9.0655F, -9.114F, 5.5488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 60).addBox(-8.2655F, -8.114F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 86).addBox(-7.2655F, -7.764F, 5.7988F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 41).addBox(-5.2655F, -8.164F, 5.8488F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 8).addBox(-3.2655F, -8.614F, 5.8488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 113).addBox(-2.6655F, -9.614F, 5.3988F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 103).addBox(-1.6655F, -10.214F, 5.0988F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 107).addBox(0.6655F, -10.214F, 5.0988F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 105).addBox(1.9655F, -13.614F, 4.8988F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 23).addBox(3.9655F, -14.814F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 6).addBox(4.9655F, -15.114F, 5.5988F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 97).addBox(6.9655F, -14.414F, 5.7488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 93).addBox(7.9655F, -13.614F, 5.6488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 91).addBox(7.2655F, -12.614F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 62).addBox(7.2655F, -10.064F, 5.5488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 58).addBox(8.0655F, -9.114F, 5.5488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 56).addBox(7.2655F, -8.114F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 20).addBox(5.2655F, -7.764F, 5.5988F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 16).addBox(3.2655F, -8.164F, 5.8488F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 21).addBox(-2.0345F, -13.114F, 4.1488F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(74, 60).addBox(-2.0345F, -12.664F, 5.6988F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 25).addBox(1.2655F, -11.464F, 3.8988F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(79, 28).addBox(5.2655F, -12.014F, 5.2988F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 87).addBox(3.2655F, -11.764F, 4.0988F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(113, 29).addBox(5.2655F, -10.914F, 5.1488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 25).addBox(6.2655F, -10.464F, 5.4488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 111).addBox(2.2655F, -8.614F, 5.8988F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 109).addBox(1.6655F, -9.614F, 5.4988F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 31).addBox(2.9655F, -14.414F, 5.3488F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r109 = hudejie.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(0, 64).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2245F, 5.7298F, 9.8856F, 0.0931F, -0.043F, 0.1329F));

        PartDefinition cube_r110 = hudejie.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(21, 34).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2727F, -1.0365F, 8.7939F, 0.224F, -0.043F, 0.1329F));

        PartDefinition cube_r111 = hudejie.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(0, 49).addBox(0.5F, 1.0F, -0.85F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1655F, -12.214F, 5.8488F, 0.3113F, -0.043F, 0.1329F));

        PartDefinition cube_r112 = hudejie.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(21, 49).addBox(-1.0F, 3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2296F, 5.6699F, 10.1881F, 0.0059F, -0.043F, 0.1329F));

        PartDefinition cube_r113 = hudejie.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(11, 34).addBox(-1.0F, 3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2296F, 5.6699F, 10.1881F, 0.0059F, 0.043F, -0.1329F));

        PartDefinition cube_r114 = hudejie.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(68, 32).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2245F, 5.7298F, 9.8856F, 0.0931F, 0.043F, -0.1329F));

        PartDefinition cube_r115 = hudejie.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(11, 49).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2727F, -1.0365F, 8.7939F, 0.224F, 0.043F, -0.1329F));

        PartDefinition cube_r116 = hudejie.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(56, 0).addBox(-2.5F, 1.0F, -0.85F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1655F, -12.214F, 5.8488F, 0.3113F, 0.043F, -0.1329F));

        PartDefinition brace = body.addOrReplaceChild("brace", CubeListBuilder.create().texOffs(80, 0).addBox(-9.0F, -24.0F, -4.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(63, 63).addBox(-9.0F, -24.75F, -4.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 80).addBox(-9.0F, -24.0F, 3.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 79).addBox(7.0F, -24.0F, -4.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 0).addBox(7.0F, -24.75F, -4.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(42, 79).addBox(7.0F, -24.0F, 3.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition core = body.addOrReplaceChild("core", CubeListBuilder.create().texOffs(47, 83).addBox(-0.3F, -20.9F, -5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 8).addBox(-2.3F, -19.3F, -5.75F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 20).addBox(-0.3F, -18.2F, -5.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, 24.0F, 0.0F));

        PartDefinition cube_r117 = core.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(40, 11).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -15.4F, -5.25F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r118 = core.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(5, 71).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7F, -18.8F, -5.25F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r119 = core.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(81, 55).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -18.8F, -5.25F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r120 = core.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(16, 83).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -21.1F, -5.25F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r121 = core.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(77, 79).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -19.0F, -5.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bow = body.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(65, 44).addBox(-3.5F, -25.25F, -4.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 49).addBox(-4.0F, -25.25F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(11, 34).addBox(3.0F, -25.25F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(54, 70).addBox(-3.5F, -25.25F, 3.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.75F, 0.0F));

        PartDefinition cube_r122 = bow.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(42, 70).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, -23.95F, -4.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r123 = bow.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(11, 71).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, -23.95F, -4.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition left_total = partdefinition.addOrReplaceChild("left_total", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition left_arm = left_total.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(2.0F, 6.0F, 0.0F));

        PartDefinition cuff = left_arm.addOrReplaceChild("cuff", CubeListBuilder.create(), PartPose.offset(-8.0F, 17.0F, 0.0F));

        PartDefinition ring1 = cuff.addOrReplaceChild("ring1", CubeListBuilder.create().texOffs(76, 38).addBox(8.0F, -21.5F, 3.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 76).addBox(8.0F, -21.5F, -4.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(43, 86).addBox(7.25F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(87, 20).addBox(15.75F, -21.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(65, 73).addBox(8.0F, -16.5F, 3.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 35).addBox(8.0F, -16.5F, -4.75F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 86).addBox(7.25F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(86, 35).addBox(15.75F, -16.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ring2 = cuff.addOrReplaceChild("ring2", CubeListBuilder.create().texOffs(96, 39).addBox(7.5F, -20.0F, -5.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 8).addBox(15.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(16.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(101, 18).addBox(15.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 37).addBox(7.5F, -20.0F, 4.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(100, 8).addBox(7.5F, -20.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 79).addBox(6.5F, -20.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(100, 41).addBox(7.5F, -20.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 33).addBox(7.5F, -17.0F, -5.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 92).addBox(15.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 55).addBox(16.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(113, 27).addBox(15.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 35).addBox(7.5F, -17.0F, 4.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 41).addBox(7.5F, -17.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 79).addBox(6.5F, -17.0F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(114, 8).addBox(7.5F, -17.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ring3 = cuff.addOrReplaceChild("ring3", CubeListBuilder.create().texOffs(30, 55).addBox(6.25F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(53, 36).addBox(16.75F, -19.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(87, 55).addBox(7.0F, -19.0F, -5.75F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 30).addBox(7.0F, -19.0F, 4.75F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 44).addBox(16.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 41).addBox(7.0F, -19.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 79).addBox(7.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 76).addBox(16.0F, -19.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition sleeve = left_arm.addOrReplaceChild("sleeve", CubeListBuilder.create().texOffs(20, 49).addBox(7.25F, -13.5F, -4.5F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 49).addBox(7.0F, -7.5F, -4.5F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(54, 73).addBox(15.85F, -13.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(70, 13).addBox(16.1F, -10.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(69, 1).addBox(16.5F, -7.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(31, 67).addBox(16.8F, -4.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(95, 68).addBox(7.5F, -13.5F, -4.85F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(95, 64).addBox(7.5F, -10.5F, -4.95F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 94).addBox(7.5F, -7.5F, -5.1F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 72).addBox(16.0F, -7.5F, -4.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 111).addBox(16.0F, -7.5F, 3.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 45).addBox(7.5F, -4.5F, -5.2F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 94).addBox(7.5F, -13.5F, 3.85F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 86).addBox(7.5F, -10.5F, 3.95F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 82).addBox(7.5F, -7.5F, 4.1F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 75).addBox(7.5F, -4.5F, 4.3F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 16.0F, 0.0F));

        PartDefinition wing = partdefinition.addOrReplaceChild("wing", CubeListBuilder.create().texOffs(0, 6).addBox(10.2431F, -5.9771F, -0.1F, 23.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(7.2431F, -2.9771F, -0.1F, 26.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 67).addBox(7.2431F, -1.9771F, -0.1F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 25).addBox(8.2431F, 0.0229F, -0.6F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(8.2431F, -4.9771F, -0.1F, 26.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(8.2431F, -3.9771F, -0.1F, 26.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(11.2431F, 0.0229F, 0.05F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(11.2431F, -1.9771F, 0.05F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 13).addBox(11.2431F, 1.0229F, 0.2F, 17.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 26).addBox(12.2431F, 3.0229F, 0.2F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 10.0F, 0.0F, 0.0F, -0.6545F));

        PartDefinition cube_r124 = wing.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(70, 25).mirror().addBox(-25.5F, -1.0F, 0.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.2431F, 1.0229F, 1.9F, 0.0F, -3.1416F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float sin = (float) Math.sin((System.currentTimeMillis() % 4000 - 1) * Math.PI / 2000);
        float deg = sin * 20f + 20f;

        poseStack.pushPose();
        poseStack.scale(0.55f, 0.55f, 0.55f);

        // 胸甲部分
        body_total.copyFrom(this.body);
        poseStack.pushPose();
        if (this.crouching) {
            poseStack.translate(0, 0.2, 0.0);
        }
        body_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        // 右手部分
        right_total.copyFrom(this.rightArm);
        poseStack.pushPose();
        if (this.crouching) {
            poseStack.translate(0, 0.1, -0.05);
        }
        right_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        // 左手部分
        left_total.copyFrom(this.leftArm);
        poseStack.pushPose();
        if (this.crouching) {
            poseStack.translate(0, 0.1, -0.05);
        }
        left_total.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        // 翅膀部分
        wing.copyFrom(this.body);
        wing.zRot = 37f;
        wing.yRot = deg / -60f;
        poseStack.pushPose();
        poseStack.translate(-0.12, 0.65, 0.7);

        wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();

        poseStack.popPose();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body_total, this.left_total, this.right_total, this.wing);
    }
}