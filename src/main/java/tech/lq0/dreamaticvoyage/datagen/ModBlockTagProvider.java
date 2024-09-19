package tech.lq0.dreamaticvoyage.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;
import tech.lq0.dreamaticvoyage.tools.ModTags;

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
                        BlockRegistry.BLUE_SANDSTONE_WALL.get(), BlockRegistry.CHISELED_BLUE_SANDSTONE.get(),
                        BlockRegistry.HARDEN_CRYSTAL_BLOCK.get(), BlockRegistry.PURIFIED_CRYSTAL_BLOCK.get(),
                        BlockRegistry.CHARGED_CRYSTAL_BLOCK.get(), BlockRegistry.FICTIONAL_INGOT_BLOCK.get(),
                        BlockRegistry.ROCK_STATUE.get(), BlockRegistry.PHANTASMAL_VOYAGER.get(),
                        BlockRegistry.FUKAMIZU_BREAD_BRICKS.get(), BlockRegistry.FUKAMIZU_MACHINE_CASING.get(),
                        BlockRegistry.FUKAMIZU_COMPRESSOR.get(), BlockRegistry.CRYSTAL_POPPER.get(),
                        BlockRegistry.FUKAMIZU_CRUSHER.get(), BlockRegistry.GACHI_INGOT_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BlockRegistry.BLUE_SAND.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(BlockRegistry.UNI_MILLET_BLOCK.get(), BlockRegistry.HARANO_LOG.get(),
                BlockRegistry.HARANO_WOOD.get(), BlockRegistry.HARANO_SLAB.get(), BlockRegistry.HARANO_PLANKS.get(),
                BlockRegistry.HARANO_STAIRS.get(), BlockRegistry.STRIPPED_HARANO_LOG.get(), BlockRegistry.STRIPPED_HARANO_WOOD.get(),
                BlockRegistry.HARANO_FENCE.get(), BlockRegistry.HARANO_FENCE_GATE.get(), BlockRegistry.HARANO_PRESSURE_PLATE.get(),
                BlockRegistry.HARANO_DOOR.get(), BlockRegistry.HARANO_TRAPDOOR.get(), BlockRegistry.HARANO_BUTTON.get(),
                BlockRegistry.FUKAMIZU_PLUM_PLANKS.get(), BlockRegistry.FUKAMIZU_PLUM_LOG.get(), BlockRegistry.STRIPPED_FUKAMIZU_PLUM_LOG.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(BlockRegistry.HARANO_LEAVES.get(), BlockRegistry.UNI_MILLET_BLOCK.get(), BlockRegistry.FUKAMIZU_PLUM_LEAVES.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockRegistry.RED_AHOGE_BLOCK.get(), BlockRegistry.WHITE_AHOGE_BLOCK.get(),
                BlockRegistry.HARDEN_CRYSTAL_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(BlockRegistry.PURIFIED_CRYSTAL_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(BlockRegistry.CHARGED_CRYSTAL_BLOCK.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(BlockRegistry.FICTIONAL_INGOT_BLOCK.get(), BlockRegistry.GACHI_INGOT_BLOCK.get());
        this.tag(BlockTags.BEE_GROWABLES).add(BlockRegistry.UNI_MILLET_BLOCK.get());
        this.tag(BlockTags.CROPS).add(BlockRegistry.UNI_MILLET_BLOCK.get());
        this.tag(BlockTags.SAND).add(BlockRegistry.BLUE_SAND.get());
        this.tag(Tags.Blocks.SANDSTONE)
                .add(BlockRegistry.BLUE_SANDSTONE.get(), BlockRegistry.CUT_BLUE_SANDSTONE.get(),
                        BlockRegistry.SMOOTH_BLUE_SANDSTONE.get(), BlockRegistry.CHISELED_BLUE_SANDSTONE.get());
        this.tag(BlockTags.LOGS)
                .add(BlockRegistry.HARANO_LOG.get(), BlockRegistry.HARANO_WOOD.get(), BlockRegistry.STRIPPED_HARANO_LOG.get(), BlockRegistry.STRIPPED_HARANO_WOOD.get(),
                        BlockRegistry.FUKAMIZU_PLUM_LOG.get(), BlockRegistry.STRIPPED_FUKAMIZU_PLUM_LOG.get());
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(BlockRegistry.HARANO_LOG.get(), BlockRegistry.HARANO_WOOD.get(), BlockRegistry.STRIPPED_HARANO_LOG.get(), BlockRegistry.STRIPPED_HARANO_WOOD.get(),
                        BlockRegistry.FUKAMIZU_PLUM_LOG.get(), BlockRegistry.STRIPPED_FUKAMIZU_PLUM_LOG.get());
        this.tag(BlockTags.WALLS).add(BlockRegistry.BLUE_SANDSTONE_WALL.get());
        this.tag(BlockTags.SWORD_EFFICIENT).add(BlockRegistry.UNI_MILLET_BLOCK.get());
        this.tag(BlockTags.SLABS)
                .add(BlockRegistry.BLUE_SANDSTONE_SLAB.get(), BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(),
                        BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), BlockRegistry.HARANO_SLAB.get());
        this.tag(BlockTags.SMELTS_TO_GLASS).add(BlockRegistry.BLUE_SAND.get());
        this.tag(BlockTags.STAIRS)
                .add(BlockRegistry.BLUE_SANDSTONE_STAIRS.get(), BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(),
                        BlockRegistry.HARANO_STAIRS.get());
        this.tag(BlockTags.PLANKS).add(BlockRegistry.HARANO_PLANKS.get(), BlockRegistry.FUKAMIZU_PLUM_PLANKS.get());
        this.tag(BlockTags.FENCES).add(BlockRegistry.HARANO_FENCE.get());
        this.tag(BlockTags.WOODEN_FENCES).add(BlockRegistry.HARANO_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(BlockRegistry.HARANO_FENCE_GATE.get());
        this.tag(BlockTags.PRESSURE_PLATES).add(BlockRegistry.HARANO_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockRegistry.HARANO_PRESSURE_PLATE.get());
        this.tag(BlockTags.LEAVES).add(BlockRegistry.HARANO_LEAVES.get(), BlockRegistry.FUKAMIZU_PLUM_LEAVES.get());
        this.tag(Tags.Blocks.SAND).add(BlockRegistry.BLUE_SAND.get());
        this.tag(BlockTags.DOORS).add(BlockRegistry.HARANO_DOOR.get());
        this.tag(BlockTags.WOODEN_DOORS).add(BlockRegistry.HARANO_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(BlockRegistry.HARANO_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(BlockRegistry.HARANO_TRAPDOOR.get());
        this.tag(BlockTags.BUTTONS).add(BlockRegistry.HARANO_BUTTON.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(BlockRegistry.HARANO_BUTTON.get());
        this.tag(BlockTags.WITHER_IMMUNE).add(BlockRegistry.FUKAMIZU_BREAD_BLOCK.get(), BlockRegistry.FUKAMIZU_BREAD_BRICKS.get());
        this.tag(ModTags.Blocks.FUKAMIZU_MACHINE).add(BlockRegistry.FUKAMIZU_COMPRESSOR.get(), BlockRegistry.FUKAMIZU_CRUSHER.get());
        this.tag(ModTags.Blocks.FUKAMIZU_BREAD).add(BlockRegistry.FUKAMIZU_BREAD_BLOCK.get(), BlockRegistry.FUKAMIZU_BREAD_BRICKS.get());
    }
}
