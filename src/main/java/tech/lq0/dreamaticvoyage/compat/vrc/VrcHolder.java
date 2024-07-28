package tech.lq0.dreamaticvoyage.compat.vrc;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.ObjectHolder;

public class VrcHolder {

    public static final String VRC = "virtuarealcraft";

    @ObjectHolder(registryName = "minecraft:mob_effect", value = VRC + ":business_obstruction")
    public static final MobEffect BUSINESS_OBSTRUCTION = null;
}
