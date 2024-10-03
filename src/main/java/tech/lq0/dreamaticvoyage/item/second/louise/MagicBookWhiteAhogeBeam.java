package tech.lq0.dreamaticvoyage.item.second.louise;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import tech.lq0.dreamaticvoyage.entity.projectile.WhiteAhogeBeamEntity;

import java.util.List;

public class MagicBookWhiteAhogeBeam extends Item {

    public MagicBookWhiteAhogeBeam() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    // TODO 改成过热充能条形式的cd
    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);

        List<WhiteAhogeBeamEntity> entities = pLevel.getEntitiesOfClass(WhiteAhogeBeamEntity.class, pLivingEntity.getBoundingBox().inflate(2.0F),
                corruptedBeam -> corruptedBeam.getOwner() == pLivingEntity);
        Vec3 vector3d = pLivingEntity.getViewVector(1.0F);
        if (entities.isEmpty()) {
            WhiteAhogeBeamEntity beamEntity = new WhiteAhogeBeamEntity(pLevel, pLivingEntity);
            beamEntity.moveTo(
                    pLivingEntity.getX() + vector3d.x / 2,
                    pLivingEntity.getEyeY() - 0.2,
                    pLivingEntity.getZ() + vector3d.z / 2, pLivingEntity.getYRot(), pLivingEntity.getXRot());
            beamEntity.setOwner(pLivingEntity);
            pLevel.addFreshEntity(beamEntity);
        }

        if (getUseDuration(pStack) - pRemainingUseDuration > 100 && pLivingEntity instanceof Player player) {
            player.stopUsingItem();
            player.getCooldowns().addCooldown(this, 80);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 200;
    }

}
