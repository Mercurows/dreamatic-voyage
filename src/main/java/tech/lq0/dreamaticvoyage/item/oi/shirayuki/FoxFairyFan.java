package tech.lq0.dreamaticvoyage.item.oi.shirayuki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class FoxFairyFan extends Item {
    public FoxFairyFan() {
        super(new Properties().durability(186));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player playerIn, InteractionHand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        List<LivingEntity> entities = pLevel.getEntitiesOfClass(LivingEntity.class, playerIn.getBoundingBox().inflate(8));
        entities.forEach(e -> {
            if (e != playerIn && !(e instanceof ArmorStand)) {
                float distance = e.distanceTo(playerIn);
                float strength = distance <= 2 ? 6 : (float) Math.sqrt(Mth.lerp((distance - 2) / 6, 6, 0));
                e.knockback(strength, playerIn.getX() - e.getX(), playerIn.getZ() - e.getZ());
                e.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 0));
            }
        });

        playerIn.getCooldowns().addCooldown(itemStack.getItem(), 20);

        itemStack.hurtAndBreak(1, playerIn, (playerEntity) -> playerEntity.broadcastBreakEvent(handIn));
        return InteractionResultHolder.success(itemStack);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fox_fairy_fan").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.AOI);
    }
}
