package tech.lq0.providencraft.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.models.armor.*;
import tech.lq0.providencraft.models.blockentity.PdCLogoModel;
import tech.lq0.providencraft.models.curios.LunaticBowModel;
import tech.lq0.providencraft.models.entity.*;

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
        event.registerLayerDefinition(AhogeHelmetModel.LAYER_LOCATION, AhogeHelmetModel::createBodyLayer);
        event.registerLayerDefinition(MistyChestplateModel.LAYER_LOCATION, MistyChestplateModel::createBodyLayer);
        event.registerLayerDefinition(BreezeCrownModel.LAYER_LOCATION, BreezeCrownModel::createBodyLayer);
        event.registerLayerDefinition(FroggyLeggingsModel.LAYER_LOCATION, FroggyLeggingsModel::createBodyLayer);
        event.registerLayerDefinition(CelestialBootsModel.LAYER_LOCATION, CelestialBootsModel::createBodyLayer);
        event.registerLayerDefinition(ChiramIdolHelmetModel.LAYER_LOCATION, ChiramIdolHelmetModel::createBodyLayer);
        event.registerLayerDefinition(ChiramIdolChestplateModel.LAYER_LOCATION, ChiramIdolChestplateModel::createBodyLayer);
        event.registerLayerDefinition(ChiramIdolBootsModel.LAYER_LOCATION, ChiramIdolBootsModel::createBodyLayer);
        event.registerLayerDefinition(ButterflyAnkletModel.LAYER_LOCATION, ButterflyAnkletModel::createBodyLayer);
        event.registerLayerDefinition(SneakersModel.LAYER_LOCATION, SneakersModel::createBodyLayer);
        event.registerLayerDefinition(CrystalHornModel.LAYER_LOCATION, CrystalHornModel::createBodyLayer);
        event.registerLayerDefinition(WhiteAhogeEntityModel.LAYER_LOCATION, WhiteAhogeEntityModel::createBodyLayer);
    }
}
