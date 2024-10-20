package tech.lq0.dreamaticvoyage.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.client.models.armor.*;
import tech.lq0.dreamaticvoyage.client.models.blockentity.FukamizuCrusherModel;
import tech.lq0.dreamaticvoyage.client.models.curios.*;
import tech.lq0.dreamaticvoyage.client.models.entity.*;
import tech.lq0.dreamaticvoyage.client.models.blockentity.PdCLogoModel;

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
        event.registerLayerDefinition(WhiteAhogeModel.LAYER_LOCATION, WhiteAhogeModel::createBodyLayer);
        event.registerLayerDefinition(HaineIdolHelmetModel.LAYER_LOCATION, HaineIdolHelmetModel::createBodyLayer);
        event.registerLayerDefinition(HaineIdolChestplateModel.LAYER_LOCATION, HaineIdolChestplateModel::createBodyLayer);
        event.registerLayerDefinition(HaineIdolBootsModel.LAYER_LOCATION, HaineIdolBootsModel::createBodyLayer);
        event.registerLayerDefinition(AyeletMaskModel.LAYER_LOCATION, AyeletMaskModel::createBodyLayer);
        event.registerLayerDefinition(ElectricHornModel.LAYER_LOCATION, ElectricHornModel::createBodyLayer);
        event.registerLayerDefinition(JellyfishShellModel.LAYER_LOCATION, JellyfishShellModel::createBodyLayer);
        event.registerLayerDefinition(KeroroIdolBootsModel.LAYER_LOCATION, KeroroIdolBootsModel::createBodyLayer);
        event.registerLayerDefinition(KeroroIdolChestplateModel.LAYER_LOCATION, KeroroIdolChestplateModel::createBodyLayer);
        event.registerLayerDefinition(KeroroIdolHelmetModel.LAYER_LOCATION, KeroroIdolHelmetModel::createBodyLayer);
        event.registerLayerDefinition(EkiraIdolBootsModel.LAYER_LOCATION, EkiraIdolBootsModel::createBodyLayer);
        event.registerLayerDefinition(EkiraIdolChestplateModel.LAYER_LOCATION, EkiraIdolChestplateModel::createBodyLayer);
        event.registerLayerDefinition(EkiraIdolHelmetModel.LAYER_LOCATION, EkiraIdolHelmetModel::createBodyLayer);
        event.registerLayerDefinition(FrogCrownModel.LAYER_LOCATION, FrogCrownModel::createBodyLayer);
        event.registerLayerDefinition(RedNoseModel.LAYER_LOCATION, RedNoseModel::createBodyLayer);
        event.registerLayerDefinition(SuccubusTailModel.LAYER_LOCATION, SuccubusTailModel::createBodyLayer);
        event.registerLayerDefinition(GravityRestraintDeviceModel.LAYER_LOCATION, GravityRestraintDeviceModel::createBodyLayer);
        event.registerLayerDefinition(ShuRinoKenModel.LAYER_LOCATION, ShuRinoKenModel::createBodyLayer);
        event.registerLayerDefinition(ChiramHatModel.LAYER_LOCATION, ChiramHatModel::createBodyLayer);
        event.registerLayerDefinition(FluffBallModel.LAYER_LOCATION, FluffBallModel::createBodyLayer);
        event.registerLayerDefinition(YeggyPearlModel.LAYER_LOCATION, YeggyPearlModel::createBodyLayer);
        event.registerLayerDefinition(HiruHeadModel.LAYER_LOCATION, HiruHeadModel::createBodyLayer);
        event.registerLayerDefinition(PlungerModel.LAYER_LOCATION, PlungerModel::createBodyLayer);
        event.registerLayerDefinition(HirenadeGGModel.LAYER_LOCATION, HirenadeGGModel::createBodyLayer);
        event.registerLayerDefinition(LecielEarCovertsModel.LAYER_LOCATION, LecielEarCovertsModel::createBodyLayer);
        event.registerLayerDefinition(BlackEarphonesModel.LAYER_LOCATION, BlackEarphonesModel::createBodyLayer);
        event.registerLayerDefinition(OrangeTrackerModel.LAYER_LOCATION, OrangeTrackerModel::createBodyLayer);
        event.registerLayerDefinition(MaidCostumeModel.LAYER_LOCATION, MaidCostumeModel::createBodyLayer);
        event.registerLayerDefinition(MitsukiCrownModel.LAYER_LOCATION, MitsukiCrownModel::createBodyLayer);
        event.registerLayerDefinition(WaterCardModel.LAYER_LOCATION, WaterCardModel::createBodyLayer);
        event.registerLayerDefinition(HiruTentaclesModel.LAYER_LOCATION, HiruTentaclesModel::createBodyLayer);
        event.registerLayerDefinition(KRM96353Model.LAYER_LOCATION, KRM96353Model::createBodyLayer);
        event.registerLayerDefinition(DarkElfGlassesModel.LAYER_LOCATION, DarkElfGlassesModel::createBodyLayer);
        event.registerLayerDefinition(KurumiHaloModel.LAYER_LOCATION, KurumiHaloModel::createBodyLayer);
//        event.registerLayerDefinition(TetrisIBlockModel.LAYER_LOCATION, TetrisIBlockModel::createBodyLayer);
        event.registerLayerDefinition(KurumiBoomerangModel.LAYER_LOCATION, KurumiBoomerangModel::createBodyLayer);
        event.registerLayerDefinition(FukamizuCrusherModel.LAYER_LOCATION, FukamizuCrusherModel::createBodyLayer);
        event.registerLayerDefinition(ArtMasterMagicHatModel.LAYER_LOCATION, ArtMasterMagicHatModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.RegisterAdditional event) {
//        event.register(new ModelResourceLocation(Utils.MOD_ID, "special/secondary_cataclysm", "inventory"));
    }
}
