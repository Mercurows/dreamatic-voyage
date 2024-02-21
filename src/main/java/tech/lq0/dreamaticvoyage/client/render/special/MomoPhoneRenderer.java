package tech.lq0.dreamaticvoyage.client.render.special;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.item.oi.shirako.MomoPhone;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;

import java.awt.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MomoPhoneRenderer {
    @SubscribeEvent
    public static void render(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) {
            return;
        }

        AbstractClientPlayer player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getMainHandItem();
        ItemStack item_off = player.getOffhandItem();

        if (!(item.getItem() instanceof MomoPhone) && item_off.getItem() instanceof MomoPhone) {
            item = item_off;
        }

        if (item.getItem() instanceof MomoPhone) {
            if (!player.level().dimension().location().toString().equals(item.getOrCreateTag().getString("dimension"))) {
                return;
            }

            float posX = ItemNBTTool.getFloat(item, MomoPhone.NBT_POS_X, Float.NaN) - .5F;
            float posY = ItemNBTTool.getFloat(item, MomoPhone.NBT_POS_Y, Float.NaN) - .5F;
            float posZ = ItemNBTTool.getFloat(item, MomoPhone.NBT_POS_Z, Float.NaN) - .5F;
            if (!(Float.isNaN(posX) || Float.isNaN(posY) || Float.isNaN(posZ))) {
                double distance = Math.sqrt(Math.pow(posX - player.getX(), 2) + Math.pow(posZ - player.getZ(), 2));

                if (distance > 500) {
                    posX = (float) (player.getX() - (player.getX() - posX) * (500 / distance));
                    posZ = (float) (player.getZ() - (player.getZ() - posZ) * (500 / distance));
                }

                if (player.getCooldowns().getCooldownPercent(item.getItem(), event.getPartialTick()) > 0) {
                    SpecialRenderer.renderLandmark(event.getPoseStack(), posX, posY, posZ, Color.gray);
                } else {
                    SpecialRenderer.renderLandmark(event.getPoseStack(), posX, posY, posZ, Color.green);
                }
            }
        }
    }
}