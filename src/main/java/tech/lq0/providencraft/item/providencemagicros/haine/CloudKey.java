package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CloudKey extends Item implements ICurioItem {
    public CloudKey() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC).durability(4));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 1, false, false));
        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 0, false, false));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.cloud_key_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.cloud_key_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HAINE);
    }

    @SubscribeEvent
    public static void cloudKeyHurtEvent(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        float damage = event.getAmount();
        if (event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return;
        }

        if (entity instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(c -> c.findFirstCurio(ItemRegistry.CLOUD_KEY.get()).ifPresent(slotResult -> {
                if (damage >= player.getHealth() && !player.getCooldowns().isOnCooldown(ItemRegistry.CLOUD_KEY.get()) && !player.level().isClientSide) {
                    event.setAmount(player.getHealth() > 2.0f ? player.getHealth() - 2.0f : 0.0f);
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 3));
                    slotResult.stack().hurtAndBreak(1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(EquipmentSlot.CHEST));
                    player.getCooldowns().addCooldown(ItemRegistry.CLOUD_KEY.get(), 100);
                }
            }));
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
