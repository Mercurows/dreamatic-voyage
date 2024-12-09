package tech.lq0.dreamaticvoyage.client.render.special;

import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.block.entity.PylonBlockEntity;
import tech.lq0.dreamaticvoyage.item.misc.fukamizutech.FukamizuBreadWrench;

import java.awt.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class FukamizuBreadWrenchRenderer {

    @SubscribeEvent
    public static void render(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) return;

        AbstractClientPlayer player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getMainHandItem();

        if (!(item.getItem() instanceof FukamizuBreadWrench)) return;
        if (item.getTag() == null) return;

        var coordinate = item.getTag().getIntArray("Machine");
        if (coordinate.length == 0) return;

        var x = coordinate[0];
        var y = coordinate[1];
        var z = coordinate[2];

        var buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        var builder = buffer.getBuffer(CustomRenderType.BLOCK_OVERLAY);
        var matrix = event.getPoseStack();

        Vec3 view = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
        matrix.pushPose();
        matrix.translate(-view.x, -view.y, -view.z);

        // 扳手绑定方块渲染
        matrix.pushPose();
        matrix.translate(x, y, z);
        matrix.translate(-0.005f, -0.005f, -0.005f);
        matrix.scale(1.01f, 1.01f, 1.01f);
        matrix.mulPose(Axis.YP.rotationDegrees(-90.0F));

        SpecialRenderer.renderBlock(matrix.last().pose(), builder, Color.GREEN);
        matrix.popPose();

        var blockEntity = player.level().getBlockEntity(new BlockPos(x, y, z));

        if (blockEntity instanceof PylonBlockEntity pylonBlockEntity) {
            pylonBlockEntity.getConnections().forEach(c -> {
                var targetX = x + c[0];
                var targetY = y + c[1];
                var targetZ = z + c[2];

                // 能量塔绑定方块渲染
                matrix.pushPose();
                matrix.translate(targetX, targetY, targetZ);
                matrix.translate(-0.005f, -0.005f, -0.005f);
                matrix.scale(1.01f, 1.01f, 1.01f);
                matrix.mulPose(Axis.YP.rotationDegrees(-90.0F));

                SpecialRenderer.renderBlock(matrix.last().pose(), builder, Color.RED);
                matrix.popPose();
            });
        }

        matrix.popPose();
    }
}
