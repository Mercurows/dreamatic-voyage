package tech.lq0.dreamaticvoyage.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkEvent;
import tech.lq0.dreamaticvoyage.gui.menu.PhantasmalVoyagerMenu;

import java.util.function.Supplier;

public class PhantasmalVoyagerPacket {
    private final int state;

    public PhantasmalVoyagerPacket(int state) {
        this.state = state;
    }

    public static PhantasmalVoyagerPacket decode(FriendlyByteBuf buf) {
        return new PhantasmalVoyagerPacket(buf.readInt());
    }

    public static void encode(PhantasmalVoyagerPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.state);
    }

    public static void handle(PhantasmalVoyagerPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            if (player == null) return;

            AbstractContainerMenu abstractcontainermenu = player.containerMenu;
            if (abstractcontainermenu instanceof PhantasmalVoyagerMenu menu) {
                if (!menu.stillValid(player)) {
                    return;
                }

                if (packet.state == 1 && menu.getVoyageState() == 0) {
                    menu.setVoyageState(1);
                }
                if (packet.state == -1 && menu.getVoyageState() == 2) {
                    menu.setVoyageState(-1);
                }
            }

        });
        ctx.get().setPacketHandled(true);
    }

}
