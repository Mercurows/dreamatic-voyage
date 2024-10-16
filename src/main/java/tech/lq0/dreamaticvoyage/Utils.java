package tech.lq0.dreamaticvoyage;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import tech.lq0.dreamaticvoyage.init.*;
import tech.lq0.dreamaticvoyage.loot.ModLootTables;
import tech.lq0.dreamaticvoyage.network.DmvNetwork;
import tech.lq0.dreamaticvoyage.recipe.ComparableNbtIngredient;

@Mod(Utils.MOD_ID)
public class Utils {

    public static final String MOD_ID = "dreamaticvoyage";

    public static final String MOD_ATTRIBUTE_MODIFIER = "dmv_attribute_modifier";

    public Utils() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        TabRegistry.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);
        EntityRegistry.ENTITY_TYPES.register(modEventBus);
        SoundRegistry.SOUNDS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(modEventBus);
        EnchantmentRegistry.ENCHANTMENTS.register(modEventBus);
        LootModifierRegistry.register(modEventBus);
        VillagerRegistry.register(modEventBus);
        AttributeRegistry.ATTRIBUTES.register(modEventBus);
        PotionRegistry.POTIONS.register(modEventBus);
        ParticleRegistry.PARTICLE_TYPES.register(modEventBus);
        MenuTypeRegistry.MENU_TYPES.register(modEventBus);
        VoyageEventRegistry.EVENTS.register(modEventBus);
        FluidRegistry.register(modEventBus);
        RecipeRegistry.RECIPE_SERIALIZERS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerSerializers);
        MinecraftForge.EVENT_BUS.register(this);

        registerForgeEvents();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), Potions.AWKWARD)),
                Ingredient.of(Tags.Items.GLASS), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.BLEEDING.get())));
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.BLEEDING.get())),
                Ingredient.of(ItemRegistry.PAST_SUGAR.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.SUPER_BLEEDING.get())));
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(ItemRegistry.LUCIA_RICE_CAKE.get()), new ItemStack(ItemRegistry.BIG_MOE_ONE_POTION.get())));
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_POISON)),
                Ingredient.of(ItemRegistry.GARLIC_MELON_SLICE.get()), new ItemStack(Items.DRAGON_BREATH)));
        event.enqueueWork(this::registerCompostableItems);

        DmvNetwork.init();
    }

    private void registerSerializers(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS,
                helper -> CraftingHelper.register(loc("comparable"), ComparableNbtIngredient.Serializer.INSTANCE)
        );
    }

    private void registerCompostableItems() {
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.HARANO_SAPLING.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.HARANO_LEAVES.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.FUKAMIZU_PLUM_SAPLING.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.FUKAMIZU_PLUM_LEAVES.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.UNI_MILLET.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.FUKAMIZU_PLUM.get(), 0.3f);
    }

    private void registerForgeEvents() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener((LootTableLoadEvent e) -> ModLootTables.lootLoad(e.getName(), b -> e.getTable().addPool(b.build())));
    }

    public static ResourceLocation loc(String path) {
        return new ResourceLocation(Utils.MOD_ID, path);
    }
}
