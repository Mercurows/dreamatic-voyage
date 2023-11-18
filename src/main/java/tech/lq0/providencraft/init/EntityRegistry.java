package tech.lq0.providencraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.projectile.BloodCrystalEntity;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<BloodCrystalEntity>> BLOOD_CRYSTAL_ENTITY =
            ENTITY_TYPES.register("blood_crystal",
                    () -> EntityType.Builder.<BloodCrystalEntity>of(BloodCrystalEntity::new, MobCategory.MISC).sized(0.1f, 0.1f).build("blood_crystal"));
}
