package tech.lq0.dreamaticvoyage.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import tech.lq0.dreamaticvoyage.network.ClientPacketHandler;

import java.util.List;
import java.util.function.Supplier;

/**
 * Code based on @GoryMoon's Chargers
 */
public class ContainerDataSyncPacket {

    private final int containerId;
    private final List<Pair> data;

    public ContainerDataSyncPacket(int containerId, List<Pair> data) {
        this.containerId = containerId;
        this.data = data;
    }

    public static ContainerDataSyncPacket decode(FriendlyByteBuf buf) {
        return new ContainerDataSyncPacket(buf.readUnsignedByte(), buf.readList(byteBuf -> new Pair(byteBuf.readShort(), byteBuf.readLong())));
    }

    public static void encode(ContainerDataSyncPacket message, FriendlyByteBuf buf) {
        buf.writeByte(message.containerId);
        buf.writeCollection(message.data, (byteBuf, p) -> p.write(byteBuf));
    }

    public static void handle(ContainerDataSyncPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                () -> () -> ClientPacketHandler.handleContainerDataSyncPacket(message.containerId, message.data, ctx)));
        ctx.get().setPacketHandled(true);
    }

    public static class Pair {

        public int id;
        public long data;

        public Pair(int id, long data) {
            this.id = id;
            this.data = data;
        }

        public void write(FriendlyByteBuf buf) {
            buf.writeShort(id);
            buf.writeLong(data);
        }
    }

}
