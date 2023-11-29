package tech.lq0.providencraft.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;

import java.util.List;

//From MrCrayfishFurnitureMod
public class SeatEntity extends Entity {
    public SeatEntity(Level level) {
        super(EntityRegistry.SEAT_ENTITY.get(), level);
        this.noPhysics = true;
    }

    private SeatEntity(Level level, BlockPos source, double yOffset) {
        this(level);
        this.setPos(source.getX() + 0.5, source.getY() + yOffset, source.getZ() + 0.5);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            if (this.getPassengers().isEmpty() || this.level().isEmptyBlock(this.blockPosition())) {
                this.remove(RemovalReason.DISCARDED);
                this.level().updateNeighbourForOutputSignal(blockPosition(), this.level().getBlockState(blockPosition()).getBlock());
            }
        }
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.0;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected boolean canRide(Entity pVehicle) {
        return true;
    }

    public static InteractionResult create(Level level, BlockPos pos, double yOffset, Player player) {
        if (!level.isClientSide()) {
            List<SeatEntity> seats = level.getEntitiesOfClass(SeatEntity.class, new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0));
            if (seats.isEmpty()) {
                SeatEntity seat = new SeatEntity(level, pos, yOffset);
                level.addFreshEntity(seat);
                player.startRiding(seat, false);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
