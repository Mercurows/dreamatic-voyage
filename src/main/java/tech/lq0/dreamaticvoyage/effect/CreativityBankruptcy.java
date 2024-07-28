package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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

    @SubscribeEvent
    public static void onInteractVillager(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();

        if (event.getTarget() instanceof Villager villager && villager.getVillagerData().getProfession() == VillagerRegistry.ELIFAUS.get()) {
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
    }

}
