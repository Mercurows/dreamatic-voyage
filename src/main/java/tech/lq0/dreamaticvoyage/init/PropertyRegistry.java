package tech.lq0.dreamaticvoyage.init;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() ->
                ItemProperties.register(ItemRegistry.HAI_PLATE.get(), Utils.loc("blocking"),
                        (itemStack, clientWorld, livingEntity, seed) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemProperties.register(ItemRegistry.HAYAMEN.get(), Utils.loc("blocking"),
                        (itemStack, clientWorld, livingEntity, seed) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemProperties.register(ItemRegistry.ELECTRIC_HORN.get(), Utils.loc("electric_horn_able"),
                        (stack, world, entity, seed) -> ItemNBTTool.getBoolean(stack, "able", false) ? 1.0F : 0.0F));
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.MOMO_PHONE.get(), Utils.loc("momo_phone_binding"),
                (itemStack, clientWorld, livingEntity, seed) -> ItemNBTTool.getBoolean(itemStack, "binding", false) ? 1.0F : 0.0F));
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.SHURA_CHIN.get(), Utils.loc("invoke"),
                (stack, world, entity, seed) -> ItemNBTTool.getBoolean(stack, "invoke", false) ? 1.0F : 0.0F));
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.UME.get(), Utils.loc("invoke"),
                (stack, world, entity, seed) -> ItemNBTTool.getBoolean(stack, "invoke", false) ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemProperties.register(ItemRegistry.TAIL_FISHING_ROD.get(), new ResourceLocation("cast"), (heldStack, world, livingEntity, seed) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    } else {
                        boolean isMainhand = livingEntity.getMainHandItem() == heldStack;
                        boolean isOffHand = livingEntity.getOffhandItem() == heldStack;
                        if (livingEntity.getMainHandItem().getItem() instanceof FishingRodItem) {
                            isOffHand = false;
                        }
                        return (isMainhand || isOffHand) && livingEntity instanceof Player player && player.fishing != null ? 1.0F : 0.0F;
                    }
                })
        );
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.UNFAITHFUL_HEART.get(), Utils.loc("damage"),
                (heldStack, world, livingEntity, seed) -> heldStack.getDamageValue())
        );
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.RED_COW_HORN.get(), new ResourceLocation("tooting"),
                (heldStack, world, livingEntity, seed) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == heldStack ? 1.0F : 0.0F));
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.OMINOUS_SICKLE.get(), new ResourceLocation("invoke"),
                (heldStack, world, livingEntity, seed) -> ItemNBTTool.getBoolean(heldStack, "Invoke", false) ? 1.0F : 0.0F));
//        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.TETRIS_CAT.get(), Utils.loc("tetriscat_blocking"),
//                (heldStack, world, livingEntity, seed) ->
//                        livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == heldStack ? 1.0F : 0.0F));
//        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.TETRIS_CAT.get(), Utils.loc("tetriscat_tetrisblock"),
//                (heldStack, world, livingEntity, seed) -> {
//                    if (livingEntity != null){
//                        return (float)ItemNBTTool.getInt(heldStack, "tetris_block", 0 );
//                    }
//                    return 0.0f;
//                }));
//        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.TETRIS_CAT.get(), Utils.loc("tetriscat_isshield"),
//                (heldStack, world, livingEntity, seed) ->
//                        livingEntity != null && livingEntity.getOffhandItem().getItem() == ItemRegistry.TETRIS_CAT.get() ? 1.0f : 0.0f));
    }
}
