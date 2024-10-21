package tech.lq0.dreamaticvoyage.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Utils.MOD_ID);

    public static final RegistryObject<SoundEvent> MYANNA = SOUNDS.register("myanna", () -> SoundEvent.createVariableRangeEvent(Utils.loc("myanna")));
    public static final RegistryObject<SoundEvent> HAIPLATE = SOUNDS.register("haiplate", () -> SoundEvent.createVariableRangeEvent(Utils.loc("haiplate")));
    public static final RegistryObject<SoundEvent> KERORO_SNEEZE = SOUNDS.register("keroro_sneeze", () -> SoundEvent.createVariableRangeEvent(Utils.loc("keroro_sneeze")));
    public static final RegistryObject<SoundEvent> BLADE = SOUNDS.register("blade", () -> SoundEvent.createVariableRangeEvent(Utils.loc("blade")));
    public static final RegistryObject<SoundEvent> HOW_HOLD_BLOOD = SOUNDS.register("how_hold_blood", () -> SoundEvent.createVariableRangeEvent(Utils.loc("how_hold_blood")));
    public static final RegistryObject<SoundEvent> WHY_NOT_DIE = SOUNDS.register("why_not_die", () -> SoundEvent.createVariableRangeEvent(Utils.loc("why_not_die")));
    public static final RegistryObject<SoundEvent> SORRY = SOUNDS.register("sorry", () -> SoundEvent.createVariableRangeEvent(Utils.loc("sorry")));
    public static final RegistryObject<SoundEvent> BABY_MEOW = SOUNDS.register("baby_meow", () -> SoundEvent.createVariableRangeEvent(Utils.loc("baby_meow")));
    public static final RegistryObject<SoundEvent> SHUTTER = SOUNDS.register("shutter", () -> SoundEvent.createVariableRangeEvent(Utils.loc("shutter")));
    public static final RegistryObject<SoundEvent> LECIA_HOWL = SOUNDS.register("lecia_howl", () -> SoundEvent.createVariableRangeEvent(Utils.loc("lecia_howl")));
    public static final RegistryObject<SoundEvent> LECIA_SCREAM = SOUNDS.register("lecia_scream", () -> SoundEvent.createVariableRangeEvent(Utils.loc("lecia_scream")));
    public static final RegistryObject<SoundEvent> LECIA_CAST = SOUNDS.register("lecia_cast", () -> SoundEvent.createVariableRangeEvent(Utils.loc("lecia_cast")));
    public static final RegistryObject<SoundEvent> BLOOD_CRYSTAL = SOUNDS.register("blood_crystal", () -> SoundEvent.createVariableRangeEvent(Utils.loc("blood_crystal")));
    public static final RegistryObject<SoundEvent> HIRU_SCREAM = SOUNDS.register("hiru_scream", () -> SoundEvent.createVariableRangeEvent(Utils.loc("hiru_scream")));
    public static final RegistryObject<SoundEvent> GRENADE_SHOOT = SOUNDS.register("grenade_shoot", () -> SoundEvent.createVariableRangeEvent(Utils.loc("grenade_shoot")));
    public static final RegistryObject<SoundEvent> LEVIY_BEAM = SOUNDS.register("leviy_beam", () -> SoundEvent.createVariableRangeEvent(Utils.loc("leviy_beam")));
    public static final RegistryObject<SoundEvent> LEVIY_FAIL = SOUNDS.register("leviy_fail", () -> SoundEvent.createVariableRangeEvent(Utils.loc("leviy_fail")));

    // audios
    public static final RegistryObject<SoundEvent> CHIRAM_BOLSTER = SOUNDS.register("chiram_bolster", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/chiram_bolster")));
    public static final RegistryObject<SoundEvent> CHIRAM_INTRO = SOUNDS.register("chiram_intro", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/chiram_intro")));
    public static final RegistryObject<SoundEvent> CHIRAM_TALES = SOUNDS.register("chiram_tales", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/chiram_tales")));
    public static final RegistryObject<SoundEvent> HAINE_BROADCAST = SOUNDS.register("haine_broadcast", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/haine_broadcast")));
    public static final RegistryObject<SoundEvent> HAINE_TAUNT = SOUNDS.register("haine_taunt", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/haine_taunt")));
    public static final RegistryObject<SoundEvent> HAINE_HAIPLATE = SOUNDS.register("haine_haiplate", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/haine_haiplate")));
    public static final RegistryObject<SoundEvent> EKIRA_STAR = SOUNDS.register("ekira_star", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/ekira_star")));
    public static final RegistryObject<SoundEvent> EKIRA_TAUNT = SOUNDS.register("ekira_taunt", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/ekira_taunt")));
    public static final RegistryObject<SoundEvent> EKIRA_GOURMET = SOUNDS.register("ekira_gourmet", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/ekira_gourmet")));
    public static final RegistryObject<SoundEvent> KERORO_ELECTRIC_FROG = SOUNDS.register("keroro_electric_frog", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/keroro_electric_frog")));
    public static final RegistryObject<SoundEvent> KERORO_FROG_CROWN = SOUNDS.register("keroro_frog_crown", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/keroro_frog_crown")));
    public static final RegistryObject<SoundEvent> KERORO_WALKING = SOUNDS.register("keroro_walking", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/magicros/keroro_walking")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_OCEAN_MONUMENT = SOUNDS.register("fukamizu_ocean_monument", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/poi/fukamizu_ocean_monument")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_DIAMOND = SOUNDS.register("fukamizu_diamond", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/poi/fukamizu_diamond")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_RING = SOUNDS.register("fukamizu_ring", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/poi/fukamizu_ring")));
    public static final RegistryObject<SoundEvent> LOUISE_SUMMON = SOUNDS.register("louise_summon", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/second/louise_summon")));
    public static final RegistryObject<SoundEvent> LOUISE_FARMING = SOUNDS.register("louise_farming", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/second/louise_farming")));
    public static final RegistryObject<SoundEvent> LOUISE_FOOD = SOUNDS.register("louise_food", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/second/louise_food")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_CATS = SOUNDS.register("fukamizu_cats", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/poi/fukamizu_cats")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_MATH = SOUNDS.register("fukamizu_math", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/poi/fukamizu_math")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_SUN_BATH = SOUNDS.register("fukamizu_sun_bath", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/poi/fukamizu_sun_bath")));
    public static final RegistryObject<SoundEvent> MADOKA_EXCHANGE_STUDENT = SOUNDS.register("madoka_exchange_student", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/madoka_exchange_student")));
    public static final RegistryObject<SoundEvent> MADOKA_RED_AHOGE = SOUNDS.register("madoka_red_ahoge", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/madoka_red_ahoge")));
    public static final RegistryObject<SoundEvent> MADOKA_PARTY = SOUNDS.register("madoka_party", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/madoka_party")));
    public static final RegistryObject<SoundEvent> MUMU_AYELET = SOUNDS.register("mumu_ayelet", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/second/mumu_ayelet")));
    public static final RegistryObject<SoundEvent> MUMU_TRAVEL = SOUNDS.register("mumu_travel", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/second/mumu_travel")));
    public static final RegistryObject<SoundEvent> MUMU_BEEF = SOUNDS.register("mumu_beef", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/second/mumu_beef")));
    public static final RegistryObject<SoundEvent> QIANYUN_INTRO = SOUNDS.register("qianyun_intro", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/cnt/qianyun_intro")));
    public static final RegistryObject<SoundEvent> QIANYUN_EXPLORE = SOUNDS.register("qianyun_explore", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/cnt/qianyun_explore")));
    public static final RegistryObject<SoundEvent> QIANYUN_PROTECTION = SOUNDS.register("qianyun_protection", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/cnt/qianyun_protection")));
    public static final RegistryObject<SoundEvent> UNIA_LEGION = SOUNDS.register("unia_legion", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/unia_legion")));
    public static final RegistryObject<SoundEvent> UNIA_EXPLORE = SOUNDS.register("unia_explore", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/unia_explore")));
    public static final RegistryObject<SoundEvent> UNIA_UNIGIRI = SOUNDS.register("unia_unigiri", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/unia_unigiri")));
    public static final RegistryObject<SoundEvent> USA_DUODUO_ANGEL = SOUNDS.register("usa_duoduo_angel", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/usa_duoduo_angel")));
    public static final RegistryObject<SoundEvent> USA_BOOMERANG = SOUNDS.register("usa_boomerang", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/usa_boomerang")));
    public static final RegistryObject<SoundEvent> USA_GUNDAM = SOUNDS.register("usa_gundam", () -> SoundEvent.createVariableRangeEvent(Utils.loc("audio/first/usa_gundam")));

    // songs
    public static final RegistryObject<SoundEvent> AROUND_THE_TRAVEL = SOUNDS.register("around_the_travel", () -> SoundEvent.createVariableRangeEvent(Utils.loc("song/around_the_travel")));
    public static final RegistryObject<SoundEvent> SONG_OF_AUTUMN = SOUNDS.register("song_of_autumn", () -> SoundEvent.createVariableRangeEvent(Utils.loc("song/song_of_autumn")));
    public static final RegistryObject<SoundEvent> SONG_OF_QINGQIU = SOUNDS.register("song_of_qingqiu", () -> SoundEvent.createVariableRangeEvent(Utils.loc("song/song_of_qingqiu")));
    public static final RegistryObject<SoundEvent> DREAMING_FAIRY = SOUNDS.register("dreaming_fairy", () -> SoundEvent.createVariableRangeEvent(Utils.loc("song/dreaming_fairy")));
}
