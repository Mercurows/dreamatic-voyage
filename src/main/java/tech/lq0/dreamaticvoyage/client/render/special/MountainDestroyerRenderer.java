package tech.lq0.dreamaticvoyage.client.render.special;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import tech.lq0.dreamaticvoyage.item.first.myanna.MountainDestroyer;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;

import java.awt.*;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MountainDestroyerRenderer {

    @SubscribeEvent
    public static void render(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) return;

        AbstractClientPlayer player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getMainHandItem();

        if (item.getItem() instanceof MountainDestroyer) {
            if (ItemNBTTool.getBoolean(item, MountainDestroyer.TAG_MULTIMINE, false)) {
                Level level = player.level();

                Vec3 look = player.getLookAngle();

                Vec3 start = player.getEyePosition();
                Vec3 end = player.getEyePosition().add(look.x * 5, look.y * 5, look.z * 5);

                BlockHitResult result = level.clip(new ClipContext(start, end, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, player));
                BlockPos pos = result.getBlockPos();

                BlockState state = player.level().getBlockState(pos);

                if ((state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)) && TierSortingRegistry.isCorrectTierForDrops(ModItemTier.DARK_ELF, state)) {

                    ArrayList<BlockPos> posList = new ArrayList<>();

                    if (pos.getY() - player.getY() <= 2 && pos.getY() - player.getY() >= 0) {
                        pos = pos.offset(0, (int) (player.getY() - pos.getY()), 0);
                        float yaw = Math.abs(player.yHeadRot) % 360;
                        if ((yaw >= 45.0f && yaw <= 135.0f) || (yaw >= 225.0f && yaw <= 315.0f)) {
                            //x-facing
                            posList.add(pos.offset(0, 0, -1));
                            posList.add(pos.offset(0, 0, 1));
                            posList.add(pos.offset(0, 1, -1));
                            posList.add(pos.offset(0, 1, 0));
                            posList.add(pos.offset(0, 1, 1));
                            posList.add(pos.offset(0, 2, -1));
                            posList.add(pos.offset(0, 2, 0));
                            posList.add(pos.offset(0, 2, 1));
                        } else {
                            //z-facing
                            posList.add(pos.offset(-1, 0, 0));
                            posList.add(pos.offset(1, 0, 0));
                            posList.add(pos.offset(-1, 1, 0));
                            posList.add(pos.offset(0, 1, 0));
                            posList.add(pos.offset(1, 1, 0));
                            posList.add(pos.offset(-1, 2, 0));
                            posList.add(pos.offset(0, 2, 0));
                            posList.add(pos.offset(1, 2, 0));
                        }
                    } else {
                        //up-down-facing
                        posList.add(pos.offset(1, 0, 0));
                        posList.add(pos.offset(-1, 0, 0));
                        posList.add(pos.offset(0, 0, 1));
                        posList.add(pos.offset(0, 0, -1));
                        posList.add(pos.offset(1, 0, 1));
                        posList.add(pos.offset(1, 0, -1));
                        posList.add(pos.offset(-1, 0, 1));
                        posList.add(pos.offset(-1, 0, -1));
                    }
                    posList.add(pos);

                    Vec3 view = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();

                    PoseStack matrix = event.getPoseStack();
                    matrix.pushPose();
                    matrix.translate(-view.x, -view.y, -view.z);

                    var buffer = Minecraft.getInstance().renderBuffers().bufferSource();
                    var builder = buffer.getBuffer(CustomRenderType.BlockOverlay);

                    posList.forEach(b -> {
                        BlockState s = level.getBlockState(b);
                        if ((s.is(BlockTags.MINEABLE_WITH_PICKAXE) || s.is(BlockTags.MINEABLE_WITH_SHOVEL)) && TierSortingRegistry.isCorrectTierForDrops(ModItemTier.DARK_ELF, s)) {
                            matrix.pushPose();
                            matrix.translate(b.getX(), b.getY(), b.getZ());
                            matrix.translate(-0.005f, -0.005f, -0.005f);
                            matrix.scale(1.01f, 1.01f, 1.01f);
                            matrix.mulPose(Axis.YP.rotationDegrees(-90.0F));

                            Matrix4f matrix4f = matrix.last().pose();
                            SpecialRenderer.renderBlock(matrix4f, builder, Color.yellow);

                            matrix.popPose();
                        }
                    });

                    matrix.popPose();
                    RenderSystem.disableDepthTest();
                    buffer.endBatch(CustomRenderType.BlockOverlay);
                }
            }
        }
    }
}
