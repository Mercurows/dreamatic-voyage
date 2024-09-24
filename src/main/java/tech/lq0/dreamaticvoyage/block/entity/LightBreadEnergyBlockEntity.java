package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.uce.IUCEnergyStorage;
import tech.lq0.dreamaticvoyage.capability.uce.UCEnergyStorage;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;

// TODO 完成电池逻辑
public class LightBreadEnergyBlockEntity extends BlockEntity {

    public static final int MAX_CAPACITY = 3600000;
    public static final int TRANSFER_SPEED = 2000;

    public LazyOptional<IUCEnergyStorage> capability;
    public UCEnergyStorage energyStorage = new UCEnergyStorage(MAX_CAPACITY, TRANSFER_SPEED);

    public LightBreadEnergyBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.LIGHT_BREAD_ENERGY_BLOCK_ENTITY.get(), pPos, pBlockState);
        capability = LazyOptional.of(() -> energyStorage);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, LightBreadEnergyBlockEntity blockEntity) {
        blockEntity.charge(pLevel, pPos, pState);
    }

    private void charge(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!this.energyStorage.canReceive()) {
            return;
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        this.energyStorage.read(pTag);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        this.energyStorage.write(pTag);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY) {
            return this.capability.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.capability.invalidate();
    }
}
