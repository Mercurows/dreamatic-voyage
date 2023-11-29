package tech.lq0.providencraft.init;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;

import java.util.List;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class VillagerRegistry {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Utils.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Utils.MOD_ID);

    public static final RegistryObject<PoiType> ELIFAUS_POI = POI_TYPES.register("elifaus",
            () -> new PoiType(ImmutableSet.copyOf(BlockRegistry.PORCELAIN_THRONE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> ELIFAUS = VILLAGER_PROFESSIONS.register("elifaus",
            () -> new VillagerProfession("elifaus", holder -> holder.get() == ELIFAUS_POI.get(), holder -> holder.get() == ELIFAUS_POI.get(),
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

        }
    }



//    public static void fillTradeData() {
//        VillagerTrades.ITrade[] elifausLevel1 = new VillagerTrades.ITrade[]{
//                new EmeraldForItemsTrade(ItemRegistry.RED_AHOGE.get(), 5, 10, 2),
//                new EmeraldForItemsTrade(ItemRegistry.WHITE_AHOGE.get(), 5, 10, 2),
//                new ItemsForEmeraldsTrade(Items.APPLE, 1, 4, 10, 2)
//        };
//        VillagerTrades.ITrade[] elifausLevel2 = new VillagerTrades.ITrade[]{
//                new ItemsForEmeraldsTrade(ItemRegistry.LUCIA_RICE_CAKE.get(), 2, 5, 12, 4),
//                new ItemsForEmeraldsTrade(Items.CAKE, 4, 1, 3,12),
//                new EmeraldForItemsTrade(Items.SNOW_BLOCK, 32, 8, 2)
//        };
//        VillagerTrades.ITrade[] elifausLevel3 = new VillagerTrades.ITrade[]{
//                new ItemsForEmeraldsTrade(Items.SADDLE, 50, 1, 2, 25),
//                new EmeraldForItemsTrade(ItemRegistry.MAGIC_BOOK.get(), 1, 10, 4),
//                new EmeraldForItemsTrade(ItemRegistry.BROWNIE_UZZA.get(), 2, 32, 8)
//        };
//        VillagerTrades.ITrade[] elifausLevel4 = new VillagerTrades.ITrade[]{
//                new ItemsForEmeraldsTrade(ItemRegistry.PLUNGER.get(), 20, 1, 5, 10),
//                new ItemsForEmeraldsTrade(Items.BONE_MEAL, 1, 42, 4, 2),
//                new EmeraldForItemsTrade(Items.COMPOSTER, 10, 10, 2)
//        };
//        VillagerTrades.ITrade[] elifausLevel5 = new VillagerTrades.ITrade[]{
//                new EmeraldForItemsTrade(ItemRegistry.LAVA_CAKE.get(), 1, 2, 15),
//                new EmeraldForItemsTrade(ItemRegistry.UNI_MILLET.get(), 18, 20, 2)
//        };
//
//        VillagerTrades.VILLAGER_DEFAULT_TRADES.put(ELIFAUS.get(),
//                gatAsIntMap(ImmutableMap.of(1, elifausLevel1, 2, elifausLevel2, 3, elifausLevel3, 4, elifausLevel4, 5, elifausLevel5)));
//
//        VillagerTrades.ITrade[] ruozhiLevel1 = new VillagerTrades.ITrade[]{
//                new EmeraldForItemsTrade(Items.IRON_INGOT, 6, 10, 3),
//                new EmeraldForItemsTrade(Blocks.PUMPKIN.asItem(), 8, 10, 5),
//                new ItemsForEmeraldsTrade(Items.PUMPKIN_PIE, 5, 2, 5)
//        };
//        VillagerTrades.ITrade[] ruozhiLevel2 = new VillagerTrades.ITrade[]{
//                new EmeraldForItemsTrade(Items.REDSTONE, 15, 10, 5),
//                new ItemsForEmeraldsTrade(Items.STICKY_PISTON, 2, 3, 5),
//                new ItemsForEmeraldsTrade(ItemRegistry.UNI_MILLET.get(), 3, 4, 10, 5)
//        };
//        VillagerTrades.ITrade[] ruozhiLevel3 = new VillagerTrades.ITrade[]{
//                new EmeraldForItemsTrade(Items.SALMON, 20, 16, 2),
//                new ItemsForEmeraldsTrade(ItemRegistry.PORCELAIN_THRONE.get(), 8, 1, 10),
//                new ItemsForEmeraldsTrade(ItemRegistry.BANANA_MILK.get(), 2, 3, 20, 6)
//        };
//        VillagerTrades.ITrade[] ruozhiLevel4 = new VillagerTrades.ITrade[]{
//                new EmeraldForItemsTrade(Items.SMOOTH_STONE, 10, 30, 1),
//                new ItemsForEmeraldsTrade(ItemRegistry.ELIBOARD.get(), 3,8, 16, 3),
//                new ItemsForEmeraldsTrade(ItemRegistry.FROG_LEG.get(), 3, 2, 3)
//        };
//        VillagerTrades.ITrade[] ruozhiLevel5 = new VillagerTrades.ITrade[]{
//                new ItemsForEmeraldsTrade(ItemRegistry.ELECTRIC_HORN.get(), 50, 1, 1, 35),
//                new ItemsForEmeraldsTrade(ItemRegistry.TARO_ICE_CREAM.get(), 4, 1, 16, 5)
//        };
//
//        VillagerTrades.VILLAGER_DEFAULT_TRADES.put(RUOZHI.get(),
//                gatAsIntMap(ImmutableMap.of(1, ruozhiLevel1, 2, ruozhiLevel2, 3, ruozhiLevel3, 4, ruozhiLevel4, 5, ruozhiLevel5)));
//    }
}
