package tech.lq0.providencraft.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Utils.MOD_ID);

    public static final RegistryObject<SoundEvent> MYANNA = SOUNDS.register("myanna", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "myanna")));
    public static final RegistryObject<SoundEvent> HAIPLATE = SOUNDS.register("haiplate", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "haiplate")));
    public static final RegistryObject<SoundEvent> KERORO_SNEEZE = SOUNDS.register("keroro_sneeze", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "keroro_sneeze")));
    public static final RegistryObject<SoundEvent> BLADE = SOUNDS.register("blade", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "blade")));
//    public static final RegistryObject<SoundEvent> HOW_HOLD_BLOOD = SOUNDS.register("how_hold_blood", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "how_hold_blood")));
//    public static final RegistryObject<SoundEvent> WHY_NOT_DIE = SOUNDS.register("why_not_die", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "why_not_die")));
//    public static final RegistryObject<SoundEvent> SORRY = SOUNDS.register("sorry", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "sorry")));
    public static final RegistryObject<SoundEvent> BABY_MEOW = SOUNDS.register("baby_meow", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "baby_meow")));
    public static final RegistryObject<SoundEvent> SHUTTER = SOUNDS.register("shutter", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "shutter")));
    //    public static final RegistryObject<SoundEvent> LECIA_HOWL = SOUNDS.register("lecia_howl", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "lecia_howl")));
//    public static final RegistryObject<SoundEvent> LECIA_SCREAM = SOUNDS.register("lecia_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "lecia_scream")));
//    public static final RegistryObject<SoundEvent> LECIA_CAST_1 = SOUNDS.register("lecia_cast_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "lecia_cast_1")));
//    public static final RegistryObject<SoundEvent> LECIA_CAST_2 = SOUNDS.register("lecia_cast_2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "lecia_cast_2")));
    public static final RegistryObject<SoundEvent> BLOOD_CRYSTAL = SOUNDS.register("blood_crystal", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "blood_crystal")));
//    public static final RegistryObject<SoundEvent> HIRU_SCREAM = SOUNDS.register("hiru_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "hiru_scream")));
//    public static final RegistryObject<SoundEvent> GRENADE_SHOOT = SOUNDS.register("grenade_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "grenade_shoot")));
//    public static final RegistryObject<SoundEvent> LEVIY_BEAM = SOUNDS.register("leviy_beam", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "leviy_beam")));
//    public static final RegistryObject<SoundEvent> LEVIY_FAIL = SOUNDS.register("leviy_fail", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "leviy_fail")));

    //songs
    public static final RegistryObject<SoundEvent> DARAKUDATENSHI = SOUNDS.register("darakudatenshi", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "song/darakudatenshi")));
    public static final RegistryObject<SoundEvent> AROUND_THE_TRAVEL = SOUNDS.register("around_the_travel", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "song/around_the_travel")));
    public static final RegistryObject<SoundEvent> SONG_OF_AUTUMN = SOUNDS.register("song_of_autumn", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "song/song_of_autumn")));
    public static final RegistryObject<SoundEvent> SONG_OF_QINGQIU = SOUNDS.register("song_of_qingqiu", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "song/song_of_qingqiu")));
//    public static final RegistryObject<SoundEvent> DREAMING_FAIRY = SOUNDS.register("dreaming_fairy", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "song/dreaming_fairy")));
}
