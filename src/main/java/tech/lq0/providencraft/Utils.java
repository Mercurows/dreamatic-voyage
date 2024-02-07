package tech.lq0.providencraft;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tech.lq0.providencraft.init.*;
import tech.lq0.providencraft.loot.ModLootTables;

@Mod(Utils.MOD_ID)
public class Utils {

    public static final String MOD_ID = "providencraft";

    public static final String PDC_ATTRIBUTE_MODIFIER = "pdc_attribute_modifier";

    public Utils() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        TabRegistry.TABS.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);
        EntityRegistry.ENTITY_TYPES.register(modEventBus);
        SoundRegistry.SOUNDS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(modEventBus);
        EnchantmentRegistry.ENCHANTMENTS.register(modEventBus);
        LootModifierRegistry.register(modEventBus);
        VillagerRegistry.register(modEventBus);
        AttributeRegistry.ATTRIBUTES.register(modEventBus);
        PotionRegistry.POTIONS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        registerForgeEvents();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), Potions.AWKWARD)),
                Ingredient.of(Tags.Items.GLASS), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.BLEEDING.get())));
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.BLEEDING.get())),
                Ingredient.of(ItemRegistry.PAST_SUGAR.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.SUPER_BLEEDING.get())));
    }

    private void registerForgeEvents() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener((LootTableLoadEvent e) -> ModLootTables.lootLoad(e.getName(), b -> e.getTable().addPool(b.build())));
    }
}
