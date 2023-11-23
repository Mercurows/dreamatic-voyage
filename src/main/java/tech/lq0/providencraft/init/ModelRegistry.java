package tech.lq0.providencraft.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.models.armor.ReinaWingsModel;
import tech.lq0.providencraft.models.blockentity.PdCLogoModel;
import tech.lq0.providencraft.models.entity.AhogeBoomerangModel;
import tech.lq0.providencraft.models.entity.BloodCrystalModel;
import tech.lq0.providencraft.models.curios.LunaticBowModel;
import tech.lq0.providencraft.models.entity.CursedCatDollModel;
import tech.lq0.providencraft.models.entity.DaifukuSyrupModel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelRegistry {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BloodCrystalModel.LAYER_LOCATION, BloodCrystalModel::createBodyLayer);
        event.registerLayerDefinition(LunaticBowModel.LAYER_LOCATION, LunaticBowModel::createBodyLayer);
        event.registerLayerDefinition(ReinaWingsModel.LAYER_LOCATION, ReinaWingsModel::createBodyLayer);
        event.registerLayerDefinition(PdCLogoModel.LAYER_LOCATION, PdCLogoModel::createBodyLayer);
        event.registerLayerDefinition(DaifukuSyrupModel.LAYER_LOCATION, DaifukuSyrupModel::createBodyLayer);
        event.registerLayerDefinition(CursedCatDollModel.LAYER_LOCATION, CursedCatDollModel::createBodyLayer);
        event.registerLayerDefinition(AhogeBoomerangModel.LAYER_LOCATION, AhogeBoomerangModel::createBodyLayer);
    }
}
