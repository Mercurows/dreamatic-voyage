package tech.lq0.providencraft.models.curios;// Made with Blockbench 4.9.3
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

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class YeggyPearlModel extends HumanoidModel<LivingEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "yeggy_pearl_model"), "main");
    public final ModelPart armorHead;

    public YeggyPearlModel(ModelPart root) {
        super(root);
        this.armorHead = root.getChild("armorHead");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = armorHead.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition flower = main.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = flower.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 5).addBox(-2.1F, -2.7F, 0.1F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.8437F, -14.3009F, -9.073F, -0.2618F, -0.6109F, 0.0F));

        PartDefinition cube_r2 = flower.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(9, 9).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1595F, -14.7244F, -8.1497F, -0.6021F, -0.2834F, 0.7473F));

        PartDefinition cloth = main.addOrReplaceChild("cloth", CubeListBuilder.create(), PartPose.offset(0.2F, 0.0F, 0.25F));

        PartDefinition cube_r3 = cloth.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(14, 6).addBox(-1.0925F, -1.9428F, -0.3076F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0286F, -8.1359F, -7.6055F, -0.153F, -0.9621F, -0.1165F));

        PartDefinition cube_r4 = cloth.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(6, 14).addBox(-2.2425F, -1.7869F, -0.9212F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8286F, -8.1359F, -7.6055F, -0.2473F, -0.5352F, 0.0291F));

        PartDefinition cube_r5 = cloth.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(10, 14).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1728F, -6.5981F, -7.871F, -0.1745F, -1.0908F, 0.0F));

        PartDefinition cube_r6 = cloth.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 0).addBox(0.4171F, -1.8798F, -0.6444F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6286F, -6.1359F, -7.5055F, 2.6337F, -1.5199F, -2.7175F));

        PartDefinition cube_r7 = cloth.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 3).addBox(0.4171F, -1.8798F, -0.6444F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8286F, -8.1359F, -7.9055F, 2.5464F, -1.5199F, -2.7175F));

        PartDefinition cube_r8 = cloth.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1571F, -11.2718F, -9.011F, -0.2243F, 0.0282F, 0.1559F));

        PartDefinition cube_r9 = cloth.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7F, -11.2F, -7.2F, -0.0479F, -1.0495F, -0.042F));

        PartDefinition cube_r10 = cloth.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(10, 5).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4652F, -11.2228F, -8.4294F, -0.1335F, -0.3972F, -0.0721F));

        PartDefinition wires = main.addOrReplaceChild("wires", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wire1 = wires.addOrReplaceChild("wire1", CubeListBuilder.create(), PartPose.offsetAndRotation(7.468F, -10.1528F, -10.0524F, -0.0386F, 0.0385F, 0.0674F));

        PartDefinition cube_r11 = wire1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(12, 3).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4585F, 0.1918F, 0.7941F, 2.7925F, -0.5236F, 0.0F));

        PartDefinition cube_r12 = wire1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 2).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.043F, 1.2404F, 0.0745F, 1.789F, -0.5236F, 0.0F));

        PartDefinition cube_r13 = wire1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(18, 2).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3068F, 0.8945F, -0.5314F, 0.4363F, -0.5236F, 0.0F));

        PartDefinition cube_r14 = wire1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(18, 3).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3691F, -0.0511F, -0.6392F, -0.1745F, -0.5236F, 0.0F));

        PartDefinition cube_r15 = wire1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(12, 17).addBox(-0.5F, -2.5F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0494F, -1.8425F, 0.0855F, -0.5236F, -0.5236F, 0.0F));

        PartDefinition wire2 = wires.addOrReplaceChild("wire2", CubeListBuilder.create(), PartPose.offsetAndRotation(10.3822F, -10.1575F, -6.9231F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r16 = wire2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8173F, 0.1918F, 0.6833F, 2.7925F, -0.5236F, 0.0F));

        PartDefinition cube_r17 = wire2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(7, 10).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4018F, 1.2404F, -0.0363F, 1.789F, -0.5236F, 0.0F));

        PartDefinition cube_r18 = wire2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(6, 12).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.052F, 0.8945F, -0.6422F, 0.4363F, -0.5236F, 0.0F));

        PartDefinition cube_r19 = wire2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(6, 13).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0103F, -0.0511F, -0.75F, -0.1745F, -0.5236F, 0.0F));

        PartDefinition cube_r20 = wire2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(10, 17).addBox(-0.5F, -2.5F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4081F, -1.8425F, -0.0253F, -0.5236F, -0.5236F, 0.0F));

        PartDefinition wire3 = wires.addOrReplaceChild("wire3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r21 = wire3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(2, 18).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.929F, -3.251F, -10.1034F, -0.0873F, -0.6545F, 0.0F));

        PartDefinition cube_r22 = wire3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6114F, -7.213F, -9.6896F, -0.1745F, -0.6545F, 0.0F));

        PartDefinition cube_r23 = wire3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(8, 17).addBox(-1.5F, -1.25F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7601F, -11.8389F, -8.2407F, -0.2618F, -0.6545F, 0.0F));

        PartDefinition wire4 = wires.addOrReplaceChild("wire4", CubeListBuilder.create(), PartPose.offsetAndRotation(9.3315F, -9.1638F, -8.2238F, 0.0346F, -0.3135F, -0.0379F));

        PartDefinition cube_r24 = wire4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(14, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2633F, 1.9507F, -0.3431F, -0.1745F, -0.6545F, 0.0F));

        PartDefinition cube_r25 = wire4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(6, 17).addBox(-1.5F, -1.25F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4119F, -2.6752F, 1.1059F, -0.2618F, -0.6545F, 0.0F));

        PartDefinition bow = main.addOrReplaceChild("bow", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r26 = bow.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -2.0F, -0.9F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.15F, -12.0F, -7.0F, -0.0752F, 0.5187F, -0.4999F));

        PartDefinition cube_r27 = bow.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -11.5F, -9.25F, 1.0908F, -0.5236F, 0.2269F));

        PartDefinition pearl = main.addOrReplaceChild("pearl", CubeListBuilder.create().texOffs(16, 16).addBox(5.5F, -14.25F, -9.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r28 = pearl.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(16, 14).addBox(-1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -13.75F, -8.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r29 = pearl.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(16, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6618F, -11.8424F, -9.0959F, 0.0994F, -0.5754F, 0.1544F));

        PartDefinition cube_r30 = pearl.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(4, 10).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5618F, -12.3424F, -9.7959F, 0.3829F, -0.0651F, -0.0068F));

        PartDefinition cube_r31 = pearl.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(2, 16).addBox(-0.25F, -0.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.75F, -9.75F, 0.2182F, 0.0F, -0.3054F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    @Nonnull
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.armorHead);
    }

    @Override
    @Nonnull
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of();
    }
}