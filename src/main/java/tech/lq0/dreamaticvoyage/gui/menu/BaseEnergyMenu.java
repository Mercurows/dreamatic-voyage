package tech.lq0.dreamaticvoyage.gui.menu;

import com.google.common.collect.Lists;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.gui.slot.ContainerEnergyData;
import tech.lq0.dreamaticvoyage.gui.slot.ContainerEnergyDataSlot;
import tech.lq0.dreamaticvoyage.network.DmvNetwork;
import tech.lq0.dreamaticvoyage.network.packet.ContainerDataSyncPacket;

import java.util.ArrayList;
import java.util.List;

/**
 * Code based on @GoryMoon's Chargers
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public abstract class BaseEnergyMenu extends AbstractContainerMenu {

    private final List<ContainerEnergyDataSlot> containerEnergyDataSlots = Lists.newArrayList();
    private final List<ServerPlayer> usingPlayers = new ArrayList<>();

    public BaseEnergyMenu(@Nullable MenuType<?> pMenuType, int pContainerId, Inventory inventory) {
        super(pMenuType, pContainerId);
    }

    public BaseEnergyMenu(@Nullable MenuType<?> pMenuType, int id, Inventory inventory, Container container, ContainerEnergyData containerData) {
        super(pMenuType, id);

        for (int i = 0; i < containerData.getCount(); ++i) {
            this.containerEnergyDataSlots.add(ContainerEnergyDataSlot.forContainer(containerData, i));
        }
    }

    @Override
    public void broadcastChanges() {
        List<ContainerDataSyncPacket.Pair> pairs = new ArrayList<>();
        for (int i = 0; i < this.containerEnergyDataSlots.size(); ++i) {
            ContainerEnergyDataSlot dataSlot = this.containerEnergyDataSlots.get(i);
            if (dataSlot.checkAndClearUpdateFlag())
                pairs.add(new ContainerDataSyncPacket.Pair(i, dataSlot.get()));
        }

        if (!pairs.isEmpty()) {
            PacketDistributor.PacketTarget target = PacketDistributor.NMLIST.with(this.usingPlayers.stream().map(serverPlayer -> serverPlayer.connection.connection)::toList);
            DmvNetwork.CHANNEL.send(target, new ContainerDataSyncPacket(this.containerId, pairs));
        }

        super.broadcastChanges();
    }

    public void setData(int id, int data) {
        this.containerEnergyDataSlots.get(id).set(data);
    }

    public void setData(int id, long data) {
        this.containerEnergyDataSlots.get(id).set(data);
    }

    @SubscribeEvent
    public static void onContainerOpened(PlayerContainerEvent.Open event) {
        if (event.getContainer() instanceof BaseEnergyMenu menu && event.getEntity() instanceof ServerPlayer serverPlayer) {
            menu.usingPlayers.add(serverPlayer);

            List<ContainerDataSyncPacket.Pair> toSync = new ArrayList<>();
            for (int i = 0; i < menu.containerEnergyDataSlots.size(); ++i) {
                toSync.add(new ContainerDataSyncPacket.Pair(i, menu.containerEnergyDataSlots.get(i).get()));
            }

            DmvNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new ContainerDataSyncPacket(menu.containerId, toSync));
        }
    }

    @SubscribeEvent
    public static void onContainerClosed(PlayerContainerEvent.Close event) {
        if (event.getContainer() instanceof BaseEnergyMenu menu && event.getEntity() instanceof ServerPlayer serverPlayer) {
            menu.usingPlayers.remove(serverPlayer);
        }
    }
}
