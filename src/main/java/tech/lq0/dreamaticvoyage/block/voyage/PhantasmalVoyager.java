package tech.lq0.dreamaticvoyage.block.voyage;

import net.minecraft.world.level.block.Block;

public class PhantasmalVoyager extends Block {
    public PhantasmalVoyager() {
        super(Properties.of().lightLevel(light -> 15).requiresCorrectToolForDrops().strength(5.0f));
    }


}
