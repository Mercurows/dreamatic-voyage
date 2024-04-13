package tech.lq0.dreamaticvoyage.item.other.fictional;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GourmetMedal extends Item implements ICurioItem {
    private static final List<MobEffect> EFFECTS = new ArrayList<>();

    static {
        EFFECTS.add(MobEffects.MOVEMENT_SLOWDOWN);
        EFFECTS.add(MobEffects.DIG_SLOWDOWN);
        EFFECTS.add(MobEffects.CONFUSION);
        EFFECTS.add(MobEffects.HUNGER);
        EFFECTS.add(MobEffects.POISON);
        EFFECTS.add(MobEffects.UNLUCK);
        EFFECTS.add(MobEffects.WITHER);
        EFFECTS.add(MobEffects.WEAKNESS);
        EFFECTS.add(MobEffects.BLINDNESS);
    }

    public static final String TAG_GOURMET_MEDAL = "GourmetMedal";

    public GourmetMedal() {
        super(new Properties().stacksTo(1).fireResistant().rarity(RarityTool.FICTIONAL));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal").withStyle(ChatFormatting.GRAY));

        float progress = ItemNBTTool.getFloat(pStack, TAG_GOURMET_MEDAL, 0f);
        if (progress >= 1f) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal.done").withStyle(ChatFormatting.LIGHT_PURPLE).withStyle(ChatFormatting.ITALIC));
        } else if (progress >= .75f) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal.almost").withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.ITALIC));
        } else if (progress >= .5f) {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal.half").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.ITALIC));
        } else {
            pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.gourmet_medal.begin").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }

        TooltipTool.addHideText(pTooltipComponents, Component.translatable("des.dreamaticvoyage.gourmet_medal.need").withStyle(ChatFormatting.GRAY)
                .append(Component.literal(String.format(" %.2f%%", progress * 100))));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide && pEntity instanceof ServerPlayer player && player.getServer() != null) {
            var advancements = player.getServer().getAdvancements();
            var adv = advancements.getAdvancement(new ResourceLocation(Utils.MOD_ID, "main/apex_gourmet"));
            if (adv != null) {
                ItemNBTTool.setFloat(pStack, TAG_GOURMET_MEDAL, player.getAdvancements().getOrStartProgress(adv).getPercent());
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        float progress = ItemNBTTool.getFloat(stack, TAG_GOURMET_MEDAL, 0f);

        for (MobEffect mobEffect : EFFECTS) {
            if (entity != null && entity.hasEffect(mobEffect)) {
                MobEffectInstance effectInstance = entity.getEffect(mobEffect);
                if (effectInstance != null) {
                    int level = effectInstance.getAmplifier();

                    if (progress >= 1f) {
                        entity.removeEffect(mobEffect);
                    } else if (progress >= 0.75f) {
                        if (level <= 1) {
                            entity.removeEffect(mobEffect);
                        }
                    } else if (progress >= 0.5f) {
                        if (level <= 0) {
                            entity.removeEffect(mobEffect);
                        }
                    }
                }
            }
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }
}
