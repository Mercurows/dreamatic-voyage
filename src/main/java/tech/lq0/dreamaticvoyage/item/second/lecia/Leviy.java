package tech.lq0.dreamaticvoyage.item.second.lecia;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.network.DmvNetwork;
import tech.lq0.dreamaticvoyage.network.packet.LeviyLaunchPacket;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.RarityTool;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.function.Consumer;

public class Leviy extends Item {
    public Leviy() {
        super(new Properties().rarity(RarityTool.LEGENDARY).stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(pTooltipComponents);

        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.leviy_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.leviy_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.LECIA);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.CROSSBOW;
    }

    // start
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        var stack = pPlayer.getItemInHand(pUsedHand);

        if (pUsedHand == InteractionHand.MAIN_HAND) {
            pPlayer.startUsingItem(pUsedHand);
            return InteractionResultHolder.consume(stack);
        }
        return InteractionResultHolder.fail(stack);
    }

    // release
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            player.getCooldowns().addCooldown(this, 400);
            if (!pLevel.isClientSide) {
                return pStack;
            }

            var look = player.getLookAngle();
            int distance = 512;

            var start = player.position().add(0, player.getEyeHeight(), 0);
            var end = player.position().add(look.x * distance, look.y * distance + player.getEyeHeight(), look.z * distance);

            ClipContext context = new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player);
            BlockHitResult result = pLevel.clip(context);

            if (!result.getType().equals(HitResult.Type.MISS)) {
                BlockPos pos = result.getBlockPos();
                DmvNetwork.CHANNEL.sendToServer(new LeviyLaunchPacket(pos.getX(), pos.getY() + 1, pos.getZ()));
            } else {
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.leviy.invalid_select").withStyle(ChatFormatting.RED), true);
                player.playSound(SoundRegistry.LEVIY_FAIL.get(), 1.0f, 1.0f);
            }
        }
        return pStack;
    }


    @Override
    public int getUseDuration(ItemStack pStack) {
        return 40;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public HumanoidModel.@Nullable ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
                return HumanoidModel.ArmPose.BOW_AND_ARROW;
            }
        });
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;
    }
}
