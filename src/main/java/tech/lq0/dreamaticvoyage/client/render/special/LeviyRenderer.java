package tech.lq0.dreamaticvoyage.client.render.special;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import tech.lq0.dreamaticvoyage.client.render.LeviyBeamEntityRenderer;
import tech.lq0.dreamaticvoyage.entity.LeviyBeamEntity;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.item.second.lecia.Leviy;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class LeviyRenderer {
    public static float lastX, lastY, lastZ;
    private static long lastChangeTime;
//    public static boolean lastHit = false;

    @SubscribeEvent
    public static void render(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) {
            return;
        }

        var player = Minecraft.getInstance().player;
        assert player != null;
        var item = player.getMainHandItem();

        if (item.getItem() instanceof Leviy && !player.getCooldowns().isOnCooldown(ItemRegistry.LEVIY.get())) {
            var world = player.level();
            var look = player.getLookAngle();
            var stack = event.getPoseStack();

            int distance = 512;
            var start = player.position().add(0, player.getEyeHeight(), 0);
            var end = player.position().add(look.x * distance, look.y * distance + player.getEyeHeight(), look.z * distance);

            var context = new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player);
            var result = player.level().clip(context);

//            boolean isUsingLeviy = player.getItemInUseMaxCount() != 0;
//
//            if (!isUsingLeviy) {
//                lastHit = false;
//            }

            // 命中方块再渲染
            if (!result.getType().equals(BlockHitResult.Type.MISS)) {
//                lastHit = true;
                int useTime = player.getTicksUsingItem();
                float alpha = ease(0.2f, 0.5f, useTime / 40f);

                var pos = result.getBlockPos();

                int animationTime = 300;
                long timePassed = animationTime;
                if (pos.getX() != lastX || pos.getY() != lastY || pos.getZ() != lastZ) {
                    timePassed = System.currentTimeMillis() - lastChangeTime;
                }

                if (timePassed >= animationTime) {
                    lastX = pos.getX();
                    lastY = pos.getY();
                    lastZ = pos.getZ();
                    lastChangeTime = System.currentTimeMillis();
                }

                float progress = (float) Math.sqrt(Math.sqrt(Math.min(timePassed, animationTime) / (float) animationTime));
                float x = ease(lastX, pos.getX(), progress);
                float y = ease(lastY, pos.getY(), progress);
                float z = ease(lastZ, pos.getZ(), progress);

//                if (isUsingLeviy) {
//                    x = lastX;
//                    y = lastY;
//                    z = lastZ;
//                }

                stack.pushPose();
                // 渲染光柱
//                var view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
                var view = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
                stack.translate(x - view.x, y - view.y + 1, z - view.z);
                renderBeamSegment(stack,
                        Minecraft.getInstance().renderBuffers().bufferSource(),
                        LeviyBeamEntityRenderer.TEXTURE_LEVIY_BEAM,
                        event.getPartialTick(),
                        1, world.getGameTime(),
                        (int) player.getMyRidingOffset(), 150, new float[]{1, 1, 1},
                        .25f, 0, alpha, false);

                stack.popPose();
            }
        }
    }

    @SubscribeEvent
    public static void shake(ViewportEvent.ComputeCameraAngles evt) {
        var player = Minecraft.getInstance().player;
        assert player != null;
        var world = (ClientLevel) player.level();

        for (var entity : world.entitiesForRendering()) {
            if (entity instanceof LeviyBeamEntity beam) {
                double xDiff = player.getX() - beam.getX();
                double yDiff = player.getY() - beam.getY();
                double zDiff = player.getZ() - beam.getZ();
                double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);

                float beamAffectRadius = ease(0, beam.getMaxRadius(), (float) beam.tickCount / beam.getDuration()) * 8;

                if (distance <= beamAffectRadius) {
                    float shakeRate = ease(1, 5, (float) Math.pow((beamAffectRadius - distance) / beamAffectRadius, 2));
                    Random random = new Random();
                    evt.setYaw(evt.getYaw() - shakeRate * 0.3f + random.nextFloat() * shakeRate);
                    evt.setPitch(evt.getPitch() - shakeRate * 0.18f + random.nextFloat() * shakeRate);
                    evt.setRoll(evt.getRoll() - shakeRate * 0.3f + random.nextFloat() * shakeRate);
                }
            }
        }
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }

    public static void renderBeamSegment(PoseStack stack, MultiBufferSource bufferIn, ResourceLocation textureLocation, float partialTicks, float textureScale, long totalWorldTime, int yOffset, int height, float[] colors, float beamRadius, float glowRadius, float alpha, boolean flag) {
        int i = yOffset + height;
        stack.pushPose();
        stack.translate(0.5D, 0.0D, 0.5D);

        float tick40 = (float) Math.floorMod(totalWorldTime, 40L) + partialTicks;
        float tick320 = (float) Math.floorMod(totalWorldTime, 320L) + partialTicks;
        float tick120 = (float) Math.floorMod(totalWorldTime, 120L) + partialTicks;

        float f1 = height < 0 ? -tick40 : tick40;
        float f2 = Mth.frac(f1 * 0.2F - (float) Mth.floor(f1 * 0.1F));
        float r = colors[0];
        float g = colors[1];
        float b = colors[2];
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(tick40 * 2.25F - 45.0F));
        float f6, f8;
        float f9 = -beamRadius;
        float f12 = -beamRadius;
        float f15 = -1.0F + f2;
        float f16 = (float) height * textureScale * (0.5F / beamRadius) + f15;

        // 内圈
        renderPart(stack, bufferIn.getBuffer(RenderType.entityTranslucent(textureLocation)), r, g, b, alpha, yOffset, i, 0.0F, beamRadius, beamRadius, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);
        stack.mulPose(Axis.YP.rotationDegrees(45.0F));
        renderPart(stack, bufferIn.getBuffer(RenderType.entityTranslucent(textureLocation)), r, g, b, alpha, yOffset, i, 0.0F, beamRadius, beamRadius, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);

        stack.popPose();
        f6 = -glowRadius;
        float f7 = -glowRadius;
        f8 = -glowRadius;
        f9 = -glowRadius;
        f15 = -1.0F + f2;
        f16 = (float) height * textureScale + f15;

        // 外部光晕
        renderPart(stack, bufferIn.getBuffer(RenderType.entityTranslucent(textureLocation)), r, g, b, 0.125F * alpha, yOffset, i, f6, f7, glowRadius, f8, f9, glowRadius, glowRadius, glowRadius, 0.0F, 1.0F, f16, f15);

        // 是否为预览
        if (flag) {
            // 谜之光环
            renderOuterRing(stack, bufferIn, alpha * 1.5f, tick320, 16, 30, 120, 8, true);
            renderOuterRing(stack, bufferIn, alpha * 1.5f, tick120, 12, 12, 140, 3, false);

            // 魔法阵
            renderMagic(stack, bufferIn, alpha * 2f, tick40, beamRadius + 5f, 150, 1, true);
            renderMagic(stack, bufferIn, alpha * 2f, tick40, beamRadius + 5f, 0.01f, 1, true);
        } else {
            // 什么bug，ybb，必须渲染个环才能保证光柱不错位
            stack.pushPose();
            stack.translate(0, -1145140, 0);
            renderOuterRing(stack, bufferIn, alpha * 1.5f, tick320, 8, 5, 0, 8, true);
            stack.popPose();
        }

        stack.popPose();
    }

    /**
     * 渲染光环
     *
     * @param stack     PoseStack
     * @param buffer    RenderTypeBuffer
     * @param alpha     透明度
     * @param tick      传入Tick应 = Math.floorMod(totalWorldTime, 40L * rate) + partialTicks
     * @param edgeCount 光环边数
     * @param radius    光环半径
     * @param height    光环位置（相对高度）
     * @param speedRate 光环转速
     * @param reverse   是否反转（默认逆时针）
     */
    private static void renderOuterRing(PoseStack stack, MultiBufferSource buffer, float alpha, float tick, int edgeCount, int radius, int height, int speedRate, boolean reverse) {
        for (int j = 1; j <= edgeCount; j++) {
            float nTick = reverse ? tick * -2.25f / speedRate : tick * 2.25f / speedRate;

            float currentDegree = 360f / edgeCount * j + nTick;
            float lastDegree = 360f / edgeCount * (j - 1) + nTick;

            // Codeium神中神
            float x1 = radius * (float) Math.cos(Math.toRadians(lastDegree));
            float z1 = radius * (float) Math.sin(Math.toRadians(lastDegree));

            float x2 = radius * (float) Math.cos(Math.toRadians(currentDegree));
            float z2 = radius * (float) Math.sin(Math.toRadians(currentDegree));

            renderYTexture(stack, buffer, LeviyBeamEntityRenderer.TEXTURE_LEVIY_HALO, x1, height, z1, x2, height + radius * 2 * (float) Math.sin(Math.toRadians(180f / edgeCount)), z2, alpha, 1, 1);
        }
    }

    private static void renderMagic(PoseStack stack, MultiBufferSource buffer, float alpha, float tick, float radius, float height, int speedRate, boolean reverse) {
        float nTick = reverse ? tick * -2.25f / speedRate : tick * 2.25f / speedRate;

        float x1 = radius * (float) Math.cos(Math.toRadians(nTick));
        float z1 = radius * (float) Math.sin(Math.toRadians(nTick));

        float x2 = radius * (float) Math.cos(Math.toRadians(nTick + 90f));
        float z2 = radius * (float) Math.sin(Math.toRadians(nTick + 90f));

        renderXZTexture(stack, buffer, LeviyBeamEntityRenderer.TEXTURE_LEVIY_MAGIC, x1, z1, x2, z2, -x1, -z1, -x2, -z2, height, alpha, 1, 1);
    }

    private static void renderYTexture(PoseStack stack, MultiBufferSource buffer, ResourceLocation texture, float x1, float y1, float z1, float x2, float y2, float z2, float alpha, float textureWidthScale, float textureHeightScale) {
        var stack$entry = stack.last();
        var matrix4f = stack$entry.pose();
        var matrix3f = stack$entry.normal();
        var b = buffer.getBuffer(RenderType.entityTranslucent(texture));

        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y1, x1, z1, 0, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y1, x2, z2, textureWidthScale, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y2, x2, z2, textureWidthScale, textureHeightScale);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y2, x1, z1, 0, textureHeightScale);
    }

    private static void renderXZTexture(PoseStack stack, MultiBufferSource buffer, ResourceLocation texture, float x1, float z1, float x2, float z2, float x3, float z3, float x4, float z4, float y, float alpha, float textureWidthScale, float textureHeightScale) {
        var PoseStack$entry = stack.last();
        var matrix4f = PoseStack$entry.pose();
        var matrix3f = PoseStack$entry.normal();
        VertexConsumer b = buffer.getBuffer(RenderType.entityTranslucent(texture));

        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x1, z1, 0, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x2, z2, textureWidthScale, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x3, z3, textureWidthScale, textureHeightScale);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x4, z4, 0, textureHeightScale);
    }

    private static void renderPart(PoseStack PoseStackIn, VertexConsumer bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float x1, float z1, float x2, float z2, float x3, float z3, float x4, float z4, float u1, float u2, float v1, float v2) {
        var PoseStack$entry = PoseStackIn.last();
        var matrix4f = PoseStack$entry.pose();
        var matrix3f = PoseStack$entry.normal();
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x1, z1, x2, z2, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x4, z4, x3, z3, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x2, z2, x4, z4, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x3, z3, x1, z1, u1, u2, v1, v2);
    }

    private static void addQuad(Matrix4f matrixPos, Matrix3f matrixNormal, VertexConsumer bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float x1, float z1, float x2, float z2, float u1, float u2, float v1, float v2) {
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x1, z1, u2, v1);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x1, z1, u2, v2);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x2, z2, u1, v2);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x2, z2, u1, v1);
    }

    private static void addVertex(Matrix4f matrixPos, Matrix3f matrixNormal, VertexConsumer bufferIn, float red, float green, float blue, float alpha, float y, float x, float z, float texU, float texV) {
        bufferIn.vertex(matrixPos, x, y, z).color(red, green, blue, alpha).uv(texU, texV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(matrixNormal, 0.0F, 1.0F, 0.0F).endVertex();
    }
}
