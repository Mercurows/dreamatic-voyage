package tech.lq0.dreamaticvoyage.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;
import tech.lq0.dreamaticvoyage.entity.projectile.BeamEntity;

import java.util.function.Supplier;

/**
 * Beam Packet codes based on @Polarice3's Goety-2
 */
public class BeamPacket {
    private final int beamEntityID;
    private final double positionX;
    private final double positionY;
    private final double positionZ;
    private final float xRot;
    private final float yRot;
    private final float xRotO;
    private final float yRotO;

    public BeamPacket(BeamEntity entity) {
        this.beamEntityID = entity.getId();
        this.positionX = entity.position().x;
        this.positionY = entity.position().y;
        this.positionZ = entity.position().z;
        this.xRot = entity.getXRot();
        this.yRot = entity.getYRot();
        this.xRotO = entity.xRotO;
        this.yRotO = entity.yRotO;
    }

    public BeamPacket(int beamEntityID, double positionX, double positionY, double positionZ, float xRot, float yRot, float xRotO, float yRotO) {
        this.beamEntityID = beamEntityID;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.xRot = xRot;
        this.yRot = yRot;
        this.xRotO = xRotO;
        this.yRotO = yRotO;
    }

    public static void encode(BeamPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.beamEntityID);
        buf.writeDouble(packet.positionX);
        buf.writeDouble(packet.positionY);
        buf.writeDouble(packet.positionZ);
        buf.writeFloat(packet.xRot);
        buf.writeFloat(packet.yRot);
        buf.writeFloat(packet.xRotO);
        buf.writeFloat(packet.yRotO);
    }

    public static BeamPacket decode(FriendlyByteBuf buf) {
        return new BeamPacket(
                buf.readInt(),
                buf.readDouble(),
                buf.readDouble(),
                buf.readDouble(),
                buf.readFloat(),
                buf.readFloat(),
                buf.readFloat(),
                buf.readFloat()
        );
    }

    public static void handle(BeamPacket packet, Supplier<NetworkEvent.Context> ctx) {
        if (packet != null) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();
                if (player != null) {
                    Entity entity = player.level().getEntity(packet.beamEntityID);
                    if (entity instanceof BeamEntity beamEntity) {
                        if (beamEntity.getOwner() != player) {
                            return;
                        }
                        beamEntity.setPos(packet.positionX, packet.positionY, packet.positionZ);
                        beamEntity.setXRot(packet.xRot);
                        beamEntity.setYRot(packet.yRot);
                        beamEntity.xRotO = packet.xRotO;
                        beamEntity.yRotO = packet.yRotO;
                    }
                }
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
