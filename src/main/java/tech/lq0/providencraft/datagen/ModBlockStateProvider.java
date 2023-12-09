package tech.lq0.providencraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.BlockRegistry;

@SuppressWarnings("ConstantConditions")
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Utils.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.RED_AHOGE_BLOCK);
        blockWithItem(BlockRegistry.WHITE_AHOGE_BLOCK);
        blockWithItem(BlockRegistry.FUKAMIZU_BREAD_BLOCK);
        simpleBlockWithItem(BlockRegistry.COMMUNICATION_TABLE.get(), models().cube("communication_table",
                new ResourceLocation(Utils.MOD_ID, "block/communication_table_underside"), new ResourceLocation(Utils.MOD_ID, "block/communication_table_top"),
                new ResourceLocation(Utils.MOD_ID, "block/communication_table_side"), new ResourceLocation(Utils.MOD_ID, "block/communication_table_side"),
                new ResourceLocation(Utils.MOD_ID, "block/communication_table_side"), new ResourceLocation(Utils.MOD_ID, "block/communication_table_side")));

        blockWithItem(BlockRegistry.BLUE_SAND);

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
