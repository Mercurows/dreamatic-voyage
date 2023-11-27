package tech.lq0.providencraft.init;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.loot.AddItemModifier;
import tech.lq0.providencraft.loot.FishingModifier;

public class LootModifierRegistry {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Utils.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> FISHING = LOOT_MODIFIER_SERIALIZERS.register("fishing", FishingModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }

    public static LootTableReference getLootTableReference(String resLoc) {
        return (LootTableReference) LootTableReference.lootTableReference(new ResourceLocation(resLoc)).build();
    }

    public static String getString(LootTableReference lootTable) {
        return lootTable.name.toString();
    }
}
