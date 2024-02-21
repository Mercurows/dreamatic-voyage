package tech.lq0.dreamaticvoyage.item.providencefirst.madoka;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RedAhogeMachete extends SwordItem {
    private static final String TAG_FALL = "falling";

    public RedAhogeMachete() {
        super(ModItemTier.RED_AHOGE, 7, -2.8f, new Properties().durability(751).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.red_ahoge_machete_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.red_ahoge_machete_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.red_ahoge_machete.func").withStyle(ChatFormatting.AQUA));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MADOKA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (pPlayer.getVehicle() != null) {
            return InteractionResultHolder.fail(stack);
        }

        if (pUsedHand == InteractionHand.MAIN_HAND) {
            if (pPlayer.onGround()) {
                pPlayer.addDeltaMovement(new Vec3(0, 2.5, 0));
                pPlayer.getCooldowns().addCooldown(this, 20);
                return InteractionResultHolder.success(stack);
            } else {
                ItemNBTTool.setBoolean(stack, TAG_FALL, true);
                if (pPlayer.getAbilities().flying) {
                    doDamage(pPlayer, 0, stack, true);
                } else {
                    pPlayer.addDeltaMovement(new Vec3(0, -8, 0));
                }
                pPlayer.getCooldowns().addCooldown(this, 50);
            }

            stack.hurtAndBreak(10, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));

            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.fail(stack);
    }

    @SubscribeEvent
    public static void onFlyablePlayerFall(PlayerFlyableFallEvent event) {
        Player player = event.getEntity();
        ItemStack stack = player.getMainHandItem();
        doDamage(player, event.getDistance(), stack, false);
    }

    @SubscribeEvent
    public static void onPlayerFall(LivingFallEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack stack = player.getMainHandItem();
            float distance = event.getDistance();

            if (ItemNBTTool.getBoolean(stack, TAG_FALL, false)) {
                event.setDistance(0);
            }
            doDamage(player, distance, stack, false);
        }
    }

    private static void doDamage(Player playerIn, float distance, ItemStack stack, boolean isFlying) {
        if (stack.getItem() == ItemRegistry.RED_AHOGE_MACHETE.get()) {
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_FALL, false);
            int r = isFlying ? 4 : 6;

            if (flag) {
                List<LivingEntity> entities = playerIn.level().getEntitiesOfClass(LivingEntity.class, playerIn.getBoundingBox().inflate(r, 0.5, r));

                entities.forEach(e -> {
                    if (!e.isAlliedTo(playerIn) && e != playerIn) {
                        e.knockback(1.0F, playerIn.getX() - e.getX(), playerIn.getZ() - e.getZ());
                        e.hurt(playerIn.level().damageSources().playerAttack(playerIn), distance * 0.7f + 8);
                    }
                });

                if (!playerIn.level().isClientSide && !isFlying) {
                    ((ServerLevel) playerIn.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.STONE.defaultBlockState()),
                            playerIn.getX(), playerIn.getY(), playerIn.getZ(), r * 10, r, 0.5, r, 0.1);
                }
                ItemNBTTool.setBoolean(stack, TAG_FALL, false);
            }
        }
    }
}
