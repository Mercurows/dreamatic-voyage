package tech.lq0.providencraft.item.providencemagicros.ekira;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class EnchantedCrystalBall extends Item {
    public EnchantedCrystalBall() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            if (pLevel.isThundering()) {
                pPlayer.displayClientMessage(Component.translatable("des.providencraft.crystal_ball.weather_thunder").withStyle(ChatFormatting.YELLOW), true);
            } else if (pLevel.isRaining()) {
                pPlayer.displayClientMessage(Component.translatable("des.providencraft.crystal_ball.weather_rain").withStyle(ChatFormatting.AQUA), true);
            } else {
                pPlayer.displayClientMessage(Component.translatable("des.providencraft.crystal_ball.weather_clear").withStyle(ChatFormatting.GREEN), true);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.crystal_ball.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.enchanted_crystal_ball").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.EKIRA);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isClientSide && entityIn instanceof Player playerIn) {
            if (worldIn.isThundering()) {
                playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2, false, false));
                playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1, false, false));
                playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false));
            } else if (worldIn.isRaining()) {
                playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1, false, false));
                playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false));
            } else {
                playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false));
            }
        }
    }
}
