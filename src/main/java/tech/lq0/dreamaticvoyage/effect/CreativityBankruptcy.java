package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.compat.vrc.VrcHolder;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.VillagerRegistry;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CreativityBankruptcy extends MobEffect {

    public CreativityBankruptcy() {
        super(MobEffectCategory.HARMFUL, 0x87EAFF);
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();

        if (event.getTarget() instanceof Pig pig) {
            List<Villager> list = pig.level().getEntitiesOfClass(Villager.class, pig.getBoundingBox().inflate(8)).stream()
                    .filter(villager -> villager.getVillagerData().getProfession() == VillagerRegistry.ELIFAUS.get())
                    .toList();

            if (!list.isEmpty()) {
                player.addEffect(new MobEffectInstance(EffectRegistry.CREATIVITY_BANKRUPTCY.get(), 600 * list.size(), 0));
            }
        }
    }

    @SuppressWarnings("ConstantValue")
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onInteractEntity(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        Entity entity = event.getTarget();

        if (entity instanceof Villager villager && villager.getVillagerData().getProfession() == VillagerRegistry.ELIFAUS.get()) {
            List<ItemStack> stacks = player.getInventory().items.stream().filter(stack -> stack.is(TagKey.create(Registries.ITEM,
                    new ResourceLocation("virtuarealcraft", "sui")))).toList();

            int count = 0;
            for (ItemStack stack : stacks) {
                count += stack.getCount();
            }

            if (count != 0) {
                player.addEffect(new MobEffectInstance(EffectRegistry.CREATIVITY_BANKRUPTCY.get(), count * 20, 0));
            }
        }

        if (entity instanceof Pig || entity instanceof AbstractPiglin || entity instanceof Zoglin || entity instanceof Hoglin || entity instanceof ZombifiedPiglin ||
                (entity instanceof Villager villager && villager.getVillagerData().getProfession() == VillagerRegistry.ELIFAUS.get())) {
            if (VrcHolder.BUSINESS_OBSTRUCTION == null) return;

            if (player.hasEffect(EffectRegistry.CREATIVITY_BANKRUPTCY.get()) && player.hasEffect(VrcHolder.BUSINESS_OBSTRUCTION)) {
                entity.hurt(player.level().damageSources().explosion(null, null), 500f);

                Explosion explosion = new Explosion(player.level(), entity, player.level().damageSources().explosion(entity, entity),
                        null, entity.getX(), entity.getY(), entity.getZ(), 4, false, Explosion.BlockInteraction.KEEP);
                explosion.explode();
                explosion.finalizeExplosion(true);

                explosion.clearToBlow();

                for (ServerPlayer serverPlayer : ((ServerLevel) player.level()).players()) {
                    if (serverPlayer.distanceToSqr(entity.getX(), entity.getY(), entity.getZ()) < 1024) {
                        serverPlayer.connection.send(new ClientboundExplodePacket(entity.getX(), entity.getY(), entity.getZ(), 4, explosion.getToBlow(), explosion.getHitPlayers().get(serverPlayer)));
                    }
                }
            }
        }
    }

}
