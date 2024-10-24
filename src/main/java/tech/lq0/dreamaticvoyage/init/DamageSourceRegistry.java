package tech.lq0.dreamaticvoyage.init;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import tech.lq0.dreamaticvoyage.Utils;

import javax.annotation.Nullable;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class DamageSourceRegistry {
    public static final ResourceKey<DamageType> LAVA_CAKE = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("lava_cake"));
    public static final ResourceKey<DamageType> MARI_FOOD = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("mari_food"));
    public static final ResourceKey<DamageType> EMOTIONAL_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("emotional_damage"));
    public static final ResourceKey<DamageType> LOTUS_POTATO = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("lotus_potato"));
    public static final ResourceKey<DamageType> LUNATIC_HOWL = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("lunatic_howl"));
    public static final ResourceKey<DamageType> OVERLOAD = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("overload"));
    public static final ResourceKey<DamageType> BLEEDING = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("bleeding"));
    public static final ResourceKey<DamageType> BLOOD_CRYSTAL = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("blood_crystal"));
    public static final ResourceKey<DamageType> LUNAR_ECLIPSE = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("lunar_eclipse"));
    public static final ResourceKey<DamageType> FUKAMIZU_BREAD = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("fukamizu_bread"));
    public static final ResourceKey<DamageType> BROWNIE_UZZA = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("brownie_uzza"));
    public static final ResourceKey<DamageType> CHOCOAL_COOKIE = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("chocoal_cookie"));
    public static final ResourceKey<DamageType> LEVIY_BEAM = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("leviy_beam"));
    public static final ResourceKey<DamageType> LEVIY_BEAM_ABSOLUTE = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("leviy_beam_absolute"));
    public static final ResourceKey<DamageType> WITHER_ABSOLUTE = ResourceKey.create(Registries.DAMAGE_TYPE, Utils.loc("wither_absolute"));

    public static DamageSource causeLavaCakeDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LAVA_CAKE), entity);
    }

    public static DamageSource causeMariFoodDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(MARI_FOOD), entity);
    }

    public static DamageSource causeEmotionalDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(EMOTIONAL_DAMAGE), entity);
    }

    public static DamageSource causeLotusPotatoDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LOTUS_POTATO), entity);
    }

    public static DamageSource causeLunaticHowlDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LUNATIC_HOWL), entity);
    }

    public static DamageSource causeOverloadDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(OVERLOAD), entity);
    }

    public static DamageSource causeBleedingDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(BLEEDING), entity);
    }

    public static DamageSource causeBloodCrystalDamage(RegistryAccess registryAccess, @Nullable Entity entity, @Nullable Entity attacker) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(BLOOD_CRYSTAL), entity, attacker);
    }

    public static DamageSource causeLunarEclipseDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LUNAR_ECLIPSE), entity);
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

    public static DamageSource causeLeviyBeamDamage(RegistryAccess registryAccess, @Nullable Entity entity, @Nullable Entity attacker) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LEVIY_BEAM), entity, attacker);
    }

    public static DamageSource causeAbsoluteLeviyBeamDamage(RegistryAccess registryAccess, @Nullable Entity entity, @Nullable Entity attacker) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LEVIY_BEAM_ABSOLUTE), entity, attacker);
    }

    public static DamageSource causeAbsoluteWitherDamage(RegistryAccess registryAccess, @Nullable Entity entity) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(WITHER_ABSOLUTE), entity);
    }

    private static class DamageMessages extends DamageSource {
        public DamageMessages(Holder.Reference<DamageType> typeReference) {
            super(typeReference);
        }

        public DamageMessages(Holder.Reference<DamageType> typeReference, Entity entity) {
            super(typeReference, entity);
        }

        public DamageMessages(Holder.Reference<DamageType> typeReference, Entity directEntity, Entity attacker) {
            super(typeReference, directEntity, attacker);
        }

        @Override
        public Component getLocalizedDeathMessage(LivingEntity pLivingEntity) {
            Entity entity = this.getEntity() == null ? this.getDirectEntity() : this.getEntity();
            if (entity == null) {
                return Component.translatable("death.attack." + this.getMsgId(), pLivingEntity.getDisplayName());
            } else if (entity instanceof LivingEntity living && living.getMainHandItem().hasCustomHoverName()) {
                return Component.translatable("death.attack." + this.getMsgId() + ".item", pLivingEntity.getDisplayName(), entity.getDisplayName(), living.getMainHandItem().getDisplayName());
            } else {
                return Component.translatable("death.attack." + this.getMsgId() + ".entity", pLivingEntity.getDisplayName(), entity.getDisplayName());
            }
        }
    }
}
