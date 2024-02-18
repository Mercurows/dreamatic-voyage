package tech.lq0.providencraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                              CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Utils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.SAND).add(ItemRegistry.BLUE_SAND.get());
        this.tag(Tags.Items.SANDSTONE)
                .add(ItemRegistry.BLUE_SANDSTONE.get(), ItemRegistry.CUT_BLUE_SANDSTONE.get(), ItemRegistry.SMOOTH_BLUE_SANDSTONE.get(), ItemRegistry.CHISELED_BLUE_SANDSTONE.get());
        this.tag(ItemTags.LOGS)
                .add(ItemRegistry.HARANO_LOG.get(), ItemRegistry.HARANO_WOOD.get(), ItemRegistry.STRIPPED_HARANO_LOG.get(), ItemRegistry.STRIPPED_HARANO_WOOD.get());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ItemRegistry.HARANO_LOG.get(), ItemRegistry.HARANO_WOOD.get(), ItemRegistry.STRIPPED_HARANO_LOG.get(), ItemRegistry.STRIPPED_HARANO_WOOD.get());
        this.tag(ItemTags.WALLS).add(ItemRegistry.BLUE_SANDSTONE_WALL.get());
        this.tag(ItemTags.SLABS)
                .add(ItemRegistry.BLUE_SANDSTONE_SLAB.get(), ItemRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(),
                        ItemRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), ItemRegistry.HARANO_SLAB.get());
        this.tag(ItemTags.SMELTS_TO_GLASS).add(ItemRegistry.BLUE_SAND.get());
        this.tag(ItemTags.STAIRS)
                .add(ItemRegistry.BLUE_SANDSTONE_STAIRS.get(), ItemRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(),
                        ItemRegistry.HARANO_STAIRS.get());
        this.tag(ItemTags.PLANKS).add(ItemRegistry.HARANO_PLANKS.get());
        this.tag(ItemTags.FENCES).add(ItemRegistry.HARANO_FENCE.get());
        this.tag(ItemTags.WOODEN_FENCES).add(ItemRegistry.HARANO_FENCE.get());
        this.tag(ItemTags.FENCE_GATES).add(ItemRegistry.HARANO_FENCE_GATE.get());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ItemRegistry.HARANO_PRESSURE_PLATE.get());
        this.tag(ItemTags.LEAVES).add(ItemRegistry.HARANO_LEAVES.get());
        this.tag(Tags.Items.SAND).add(ItemRegistry.BLUE_SAND.get());
        ItemRegistry.AUDIO_ITEMS.getEntries().forEach(entry -> this.tag(ItemTags.MUSIC_DISCS).add(entry.get()));
        this.tag(ItemTags.MUSIC_DISCS).add(ItemRegistry.MUSIC_DISC_SONG_OF_AUTUMN.get());
        this.tag(ItemTags.DOORS).add(ItemRegistry.HARANO_DOOR.get());
        this.tag(ItemTags.WOODEN_DOORS).add(ItemRegistry.HARANO_DOOR.get());
        this.tag(ItemTags.TRAPDOORS).add(ItemRegistry.HARANO_TRAPDOOR.get());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(ItemRegistry.HARANO_TRAPDOOR.get());
        this.tag(ItemTags.BUTTONS).add(ItemRegistry.HARANO_BUTTON.get());
        this.tag(ItemTags.WOODEN_BUTTONS).add(ItemRegistry.HARANO_BUTTON.get());
        this.tag(ItemTags.PIGLIN_LOVED).add(ItemRegistry.CRYSTAL_POWDER.get(), ItemRegistry.PURIFIED_CRYSTAL_POWDER.get(), ItemRegistry.CHARGED_CRYSTAL_POWDER.get(),
                ItemRegistry.HARDEN_CRYSTAL_INGOT.get(), ItemRegistry.PURIFIED_CRYSTAL_INGOT.get(), ItemRegistry.CHARGED_CRYSTAL_INGOT.get());
    }
}
