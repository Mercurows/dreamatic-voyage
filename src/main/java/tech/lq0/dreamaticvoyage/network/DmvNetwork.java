package tech.lq0.dreamaticvoyage.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.network.packet.LeviyLaunchPacket;
import tech.lq0.dreamaticvoyage.network.packet.PhantasmalVoyagerPacket;

public class DmvNetwork {
    public static final String NETWORK_VERSION = "1.0";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(Utils.MOD_ID, "network"),
            () -> NETWORK_VERSION, NETWORK_VERSION::equals, NETWORK_VERSION::equals);

    public static void init() {
        CHANNEL.registerMessage(0, LeviyLaunchPacket.class, LeviyLaunchPacket::encode, LeviyLaunchPacket::decode, LeviyLaunchPacket::handle);
        CHANNEL.registerMessage(1, PhantasmalVoyagerPacket.class, PhantasmalVoyagerPacket::encode, PhantasmalVoyagerPacket::decode, PhantasmalVoyagerPacket::handle);
    }
}
