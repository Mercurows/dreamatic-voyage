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

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class DamageSourceRegistry {
    public static final ResourceKey<DamageType> LAVA_CAKE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "lava_cake"));
    public static final ResourceKey<DamageType> CHOCOAL_COOKIE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, "chocoal_cookie"));

    public static DamageSource causeLavaCakeDamage(RegistryAccess registryAccess) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LAVA_CAKE));
    }

    public static DamageSource causeChocoalCookieDamage(RegistryAccess registryAccess) {
        return new DamageMessages(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(CHOCOAL_COOKIE));
    }

    private static class DamageMessages extends DamageSource {
        public DamageMessages(Holder.Reference<DamageType> typeReference) {
            super(typeReference);
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
