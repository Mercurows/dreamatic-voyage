package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class HaiPlate extends ShieldItem {
    public HaiPlate() {
        super(new Properties().durability(401));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);

        if (pPlayer.isSteppingCarefully()) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 4));
            itemstack.hurtAndBreak(80, pPlayer, (playerEntity) -> playerEntity.broadcastBreakEvent(pHand));
            pPlayer.getCooldowns().addCooldown(itemstack.getItem(), 220);
            pLevel.playSound(pPlayer, pPlayer.getOnPos(), SoundRegistry.HAIPLATE.get(), SoundSource.AMBIENT, 0.5f, 1f);
        }

        return InteractionResultHolder.consume(itemstack);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.hai_plate.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.hai_plate_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.hai_plate_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.hai_plate_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HAINE);
    }
}
