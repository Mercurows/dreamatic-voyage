package tech.lq0.dreamaticvoyage.item.oi.fukami;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tiers.ModItemTier;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

// TODO 完成功能
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HardEdge extends SwordItem {

    public static final ResourceLocation EXTRA_WITHER_SKELETON_SKULL = Utils.loc("special/extra_wither_skeleton_skull");

    public HardEdge() {
        super(ModItemTier.FUKAMIZU_BREAD, 4, -2.8f, new Properties().setNoRepair().rarity(Rarity.UNCOMMON).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hard_edge_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.hard_edge_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMIZU);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    // From Botania
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity target = event.getEntity();
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

}
