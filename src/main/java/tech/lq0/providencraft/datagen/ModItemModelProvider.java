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
        //1st
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


        simpleItem(ItemRegistry.BANANA_MILK);

        simpleItem(ItemRegistry.BROWNIE_UZZA);

        simpleItem(ItemRegistry.DARK_ELF_CORE);
        simpleItem(ItemRegistry.DRILL);
        simpleItem(ItemRegistry.SCHEDULE);

        simpleItem(ItemRegistry.TARO_ICE_CREAM);
        simpleItem(ItemRegistry.UNIGIRI);
        simpleItem(ItemRegistry.ENCHANTED_UNIGIRI);
        simpleItem(ItemRegistry.ELF_WINGS);

        //2nd
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
        simpleItem(ItemRegistry.ISEKAI_LOLLIPOP);
        simpleItem(ItemRegistry.PAST_SUGAR);
        simpleItem(ItemRegistry.SATOU_CHESTPLATE);

        simpleItem(ItemRegistry.AYELET_MASK);
        simpleItem(ItemRegistry.MUMU_STEAK);

        //mc
        simpleItem(ItemRegistry.FLAT_VEGETABLE_CHESTPLATE);
        simpleItem(ItemRegistry.STEEL_PLATE);
        simpleItem(ItemRegistry.LOTUS_POTATO);
//        simpleItem(ItemRegistry.CHIRAM_LANTERN);
        simpleItem(ItemRegistry.BREEZE_CROWN);
        simpleItem(ItemRegistry.CHIRAM_CORE);
//        simpleItem(ItemRegistry.MAGIC_TEAPOT);

        simpleItem(ItemRegistry.MARSHAIMALLOW);
        simpleItem(ItemRegistry.CLOUD_KEY);
        simpleItem(ItemRegistry.CURSED_MARSHAIMALLOW);
        simpleItem(ItemRegistry.MISTY_CHESTPLATE);
        simpleItem(ItemRegistry.HAINE_CORE);
        simpleItem(ItemRegistry.HAIBARA_SOUP);

        simpleItem(ItemRegistry.FROG_LEG);
        simpleItem(ItemRegistry.FROGGY_LEGGINGS);
        simpleItem(ItemRegistry.KERORO_CORE);
        simpleItem(ItemRegistry.LEMON_TEA);
        simpleItem(ItemRegistry.LARGE_LEMON_TEA);

        simpleItem(ItemRegistry.EKIRA_PEARL);
        simpleItem(ItemRegistry.CELESTIAL_BOOTS);
        simpleItem(ItemRegistry.EKIRA_CORE);

        //3rd


        //oi


        simpleItem(ItemRegistry.CHOCOLATE_BOOTS);


        //4th
        simpleItem(ItemRegistry.STRAWBERRY_CAKE);
        simpleItem(ItemRegistry.CHOCOAL_COOKIE);

        simpleItem(ItemRegistry.SHAKANA);


        //cnt


        //others
        simpleItem(ItemRegistry.MMA_STEW);
        simpleItem(ItemRegistry.MVA_STEW);
        simpleItem(ItemRegistry.PDC_POINT);
        simpleItem(ItemRegistry.PREMIUM_PDC_POINT);
        simpleItem(ItemRegistry.CHAOS_CHECKER);
        simpleItem(ItemRegistry.ESCORT_TOKEN);

        //legacy
        simpleItem(ItemRegistry.YAGI_STAFF_CARD);
        simpleItem(ItemRegistry.LAVA_CAKE);


        //material
        simpleItem(ItemRegistry.IDOL_CLOTH);
        simpleItem(ItemRegistry.GN_SOUL);
        simpleItem(ItemRegistry.GN_SPIRIT);
        simpleItem(ItemRegistry.GN_STAR);
        simpleItem(ItemRegistry.MAGICROS_CORE);
        simpleItem(ItemRegistry.DREAM_WEAVING_YARN);
        simpleItem(ItemRegistry.DARK_CRYSTAL);
        simpleItem(ItemRegistry.RADIANT_CRYSTAL);
        simpleItem(ItemRegistry.ILLUSORY_CRYSTAL);
        simpleItem(ItemRegistry.SINK_CRYSTAL);
        simpleItem(ItemRegistry.ALIENIS_CRYSTAL);
        simpleItem(ItemRegistry.TERMINAL_CRYSTAL);

        //donate


        //costume
        simpleItem(ItemRegistry.CHIRAM_IDOL_HELMET);
        simpleItem(ItemRegistry.CHIRAM_IDOL_CHESTPLATE);
        simpleItem(ItemRegistry.CHIRAM_IDOL_BOOTS);
        simpleItem(ItemRegistry.HAINE_IDOL_HELMET);
        simpleItem(ItemRegistry.HAINE_IDOL_CHESTPLATE);
        simpleItem(ItemRegistry.HAINE_IDOL_BOOTS);
        simpleItem(ItemRegistry.KERORO_IDOL_HELMET);
        simpleItem(ItemRegistry.KERORO_IDOL_CHESTPLATE);
        simpleItem(ItemRegistry.KERORO_IDOL_BOOTS);
        simpleItem(ItemRegistry.EKIRA_IDOL_HELMET);
        simpleItem(ItemRegistry.EKIRA_IDOL_CHESTPLATE);
        simpleItem(ItemRegistry.EKIRA_IDOL_BOOTS);


        //blocks
        evenSimplerBlockItem(BlockRegistry.PORCELAIN_THRONE);
        evenSimplerBlockItem(BlockRegistry.BLUE_SANDSTONE_SLAB);
        evenSimplerBlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB);
        evenSimplerBlockItem(BlockRegistry.CUT_BLUE_SANDSTONE_SLAB);
        wallItem(BlockRegistry.BLUE_SANDSTONE_WALL, BlockRegistry.BLUE_SANDSTONE);
        evenSimplerBlockItem(BlockRegistry.BLUE_SANDSTONE_STAIRS);
        evenSimplerBlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID, "item/" + item.getId().getPath()));
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
                .texture("texture", new ResourceLocation(Utils.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Utils.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(Utils.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID, "block/" + item.getId().getPath()));
    }
}