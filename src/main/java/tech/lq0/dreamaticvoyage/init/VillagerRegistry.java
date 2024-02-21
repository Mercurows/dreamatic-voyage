package tech.lq0.dreamaticvoyage.init;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;

import java.util.List;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class VillagerRegistry {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Utils.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Utils.MOD_ID);

    public static final RegistryObject<PoiType> ELIFAUS_POI = POI_TYPES.register("elifaus",
            () -> new PoiType(ImmutableSet.copyOf(BlockRegistry.PORCELAIN_THRONE.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<PoiType> RUOZHI_POI = POI_TYPES.register("ruozhi",
            () -> new PoiType(ImmutableSet.copyOf(BlockRegistry.COMMUNICATION_TABLE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> ELIFAUS = VILLAGER_PROFESSIONS.register("elifaus",
            () -> new VillagerProfession("elifaus", holder -> holder.get() == ELIFAUS_POI.get(), holder -> holder.get() == ELIFAUS_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), null));
    public static final RegistryObject<VillagerProfession> RUOZHI = VILLAGER_PROFESSIONS.register("ruozhi",
            () -> new VillagerProfession("ruozhi", holder -> holder.get() == RUOZHI_POI.get(), holder -> holder.get() == RUOZHI_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), null));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerRegistry.ELIFAUS.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ItemRegistry.RED_AHOGE.get(), 5),
                    new ItemStack(Items.EMERALD, 1), 10, 2, 0.05f)));
            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ItemRegistry.WHITE_AHOGE.get(), 5),
                    new ItemStack(Items.EMERALD, 1), 10, 2, 0.05f)));
            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.APPLE, 4), 10, 2, 0.05f)));

            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ItemRegistry.LUCIA_RICE_CAKE.get(), 5), 12, 4, 0.05f)));
            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4),
                    new ItemStack(Items.CAKE, 1), 3, 12, 0.05f)));
            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.SNOW_BLOCK, 32),
                    new ItemStack(Items.EMERALD, 1), 8, 2, 0.05f)));

            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 50),
                    new ItemStack(Items.SADDLE, 1), 2, 25, 0.05f)));
            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ItemRegistry.CRYSTAL_POWDER.get(), 1),
                    new ItemStack(Items.EMERALD, 1), 64, 1, 0.05f)));
            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ItemRegistry.BROWNIE_UZZA.get(), 2),
                    new ItemStack(Items.EMERALD, 1), 32, 8, 0.05f)));

//            trades.get(4).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 20),
//                    new ItemStack(ItemRegistry.PLUNGER.get(), 1), 5, 10, 0.05f)));
            trades.get(4).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.BONE_MEAL, 42), 4, 2, 0.05f)));
            trades.get(4).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.COMPOSTER, 10),
                    new ItemStack(Items.EMERALD, 1), 10, 2, 0.05f)));

            trades.get(5).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ItemRegistry.LAVA_CAKE.get(), 1),
                    new ItemStack(Items.EMERALD, 1), 2, 15, 0.05f)));
            trades.get(5).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ItemRegistry.UNI_MILLET.get(), 18),
                    new ItemStack(Items.EMERALD, 1), 20, 2, 0.05f)));
        }
        if (event.getType() == VillagerRegistry.RUOZHI.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.IRON_INGOT, 6),
                    new ItemStack(Items.EMERALD, 1), 10, 3, 0.05f)));
            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Blocks.PUMPKIN.asItem(), 8),
                    new ItemStack(Items.EMERALD, 1), 10, 5, 0.05f)));
            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5),
                    new ItemStack(Items.PUMPKIN_PIE, 2), 12, 5, 0.05f)));

            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.REDSTONE, 15),
                    new ItemStack(Items.EMERALD, 1), 10, 5, 0.05f)));
            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2),
                    new ItemStack(Items.STICKY_PISTON, 3), 12, 5, 0.05f)));
            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.UNI_MILLET.get(), 4), 10, 5, 0.05f)));

            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.SALMON, 20),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f)));
            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ItemRegistry.PORCELAIN_THRONE.get(), 3), 12, 10, 0.05f)));
            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ItemRegistry.BANANA_MILK.get(), 3), 20, 6, 0.05f)));

            trades.get(4).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.SMOOTH_STONE, 10),
                    new ItemStack(Items.EMERALD, 1), 30, 1, 0.05f)));
            trades.get(4).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.FROG_LEG.get(), 2), 12, 3, 0.05f)));

            trades.get(5).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 50),
                    new ItemStack(ItemRegistry.ELECTRIC_HORN.get(), 1), 1, 35, 0.05f)));
            trades.get(5).add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ItemRegistry.TARO_ICE_CREAM.get(), 1), 16, 5, 0.05f)));
        }
    }

    @SubscribeEvent
    public static void addWandererTrade(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add(((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5),
                new ItemStack(ItemRegistry.HARANO_SAPLING.get(), 1), 12, 0, 0.15f)));
    }
}
