package tech.lq0.providencraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.BlockRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

@SuppressWarnings({"ConstantConditions", "UnusedReturnValue"})
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Utils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.RED_AHOGE);
        handheldItem(ItemRegistry.RED_AHOGE_SWORD);
        handheldItem(ItemRegistry.RED_AHOGE_BOOMERANG);
        simpleItem(ItemRegistry.RED_AHOGE_HELMET);
        simpleItem(ItemRegistry.PEACH_BEACH);
        simpleItem(ItemRegistry.SNEAKERS);

        simpleItem(ItemRegistry.CRYSTAL_HORN);
        simpleItem(ItemRegistry.SLEEP_ROULETTE);

        simpleItem(ItemRegistry.MARI_STEW);
        simpleItem(ItemRegistry.MAGIC_MIRROR);


        simpleItem(ItemRegistry.BROWNIE_UZZA);

        simpleItem(ItemRegistry.DARK_ELF_CORE);
        simpleItem(ItemRegistry.DRILL);
        simpleItem(ItemRegistry.SCHEDULE);

        simpleItem(ItemRegistry.TARO_ICE_CREAM);
        simpleItem(ItemRegistry.UNIGIRI);
        simpleItem(ItemRegistry.ENCHANTED_UNIGIRI);
        simpleItem(ItemRegistry.ELF_WINGS);

        simpleItem(ItemRegistry.LUCIA_RICE_CAKE);
        simpleItem(ItemRegistry.BIG_MOE_ONE_POTION);
        simpleItem(ItemRegistry.MOONLIGHT_AMULET);
        simpleItem(ItemRegistry.BIG_FIERCE_ONE_COFFEE);

        simpleItem(ItemRegistry.WHITE_AHOGE);
        simpleItem(ItemRegistry.WHITE_DOUBLE_AHOGE);
        simpleItem(ItemRegistry.MAGIC_BOOK);
        simpleItem(ItemRegistry.MAGIC_BOOK_MYANNA);
        simpleItem(ItemRegistry.MAGIC_BOOK_MYANNA_PLUS);
        simpleItem(ItemRegistry.MAGIC_BOOK_THROW);
        simpleItem(ItemRegistry.MAGIC_BOOK_REVELATION);
        simpleItem(ItemRegistry.LOUISTEW);
        simpleItem(ItemRegistry.UNI_MILLET);

        simpleItem(ItemRegistry.MECHANICAL_HORN);

        handheldItem(ItemRegistry.SATOU_KNIFE);
        simpleItem(ItemRegistry.SATOU_CHESTPLATE);


        evenSimplerBlockItem(BlockRegistry.PORCELAIN_THRONE);
        evenSimplerBlockItem(BlockRegistry.BLUE_SANDSTONE_SLAB);
        evenSimplerBlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB);
        evenSimplerBlockItem(BlockRegistry.CUT_BLUE_SANDSTONE_SLAB);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Utils.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Utils.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Utils.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Utils.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID,"block/" + item.getId().getPath()));
    }
}
