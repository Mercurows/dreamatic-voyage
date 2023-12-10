package tech.lq0.providencraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.BlockRegistry;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Utils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.RED_AHOGE_BLOCK.get(), BlockRegistry.WHITE_AHOGE_BLOCK.get(),
                        BlockRegistry.COMMUNICATION_TABLE.get(), BlockRegistry.PORCELAIN_THRONE.get(),
                        BlockRegistry.POINTS_STORE.get(), BlockRegistry.FUKAMIZU_BREAD_BLOCK.get(),
                        BlockRegistry.BLUE_SANDSTONE.get(), BlockRegistry.BLUE_SANDSTONE_SLAB.get(),
                        BlockRegistry.CUT_BLUE_SANDSTONE.get(), BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get(),
                        BlockRegistry.SMOOTH_BLUE_SANDSTONE.get(), BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(),
                        BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(), BlockRegistry.BLUE_SANDSTONE_STAIRS.get(),
                        BlockRegistry.BLUE_SANDSTONE_WALL.get(), BlockRegistry.CHISELED_BLUE_SANDSTONE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BlockRegistry.BLUE_SAND.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(BlockRegistry.UNI_MILLET_BLOCK.get(), BlockRegistry.HARANO_LOG.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(BlockRegistry.HARANO_LEAVES.get(), BlockRegistry.UNI_MILLET_BLOCK.get());

        this.tag(BlockTags.BEE_GROWABLES).add(BlockRegistry.UNI_MILLET_BLOCK.get());

        this.tag(BlockTags.CROPS).add(BlockRegistry.UNI_MILLET_BLOCK.get());

        this.tag(BlockTags.SAND).add(BlockRegistry.BLUE_SAND.get());

        this.tag(Tags.Blocks.SANDSTONE)
                .add(BlockRegistry.BLUE_SANDSTONE.get(), BlockRegistry.CUT_BLUE_SANDSTONE.get(),
                        BlockRegistry.SMOOTH_BLUE_SANDSTONE.get(), BlockRegistry.CHISELED_BLUE_SANDSTONE.get());

        this.tag(BlockTags.LOGS)
                .add(BlockRegistry.HARANO_LOG.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(BlockRegistry.HARANO_LOG.get());

        this.tag(BlockTags.WALLS).add(BlockRegistry.BLUE_SANDSTONE_WALL.get());

        this.tag(BlockTags.SWORD_EFFICIENT).add(BlockRegistry.UNI_MILLET_BLOCK.get());

        this.tag(BlockTags.SLABS)
                .add(BlockRegistry.BLUE_SANDSTONE_SLAB.get(), BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(),
                        BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get());

        this.tag(BlockTags.SMELTS_TO_GLASS).add(BlockRegistry.BLUE_SAND.get());

        this.tag(BlockTags.STAIRS)
                .add(BlockRegistry.BLUE_SANDSTONE_STAIRS.get(), BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get());
    }
}
