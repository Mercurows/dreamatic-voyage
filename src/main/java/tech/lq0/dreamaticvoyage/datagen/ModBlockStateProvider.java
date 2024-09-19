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
        simpleBlockWithItem(BlockRegistry.COMMUNICATION_TABLE.get(), models().cubeBottomTop("communication_table", new ResourceLocation(Utils.MOD_ID, "block/communication_table_side"),
                new ResourceLocation(Utils.MOD_ID, "block/communication_table_bottom"), new ResourceLocation(Utils.MOD_ID, "block/communication_table_top")));
        horizontalBlock(BlockRegistry.PORCELAIN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/porcelain_throne")));
        simpleBlockWithItem(BlockRegistry.POINTS_STORE.get(), new ModelFile.UncheckedModelFile(modLoc("block/points_store")));
        horizontalBlock(BlockRegistry.ROCK_STATUE.get(), new ModelFile.UncheckedModelFile(modLoc("block/rock_statue")));

        blockWithItem(BlockRegistry.BLUE_SAND);
        simpleBlockWithItem(BlockRegistry.BLUE_SANDSTONE.get(), models().cubeBottomTop("blue_sandstone", new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone"),
                new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_bottom"), new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top")));
        simpleBlockWithItem(BlockRegistry.CUT_BLUE_SANDSTONE.get(), models().cubeColumn("cut_blue_sandstone", new ResourceLocation(Utils.MOD_ID, "block/cut_blue_sandstone"),
                new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top")));
        simpleBlockWithItem(BlockRegistry.CHISELED_BLUE_SANDSTONE.get(), models().cubeColumn("chiseled_blue_sandstone", new ResourceLocation(Utils.MOD_ID, "block/chiseled_blue_sandstone"),
                new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top")));
        slabBlock((SlabBlock) BlockRegistry.BLUE_SANDSTONE_SLAB.get(), blockTexture(BlockRegistry.BLUE_SANDSTONE.get()), new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone"),
                new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_bottom"), new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top"));
        stairsBlock((StairBlock) BlockRegistry.BLUE_SANDSTONE_STAIRS.get(), blockTexture(BlockRegistry.BLUE_SANDSTONE.get()), new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_bottom"),
                new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top"));
        wallBlock((WallBlock) BlockRegistry.BLUE_SANDSTONE_WALL.get(), blockTexture(BlockRegistry.BLUE_SANDSTONE.get()));
        simpleBlockWithItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get(), models().cubeAll("smooth_blue_sandstone", new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top")));
        slabBlock((SlabBlock) BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), blockTexture(BlockRegistry.CUT_BLUE_SANDSTONE.get()), new ResourceLocation(Utils.MOD_ID, "block/cut_blue_sandstone"),
                new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_bottom"), new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top"));
        slabBlock((SlabBlock) BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(), blockTexture(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get()), new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top"));
        stairsBlock((StairBlock) BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(), new ResourceLocation(Utils.MOD_ID, "block/blue_sandstone_top"));

        leavesBlock(BlockRegistry.HARANO_LEAVES);
        blockWithItem(BlockRegistry.HARANO_PLANKS);
        slabBlock((SlabBlock) BlockRegistry.HARANO_SLAB.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()), new ResourceLocation(Utils.MOD_ID, "block/harano_planks"),
                new ResourceLocation(Utils.MOD_ID, "block/harano_planks"), new ResourceLocation(Utils.MOD_ID, "block/harano_planks"));
        stairsBlock((StairBlock) BlockRegistry.HARANO_STAIRS.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()), new ResourceLocation(Utils.MOD_ID, "block/harano_planks"),
                new ResourceLocation(Utils.MOD_ID, "block/harano_planks"));
        logBlock((RotatedPillarBlock) BlockRegistry.HARANO_LOG.get());
        saplingBlock(BlockRegistry.HARANO_SAPLING);
        axisBlock((RotatedPillarBlock) BlockRegistry.HARANO_WOOD.get(), models().cubeColumn("harano_wood", new ResourceLocation(Utils.MOD_ID, "block/harano_log"), new ResourceLocation(Utils.MOD_ID, "block/harano_log")),
                models().cubeColumn("harano_wood", new ResourceLocation(Utils.MOD_ID, "block/harano_log"), new ResourceLocation(Utils.MOD_ID, "block/harano_log")));
        fenceBlock((FenceBlock) BlockRegistry.HARANO_FENCE.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockRegistry.HARANO_FENCE_GATE.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) BlockRegistry.HARANO_PRESSURE_PLATE.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));
        logBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_HARANO_LOG.get());
        axisBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_HARANO_WOOD.get(), models().cubeColumn("stripped_harano_wood", new ResourceLocation(Utils.MOD_ID, "block/stripped_harano_log"), new ResourceLocation(Utils.MOD_ID, "block/stripped_harano_log")),
                models().cubeColumn("stripped_harano_wood", new ResourceLocation(Utils.MOD_ID, "block/stripped_harano_log"), new ResourceLocation(Utils.MOD_ID, "block/stripped_harano_log")));
        doorBlockWithRenderType((DoorBlock) BlockRegistry.HARANO_DOOR.get(), new ResourceLocation(Utils.MOD_ID, "block/harano_door_bottom"), new ResourceLocation(Utils.MOD_ID, "block/harano_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) BlockRegistry.HARANO_TRAPDOOR.get(), new ResourceLocation(Utils.MOD_ID, "block/harano_trapdoor"), true, "cutout");
        buttonBlock((ButtonBlock) BlockRegistry.HARANO_BUTTON.get(), blockTexture(BlockRegistry.HARANO_PLANKS.get()));
        blockWithItem(BlockRegistry.HARDEN_CRYSTAL_BLOCK);
        blockWithItem(BlockRegistry.PURIFIED_CRYSTAL_BLOCK);
        blockWithItem(BlockRegistry.CHARGED_CRYSTAL_BLOCK);
        blockWithItem(BlockRegistry.FICTIONAL_INGOT_BLOCK);
        blockWithItem(BlockRegistry.GACHI_INGOT_BLOCK);

        blockWithItem(BlockRegistry.FUKAMIZU_PLUM_PLANKS);
        logBlock((RotatedPillarBlock) BlockRegistry.FUKAMIZU_PLUM_LOG.get());
        logBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_FUKAMIZU_PLUM_LOG.get());

        blockWithItem(BlockRegistry.VERDANT_SPIRIT_RICH_SOIL);

        simpleBlockWithItem(BlockRegistry.FUKAMIZU_MACHINE_CASING.get(), models().cubeColumn("fukamizu_machine_casing", new ResourceLocation(Utils.MOD_ID, "block/fukamizu_machine_casing_side"),
                new ResourceLocation(Utils.MOD_ID, "block/fukamizu_machine_casing_top")));
        horizontalBlock(BlockRegistry.FUKAMIZU_COMPRESSOR.get(), new ModelFile.UncheckedModelFile(modLoc("block/fukamizu_compressor")));
        horizontalBlock(BlockRegistry.FUKAMIZU_CRUSHER.get(), new ModelFile.UncheckedModelFile(modLoc("block/fukamizu_crusher")));

        horizontalBlock(BlockRegistry.CRYSTAL_POPPER.get(), new ModelFile.UncheckedModelFile(modLoc("block/crystal_popper")));
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
