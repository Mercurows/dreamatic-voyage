package tech.lq0.dreamaticvoyage.network;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;
import tech.lq0.dreamaticvoyage.gui.menu.BaseEnergyMenu;
import tech.lq0.dreamaticvoyage.network.packet.ContainerDataSyncPacket;

import java.util.List;
import java.util.function.Supplier;

public class ClientPacketHandler {

    public static void handleContainerDataSyncPacket(int containerId, List<ContainerDataSyncPacket.Pair> data, Supplier<NetworkEvent.Context> ctx) {
        if (ctx.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && mc.player.containerMenu.containerId == containerId) {
                data.forEach(p -> ((BaseEnergyMenu) mc.player.containerMenu).setData(p.id, p.data));
            }
        }
    }
}
