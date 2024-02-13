package tech.lq0.providencraft.item.providencesecond.satou;

import com.google.common.collect.Streams;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.RarityTool;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AncientLollipop extends SwordItem {
    public static final String TAG_LOLLIPOP = "shouldExplode";

    public AncientLollipop() {
        super(Tiers.NETHERITE, 1, -0.8f, new Properties().rarity(RarityTool.LEGENDARY).durability(642).fireResistant().setNoRepair());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.ancient_lollipop_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.providencraft.ancient_lollipop_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SATOU);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        if (!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
        }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.EMPTY;
    }

    @Override
    public int getEnchantmentValue() {
        return 20;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 5;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            if (player.getVehicle() != null) {
                return pStack;
            }

            Vec3 start = player.getEyePosition(1);
            Vec3 end = start.add(player.getLookAngle().scale(20));

            Vec3 res;

            BlockHitResult rayTrace = pLevel.clip(new ClipContext(start, end, ClipContext.Block.COLLIDER,
                    ClipContext.Fluid.NONE, player));

            if (rayTrace.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = rayTrace.getBlockPos().relative(rayTrace.getDirection());

                res = getTpPos(player, getFaceCenter(pos));
            } else {
                res = start.add(player.getLookAngle().scale(10));
            }

            if (res != null) {
                if (!pLevel.isClientSide) {
                    player.teleportTo(res.x, res.y, res.z);
                } else {
                    for (int i = 1; i <= 20; i++) {
                        pLevel.addParticle(ParticleTypes.PORTAL, true,
                                player.getX(), player.getY(), player.getZ(),
                                pLevel.random.nextDouble() - 0.5, pLevel.random.nextDouble(), pLevel.random.nextDouble() - 0.5);
                    }
                }
            }

            pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
            player.fallDistance = 0;
            ItemNBTTool.setBoolean(pStack, TAG_LOLLIPOP, true);
            player.getCooldowns().addCooldown(pStack.getItem(), 70);

        }

        return pStack;
    }

    //From Electroblob77's Wizardry
    public static Vec3 getTpPos(Entity entity, Vec3 vec3) {
        Level level = entity.level();
        AABB box = entity.getBoundingBox();

        box = box.move(vec3.subtract(entity.getX(), entity.getY(), entity.getZ()));

        Iterable<BlockPos> cuboid = BlockPos.betweenClosed(Mth.floor(box.minX), Mth.floor(box.minY),
                Mth.floor(box.minZ), Mth.floor(box.maxX), Mth.floor(box.maxY), Mth.floor(box.maxZ));

        if (Streams.stream(cuboid).noneMatch(b -> level.noCollision(new AABB(b)))) {
            return vec3;
        } else {
            double dx = box.maxX - box.minX;
            double dy = box.maxY - box.minY;
            double dz = box.maxZ - box.minZ;

            int nx = Mth.ceil(dx) / 2;
            int px = Mth.ceil(dx) - nx;
            int ny = Mth.ceil(dy) / 2;
            int py = Mth.ceil(dy) - ny;
            int nz = Mth.ceil(dz) / 2;
            int pz = Mth.ceil(dz) - nz;

            List<BlockPos> nearby = Streams.stream(BlockPos.betweenClosed(Mth.floor(box.minX) - 1,
                    Mth.floor(box.minY) - 1, Mth.floor(box.minZ) - 1,
                    Mth.floor(box.maxX) + 1, Mth.floor(box.maxY) + 1,
                    Mth.floor(box.maxZ) + 1)).collect(Collectors.toList());

            List<BlockPos> possiblePositions = Streams.stream(cuboid).collect(Collectors.toList());

            while (!nearby.isEmpty()) {
                BlockPos pos = nearby.remove(0);

                if (level.noCollision(new AABB(pos))) {
                    Predicate<BlockPos> nearSolidBlock = b -> b.getX() >= pos.getX() - nx && b.getX() <= pos.getX() + px
                            && b.getY() >= pos.getY() - ny && b.getY() <= pos.getY() + py
                            && b.getZ() >= pos.getZ() - nz && b.getZ() <= pos.getZ() + pz;
                    nearby.removeIf(nearSolidBlock);
                    possiblePositions.removeIf(nearSolidBlock);
                }
            }

            if (possiblePositions.isEmpty()) {
                return null;
            }

            BlockPos nearest = possiblePositions.stream().min(Comparator.comparingDouble(b -> vec3.distanceToSqr(
                    b.getX() + 0.5, b.getY() + 0.5, b.getZ() + 0.5))).get();

            return getFaceCenter(nearest);
        }
    }

    public static Vec3 getFaceCenter(BlockPos pos) {
        return new Vec3(pos.getX(), pos.getY(), pos.getZ()).add(0.5, 0, 0.5);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof Player player && pIsSelected) {
            if (player.isSteppingCarefully()) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 50, 4, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 50, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 50, 4, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 50, 1, false, false));
            }

            if (player.tickCount % 200 == 0) {
                player.getFoodData().eat(1, 0.5f);
            }
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return false;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity pAttacker) {
        Level level = pAttacker.level();
        target.invulnerableTime = 0;

        if (pAttacker instanceof Player player) {
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_LOLLIPOP, false);
            if (flag) {
                ItemNBTTool.setBoolean(stack, TAG_LOLLIPOP, false);

                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 2));

                if (!level.isClientSide) {
                    new Object() {
                        private int ticks = 0;
                        private float waitTicks;

                        public void start(int waitTicks) {
                            ((ServerLevel) level).sendParticles(ParticleTypes.ENCHANT, target.getX(), target.getY() + 1, target.getZ(),
                                    150, 0.1, 0.2, 0.1, 2);

                            this.waitTicks = waitTicks;
                            MinecraftForge.EVENT_BUS.register(this);
                        }

                        @SubscribeEvent
                        public void tick(TickEvent.ServerTickEvent event) {
                            if (event.phase == TickEvent.Phase.END) {
                                this.ticks++;

                                if (!target.isAlive()) {
                                    MinecraftForge.EVENT_BUS.unregister(this);
                                }

                                if (this.ticks >= this.waitTicks) {
                                    run();
                                }
                            }
                        }

                        private void run() {
                            Explosion explosion = new Explosion(level, player, level.damageSources().playerAttack(player),
                                    null, target.getX(), target.getY(), target.getZ(), 3, false, Explosion.BlockInteraction.KEEP);
                            explosion.explode();
                            explosion.finalizeExplosion(true);

                            ((ServerLevel) level).sendParticles(ParticleTypes.DRAGON_BREATH, target.getX(), target.getY() + 1, target.getZ(),
                                    200, level.random.nextDouble() - 0.5, level.random.nextDouble(), level.random.nextDouble() - 0.5, 0.5);

                            explosion.clearToBlow();

                            for (ServerPlayer serverPlayer : ((ServerLevel) level).players()) {
                                if (serverPlayer.distanceToSqr(target.getX(), target.getY(), target.getZ()) < 400) {
                                    serverPlayer.connection.send(new ClientboundExplodePacket(target.getX(), target.getY(), target.getZ(), 3, explosion.getToBlow(), explosion.getHitPlayers().get(target)));
                                }
                            }

                            MinecraftForge.EVENT_BUS.unregister(this);
                        }
                    }.start(30);
                }
            }
        }

        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.BREAKABLE;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
}
