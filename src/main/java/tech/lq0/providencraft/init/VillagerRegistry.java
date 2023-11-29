package tech.lq0.providencraft.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;

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
}
