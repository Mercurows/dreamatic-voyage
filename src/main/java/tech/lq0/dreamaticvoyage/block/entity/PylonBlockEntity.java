package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;

public abstract class PylonBlockEntity extends BlockEntity {
    protected NonNullList<byte[]> connections = NonNullList.create();

    public PylonBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    abstract public int getPylonLevel();

    abstract public boolean canBind(byte[] offset);

    abstract public boolean canBindMore();

    public boolean hasConnection(byte[] offset) {
        return this.connections.stream().anyMatch(c -> Arrays.equals(c, offset));
    }

    public void addConnection(byte[] offset) {
        if (this.hasConnection(offset)) {
            return;
        }
        this.connections.add(offset);
    }

    public void removeConnection(byte[] offset) {
        this.connections.removeIf(c -> Arrays.equals(c, offset));
    }
}
