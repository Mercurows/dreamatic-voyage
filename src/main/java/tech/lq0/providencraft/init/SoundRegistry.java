package tech.lq0.providencraft.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Utils.MOD_ID);

    public static final RegistryObject<SoundEvent> BLOOD_CRYSTAL = SOUNDS.register("blood_crystal", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "blood_crystal")));

    public static final RegistryObject<SoundEvent> AROUND_THE_TRAVEL = SOUNDS.register("around_the_travel", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Utils.MOD_ID, "song/around_the_travel")));
}
