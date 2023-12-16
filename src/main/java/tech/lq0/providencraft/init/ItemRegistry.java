package tech.lq0.providencraft.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.item.donate.AtsuiShio;
import tech.lq0.providencraft.item.donate.EmptyJar;
import tech.lq0.providencraft.item.legacy.LavaCake;
import tech.lq0.providencraft.item.legacy.Plate;
import tech.lq0.providencraft.item.legacy.YagiStaffCard;
import tech.lq0.providencraft.item.material.*;
import tech.lq0.providencraft.item.other.*;
import tech.lq0.providencraft.item.providenceOI.ccelia.CraftBeer0322;
import tech.lq0.providencraft.item.providenceOI.fukami.*;
import tech.lq0.providencraft.item.providenceOI.lutafia.Fiaxe;
import tech.lq0.providencraft.item.providenceOI.miya.JellyfishShell;
import tech.lq0.providencraft.item.providenceOI.miya.TailPen;
import tech.lq0.providencraft.item.providenceOI.rino.ClarityAmulet;
import tech.lq0.providencraft.item.providenceOI.roky.Xiaolongbao;
import tech.lq0.providencraft.item.providenceOI.shirako.*;
import tech.lq0.providencraft.item.providenceOI.shirayuki.ButterflyAnklet;
import tech.lq0.providencraft.item.providenceOI.sorayo.LunaticBow;
import tech.lq0.providencraft.item.providenceOI.sorayo.MoonCake;
import tech.lq0.providencraft.item.providenceOI.yesa.MintChocolate;
import tech.lq0.providencraft.item.providenceOI.yuri.RabbitLychee;
import tech.lq0.providencraft.item.providencefirst.ayelet.CrystalHorn;
import tech.lq0.providencraft.item.providencefirst.ayelet.SleepRoulette;
import tech.lq0.providencraft.item.providencefirst.haya.BigSpoon;
import tech.lq0.providencraft.item.providencefirst.madoka.*;
import tech.lq0.providencraft.item.providencefirst.mari.Machete;
import tech.lq0.providencraft.item.providencefirst.mari.MagicMirror;
import tech.lq0.providencraft.item.providencefirst.mari.MariStew;
import tech.lq0.providencraft.item.providencefirst.myanna.DarkElfCore;
import tech.lq0.providencraft.item.providencefirst.myanna.Drill;
import tech.lq0.providencraft.item.providencefirst.myanna.MountainDestroyer;
import tech.lq0.providencraft.item.providencefirst.myanna.Schedule;
import tech.lq0.providencraft.item.providencefirst.niina.BananaMilk;
import tech.lq0.providencraft.item.providencefirst.unia.ElfWings;
import tech.lq0.providencraft.item.providencefirst.unia.EnchantedUnigiri;
import tech.lq0.providencraft.item.providencefirst.unia.TaroIceCream;
import tech.lq0.providencraft.item.providencefirst.unia.Unigiri;
import tech.lq0.providencraft.item.providencefirst.usa.BrownieUzza;
import tech.lq0.providencraft.item.providencefourth.choco.ChocoalCookie;
import tech.lq0.providencraft.item.providencefourth.choco.StrawberryCake;
import tech.lq0.providencraft.item.providencefourth.hifumi.NetherLight;
import tech.lq0.providencraft.item.providencefourth.sana.Shakana;
import tech.lq0.providencraft.item.providencemagicros.chiram.*;
import tech.lq0.providencraft.item.providencemagicros.ekira.*;
import tech.lq0.providencraft.item.providencemagicros.haine.*;
import tech.lq0.providencraft.item.providencemagicros.keroro.*;
import tech.lq0.providencraft.item.providencesecond.lecia.ElectricHorn;
import tech.lq0.providencraft.item.providencesecond.lecia.MechanicalHorn;
import tech.lq0.providencraft.item.providencesecond.louise.*;
import tech.lq0.providencraft.item.providencesecond.lucia.BigFierceOneCoffee;
import tech.lq0.providencraft.item.providencesecond.lucia.BigMoeOnePotion;
import tech.lq0.providencraft.item.providencesecond.lucia.LuciaRiceCake;
import tech.lq0.providencraft.item.providencesecond.lucia.MoonlightAmulet;
import tech.lq0.providencraft.item.providencesecond.mumu.AyeletMask;
import tech.lq0.providencraft.item.providencesecond.mumu.MumuSteak;
import tech.lq0.providencraft.item.providencesecond.satou.*;
import tech.lq0.providencraft.item.providencethird.hiru.GNSouls;
import tech.lq0.providencraft.item.providencethird.hiru.GNSpirit;
import tech.lq0.providencraft.item.providencethird.hiru.GNStar;
import tech.lq0.providencraft.item.providencethird.leciel.ReinaFeather;
import tech.lq0.providencraft.item.providencethird.leciel.ReinaWings;
import tech.lq0.providencraft.item.providencethird.yuki.FoxIceCream;
import tech.lq0.providencraft.item.providencethird.yuki.FoxPudding;
import tech.lq0.providencraft.tools.Livers;

@SuppressWarnings("unused")
public class ItemRegistry {

    /**
     * ===PROVIDENCRAFT ITEMS===
     **/
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    /**
     * 1st
     **/
    //madoka
    public static final RegistryObject<Item> RED_AHOGE = ITEMS.register("red_ahoge", RedAhoge::new);
    public static final RegistryObject<Item> RED_AHOGE_SWORD = ITEMS.register("red_ahoge_sword", RedAhogeSword::new);
    public static final RegistryObject<Item> RED_AHOGE_BOOMERANG = ITEMS.register("red_ahoge_boomerang", RedAhogeBoomerang::new);
    public static final RegistryObject<Item> RED_AHOGE_HELMET = ITEMS.register("red_ahoge_helmet", RedAhogeHelmet::new);
    public static final RegistryObject<Item> PEACH_BEACH = ITEMS.register("peach_beach", PeachBeach::new);
    public static final RegistryObject<Item> RED_AHOGE_MACHETE = ITEMS.register("red_ahoge_machete", RedAhogeMachete::new);
    public static final RegistryObject<Item> SNEAKERS = ITEMS.register("sneakers", Sneakers::new);
    public static final RegistryObject<Item> CRIMSON_IMPACT = ITEMS.register("crimson_impact", CrimsonImpact::new);

    //ayelet
    public static final RegistryObject<Item> CRYSTAL_HORN = ITEMS.register("crystal_horn", CrystalHorn::new);
    public static final RegistryObject<Item> SLEEP_ROULETTE = ITEMS.register("sleep_roulette", SleepRoulette::new);

    //mari
    public static final RegistryObject<Item> MACHETE = ITEMS.register("machete", Machete::new);
    public static final RegistryObject<Item> MARI_STEW = ITEMS.register("mari_stew", MariStew::new);
    public static final RegistryObject<Item> MAGIC_MIRROR = ITEMS.register("magic_mirror", MagicMirror::new);

    //mitsuki
//    public static final RegistryObject<Item> CROWN = ITEMS.register("crown", Crown::new);
//    public static final RegistryObject<Item> GOOD_MAN_CARD = ITEMS.register("good_man_card", GoodManCard::new);

    //niina
    public static final RegistryObject<Item> BANANA_MILK = ITEMS.register("banana_milk", BananaMilk::new);
//    public static final RegistryObject<Item> BLUE_SMALL_BALL = ITEMS.register("blue_small_ball", BlueSmallBall::new);
//
    //usa
//    public static final RegistryObject<Item> PLUNGER = ITEMS.register("plunger", Plunger::new);
//    public static final RegistryObject<Item> KURUMI_BOOMERANG = ITEMS.register("kurumi_boomerang", KurumiBoomerang::new);
//    public static final RegistryObject<Item> KURUMI_HALO = ITEMS.register("kurumi_halo", KurumiHalo::new);
    public static final RegistryObject<Item> BROWNIE_UZZA = ITEMS.register("brownie_uzza", BrownieUzza::new);

    //myanna
    public static final RegistryObject<Item> MOUNTAIN_DESTROYER = ITEMS.register("mountain_destroyer", MountainDestroyer::new);
    public static final RegistryObject<Item> DARK_ELF_CORE = ITEMS.register("dark_elf_core", DarkElfCore::new);
    public static final RegistryObject<Item> DRILL = ITEMS.register("drill", Drill::new);
    public static final RegistryObject<Item> SCHEDULE = ITEMS.register("schedule", Schedule::new);
//    public static final RegistryObject<Item> DARK_ELF_GLASSES = ITEMS.register("dark_elf_glasses", DarkElfGlasses::new);

    //haya
//    public static final RegistryObject<Item> HAYAMEN = ITEMS.register("hayamen", Hayamen::new);
    public static final RegistryObject<Item> BIG_SPOON = ITEMS.register("big_spoon", BigSpoon::new);
//    public static final RegistryObject<Item> HAYA_SWORD = ITEMS.register("haya_sword", HayaSword::new);

    //unia
    public static final RegistryObject<Item> TARO_ICE_CREAM = ITEMS.register("taro_ice_cream", TaroIceCream::new);
    public static final RegistryObject<Item> UNIGIRI = ITEMS.register("unigiri", Unigiri::new);
    public static final RegistryObject<Item> ENCHANTED_UNIGIRI = ITEMS.register("enchanted_unigiri", EnchantedUnigiri::new);
    public static final RegistryObject<Item> ELF_WINGS = ITEMS.register("elf_wings", ElfWings::new);

    /**
     * 2nd
     **/
    //lucia
    public static final RegistryObject<Item> LUCIA_RICE_CAKE = ITEMS.register("lucia_rice_cake", LuciaRiceCake::new);
    public static final RegistryObject<Item> BIG_MOE_ONE_POTION = ITEMS.register("big_moe_one_potion", BigMoeOnePotion::new);
    public static final RegistryObject<Item> MOONLIGHT_AMULET = ITEMS.register("moonlight_amulet", MoonlightAmulet::new);
    public static final RegistryObject<Item> BIG_FIERCE_ONE_COFFEE = ITEMS.register("big_fierce_one_coffee", BigFierceOneCoffee::new);

    //louise
    public static final RegistryObject<Item> WHITE_AHOGE = ITEMS.register("white_ahoge", WhiteAhoge::new);
    public static final RegistryObject<Item> WHITE_DOUBLE_AHOGE = ITEMS.register("white_double_ahoge", WhiteDoubleAhoge::new);
    public static final RegistryObject<Item> MAGIC_BOOK = ITEMS.register("magic_book", MagicBook::new);
    public static final RegistryObject<Item> MAGIC_BOOK_MYANNA = ITEMS.register("magic_book_myanna", MagicBookMyanna::new);
    public static final RegistryObject<Item> MAGIC_BOOK_MYANNA_PLUS = ITEMS.register("magic_book_myanna_plus", MagicBookMyannaPlus::new);
    public static final RegistryObject<Item> MAGIC_BOOK_THROW = ITEMS.register("magic_book_throw", MagicBookThrow::new);
    public static final RegistryObject<Item> MAGIC_BOOK_REVELATION = ITEMS.register("magic_book_revelation", MagicBookRevelation::new);
    public static final RegistryObject<Item> LOUISTEW = ITEMS.register("louistew", Louistew::new);
    public static final RegistryObject<Item> UNI_MILLET = ITEMS.register("uni_millet", UniMillet::new);

    //lecia
    public static final RegistryObject<Item> ELECTRIC_HORN = ITEMS.register("electric_horn", ElectricHorn::new);
    public static final RegistryObject<Item> MECHANICAL_HORN = ITEMS.register("mechanical_horn", MechanicalHorn::new);
//    public static final RegistryObject<Item> DUEL_WATER_GUN = ITEMS.register("duel_water_gun", DuelWaterGun::new);
//    public static final RegistryObject<Item> KULEBOH = ITEMS.register("kuleboh", Kuleboh::new);
//    public static final RegistryObject<Item> KULECIABOH = ITEMS.register("kuleciaboh", Kuleciaboh::new);
//    public static final RegistryObject<Item> TURBULENCE_AMBER = ITEMS.register("turbulence_amber", TurbulenceAmber::new);
//    public static final RegistryObject<Item> SPATIOTEMPORAL_DEVICE = ITEMS.register("spatiotemporal_device", SpatiotemporalDevice::new);
//    public static final RegistryObject<Item> LEVIY = ITEMS.register("leviy", Leviy::new);

    //satou
    public static final RegistryObject<Item> SATOU_KNIFE = ITEMS.register("satou_knife", SatouKnife::new);
    public static final RegistryObject<Item> SATOU_CAMERA = ITEMS.register("satou_camera", SatouCamera::new);
    public static final RegistryObject<Item> ANCIENT_LOLLIPOP = ITEMS.register("ancient_lollipop", AncientLollipop::new);
    public static final RegistryObject<Item> ISEKAI_LOLLIPOP = ITEMS.register("isekai_lollipop", IsekaiLollipop::new);
    public static final RegistryObject<Item> PAST_SUGAR = ITEMS.register("past_sugar", PastSugar::new);
    public static final RegistryObject<Item> SATOU_CHESTPLATE = ITEMS.register("satou_chestplate", SatouChestplate::new);

    //mumu
    public static final RegistryObject<Item> AYELET_MASK = ITEMS.register("ayelet_mask", AyeletMask::new);
    public static final RegistryObject<Item> MUMU_STEAK = ITEMS.register("mumu_steak", MumuSteak::new);

    /**
     * magicros
     **/
    //chiram
    public static final RegistryObject<Item> FLAT_VEGETABLE_CHESTPLATE = ITEMS.register("flat_vegetable_chestplate", FlatVegetableChestplate::new);
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", SteelPlate::new);
    public static final RegistryObject<Item> LOTUS_POTATO = ITEMS.register("lotus_potato", LotusPotato::new);
    //    public static final RegistryObject<Item> CHIRAM_LANTERN = ITEMS.register("chiram_lantern", ChiramLantern::new);
    public static final RegistryObject<Item> BOLSTER = ITEMS.register("bolster", Bolster::new);
    //    public static final RegistryObject<Item> EYE_MASK = ITEMS.register("eye_mask", EyeMask::new);
    public static final RegistryObject<Item> BREEZE_CROWN = ITEMS.register("breeze_crown", BreezeCrown::new);
    public static final RegistryObject<Item> CHIRAM_CORE = ITEMS.register("chiram_core", ChiramCore::new);
    public static final RegistryObject<Item> QINGLAN_UMBRELLA = ITEMS.register("qinglan_umbrella", QinglanUmbrella::new);
    public static final RegistryObject<Item> MAGIC_TEAPOT = ITEMS.register("magic_teapot", MagicTeapot::new);

    //haine
//    public static final RegistryObject<Item> HAI_PLATE = ITEMS.register("hai_plate", HaiPlate::new);
    public static final RegistryObject<Item> MARSHAIMALLOW = ITEMS.register("marshaimallow", Marshaimallow::new);
    public static final RegistryObject<Item> CLOUD_KEY = ITEMS.register("cloud_key", CloudKey::new);
    public static final RegistryObject<Item> CURSED_MARSHAIMALLOW = ITEMS.register("cursed_marshaimallow", CursedMarshaimallow::new);
    public static final RegistryObject<Item> MISTY_CHESTPLATE = ITEMS.register("misty_chestplate", MistyChestplate::new);
    public static final RegistryObject<Item> HAINE_CORE = ITEMS.register("haine_core", HaineCore::new);
    public static final RegistryObject<Item> HAIBARA_SOUP = ITEMS.register("haibara_soup", HaibaraSoup::new);

    //keroro
    public static final RegistryObject<Item> RED_NOSE = ITEMS.register("red_nose", RedNose::new);
    public static final RegistryObject<Item> FROG_LEG = ITEMS.register("frog_leg", FrogLeg::new);
    public static final RegistryObject<Item> FROG_CROWN = ITEMS.register("frog_crown", FrogCrown::new);
    public static final RegistryObject<Item> FROGGY_LEGGINGS = ITEMS.register("froggy_leggings", FroggyLeggings::new);
    public static final RegistryObject<Item> KERORO_CORE = ITEMS.register("keroro_core", KeroroCore::new);
    public static final RegistryObject<Item> LEMON_TEA = ITEMS.register("lemon_tea", LemonTea::new);
    public static final RegistryObject<Item> LARGE_LEMON_TEA = ITEMS.register("large_lemon_tea", LargeLemonTea::new);

    //ekira
//    public static final RegistryObject<Item> CRYSTAL_BALL = ITEMS.register("crystal_ball", CrystalBall::new);
//    public static final RegistryObject<Item> ENCHANTED_CRYSTAL_BALL = ITEMS.register("enchanted_crystal_ball", EnchantedCrystalBall::new);
//    public static final RegistryObject<Item> SUCCUBUS_TAIL = ITEMS.register("succubus_tail", SuccubusTail::new);
    public static final RegistryObject<Item> EKIRA_PEARL = ITEMS.register("ekira_pearl", EkiraPearl::new);
    //    public static final RegistryObject<Item> BUBBLE_TEA = ITEMS.register("bubble_tea", BubbleTea::new);
    public static final RegistryObject<Item> CELESTIAL_BOOTS = ITEMS.register("celestial_boots", CelestialBoots::new);
    public static final RegistryObject<Item> EKIRA_CORE = ITEMS.register("ekira_core", EkiraCore::new);

    /**
     * 3rd
     **/
    //hiru
//    public static final RegistryObject<Item> HIRU_HEAD = ITEMS.register("hiru_head", HiruHead::new);
//    public static final RegistryObject<Item> HIRU_TENTACLES = ITEMS.register("hiru_tentacles", HiruTentacles::new);
//    public static final RegistryObject<Item> HIRENADE_GG = ITEMS.register("hirenade_gg", HirenadeGG::new);
//    public static final RegistryObject<Item> SECONDARY_CATACLYSM = ITEMS.register("secondary_cataclysm", SecondaryCataclysm::new);
    public static final RegistryObject<Item> GN_SOUL = ITEMS.register("gn_souls", GNSouls::new);
    public static final RegistryObject<Item> GN_SPIRIT = ITEMS.register("gn_spirit", GNSpirit::new);
    public static final RegistryObject<Item> GN_STAR = ITEMS.register("gn_star", GNStar::new);

    //leciel
    public static final RegistryObject<Item> REINA_WINGS = ITEMS.register("reina_wings", ReinaWings::new);
    public static final RegistryObject<Item> REINA_FEATHER = ITEMS.register("reina_feather", ReinaFeather::new);
//    public static final RegistryObject<Item> LECIEL_EAR_COVERTS = ITEMS.register("leciel_ear_coverts", LecielEarCoverts::new);
//    public static final RegistryObject<Item> GIANT_DIAMOND_RING = ITEMS.register("giant_diamond_ring", GiantDiamondRing::new);

    //yuki
    public static final RegistryObject<Item> FOX_ICE_CREAM = ITEMS.register("fox_ice_cream", FoxIceCream::new);
    public static final RegistryObject<Item> FOX_PUDDING = ITEMS.register("fox_pudding", FoxPudding::new);

    /**
     * POI
     **/
    //shirako
    public static final RegistryObject<Item> MOMO_DAIFUKU = ITEMS.register("momo_daifuku", MomoDaifuku::new);
    public static final RegistryObject<Item> FETUOZI = ITEMS.register("fetuozi", Fetuozi::new);
    public static final RegistryObject<Item> DAIFUKU_SYRUP = ITEMS.register("daifuku_syrup", DaifukuSyrup::new);
    public static final RegistryObject<Item> MOMO_GUN = ITEMS.register("momo_gun", MomoGun::new);
    public static final RegistryObject<Item> MOMO_PHONE = ITEMS.register("momo_phone", MomoPhone::new);
    public static final RegistryObject<Item> MOMO_KNIFE = ITEMS.register("momo_knife", MomoKnife::new);
    public static final RegistryObject<Item> WORLD_PEACE_STAFF = ITEMS.register("world_peace_staff", WorldPeaceStaff::new);
    public static final RegistryObject<Item> MOMO_SYRINGE = ITEMS.register("momo_syringe", MomoSyringe::new);
    public static final RegistryObject<Item> MOMO_BANDAGE = ITEMS.register("momo_bandage", MomoBandage::new);
    public static final RegistryObject<Item> CHOCOLATE_BOOTS = ITEMS.register("chocolate_boots", ChocolateBoots::new);

    //sorayo
    public static final RegistryObject<Item> LUNATIC_BOW = ITEMS.register("lunatic_bow", LunaticBow::new);
    public static final RegistryObject<Item> MOON_CAKE = ITEMS.register("moon_cake", MoonCake::new);
//    public static final RegistryObject<Item> LUNAR_ECLIPSE = ITEMS.register("lunar_eclipse", LunarEclipse::new);

    //miya
    public static final RegistryObject<Item> TAIL_PEN = ITEMS.register("tail_pen", TailPen::new);
    public static final RegistryObject<Item> JELLYFISH_SHELL = ITEMS.register("jellyfish_shell", JellyfishShell::new);

    //ayu
//    public static final RegistryObject<Item> GRAVITY_RESTRAINT_DEVICE = ITEMS.register("gravity_restraint_device", GravityRestraintDevice::new);
//    public static final RegistryObject<Item> DELICATE_MIRAGE = ITEMS.register("delicate_mirage", DelicateMirage::new);

    //shirayuki
//    public static final RegistryObject<Item> FOX_FAIRY_FAN = ITEMS.register("fox_fairy_fan", FoxFairyFan::new);
    public static final RegistryObject<Item> BUTTERFLY_ANKLET = ITEMS.register("butterfly_anklet", ButterflyAnklet::new);

    //yuri
    public static final RegistryObject<Item> RABBIT_LYCHEE = ITEMS.register("rabbit_lychee", RabbitLychee::new);

    //fukami
    public static final RegistryObject<Item> FUKAMIZU_RING = ITEMS.register("fukamizu_ring", FukamizuRing::new);
    public static final RegistryObject<Item> ECHOED_DESTINY_RING = ITEMS.register("echoed_destiny_ring", EchoedDestinyRing::new);
    public static final RegistryObject<Item> OCEAN_DESTINY = ITEMS.register("ocean_destiny", OceanDestiny::new);
    public static final RegistryObject<Item> FRACTURE_DESTINY = ITEMS.register("fracture_destiny", FractureDestiny::new);
    public static final RegistryObject<Item> FUKAMIZU_FISH = ITEMS.register("fukamizu_fish", FukamizuFish::new);
    public static final RegistryObject<Item> FUKAMIZU_BREAD = ITEMS.register("fukamizu_bread", FukamizuBread::new);
    public static final RegistryObject<Item> GARLIC_MELON_SLICE = ITEMS.register("garlic_melon_slice", GarlicMelonSlice::new);

    //lutafia
    public static final RegistryObject<Item> FIAXE = ITEMS.register("fiaxe", Fiaxe::new);

    //yesa
    public static final RegistryObject<Item> MINT_CHOCOLATE = ITEMS.register("mint_chocolate", MintChocolate::new);
//    public static final RegistryObject<Item> YEGGY_PEARL = ITEMS.register("yeggy_pearl", YeggyPearl::new);
//    public static final RegistryObject<Item> TAIL_FISHING_ROD = ITEMS.register("tail_fishing_rod", TailFishingRod::new);

    //roky
    public static final RegistryObject<Item> XIAOLONGBAO = ITEMS.register("xiaolongbao", Xiaolongbao::new);

    //rino
//    public static final RegistryObject<Item> SHU_RINO_KEN = ITEMS.register("shu_rino_ken", ShuRinoKen::new);
    public static final RegistryObject<Item> CLARITY_AMULET = ITEMS.register("clarity_amulet", ClarityAmulet::new);

    //ccelia
    public static final RegistryObject<Item> CRAFT_BEER_0322 = ITEMS.register("craft_beer_0322", CraftBeer0322::new);

    /**
     * connections
     **/
    //qianyun
//    public static final RegistryObject<Item> QIANYUN_HOE = ITEMS.register("qianyun_hoe", QianyunHoe::new);
//    public static final RegistryObject<Item> SUITCASE = ITEMS.register("suitcase", Suitcase::new);
//    public static final RegistryObject<Item> QIANKELA = ITEMS.register("qiankela", Qiankela::new);

    /**
     * 4th
     **/
    //choco
    public static final RegistryObject<Item> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake", StrawberryCake::new);
    public static final RegistryObject<Item> CHOCOAL_COOKIE = ITEMS.register("chocoal_cookie", ChocoalCookie::new);

    //hifumi
    public static final RegistryObject<Item> NETHER_LIGHT = ITEMS.register("nether_light", NetherLight::new);
//    public static final RegistryObject<Item> UNFAITHFUL_HEART = ITEMS.register("unfaithful_heart", UnfaithfulHeart::new);

    //sana
//    public static final RegistryObject<Item> JELLYFISH_BOTTLE = ITEMS.register("jellyfish_bottle", JellyfishBottle::new);
    public static final RegistryObject<Item> SHAKANA = ITEMS.register("shakana", Shakana::new);

    /**
     * others
     **/
    public static final RegistryObject<Item> MMA_STEW = ITEMS.register("mma_stew", MMAStew::new);
    public static final RegistryObject<Item> MVA_STEW = ITEMS.register("mva_stew", MVAStew::new);
    public static final RegistryObject<Item> PDC_POINT = ITEMS.register("pdc_point", PdcPoint::new);
    public static final RegistryObject<Item> PREMIUM_PDC_POINT = ITEMS.register("premium_pdc_point", PremiumPdcPoint::new);
    public static final RegistryObject<Item> CHAOS_CHECKER = ITEMS.register("chaos_checker", ChaosChecker::new);
    public static final RegistryObject<Item> ESCORT_TOKEN = ITEMS.register("escort_token", EscortToken::new);

    /**
     * legacy
     **/
    public static final RegistryObject<Item> PLATE = ITEMS.register("plate", Plate::new);
    //    public static final RegistryObject<Item> FLUFF_BALL = ITEMS.register("fluff_ball", FluffBall::new);
    public static final RegistryObject<Item> YAGI_STAFF_CARD = ITEMS.register("yagi_staff_card", YagiStaffCard::new);
    public static final RegistryObject<Item> LAVA_CAKE = ITEMS.register("lava_cake", LavaCake::new);
//    public static final RegistryObject<Item> SHURA_CHIN = ITEMS.register("shura_chin", ShuraChin::new);
//    public static final RegistryObject<Item> UME = ITEMS.register("ume", Ume::new);

    /**
     * material
     */
    public static final RegistryObject<Item> IDOL_CLOTH = ITEMS.register("idol_cloth", IdolCloth::new);
    public static final RegistryObject<Item> MAGICROS_CORE = ITEMS.register("magicros_core", MagicrosCore::new);
    public static final RegistryObject<Item> DREAM_WEAVING_YARN = ITEMS.register("dream_weaving_yarn", DreamWeavingYarn::new);
    public static final RegistryObject<Item> DARK_CRYSTAL = ITEMS.register("dark_crystal", DarkCrystal::new);
    public static final RegistryObject<Item> RADIANT_CRYSTAL = ITEMS.register("radiant_crystal", RadiantCrystal::new);
    public static final RegistryObject<Item> ILLUSORY_CRYSTAL = ITEMS.register("illusory_crystal", IllusoryCrystal::new);
    public static final RegistryObject<Item> SINK_CRYSTAL = ITEMS.register("sink_crystal", SinkCrystal::new);
    public static final RegistryObject<Item> ALIENIS_CRYSTAL = ITEMS.register("alienis_crystal", AlienisCrystal::new);
    public static final RegistryObject<Item> TERMINAL_CRYSTAL = ITEMS.register("terminal_crystal", TerminalCrystal::new);


    /**
     * ===PROVIDENCRAFT AUDIO ITEMS===
     */
    public static final DeferredRegister<Item> AUDIO_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

//    public static final RegistryObject<Item> AUDIO_TAPE_HAINE_1 = AUDIO_ITEMS.register("audio_tape_haine_1", () -> new AudioTape(Livers.HAINE, SoundRegistry.HAINE_BROADCAST, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_HAINE_2 = AUDIO_ITEMS.register("audio_tape_haine_2", () -> new AudioTape(Livers.HAINE, SoundRegistry.HAINE_TAUNT, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_HAINE_3 = AUDIO_ITEMS.register("audio_tape_haine_3", () -> new AudioTape(Livers.HAINE, SoundRegistry.HAINE_HAIPLATE, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_CHIRAM_1 = AUDIO_ITEMS.register("audio_tape_chiram_1", () -> new AudioTape(Livers.CHIRAM, SoundRegistry.CHIRAM_INTRO, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_CHIRAM_2 = AUDIO_ITEMS.register("audio_tape_chiram_2", () -> new AudioTape(Livers.CHIRAM, SoundRegistry.CHIRAM_TALES, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_CHIRAM_3 = AUDIO_ITEMS.register("audio_tape_chiram_3", () -> new AudioTape(Livers.CHIRAM, SoundRegistry.CHIRAM_BOLSTER, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_EKIRA_1 = AUDIO_ITEMS.register("audio_tape_ekira_1", () -> new AudioTape(Livers.EKIRA, SoundRegistry.EKIRA_STAR, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_EKIRA_2 = AUDIO_ITEMS.register("audio_tape_ekira_2", () -> new AudioTape(Livers.EKIRA, SoundRegistry.EKIRA_TAUNT, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_EKIRA_3 = AUDIO_ITEMS.register("audio_tape_ekira_3", () -> new AudioTape(Livers.EKIRA, SoundRegistry.EKIRA_GOURMET, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_KERORO_1 = AUDIO_ITEMS.register("audio_tape_keroro_1", () -> new AudioTape(Livers.KERORO, SoundRegistry.KERORO_ELECTRIC_FROG, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_KERORO_2 = AUDIO_ITEMS.register("audio_tape_keroro_2", () -> new AudioTape(Livers.KERORO, SoundRegistry.KERORO_WALKING, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_KERORO_3 = AUDIO_ITEMS.register("audio_tape_keroro_3", () -> new AudioTape(Livers.KERORO, SoundRegistry.KERORO_FROG_CROWN, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_FUKAMIZU_1 = AUDIO_ITEMS.register("audio_tape_fukamizu_1", () -> new AudioTape(Livers.FUKAMI, SoundRegistry.FUKAMIZU_OCEAN_MONUMENT, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_FUKAMIZU_2 = AUDIO_ITEMS.register("audio_tape_fukamizu_2", () -> new AudioTape(Livers.FUKAMI, SoundRegistry.FUKAMIZU_DIAMOND, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_FUKAMIZU_3 = AUDIO_ITEMS.register("audio_tape_fukamizu_3", () -> new AudioTape(Livers.FUKAMI, SoundRegistry.FUKAMIZU_RING, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_FUKAMIZU_4 = AUDIO_ITEMS.register("audio_tape_fukamizu_4", () -> new AudioTape(Livers.FUKAMI, SoundRegistry.FUKAMIZU_CATS, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_FUKAMIZU_5 = AUDIO_ITEMS.register("audio_tape_fukamizu_5", () -> new AudioTape(Livers.FUKAMI, SoundRegistry.FUKAMIZU_MATH, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_FUKAMIZU_6 = AUDIO_ITEMS.register("audio_tape_fukamizu_6", () -> new AudioTape(Livers.FUKAMI, SoundRegistry.FUKAMIZU_SUN_BATH, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_LOUISE_1 = AUDIO_ITEMS.register("audio_tape_louise_1", () -> new AudioTape(Livers.LOUISE, SoundRegistry.LOUISE_SUMMON, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_LOUISE_2 = AUDIO_ITEMS.register("audio_tape_louise_2", () -> new AudioTape(Livers.LOUISE, SoundRegistry.LOUISE_FARMING, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_LOUISE_3 = AUDIO_ITEMS.register("audio_tape_louise_3", () -> new AudioTape(Livers.LOUISE, SoundRegistry.LOUISE_FOOD, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_MADOKA_1 = AUDIO_ITEMS.register("audio_tape_madoka_1", () -> new AudioTape(Livers.MADOKA, SoundRegistry.MADOKA_EXCHANGE_STUDENT, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_MADOKA_2 = AUDIO_ITEMS.register("audio_tape_madoka_2", () -> new AudioTape(Livers.MADOKA, SoundRegistry.MADOKA_RED_AHOGE, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_MADOKA_3 = AUDIO_ITEMS.register("audio_tape_madoka_3", () -> new AudioTape(Livers.MADOKA, SoundRegistry.MADOKA_PARTY, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_MUMU_1 = AUDIO_ITEMS.register("audio_tape_mumu_1", () -> new AudioTape(Livers.MUMU, SoundRegistry.MUMU_AYELET, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_MUMU_2 = AUDIO_ITEMS.register("audio_tape_mumu_2", () -> new AudioTape(Livers.MUMU, SoundRegistry.MUMU_TRAVEL, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_MUMU_3 = AUDIO_ITEMS.register("audio_tape_mumu_3", () -> new AudioTape(Livers.MUMU, SoundRegistry.MUMU_BEEF, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1)));
//    public static final RegistryObject<Item> AUDIO_TAPE_QIANYUN_1 = AUDIO_ITEMS.register("audio_tape_qianyun_1", () -> new AudioTape(Livers.QIANYUN, SoundRegistry.QIANYUN_INTRO, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_QIANYUN_2 = AUDIO_ITEMS.register("audio_tape_qianyun_2", () -> new AudioTape(Livers.QIANYUN, SoundRegistry.QIANYUN_EXPLORE, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_QIANYUN_3 = AUDIO_ITEMS.register("audio_tape_qianyun_3", () -> new AudioTape(Livers.QIANYUN, SoundRegistry.QIANYUN_PROTECTION, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_UNIA_1 = AUDIO_ITEMS.register("audio_tape_unia_1", () -> new AudioTape(Livers.UNIA, SoundRegistry.UNIA_LEGION, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_UNIA_2 = AUDIO_ITEMS.register("audio_tape_unia_2", () -> new AudioTape(Livers.UNIA, SoundRegistry.UNIA_EXPLORE, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_UNIA_3 = AUDIO_ITEMS.register("audio_tape_unia_3", () -> new AudioTape(Livers.UNIA, SoundRegistry.UNIA_UNIGIRI, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_USA_1 = AUDIO_ITEMS.register("audio_tape_usa_1", () -> new AudioTape(Livers.USA, SoundRegistry.USA_DUODUO_ANGEL, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_USA_2 = AUDIO_ITEMS.register("audio_tape_usa_2", () -> new AudioTape(Livers.USA, SoundRegistry.USA_BOOMERANG, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
//    public static final RegistryObject<Item> AUDIO_TAPE_USA_3 = AUDIO_ITEMS.register("audio_tape_usa_3", () -> new AudioTape(Livers.USA, SoundRegistry.USA_GUNDAM, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));

    public static final RegistryObject<Item> MUSIC_DISC_DARAKUDATENSHI = AUDIO_ITEMS.register("music_disc_darakudatenshi", () -> new MusicDisc(Livers.USA, SoundRegistry.DARAKUDATENSHI, (new Item.Properties()).stacksTo(1).rarity(Rarity.RARE), 1, 4100));
    public static final RegistryObject<Item> MUSIC_DISC_AROUND_THE_TRAVEL = AUDIO_ITEMS.register("music_disc_around_the_travel", () -> new MusicDisc(Livers.SHIRAKO, SoundRegistry.AROUND_THE_TRAVEL, (new Item.Properties()).stacksTo(1).rarity(Rarity.EPIC), 2, 4420));
    public static final RegistryObject<Item> MUSIC_DISC_SONG_OF_QINGQIU = AUDIO_ITEMS.register("music_disc_song_of_qingqiu", () -> new MusicDisc(Livers.AOI, SoundRegistry.SONG_OF_QINGQIU, (new Item.Properties()).stacksTo(1).rarity(Rarity.RARE), 3, 4260));
//    public static final RegistryObject<Item> MUSIC_DISC_DREAMING_FAIRY = AUDIO_ITEMS.register("music_disc_dreaming_fairy", () -> new MusicDisc(Livers.UNIA, SoundRegistry.DREAMING_FAIRY, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1).rarity(Rarity.RARE), 4));

    /**
     * ===PROVIDENCRAFT DONATE ITEMS===
     */
    public static final DeferredRegister<Item> DONATE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

//    public static final RegistryObject<Item> DONATE_ITEM_EXAMPLE = DONATE_ITEMS.register("donate_item_example", DonateItemExample::new);
    public static final RegistryObject<Item> ATSUISHIO = DONATE_ITEMS.register("atsuishio", AtsuiShio::new);
    public static final RegistryObject<Item> EMPTY_JAR = DONATE_ITEMS.register("empty_jar", EmptyJar::new);
//    public static final RegistryObject<Item> LITTLE_POTATO = DONATE_ITEMS.register("little_potato", LittlePotato::new);
//    public static final RegistryObject<Item> LOLLIPOP = DONATE_ITEMS.register("lollipop", Lollipop::new);
//    public static final RegistryObject<Item> ORANGE_TRACKER = DONATE_ITEMS.register("orange_tracker", OrangeTracker::new);
//    public static final RegistryObject<Item> BLACK_EARPHONES = DONATE_ITEMS.register("black_earphones", BlackEarphones::new);
//    public static final RegistryObject<Item> EMERGENCY_ENGINE_POWER = DONATE_ITEMS.register("emergency_engine_power", EmergencyEnginePower::new);
//    public static final RegistryObject<Item> MUSIC_DISC_SONG_OF_AUTUMN = DONATE_ITEMS.register("music_disc_song_of_autumn", MusicDiscSongOfAutumn::new);

    /**
     * ===PROVIDENCRAFT COSTUMES===
     */
    public static final DeferredRegister<Item> COSTUMES = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> CHIRAM_IDOL_HELMET = COSTUMES.register("chiram_idol_helmet", ChiramIdolHelmet::new);
    public static final RegistryObject<Item> CHIRAM_IDOL_CHESTPLATE = COSTUMES.register("chiram_idol_chestplate", ChiramIdolChestplate::new);
    public static final RegistryObject<Item> CHIRAM_IDOL_BOOTS = COSTUMES.register("chiram_idol_boots", ChiramIdolBoots::new);
    public static final RegistryObject<Item> HAINE_IDOL_HELMET = COSTUMES.register("haine_idol_helmet", HaineIdolHelmet::new);
    public static final RegistryObject<Item> HAINE_IDOL_CHESTPLATE = COSTUMES.register("haine_idol_chestplate", HaineIdolChestplate::new);
    public static final RegistryObject<Item> HAINE_IDOL_BOOTS = COSTUMES.register("haine_idol_boots", HaineIdolBoots::new);
    public static final RegistryObject<Item> KERORO_IDOL_HELMET = COSTUMES.register("keroro_idol_helmet", KeroroIdolHelmet::new);
    public static final RegistryObject<Item> KERORO_IDOL_CHESTPLATE = COSTUMES.register("keroro_idol_chestplate", KeroroIdolChestplate::new);
    public static final RegistryObject<Item> KERORO_IDOL_BOOTS = COSTUMES.register("keroro_idol_boots", KeroroIdolBoots::new);
    public static final RegistryObject<Item> EKIRA_IDOL_HELMET = COSTUMES.register("ekira_idol_helmet", EkiraIdolHelmet::new);
    public static final RegistryObject<Item> EKIRA_IDOL_CHESTPLATE = COSTUMES.register("ekira_idol_chestplate", EkiraIdolChestplate::new);
    public static final RegistryObject<Item> EKIRA_IDOL_BOOTS = COSTUMES.register("ekira_idol_boots", EkiraIdolBoots::new);
//    public static final RegistryObject<Item> KRM_963_53 = COSTUMES.register("krm_963_53", KRM_963_53::new);
//    public static final RegistryObject<Item> MAID_COSTUME = COSTUMES.register("maid_costume", MaidCostume::new);

    /**
     * ===PROVIDENCRAFT BLOCKS===
     */
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> RED_AHOGE_BLOCK = BLOCK_ITEMS.register("red_ahoge_block",
            () -> new BlockItem(BlockRegistry.RED_AHOGE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> WHITE_AHOGE_BLOCK = BLOCK_ITEMS.register("white_ahoge_block",
            () -> new BlockItem(BlockRegistry.WHITE_AHOGE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> COMMUNICATION_TABLE = BLOCK_ITEMS.register("communication_table",
            () -> new BlockItem(BlockRegistry.COMMUNICATION_TABLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PORCELAIN_THRONE = BLOCK_ITEMS.register("porcelain_throne", PorcelainThroneBlockItem::new);
    public static final RegistryObject<Item> POINTS_STORE = BLOCK_ITEMS.register("points_store",
            () -> new BlockItem(BlockRegistry.POINTS_STORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> FUKAMIZU_BREAD_BLOCK = BLOCK_ITEMS.register("fukamizu_bread_block",
            () -> new BlockItem(BlockRegistry.FUKAMIZU_BREAD_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> BLUE_SAND = BLOCK_ITEMS.register("blue_sand",
            () -> new BlockItem(BlockRegistry.BLUE_SAND.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SANDSTONE = BLOCK_ITEMS.register("blue_sandstone",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CUT_BLUE_SANDSTONE = BLOCK_ITEMS.register("cut_blue_sandstone",
            () -> new BlockItem(BlockRegistry.CUT_BLUE_SANDSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHISELED_BLUE_SANDSTONE = BLOCK_ITEMS.register("chiseled_blue_sandstone",
            () -> new BlockItem(BlockRegistry.CHISELED_BLUE_SANDSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SANDSTONE_SLAB = BLOCK_ITEMS.register("blue_sandstone_slab",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> CUT_BLUE_SANDSTONE_SLAB = BLOCK_ITEMS.register("cut_blue_sandstone_slab",
            () -> new BlockItem(BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SANDSTONE_STAIRS = BLOCK_ITEMS.register("blue_sandstone_stairs",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SANDSTONE_WALL = BLOCK_ITEMS.register("blue_sandstone_wall",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMOOTH_BLUE_SANDSTONE = BLOCK_ITEMS.register("smooth_blue_sandstone",
            () -> new BlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMOOTH_BLUE_SANDSTONE_SLAB = BLOCK_ITEMS.register("smooth_blue_sandstone_slab",
            () -> new BlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMOOTH_BLUE_SANDSTONE_STAIRS = BLOCK_ITEMS.register("smooth_blue_sandstone_stairs",
            () -> new BlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(), new Item.Properties()));

    public static final RegistryObject<Item> HARANO_LOG = BLOCK_ITEMS.register("harano_log",
            () -> new BlockItem(BlockRegistry.HARANO_LOG.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_PLANKS = BLOCK_ITEMS.register("harano_planks",
//            () -> new BlockItem(BlockRegistry.HARANO_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> HARANO_LEAVES = BLOCK_ITEMS.register("harano_leaves",
            () -> new BlockItem(BlockRegistry.HARANO_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> HARANO_SAPLING = BLOCK_ITEMS.register("harano_sapling",
            () -> new BlockItem(BlockRegistry.HARANO_SAPLING.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_WOOD = BLOCK_ITEMS.register("harano_wood",
//            () -> new BlockItem(BlockRegistry.HARANO_WOOD.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_STAIRS = BLOCK_ITEMS.register("harano_stairs",
//            () -> new BlockItem(BlockRegistry.HARANO_STAIRS.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_SLAB = BLOCK_ITEMS.register("harano_slab",
//            () -> new BlockItem(BlockRegistry.HARANO_SLAB.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_FENCE = BLOCK_ITEMS.register("harano_fence",
//            () -> new BlockItem(BlockRegistry.HARANO_FENCE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_FENCE_GATE = BLOCK_ITEMS.register("harano_fence_gate",
//            () -> new BlockItem(BlockRegistry.HARANO_FENCE_GATE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_PRESSURE_PLATE = BLOCK_ITEMS.register("harano_pressure_plate",
//            () -> new BlockItem(BlockRegistry.HARANO_PRESSURE_PLATE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> STRIPPED_HARANO_LOG = BLOCK_ITEMS.register("stripped_harano_log",
//            () -> new BlockItem(BlockRegistry.STRIPPED_HARANO_LOG.get(), new Item.Properties()));
//    public static final RegistryObject<Item> STRIPPED_HARANO_WOOD = BLOCK_ITEMS.register("stripped_harano_wood",
//            () -> new BlockItem(BlockRegistry.STRIPPED_HARANO_WOOD.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_DOOR = BLOCK_ITEMS.register("harano_door",
//            () -> new BlockItem(BlockRegistry.HARANO_DOOR.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_TRAPDOOR = BLOCK_ITEMS.register("harano_trapdoor",
//            () -> new BlockItem(BlockRegistry.HARANO_TRAPDOOR.get(), new Item.Properties()));
//    public static final RegistryObject<Item> HARANO_BUTTON = BLOCK_ITEMS.register("harano_button",
//            () -> new BlockItem(BlockRegistry.HARANO_BUTTON.get(), new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        AUDIO_ITEMS.register(bus);
        DONATE_ITEMS.register(bus);
        COSTUMES.register(bus);
        BLOCK_ITEMS.register(bus);
    }
}
