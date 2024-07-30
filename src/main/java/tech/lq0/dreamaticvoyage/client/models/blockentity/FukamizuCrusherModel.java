package tech.lq0.dreamaticvoyage.client.models.blockentity;// Made with Blockbench 4.10.4
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.dreamaticvoyage.Utils;

@SuppressWarnings("unused")
@OnlyIn(Dist.CLIENT)
public class FukamizuCrusherModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "fukamizu_crusher_model"), "main");
    public final ModelPart main;
    public final ModelPart wheel1;
    public final ModelPart wheel2;

    public FukamizuCrusherModel(ModelPart root) {
        this.main = root.getChild("main");
        this.wheel1 = this.main.getChild("wheel1");
        this.wheel2 = this.main.getChild("wheel2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition wheel2 = main.addOrReplaceChild("wheel2", CubeListBuilder.create(), PartPose.offset(-2.75F, -2.25F, 0.4375F));

        PartDefinition cube_r1 = wheel2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -5.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-3.0F, -3.0F, -1.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 0).addBox(-3.0F, -3.0F, 0.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 7).addBox(-3.0F, -3.0F, 2.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 16).addBox(-3.0F, -3.0F, 6.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-3.0F, -3.0F, 4.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -1.0F, -6.5F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.9375F, 0.0F, 0.0F, 0.3927F));

        PartDefinition wheel1 = main.addOrReplaceChild("wheel1", CubeListBuilder.create(), PartPose.offset(2.75F, -2.25F, -0.4375F));

        PartDefinition cube_r2 = wheel1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 31).addBox(-3.0F, -3.0F, 4.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-3.0F, -3.0F, 2.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-3.0F, -3.0F, 0.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 7).addBox(-3.0F, -3.0F, -1.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 32).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 23).addBox(-3.0F, -3.0F, -7.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 14).addBox(-3.0F, -3.0F, -5.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-1.0F, -1.0F, -7.5F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.9375F, 0.0F, 0.0F, -0.3927F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}