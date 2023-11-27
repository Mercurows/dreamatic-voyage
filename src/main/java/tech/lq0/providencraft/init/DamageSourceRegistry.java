package tech.lq0.providencraft.init;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import tech.lq0.providencraft.Utils;

import javax.annotation.Nullable;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class DamageSourceRegistry {
    public static final ResourceKey<DamageType> LAVA_CAKE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "lava_cake"));
    public static final ResourceKey<DamageType> MARI_FOOD = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "mari_food"));
    public static final ResourceKey<DamageType> EMOTIONAL_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "emotional_damage"));;
    public static final ResourceKey<DamageType> LOTUS_POTATO = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "lotus_potato"));
    public static final ResourceKey<DamageType> SORAYO = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "sorayo"));
//    public static final ResourceKey<DamageType> OVERLOAD
    public static final ResourceKey<DamageType> BLEEDING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "pdc_bleeding"));
    public static final ResourceKey<DamageType> BLOOD_CRYSTAL = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "blood_crystal"));
//    public static final ResourceKey<DamageType> LUNAR_ECLIPSE
    public static final ResourceKey<DamageType> FUKAMIZU_BREAD = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "fukamizu_bread"));
    public static final ResourceKey<DamageType> BROWNIE_UZZA = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "brownie_uzza"));
    public static final ResourceKey<DamageType> CHOCOAL_COOKIE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "chocoal_cookie"));

    public static DamageSource causeLavaCakeDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LAVA_CAKE), entity);
    }

    public static DamageSource causeLotusPotatoDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LOTUS_POTATO), entity);
    }

    public static DamageSource causeSorayoDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(SORAYO), entity);
    }

    public static DamageSource causeBleedingDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(BLEEDING), entity);
    }

    public static DamageSource causeBloodCrystalDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(BLOOD_CRYSTAL), entity);
    }

    public static DamageSource causeFukamizuBreadDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(FUKAMIZU_BREAD), entity);
    }

    public static DamageSource causeBrownieUzzaDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(BROWNIE_UZZA), entity);
    }

    public static DamageSource causeChocoalCookieDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(CHOCOAL_COOKIE), entity);
    }

    private static class DamageMessages extends DamageSource {
        public DamageMessages(Holder.Reference<DamageType> typeReference) {
            super(typeReference);
        }

        public DamageMessages(Holder.Reference<DamageType> typeReference, Entity entity) {
            super(typeReference, entity);
        }

        @Override
        public Component getLocalizedDeathMessage(LivingEntity pLivingEntity) {
            Entity entity = this.getDirectEntity() == null ? this.getEntity() : this.getDirectEntity();
            if (entity == null) {
                return Component.translatable("death.attack." + this.getMsgId(), pLivingEntity.getDisplayName());
            } else {
                return Component.translatable("death.attack." + this.getMsgId() + ".entity", pLivingEntity.getDisplayName(), entity.getDisplayName());
            }
        }
    }
}
