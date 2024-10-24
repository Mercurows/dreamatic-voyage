package tech.lq0.dreamaticvoyage.item.magicros.chiram;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChiramHat extends Item implements ICurioItem {
    public ChiramHat() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.chiram_hat_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.chiram_hat_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHIRAM);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (!entity.level().isClientSide) {
            if (entity instanceof Player player) {
                if (player.isFallFlying()) {
                    if (player.getFallFlyingTicks() % 10 == 0) {
                        ((ServerLevel) entity.level()).sendParticles(ParticleTypes.CHERRY_LEAVES,
                                entity.getX(), entity.getY(), entity.getZ(), 10, 2, 2, 2, 0.1);
                    }

                    if (player.isSteppingCarefully() && !player.getCooldowns().isOnCooldown(stack.getItem())) {
                        ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET);
                        rocket.getOrCreateTagElement("Fireworks").putByte("Flight", (byte) 3);

                        FireworkRocketEntity fireworkrocketentity = new FireworkRocketEntity(player.level(), rocket, player);
                        player.level().addFreshEntity(fireworkrocketentity);
                        player.getCooldowns().addCooldown(stack.getItem(), 300);
                    }
                }
            }
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }
}
