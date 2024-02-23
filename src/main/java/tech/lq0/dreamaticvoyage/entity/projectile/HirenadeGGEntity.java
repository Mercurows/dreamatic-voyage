package tech.lq0.dreamaticvoyage.entity.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.ParticleRegistry;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;

import java.util.Random;

public class HirenadeGGEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> FUSE = SynchedEntityData.defineId(HirenadeGGEntity.class, EntityDataSerializers.INT);
    private int fuse = 12000;

    public HirenadeGGEntity(EntityType<? extends HirenadeGGEntity> p_i50159_1_, Level p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public HirenadeGGEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.HIRENADE_GG_ENTITY.get(), entity, world);
    }

    public HirenadeGGEntity(Level p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.HIRENADE_GG_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        explode(this, 6.5f);
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        explode(this, 6.5f);
        this.discard();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FUSE, 12000);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.HIRENADE_GG.get().asItem();
    }

    @Override
    public void tick() {
        super.tick();
        --this.fuse;
        if (this.fuse <= 0) {
            this.discard();
            if (!this.level().isClientSide) {
                explode(this, 6.5f);
            }
        } else {
            if (this.level().isClientSide) {
                this.level().addParticle(ParticleRegistry.TENTACLE.get(), this.getX(), this.getY() + 0.1D, this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putShort("Fuse", (short) this.getFuse());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.setFuse(pCompound.getShort("Fuse"));
    }

    public int getFuse() {
        return fuse;
    }

    public void setFuse(int fuse) {
        this.fuse = fuse;
    }

    public static void explode(Entity entity, float radius) {
        Level world = entity.level();
        if (world.isClientSide()) {
            return;
        }

        Explosion explosion = new Explosion(world, entity, null, null, entity.getX(), entity.getY(), entity.getZ(), radius, false, Explosion.BlockInteraction.KEEP);

        if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion)) {
            return;
        }

        explosion.explode();
        explosion.finalizeExplosion(true);

        explosion.clearToBlow();

        Random random = new Random();
        entity.playSound(SoundRegistry.HIRU_SCREAM.get(), 0.7f + random.nextFloat(), 1.0f);

        ((ServerLevel) world).sendParticles(ParticleTypes.FLASH, entity.getX(), entity.getY(), entity.getZ(),
                10, 1.0D, 1.0D, 1.0D, 0.05);

        for (ServerPlayer serverPlayer : ((ServerLevel) world).players()) {
            if (serverPlayer.distanceToSqr(entity.getX(), entity.getY(), entity.getZ()) < 16384) {
                serverPlayer.connection.send(new ClientboundExplodePacket(entity.getX(), entity.getY(), entity.getZ(), 2, explosion.getToBlow(), explosion.getHitPlayers().get(entity)));
            }
        }
    }
}
