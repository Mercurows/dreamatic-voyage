package tech.lq0.dreamaticvoyage.item.second.mumu;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class MushroomCroissant extends Item {
    public MushroomCroissant() {
        super(new Properties().rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pInteractionTarget instanceof Cow cow) {
            if (!pPlayer.level().isClientSide) {
                MushroomCow mushroomCow = EntityType.MOOSHROOM.create(cow.level());
                if (mushroomCow != null) {
                    ((ServerLevel) cow.level()).sendParticles(ParticleTypes.EXPLOSION, cow.getX(), cow.getY(0.5D), cow.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                    cow.discard();
                    mushroomCow.moveTo(cow.getX(), cow.getY(), cow.getZ(), cow.getYRot(), cow.getXRot());
                    mushroomCow.setHealth(cow.getHealth());
                    mushroomCow.yBodyRot = cow.yBodyRot;
                    if (cow.hasCustomName()) {
                        mushroomCow.setCustomName(cow.getCustomName());
                        mushroomCow.setCustomNameVisible(cow.isCustomNameVisible());
                    }

                    if (cow.isPersistenceRequired()) {
                        mushroomCow.setPersistenceRequired();
                    }

                    mushroomCow.setInvulnerable(cow.isInvulnerable());

                    if (cow.level().random.nextDouble() < .2) {
                        mushroomCow.setVariant(MushroomCow.MushroomType.BROWN);
                    } else {
                        mushroomCow.setVariant(MushroomCow.MushroomType.RED);
                    }

                    cow.level().addFreshEntity(mushroomCow);

                    pStack.shrink(1);

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
