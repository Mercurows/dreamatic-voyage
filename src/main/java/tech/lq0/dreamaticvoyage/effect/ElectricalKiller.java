package tech.lq0.dreamaticvoyage.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.ModTags;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ElectricalKiller extends MobEffect {

    public ElectricalKiller() {
        super(MobEffectCategory.HARMFUL, 0xF6E6D9);
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (player == null) return;

        if (!player.hasEffect(EffectRegistry.ELECTRICAL_KILLER.get())) return;

        if (event.getHitVec() == null) return;

        Level level = player.level();
        var block = level.getBlockState(event.getHitVec().getBlockPos());

        if (block.is(ModTags.Blocks.ELECTRICAL_BLOCKS)) {
            event.setCanceled(true);
        }
    }

}
