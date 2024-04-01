package tech.lq0.dreamaticvoyage.item.fourth.choco;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ActivatedCream extends Item {
    public ActivatedCream() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.activated_cream_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.activated_cream_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHOCO);
    }

    @SubscribeEvent
    public static void onStruckByLightning(EntityStruckByLightningEvent event) {
        if (event.getEntity() instanceof MushroomCow cow) {
            if (cow.hasEffect(EffectRegistry.SWEET_MIRAGE.get())) {
                cow.getPersistentData().putBoolean("ActivatedCream", true);
            }
        }
    }

    @SubscribeEvent
    public static void onInteractLivingEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof MushroomCow cow && cow.getVariant() == MushroomCow.MushroomType.RED
                && event.getItemStack().getItem() == Items.BUCKET) {
            if (cow.getPersistentData().getBoolean("ActivatedCream")) {
                if (cow.hasEffect(EffectRegistry.SWEET_MIRAGE.get())) {
                    cow.removeEffect(EffectRegistry.SWEET_MIRAGE.get());
                }

                cow.getPersistentData().putBoolean("ActivatedCream", false);

                Player player = event.getEntity();
                boolean flag = player.addItem(new ItemStack(ItemRegistry.ACTIVATED_CREAM.get()));
                if (!flag) {
                    player.drop(new ItemStack(ItemRegistry.ACTIVATED_CREAM.get()), false);
                }
            }
        }
    }
}
