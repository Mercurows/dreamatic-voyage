package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import tech.lq0.providencraft.entity.LeviyBeamEntity;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providencesecond.lecia.Leviy;
import tech.lq0.providencraft.render.LeviyBeamEntityRenderer;

import java.util.Random;

public class LeviyRenderer {
    public static float lastX, lastY, lastZ;
    private static long lastChangeTime;
    public static boolean lastHit = false;

    public static void render(RenderWorldLastEvent evt) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getHeldItemMainhand();

        if (item.getItem() instanceof Leviy && !player.getCooldownTracker().hasCooldown(ItemRegistry.LEVIY.get())) {
            World world = player.getEntityWorld();
            Vector3d look = player.getLookVec();
            MatrixStack stack = evt.getMatrixStack();

            int distance = 512;
            Vector3d start = player.getPositionVec().add(0, player.getEyeHeight(), 0);
            Vector3d end = player.getPositionVec().add(look.x * distance, look.y * distance + player.getEyeHeight(), look.z * distance);

            RayTraceContext context = new RayTraceContext(start, end, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, player);
            BlockRayTraceResult result = player.getEntityWorld().rayTraceBlocks(context);

            boolean isUsingLeviy = player.getItemInUseMaxCount() != 0;

            if (!isUsingLeviy) {
                lastHit = false;
            }

            // 命中方块再渲染
            if (!result.getType().equals(RayTraceResult.Type.MISS)) {
                lastHit = true;
                int useTime = player.getItemInUseMaxCount();
                float alpha = ease(0.2f, 0.5f, useTime / 40f);

                BlockPos pos = result.getPos();

                int animationTime = 300;
                long timePassed = animationTime;
                if (pos.getX() != lastX || pos.getY() != lastY || pos.getZ() != lastZ) {
                    timePassed = System.currentTimeMillis() - lastChangeTime;
                }

                if (timePassed >= animationTime && !isUsingLeviy) {
                    lastX = pos.getX();
                    lastY = pos.getY();
                    lastZ = pos.getZ();
                    lastChangeTime = System.currentTimeMillis();
                }

                float progress = (float) Math.sqrt(Math.sqrt(Math.min(timePassed, animationTime) / (float) animationTime));
                float x = ease(lastX, pos.getX(), progress);
                float y = ease(lastY, pos.getY(), progress);
                float z = ease(lastZ, pos.getZ(), progress);

                if (isUsingLeviy) {
                    x = lastX;
                    y = lastY;
                    z = lastZ;
                }

                stack.push();
                // 渲染光柱
                Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
                stack.translate(x - view.getX(), y - view.getY() + 1, z - view.getZ());
                renderBeamSegment(stack,
                        Minecraft.getInstance().getRenderTypeBuffers().getBufferSource(),
                        LeviyBeamEntityRenderer.TEXTURE_LEVIY_BEAM,
                        evt.getPartialTicks(),
                        1, world.getGameTime(),
                        0, 150, new float[]{1, 1, 1},
                        .25f, 0, alpha);

                stack.pop();
            }
        }
    }

    public static void shake(EntityViewRenderEvent.CameraSetup evt) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        ClientWorld world = player.connection.getWorld();

        for (Entity entity : world.getAllEntities()) {
            if (entity instanceof LeviyBeamEntity) {
                LeviyBeamEntity beam = (LeviyBeamEntity) entity;
                double xDiff = player.getPosX() - beam.getPosX();
                double yDiff = player.getPosY() - beam.getPosY();
                double zDiff = player.getPosZ() - beam.getPosZ();
                double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);

                float beamAffectRadius = ease(0, beam.getRadius(), (float) beam.ticksExisted / beam.getDuration()) * 8;

                if (distance <= beamAffectRadius) {
                    // TODO 修改为更合理的晃动
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

    public static void renderBeamSegment(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, ResourceLocation textureLocation, float partialTicks, float textureScale, long totalWorldTime, int yOffset, int height, float[] colors, float beamRadius, float glowRadius, float alpha) {
        int i = yOffset + height;
        matrixStackIn.push();
        matrixStackIn.translate(0.5D, 0.0D, 0.5D);

        float tick40 = (float) Math.floorMod(totalWorldTime, 40L) + partialTicks;
        float tick320 = (float) Math.floorMod(totalWorldTime, 320L) + partialTicks;
        float tick120 = (float) Math.floorMod(totalWorldTime, 120L) + partialTicks;

        float f1 = height < 0 ? -tick40 : tick40;
        float f2 = MathHelper.frac(f1 * 0.2F - (float) MathHelper.floor(f1 * 0.1F));
        float r = colors[0];
        float g = colors[1];
        float b = colors[2];
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(tick40 * 2.25F - 45.0F));
        float f6, f8;
        float f9 = -beamRadius;
        float f12 = -beamRadius;
        float f15 = -1.0F + f2;
        float f16 = (float) height * textureScale * (0.5F / beamRadius) + f15;

        // 内圈
        renderPart(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityTranslucent(textureLocation)), r, g, b, alpha, yOffset, i, 0.0F, beamRadius, beamRadius, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(45.0F));
        renderPart(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityTranslucent(textureLocation)), r, g, b, alpha, yOffset, i, 0.0F, beamRadius, beamRadius, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);

        matrixStackIn.pop();
        f6 = -glowRadius;
        float f7 = -glowRadius;
        f8 = -glowRadius;
        f9 = -glowRadius;
        f15 = -1.0F + f2;
        f16 = (float) height * textureScale + f15;

        // 外部光晕
        renderPart(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityTranslucent(textureLocation)), r, g, b, 0.125F * alpha, yOffset, i, f6, f7, glowRadius, f8, f9, glowRadius, glowRadius, glowRadius, 0.0F, 1.0F, f16, f15);

        // 谜之光环
        renderOuterRing(matrixStackIn, bufferIn, alpha * 1.5f, tick320, 16, 30, 120, 8, true);

        renderOuterRing(matrixStackIn, bufferIn, alpha * 1.5f, tick120, 12, 12, 140, 3, false);

        // 魔法阵
        renderMagic(matrixStackIn, bufferIn, alpha * 2f, tick40, beamRadius + 5f, 150, 1, true);

        renderMagic(matrixStackIn, bufferIn, alpha * 2f, tick40, beamRadius + 5f, 0.01f, 1, true);

        matrixStackIn.pop();
    }

    /**
     * 渲染光环
     *
     * @param stack     MatrixStack
     * @param buffer    RenderTypeBuffer
     * @param alpha     透明度
     * @param tick      传入Tick应 = Math.floorMod(totalWorldTime, 40L * rate) + partialTicks
     * @param edgeCount 光环边数
     * @param radius    光环半径
     * @param height    光环位置（相对高度）
     * @param speedRate 光环转速
     * @param reverse   是否反转（默认逆时针）
     */
    private static void renderOuterRing(MatrixStack stack, IRenderTypeBuffer buffer, float alpha, float tick, int edgeCount, int radius, int height, int speedRate, boolean reverse) {
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

    private static void renderMagic(MatrixStack stack, IRenderTypeBuffer buffer, float alpha, float tick, float radius, float height, int speedRate, boolean reverse) {
        float nTick = reverse ? tick * -2.25f / speedRate : tick * 2.25f / speedRate;

        float x1 = radius * (float) Math.cos(Math.toRadians(nTick));
        float z1 = radius * (float) Math.sin(Math.toRadians(nTick));

        float x2 = radius * (float) Math.cos(Math.toRadians(nTick + 90f));
        float z2 = radius * (float) Math.sin(Math.toRadians(nTick + 90f));

        renderXZTexture(stack, buffer, LeviyBeamEntityRenderer.TEXTURE_LEVIY_MAGIC, x1, z1, x2, z2, -x1, -z1, -x2, -z2, height, alpha, 1, 1);
    }

    private static void renderYTexture(MatrixStack stack, IRenderTypeBuffer buffer, ResourceLocation texture, float x1, float y1, float z1, float x2, float y2, float z2, float alpha, float textureWidthScale, float textureHeightScale) {
        MatrixStack.Entry matrixstack$entry = stack.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        IVertexBuilder b = buffer.getBuffer(RenderType.getEntityTranslucent(texture));

        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y1, x1, z1, 0, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y1, x2, z2, textureWidthScale, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y2, x2, z2, textureWidthScale, textureHeightScale);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y2, x1, z1, 0, textureHeightScale);
    }

    private static void renderXZTexture(MatrixStack stack, IRenderTypeBuffer buffer, ResourceLocation texture, float x1, float z1, float x2, float z2, float x3, float z3, float x4, float z4, float y, float alpha, float textureWidthScale, float textureHeightScale) {
        MatrixStack.Entry matrixstack$entry = stack.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        IVertexBuilder b = buffer.getBuffer(RenderType.getEntityTranslucent(texture));

        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x1, z1, 0, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x2, z2, textureWidthScale, 0);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x3, z3, textureWidthScale, textureHeightScale);
        addVertex(matrix4f, matrix3f, b, 1, 1, 1, alpha, y, x4, z4, 0, textureHeightScale);
    }

    private static void renderPart(MatrixStack matrixStackIn, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float x1, float z1, float x2, float z2, float x3, float z3, float x4, float z4, float u1, float u2, float v1, float v2) {
        MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x1, z1, x2, z2, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x4, z4, x3, z3, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x2, z2, x4, z4, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x3, z3, x1, z1, u1, u2, v1, v2);
    }

    private static void addQuad(Matrix4f matrixPos, Matrix3f matrixNormal, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float x1, float z1, float x2, float z2, float u1, float u2, float v1, float v2) {
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x1, z1, u2, v1);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x1, z1, u2, v2);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x2, z2, u1, v2);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x2, z2, u1, v1);
    }

    private static void addVertex(Matrix4f matrixPos, Matrix3f matrixNormal, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, float y, float x, float z, float texU, float texV) {
        bufferIn.pos(matrixPos, x, y, z).color(red, green, blue, alpha).tex(texU, texV).overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).normal(matrixNormal, 0.0F, 1.0F, 0.0F).endVertex();
    }
}
