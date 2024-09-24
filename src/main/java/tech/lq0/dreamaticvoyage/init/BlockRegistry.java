package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.*;
import tech.lq0.dreamaticvoyage.block.bluesand.*;
import tech.lq0.dreamaticvoyage.block.fukamizu.plum.*;
import tech.lq0.dreamaticvoyage.block.fukamizu.tech.*;
import tech.lq0.dreamaticvoyage.block.harano.*;
import tech.lq0.dreamaticvoyage.block.voyage.PhantasmalVoyager;

@SuppressWarnings("unused")
public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);

    public static final RegistryObject<Block> RED_AHOGE_BLOCK = BLOCKS.register("red_ahoge_block", RedAhogeBlock::new);
    public static final RegistryObject<Block> WHITE_AHOGE_BLOCK = BLOCKS.register("white_ahoge_block", WhiteAhogeBlock::new);
    public static final RegistryObject<Block> COMMUNICATION_TABLE = BLOCKS.register("communication_table", CommunicationTable::new);
    public static final RegistryObject<Block> PORCELAIN_THRONE = BLOCKS.register("porcelain_throne", PorcelainThrone::new);
    public static final RegistryObject<Block> POINTS_STORE = BLOCKS.register("points_store", PointsStore::new);
    public static final RegistryObject<Block> FUKAMIZU_BREAD_BLOCK = BLOCKS.register("fukamizu_bread_block", FukamizuBreadBlock::new);
    public static final RegistryObject<Block> FUKAMIZU_BREAD_BRICKS = BLOCKS.register("fukamizu_bread_bricks", FukamizuBreadBricks::new);
    public static final RegistryObject<Block> UNI_MILLET_BLOCK = BLOCKS.register("uni_millet_block", UniMilletBlock::new);
    public static final RegistryObject<Block> JELLYFISH_BOTTLE = BLOCKS.register("jellyfish_bottle", JellyfishBottleBlock::new);
    public static final RegistryObject<Block> ROCK_STATUE = BLOCKS.register("rock_statue", RockStatueBlock::new);
    public static final RegistryObject<Block> VERDANT_SPIRIT_RICH_SOIL = BLOCKS.register("verdant_spirit_rich_soil", VerdantSpiritRichSoilBlock::new);
    public static final RegistryObject<Block> VERDANT_SPIRIT_FARMLAND = BLOCKS.register("verdant_spirit_farmland", VerdantSpiritFarmlandBlock::new);

    // Blue Sand Series
    public static final RegistryObject<Block> BLUE_SAND = BLOCKS.register("blue_sand", BlueSand::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE = BLOCKS.register("blue_sandstone", BlueSandstone::new);
    public static final RegistryObject<Block> CUT_BLUE_SANDSTONE = BLOCKS.register("cut_blue_sandstone", CutBlueSandstone::new);
    public static final RegistryObject<Block> CHISELED_BLUE_SANDSTONE = BLOCKS.register("chiseled_blue_sandstone", ChiseledBlueSandstone::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE_SLAB = BLOCKS.register("blue_sandstone_slab", BlueSandstoneSlab::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE_STAIRS = BLOCKS.register("blue_sandstone_stairs", BlueSandstoneStairs::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE_WALL = BLOCKS.register("blue_sandstone_wall", BlueSandstoneWall::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE = BLOCKS.register("smooth_blue_sandstone", SmoothBlueSandstone::new);
    public static final RegistryObject<Block> CUT_BLUE_SANDSTONE_SLAB = BLOCKS.register("cut_blue_sandstone_slab", CutBlueSandstoneSlab::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE_SLAB = BLOCKS.register("smooth_blue_sandstone_slab", SmoothBlueSandstoneSlab::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE_STAIRS = BLOCKS.register("smooth_blue_sandstone_stairs", SmoothBlueSandstoneStairs::new);
    public static final RegistryObject<Block> SUSPICIOUS_BLUE_SAND = BLOCKS.register("suspicious_blue_sand", SuspiciousBlueSand::new);

    // Harano Wood Series
    public static final RegistryObject<Block> HARANO_LOG = BLOCKS.register("harano_log", HaranoLog::new);
    public static final RegistryObject<Block> HARANO_LEAVES = BLOCKS.register("harano_leaves", HaranoLeaves::new);
    public static final RegistryObject<Block> HARANO_SAPLING = BLOCKS.register("harano_sapling", HaranoSapling::new);
    public static final RegistryObject<Block> HARANO_PLANKS = BLOCKS.register("harano_planks", HaranoPlanks::new);
    public static final RegistryObject<Block> HARANO_WOOD = BLOCKS.register("harano_wood", HaranoWood::new);
    public static final RegistryObject<Block> HARANO_STAIRS = BLOCKS.register("harano_stairs", HaranoStairs::new);
    public static final RegistryObject<Block> HARANO_SLAB = BLOCKS.register("harano_slab", HaranoSlab::new);
    public static final RegistryObject<Block> HARANO_FENCE = BLOCKS.register("harano_fence", HaranoFence::new);
    public static final RegistryObject<Block> HARANO_FENCE_GATE = BLOCKS.register("harano_fence_gate", HaranoFenceGate::new);
    public static final RegistryObject<Block> HARANO_PRESSURE_PLATE = BLOCKS.register("harano_pressure_plate", HaranoPressurePlate::new);
    public static final RegistryObject<Block> STRIPPED_HARANO_LOG = BLOCKS.register("stripped_harano_log", StrippedHaranoLog::new);
    public static final RegistryObject<Block> STRIPPED_HARANO_WOOD = BLOCKS.register("stripped_harano_wood", StrippedHaranoWood::new);
    public static final RegistryObject<Block> HARANO_DOOR = BLOCKS.register("harano_door", HaranoDoor::new);
    public static final RegistryObject<Block> HARANO_TRAPDOOR = BLOCKS.register("harano_trapdoor", HaranoTrapDoor::new);
    public static final RegistryObject<Block> HARANO_BUTTON = BLOCKS.register("harano_button", HaranoButton::new);

    // Crystal Series
    public static final RegistryObject<Block> HARDEN_CRYSTAL_BLOCK = BLOCKS.register("harden_crystal_block", HardenCrystalBlock::new);
    public static final RegistryObject<Block> PURIFIED_CRYSTAL_BLOCK = BLOCKS.register("purified_crystal_block", PurifiedCrystalBlock::new);
    public static final RegistryObject<Block> CHARGED_CRYSTAL_BLOCK = BLOCKS.register("charged_crystal_block", ChargedCrystalBlock::new);
    public static final RegistryObject<Block> FICTIONAL_INGOT_BLOCK = BLOCKS.register("fictional_ingot_block", FictionalIngotBlock::new);
    public static final RegistryObject<Block> GACHI_INGOT_BLOCK = BLOCKS.register("gachi_ingot_block", GachiIngotBlock::new);

    // Voyage Series
    public static final RegistryObject<Block> PHANTASMAL_VOYAGER = BLOCKS.register("phantasmal_voyager", PhantasmalVoyager::new);
    public static final RegistryObject<Block> CRYSTAL_POPPER = BLOCKS.register("crystal_popper", CrystalPopper::new);
    public static final RegistryObject<Block> CRYSTAL_PURIFIER = BLOCKS.register("crystal_purifier", CrystalPurifier::new);

    // Fukamizu Tech Series
    public static final RegistryObject<Block> FUKAMIZU_MACHINE_CASING = BLOCKS.register("fukamizu_machine_casing", FukamizuMachineCasing::new);
    public static final RegistryObject<Block> FUKAMIZU_COMPRESSOR = BLOCKS.register("fukamizu_compressor", FukamizuCompressor::new);
    public static final RegistryObject<Block> FUKAMIZU_PYLON = BLOCKS.register("fukamizu_pylon", FukamizuPylon::new);
    public static final RegistryObject<Block> LIGHT_BREAD_ENERGY_BLOCK = BLOCKS.register("light_bread_energy_block", LightBreadEnergyBlock::new);
    public static final RegistryObject<Block> FUKAMIZU_CRUSHER = BLOCKS.register("fukamizu_crusher", FukamizuCrusher::new);

    // Fukamizu Plum Series
    public static final RegistryObject<Block> FUKAMIZU_PLUM_LOG = BLOCKS.register("fukamizu_plum_log", FukamizuPlumLog::new);
    public static final RegistryObject<Block> FUKAMIZU_PLUM_LEAVES = BLOCKS.register("fukamizu_plum_leaves", FukamizuPlumLeaves::new);
    public static final RegistryObject<Block> FUKAMIZU_PLUM_SAPLING = BLOCKS.register("fukamizu_plum_sapling", FukamizuPlumSapling::new);
    public static final RegistryObject<Block> FUKAMIZU_PLUM_PLANKS = BLOCKS.register("fukamizu_plum_planks", FukamizuPlumPlanks::new);
    public static final RegistryObject<Block> FUKAMIZU_PLUM_WOOD = BLOCKS.register("fukamizu_plum_wood", FukamizuPlumWood::new);
    public static final RegistryObject<Block> STRIPPED_FUKAMIZU_PLUM_LOG = BLOCKS.register("stripped_fukamizu_plum_log", StrippedFukamizuPlumLog::new);
    public static final RegistryObject<Block> STRIPPED_FUKAMIZU_PLUM_WOOD = BLOCKS.register("stripped_fukamizu_plum_wood", StrippedFukamizuPlumWood::new);

    // Fluids
    public static final RegistryObject<LiquidBlock> FUKAMIZU_KWAS = BLOCKS.register("fukamizu_kwas", FukamizuKwasBlock::new);
}
