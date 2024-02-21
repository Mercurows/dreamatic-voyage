package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.block.entity.PointsStoreBlockEntity;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<BlockEntityType<PointsStoreBlockEntity>> POINTS_STORE_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("points_store_block_entity",
                    () -> BlockEntityType.Builder.of(PointsStoreBlockEntity::new, BlockRegistry.POINTS_STORE.get()).build(null));
}
