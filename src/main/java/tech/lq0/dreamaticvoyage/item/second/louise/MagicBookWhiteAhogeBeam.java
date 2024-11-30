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
import tech.lq0.dreamaticvoyage.capability.beam.BeamHandler;
import tech.lq0.dreamaticvoyage.entity.projectile.WhiteAhogeBeamEntity;

public class MagicBookWhiteAhogeBeam extends Item {

    public MagicBookWhiteAhogeBeam() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.getCapability(ModCapabilities.BEAM_CAPABILITY).ifPresent(capability -> {
            player.startUsingItem(hand);

            if (!level.isClientSide) {
                double px = player.getX();
                double py = player.getY() + player.getBbHeight() * 0.6F;
                double pz = player.getZ();
                float yHeadRotAngle = (float) Math.toRadians(player.yHeadRot + 90);
                float xHeadRotAngle = (float) (float) -Math.toRadians(player.getXRot());
                WhiteAhogeBeamEntity whiteAhogeBeamEntity = new WhiteAhogeBeamEntity(player.level(), player, px, py, pz, yHeadRotAngle, xHeadRotAngle, 200);
                capability.init(new BeamHandler(player, whiteAhogeBeamEntity, stack, 60));
                capability.start();
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
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if (entity instanceof Player player) {
            player.getCapability(ModCapabilities.BEAM_CAPABILITY).ifPresent(BeamCapability.IBeamCapability::stop);
        }
        super.onStopUsing(stack, entity, count);
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
