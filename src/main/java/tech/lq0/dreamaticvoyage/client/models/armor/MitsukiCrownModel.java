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
public class MitsukiCrownModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "mitsuki_crown_model"), "main");
    public final ModelPart armorHead;

    public MitsukiCrownModel(ModelPart root) {
        this.armorHead = root.getChild("armorHead");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = armorHead.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -8.0F, -1.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cross = main.addOrReplaceChild("cross", CubeListBuilder.create().texOffs(0, 6).addBox(-2.0F, -12.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 11).addBox(-3.0F, -11.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone = main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.0F, -2.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(15, 2).addBox(-3.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(-3.0F, -1.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 7).addBox(-5.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(4, 6).addBox(1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition crownhead = main.addOrReplaceChild("crownhead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ele1 = crownhead.addOrReplaceChild("ele1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = ele1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0115F, -1.5944F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = ele1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 25).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.5528F, -4.5514F, -0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r3 = ele1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(18, 16).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.7842F, -3.0478F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r4 = ele1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 27).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 1.1345F, 0.0F, 0.0F));

        PartDefinition ele2 = crownhead.addOrReplaceChild("ele2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r5 = ele2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0115F, 1.5944F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r6 = ele2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(11, 24).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.5528F, 4.5514F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r7 = ele2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(18, 6).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.7842F, 3.0478F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r8 = ele2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 27).addBox(-2.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, -1.1345F, 0.0F, 0.0F));

        PartDefinition ele3 = crownhead.addOrReplaceChild("ele3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r9 = ele3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(23, 10).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0115F, 1.5944F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r10 = ele3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(22, 23).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.5528F, 4.5514F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r11 = ele3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.7842F, 3.0478F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r12 = ele3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(26, 25).addBox(-2.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, -1.1345F, 0.0F, 0.0F));

        PartDefinition ele4 = crownhead.addOrReplaceChild("ele4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 0.0F, 1.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r13 = ele4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(16, 22).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0115F, -1.5944F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r14 = ele4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(7, 23).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -6.5528F, -4.5514F, -0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r15 = ele4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(14, 17).addBox(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.7842F, -3.0478F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r16 = ele4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(26, 21).addBox(1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 1.1345F, 0.0F, 0.0F));

        PartDefinition ele5 = crownhead.addOrReplaceChild("ele5", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r17 = ele5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(10, 21).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0115F, 1.5944F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r18 = ele5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(22, 15).addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -6.5528F, 4.5514F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r19 = ele5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(8, 17).addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.7842F, 3.0478F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r20 = ele5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(26, 13).addBox(1.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, -1.1345F, 0.0F, 0.0F));

        PartDefinition ele6 = crownhead.addOrReplaceChild("ele6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r21 = ele6.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(21, 2).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0115F, -1.5944F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r22 = ele6.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(22, 5).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.5528F, -4.5514F, -0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r23 = ele6.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(15, 11).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.7842F, -3.0478F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r24 = ele6.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(26, 4).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 1.1345F, 0.0F, 0.0F));

        PartDefinition ele7 = crownhead.addOrReplaceChild("ele7", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r25 = ele7.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(20, 20).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0115F, -1.5944F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r26 = ele7.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(4, 19).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.5528F, -4.5514F, -0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r27 = ele7.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(4, 13).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.7842F, -3.0478F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r28 = ele7.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(25, 0).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 1.1345F, 0.0F, 0.0F));

        PartDefinition ele8 = crownhead.addOrReplaceChild("ele8", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 0.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r29 = ele8.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(19, 12).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0115F, -1.5944F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r30 = ele8.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -6.5528F, -4.5514F, -0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r31 = ele8.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(11, 12).addBox(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.7842F, -3.0478F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r32 = ele8.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(14, 6).addBox(1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 1.1345F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        armorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}