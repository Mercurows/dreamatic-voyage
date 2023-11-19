package tech.lq0.providencraft.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.models.BloodCrystalModel;
import tech.lq0.providencraft.models.curios.LunaticBowModel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelRegistry {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BloodCrystalModel.LAYER_LOCATION, BloodCrystalModel::createBodyLayer);
        event.registerLayerDefinition(LunaticBowModel.LAYER_LOCATION, LunaticBowModel::createBodyLayer);
    }
}
