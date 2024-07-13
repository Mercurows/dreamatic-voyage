package tech.lq0.dreamaticvoyage.item.oi.rino;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosHelper;
import tech.lq0.dreamaticvoyage.init.EffectRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClarityAmulet extends Item implements ICurioItem {
    public ClarityAmulet() {
        super(new Properties().rarity(Rarity.RARE).stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.clarity_amulet").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.RINO);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!slotContext.entity().level().isClientSide) {
            if (slotContext.entity() instanceof Player player) {
                int chaos = ChaosHelper.getChaos(player);

                if (chaos <= -70) {
                    player.addEffect(new MobEffectInstance(MobEffects.LUCK, 100, 0, false, false), player);
                    player.addEffect(new MobEffectInstance(EffectRegistry.HOLINESS.get(), 100, 2, false, false), player);
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, false, false), player);
                } else if (chaos <= -30) {
                    player.addEffect(new MobEffectInstance(MobEffects.LUCK, 100, 0, false, false), player);
                    player.addEffect(new MobEffectInstance(EffectRegistry.HOLINESS.get(), 100, 1, false, false), player);
                } else if (chaos < 0) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.HOLINESS.get(), 100, 0, false, false), player);
                } else if (chaos >= 80) {
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, 0, false, false), player);
                    player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 100, 0, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0, false, false));
                }
            }
        }
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }
}
