package tech.lq0.dreamaticvoyage.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.compat.data.CompatMetals;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
                              CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture, Utils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.SAND).add(ItemRegistry.BLUE_SAND.get());
        this.tag(Tags.Items.SANDSTONE)
                .add(ItemRegistry.BLUE_SANDSTONE.get(), ItemRegistry.CUT_BLUE_SANDSTONE.get(), ItemRegistry.SMOOTH_BLUE_SANDSTONE.get(), ItemRegistry.CHISELED_BLUE_SANDSTONE.get());
        this.tag(ItemTags.LOGS)
                .add(ItemRegistry.HARANO_LOG.get(), ItemRegistry.HARANO_WOOD.get(), ItemRegistry.STRIPPED_HARANO_LOG.get(), ItemRegistry.STRIPPED_HARANO_WOOD.get(),
                        ItemRegistry.FUKAMIZU_PLUM_LOG.get(), ItemRegistry.STRIPPED_FUKAMIZU_PLUM_LOG.get(), ItemRegistry.FUKAMIZU_PLUM_WOOD.get(),
                        ItemRegistry.STRIPPED_FUKAMIZU_PLUM_WOOD.get());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ItemRegistry.HARANO_LOG.get(), ItemRegistry.HARANO_WOOD.get(), ItemRegistry.STRIPPED_HARANO_LOG.get(), ItemRegistry.STRIPPED_HARANO_WOOD.get(),
                        ItemRegistry.FUKAMIZU_PLUM_LOG.get(), ItemRegistry.STRIPPED_FUKAMIZU_PLUM_LOG.get(), ItemRegistry.FUKAMIZU_PLUM_WOOD.get(),
                        ItemRegistry.STRIPPED_FUKAMIZU_PLUM_WOOD.get());
        this.tag(ItemTags.WALLS).add(ItemRegistry.BLUE_SANDSTONE_WALL.get());
        this.tag(ItemTags.SLABS)
                .add(ItemRegistry.BLUE_SANDSTONE_SLAB.get(), ItemRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(),
                        ItemRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), ItemRegistry.HARANO_SLAB.get(), ItemRegistry.FUKAMIZU_PLUM_SLAB.get());
        this.tag(ItemTags.SMELTS_TO_GLASS).add(ItemRegistry.BLUE_SAND.get());
        this.tag(ItemTags.STAIRS)
                .add(ItemRegistry.BLUE_SANDSTONE_STAIRS.get(), ItemRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(),
                        ItemRegistry.HARANO_STAIRS.get(), ItemRegistry.FUKAMIZU_PLUM_STAIRS.get());
        this.tag(ItemTags.PLANKS).add(ItemRegistry.HARANO_PLANKS.get(), ItemRegistry.FUKAMIZU_PLUM_PLANKS.get());
        this.tag(ItemTags.FENCES).add(ItemRegistry.HARANO_FENCE.get(), ItemRegistry.FUKAMIZU_PLUM_FENCE.get());
        this.tag(ItemTags.WOODEN_FENCES).add(ItemRegistry.HARANO_FENCE.get(), ItemRegistry.FUKAMIZU_PLUM_FENCE.get());
        this.tag(ItemTags.FENCE_GATES).add(ItemRegistry.HARANO_FENCE_GATE.get(), ItemRegistry.FUKAMIZU_PLUM_FENCE_GATE.get());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ItemRegistry.HARANO_PRESSURE_PLATE.get(), ItemRegistry.FUKAMIZU_PLUM_PRESSURE_PLATE.get());
        this.tag(ItemTags.LEAVES).add(ItemRegistry.HARANO_LEAVES.get(), ItemRegistry.FUKAMIZU_PLUM_LEAVES.get());
        this.tag(Tags.Items.SAND).add(ItemRegistry.BLUE_SAND.get());
        ItemRegistry.AUDIO_ITEMS.getEntries().forEach(entry -> this.tag(ItemTags.MUSIC_DISCS).add(entry.get()));
        this.tag(ItemTags.MUSIC_DISCS).add(ItemRegistry.MUSIC_DISC_SONG_OF_AUTUMN.get());
        this.tag(ItemTags.DOORS).add(ItemRegistry.HARANO_DOOR.get());
        this.tag(ItemTags.WOODEN_DOORS).add(ItemRegistry.HARANO_DOOR.get());
        this.tag(ItemTags.TRAPDOORS).add(ItemRegistry.HARANO_TRAPDOOR.get());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(ItemRegistry.HARANO_TRAPDOOR.get());
        this.tag(ItemTags.BUTTONS).add(ItemRegistry.HARANO_BUTTON.get(), ItemRegistry.FUKAMIZU_PLUM_BUTTON.get());
        this.tag(ItemTags.WOODEN_BUTTONS).add(ItemRegistry.HARANO_BUTTON.get(), ItemRegistry.FUKAMIZU_PLUM_BUTTON.get());
        this.tag(ItemTags.PIGLIN_LOVED).add(ItemRegistry.CRYSTAL_POWDER.get(), ItemRegistry.PURIFIED_CRYSTAL_POWDER.get(), ItemRegistry.CHARGED_CRYSTAL_POWDER.get(),
                ItemRegistry.HARDEN_CRYSTAL_INGOT.get(), ItemRegistry.PURIFIED_CRYSTAL_INGOT.get(), ItemRegistry.CHARGED_CRYSTAL_INGOT.get());
        this.tag(ItemTags.SWORDS).add(ItemRegistry.RED_AHOGE_SWORD.get(), ItemRegistry.RED_AHOGE_BOOMERANG.get(),
                ItemRegistry.RED_AHOGE_MACHETE.get(), ItemRegistry.HAYA_SWORD.get(), ItemRegistry.BIG_SPOON.get(),
                ItemRegistry.MACHETE.get(), ItemRegistry.PLUNGER.get(), ItemRegistry.SATOU_KNIFE.get(),
                ItemRegistry.ANCIENT_LOLLIPOP.get(), ItemRegistry.FETUOZI.get(), ItemRegistry.WORLD_PEACE_STAFF.get(),
                ItemRegistry.MOMO_KNIFE.get(), ItemRegistry.TAIL_PEN.get(), ItemRegistry.SHU_RINO_KEN.get(),
                ItemRegistry.SHURA_CHIN.get(), ItemRegistry.UME.get(), ItemRegistry.LUNAR_ECLIPSE.get(),
                ItemRegistry.OMINOUS_SICKLE.get(), ItemRegistry.FUKAMIZU_BREAD_SWORD.get(),
                ItemRegistry.FUKAMIZU_BREAD_MULTITOOL.get());
        this.tag(ItemTags.PICKAXES).add(ItemRegistry.MOUNTAIN_DESTROYER.get(), ItemRegistry.FUKAMIZU_BREAD_PICKAXE.get(), ItemRegistry.FUKAMIZU_BREAD_MULTITOOL.get());
        this.tag(ItemTags.AXES).add(ItemRegistry.FIAXE.get(), ItemRegistry.FUKAMIZU_BREAD_AXE.get(), ItemRegistry.FUKAMIZU_BREAD_MULTITOOL.get());
        this.tag(ItemTags.HOES).add(ItemRegistry.QIANYUN_HOE.get(), ItemRegistry.GREEN_FIELD_SONG.get(),
                ItemRegistry.FUKAMIZU_BREAD_HOE.get(), ItemRegistry.FUKAMIZU_BREAD_MULTITOOL.get());
        this.tag(ItemTags.SHOVELS).add(ItemRegistry.MOUNTAIN_DESTROYER.get(), ItemRegistry.FUKAMIZU_BREAD_SHOVEL.get(), ItemRegistry.FUKAMIZU_BREAD_MULTITOOL.get());
        this.tag(Tags.Items.SEEDS).add(ItemRegistry.UNI_MILLET.get());
        this.tag(Tags.Items.SHEARS).add(ItemRegistry.FUKAMIZU_BREAD_SHEARS.get());
        this.tag(ItemTags.SAPLINGS).add(ItemRegistry.HARANO_SAPLING.get(), ItemRegistry.FUKAMIZU_PLUM_SAPLING.get());

        this.tag(Tags.Items.DUSTS).add(ItemRegistry.FUKAMIZU_CRUMB.get(), ItemRegistry.IRON_RICH_CRUMB.get(),
                        ItemRegistry.COPPER_RICH_CRUMB.get(), ItemRegistry.GOLD_RICH_CRUMB.get())
                .addOptional(makeCompatCrumbId(CompatMetals.ZINC)).addOptional(makeCompatCrumbId(CompatMetals.LEAD))
                .addOptional(makeCompatCrumbId(CompatMetals.NICKEL)).addOptional(makeCompatCrumbId(CompatMetals.SILVER))
                .addOptional(makeCompatCrumbId(CompatMetals.TIN)).addOptional(makeCompatCrumbId(CompatMetals.ALUMINUM))
                .addOptional(makeCompatCrumbId(CompatMetals.OSMIUM)).addOptional(makeCompatCrumbId(CompatMetals.URANIUM))
                .addOptional(makeCompatCrumbId(CompatMetals.QUICKSILVER)).addOptional(makeCompatCrumbId(CompatMetals.PLATINUM));
        addCompatCrumbDustTag(CompatMetals.ZINC, CompatMetals.LEAD, CompatMetals.NICKEL, CompatMetals.SILVER,
                CompatMetals.TIN, CompatMetals.ALUMINUM, CompatMetals.OSMIUM, CompatMetals.URANIUM, CompatMetals.PLATINUM, CompatMetals.QUICKSILVER);
        this.tag(forgeTag("dusts/iron")).add(ItemRegistry.IRON_RICH_CRUMB.get());
        this.tag(forgeTag("dusts/copper")).add(ItemRegistry.COPPER_RICH_CRUMB.get());
        this.tag(forgeTag("dusts/gold")).add(ItemRegistry.GOLD_RICH_CRUMB.get());

        this.tag(forgeTag("plates")).add(ItemRegistry.IRON_BREAD_SLICE.get(),
                        ItemRegistry.COPPER_BREAD_SLICE.get(), ItemRegistry.GOLD_BREAD_SLICE.get())
                .addOptional(makeCompatBreadSliceId(CompatMetals.ZINC)).addOptional(makeCompatBreadSliceId(CompatMetals.LEAD))
                .addOptional(makeCompatBreadSliceId(CompatMetals.NICKEL)).addOptional(makeCompatBreadSliceId(CompatMetals.SILVER))
                .addOptional(makeCompatBreadSliceId(CompatMetals.TIN)).addOptional(makeCompatBreadSliceId(CompatMetals.ALUMINUM))
                .addOptional(makeCompatBreadSliceId(CompatMetals.OSMIUM)).addOptional(makeCompatBreadSliceId(CompatMetals.URANIUM))
                .addOptional(makeCompatBreadSliceId(CompatMetals.QUICKSILVER)).addOptional(makeCompatBreadSliceId(CompatMetals.PLATINUM))
                .addOptional(makeCompatBreadSliceId(CompatMetals.BRASS)).addOptional(makeCompatBreadSliceId(CompatMetals.STEEL));
        this.tag(forgeTag("plates/iron")).add(ItemRegistry.IRON_BREAD_SLICE.get());
        this.tag(forgeTag("plates/copper")).add(ItemRegistry.COPPER_BREAD_SLICE.get());
        this.tag(forgeTag("plates/gold")).add(ItemRegistry.GOLD_BREAD_SLICE.get());
        addCompatBreadSlicePlateTag(CompatMetals.ZINC, CompatMetals.LEAD, CompatMetals.NICKEL, CompatMetals.SILVER,
                CompatMetals.TIN, CompatMetals.ALUMINUM, CompatMetals.OSMIUM, CompatMetals.URANIUM, CompatMetals.PLATINUM, CompatMetals.QUICKSILVER,
                CompatMetals.BRASS, CompatMetals.STEEL);

        this.tag(ModTags.Items.AUDIO_TAPE_CHIRAM).add(ItemRegistry.AUDIO_TAPE_CHIRAM_1.get(), ItemRegistry.AUDIO_TAPE_CHIRAM_2.get(), ItemRegistry.AUDIO_TAPE_CHIRAM_3.get());
        this.tag(ModTags.Items.AUDIO_TAPE_HAINE).add(ItemRegistry.AUDIO_TAPE_HAINE_1.get(), ItemRegistry.AUDIO_TAPE_HAINE_2.get(), ItemRegistry.AUDIO_TAPE_HAINE_3.get());
        this.tag(ModTags.Items.AUDIO_TAPE_KERORO).add(ItemRegistry.AUDIO_TAPE_KERORO_1.get(), ItemRegistry.AUDIO_TAPE_KERORO_2.get(), ItemRegistry.AUDIO_TAPE_KERORO_3.get());
        this.tag(ModTags.Items.AUDIO_TAPE_EKIRA).add(ItemRegistry.AUDIO_TAPE_EKIRA_1.get(), ItemRegistry.AUDIO_TAPE_EKIRA_2.get(), ItemRegistry.AUDIO_TAPE_EKIRA_3.get());

        this.tag(ModTags.Items.FUKAMIZU_EDGE).add(ItemRegistry.SOFT_EDGE.get()).addTag(ModTags.Items.FUKAMIZU_EDGE_WITH_EXTRA_LOOT);
        this.tag(ModTags.Items.FUKAMIZU_EDGE_WITH_EXTRA_LOOT).add(ItemRegistry.HARD_EDGE.get(), ItemRegistry.SERRATION_EDGE.get(),
                ItemRegistry.COLORFUL_EDGE.get(), ItemRegistry.SWOLLEN_EDGE.get(), ItemRegistry.FUKAMIZU_EDGE.get());
    }

    private static TagKey<Item> forgeTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }

    private void addCompatCrumbDustTag(CompatMetals... metals) {
        for (var metal : metals) {
            this.tag(forgeTag("dusts/" + metal.getName())).addOptional(Utils.loc(metal.getName() + "_rich_crumb"));
        }
    }

    private ResourceLocation makeCompatCrumbId(CompatMetals metal) {
        return Utils.loc(metal.getName() + "_rich_crumb");
    }

    private void addCompatBreadSlicePlateTag(CompatMetals... metals) {
        for (var metal : metals) {
            this.tag(forgeTag("plates/" + metal.getName())).addOptional(Utils.loc(metal.getName() + "_bread_slice"));
        }
    }

    private ResourceLocation makeCompatBreadSliceId(CompatMetals metal) {
        return Utils.loc(metal.getName() + "_bread_slice");
    }
}
