package tech.lq0.dreamaticvoyage.block.fukamizutech;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FukamizuMachineCasing extends Block {
    public FukamizuMachineCasing() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
    }
}
