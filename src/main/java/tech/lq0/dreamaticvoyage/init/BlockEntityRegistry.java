package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.FukamizuCompressorBlockEntity;
import tech.lq0.dreamaticvoyage.block.entity.PhantasmalVoyagerBlockEntity;
import tech.lq0.dreamaticvoyage.block.entity.PointsStoreBlockEntity;
import tech.lq0.dreamaticvoyage.block.entity.VerdantSpiritFarmlandBlockEntity;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<BlockEntityType<PointsStoreBlockEntity>> POINTS_STORE_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("points_store_block_entity",
                    () -> BlockEntityType.Builder.of(PointsStoreBlockEntity::new, BlockRegistry.POINTS_STORE.get()).build(null));
    public static final RegistryObject<BlockEntityType<PhantasmalVoyagerBlockEntity>> PHANTASMAL_VOYAGER_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("phantasmal_voyager_block_entity",
                    () -> BlockEntityType.Builder.of(PhantasmalVoyagerBlockEntity::new, BlockRegistry.PHANTASMAL_VOYAGER.get()).build(null));
    public static final RegistryObject<BlockEntityType<VerdantSpiritFarmlandBlockEntity>> VERDANT_SPIRIT_FARMLAND_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("verdant_spirit_farmland_block_entity",
                    () -> BlockEntityType.Builder.of(VerdantSpiritFarmlandBlockEntity::new, BlockRegistry.VERDANT_SPIRIT_FARMLAND.get()).build(null));

    public static final RegistryObject<BlockEntityType<FukamizuCompressorBlockEntity>> FUKAMIZU_COMPRESSOR_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("fukamizu_compressor_block_entity",
                    () -> BlockEntityType.Builder.of(FukamizuCompressorBlockEntity::new, BlockRegistry.FUKAMIZU_COMPRESSOR.get()).build(null));
}
