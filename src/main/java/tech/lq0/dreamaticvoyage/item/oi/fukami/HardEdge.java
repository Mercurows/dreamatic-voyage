package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.ModTags;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.text.DecimalFormat;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HardEdge extends SwordItem {
    public static final float MAX_DAMAGE = 8000.0f;
    public static final int MAX_HUNGER = 400;
    public static final int MAX_KILL_COUNT = 100;

    public static final ResourceLocation EXTRA_WITHER_SKELETON_SKULL = Utils.loc("special/extra_wither_skeleton_skull");

    public HardEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 4, -2.8f, new Properties().setNoRepair().rarity(Rarity.UNCOMMON).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hard_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hard_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
        handleUpgradeTooltips(pStack, pTooltipComponents);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 48;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }

    @Override
    public SoundEvent getEatingSound() {
        return super.getEatingSound();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F + (pLevel.random.nextFloat() - pLevel.random.nextFloat()) * 0.4F);
        if (!pLevel.isClientSide) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0), pLivingEntity);
            pLivingEntity.hurt(DamageSourceRegistry.causeFukamizuBreadDamage(pLevel.registryAccess(), null), 2.0f);
        }
        if (pLivingEntity instanceof Player player) {
            int hunger = player.getFoodData().getFoodLevel();
            float saturation = player.getFoodData().getSaturationLevel();
            pStack.getOrCreateTag().putInt("Hunger",
                    pStack.getOrCreateTag().getInt("Hunger") + Math.min(20 - hunger, 7) + (int) Math.min(20 - saturation, 7));

            player.getFoodData().eat(7, 0.5f);
            player.getCooldowns().addCooldown(this, 600);
        }
        pLivingEntity.gameEvent(GameEvent.EAT);
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    private void handleUpgradeTooltips(ItemStack pStack, List<Component> pTooltipComponents) {
        pTooltipComponents.add(Component.literal(""));
        TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.ctrl_hide").withStyle(ChatFormatting.YELLOW), true);

        float damage = pStack.getOrCreateTag().getFloat("CausedDamage");
        int hunger = pStack.getOrCreateTag().getInt("Hunger");
        int killCount = pStack.getOrCreateTag().getInt("KillCount");

        float damageProgress = Math.min(2, damage / MAX_DAMAGE);
        float hungerProgress = Math.min(2, (float) hunger / MAX_HUNGER);
        float killCountProgress = Math.min(2, (float) killCount / MAX_KILL_COUNT);

        int count = 0;
        int nCount = 0;
        if (damageProgress >= 1) {
            count++;
            if (damageProgress >= 2) {
                nCount++;
            }
        }
        if (hungerProgress >= 1) {
            count++;
            if (hungerProgress >= 2) {
                nCount++;
            }
        }
        if (killCountProgress >= 1) {
            count++;
            if (killCountProgress >= 2) {
                nCount++;
            }
        }

        if (count >= 3 && nCount >= 1) {
            TooltipTool.addCtrlHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.complete").withStyle(ChatFormatting.GREEN));
        }

        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.progress").withStyle(ChatFormatting.YELLOW)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(count + " / 3").withStyle(count == 3 ? ChatFormatting.GREEN : ChatFormatting.WHITE))
                        .append(Component.literal(" | ").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(nCount + " / 1").withStyle(nCount >= 1 ? ChatFormatting.GOLD : ChatFormatting.WHITE)));
        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.damage").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(new DecimalFormat("#0.0").format(damage) + " / " + MAX_DAMAGE + " (" + MAX_DAMAGE * 2 + ")")
                                .withStyle(damageProgress >= 1 ? damageProgress >= 2 ? ChatFormatting.GOLD : ChatFormatting.GREEN : ChatFormatting.GRAY))));
        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.hunger").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(hunger + " / " + MAX_HUNGER + " (" + MAX_HUNGER * 2 + ")")
                                .withStyle(hungerProgress >= 1 ? hungerProgress >= 2 ? ChatFormatting.GOLD : ChatFormatting.GREEN : ChatFormatting.GRAY))));
        TooltipTool.addCtrlHideText(pTooltipComponents,
                Component.literal(" - ").append(Component.translatable("des.dreamaticvoyage.fukamizu_edge.upgrade.task.kill_count").withStyle(ChatFormatting.WHITE)
                        .append(Component.literal("").withStyle(ChatFormatting.RESET))
                        .append(Component.literal(killCount + " / " + MAX_KILL_COUNT + " (" + MAX_KILL_COUNT * 2 + ")")
                                .withStyle(killCountProgress >= 1 ? killCountProgress >= 2 ? ChatFormatting.GOLD : ChatFormatting.GREEN : ChatFormatting.GRAY))));
    }

    /**
     * 二阶以上的锋芒通用方法
     * Living Drop codes based on Botania
     */
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity target = event.getEntity();

        if (!(target instanceof WitherSkeleton)) return;

        var source = event.getSource();
        boolean hitRecently = event.isRecentlyHit();

        LootParams.Builder ctx = (new LootParams.Builder((ServerLevel) target.level()))
                .withParameter(LootContextParams.THIS_ENTITY, target)
                .withParameter(LootContextParams.ORIGIN, target.position())
                .withParameter(LootContextParams.DAMAGE_SOURCE, source)
                .withOptionalParameter(LootContextParams.KILLER_ENTITY, source.getEntity())
                .withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, source.getDirectEntity());

        if (hitRecently && target.getKillCredit() != null && target.getKillCredit() instanceof Player player) {
            ctx = ctx.withParameter(LootContextParams.LAST_DAMAGE_PLAYER, player).withLuck(player.getLuck());
        }

        var server = target.level().getServer();
        if (server == null) return;

        server.getLootData().getLootTable(EXTRA_WITHER_SKELETON_SKULL)
                .getRandomItems(ctx.create(LootContextParamSets.ENTITY), target.getLootTableSeed(), stack -> {
                    var ent = new ItemEntity(target.level(), target.getX(), target.getY(), target.getZ(), stack);
                    ent.setDefaultPickUpDelay();
                    event.getDrops().add(ent);
                });
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        var entity = event.getEntity();
        if (entity == null) return;

        var source = event.getSource();
        if (!source.is(DamageTypes.PLAYER_ATTACK)) return;

        var sourceEntity = source.getEntity();
        if (!(sourceEntity instanceof Player player)) return;

        ItemStack stack = player.getMainHandItem();
        if (stack.is(ModTags.Items.FUKAMIZU_EDGE_WITH_EXTRA_LOOT) && player.isInWater() && entity.isInWater()) {
            stack.getOrCreateTag().putInt("KillCount", stack.getOrCreateTag().getInt("KillCount") + 1);
        }
    }

}
