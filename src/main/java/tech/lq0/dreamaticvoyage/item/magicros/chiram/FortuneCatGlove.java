package tech.lq0.dreamaticvoyage.item.magicros.chiram;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FortuneCatGlove extends Item implements ICurioItem {

    public FortuneCatGlove() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onClientChat(ClientChatEvent event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;
        CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.FORTUNE_CAT_GLOVE.get()).ifPresent(
                slotResult -> event.setMessage(event.getOriginalMessage() +
                        Component.translatable("des.dreamaticvoyage.fortune_cat_glove.text").getString())
        ));
    }

}
