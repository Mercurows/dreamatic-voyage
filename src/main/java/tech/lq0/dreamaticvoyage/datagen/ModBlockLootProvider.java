package tech.lq0.dreamaticvoyage.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.block.UniMilletBlock;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.Set;

public class ModBlockLootProvider extends BlockLootSubProvider {
    public ModBlockLootProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BlockRegistry.RED_AHOGE_BLOCK.get());
        this.dropSelf(BlockRegistry.WHITE_AHOGE_BLOCK.get());
        this.dropSelf(BlockRegistry.COMMUNICATION_TABLE.get());
        this.dropSelf(BlockRegistry.PORCELAIN_THRONE.get());
        this.dropSelf(BlockRegistry.POINTS_STORE.get());
        this.dropSelf(BlockRegistry.FUKAMIZU_BREAD_BLOCK.get());
        this.dropOther(BlockRegistry.JELLYFISH_BOTTLE.get(), ItemRegistry.JELLYFISH_BOTTLE.get());

        LootItemCondition.Builder lootItemCondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(BlockRegistry.UNI_MILLET_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UniMilletBlock.AGE, 7));
        this.add(BlockRegistry.UNI_MILLET_BLOCK.get(), createCropDrops(BlockRegistry.UNI_MILLET_BLOCK.get(),
                ItemRegistry.UNI_MILLET.get(), ItemRegistry.UNI_MILLET.get(), lootItemCondition$builder));

        this.dropSelf(BlockRegistry.BLUE_SAND.get());
        this.dropSelf(BlockRegistry.BLUE_SANDSTONE.get());
        this.dropSelf(BlockRegistry.CUT_BLUE_SANDSTONE.get());
        this.dropSelf(BlockRegistry.CHISELED_BLUE_SANDSTONE.get());
        this.add(BlockRegistry.BLUE_SANDSTONE_SLAB.get(), block -> createSlabItemTable(BlockRegistry.BLUE_SANDSTONE_SLAB.get()));
        this.dropSelf(BlockRegistry.BLUE_SANDSTONE_STAIRS.get());
        this.dropSelf(BlockRegistry.BLUE_SANDSTONE_WALL.get());
        this.dropSelf(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get());
        this.add(BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), block -> createSlabItemTable(BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get()));
        this.add(BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(), block -> createSlabItemTable(BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get()));
        this.dropSelf(BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get());

        this.dropSelf(BlockRegistry.HARANO_LOG.get());
        this.add(BlockRegistry.HARANO_LEAVES.get(), block -> createLeavesDrops(BlockRegistry.HARANO_LEAVES.get(), BlockRegistry.HARANO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(BlockRegistry.HARANO_SAPLING.get());
        this.dropSelf(BlockRegistry.HARANO_PLANKS.get());
        this.dropSelf(BlockRegistry.HARANO_STAIRS.get());
        this.dropSelf(BlockRegistry.HARANO_WOOD.get());
        this.add(BlockRegistry.HARANO_SLAB.get(), block -> createSlabItemTable(BlockRegistry.HARANO_SLAB.get()));
        this.dropSelf(BlockRegistry.HARANO_FENCE.get());
        this.dropSelf(BlockRegistry.HARANO_FENCE_GATE.get());
        this.dropSelf(BlockRegistry.HARANO_PRESSURE_PLATE.get());
        this.dropSelf(BlockRegistry.STRIPPED_HARANO_LOG.get());
        this.dropSelf(BlockRegistry.STRIPPED_HARANO_WOOD.get());
        this.add(BlockRegistry.HARANO_DOOR.get(), block -> createDoorTable(BlockRegistry.HARANO_DOOR.get()));
        this.dropSelf(BlockRegistry.HARANO_TRAPDOOR.get());
        this.dropSelf(BlockRegistry.HARANO_BUTTON.get());

        this.dropSelf(BlockRegistry.HARDEN_CRYSTAL_BLOCK.get());
        this.dropSelf(BlockRegistry.PURIFIED_CRYSTAL_BLOCK.get());
        this.dropSelf(BlockRegistry.CHARGED_CRYSTAL_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
