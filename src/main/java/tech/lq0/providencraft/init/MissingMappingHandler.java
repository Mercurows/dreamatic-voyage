//package tech.lq0.providencraft.init;
//
//import net.minecraft.core.registries.Registries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.MissingMappingsEvent;
//
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class MissingMappingHandler {
//    @SubscribeEvent
//    public static void onMissingMappings(MissingMappingsEvent event) {
//        for (MissingMappingsEvent.Mapping<Item> mapping : event.getAllMappings(Registries.ITEM)) {
//            if ("providencraft".equals(mapping.getKey().getNamespace())) {
//                ResourceLocation newResourceLocation = new ResourceLocation("voyaprocrypha", mapping.getKey().getPath());
//
//                Item remappedResource = ForgeRegistries.ITEMS.getValue(newResourceLocation);
//
//                if (remappedResource != null) {
//                    mapping.remap(remappedResource);
//                }
//            }
//        }
//
//        for (MissingMappingsEvent.Mapping<Block> mapping : event.getAllMappings(Registries.BLOCK)) {
//            if ("providencraft".equals(mapping.getKey().getNamespace())) {
//                ResourceLocation newResourceLocation = new ResourceLocation("voyaprocrypha", mapping.getKey().getPath());
//
//                Block remappedResource = ForgeRegistries.BLOCKS.getValue(newResourceLocation);
//
//                if (remappedResource != null) {
//                    mapping.remap(remappedResource);
//                }
//            }
//        }
//    }
//}
