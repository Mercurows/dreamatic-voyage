package tech.lq0.dreamaticvoyage.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

public class UniMilletBlock extends CropBlock {
    public UniMilletBlock(){
        super(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission());
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemRegistry.UNI_MILLET.get();
    }
}
