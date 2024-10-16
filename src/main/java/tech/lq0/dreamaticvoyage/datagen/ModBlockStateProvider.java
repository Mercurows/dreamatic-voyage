package tech.lq0.dreamaticvoyage.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;

@SuppressWarnings({"ConstantConditions", "SameParameterValue"})
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Utils.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.RED_AHOGE_BLOCK);
        blockWithItem(BlockRegistry.WHITE_AHOGE_BLOCK);
        blockWithItem(BlockRegistry.FUKAMIZU_BREAD_BLOCK);
        blockWithItem(BlockRegistry.FUKAMIZU_BREAD_BRICKS);
        simpleBlockWithItem(BlockRegistry.COMMUNICATION_TABLE.get(), models().cubeBottomTop("communication_table", Utils.loc( "block/communication_table_side"),
                Utils.loc( "block/communication_table_bottom"), Utils.loc( "block/communication_table_top")));
        horizontalBlock(BlockRegistry.PORCELAIN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/porcelain_throne")));
        simpleBlockWithItem(BlockRegistry.POINTS_STORE.get(), new ModelFile.UncheckedModelFile(modLoc("block/points_store")));
        horizontalBlock(BlockRegistry.ROCK_STATUE.get(), new ModelFile.UncheckedModelFile(modLoc("block/rock_statue")));

        blockWithItem(BlockRegistry.BLUE_SAND);
        simpleBlockWithItem(BlockRegistry.BLUE_SANDSTONE.get(), models().cubeBottomTop("blue_sandstone", Utils.loc( "block/blue_sandstone"),
                Utils.loc( "block/blue_sandstone_bottom"), Utils.loc( "block/blue_sandstone_top")));
        simpleBlockWithItem(BlockRegistry.CUT_BLUE_SANDSTONE.get(), models().cubeColumn("cut_blue_sandstone", Utils.loc( "block/cut_blue_sandstone"),
                Utils.loc( "block/blue_sandstone_top")));
        simpleBlockWithItem(BlockRegistry.CHISELED_BLUE_SANDSTONE.get(), models().cubeColumn("chiseled_blue_sandstone", Utils.loc( "block/chiseled_blue_sandstone"),
                Utils.loc( "block/blue_sandstone_top")));
        slabBlock((SlabBlock) BlockRegistry.BLUE_SANDSTONE_SLAB.get(), blockTexture(BlockRegistry.BLUE_SANDSTONE.get()), Utils.loc( "block/blue_sandstone"),
                Utils.loc( "block/blue_sandstone_bottom"), Utils.loc( "block/blue_sandstone_top"));
        stairsBlock((StairBlock) BlockRegistry.BLUE_SANDSTONE_STAIRS.get(), blockTexture(BlockRegistry.BLUE_SANDSTONE.get()), Utils.loc( "block/blue_sandstone_bottom"),
                Utils.loc( "block/blue_sandstone_top"));
        wallBlock((WallBlock) BlockRegistry.BLUE_SANDSTONE_WALL.get(), blockTexture(BlockRegistry.BLUE_SANDSTONE.get()));
        simpleBlockWithItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get(), models().cubeAll("smooth_blue_sandstone", Utils.loc( "block/blue_sandstone_top")));
        slabBlock((SlabBlock) BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), blockTexture(BlockRegistry.CUT_BLUE_SANDSTONE.get()), Utils.loc( "block/cut_blue_sandstone"),
                Utils.loc( "block/blue_sandstone_bottom"), Utils.loc( "block/blue_sandstone_top"));
        slabBlock((SlabBlock) BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(), blockTexture(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get()), Utils.loc( "block/blue_sandstone_top"));
        stairsBlock((StairBlock) BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(), Utils.loc( "block/blue_sandstone_top"));

        leavesBlock(BlockRegistry.HARANO_LEAVES);
        blockWithItem(BlockRegistry.HARANO_PLANKS);
        slabBlock((SlabBlock) BlockRegistry.HARANO_SLAB.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()), Utils.loc( "block/harano_planks"),
                Utils.loc( "block/harano_planks"), Utils.loc( "block/harano_planks"));
        stairsBlock((StairBlock) BlockRegistry.HARANO_STAIRS.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()), Utils.loc( "block/harano_planks"),
                Utils.loc( "block/harano_planks"));
        logBlock((RotatedPillarBlock) BlockRegistry.HARANO_LOG.get());
        saplingBlock(BlockRegistry.HARANO_SAPLING);
        axisBlock((RotatedPillarBlock) BlockRegistry.HARANO_WOOD.get(), models().cubeColumn("harano_wood", Utils.loc( "block/harano_log"), Utils.loc( "block/harano_log")),
                models().cubeColumn("harano_wood", Utils.loc( "block/harano_log"), Utils.loc( "block/harano_log")));
        fenceBlock((FenceBlock) BlockRegistry.HARANO_FENCE.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockRegistry.HARANO_FENCE_GATE.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) BlockRegistry.HARANO_PRESSURE_PLATE.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));
        logBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_HARANO_LOG.get());
        axisBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_HARANO_WOOD.get(), models().cubeColumn("stripped_harano_wood", Utils.loc( "block/stripped_harano_log"), Utils.loc( "block/stripped_harano_log")),
                models().cubeColumn("stripped_harano_wood", Utils.loc( "block/stripped_harano_log"), Utils.loc( "block/stripped_harano_log")));
        doorBlockWithRenderType((DoorBlock) BlockRegistry.HARANO_DOOR.get(), Utils.loc( "block/harano_door_bottom"), Utils.loc( "block/harano_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) BlockRegistry.HARANO_TRAPDOOR.get(), Utils.loc( "block/harano_trapdoor"), true, "cutout");
        buttonBlock((ButtonBlock) BlockRegistry.HARANO_BUTTON.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));

        blockWithItem(BlockRegistry.HARDEN_CRYSTAL_BLOCK);
        blockWithItem(BlockRegistry.PURIFIED_CRYSTAL_BLOCK);
        blockWithItem(BlockRegistry.CHARGED_CRYSTAL_BLOCK);
        blockWithItem(BlockRegistry.FICTIONAL_INGOT_BLOCK);
        blockWithItem(BlockRegistry.GACHI_INGOT_BLOCK);

        leavesBlock(BlockRegistry.FUKAMIZU_PLUM_LEAVES);
        blockWithItem(BlockRegistry.FUKAMIZU_PLUM_PLANKS);
        slabBlock((SlabBlock) BlockRegistry.FUKAMIZU_PLUM_SLAB.get(), blockTexture(BlockRegistry.FUKAMIZU_PLUM_PLANKS.get()), Utils.loc( "block/fukamizu_plum_planks"),
                Utils.loc( "block/fukamizu_plum_planks"), Utils.loc( "block/fukamizu_plum_planks"));
        stairsBlock((StairBlock) BlockRegistry.FUKAMIZU_PLUM_STAIRS.get(), blockTexture(BlockRegistry.FUKAMIZU_PLUM_PLANKS.get()), Utils.loc( "block/fukamizu_plum_planks"),
                Utils.loc( "block/fukamizu_plum_planks"));
        logBlock((RotatedPillarBlock) BlockRegistry.FUKAMIZU_PLUM_LOG.get());
        logBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_FUKAMIZU_PLUM_LOG.get());
        saplingBlock(BlockRegistry.FUKAMIZU_PLUM_SAPLING);
        axisBlock((RotatedPillarBlock) BlockRegistry.FUKAMIZU_PLUM_WOOD.get(), models().cubeColumn("fukamizu_plum_wood", Utils.loc( "block/fukamizu_plum_log"), Utils.loc( "block/fukamizu_plum_log")),
                models().cubeColumn("fukamizu_plum_wood", Utils.loc( "block/fukamizu_plum_log"), Utils.loc( "block/fukamizu_plum_log")));
        axisBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_FUKAMIZU_PLUM_WOOD.get(), models().cubeColumn("stripped_fukamizu_plum_wood", Utils.loc( "block/stripped_fukamizu_plum_log"), Utils.loc( "block/stripped_fukamizu_plum_log")),
                models().cubeColumn("stripped_fukamizu_plum_wood", Utils.loc( "block/stripped_fukamizu_plum_log"), Utils.loc( "block/stripped_fukamizu_plum_log")));
        fenceBlock((FenceBlock) BlockRegistry.FUKAMIZU_PLUM_FENCE.get(), blockTexture(BlockRegistry.FUKAMIZU_PLUM_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockRegistry.FUKAMIZU_PLUM_FENCE_GATE.get(), blockTexture(BlockRegistry.FUKAMIZU_PLUM_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) BlockRegistry.FUKAMIZU_PLUM_PRESSURE_PLATE.get(), blockTexture(BlockRegistry.FUKAMIZU_PLUM_PLANKS.get()));
        buttonBlock((ButtonBlock) BlockRegistry.FUKAMIZU_PLUM_BUTTON.get(), blockTexture(BlockRegistry.FUKAMIZU_PLUM_PLANKS.get()));
//        doorBlockWithRenderType((DoorBlock) BlockRegistry.FUKAMIZU_PLUM_DOOR.get(), Utils.loc( "block/fukamizu_plum_door_bottom"), Utils.loc( "block/fukamizu_plum_door_top"), "cutout");
//        trapdoorBlockWithRenderType((TrapDoorBlock) BlockRegistry.FUKAMIZU_PLUM_TRAPDOOR.get(), Utils.loc( "block/fukamizu_plum_trapdoor"), true, "cutout");

        blockWithItem(BlockRegistry.VERDANT_SPIRIT_RICH_SOIL);

        simpleBlockWithItem(BlockRegistry.FUKAMIZU_MACHINE_CASING.get(), models().cubeColumn("fukamizu_machine_casing", Utils.loc( "block/fukamizu_machine_casing_side"),
                Utils.loc( "block/fukamizu_machine_casing_top")));
        horizontalBlock(BlockRegistry.FUKAMIZU_COMPRESSOR.get(), new ModelFile.UncheckedModelFile(modLoc("block/fukamizu_compressor")));
        horizontalBlock(BlockRegistry.FUKAMIZU_CRUSHER.get(), new ModelFile.UncheckedModelFile(modLoc("block/fukamizu_crusher")));
        blockWithItem(BlockRegistry.LIGHT_BREAD_ENERGY_BLOCK);

        horizontalBlock(BlockRegistry.CRYSTAL_POPPER.get(), new ModelFile.UncheckedModelFile(modLoc("block/crystal_popper")));
        horizontalBlock(BlockRegistry.CRYSTAL_PURIFIER.get(), models().orientableWithBottom("crystal_purifier", Utils.loc("block/crystal_purifier_side"),
                Utils.loc("block/crystal_purifier_front"), Utils.loc("block/crystal_purifier_bottom"), Utils.loc("block/crystal_purifier_top")));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Utils.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
