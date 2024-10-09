package tech.lq0.dreamaticvoyage.item.misc.fukamizutech;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import tech.lq0.dreamaticvoyage.block.entity.PylonBlockEntity;
import tech.lq0.dreamaticvoyage.capability.ModCapabilities;

public class FukamizuBreadWrench extends Item {

    public FukamizuBreadWrench() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        var pos = context.getClickedPos();
        var itemStack = context.getItemInHand();
        var player = context.getPlayer();
        var level = context.getLevel();
        var blockEntity = level.getBlockEntity(pos);

        if (blockEntity == null) return InteractionResult.FAIL;
        if (player == null) return InteractionResult.FAIL;

        if (blockEntity.getCapability(ModCapabilities.UMISU_CURRENT_ENERGY_CAPABILITY).isPresent()) {
            if (player.isShiftKeyDown()) {
                // shift右键
                if (blockEntity instanceof PylonBlockEntity) {
                    // 扳手只能绑定能量塔
                    itemStack.getOrCreateTag().putIntArray("Machine", new int[]{pos.getX(), pos.getY(), pos.getZ()});
                    player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.bound",
                            pos.getX() + ", " + pos.getY() + ", " + pos.getZ()).withStyle(ChatFormatting.GREEN), true);
                } else {
                    player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.not_pylon")
                            .withStyle(ChatFormatting.RED), true);
                    return InteractionResult.FAIL;
                }
            } else {
                // 直接右键
                if (!itemStack.hasTag() || !itemStack.getOrCreateTag().contains("Machine")) {
                    player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.not_bounded")
                            .withStyle(ChatFormatting.RED), true);
                    return InteractionResult.FAIL;
                }

                var tag = itemStack.getOrCreateTag();
                var array = tag.getIntArray("Machine");

                if (array.length != 3) {
                    player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.not_bounded")
                            .withStyle(ChatFormatting.RED), true);
                    return InteractionResult.FAIL;
                }

                // 扳手绑定的方块需要是能量塔才能进行下一步操作
                if (level.getBlockEntity(new BlockPos(array[0], array[1], array[2])) instanceof PylonBlockEntity pylonBlockEntity) {
                    byte xDiff = (byte) (pos.getX() - array[0]);
                    byte yDiff = (byte) (pos.getY() - array[1]);
                    byte zDiff = (byte) (pos.getZ() - array[2]);

                    if (xDiff == 0 && yDiff == 0 && zDiff == 0) {
                        // 不能绑定自己
                        player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.self_bound")
                                .withStyle(ChatFormatting.RED), true);
                        return InteractionResult.FAIL;
                    } else if (!pylonBlockEntity.canBind(new byte[]{xDiff, yDiff, zDiff})) {
                        // 距离限制
                        player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.too_far")
                                .withStyle(ChatFormatting.RED), true);
                        return InteractionResult.FAIL;
                    }

                    if (level.getBlockEntity(pos) instanceof PylonBlockEntity pylonBlock &&
                            pylonBlockEntity.getPylonLevel() <= pylonBlock.getPylonLevel()) {
                        // 只有高级能量塔才能绑定低级能量塔
                        player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.wrong_level", pylonBlock.getPylonLevel())
                                .withStyle(ChatFormatting.RED), true);
                        return InteractionResult.FAIL;
                    }

                    if (pylonBlockEntity.hasConnection(new byte[]{xDiff, yDiff, zDiff})) {
                        // 右键已连接方块时，移除现有连接
                        pylonBlockEntity.removeConnection(new byte[]{xDiff, yDiff, zDiff});
                        player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.disconnected")
                                .withStyle(ChatFormatting.YELLOW), true);
                    } else {
                        // 绑定数量限制
                        if (!pylonBlockEntity.canBindMore()) {
                            player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.max_count")
                                    .withStyle(ChatFormatting.RED), true);
                            return InteractionResult.FAIL;
                        }
                        // 满足条件，进行绑定
                        pylonBlockEntity.addConnection(new byte[]{xDiff, yDiff, zDiff});
                        player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.uce_bound",
                                pos.getX() + ", " + pos.getY() + ", " + pos.getZ()).withStyle(ChatFormatting.GREEN), true);
                    }
                } else {
                    player.displayClientMessage(Component.translatable("des.dreamaticvoyage.fukamizu_bread_wrench.not_pylon")
                            .withStyle(ChatFormatting.RED), true);
                }
            }

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
