package tech.lq0.providencraft.entity;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.level.Level;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import tech.lq0.providencraft.init.EntityRegistry;

public class TailHookEntity extends FishingHook implements IEntityAdditionalSpawnData {
    public TailHookEntity(PlayMessages.SpawnEntity spawnPacket, Level world) {
        super(world.getPlayerByUUID(spawnPacket.getAdditionalData().readUUID()), world, 0, 0);
    }

    public TailHookEntity(Player player, Level world, int luck, int lureSpeed) {
        super(player, world, luck, lureSpeed);
        this.setOwner(player);
        player.fishing = this;
    }

    @Override
    public EntityType<?> getType() {
        return EntityRegistry.TAIL_HOOK_ENTITY.get();
    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        Player player = this.getPlayerOwner();
        if (player != null) {
            buffer.writeUUID(player.getUUID());
        }
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {

    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
