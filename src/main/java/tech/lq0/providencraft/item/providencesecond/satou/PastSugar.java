package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class PastSugar extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(0.5f).build();

    public PastSugar() {
        super(new Properties().rarity(Rarity.EPIC).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.past_sugar").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SATOU);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 60;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);

        if (!pLevel.isClientSide) {
            double d0 = pEntityLiving.getX();
            double d1 = pEntityLiving.getY();
            double d2 = pEntityLiving.getZ();

            for (int i = 0; i < 16; ++i) {
                double d3 = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - 0.5D) * 16.0D;
                double d4 = Mth.clamp(pEntityLiving.getY() + (double) (pEntityLiving.getRandom().nextInt(16) - 8), pLevel.getMinBuildHeight(), pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1);
                double d5 = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - 0.5D) * 16.0D;
                if (pEntityLiving.isPassenger()) {
                    pEntityLiving.stopRiding();
                }

                Vec3 vec3 = pEntityLiving.position();
                pLevel.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(pEntityLiving));
                net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(pEntityLiving, d3, d4, d5);
                if (event.isCanceled()) {
                    return itemstack;
                }
                if (pEntityLiving.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = pEntityLiving instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                    pLevel.playSound(null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    pEntityLiving.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }

            if (pEntityLiving instanceof Player player) {
                player.getCooldowns().addCooldown(this, 60);
            }

        }

        return itemstack;
    }
}
