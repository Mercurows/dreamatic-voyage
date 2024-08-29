package tech.lq0.dreamaticvoyage.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import tech.lq0.dreamaticvoyage.entity.LeviyBeamEntity;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;

import java.util.function.Supplier;

public class LeviyLaunchPacket {
    private final int x;
    private final int y;
    private final int z;

    private final float power;
    private final float radius;
    private final int duration;

    public LeviyLaunchPacket(int x, int y, int z) {
        this(x, y, z, 6, 10, 200);
    }

    public LeviyLaunchPacket(int x, int y, int z, float power) {
        this(x, y, z, power, 10, 200);
    }

    public LeviyLaunchPacket(int x, int y, int z, float power, float radius) {
        this(x, y, z, power, radius, 200);
    }

    public LeviyLaunchPacket(int x, int y, int z, float power, float radius, int duration) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.power = power;
        this.radius = radius;
        this.duration = duration;
    }

    public static void encode(LeviyLaunchPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.x);
        buf.writeInt(packet.y);
        buf.writeInt(packet.z);
    }

    public static LeviyLaunchPacket decode(FriendlyByteBuf buf) {
        return new LeviyLaunchPacket(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public static void handle(LeviyLaunchPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            if (player == null) return;

            var world = player.level();

            double xDiff = player.getX() - packet.x;
            double zDiff = player.getZ() - packet.z;
            double distance = Math.sqrt(xDiff * xDiff + zDiff * zDiff);

            if (distance > 512) return;

            LeviyBeamEntity beam = EntityRegistry.LEVIY_BEAM_ENTITY.get().create(player.level());

            assert beam != null;
            beam.setPos(packet.x, packet.y, packet.z);
            beam.setPower(packet.power);
            beam.setMaxRadius(packet.radius);
            beam.setDuration(packet.duration);
            beam.setOwner(player);
            world.addFreshEntity(beam);
        });
        ctx.get().setPacketHandled(true);
    }

}
