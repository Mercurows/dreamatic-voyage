package tech.lq0.dreamaticvoyage.item.second.louise;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;
import tech.lq0.dreamaticvoyage.capability.beam.BeamCapability;
import tech.lq0.dreamaticvoyage.entity.projectile.TestBeamEntity;

public class MagicBookWhiteAhogeBeam extends Item {

    public MagicBookWhiteAhogeBeam() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

//    @Override
//    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
//        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
//
//        List<WhiteAhogeBeamEntity> entities = pLevel.getEntitiesOfClass(WhiteAhogeBeamEntity.class, pLivingEntity.getBoundingBox().inflate(2.0F),
//                corruptedBeam -> corruptedBeam.getOwner() == pLivingEntity);
//        Vec3 vector3d = pLivingEntity.getViewVector(1.0F);
//        if (entities.isEmpty()) {
//            WhiteAhogeBeamEntity beamEntity = new WhiteAhogeBeamEntity(pLevel, pLivingEntity);
//            beamEntity.moveTo(
//                    pLivingEntity.getX() + vector3d.x / 2,
//                    pLivingEntity.getEyeY() - 0.2,
//                    pLivingEntity.getZ() + vector3d.z / 2, pLivingEntity.getYRot(), pLivingEntity.getXRot());
//            beamEntity.setOwner(pLivingEntity);
//            pLevel.addFreshEntity(beamEntity);
//
//            pStack.getOrCreateTag().putInt("Cooldown", Math.min(100, pStack.getOrCreateTag().getInt("Cooldown") + 1));
//        }
//    }
//
//    @Override
//    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
//        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
//
//        if (pStack.getOrCreateTag().getInt("Cooldown") >= 100 && pEntity instanceof Player player) {
//            player.getCooldowns().addCooldown(this, 80);
//            pStack.getOrCreateTag().putInt("Cooldown", 0);
//            player.stopUsingItem();
//        }
//
//        if (pEntity instanceof Player player && (!player.isUsingItem() || !pIsSelected)) {
//            pStack.getOrCreateTag().putInt("Cooldown", Math.max(0, pStack.getOrCreateTag().getInt("Cooldown") - 1));
//        }
//    }
//
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
//        pPlayer.startUsingItem(pUsedHand);
//        return InteractionResultHolder.consume(stack);
//    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.getCapability(ModCapabilities.BEAM_CAPABILITY).ifPresent(consumer -> {
            player.startUsingItem(hand);

            if (!level.isClientSide) {
                double px = player.getX();
                double py = player.getY() + player.getBbHeight() * 0.6F;
                double pz = player.getZ();
                float yHeadRotAngle = (float) Math.toRadians(player.yHeadRot + 90);
                float xHeadRotAngle = (float) (float) -Math.toRadians(player.getXRot());
                TestBeamEntity testBeamEntity = new TestBeamEntity(player.level(), player, px, py, pz, yHeadRotAngle, xHeadRotAngle, 100);
                consumer.init(testBeamEntity, player);
                consumer.start();
            }
        });

        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (livingEntity instanceof Player player) {
            player.getCapability(ModCapabilities.BEAM_CAPABILITY).ifPresent(BeamCapability.IBeamCapability::stop);
        }
        super.releaseUsing(stack, level, livingEntity, timeCharged);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 200;
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0xE8FFE7;
    }

    @Override
    public int getBarWidth(ItemStack pStack) {
        return Math.round(pStack.getOrCreateTag().getInt("Cooldown") * 13.0F / 100.0f);
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return pStack.getOrCreateTag().getInt("Cooldown") > 0;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
