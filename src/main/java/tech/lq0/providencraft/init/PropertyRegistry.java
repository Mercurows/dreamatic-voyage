package tech.lq0.providencraft.init;

import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.ItemNBTTool;

import static tech.lq0.providencraft.item.providenceOI.shirako.MomoPhone.NBT_BINDING;
import static tech.lq0.providencraft.item.providenceOI.yesa.TailFishingRod.TAG_CAST;
import static tech.lq0.providencraft.item.providencesecond.lecia.ElectricHorn.TAG_ABLE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ItemModelsProperties.registerProperty(ItemRegistry.HAI_PLATE.get(), new ResourceLocation(Utils.MOD_ID, "blocking"), (itemStack, clientWorld, livingEntity) ->
                livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F));
        event.enqueueWork(() -> ItemModelsProperties.registerProperty(ItemRegistry.HAYAMEN.get(), new ResourceLocation(Utils.MOD_ID, "hayamen_blocking"), (itemStack, clientWorld, livingEntity) ->
                livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.ELECTRIC_HORN.get(), new ResourceLocation(Utils.MOD_ID, "electric_horn_able"),
                        (stack, world, entity) -> ItemNBTTool.getBoolean(stack, TAG_ABLE, false) ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.MOMO_PHONE.get(), new ResourceLocation(Utils.MOD_ID, "momo_phone_binding"),
                        (itemStack, clientWorld, livingEntity) -> ItemNBTTool.getBoolean(itemStack, NBT_BINDING, false) ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.TAIL_FISHING_ROD.get(), new ResourceLocation(Utils.MOD_ID, "tail_cast"),
                        (itemStack, clientWorld, livingEntity) -> ItemNBTTool.getBoolean(itemStack, TAG_CAST, false) ? 1.0F : 0.0F));
    }
}
