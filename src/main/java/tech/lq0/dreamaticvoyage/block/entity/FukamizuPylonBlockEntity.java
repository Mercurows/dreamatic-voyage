package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.uce.UCEnergyStorage;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.concurrent.atomic.AtomicBoolean;

// TODO 完成能量塔逻辑
public class FukamizuPylonBlockEntity extends PylonBlockEntity implements WorldlyContainer, MenuProvider {

    public static final int MAX_RANGE = 16;
    public static final int MAX_CAPACITY = 128000;
    public static final int CHARGE_SPEED = 50;
    public static final int CHARGE_TIME = 40;
    public static final int TRANSFER_COOLDOWN = 40;
    public static final int MAX_CONNECT_COUNT = 10;
    public static final int MAX_TRANSFER_SINGLE = 200;

    private LazyOptional<UCEnergyStorage> energyHandler;
    public int chargeTime;
    public int cooldown = 0;

    public FukamizuPylonBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.FUKAMIZU_PYLON_BLOCK_ENTITY.get(), pPos, pBlockState);

        this.energyHandler = LazyOptional.of(() -> new UCEnergyStorage(MAX_CAPACITY, MAX_TRANSFER_SINGLE * MAX_CONNECT_COUNT));
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, FukamizuPylonBlockEntity pylonBlockEntity) {
        pylonBlockEntity.selfCharge(pLevel, pPos, pState);

        if (pylonBlockEntity.cooldown > 0) {
            pylonBlockEntity.cooldown--;
        } else {
            pylonBlockEntity.cooldown = TRANSFER_COOLDOWN;
        }

        // 自动移除失效链接
        pylonBlockEntity.connections.removeIf(offset -> {
            var newPos = new BlockPos(pPos.getX() + offset[0], pPos.getY() + offset[1], pPos.getZ() + offset[2]);
            var blockEntity = pLevel.getBlockEntity(newPos);
            return blockEntity == null || !blockEntity.getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).isPresent();
        });

        // 尝试发送能量
        if (pylonBlockEntity.cooldown == 0 && pylonBlockEntity.energyHandler.map(UCEnergyStorage::getEnergyStored).orElse(0) > 0) {
            pylonBlockEntity.connections.forEach(offset -> {
                var newPos = new BlockPos(pPos.getX() + offset[0], pPos.getY() + offset[1], pPos.getZ() + offset[2]);
                var blockEntity = pLevel.getBlockEntity(newPos);
                if (blockEntity == null) return;

                blockEntity.getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(targetBlockHandler -> {
                    if (targetBlockHandler.canReceive() && targetBlockHandler.getEnergyStored() < targetBlockHandler.getMaxEnergyStored()) {
                        int energy = targetBlockHandler.receiveEnergy(MAX_TRANSFER_SINGLE, false);
                        pylonBlockEntity.energyHandler.ifPresent(handler -> handler.extractEnergy(energy, false));
                    }
                });
            });
        }
    }

    private void selfCharge(Level pLevel, BlockPos pPos, BlockState pState) {
        AtomicBoolean flag = new AtomicBoolean(false);
        this.energyHandler.ifPresent(handler -> flag.set(handler.getEnergyStored() >= handler.getMaxEnergyStored()));
        if (flag.get()) return;

        if (this.chargeTime <= 0) {
            ItemStack stack = this.items.get(0);
            if (stack.isEmpty()) {
                return;
            }

            if (!stack.is(ItemRegistry.SWOLLEN_FUKAMIZU_BREAD_INGOT.get())) {
                return;
            }

            stack.shrink(1);
            this.chargeTime += CHARGE_TIME;

            this.setChanged();
            pLevel.sendBlockUpdated(pPos, pState, pState, 3);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pState));
        } else {
            this.energyHandler.ifPresent(handler -> handler.receiveEnergy(CHARGE_SPEED, false));
            this.chargeTime--;
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.dreamaticvoyage.fukamizu_pylon");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    @Override
    public boolean canBind(byte[] offset) {
        return Math.abs(offset[0]) <= MAX_RANGE && Math.abs(offset[1]) <= MAX_RANGE && Math.abs(offset[2]) <= MAX_RANGE;
    }

    @Override
    public boolean canBindMore() {
        return this.connections.size() < MAX_CONNECT_COUNT;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        if (pTag.contains("UmisuEnergy")) {
            getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(handler -> ((UCEnergyStorage) handler).deserializeNBT(pTag.get("UmisuEnergy")));
        }
        this.chargeTime = pTag.getInt("ChargeTime");
        this.cooldown = pTag.getInt("Cooldown");
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);

        var connectionsTag = pTag.getList("Connections", CompoundTag.TAG_COMPOUND);
        this.connections.clear();
        for (var connectionTag : connectionsTag) {
            this.connections.add(((CompoundTag) connectionTag).getByteArray("Offset"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);

        getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).ifPresent(handler -> pTag.put("UmisuEnergy", ((UCEnergyStorage) handler).serializeNBT()));
        pTag.putInt("ChargeTime", this.chargeTime);
        pTag.putInt("Cooldown", this.cooldown);
        ContainerHelper.saveAllItems(pTag, this.items);

        var connectionsTag = new ListTag();
        for (var connection : this.connections) {
            var connectionTag = new CompoundTag();
            connectionTag.putByteArray("Offset", connection);
            connectionsTag.add(connectionTag);
        }
        pTag.put("Connections", connectionsTag);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY) {
            return this.energyHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.energyHandler.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.energyHandler = LazyOptional.of(() -> new UCEnergyStorage(MAX_CAPACITY));
    }

    @Override
    public int getPylonLevel() {
        return 1;
    }
}
