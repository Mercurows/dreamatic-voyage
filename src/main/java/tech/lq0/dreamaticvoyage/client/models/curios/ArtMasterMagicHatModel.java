package tech.lq0.dreamaticvoyage.client.models.curios;// Made with Blockbench 4.11.1
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
import net.minecraft.world.entity.LivingEntity;
import tech.lq0.dreamaticvoyage.Utils;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class ArtMasterMagicHatModel extends HumanoidModel<LivingEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Utils.loc("art_master_magic_hat_model"), "main");

    public final ModelPart armorHead;
    private final ModelPart main;
    private final ModelPart hat;
    private final ModelPart deco;
    private final ModelPart tie;

    public ArtMasterMagicHatModel(ModelPart root) {
        super(root);
        this.armorHead = root.getChild("armorHead");
        this.main = this.armorHead.getChild("main");
        this.hat = this.main.getChild("hat");
        this.deco = this.main.getChild("deco");
        this.tie = this.main.getChild("tie");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.0f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = armorHead.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition hat = main.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -9.0F, -12.0F, 24.0F, 1.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-6.0F, -10.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 38).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(40, 38).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(48, 25).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(40, 48).addBox(-2.0F, -20.0F, -2.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 58).addBox(-2.0F, -19.4218F, 7.2796F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 58).addBox(-1.5F, -19.2718F, 9.2796F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 58).addBox(-1.5F, -17.5718F, 9.2796F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 50).addBox(-1.0F, -18.9218F, 11.2796F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 50).addBox(-2.0F, -20.5F, -1.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = hat.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 50).addBox(-2.0F, -1.5F, -3.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.778F, 8.0924F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = hat.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 58).addBox(-1.0F, -0.5F, -1.75F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.4218F, 14.7796F, 0.2182F, 0.0F, 0.0F));

        PartDefinition deco = main.addOrReplaceChild("deco", CubeListBuilder.create().texOffs(42, 58).addBox(-1.5F, -12.4F, -6.2F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = deco.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(18, 62).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0783F, -12.356F, -5.6F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r4 = deco.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(36, 56).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0783F, -12.356F, -5.6F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r5 = deco.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(58, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3227F, -11.8365F, -5.6F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r6 = deco.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(50, 60).addBox(-1.25F, -0.35F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3227F, -11.0865F, -5.6F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r7 = deco.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 62).addBox(-0.75F, -0.25F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0727F, -10.3365F, -5.6F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r8 = deco.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(58, 60).addBox(-1.25F, -0.25F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0727F, -10.3365F, -5.6F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r9 = deco.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(50, 58).addBox(-1.75F, -0.35F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3227F, -11.0865F, -5.6F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r10 = deco.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(32, 54).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3227F, -11.8365F, -5.6F, 0.0F, 0.0F, 0.2182F));

        PartDefinition tie = main.addOrReplaceChild("tie", CubeListBuilder.create().texOffs(48, 34).addBox(4.15F, -9.15F, 6.0F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r11 = tie.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(18, 56).addBox(-8.5F, 0.0F, 0.75F, 7.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.85F, -9.15F, 14.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r12 = tie.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(48, 36).addBox(-3.5F, 0.0F, -1.0F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, -5.651F, 12.499F, -1.5708F, 0.0F, 1.5708F));

        PartDefinition cube_r13 = tie.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 56).addBox(-0.5F, 5.0F, -1.0F, 7.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.15F, -8.65F, 7.0F, 0.0F, 0.0F, 1.5708F));

        return LayerDefinition.create(meshdefinition, 128, 128);
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