package tech.lq0.providencraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.SeatEntity;
import tech.lq0.providencraft.entity.TailHookEntity;
import tech.lq0.providencraft.entity.projectile.*;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<AhogeBoomerangEntity>> AHOGE_BOOMERANG_ENTITY =
            ENTITY_TYPES.register("ahoge_boomerang",
                    () -> EntityType.Builder.<AhogeBoomerangEntity>of(AhogeBoomerangEntity::new, MobCategory.MISC).sized(0.8f, 0.3f).build("ahoge_boomerang"));
    public static final RegistryObject<EntityType<PlungerEntity>> PLUNGER_ENTITY =
            ENTITY_TYPES.register("plunger",
                    () -> EntityType.Builder.<PlungerEntity>of(PlungerEntity::new, MobCategory.MISC).sized(0.3f, 0.3f).build("plunger"));
    public static final RegistryObject<EntityType<SeatEntity>> SEAT_ENTITY =
            ENTITY_TYPES.register("seat_entity",
                    () -> EntityType.Builder.<SeatEntity>of((type, level) -> new SeatEntity(level),
                            MobCategory.MISC).sized(0.0f, 0.0f).setCustomClientFactory((spawnEntity, level) -> new SeatEntity(level)).noSummon().build("seat_entity"));
    public static final RegistryObject<EntityType<DaifukuSyrupEntity>> DAIFUKU_SYRUP_ENTITY =
            ENTITY_TYPES.register("daifuku_syrup",
                    () -> EntityType.Builder.<DaifukuSyrupEntity>of(DaifukuSyrupEntity::new, MobCategory.MISC).sized(0.2f, 0.2f).build("daifuku_syrup"));
    public static final RegistryObject<EntityType<FluffBallEntity>> FLUFF_BALL_ENTITY =
            ENTITY_TYPES.register("fluff_ball",
                    () -> EntityType.Builder.<FluffBallEntity>of(FluffBallEntity::new, MobCategory.MISC).sized(0.3f, 0.3f).build("fluff_ball"));
    //    public static final RegistryObject<EntityType<KurumiBoomerangEntity>> KURUMI_BOOMERANG_ENTITY =
//            ENTITY_TYPES.register("kurumi_boomerang_entity",
//                    () -> EntityType.Builder.<KurumiBoomerangEntity>create(KurumiBoomerangEntity::new, EntityClassification.MISC).size(1.0f, 0.3f).build("kurumi_boomerang_entity"));
    public static final RegistryObject<EntityType<WhiteAhogeEntity>> WHITE_AHOGE_ENTITY =
            ENTITY_TYPES.register("white_ahoge",
                    () -> EntityType.Builder.<WhiteAhogeEntity>of(WhiteAhogeEntity::new, MobCategory.MISC).sized(0.8f, 0.3f).build("white_ahoge"));
    //    public static final RegistryObject<EntityType<NiitCarEntity>> NIIT_CAR_ENTITY =
//            ENTITY_TYPES.register("niit_car",
//                    () -> EntityType.Builder.create(NiitCarEntity::new, EntityClassification.MISC).size(2.0f, 1.7f).build("niit_car"));
//    public static final RegistryObject<EntityType<GoodManCardEntity>> GOOD_MAN_CARD_ENTITY =
//            ENTITY_TYPES.register("good_man_card",
//                    () -> EntityType.Builder.<GoodManCardEntity>create(GoodManCardEntity::new, EntityClassification.MISC).size(0.2f, 0.1f).build("good_man_card"));
//    public static final RegistryObject<EntityType<WaterCardEntity>> WATER_CARD_ENTITY =
//            ENTITY_TYPES.register("water_card",
//                    () -> EntityType.Builder.<WaterCardEntity>create(WaterCardEntity::new, EntityClassification.MISC).size(0.1f, 0.3f).build("water_card"));
    public static final RegistryObject<EntityType<BloodCrystalEntity>> BLOOD_CRYSTAL_ENTITY =
            ENTITY_TYPES.register("blood_crystal",
                    () -> EntityType.Builder.<BloodCrystalEntity>of(BloodCrystalEntity::new, MobCategory.MISC).sized(0.1f, 0.1f).build("blood_crystal"));
    public static final RegistryObject<EntityType<CursedCatDollEntity>> CURSED_CAT_DOLL_ENTITY =
            ENTITY_TYPES.register("cursed_cat_doll",
                    () -> EntityType.Builder.<CursedCatDollEntity>of(CursedCatDollEntity::new, MobCategory.MISC).sized(0.3f, 0.3f).build("cursed_cat_doll"));
    public static final RegistryObject<EntityType<ShuRinoKenEntity>> SHU_RINO_KEN_ENTITY =
            ENTITY_TYPES.register("shu_rino_ken",
                    () -> EntityType.Builder.<ShuRinoKenEntity>of(ShuRinoKenEntity::new, MobCategory.MISC).sized(0.5f, 0.2f).build("shu_rino_ken"));
    public static final RegistryObject<EntityType<TailHookEntity>> TAIL_HOOK_ENTITY =
            ENTITY_TYPES.register("tail_hook",
                    () -> EntityType.Builder.<TailHookEntity>createNothing(MobCategory.MISC)
                            .noSave().clientTrackingRange(4).updateInterval(5).noSummon().sized(0.25f, 0.25f)
                            .setCustomClientFactory(TailHookEntity::new).build("tail_hook"));
//    public static final RegistryObject<EntityType<HirenadeGGEntity>> HIRENADE_GG_ENTITY =
//            ENTITY_TYPES.register("hirenade_gg",
//                    () -> EntityType.Builder.<HirenadeGGEntity>create(HirenadeGGEntity::new, EntityClassification.MISC).size(0.4f, 0.4f).build("hirenade_gg"));
//
//    public static final RegistryObject<EntityType<LeviyBeamEntity>> LEVIY_BEAM_ENTITY =
//            ENTITY_TYPES.register("leviy_beam",
//                    () -> EntityType.Builder.create(LeviyBeamEntity::new, EntityClassification.MISC).size(1, 100).disableSerialization().trackingRange(300).func_233608_b_(Integer.MAX_VALUE).build("leviy_beam"));
}
