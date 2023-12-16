package tech.lq0.providencraft.init;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.ItemNBTTool;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() ->
                ItemProperties.register(ItemRegistry.HAI_PLATE.get(), new ResourceLocation(Utils.MOD_ID, "blocking"),
                        (itemStack, clientWorld, livingEntity, seed) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemProperties.register(ItemRegistry.ELECTRIC_HORN.get(), new ResourceLocation(Utils.MOD_ID, "electric_horn_able"),
                        (stack, world, entity, seed) -> ItemNBTTool.getBoolean(stack, "able", false) ? 1.0F : 0.0F));
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.MOMO_PHONE.get(), new ResourceLocation(Utils.MOD_ID, "momo_phone_binding"),
                (itemStack, clientWorld, livingEntity, seed) -> ItemNBTTool.getBoolean(itemStack, "binding", false) ? 1.0F : 0.0F));
    }
}
