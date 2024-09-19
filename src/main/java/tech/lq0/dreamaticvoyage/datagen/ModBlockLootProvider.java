package tech.lq0.dreamaticvoyage.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.block.UniMilletBlock;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

import java.util.Set;

public class ModBlockLootProvider extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SHEARS_TAG_OR_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)).or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_TAG_OR_SILK_TOUCH = HAS_SHEARS_TAG_OR_SILK_TOUCH.invert();

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
        this.dropSelf(BlockRegistry.FUKAMIZU_BREAD_BRICKS.get());
        this.dropOther(BlockRegistry.JELLYFISH_BOTTLE.get(), ItemRegistry.JELLYFISH_BOTTLE.get());
        this.dropOther(BlockRegistry.ROCK_STATUE.get(), ItemRegistry.ROCK_STATUE.get());

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
        this.add(BlockRegistry.SUSPICIOUS_BLUE_SAND.get(), block -> noDrop());

        this.dropSelf(BlockRegistry.HARANO_LOG.get());
        this.add(BlockRegistry.HARANO_LEAVES.get(), block -> createTagLeavesDrops(BlockRegistry.HARANO_LEAVES.get(), BlockRegistry.HARANO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
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

        this.dropSelf(BlockRegistry.FUKAMIZU_PLUM_LOG.get());
        this.dropSelf(BlockRegistry.FUKAMIZU_PLUM_PLANKS.get());

        this.dropSelf(BlockRegistry.HARDEN_CRYSTAL_BLOCK.get());
        this.dropSelf(BlockRegistry.PURIFIED_CRYSTAL_BLOCK.get());
        this.dropSelf(BlockRegistry.CHARGED_CRYSTAL_BLOCK.get());
        this.dropSelf(BlockRegistry.FICTIONAL_INGOT_BLOCK.get());
        this.dropSelf(BlockRegistry.GACHI_INGOT_BLOCK.get());

        this.dropSelf(BlockRegistry.VERDANT_SPIRIT_RICH_SOIL.get());
        this.dropOther(BlockRegistry.VERDANT_SPIRIT_FARMLAND.get(), BlockRegistry.VERDANT_SPIRIT_RICH_SOIL.get());

        this.dropSelf(BlockRegistry.PHANTASMAL_VOYAGER.get());
        this.dropSelf(BlockRegistry.CRYSTAL_POPPER.get());

        this.dropSelf(BlockRegistry.FUKAMIZU_MACHINE_CASING.get());
        this.dropSelf(BlockRegistry.FUKAMIZU_COMPRESSOR.get());
        this.dropSelf(BlockRegistry.FUKAMIZU_CRUSHER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    public LootTable.Builder createTagLeavesDrops(Block pLeavesBlock, Block pSaplingBlock, float... pChances) {
        return createSelfDropDispatchTable(pLeavesBlock, HAS_SHEARS_TAG_OR_SILK_TOUCH, this.applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(pSaplingBlock))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pChances))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .when(HAS_NO_SHEARS_TAG_OR_SILK_TOUCH).add(this.applyExplosionDecay(pLeavesBlock, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }
}
