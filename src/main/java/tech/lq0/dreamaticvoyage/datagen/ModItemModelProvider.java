package tech.lq0.dreamaticvoyage.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.BlockRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;

@SuppressWarnings({"ConstantConditions", "UnusedReturnValue", "SameParameterValue", "unused"})
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Utils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // 1st
        simpleItem(ItemRegistry.RED_AHOGE);
        handheldItem(ItemRegistry.RED_AHOGE_SWORD);
        handheldItem(ItemRegistry.RED_AHOGE_BOOMERANG);
        simpleItem(ItemRegistry.RED_AHOGE_HELMET);
        simpleItem(ItemRegistry.PEACH_BEACH);
        simpleItem(ItemRegistry.SNEAKERS);
        simpleItem(ItemRegistry.ROCK_STATUE);

        simpleItem(ItemRegistry.CRYSTAL_HORN);
        simpleItem(ItemRegistry.SLEEP_ROULETTE);

        simpleItem(ItemRegistry.MARI_STEW);
        simpleItem(ItemRegistry.MAGIC_MIRROR);

        simpleItem(ItemRegistry.LUNAR_CROSS);
        simpleItem(ItemRegistry.MITSUKI_CROWN);

        simpleItem(ItemRegistry.BANANA_MILK);

        simpleItem(ItemRegistry.KURUMI_HALO);
        simpleItem(ItemRegistry.BROWNIE_UZZA);

        simpleItem(ItemRegistry.DARK_ELF_CORE);
        simpleItem(ItemRegistry.DRILL);
        simpleItem(ItemRegistry.SCHEDULE);
        simpleItem(ItemRegistry.DARK_ELF_GLASSES);

        simpleItem(ItemRegistry.TARO_ICE_CREAM);
        simpleItem(ItemRegistry.UNIGIRI);
        simpleItem(ItemRegistry.ENCHANTED_UNIGIRI);
        simpleItem(ItemRegistry.ELF_WINGS);

        // 2nd
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
        simpleItem(ItemRegistry.KULEBOH);
        simpleItem(ItemRegistry.KULECIABOH);
        simpleItem(ItemRegistry.TURBULENCE_AMBER);
        simpleItem(ItemRegistry.SPATIOTEMPORAL_DEVICE);

        handheldItem(ItemRegistry.SATOU_KNIFE);
        simpleItem(ItemRegistry.ISEKAI_LOLLIPOP);
        simpleItem(ItemRegistry.PAST_SUGAR);
        simpleItem(ItemRegistry.SATOU_CHESTPLATE);

        simpleItem(ItemRegistry.AYELET_MASK);
        simpleItem(ItemRegistry.MUMU_STEAK);
        simpleItem(ItemRegistry.MUSHROOM_CROISSANT);

        // magicros
        simpleItem(ItemRegistry.FLAT_VEGETABLE_CHESTPLATE);
        simpleItem(ItemRegistry.STEEL_PLATE);
        simpleItem(ItemRegistry.LOTUS_POTATO);
        simpleItem(ItemRegistry.CHIRAM_LANTERN);
        simpleItem(ItemRegistry.BREEZE_CROWN);
        simpleItem(ItemRegistry.CHIRAM_CORE);
        simpleItem(ItemRegistry.MAGIC_TEAPOT);
        simpleItem(ItemRegistry.CHIRAM_HAT);
        simpleItem(ItemRegistry.BOWL_OF_VEGETABLE);

        simpleItem(ItemRegistry.MARSHAIMALLOW);
        simpleItem(ItemRegistry.CLOUD_KEY);
        simpleItem(ItemRegistry.CURSED_MARSHAIMALLOW);
        simpleItem(ItemRegistry.MISTY_CHESTPLATE);
        simpleItem(ItemRegistry.HAINE_CORE);
        simpleItem(ItemRegistry.HAIBARA_SOUP);

        simpleItem(ItemRegistry.RED_NOSE);
        simpleItem(ItemRegistry.FROG_LEG);
        simpleItem(ItemRegistry.FROG_CROWN);
        simpleItem(ItemRegistry.FROGGY_LEGGINGS);
        simpleItem(ItemRegistry.KERORO_CORE);
        simpleItem(ItemRegistry.LEMON_TEA);
        simpleItem(ItemRegistry.LARGE_LEMON_TEA);

        simpleItem(ItemRegistry.CRYSTAL_BALL);
        simpleItem(ItemRegistry.ENCHANTED_CRYSTAL_BALL);
        simpleItem(ItemRegistry.SUCCUBUS_TAIL);
        simpleItem(ItemRegistry.EKIRA_PEARL);
        simpleItem(ItemRegistry.BUBBLE_TEA);
        simpleItem(ItemRegistry.CELESTIAL_BOOTS);
        simpleItem(ItemRegistry.EKIRA_CORE);

        // 3rd
        simpleItem(ItemRegistry.HIRU_HEAD);
        simpleItem(ItemRegistry.HIRENADE_GG);
        simpleItem(ItemRegistry.WITHER_BOUQUET);
        simpleItem(ItemRegistry.HIRU_TENTACLES);
        simpleItem(ItemRegistry.GN_SOUL);
        simpleItem(ItemRegistry.GN_SPIRIT);
        simpleItem(ItemRegistry.GN_STAR);

        simpleItem(ItemRegistry.REINA_WINGS);
        simpleItem(ItemRegistry.REINA_FEATHER);
        simpleItem(ItemRegistry.LECIEL_EAR_COVERTS);

        simpleItem(ItemRegistry.FOX_ICE_CREAM);
        simpleItem(ItemRegistry.FOX_PUDDING);

        // oi
        simpleItem(ItemRegistry.MOMO_DAIFUKU);
        handheldItem(ItemRegistry.FETUOZI);
        simpleItem(ItemRegistry.MOMO_BANDAGE);
        simpleItem(ItemRegistry.CHOCOLATE_BOOTS);

        simpleItem(ItemRegistry.LUNATIC_BOW);
        simpleItem(ItemRegistry.MOON_CAKE);

        simpleItem(ItemRegistry.JELLYFISH_SHELL);
        simpleItem(ItemRegistry.ARTIST_TOOL_BELT);

        simpleItem(ItemRegistry.GRAVITY_RESTRAINT_DEVICE);

        simpleItem(ItemRegistry.BUTTERFLY_ANKLET);

        simpleItem(ItemRegistry.RABBIT_LYCHEE);

        simpleItem(ItemRegistry.OCEAN_DESTINY);
        simpleItem(ItemRegistry.FRACTURE_DESTINY);
        simpleItem(ItemRegistry.FUKAMIZU_FISH);
        simpleItem(ItemRegistry.FUKAMIZU_BREAD);
        simpleItem(ItemRegistry.GARLIC_MELON_SLICE);
        simpleItem(ItemRegistry.CAGE_RING);
        simpleItem(ItemRegistry.FUKAMIZU_BREAD_INGOT);
        simpleItem(ItemRegistry.HQSS_BREAD_INGOT);
        simpleItem(ItemRegistry.HEAVY_BREAD_COMPONENT);

        simpleItem(ItemRegistry.MINT_CHOCOLATE);
        simpleItem(ItemRegistry.YEGGY_PEARL);

        simpleItem(ItemRegistry.XIAOLONGBAO);

        handheldItem(ItemRegistry.SHU_RINO_KEN);
        simpleItem(ItemRegistry.CLARITY_AMULET);

        simpleItem(ItemRegistry.CRAFT_BEER_0322);

        // 4th
        simpleItem(ItemRegistry.STRAWBERRY_CAKE);
        simpleItem(ItemRegistry.CHOCOAL_COOKIE);
        simpleItem(ItemRegistry.UNTOUCHABLE_LOVE);
        simpleItem(ItemRegistry.STRAWBERRY_CHOCOLATE);
        simpleItem(ItemRegistry.ACTIVATED_CREAM);

        simpleItem(ItemRegistry.JELLYFISH_BOTTLE, "translucent");
        simpleItem(ItemRegistry.SHAKANA);

        handheldItem(ItemRegistry.OMINOUS_BONE);

        // cnt
        handheldItem(ItemRegistry.QIANYUN_HOE);
        simpleItem(ItemRegistry.QIANKELA);

        // others
        simpleItem(ItemRegistry.MMA_STEW);
        simpleItem(ItemRegistry.MVA_STEW);
        simpleItem(ItemRegistry.PDC_POINT);
        simpleItem(ItemRegistry.PREMIUM_PDC_POINT);
        simpleItem(ItemRegistry.CHAOS_CHECKER);
        simpleItem(ItemRegistry.FALLEN_RING);
        simpleItem(ItemRegistry.ESCORT_TOKEN);
        handheldItem(ItemRegistry.ANCIENT_MICROPHONE);
        simpleItem(ItemRegistry.FICTIONAL_FORGING_SIGIL);
        simpleItem(ItemRegistry.CRYSTAL_POPCORN);
        simpleItem(ItemRegistry.CRYSTAL_PENDANT);

        // dream guardian
        simpleItem(ItemRegistry.DG_SHIRAKO);
        simpleItem(ItemRegistry.DG_YORUNE);
        simpleItem(ItemRegistry.DG_LEAH);
        simpleItem(ItemRegistry.DG_HURRIC);
        simpleItem(ItemRegistry.DG_KURIKO);

        // fukamizu tech
        handheldItem(ItemRegistry.FUKAMIZU_BREAD_AXE);
        handheldItem(ItemRegistry.FUKAMIZU_BREAD_HOE);
        handheldItem(ItemRegistry.FUKAMIZU_BREAD_SHOVEL);
        handheldItem(ItemRegistry.FUKAMIZU_BREAD_PICKAXE);
        handheldItem(ItemRegistry.FUKAMIZU_BREAD_SWORD);
        simpleItem(ItemRegistry.SWOLLEN_FUKAMIZU_BREAD_INGOT);
        simpleItem(ItemRegistry.MINERALIZED_FUKAMIZU_BREAD);
        simpleItem(ItemRegistry.FUKAMIZU_BREAD_HELMET);
        simpleItem(ItemRegistry.FUKAMIZU_BREAD_CHESTPLATE);
        simpleItem(ItemRegistry.FUKAMIZU_BREAD_LEGGINGS);
        simpleItem(ItemRegistry.FUKAMIZU_BREAD_BOOTS);
        handheldItem(ItemRegistry.FUKAMIZU_BREAD_SHEARS);

        simpleItem(ItemRegistry.FUKAMIZU_KWAS_BUCKET);

        simpleItem(ItemRegistry.FUKAMIZU_CRUMB);
        simpleItem(ItemRegistry.IRON_RICH_CRUMB);
        simpleItem(ItemRegistry.GOLD_RICH_CRUMB);
        simpleItem(ItemRegistry.COPPER_RICH_CRUMB);

        // legacy
        simpleItem(ItemRegistry.FLUFF_BALL);
        simpleItem(ItemRegistry.YAGI_STAFF_CARD);
        simpleItem(ItemRegistry.LAVA_CAKE);

        // material
        simpleItem(ItemRegistry.IDOL_CLOTH);
        simpleItem(ItemRegistry.MAGICROS_CORE);
        simpleItem(ItemRegistry.DREAM_WEAVING_YARN);
        simpleItem(ItemRegistry.DARK_CRYSTAL);
        simpleItem(ItemRegistry.RADIANT_CRYSTAL);
        simpleItem(ItemRegistry.ILLUSORY_CRYSTAL);
        simpleItem(ItemRegistry.SINK_CRYSTAL);
        simpleItem(ItemRegistry.ALIENIS_CRYSTAL);
        simpleItem(ItemRegistry.TERMINAL_CRYSTAL);
        simpleItem(ItemRegistry.CRYSTAL_POWDER);
        simpleItem(ItemRegistry.PURIFIED_CRYSTAL_POWDER);
        simpleItem(ItemRegistry.CHARGED_CRYSTAL_POWDER);
        simpleItem(ItemRegistry.HARDEN_CRYSTAL_INGOT);
        simpleItem(ItemRegistry.PURIFIED_CRYSTAL_INGOT);
        simpleItem(ItemRegistry.CHARGED_CRYSTAL_INGOT);
        simpleItem(ItemRegistry.FICTIONAL_INGOT);
        simpleItem(ItemRegistry.FICTIONAL_NUGGET);
        simpleItem(ItemRegistry.GACHI_INGOT);
        simpleItem(ItemRegistry.GACHI_NUGGET);
        simpleItem(ItemRegistry.FUKAMIZU_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ItemRegistry.MIRACLE_CORE);
        simpleItem(ItemRegistry.EARTH_DEBRIS);
        simpleItem(ItemRegistry.PHANTASM_FUEL);

        // donate
        simpleItem(ItemRegistry.LITTLE_POTATO);
        simpleItem(ItemRegistry.LOLLIPOP);
        simpleItem(ItemRegistry.BLACK_EARPHONES);
        simpleItem(ItemRegistry.ORANGE_TRACKER);
        simpleItem(ItemRegistry.EMERGENCY_ENGINE_POWER);
        simpleItem(ItemRegistry.MUSIC_DISC_SONG_OF_AUTUMN);
        simpleItem(ItemRegistry.LEAH_PAD);
        simpleItem(ItemRegistry.BAKED_NAME_TAG);
        simpleItem(ItemRegistry.SAKURA_BEAN_CURD);

        // costume
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
        simpleItem(ItemRegistry.KRM_963_53);
        simpleItem(ItemRegistry.MAID_COSTUME);

        // blocks
        evenSimplerBlockItem(BlockRegistry.PORCELAIN_THRONE);
        evenSimplerBlockItem(BlockRegistry.BLUE_SANDSTONE_SLAB);
        evenSimplerBlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB);
        evenSimplerBlockItem(BlockRegistry.CUT_BLUE_SANDSTONE_SLAB);
        wallItem(BlockRegistry.BLUE_SANDSTONE_WALL, BlockRegistry.BLUE_SANDSTONE);
        evenSimplerBlockItem(BlockRegistry.BLUE_SANDSTONE_STAIRS);
        evenSimplerBlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS);

        evenSimplerBlockItem(BlockRegistry.HARANO_SLAB);
        evenSimplerBlockItem(BlockRegistry.HARANO_STAIRS);
        evenSimplerBlockItem(BlockRegistry.HARANO_LOG);
        evenSimplerBlockItem(BlockRegistry.HARANO_WOOD);
        fenceItem(BlockRegistry.HARANO_FENCE, BlockRegistry.HARANO_PLANKS);
        evenSimplerBlockItem(BlockRegistry.HARANO_FENCE_GATE);
        evenSimplerBlockItem(BlockRegistry.HARANO_PRESSURE_PLATE);
        evenSimplerBlockItem(BlockRegistry.STRIPPED_HARANO_LOG);
        evenSimplerBlockItem(BlockRegistry.STRIPPED_HARANO_WOOD);
        simpleItem(ItemRegistry.HARANO_DOOR);
        trapdoorItem(BlockRegistry.HARANO_TRAPDOOR);
        buttonItem(BlockRegistry.HARANO_BUTTON, BlockRegistry.HARANO_PLANKS);

        evenSimplerBlockItem(BlockRegistry.FUKAMIZU_COMPRESSOR);

        evenSimplerBlockItem(BlockRegistry.CRYSTAL_POPPER);

        // audio
        audioTapeItem(ItemRegistry.AUDIO_TAPE_HAINE_1, Livers.HAINE);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_HAINE_2, Livers.HAINE);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_HAINE_3, Livers.HAINE);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_CHIRAM_1, Livers.CHIRAM);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_CHIRAM_2, Livers.CHIRAM);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_CHIRAM_3, Livers.CHIRAM);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_EKIRA_1, Livers.EKIRA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_EKIRA_2, Livers.EKIRA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_EKIRA_3, Livers.EKIRA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_KERORO_1, Livers.KERORO);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_KERORO_2, Livers.KERORO);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_KERORO_3, Livers.KERORO);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_FUKAMIZU_1, Livers.FUKAMIZU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_FUKAMIZU_2, Livers.FUKAMIZU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_FUKAMIZU_3, Livers.FUKAMIZU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_FUKAMIZU_4, Livers.FUKAMIZU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_FUKAMIZU_5, Livers.FUKAMIZU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_FUKAMIZU_6, Livers.FUKAMIZU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_LOUISE_1, Livers.LOUISE);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_LOUISE_2, Livers.LOUISE);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_LOUISE_3, Livers.LOUISE);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_MADOKA_1, Livers.MADOKA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_MADOKA_2, Livers.MADOKA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_MADOKA_3, Livers.MADOKA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_MUMU_1, Livers.MUMU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_MUMU_2, Livers.MUMU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_MUMU_3, Livers.MUMU);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_QIANYUN_1, Livers.QIANYUN);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_QIANYUN_2, Livers.QIANYUN);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_QIANYUN_3, Livers.QIANYUN);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_UNIA_1, Livers.UNIA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_UNIA_2, Livers.UNIA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_UNIA_3, Livers.UNIA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_USA_1, Livers.USA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_USA_2, Livers.USA);
        audioTapeItem(ItemRegistry.AUDIO_TAPE_USA_3, Livers.USA);

        simpleItem(ItemRegistry.MUSIC_DISC_DARAKUDATENSHI);
        simpleItem(ItemRegistry.MUSIC_DISC_AROUND_THE_TRAVEL);
        simpleItem(ItemRegistry.MUSIC_DISC_SONG_OF_QINGQIU);
        simpleItem(ItemRegistry.MUSIC_DISC_DREAMING_FAIRY);
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

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String renderType) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID, "item/" + item.getId().getPath())).renderType(renderType);
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

    private ItemModelBuilder audioTapeItem(RegistryObject<Item> item, Livers livers) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Utils.MOD_ID, "item/" + "audio_tape_" + livers.getName()));
    }
}
