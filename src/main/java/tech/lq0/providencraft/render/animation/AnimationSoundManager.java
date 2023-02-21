package tech.lq0.providencraft.render.animation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.EntityTickableSound;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//Forked from TaC
@OnlyIn(Dist.CLIENT)
public enum AnimationSoundManager {
    INSTANCE;
    private final Map<UUID, Map<ResourceLocation, ISound>> soundsMap = new HashMap<>();

    public void playerSound(PlayerEntity player, AnimationMeta animationMeta, AnimationSoundMeta soundMeta){
        Map<ResourceLocation, ISound> map = soundsMap.computeIfAbsent(player.getUniqueID(), k -> new HashMap<>());
        ISound sound = map.get(animationMeta.getResourceLocation());
        if(sound == null) {
            SoundEvent soundEvent = new SoundEvent(soundMeta.getResourceLocation());
            sound = new EntityTickableSound(soundEvent, SoundCategory.PLAYERS, player);
        }
        if(sound instanceof EntityTickableSound){
            EntityTickableSound entityTickableSound = (EntityTickableSound) sound;
            if(entityTickableSound.isDonePlaying()){
                SoundEvent soundEvent = new SoundEvent(soundMeta.getResourceLocation());
                sound = new EntityTickableSound(soundEvent, SoundCategory.PLAYERS, player);
            }
        }
        if(Minecraft.getInstance().getSoundHandler().isPlaying(sound)) return;
        Minecraft.getInstance().getSoundHandler().play(sound);
        map.put(animationMeta.getResourceLocation(), sound);
    }

    public void onPlayerDeath(PlayerEntity player){
        Map<ResourceLocation, ISound> map = soundsMap.computeIfAbsent(player.getUniqueID(), k -> new HashMap<>());
        for(ISound sound : map.values()){
            Minecraft.getInstance().getSoundHandler().stop(sound);
        }
        soundsMap.remove(player.getUniqueID());
    }

    public void interruptSound(PlayerEntity player, AnimationMeta animationMeta){
        Map<ResourceLocation, ISound> map = soundsMap.get(player.getUniqueID());
        if(map != null){
            ISound sound = map.get(animationMeta.getResourceLocation());
            if(sound != null){
                Minecraft.getInstance().getSoundHandler().stop(sound);
            }
            map.remove(animationMeta.getResourceLocation());
        }
    }
}