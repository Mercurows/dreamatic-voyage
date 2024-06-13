package tech.lq0.dreamaticvoyage.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;

@Mixin(JukeboxBlockEntity.class)
public abstract class JukeboxBlockEntityMixin {

    @Shadow
    public abstract boolean isRecordPlaying();

    @Shadow
    public abstract ItemStack getItem(int pSlot);

    @Shadow
    private long tickCount;

    // TODO 完成治愈功能
    @Inject(method = "tick(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At("HEAD"))
    private void tick(Level pLevel, BlockPos pPos, BlockState pState, CallbackInfo callbackInfo) {
        if (this.isRecordPlaying() && this.getItem(0).getItem() == ItemRegistry.MUSIC_DISC_SONG_OF_AUTUMN.get()) {
            if (this.tickCount % 20 == 0) {
                AABB aabb = new AABB(pPos);
                pLevel.getEntitiesOfClass(LivingEntity.class, aabb.inflate(16, 16, 16))
                        .forEach(living -> living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 1, true, false)));
            }
        }
    }
}
